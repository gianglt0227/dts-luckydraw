package com.dts.core.mobile.luckycmd;

import javax.servlet.http.HttpServletRequest;

import com.dts.core.mobile.result.Result;

public class CancelGuestResultCmd extends MobileBaseCmd{

	@Override
	public boolean checkSign(HttpServletRequest req) {
		return true;
	}

	@Override
	public MobileBaseCmd createCmd() {
		return new CancelGuestResultCmd();
	}

	@Override
	public Result executeCmd(HttpServletRequest req) throws Exception {
		int index = Integer.parseInt(req.getParameter("Index"));
		logger.info("CancelGuestResultCmd - index " + index);
		
		lucky.cancelLuckyResult(index);
		return new Result(0, "OK");
	}

}
