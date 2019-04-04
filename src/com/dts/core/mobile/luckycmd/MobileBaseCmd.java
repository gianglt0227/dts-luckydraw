package com.dts.core.mobile.luckycmd;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.dts.core.mobile.LuckyDraw;
import com.dts.core.mobile.result.Result;
import com.google.gson.Gson;

public abstract class MobileBaseCmd {
	protected final String SIGN_KEY = "DTSKey";
	
	protected String name;
	
	protected Gson gson = new Gson();
	
	protected LuckyDraw lucky;

	public void setLucky(LuckyDraw lucky) {
		this.lucky = lucky;
	}
	
	public Result execute(HttpServletRequest req) throws Exception{
		System.out.println("URL: " + req.getRequestURL() + "?" + req.getQueryString());
		if (checkSign(req) == false)
			return new Result(100, "Unknow err");
		
		return executeCmd(req);
	}
	

	public abstract Result executeCmd(HttpServletRequest req) throws Exception;
	
	public abstract boolean checkSign(HttpServletRequest req);

	public abstract MobileBaseCmd createCmd();
	
	protected Log logger = LogFactory.getLog(this.getClass());
	
	public MobileBaseCmd() {
		super();
	}

	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public final void setName(String name) {
		this.name = name;
	}
}
