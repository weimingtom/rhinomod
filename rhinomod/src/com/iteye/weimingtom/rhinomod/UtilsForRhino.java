package com.iteye.weimingtom.rhinomod;


public class UtilsForRhino {
	public final static String[] API = new String[]{
		"toast",
		"print",
		"sleep",
		"mkdir",
		"exec",
	};
	
    public static void toast(String msg) {
    	CoreAPI.toast(msg);
    }
    
    public static void print(String msg) {
    	CoreAPI.print(msg);
    }
    
    public static void sleep(double n) {
    	CoreAPI.sleep(n);
    }
    
    public static boolean mkdir(String path) {
    	return CoreAPI.mkdir(path);
    }
    
    public static boolean exec(String commandStr) {
    	return CoreAPI.exec(commandStr);
    }
}
