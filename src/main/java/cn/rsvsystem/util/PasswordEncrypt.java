package cn.rsvsystem.util;

public class PasswordEncrypt {
		private static final String SALT = "bWxkbmphdmE=";
		/** 
		 * �ṩ������ļ��ܴ������
		 * @param password
		 * @return
		 */
		public static String encryptPassword(String password) {
			return new MD5Code().getMD5ofStr(password + "({"+SALT+"})") ;
		}
}
