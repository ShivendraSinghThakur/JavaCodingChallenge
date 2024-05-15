package com.java.ECom.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptPassword {

	public static String getCode(String password) {
		
		String encryptedpassword = null;  
		
		try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			
			 m.update(password.getBytes()); 
			 
			 byte[] bytes = m.digest(); 
			 
			 StringBuilder s = new StringBuilder();  
	            for(int i=0; i< bytes.length ;i++)  
	            {  
	                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));  
	            }  
	            
	            encryptedpassword = s.toString();    
		} 
		catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		System.out.println("Plain-text password: " + password);  
        System.out.println("Encrypted password using MD5: " + encryptedpassword);  
        return encryptedpassword;
	}
}
