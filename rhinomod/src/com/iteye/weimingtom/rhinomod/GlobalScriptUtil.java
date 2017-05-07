package com.iteye.weimingtom.rhinomod;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class GlobalScriptUtil {
    public static String getString(String name) {
    	InputStream inputStr = null;
		try {
			inputStr = new FileInputStream(name);
	    	return convertStreamToString(inputStr, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
    }
    
    public static String convertStreamToString(InputStream is, String charset) {
    	StringBuilder sb = new StringBuilder();
		if (is != null) {
			try {
				ByteArrayOutputStream ots = new ByteArrayOutputStream();
				byte[] data = new byte[4096];
				int count = -1;
				while ((count = is.read(data)) != -1) {
					ots.write(data, 0, count);
				}
				byte[] bytes = ots.toByteArray();
				sb.append(new String(bytes, "UTF-8"));
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
					try {
						is.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
    	}
		return sb.toString();
	}
}
