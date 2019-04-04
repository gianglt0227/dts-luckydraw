package com.dts.core.main;

import org.apache.log4j.xml.DOMConfigurator;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import com.dts.common.Config;
import com.dts.core.mobile.APIServlet;
import com.elcom.utils.DebugUtil;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DOMConfigurator.configure("config/log4j.xml");
		APIServlet api = new APIServlet();

		Config config = Config.getInstance();
		Server syncserver = new Server(config.getApiport());
		ServletContextHandler synccontext = new ServletContextHandler(0);
		synccontext.setContextPath("/");
		ServletHolder syncholder = new ServletHolder(api);
		synccontext.addServlet(syncholder, config.getApipath());
		syncserver.setHandler(synccontext);
		try {
			syncserver.start();
		} catch (Throwable e) {
			DebugUtil.printStackTrace(e);
		}
	}

}
