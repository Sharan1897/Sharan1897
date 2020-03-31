package com.NewV1.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	public ReadConfig()
	{
		File src = new File("F:\\Eclipse_workplace\\NewV1\\Configurations\\config.properties");
		try
		{
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}
		catch(Exception e)
		{
			String Exception;
			System.out.println("Exception is "+e.getMessage());
		}
	}
	
	    public String getApplicationURL() 
	    {
		String URL = pro.getProperty("baseURL");
		return URL;
	    }
	    
	    public String getEmail() 
	    {
		String Email = pro.getProperty("email");
		return Email;
	    }
	    
	    public String getPassword() 
	    {
		String Password = pro.getProperty("password");
		return Password;
	    }
	    
	    public String getChromePath() 
	    {
		String chromepath = pro.getProperty("ChromePath");
		return chromepath;
	    }
}

