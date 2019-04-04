package com.dts.core.mobile.luckycmd;

import javax.servlet.http.HttpServletRequest;

import com.dts.core.mobile.result.Result;

public class ResetAllCmd extends MobileBaseCmd{

	@Override
	public boolean checkSign(HttpServletRequest req) {
		return true;
	}

	@Override
	public MobileBaseCmd createCmd() {
		return new ResetAllCmd();
	}

	@Override
	public Result executeCmd(HttpServletRequest req) throws Exception {
		logger.info("ResetAllCmd");
		lucky.resetAll();
		
		return new Result(0, "OK");
	}

}
