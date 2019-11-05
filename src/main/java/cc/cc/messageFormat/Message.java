package cc.cc.messageFormat;

import cc.cc.util.UUIDUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.text.MessageFormat;
import java.util.List;

/**
 * @Class Message
 * @Description
 * @Author 张超超
 * @Date 2019/7/12 16:09
 */
public class Message {
    public static void main(String[] args) {
        Message message = new Message();
        message.test1();
    }

    private void test1() {
        String text = "[\n" +
                "{\"userId\":\"1811171613132547\",\"signData\":\"0xf86b028504a817c800825a3c94e5e5578a00798bde77ad8364ccdd0ce75f3917a28702fbf9bd9c8000801ba06433593297020715fd968971e01b06dfbeed06d0cf23207205b23b2117b1b74fa01e7820d57dbe59166b1291841162a33c01982215e647dfd664534e0cc28a69cb\",\"toAddress\":\"0x4c21eae95b21dec62a5545c24328c6e23da01953\",\"fromAddress\":\"0x719a374c1654d4733f463cb5b87aefbb847917a1\",\"transNum\":\"0.03\",\"txHash\":null,\"type\":\"1\",\"tokenType\":\"2\",\"tradeStatus\":\"5\",\"fee\":\"0.00084\",\"actualNum\":null,\"creatTime\":\"2019-07-12 04:33:16\"},\n" +
                "{\"userId\":\"1901181110006075\",\"signData\":\"0xf86b088504a817c800825a3c94e5e5578a00798bde77ad8364ccdd0ce75f3917a28702fbf9bd9c8000801ba0ada6449d9e6533d1dcb3977b0c22c5f11b0f9931719e5d45cd5d9a8db64e52cea0286a309a28a345a5f21053821431233647dce7fee5b4176d2d29283a1d08547b\",\"toAddress\":\"0xacb08b1fed2807bd047244b4a7f394861b4667b3\",\"fromAddress\":\"0x719a374c1654d4733f463cb5b87aefbb847917a1\",\"transNum\":\"0.18\",\"txHash\":null,\"type\":\"1\",\"tokenType\":\"2\",\"tradeStatus\":\"5\",\"fee\":\"0.00084\",\"actualNum\":null,\"creatTime\":\"2019-07-12 05:00:46\"},\n" +
                "{\"userId\":\"1901251230062972\",\"signData\":\"0xf86b318504a817c800825a3c94e5e5578a00798bde77ad8364ccdd0ce75f3917a28702fbf9bd9c8000801ba06a76245510d216ffc01b3bc513f80306a7c767909bf174e388b50bdfe10c52fea02879ec853f14acfaa76c4160a6ba273e31200eeda1f551ec6449825345fc2486\",\"toAddress\":\"0xc544812e9b5126372118ae39fb628cf2235a2156\",\"fromAddress\":\"0x719a374c1654d4733f463cb5b87aefbb847917a1\",\"transNum\":\"0.05\",\"txHash\":null,\"type\":\"1\",\"tokenType\":\"2\",\"tradeStatus\":\"5\",\"fee\":\"0.00084\",\"actualNum\":null,\"creatTime\":\"2019-07-12 06:17:47\"},\n" +
                "{\"userId\":\"1811090904556034\",\"signData\":\"0xf86c81e28504a817c800825a3c94e5e5578a00798bde77ad8364ccdd0ce75f3917a28702fbf9bd9c8000801ba0e356197401fc482371f3f42c7460fc3d0744d7dca19bc2ac495ce6a53157b403a030099e82e4c77be4ee2f4e5ab4a13580856a4886d31302f1424dc58905e3a6ba\",\"toAddress\":\"0xb2e6445ef3848412896cc6c1a68696ad9e96072b\",\"fromAddress\":\"0x719a374c1654d4733f463cb5b87aefbb847917a1\",\"transNum\":\"0.01\",\"txHash\":null,\"type\":\"1\",\"tokenType\":\"2\",\"tradeStatus\":\"5\",\"fee\":\"0.00084\",\"actualNum\":null,\"creatTime\":\"2019-07-12 06:44:19\"},\n" +
                "{\"userId\":\"1810151442101381\",\"signData\":\"0xf86b038502540be400825a3c94e5e5578a00798bde77ad8364ccdd0ce75f3917a287017dfcdece4000801ca0b8de3407ea417fc5b3d894a1034b318c26c40d697183dc4e2621b84a38d33c0ba07de93be6aa264c012edb1d3ebe4d20e82e70d1be36250d5dbc5f609155fd597d\",\"toAddress\":\"0x1d515b0008804b94ba6a81b0ecd58225542214be\",\"fromAddress\":\"0x719a374c1654d4733f463cb5b87aefbb847917a1\",\"transNum\":\"0.02\",\"txHash\":null,\"type\":\"1\",\"tokenType\":\"2\",\"tradeStatus\":\"5\",\"fee\":\"0.00042\",\"actualNum\":null,\"creatTime\":\"2019-07-12 08:07:05\"},\n" +
                "{\"userId\":\"1901070747194262\",\"signData\":\"0xf86b088502540be400825a3c94e5e5578a00798bde77ad8364ccdd0ce75f3917a287017dfcdece4000801ca01bcbaacaa28fb0540552d2eeaeb6a027f7d7ea86a925139af430d5463e7786f7a047bfd05d4ffe16d5c79da35bde805ec156446fcca32635dcf5204a18aa94e55a\",\"toAddress\":\"0xc8edab255a4f0155a996eeb1cd3dea2a873a167a\",\"fromAddress\":\"0x719a374c1654d4733f463cb5b87aefbb847917a1\",\"transNum\":\"0.05\",\"txHash\":null,\"type\":\"1\",\"tokenType\":\"2\",\"tradeStatus\":\"5\",\"fee\":\"0.00042\",\"actualNum\":null,\"creatTime\":\"2019-07-12 08:24:42\"},\n" +
                "{\"userId\":\"1811171256068571\",\"signData\":\"0xf86b228502540be400825a3c94e5e5578a00798bde77ad8364ccdd0ce75f3917a287017dfcdece4000801ba02e7c0f42020ed7161c73a6f0030945216b4ad7a84e7970a4a70b2e34ba4a6ae1a01e8e2ad0f52b64ffe38aa170d1b5882432ea33445882020d783f7f2847427789\",\"toAddress\":\"0x681d922135ab07a298c97463f66412d2d577a239\",\"fromAddress\":\"0x719a374c1654d4733f463cb5b87aefbb847917a1\",\"transNum\":\"0.03\",\"txHash\":null,\"type\":\"1\",\"tokenType\":\"2\",\"tradeStatus\":\"5\",\"fee\":\"0.00042\",\"actualNum\":null,\"creatTime\":\"2019-07-12 08:50:19\"},\n" +
                "{\"userId\":\"1903240910249465\",\"signData\":\"0xf86b188502540be400825a3c94e5e5578a00798bde77ad8364ccdd0ce75f3917a287017dfcdece4000801ca058b0277b93fa21e0d00a834f9cb663c2b09ce5bd9441066503edb952bbc6b5daa07143014b4088c6422c651d25baa6c002247059fe9c673dccd5e95dac0da4ad9b\",\"toAddress\":\"0xa0c893deb07aae7a182525213298bd9e9bebf258\",\"fromAddress\":\"0x719a374c1654d4733f463cb5b87aefbb847917a1\",\"transNum\":\"0.01\",\"txHash\":null,\"type\":\"1\",\"tokenType\":\"2\",\"tradeStatus\":\"5\",\"fee\":\"0.00042\",\"actualNum\":null,\"creatTime\":\"2019-07-12 08:58:42\"},\n" +
                "{\"userId\":\"1812271435076744\",\"signData\":\"0xf86a5085012a05f200825a3c94e5e5578a00798bde77ad8364ccdd0ce75f3917a286befe6f672000801ba0269db04aac23a898c9914b898823089621ea0915724a6a8d047f283a3f77d634a0634f474947f59df9bfed36c6f1a96c78f9d8bfc7c810645ab56d2c9b91cae440\",\"toAddress\":\"0x077ce2e7648a73005aca08978242329411eed59a\",\"fromAddress\":\"0x719a374c1654d4733f463cb5b87aefbb847917a1\",\"transNum\":\"0.22\",\"txHash\":null,\"type\":\"1\",\"tokenType\":\"2\",\"tradeStatus\":\"5\",\"fee\":\"0.000210\",\"actualNum\":null,\"creatTime\":\"2019-07-12 09:17:51\"},\n" +
                "{\"userId\":\"1809121808364147\",\"signData\":\"0xf8698084ee6b2800825a3c94e5e5578a00798bde77ad8364ccdd0ce75f3917a28698cb8c528000801ca0af8ab561a6b62e8635b633f78d0aafcb63d674a7943d24f596b000a6a20ab1d1a0303f962e8b51c6759da6a91e7fdfd6bd27bf11b6ea513f80a401cccb0868bbc5\",\"toAddress\":\"0xae937d42def3f06da42c301c9f8411cedb72dfe3\",\"fromAddress\":\"0x719a374c1654d4733f463cb5b87aefbb847917a1\",\"transNum\":\"0.11\",\"txHash\":null,\"type\":\"1\",\"tokenType\":\"2\",\"tradeStatus\":\"5\",\"fee\":\"0.000168\",\"actualNum\":null,\"creatTime\":\"2019-07-12 09:36:52\"},\n" +
                "{\"userId\":\"1901191418283332\",\"signData\":\"0xf8698084ee6b2800825a3c94e5e5578a00798bde77ad8364ccdd0ce75f3917a28698cb8c528000801ba0da146be995dc82aee734a0fc6facfb8d5482cd7cb829160e80d9a3186f9097f3a055261ec5b0eefe5c318901aad4b6878fa5e58e5f19ee557ebb871fdab711a5a8\",\"toAddress\":\"0xa166f9ca53b672d5cb5efeeed108d16f2d69a086\",\"fromAddress\":\"0x719a374c1654d4733f463cb5b87aefbb847917a1\",\"transNum\":\"0.05\",\"txHash\":null,\"type\":\"1\",\"tokenType\":\"2\",\"tradeStatus\":\"5\",\"fee\":\"0.000168\",\"actualNum\":null,\"creatTime\":\"2019-07-12 09:40:19\"}\n" +
                "]\n";
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        List<TokenTransfer> ttList = gson.fromJson(text, new TypeToken<List<TokenTransfer>>(){}.getType());

        String pattern = "INSERT INTO tokentransfer(id,userId,txhash,signData,fromAddress,toAddress,transNum,fee,actualNum,type,tokenType,tradeStatus,creatTime)"
                + "VALUES(''{0}'',''{1}'',{2},''{3}'',''{4}'',''{5}'',{6},{7},{8},{9},{10},{11},''{12}'')";

        ttList.forEach(tt -> {
            tt.setId(UUIDUtil.get32UUID());
            String[] arguments = new String[]{tt.getId(), tt.getUserId(), tt.getTxHash(), tt.getSignData(), tt.getFromAddress(),
                tt.getToAddress(), tt.getTransNum(), tt.getFee(), tt.getActualNum(), tt.getType(), tt.getTokenType(),
                tt.getTradeStatus(), tt.getCreatTime()};

            System.out.println(MessageFormat.format(pattern, arguments));
        });



    }
}
