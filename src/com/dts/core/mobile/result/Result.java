package com.dts.core.mobile.result;

public class Result {
	private int Result;
	
	private String Message;

	public int getResult() {
		return Result;
	}

	public void setResult(int result) {
		Result = result;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public Result(int result, String message) {
		super();
		Result = result;
		Message = message;
	}

	public Result() {
		super();
	}
}
