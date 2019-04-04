package com.dts.core.mobile.luckycmd;

import javax.servlet.http.HttpServletRequest;

import com.dts.core.mobile.entity.Guest;
import com.dts.core.mobile.result.LuckyDrawResult;
import com.dts.core.mobile.result.Result;

public class GetLuckyGuestCmd extends MobileBaseCmd{

	@Override
	public boolean checkSign(HttpServletRequest req) {
		return true;
	}

	@Override
	public MobileBaseCmd createCmd() {
		return new GetLuckyGuestCmd();
	}

	@Override
	public Result executeCmd(HttpServletRequest req) throws Exception {
		int prize = Integer.parseInt(req.getParameter("Prize"));
		logger.info("GetLuckyGuestCmd - prize " + prize);
		
		Guest luckyGuest = lucky.rotateLuckyDraw(prize);
		logger.info("GetLuckyGuestCmd - prize " + prize + ", result " + luckyGuest);
		return new LuckyDrawResult(0, "OK", luckyGuest.getIndex(), luckyGuest.getName());
	}

}
