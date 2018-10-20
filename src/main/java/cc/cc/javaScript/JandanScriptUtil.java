/**
 * @Version 1.0.0
 * Copyright (c) 2018上海相诚金融-版权所有
 */
package cc.cc.javaScript;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileReader;

/**
 * @Class JandanScriptUtil
 * @Description
 * @Author 张超超
 * @Date 2018/10/20 13:53
 */
public class JandanScriptUtil {
    public static String decrypt(String s) throws Exception{
        String key = "lPTo3aD0mFBhNjeNWgaSlMNkoygcKjX6";

        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String js_wh = path + "jandan_decrypt.js";

        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("nashorn");
        scriptEngine.eval(new FileReader(js_wh));

        Invocable invocable = (Invocable) scriptEngine;

        Object result = invocable.invokeFunction("getUrl", s, key);
        System.out.println(result);
        return String.valueOf(result);
    }
}
