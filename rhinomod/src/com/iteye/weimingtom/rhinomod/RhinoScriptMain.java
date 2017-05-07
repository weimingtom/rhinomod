package com.iteye.weimingtom.rhinomod;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.RhinoException;
import org.mozilla.javascript.ScriptableObject;

public class RhinoScriptMain {
    public final static void main(String[] args) {
        String scripts = GlobalScriptUtil.getString("app.js");
        System.out.println("script==>");
        System.out.println(scripts);
        System.out.println("script<==END");
        
        //run js
        runJavaScript(scripts);
    }
    
	public static void runJavaScript(String script) {
		Context context = Context.enter();
		context.setOptimizationLevel(-1);
		UtilsForRhino utils = new UtilsForRhino();
		String resultString;
		try {
			ScriptableObject scope = context.initStandardObjects();
			try {
				// set Function
				scope.defineFunctionProperties(UtilsForRhino.API, UtilsForRhino.class, ScriptableObject.DONTENUM);

				// set Object
				Object wrapped = Context.javaToJS(utils, scope);
				ScriptableObject.putProperty(scope, "UtilsForRhino", wrapped);

				// run
				Object result = context.evaluateString(scope, script,
						"<cmd>", 1, null);
				resultString = Context.toString(result);
			} catch (RhinoException jse) {
				jse.printStackTrace();
				resultString = jse.getMessage();
			}
		} finally {
			Context.exit();
		}
		if (resultString != null) {
			CoreAPI.log("resultString:" + resultString);
		}
	}
}
