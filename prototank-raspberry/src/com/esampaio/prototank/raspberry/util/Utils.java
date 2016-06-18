package com.esampaio.prototank.raspberry.util;

public class Utils {
	public static boolean isWindows(){
		return  System.getProperty("os.name").startsWith("windows");
	}
}
