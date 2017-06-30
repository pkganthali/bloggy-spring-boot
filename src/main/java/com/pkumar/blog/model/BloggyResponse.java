package com.pkumar.blog.model;

public class BloggyResponse<T> {

	private T payload;
	private boolean failed = false;
	private String errorMessage;
	private String rootCause;

	public BloggyResponse(T payload) {
		this.payload = payload;
	}

	public BloggyResponse(String errorMessage, String rootCause) {
		this.errorMessage = errorMessage;
		this.failed = true;
		this.rootCause = rootCause;
	}

	/**
	 * @return the payload
	 */
	public T getPayload() {
		return payload;
	}

	/**
	 * @param payload
	 *            the payload to set
	 */
	public void setPayload(T payload) {
		this.payload = payload;
	}

	/**
	 * @return the failed
	 */
	public boolean isFailed() {
		return failed;
	}

	/**
	 * @param failed
	 *            the failed to set
	 */
	public void setFailed(boolean failed) {
		this.failed = failed;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage
	 *            the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * @return the rootCause
	 */
	public String getRootCause() {
		return rootCause;
	}

	/**
	 * @param rootCause the rootCause to set
	 */
	public void setRootCause(String rootCause) {
		this.rootCause = rootCause;
	}
	
	
}
