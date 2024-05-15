package com.java.ECom.util;

import java.util.ResourceBundle;

public class DBPropertyUtil {

	public static String getConnectionString(String propertyFile) {
		ResourceBundle rb = ResourceBundle.getBundle(propertyFile);
		return rb.getString("url");
	}
}
