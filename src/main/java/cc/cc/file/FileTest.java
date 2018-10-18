/**
 * @Version 1.0.0
 * Copyright (c) 2018上海相诚金融-版权所有
 */
package cc.cc.file;

import java.io.File;

/**
 * @Class FileTest
 * @Description
 * @Author 张超超
 * @Date 2018/8/31 15:52
 */
public class FileTest {
    public static void main(String[] args) {
        String dir = "D:\\tempWork\\contracts\\2018_08_31";
        print(dir);
    }

    private static void print(String dir) {
        File file = new File(dir);
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                System.out.print(f.getName() + " ");
            }
        }
    }
}
