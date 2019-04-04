package com.dts.core.mobile.result;

import com.dts.core.mobile.entity.Guest;

public class GuestInfoResult extends Result{
	private Guest GuestInfo;

	public Guest getGuestInfo() {
		return GuestInfo;
	}

	public void setGuestInfo(Guest guestInfo) {
		GuestInfo = guestInfo;
	}

	public GuestInfoResult(int result, String message, Guest guestInfo) {
		super(result, message);
		GuestInfo = guestInfo;
	}

}
