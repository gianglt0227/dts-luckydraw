package com.dts.core.mobile.result;

import java.util.ArrayList;

import com.dts.core.mobile.entity.GuestInfo;

public class ListGuestResult extends Result{
	private ArrayList<GuestInfo> ListGuest = new ArrayList<GuestInfo>();

	public ArrayList<GuestInfo> getListGuest() {
		return ListGuest;
	}

	public void setListGuest(ArrayList<GuestInfo> listGuest) {
		ListGuest = listGuest;
	}

	public ListGuestResult(int result, String message,
			ArrayList<GuestInfo> listGuest) {
		super(result, message);
		ListGuest = listGuest;
	}
}
