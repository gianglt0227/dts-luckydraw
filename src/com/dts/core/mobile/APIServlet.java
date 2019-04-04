package com.dts.core.mobile;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.dts.common.ResultCode;
import com.dts.core.mobile.luckycmd.CancelGuestResultCmd;
import com.dts.core.mobile.luckycmd.GetGuestInfoCmd;
import com.dts.core.mobile.luckycmd.GetListGuestCmd;
import com.dts.core.mobile.luckycmd.GetLuckyGuestCmd;
import com.dts.core.mobile.luckycmd.MobileBaseCmd;
import com.dts.core.mobile.luckycmd.ResetAllCmd;
import com.dts.core.mobile.result.Result;
import com.elcom.utils.DebugUtil;
import com.google.gson.Gson;
//import com.google.gson.Gson;


public class APIServlet extends HttpServlet{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1848555498981334530L;
	
	private Log logger = LogFactory.getLog(this.getClass());
	
	private CmdFactory factory = new CmdFactory();
	
	private LuckyDraw lucky = new LuckyDraw();
	
	public APIServlet()
	{
		factory.addCmd("GetListGuest", new GetListGuestCmd());
		factory.addCmd("GetLuckyGuest", new GetLuckyGuestCmd());
		factory.addCmd("CancelGuestResult", new CancelGuestResultCmd());
		factory.addCmd("ResetAll", new ResetAllCmd());
		factory.addCmd("GetGuestInfo", new GetGuestInfoCmd());
	}
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String cmdname = req.getParameter("ApiName");
		MobileBaseCmd cmd = null;
		
		if (cmdname == null || cmdname.length() == 0)
		{
			logger.error("Command name not found, return error");
			sendResponse(resp, new Result(ResultCode.DTS_RESULT_CODE_INVALID_COMMAND_NAME, "Command name not found"));
			return;
			//cmd = new GetOTPCmd();
		}
		else	
			cmd = factory.getCmd(cmdname);
		
		if (cmd == null)
		{
			logger.error(String.format("Command %s not found, return error", cmdname));
			sendResponse(resp, new Result(ResultCode.DTS_RESULT_CODE_INVALID_COMMAND_NAME, String.format("Command %s invalid", cmdname)));
			return;
		}

		try {
			logger.debug(String.format("Process cmd %s", cmdname));
			cmd.setLucky(lucky);
			Result result = cmd.execute(req);
			sendResponse(resp, result);
		} catch (Exception e) {
			DebugUtil.printStackTrace(e);
			sendResponse(resp, new Result(ResultCode.DTS_RESULT_CODE_SYSTEM_ERR, "Unkonw err"));
		}
		
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

	private void sendResponse(HttpServletResponse resp, Object result) throws IOException
	{
		resp.setContentType("text/html;charset=utf-8");
        resp.setStatus(200);
        Gson gson = new Gson();
        resp.getWriter().println(gson.toJson(result));
	}
}
