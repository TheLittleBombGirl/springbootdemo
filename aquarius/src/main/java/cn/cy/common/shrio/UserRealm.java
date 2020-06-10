package cn.cy.common.shrio;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.cy.system.dao.ISystemMenuDao;
import cn.cy.system.dao.ISystemUserDao;
import cn.cy.system.entity.TSystemMenuEntity;
import cn.cy.system.entity.TSystemUserEntity;

/**
 * 认证
 * 
 */
@Component
public class UserRealm extends AuthorizingRealm {

	Logger logger = Logger.getLogger(UserRealm.class);

	@Autowired
	private ISystemUserDao iSystemUserDao;
	@Autowired
	private ISystemMenuDao iSystemMenuDao;

	/**
	 * 权限认证，即登录过后，每个身份不一定，对应的所能看的页面也不一样。
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		logger.info("执行Shiro权限认证");

		TSystemUserEntity user = (TSystemUserEntity) principals.getPrimaryPrincipal();
		List<String> permsList = null;
		// 系统管理员，拥有最高权限
		if ("super".equals(user.getUsername())) {
			List<TSystemMenuEntity> menuList = iSystemMenuDao.selectList(null);
			permsList = new ArrayList<>(menuList.size());
			for (TSystemMenuEntity menu : menuList) {
				permsList.add(menu.getPermission());
			}
		}
		// 用户权限列表
		Set<String> permsSet = new HashSet<>();
		for (String perms : permsList) {
			if (StringUtils.isBlank(perms)) {
				continue;
			}
			permsSet.addAll(Arrays.asList(perms.trim().split(",")));
		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setStringPermissions(permsSet);
		return info;
	}

	/**
	 * 身份认证。即登录通过账号和密码验证登陆人的身份信息。
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;

		// 查询用户信息
		TSystemUserEntity user = new TSystemUserEntity();
		user.setUsername(token.getUsername());
		user = iSystemUserDao.selectOne(user);

		// 账号不存在
		if (user == null) {
			throw new UnknownAccountException("账号或密码不正确");
		}


		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), getName());
		return info;
	}

	@Override
	public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
		HashedCredentialsMatcher shaCredentialsMatcher = new HashedCredentialsMatcher();
		shaCredentialsMatcher.setHashAlgorithmName(Md5Hash.ALGORITHM_NAME);
		// 告诉realm,使用credentialsMatcher加密算法类来验证密文
		super.setCredentialsMatcher(shaCredentialsMatcher);
	}
}
