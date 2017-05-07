package com.iteye.weimingtom.rhinomod;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 核心API，由JavaScript脚本调用
 * 
 */
public class CoreAPI {
	protected final static boolean D = true;
	private final static String TAG = "CoreAPI";
	
	public static void log(String msg) {
		System.out.println("[" + TAG + "] ===========>" + msg);
	}
	
    public static void toast(String msg) {
    	log("[toast]" + msg);
    }
    
    public static void print(String msg) {
    	log("[print]" + msg);
    	if (msg != null) {
    		log(msg);
    	}
    }
    
    public static void sleep(double n) {
    	log("[sleep]" + n);
    	try {
			Thread.sleep((long)n);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    
    public static boolean mkdir(String path) {
        File file = new File(path);
        if (file.exists() || file.mkdirs()) {
            return true;
        }
        log("mkdir failed");
        return false;
    }
    
    public static boolean exec(String commandStr) {
    	boolean success = false;
        Process process;
        DataOutputStream os;
    	try {
            process = Runtime.getRuntime().exec("cmd");
            try {
                os = new DataOutputStream(process.getOutputStream());
                BufferedReader r = new BufferedReader(new InputStreamReader(process.getInputStream()));
                os.writeBytes(commandStr + " \n");
                os.writeBytes("exit\n");
                os.flush();
                os.close();
                StringBuilder total = new StringBuilder();
                while (true) {
                    String line = r.readLine();
                    if (line == null) {
                        break;
                    }
                    total.append(line);
                }
                process.waitFor();
                success = true;
            } catch (InterruptedException e2) {
                return success;
            }
        } catch (Exception e3) {
            e3.printStackTrace();
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e1) {
//                e1.printStackTrace();
//            }
        }
    	return success;
    }
}
