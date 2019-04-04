package com.dts.core.mobile.entity;

public class GuestInfo {
	private int index;
	private String name;
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
	public GuestInfo() {
		super();
	}
	public GuestInfo(Guest guest){
		this.index = guest.getIndex();
		this.name = guest.getName();
	}
}
