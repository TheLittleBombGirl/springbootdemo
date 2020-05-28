package cn.cy;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

public class MD5test {
	
	@Test
	public void md5() {
		String password = new Md5Hash("111111").toHex();
		System.err.println(password);
	}

}
