package com.fatih.core.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class StreamUtilities {
	
	
	public static String post(String address ,String output)
			throws MalformedURLException, IOException, UnsupportedEncodingException, Exception {
		URL url=new URL(address);
		
		URLConnection connection=url.openConnection();
		connection.setDoInput(true);
		connection.setDoOutput(true);
		

		StreamUtilities.write(connection.getOutputStream(),output);
		
		String input=WebHelper.read(connection.getInputStream());
		return input;
	}
	public static void write(OutputStream out,String result) throws UnsupportedEncodingException, IOException{
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(out));
		writer.write(result);
		writer.flush();
		writer.close();
		out.flush();
		out.close();
	}
	
	

}
