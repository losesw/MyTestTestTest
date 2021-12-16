package cc.cc.custom;

import cc.cc.file.FileTest;
import cn.hutool.core.util.ObjectUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhangchaochao
 * @version 1.0
 * @date 2021-10-22 10:20
 */
@Slf4j
public class ExportConfig {
    enum ExportRule{
        apollo(0), //0:以apollo为主
        prop(1), //1:以prop为主
        all(2); //2:两者并集
        private int value;
        ExportRule(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
//        String propPath1 = "E:\\workspace\\idea\\gitlabNew\\opExternalUpload\\yto-opExternalUpload-starter\\src\\main\\resources\\application-release.properties";

        //opExternalUpload
        String propPath = "E:\\workspace\\idea\\gitlabNew\\opExternalUpload\\yto-opExternalUpload-starter\\src\\main\\resources\\application.properties";
        String apolloPath = "E:\\tmp\\apollo_opExternalUpload.txt";
        String exportFilePath = "E:\\tmp\\exportConfig_opExternalUpload.csv";
        exportFile(propPath, apolloPath, exportFilePath, ExportRule.prop);

        //pdaUpload
//        String propPath = "E:\\workspace\\idea\\gitlabNew\\pdaUpload\\src\\main\\resources\\application.properties";
//        String apolloPath = "E:\\tmp\\exportConfig - apollo.txt";
//        String exportFilePath = "E:\\tmp\\exportConfig.csv";
//        exportFile(propPath, apolloPath, exportFilePath, ExportRule.apollo);


    }

    public static void exportFile(String propPath, String apolloPath, String exportFilePath) {
        exportFile(propPath, apolloPath, exportFilePath, ExportRule.apollo);
    }

    public static void exportFile(String propPath, String apolloPath, String exportFilePath, ExportRule rule) {
        List<String> dataList = new ArrayList<>();
        //获取数据
        dataList.addAll(calcCofnigList(propPath, apolloPath, rule));
        //导出数据
        FileTest.writeFile(dataList, exportFilePath);
    }

    public static List<String> calcCofnigList(String propPath, String apolloPath, ExportRule rule) {
        List<String> list = new ArrayList<>();
        LinkedHashMap<String, String> propMap = getPropMap(propPath);
        LinkedHashMap<String, String> apolloMap = getApolloMap(apolloPath);

        //计算content
        if (ExportRule.apollo.equals(rule)) {
            for(Map.Entry<String, String> entry : apolloMap.entrySet()) {
                String content = propMap.get(entry.getKey());
                if (null == content) {
                    log.info("prop key not found --> {}, apollo value --> {}", entry.getKey(), entry.getValue());
                    continue;
                }
//            log.info("apollo key --> {}, value --> {}", entry.getKey(), entry.getValue());
//            log.info("porp value --> {}", content);
                content = Arrays.stream(content.split(",")).map(c -> {
                    if ("true".equalsIgnoreCase(c)||"false".equalsIgnoreCase(c)) {
                        return entry.getValue();
                    }
                    return c;
                }).collect(Collectors.joining(","));
//            log.info("porp new value --> {}", content);
                list.add(content);
            }
        } else if (ExportRule.prop.equals(rule)) {
            for(Map.Entry<String, String> entry : propMap.entrySet()) {
                String contentProp = entry.getValue();
                String contentApollo = apolloMap.get(entry.getKey());
                if (null == contentProp) {
                    log.info("prop key not found --> {}, apollo value --> {}", entry.getKey(), entry.getValue());
                    continue;
                }
//            log.info("porp key --> {}, value --> {}", entry.getKey(), entry.getValue());
//            log.info("apollo value --> {}", contentApollo);
                contentProp = Arrays.stream(contentProp.split(",")).map(c -> {
                    if ("true".equalsIgnoreCase(c)||"false".equalsIgnoreCase(c)) {
                        if (null != contentApollo) {return contentApollo;};
                    }
                    return c;
                }).collect(Collectors.joining(","));
//            log.info("porp new value --> {}", contentApollo);
                list.add(contentProp);
            }
        } else if (ExportRule.all.equals(rule)) {
            for(Map.Entry<String, String> entry : propMap.entrySet()) {
                String contentProp = entry.getValue();
                String contentApollo = apolloMap.get(entry.getKey());
                if (null == contentProp) {
                    log.info("prop key not found --> {}, apollo value --> {}", entry.getKey(), entry.getValue());
                    continue;
                }
//            log.info("porp key --> {}, value --> {}", entry.getKey(), entry.getValue());
//            log.info("apollo value --> {}", contentApollo);
                contentProp = Arrays.stream(contentProp.split(",")).map(c -> {
                    if ("true".equalsIgnoreCase(c)||"false".equalsIgnoreCase(c)) {
                        if (null != contentApollo) {return contentApollo;};
                    }
                    return c;
                }).collect(Collectors.joining(","));
//            log.info("porp new value --> {}", contentApollo);
                list.add(contentProp);
            }
        }


        //使用双引号包裹字符串
        list = list.stream()
                .filter(str -> str.split(",").length==3
                        && ("true".equalsIgnoreCase(str.split(",")[1]) || "false".equalsIgnoreCase(str.split(",")[1])))
                .map(str -> {
                    return Arrays.stream(str.split(",")).map(s -> "\""+s+"\"").collect(Collectors.joining(","));
                }).collect(Collectors.toList());
        return list;
    }

    //获取prop的map集合
    public static LinkedHashMap<String, String> getApolloMap(String apolloPath) {
        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<>();
        //获取配置数据
        String[] keyValueArr = new String[2];
        FileTest.readContentToList(apolloPath)
            .stream()
            .filter(l -> {
                if (ObjectUtil.isNotNull(l) && ObjectUtil.isNotEmpty(l.trim())) {return true;}
                return false;
            })
            .filter(str -> str.split("=").length==2 //只保留true、false值
                    && ("true".equalsIgnoreCase(str.split("=")[1].trim()) || "false".equalsIgnoreCase(str.split("=")[1].trim())))
            .forEach(str -> {
                keyValueArr[0] = str.split("=")[0].trim();
                keyValueArr[1] = str.split("=").length > 1 ? str.split("=")[1].trim() : "";
                linkedHashMap.put(keyValueArr[0], keyValueArr[1]);
            });
        return linkedHashMap;
    }

    //获取apollo的map集合
    public static LinkedHashMap<String, String> getPropMap(String propPath) {
        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<>();
        //获取配置数据
        String[] arr = new String[2];
        String[] keyValueArr = new String[2];
        FileTest.readContentToList(propPath)
                .stream()
                .filter(l -> { //去除空值
                    if (ObjectUtil.isNotNull(l) && ObjectUtil.isNotEmpty(l.trim())) {return true;}
                    return false;
                })
                .forEach(str -> {
                    arr[1] = arr[0];
                    arr[0] = str;
                    if (ObjectUtil.isNotEmpty(arr[0]) && ObjectUtil.isNotEmpty(arr[1])) { //当前行和上一行都不为空
                        keyValueArr[0] = arr[0].split("=")[0].trim();
                        keyValueArr[1] = arr[0].split("=").length > 1 ? arr[0].split("=")[1].trim() : "";
                        if (arr[0].startsWith("#")) { //当前行数据包含#，跳过

                        } else if (arr[1].startsWith("#")) { //当前行数据不包含#，且上行数据包含#
                            linkedHashMap.put(keyValueArr[0],String.join(",", keyValueArr[0], keyValueArr[1], arr[1].replace("#","").trim()));
                            arr[0] = "";
                            arr[1] = "";
                        } else {
                            linkedHashMap.put(keyValueArr[0],String.join(",", keyValueArr[0].trim(), keyValueArr[1].trim(), ""));
                            arr[1] = "";
                        }
                    }
                });;
        return linkedHashMap;
    }

    public static List<String> exportWithProperty(String path) {
        //获取配置数据
        List<String> list = FileTest.readContentToList(path);
        list = list.stream().filter(l -> {
            if (ObjectUtil.isNotNull(l) && ObjectUtil.isNotEmpty(l.trim())) {return true;}
            return false;
        }).collect(Collectors.toList());

        List<String> putList = new ArrayList<>();
        List<String> returnList = new ArrayList<>();
        String[] arr = new String[2];
        String[] keyValueArr = new String[2];
        list.forEach(str -> {
//            log.info("{}", str);
            arr[1] = arr[0];
            arr[0] = str;
            if (ObjectUtil.isNotEmpty(arr[0]) && ObjectUtil.isNotEmpty(arr[1])) { //当前行和上一行都不为空
                keyValueArr[0] = arr[0].split("=")[0].trim();
                keyValueArr[1] = arr[0].split("=").length > 1 ? arr[0].split("=")[1].trim() : "";
                if (arr[0].startsWith("#")) { //当前行数据包含#，跳过

                } else if (arr[1].startsWith("#")) { //当前行数据不包含#，且上行数据包含#
                    putList.add(String.join(",", keyValueArr[0], keyValueArr[1], arr[1].replace("#","")));
                    arr[0] = "";
                    arr[1] = "";
                } else {
                    putList.add(String.join(",", keyValueArr[0].trim(), keyValueArr[1].trim(), ""));
                    arr[1] = "";
                }
            }
        });

        //1.只保留true、false开关
        //2.使用双引号包裹字符串
        returnList = putList.stream()
                .filter(str -> str.split(",").length==3
                        && ("true".equalsIgnoreCase(str.split(",")[1]) || "false".equalsIgnoreCase(str.split(",")[1])))
                .map(str -> {
            return Arrays.stream(str.split(",")).map(s -> "\""+s+"\"").collect(Collectors.joining(","));
        }).collect(Collectors.toList());

        returnList.forEach(str -> {
            log.info("{}", str);
        });

        return returnList;
    }
}
