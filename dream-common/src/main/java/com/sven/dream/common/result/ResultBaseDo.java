package com.sven.dream.common.result; 

/**
 * 泛型包装输出对象 
 *
 * @param <T>
 */
public class ResultBaseDo<T> {
	public ResultBaseDo() {
	}

	public ResultBaseDo(T module) {
		this.module = module;
	}

	private boolean success = true; // 执行是否成功 

	private T module; // 实际的返回结果 
	
	private String errorMessages;

	public T getModule() {
		return module;
	}  
 
	public void setModule(T module) {
		this.module = module;
	}

	public boolean isSuccess() {
		return success;
	}

	public boolean isFailure() {
		return !success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(String errorMessages) {
		this.errorMessages = errorMessages;
	}   
}
