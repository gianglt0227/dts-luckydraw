package com.dts.core.mobile.luckycmd;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.dts.core.mobile.entity.Guest;
import com.dts.core.mobile.entity.GuestInfo;
import com.dts.core.mobile.result.ListGuestResult;
import com.dts.core.mobile.result.Result;

public class GetListGuestCmd extends MobileBaseCmd{

	@Override
	public boolean checkSign(HttpServletRequest req) {
		return true;
	}

	@Override
	public MobileBaseCmd createCmd() {
		return new GetListGuestCmd();
	}

	@Override
	public Result executeCmd(HttpServletRequest req) throws Exception {
		logger.info("GetListGuestCmd");
		//reset list trung thuong
		lucky.resetAll();
		ArrayList<Guest> lstGuest = lucky.getLstGuest();
		ArrayList<GuestInfo> ListGuestInfo = new ArrayList<GuestInfo>();
		
		for (int i=0; i<lstGuest.size(); i++){
			ListGuestInfo.add(new GuestInfo(lstGuest.get(i)));
		}
		
		return new ListGuestResult(0, "OK", ListGuestInfo);
	}

}
