package com.netBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readConfig {

	Properties pro;
	public readConfig() {
		File src= new File("./Configuration/config.properties");
		try {
			FileInputStream fi = new FileInputStream(src);
			pro= new Properties();
			pro.load(fi);
			
		}
		catch(Exception e) {
			System.out.println("Exception is : "+e.getMessage());
			
		}
	}
	
	public String getApplicationURL() {
		String url= pro.getProperty("baseURL");
		return url;
	}
	
	public String getUsername() {
		String username= pro.getProperty("username");
		return username;
	}
	
	
	public String getPassword() {
		String password= pro.getProperty("password");
		return password;
	}
	
	public String getName() {
		String Name= pro.getProperty("Name");
		return Name;
	}
	
	public String getDob() {
		String Dob= pro.getProperty("Dob");
		return Dob;
	}
	
	public String getAddress() {
		String Address= pro.getProperty("Address");
		return Address;
	}
	public String getCity() {
		String City= pro.getProperty("City");
		return City;
	}
	public String getState() {
		String State= pro.getProperty("State");
		return State;
	}
	public String getEmail() {
		String Email= pro.getProperty("Email");
		return Email;
	}
}
