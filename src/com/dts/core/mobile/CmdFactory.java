package com.dts.core.mobile;

import java.util.HashMap;

import com.dts.core.mobile.luckycmd.MobileBaseCmd;


public class CmdFactory {
	private HashMap<String, MobileBaseCmd> listcmd = new HashMap<String, MobileBaseCmd>();
	
	public CmdFactory()
	{
		
	}
	
	public MobileBaseCmd getCmd(String cmdname)
	{
		MobileBaseCmd cmd = listcmd.get(cmdname);
		if (cmd != null)
			return cmd.createCmd();
		else
			return null;
	}
	
	public void addCmd(String cmdname, MobileBaseCmd cmd)
	{
		listcmd.put(cmdname, cmd);
	}
}
