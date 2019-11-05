package cc.cc.messageFormat;

import lombok.Data;

/**
 * @Class TokenTransfer
 * @Description
 * @Author 张超超
 * @Date 2019/7/12 16:09
 */
@Data
public class TokenTransfer {
    private String id;
    private String userId;
    private String signData;
    private String toAddress;
    private String fromAddress;
    private String transNum;
    private String txHash;
    private String type;
    private String tokenType;
    private String tradeStatus;
    private String fee;
    private String actualNum;
    private String creatTime;
}
