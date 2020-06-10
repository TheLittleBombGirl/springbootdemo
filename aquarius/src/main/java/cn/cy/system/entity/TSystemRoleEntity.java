package cn.cy.system.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("t_system_role")
public class TSystemRoleEntity {
	@TableId
	private String ListId;
	private String roleName;
	private String roleParentId;
	private String remark;
	private String isDelete;
	public String getListId() {
		return ListId;
	}
	public void setListId(String listId) {
		ListId = listId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleParentId() {
		return roleParentId;
	}
	public void setRoleParentId(String roleParentId) {
		this.roleParentId = roleParentId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	
	

}
