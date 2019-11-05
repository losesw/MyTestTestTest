package cc.cc.wallet;

import com.google.gson.Gson;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Class Filter
 * @Description
 * @Author 张超超
 * @Date 2019/11/5 13:58
 */
public class Filter {
    public static void main(String[] args) {
        StringBuilder filters = new StringBuilder();
        filters.append("{\"code\":0,\"msg\":\"\",\"data\":[{\"address\":\"0x36f9169110513f808cc2db108a427b6e3dbd59b7\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x5a9851ade82175ba0ffdb44e0c2a608f5cc1ee20\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x67aaa94a18938b4a81dd5ace0a9a34e234616b19\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0xff9cec695cb53423b8ffeeb2599df97289654a89\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0xbd4bbeca48dc50ae41702126213601c275accf0f\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x55fc5185020a104f06c0faaad6654c38c2d85746\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x8a9a0573e9f4c52af6f7de4eb580e7a835b8133f\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x71745a5f6e1261fab91705c5b6e7b2a3ab9b517b\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0xd2d38ddc89d01fe2686bbeb99138f6a1dd7932ed\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x3f01e64179c83a314ca21fa1c33d6feda0002878\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x83651f2e28c81e7ac4eaea658c4e665016e85723\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x4b0aa6871e569ebe2b391c0fa716117f5a65de70\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x40d00f1d042a369b9f079b675b8fa093eb0ddd70\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x424a7713491a6f3ccf9136c066a60f3ee492e278\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0xe216f6d3ef67e1ecd6435f8e23baa627bc708db2\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0xb5d2f2821c415ba65700342ba6e00cf131595793\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x92fa475ba258f57d69773e974e8207638a62be0a\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x98d7f0593e787eb7d1f90016b637d618d51aec17\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x074149f1d33b2f4be544cc7a854373450eb5bced\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x9fce8173da8949ff0516f9b3628262b26c086f5c\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0xa2a1aa3fc5a4b28f14a9f747d572996a11bf4db5\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0xc3fa14b92c84645c3b1da0a2b6baf2a114b65314\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x960fd2cecc3d8cdff19dea4e02484b3603f3400a\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x54e77298e8befa306de50f12de74e839d95c75c5\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0xd68a9824e069018ac49449392ff5c371e09abdb7\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x6dc3b65b4da986aeb3cdf5f99cf6dbc33c06e882\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x34001bde3fe69094a93e6c0d303e54dc0cea527a\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x99dd6454da3d67c073678c85054851e610cf191c\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x430478dc12df3bf621747d11cfcfda617b8dbc6a\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x25205285f4eb0ba6b0b2ecc128602c1417ea7897\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0xb989836d774386c48c880546fa9f32531cccfa2c\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0xe472afa81ebdf86d459497a40f9a3b0793a46692\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x825dcaeadb4461e1ccbe9873502c5497298a258f\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x5fe7aaf964e3f0d02c5e1df3c32d7a6063cd39af\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x52c061a6b47a47d9db2b30da65ee4fcfeaaeb82d\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0xb0135be2833283fb2112c97815a8068fba727385\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x3f7f122ffcc01f601f8dfb1cff22956c14654b60\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0xd6bee8b023d17abe07451f6be14d8d936456dcfb\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x55c4690782598987356be725fdc7162532e340c5\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0xeafd0c75f0d20dd0350e898dc8c8e535d2eb5fa9\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x277178d5c55115d52a9f1786f0f162fb40c04192\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0xa34c88cfba15f374a6072409cf3850c1f88457e2\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x6b0653ddd7c96d9ea9b0965e4f7f51589baeb905\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x040e0102430636b1fc130bb09b7a3f941b8471d8\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0xfd2f6e86a7bc36a39e5a5f30acb6b9e295d0abbb\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x2e0cf2ff986b639da0129c932c4d3791f23b55c3\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x9f2fb2a92bcea05a4c5bf2235edd60de79de3301\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x9c57f7a514b0ba10a9a6a663be0f5e377db53fb7\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x189d14fb8a409948e91a869b525b241caab1c5fe\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x362b034ae282d1e0b6329cea5e022d82d876472c\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x725ca6c159bbc66d986f1f5b5ee53729770d6fb8\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x22c80a7af4e1081208443ce8dc5f9bc0edfc0cf4\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x4999a21d9f1863c96e9cff8beb2b4b639973925c\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x4634ea062c0bdd508613a9c0ac1131bfa69d270b\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0xe176d11bb62fd7117bf5438866015b0b3a50603d\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0xcf30c39f869b2e350af9e911ad279d58d043a1b4\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x713f84a093f2b01c0bd42a105f1f54d70ef93cfa\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0xf086669a5ff9b20037cf7562d61e78252fb541bd\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x14e51340f948b2f2d12bb90ccc7538149c2fcfd8\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0xa039f1b7279a11fe6ecf6e6759a51b269e09cd0f\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0xacb73ea407872b1a0208518cfb1d0bb7ef66e82a\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x39e94f2d4a00f2904f11c31459c12023f95c1fcf\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0xadf5883a1b1c0ab9e5aed70b84c9ec7ac5560091\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x60acd10088aeaa5b71f84f8f9b21422be0308aa1\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x8c40f7cf5815646538b9e3c221f737aa2a4e2339\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x02dfc3a36145aba0536749fd6ddfceb5b48ed0dd\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x093ff3407816f56bf8c2d0b3975dee6d8fc79c00\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0xe8706dad21737f5e65dc4235d187c32c174a99f7\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x439a15a8678df7490b1f09b248ab5e26e00cafbd\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x40b8b4585cf5e779e1e45ed79f4b1bc49dae65d9\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x7dfcfb36e0bd0d3e35a6b1d38d148a16da4a7d31\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0xf780dac5601c8a503d37c1b59e2235dddf612f71\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0xa61ecf95fc2d387bbcc2c3f83eeda4b786ccae9a\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0xa1ccc50025e11a512b9195c7380581ac0c197f1d\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x10151fbae3dd4e8f9c8b145c6b5998206a416296\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x99673adab698054bdc7b11a47dbb72483cefaf69\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x826b8c6120702afca58e63c16dd21b8e27138f66\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x0533b7b7ebc14718e682c553608642e6f18e0ae2\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0xef138f9b4c0869b9273f93b2645136a3d46bcd8c\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x9f071894a2d03eb341813e9555d7d6b59a0e750a\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x0cf9a7cca9345ae3fad1e56bbcef7c099c9f52e7\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0xd976b5215c858b681e04c0672f63894244138149\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x5ac0d3dec58796faccafd5351735546b938b17c3\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x704aac9836f99c9834d4294700d94350e286633b\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0x63fbb7d6f94fb6d25f46a695245463ea65e05363\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0xab6171dfe12553e643ab5112bfee57c5f75f61ec\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"},{\"address\":\"0xa9d77b032815aef788fd9bebb409ec5b0e96b554\",\"method\":0,\"invalidated_time\":-1,\"type\":1,\"methodIdEnum\":\"TRANSFER\"}]}");
        Gson gson = new Gson();
        Map<String, Object> map = gson.fromJson(filters.toString(), Map.class);
        List<Map<String, Object>> objects = (List<Map<String, Object>>) map.get("data");
        List<String> addressList = objects.stream().map(m -> String.valueOf(m.get("address"))).collect(Collectors.toList());
        System.out.println(addressList.size());

        String pattern = "curl -X POST -H \"Content-Type:application/json\" --data '{\"address\":\"_address_\",\"method\":\"0\",\"type\":\"1\",\"invalidated_time\":\"-1\"}' http://127.0.0.1:11112/api/blockchain/filter/addFilter";
        StringBuilder wallet = new StringBuilder();
        wallet.append("");
        wallet.append("");
        List<Map<String, Object>> list = gson.fromJson(wallet.toString(), List.class);
        list.stream().forEach(m -> {
            String address = String.valueOf(m.get("address"));
            if (!addressList.contains(address))
                System.out.println(pattern.replace("_address_", address));
        });
    }
}
