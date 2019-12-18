package de.mctzcok.screentime;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ScreenTimePsswd {
	
	public static void setPassword(String password)
	{
		File f = new File("database/db.bin");
		try {
			FileWriter writer = new FileWriter(f);
			f.delete();
			f.createNewFile();
			writer.write(password);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String getPassword()
	{
		String st = "";
		String str = "";
		File f = new File("database/db.bin");
		try {
			Scanner s = new Scanner(f);
			while(s.hasNextLine())
			{
				str = s.nextLine();
			}
			st = Compiler.decompile(str, "Löwe.Kappe.Turnschuhe.Schwarz");
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Error! Error-Code: 0x000001 (FileNotFound)");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;
	}
}
