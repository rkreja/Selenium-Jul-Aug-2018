package net.timeandtraining.framework;

import java.io.IOException;

import sun.misc.BASE64Decoder;

public class OurUtil {
	
	public static String decodePassword(String str) {
		String mypwd=null;
		try {
			mypwd=new String(new BASE64Decoder().decodeBuffer(str));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return mypwd;
	}
	

}
