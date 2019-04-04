package com.dts.core.mobile.luckycmd;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.dts.core.mobile.entity.Guest;
import com.dts.core.mobile.result.GuestInfoResult;
import com.dts.core.mobile.result.Result;

public class GetGuestInfoCmd extends MobileBaseCmd{

	@Override
	public boolean checkSign(HttpServletRequest req) {
		return true;
	}

	@Override
	public MobileBaseCmd createCmd() {
		return new GetGuestInfoCmd();
	}

	@Override
	public Result executeCmd(HttpServletRequest req) throws Exception {
		int index = Integer.parseInt(req.getParameter("Index"));
		logger.info("GetGuestInfoCmd - index " + index);
		
		ArrayList<Guest> lstGuest = lucky.getLstGuest();
		Guest guestInfo = lstGuest.get(index);
		return new GuestInfoResult(0, "OK", guestInfo);
	}

}
