package com.fatih.core.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class WebHelper {
	
	public static URLConnection connect(String address) throws IOException {
		URL url=new URL(address);
		URLConnection connection=url.openConnection();
		connection.setDoInput(true);
		connection.setDoOutput(true);
		return connection;
	}
	public static InputStream  get(String address) throws Exception{
		URL url=new  URL(address);
		URLConnection connection=url.openConnection();
		InputStream in=connection.getInputStream();
		return in;
		
	}
	public static String read(InputStream in) throws IOException
    {
		BufferedReader reader=new BufferedReader(new InputStreamReader(in,"UTF-8"));
		String line;
		StringBuilder builder=new StringBuilder();
		while((line=reader.readLine())!=null) {
			builder.append(line);
		}
		reader.close();
		String text =builder.toString();
		
		return text;				
	}
	
	
	

}
