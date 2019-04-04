package com.dts.common;
import java.util.TimerTask;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;

import com.elcom.utils.DebugUtil;


public class Config {

	private static final String CORE_CONFIG = "config/config.xml";

	private static Config instance;

	private String apipath = "/api";

	private int apiport = 7788;

	private XMLConfiguration config;

	class AutoReloadTask extends TimerTask {

		@Override
		public void run() {
			loadConfig();
		}

	}

	private Config() {
		loadConfig();
	}

	private void loadConfig() {
		try {
			config = new XMLConfiguration(CORE_CONFIG);
			apipath = config.getString("core.api.path", apipath);
			apiport = config.getInt("core.api.port", apiport);
		} catch (ConfigurationException e) {
			DebugUtil.printStackTrace(e);
		}
		
	}

	public static synchronized Config getInstance() {
		if (instance == null)
			instance = new Config();

		return instance;
	}

	/**
	 * @return the apipath
	 */
	public final String getApipath() {
		return apipath;
	}

	/**
	 * @return the apiport
	 */
	public final int getApiport() {
		return apiport;
	}
}
