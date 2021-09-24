package cc.cc.file;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangchaochao
 * @version 1.0
 * @description:
 * @date 2021-06-22 13:30
 */
@Data
public class DocModel {
    private String tag;
    private List<DocBean> list = new ArrayList<>();
}
