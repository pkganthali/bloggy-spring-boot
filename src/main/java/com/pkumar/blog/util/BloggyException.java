package com.pkumar.blog.util;

public class BloggyException extends Exception {

	private static final long serialVersionUID = 1L;
	private String rootCause;

	public BloggyException(String msg, Throwable cause) {
		super(msg, cause);
		this.rootCause = cause.getClass().getSimpleName() + ":" + cause.getMessage();
	}

	public BloggyException(String msg) {
		super(msg);
	}

	public BloggyException(Throwable cause) {
		super(cause);
		this.rootCause = cause.getClass().getSimpleName() + ":" + cause.getMessage();
	}

	public static void throwIt(String msg) throws BloggyException {
		throw new BloggyException(msg);
	}

	public static void wrapAndThrowIt(String msg, Throwable t) throws BloggyException {
		if (t instanceof BloggyException) {
			throw (BloggyException) t;
		} else {
			throw new BloggyException(msg, t);
		}
	}

	/**
	 * @return the rootCause
	 */
	public String getRootCause() {
		return rootCause;
	}

	/**
	 * @param rootCause
	 *            the rootCause to set
	 */
	public void setRootCause(String rootCause) {
		this.rootCause = rootCause;
	}
	
	public static void main(String[] args) {
		Integer.parseInt(null);
	}
}
