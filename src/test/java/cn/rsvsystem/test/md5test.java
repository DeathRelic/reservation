package cn.rsvsystem.test;

import org.junit.Test;

import cn.rsvsystem.util.PasswordEncrypt;

public class md5test {
	@Test
	public void test() {
		String password = "111111";
		String newPwd = PasswordEncrypt.encryptPassword(password);
		System.out.println(newPwd);
	}
}
