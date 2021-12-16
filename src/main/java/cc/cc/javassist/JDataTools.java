package cc.cc.javassist;

/**
 * @author zhangchaochao
 * @version 1.0
 * @date 2021-12-08 15:19
 */
public class JDataTools {
    public static void printTest() {
        System.out.println("我是一条紧急插播消息");
    }

    public static void errorTest() throws Exception {
        System.out.println("我是一条紧急插播消息");
        throw new Exception("发生异常啦！小心！");
    }

}
