/**
 * @Version 1.0.0
 * Copyright (c) 2018上海相诚金融-版权所有
 */
package cc.cc.javaScript;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * @Class JavaScriptTest
 * @Description
 * @Author 张超超
 * @Date 2018/10/18 10:41
 */
public class JavaScriptTest {

    public static void main(String[] args) throws Exception{
        JavaScriptTest test = new JavaScriptTest();
        test.test1();
    }

    private void test1() throws Exception{
        String script = "var fun1 = function(name) {\n" +
                "    print('Hi there from Javascript, ' + name);\n" +
                "    return \"greetings from javascript\";\n" +
                "};\n" +
                "\n" +
                "var fun2 = function (object) {\n" +
                "    print(\"JS Class Definition: \" + Object.prototype.toString.call(object));\n" +
                "};";

        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        scriptEngineManager.getEngineFactories().stream().forEach(f -> {
            System.out.println(f.getEngineName() + " | " + f.getLanguageName() + " | " + f.getLanguageVersion()
                    + " | " + f.getEngineVersion() + " | " + f.getNames());
            System.out.println("----------------");
        });
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("nashorn");
        scriptEngine.eval(script);

        Invocable invocable = (Invocable) scriptEngine;

        Object result = invocable.invokeFunction("fun1", "Peter Parker");
        System.out.println(result);
        System.out.println(result.getClass());
    }
}
