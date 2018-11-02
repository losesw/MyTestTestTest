/**
 * @Version 1.0.0
 * Copyright (c) 2018上海相诚金融-版权所有
 */
package cc.cc.images;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Class ImageDownload
 * @Description
 * @Author 张超超
 * @Date 2018/11/2 15:59
 */
@Slf4j
public class ImageDownload {

    public void download(String urlPath, String directory) {
        download(urlPath, directory, true);
    }

    public void download(String urlPath, String directory, boolean cover) {
        int endSeparator = urlPath.lastIndexOf("/");
        String name = urlPath.substring(endSeparator + 1);
        String filePath = directory.concat("/").concat(name);

        if (!cover) {
            File file = new File(filePath);
            if (file.exists()) {
                log.info("file exists: {}", file);
                return;
            }
        }

        downloadFile(urlPath, filePath);
    }

    private void downloadFile(String urlPath, String filePath) {
        try {
            URL url = new URL(urlPath);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(15000); //timeout 15s
            conn.setRequestProperty("User-Agent","Mozilla/5.0 Gecko/20100101 Firefox/63.0");
            InputStream in = conn.getInputStream();

            int len = 0;
            byte[] b = new byte[2048];
            ByteOutputStream out = new ByteOutputStream();
            while ((len = in.read(b)) != -1) {
                out.write(b, 0, len);
            }
            byte[] bytes = out.getBytes();

            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            fileOutputStream.write(bytes);

            if (null != in) in.close();
            if (null != out) in.close();
            if (null != fileOutputStream) in.close();

            log.info("download success: {} ", url);

        } catch (Exception e) {
            e.printStackTrace();
            log.info("download error: {}", urlPath);
        }
    }

}
