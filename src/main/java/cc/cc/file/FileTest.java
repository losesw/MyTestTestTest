package cc.cc.file;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangchaochao
 * @version 1.0
 * @description:
 * @date 2021-06-22 11:00
 */
@Slf4j
public class FileTest {
    public static void main(String[] args) {

        Map<String, DocModel> dataMap = new HashMap<>();

        String filePath = "C:\\Users\\admin\\Desktop\\work\\整理\\api-docs.json";
        String content = FileTest.readContent(filePath);
        Map<String, Object> obj = JSON.parseObject(content, Map.class);

        Map<String, String> tagMap = new HashMap<>();
        ((List<Map<String, String>>) obj.get("tags")).forEach(m -> {
            tagMap.put(m.get("name"), m.get("description"));
        });

        Map<String, Object> pathMap = (Map<String, Object>) obj.get("paths");
        for (Map.Entry<String, Object> entryPath : pathMap.entrySet()) {
            Map<String, Object> methodMap = (Map<String, Object>) entryPath.getValue();
            for (Map.Entry<String, Object> entryMethod : methodMap.entrySet()) {
                Map<String, Object> method = (Map<String, Object>) entryMethod.getValue();
                String path = entryPath.getKey();
                String summary = (String) method.get("summary");
                String methodStr = (String) entryMethod.getKey();
                List<String> tags = (List<String>) method.get("tags");
//                log.info("path -> {} | method -> {} | summary -> {}| tags -> {}", entryPath.getValue(), entryMethod.getKey(), summary, tags);
//                if (tags.size() > 2) {
//                    log.info("tags length > 1");
//                }
                for(String tag: tags) {
                    if (null == dataMap.get(tag)) dataMap.put(tag, new DocModel());
                    dataMap.get(tag).getList().add(new DocBean(path, summary, methodStr));
                }
            }
        }

//        log.info("tagMap --> {}", tagMap);
//        log.info("dataMap --> {}", dataMap);

        String path = "C:\\Users\\admin\\Desktop\\work\\整理\\PdaUpload接口整理.txt";
        FileTest.writeFile(dataMap, path);

        log.info("------执行完毕！-------");
    }

    public static void writeFile(Map<String, DocModel> tagMap, String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) file.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for(Map.Entry<String, DocModel> entry : tagMap.entrySet()) {
                writer.newLine();
                writer.newLine();
                writer.newLine();
                writer.write(entry.getKey());
                writer.write("------------");
                writer.newLine();
                for(DocBean bean : entry.getValue().getList()) {
                    writer.write("接口：");
                    writer.write(bean.getRemark());
                    writer.newLine();
                    writer.write("路径：");
                    writer.write(bean.getPath());
                    writer.newLine();
                    writer.write("类型：");
                    writer.write(bean.getMethod());
                    writer.newLine();
                    writer.newLine();
                }
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String readContent(String filePath) {
        File file = new File(filePath);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
