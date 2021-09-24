package cc.cc.file;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangchaochao
 * @version 1.0
 * @description:
 * @date 2021-06-22 13:29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocBean {
    private String path;
    private String remark;
    private String method;
}
