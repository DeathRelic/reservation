package cn.rsvsystem.shiro.realm.crematcher;


import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

import cn.rsvsystem.util.PasswordEncrypt;

public class LoginCredentialsMatcher extends SimpleCredentialsMatcher{
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		Object tokenCredentials = PasswordEncrypt.encryptPassword(super.toString(token.getCredentials()));
		Object accountCredentials = info.getCredentials();
		return super.equals(tokenCredentials, accountCredentials);
	}

}
