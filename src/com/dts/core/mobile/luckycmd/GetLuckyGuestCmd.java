package com.dts.core.mobile.luckycmd;

import javax.servlet.http.HttpServletRequest;

import com.dts.common.ResultCode;
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
		
		if (luckyGuest == null)
			return new Result(ResultCode.DTS_RESULT_CODE_INVALID_COMMAND_CONTENT, "Can get lucky guest");
		else
			return new LuckyDrawResult(0, "OK", luckyGuest.getIndex(), luckyGuest.getName());
	}

}
