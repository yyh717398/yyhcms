package com.yyh.cms.util;

import org.apache.commons.codec.digest.DigestUtils;
/**
 * 
 * @ClassName: Md5Util 
 * @Description: Md5加密工具类
 * @author: dell
 * @date: 2020年5月9日 下午1:58:04
 */

public class Md5Util {
	
	/**
	 * 
	 * 直接对密码进行散列，name黑客可以通过这个密码散列值
	 * 然后通过查散列字典(MD5密码破解网站),得到用户密码
	 * 加Salt可以一定程度上解决这个问题
	 */
	private static String salt="qazwsx123";
	public static String endcode(String password){
		
		return DigestUtils.md5Hex(password+salt);
	}
	
	public static void main(String[] args) {
		System.out.println(Md5Util.endcode("111111"));
	}
}
