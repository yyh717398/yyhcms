package com.yyh.cms.util;

/**
 * 
 * @ClassName: CMSException
 * @Description: cms异常
 * @author: dell
 * @date: 2020年5月8日 下午8:48:20
 */
public class CMSException extends RuntimeException {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;

	private String message;

	public CMSException() {
		super();

	}

	public CMSException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
