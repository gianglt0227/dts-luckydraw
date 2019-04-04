package com.dts.core.mobile.entity;

public class Guest {
	@Override
	public String toString() {
		return "Guest [index=" + index + ", name=" + name
				+ ", wonprize=" + wonprize + "]";
	}
	private int index;
	private String name;
	private int wonprize;
	public Guest() {
		super();
	}
	public Guest(int index, String name, int wonprize) {
		super();
		this.index = index;
		this.name = name;
		this.wonprize = wonprize;
	}
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
	public int getWonprize() {
		return wonprize;
	}
	public void setWonprize(int wonprize) {
		this.wonprize = wonprize;
	}
}
