package cc.cc.javassist;

import com.sun.tools.attach.VirtualMachine;
import javassist.*;
import javassist.bytecode.*;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * @author zhangchaochao
 * @version 1.0
 * @date 2021-12-08 11:02
 */
public class MyJavassistDemo {
    public static void main(String[] args) throws IOException, CannotCompileException, NotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, InvocationTargetException {

//        test001();
//        test002();
//        test003();
//        test004();
//        test005();
        test006();
    }

    public static void test006() {
        try {
            String pid = "9908";
            VirtualMachine vm = VirtualMachine.attach(pid);
            vm.loadAgent("E:/workspace/idea/my/MyInstrumentation/target/my-instrumentation-jar-with-dependencies.jar");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("结束");
    }

    public static void test005() {
        try {
            //创建
//            ClassPool classPool = ClassPool.getDefault();
//            CtClass ctClass = classPool.makeClass("cc.cc.javassist.ClassDemo2");
//
//            CtMethod ctMethod = new CtMethod(CtClass.intType, "strToInt", new CtClass[]{classPool.getCtClass(String.class.getName()), classPool.getCtClass(String.class.getName())}, ctClass);
//            ctMethod.setModifiers(Modifier.PUBLIC);
//            ctMethod.setBody("{return java.lang.Integer.parseInt($1);}");
//            ctClass.addMethod(ctMethod);
//            ctClass.writeFile("D:/javassist/test005/");
//
//            Class cls = ctClass.toClass();
//            Object instance = cls.newInstance();
//            Method method = cls.getDeclaredMethod("strToInt", String.class, String.class);
//            Object result = method.invoke(instance, "10", "");
//
//
//            System.out.println("执行结果为 --> " + result);
//            System.out.println("-----结束--------");

            //添加监控
//            监控 - Begin
//            方法：org.itstack.demo.javassist.ApiTest.strToInt
//            入参：["str01","str02"] 入参[类型]：["java.lang.String","java.lang.String"] 入数[值]：["1","2"]
//            出参：java.lang.Integer 出参[值]：1
//            耗时：59(s)
//            监控 - End

            String filePath = "D:\\javassist\\test005\\cc\\cc\\javassist\\ClassDemo2.class";
            ClassPool classPool = ClassPool.getDefault();
            CtClass ctClass = classPool.makeClass(new BufferedInputStream(new FileInputStream(filePath)));

            for (CtMethod ctMethod : ctClass.getDeclaredMethods()) {
                if ("strToInt".equalsIgnoreCase(ctMethod.getName())) {
                    ctMethod.addLocalVariable("startTime", CtClass.longType);
                    ctMethod.insertBefore("startTime = System.currentTimeMillis();");

                    ctMethod.addLocalVariable("endTime", CtClass.longType);
                    ctMethod.insertAfter("endTime = System.currentTimeMillis();");

                    ctMethod.insertAfter("{System.out.println(\"耗时：\" + (endTime - startTime) + \"(s) | startTime: \" + startTime + \" | endTime:\" + endTime);}");

                    ctMethod.insertBefore("{System.out.println(\"监控 - Begin\");}");
                    String methodContent = "{System.out.println(\"方法："+ ctMethod.getLongName() + "\");}";
                    ctMethod.insertBefore(methodContent);
                    String paramsContent = "{System.out.println(\"入参：[str01,str02] 入参[类型]：" + ctMethod.getParameterTypes() + "入数[值]：[\"+$1+\",\" + $2 + \"]\");}";
                    ctMethod.insertBefore(paramsContent);
                    ctMethod.insertBefore("{System.out.println(\"出参 - End\");}");

                    ctMethod.insertAfter("{System.out.println(\"出参：java.lang.Integer 出参[值]：1\");}");
                    ctMethod.insertAfter("{System.out.println(\"监控 - End\");}");
                }
            }

            Class cls = ctClass.toClass();
            Object instance = cls.newInstance();
            Method method = cls.getDeclaredMethod("strToInt", String.class, String.class);
            Object result = method.invoke(instance, "10", "1");


            System.out.println("执行结果为 --> " + result);
            System.out.println("-----结束--------");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test004() {
        try {
            String filePath = "D:\\cc\\cc\\javassist\\ClassDemo.class";
            BufferedInputStream fin
                    = new BufferedInputStream(new FileInputStream(filePath));
//            //创建ClassFile
//            ClassFile classFile = new ClassFile(new DataInputStream(fin));
            //创建ClassPool
            ClassPool pool = ClassPool.getDefault();
            CtClass ctClass = pool.makeClass(fin);

            for (CtMethod ctMethod : ctClass.getDeclaredMethods()) {
                System.out.println(ctMethod.getName() + " | " + ctMethod.getLongName() + " | " + ctMethod.getReturnType());
                if ("register".equalsIgnoreCase(ctMethod.getName())) {
//                ctMethod.insertBefore("{cc.cc.javassist.JDataTools.printTest();}");
                    ctMethod.insertBefore("{cc.cc.javassist.JDataTools.printTest();}");
                    ctMethod.insertBefore("{System.out.println(\"我是不是第一条消息？\");;}");
//                    ctMethod.insertBefore("{boolean flag=true; if(flag){return;}}");
//                ctMethod.insertBefore("{cc.cc.javassist.JDataTools.errorTest();}");
//                ctClass.rebuildClassFile();
                }
                System.out.println(ctClass.getURL());
                System.out.println(ctClass.getURL().getPath());
            }

            // 输出类内容
            ctClass.writeFile("d:/javassist/test003/");

            //调用
            Class clazz = ctClass.toClass();
            Object obj = clazz.newInstance();

//            Method main = clazz.getDeclaredMethod("main", String[].class);
//            main.invoke(obj, (Object)new String[1]);

            Method tMethod = clazz.getDeclaredMethod("register", String.class, String.class);
            tMethod.invoke(obj, "这是一条测试数据！", "这也是！");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test003() {
        try {
            String filePath = "D:\\cc\\cc\\javassist\\ClassDemo.class";
            BufferedInputStream fin
                    = new BufferedInputStream(new FileInputStream(filePath));
//            //创建ClassFile
//            ClassFile classFile = new ClassFile(new DataInputStream(fin));
            //创建ClassPool
            ClassPool pool = ClassPool.getDefault();
            CtClass ctClass = pool.makeClass(fin);

            for (CtMethod ctMethod : ctClass.getDeclaredMethods()) {
                System.out.println(ctMethod.getName() + " | " + ctMethod.getLongName() + " | " + ctMethod.getReturnType());
                ctMethod.setBody("{System.out.println(\"这是第一条 javassist 测试消息！\");}");
                ctMethod.insertAfter("{System.out.println(\"这是第2条 javassist 测试消息！\");}");
                ctClass.rebuildClassFile();
                System.out.println(ctClass.getURL());
                System.out.println(ctClass.getURL().getPath());
            }

//            // 输出类内容
//            ctClass.writeFile("d:/javassist/test003/");

            //调用
            Class clazz = ctClass.toClass();
            Object obj = clazz.newInstance();

            Method main = clazz.getDeclaredMethod("main", String[].class);
            main.invoke(obj, (Object)new String[1]);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test002() {
        try {
            String filePath = "D:\\cc\\cc\\javassist\\ClassDemo.class";
            BufferedInputStream fin
                    = new BufferedInputStream(new FileInputStream(filePath));
            //创建ClassFile
            ClassFile classFile = new ClassFile(new DataInputStream(fin));

//            classFile.

            //循环输出method信息
            for(Object obj : classFile.getMethods()) {
                if (obj instanceof MethodInfo) {
                    if (((MethodInfo)obj).isConstructor()) {
                        System.out.println(obj + " --> isConstructor");
                    } else if (((MethodInfo)obj).isStaticInitializer()) {
                        System.out.println(obj + " --> isStaticInitializer");
                    } else if (((MethodInfo)obj).isMethod()) {
                        System.out.println(obj + " --> isMethod");
                    }
//                    ((MethodInfo)obj).

                    CodeIterator ci = ((MethodInfo)obj).getCodeAttribute().iterator(); ;
                    while (ci.hasNext()) {
                        int index = ci.next();
                        int op = ci.byteAt(index);
                        System.out.println(Mnemonic.OPCODE[op]);
                    }

                } else {
                    System.out.println(obj);
                }
            }

            //创建 ByteCode
            Bytecode bytecode = new Bytecode(classFile.getConstPool());



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test001() throws IOException, CannotCompileException, NotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, InvocationTargetException {

        ClassPool pool = ClassPool.getDefault();

        // 创建类 classname：创建类路径和名称
//        CtClass ctClass = pool.makeClass("org.itstack.demo.javassist.HelloWorld");
//        CtClass ctClass = pool.makeClass("cc.cc.javassist.HelloWorld");
        CtClass ctClass = pool.makeClass("cc.cc.javassist.ClassDemo");


        // 添加方法
        CtMethod mainMethod = new CtMethod(CtClass.voidType, "main", new CtClass[]{pool.get(String[].class.getName())}, ctClass);
        mainMethod.setModifiers(Modifier.PUBLIC + Modifier.STATIC);
        mainMethod.setBody("{System.out.println(\"javassist hi helloworld by 测试-小傅哥(bugstack.cn)\");}");
        ctClass.addMethod(mainMethod);

//        CtMethod(CtClass returnType, String mname, CtClass[] parameters, CtClass declaring)
        CtMethod testMethod = CtNewMethod.make("public void register(String username,String password) throws Exception {};", ctClass);
        testMethod.setBody("{ System.out.println($1); System.out.println($2); }");
        CtClass etype = ClassPool.getDefault().get("java.lang.Exception");
        testMethod.addCatch("{ System.out.println($e); throw $e; }", etype);
        ctClass.addMethod(testMethod);

//        // 创建无参数构造方法
//        CtConstructor ctConstructor = new CtConstructor(new CtClass[]{}, ctClass);
//        ctConstructor.setBody("{}");
//        ctClass.addConstructor(ctConstructor);

        // 输出类内容
        ctClass.writeFile("d:/");

        // 测试调用
        Class clazz = ctClass.toClass();
        Object obj = clazz.newInstance();

        Method main = clazz.getDeclaredMethod("main", String[].class);
        main.invoke(obj, (Object)new String[1]);

        Method tMethod = clazz.getDeclaredMethod("register", String.class, String.class);
        tMethod.invoke(obj, "这是一条测试数据！", "这也是！");



    }
}
