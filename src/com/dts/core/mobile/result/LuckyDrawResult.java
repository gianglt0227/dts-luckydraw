package com.dts.core.mobile.result;


public class LuckyDrawResult extends Result{
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LuckyDrawResult(int result, String message) {
		super(result, message);
	}
	public LuckyDrawResult(int result, String message, int index, String name) {
		super(result, message);
		this.index = index;
		this.name = name;
	}
	private int index;
	private String name;
}
