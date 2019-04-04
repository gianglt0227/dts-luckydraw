package com.dts.core.mobile;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.dts.core.mobile.entity.Guest;
import com.elcom.utils.DebugUtil;

public class LuckyDraw {
	public static final int NONE_PRIZE = -1;
	public static final int FIRST_PRIZE = 1;
	public static final int SECOND_PRIZE = 2;
	public static final int LAST_PRIZE = 3;
	
	private ArrayList<Guest> lstGuest = new ArrayList<Guest>();
	private Log logger = LogFactory.getLog(this.getClass());
	
	public LuckyDraw(){
		try {
			loadGuestList();
		} catch (IOException e) {
			DebugUtil.printStackTrace(e);
		}
	}

	
	private void loadGuestList() throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("Guest.csv"), "UTF8"));
		String line = reader.readLine();
		int index = 0;
		while (line != null){			
			Guest guest = new Guest(index, line.trim(), NONE_PRIZE);
			logger.info(guest);
			lstGuest.add(guest);
			
			line = reader.readLine();
			index++;
		}
	}
	
	public Guest rotateLuckyDraw(int prize){
		Random rand = new Random();
		ArrayList<Guest> lstRandom = new ArrayList<Guest>();			
		
		for (int i=0; i<lstGuest.size(); i++){
			Guest guest = lstGuest.get(i);
			if (guest.getWonprize() == NONE_PRIZE)
				lstRandom.add(guest);
		}
		
		if (lstRandom.size() > 0)
		{
			Guest luckGuest = lstRandom.get(rand.nextInt(lstRandom.size()));
			luckGuest.setWonprize(prize);
			
			return luckGuest;
		}
		
		return null;
	}
	
	public void cancelLuckyResult(int index){
		Guest guest = lstGuest.get(index);
		guest.setWonprize(NONE_PRIZE);
	}
	
	public void resetAll(){
		for (int i=0; i<lstGuest.size(); i++)
			lstGuest.get(i).setWonprize(NONE_PRIZE);
	}

	public ArrayList<Guest> getLstGuest() {
		return lstGuest;
	}
}
