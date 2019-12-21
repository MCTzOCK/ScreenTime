package de.mctzcok.screentime;

import java.io.File;
import java.io.IOException;

public class ScreenTime {
	
	public static long startTime = System.currentTimeMillis();
	
	public static void main(String[] args) 
	{
		File f = new File("database/db.bin");
		if(!f.exists())
		{
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ScreenTimeUI.init();
	}
}