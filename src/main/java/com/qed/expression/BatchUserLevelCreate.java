///**
// * @Version 1.0.0
// * Copyright (c) 2016上海相诚金融-版权所有
// */
//package com.qed.expression;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @Class BatchUserLevelCreate
// * @Description ${DESCRIPTION}
// * @Author 张超超
// * @Date 2016/4/14 10:28
// */
//public class BatchUserLevelCreate {
//    @RequestMapping(value = "/test")
//    public Msg test() {
//        Msg msg =new Msg();
//
//        String userIds = "13735";
////		String userIds = "13735,13767,13817,14014,14088,14104,14128,14138,14139,14140,14145,14154,14155,14157,14159,14162,14168,14169,14171,14177,14183,14184,14185,14196,14197,14218,14220,14221,14229,14231,14235,14240,14241,14242,14244,14245,14251,14254,14257,14260,14261,14262,14265,14266,14267,14270,14273,14276,14278,14279,14280,14283,14284,14286,14289,14290,14291,14292,14298,14302,14308,14311,14317,14331,14332,14334,14337,14340,14349,14350,14352,14358,14360,14361,14362,14366,14368,14370,14371,14374,14375,14376,14378,14380,14388,14389,14392,14395,14396,14397,14399,14401,14402,14403,14406,14420,14423,14427,14429,14430,14433,14434,14436,14438,14439,14440,14441,14444,14445,14446,14449,14454,14457,14458,14460,14463,14464,14470,14472,14475,14476,14496,14507,14508,14509,14517,14518,14524,14525,14526,14532,14533,14539,14549,14558,14564,14565,14567,14568,14569,14573,14574,14579,14580,14585,14589,14590,14591,14592,14596,14601,14622,14650,14658,14662,14663,14678,14694,14712,14719,14724,14725,14745,14762,14766,14772,14779,14785,14786,14792,1479";
////		String userIds = "13767,13817,14014,14088,14104,14128,14138,14139,14140,14145,14154,14155,14157,14159,14162,14168,14169,14171,14177,14183,14184,14185,14196,14197,14218,14220,14221,14229,14231,14235,14240,14241,14242,14244,14245,14251,14254,14257,14260,14261,14262,14265,14266,14267,14270,14273,14276,14278,14279,14280,14283,14284,14286,14289,14290,14291,14292,14298,14302,14308,14311,14317,14331,14332,14334,14337,14340,14349,14350,14352,14358,14360,14361,14362,14366,14368,14370,14371,14374,14375,14376,14378,14380,14388,14389,14392,14395,14396,14397,14399,14401,14402,14403,14406,14420,14423,14427,14429,14430,14433,14434,14436,14438,14439,14440,14441,14444,14445,14446,14449,14454,14457,14458,14460,14463,14464,14470,14472,14475,14476,14496,14507,14508,14509,14517,14518,14524,14525,14526,14532,14533,14539,14549,14558,14564,14565,14567,14568,14569,14573,14574,14579,14580,14585,14589,14590,14591,14592,14596,14601,14622,14650,14658,14662,14663,14678,14694,14712,14719,14724,14725,14745,14762,14766,14772,14779,14785,14786,14792,1479";
////		String userIds = "14793,14795,14796,14799,14800,14801,14811,14812,14815,14817,14829,14833,14843,14855,14864,14878,14883,14890,14918,14935,14937,14946,14954,14973,14997,15027,15053,15070,15145,15158,15165,15340,15373,15461,15499,15686,15687,15695,15741,15778,15797,15805,15812,15814,15815,15817,15820,15825,15826,15833,15836,15839,15840,15846,15863,15916,15921,15969,15998,16003,16005,16008,16063,16087,16103,16142,16151,16155,16244,16264,16316,16349,16350,16361,16439,16443,16447,16472,16506,16537,16770,17194,17286,17421,17482,17545,17798,18215,18216,18294,18454,18510,18518,19626,19702,19733,19735,19736,19740,19741,19751,19769,19798,19860,19884,19943,20034,20055,20085,20161,20295,20298,20409,20452";
//        String[] userIdArray = userIds.split(",");
//        int index = 0;
//        for (String userId : userIdArray) {
//            L.info(++index + "");
//            callCreateOrUpdateUserLevelByUserId(userId);
//        }
//
//        msg.setCode(Constant.SUCCESS);
//        msg.setData(userIdArray.length);
//        return msg;
//    }
//
//    /**
//     *
//     * @param userId
//     * @return
//     */
//    public Msg callCreateOrUpdateUserLevelByUserId(String userId) {
//        Map<String, String> paramsMap = new HashMap<String,String>();
//        paramsMap.put("userId", userId);
//        String url = "http://api.51qed.com/app/userlevel/createOrUpdateUserLevelByUserId";
////		String url = "http://localhost:8093/app/users/checkToken";
//        return callWithJson(url,paramsMap, 1);
//    }
//
//    /**
//     * 调用外部接口，json（get方法暂时有问题，勿调用）
//     * @param url url地址
//     * @param paramsMap 参数
//     * @param method get/post
//     * @return Msg
//     */
//    private Msg callWithJson(String url, Map<String, String> paramsMap, int method) {
//        L.info("method callInterface params : " + paramsMap);
//        Msg msg = new Msg();
//        try {
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_JSON);
//            HttpEntity<Map<String, String>> entity = new HttpEntity<Map<String,String>>(paramsMap, headers);
//            RestTemplate template = new RestTemplate();
//            if (0 == method) { //get
//                ResponseEntity<Msg> responseEntity = template.exchange(url, HttpMethod.GET, entity, Msg.class);
//                msg = responseEntity.getBody();
//            } else if (1 == method) { //post
//                ResponseEntity<Msg> responseEntity = template.exchange(url, HttpMethod.POST, entity, Msg.class);
//                msg = responseEntity.getBody();
//            } else {
//                msg.setCode(Constant.FAIL);
//                msg.setMsg("method 参数错误");
//            }
//        } catch (Exception e) {
//            msg.setCode(-1);
//            msg.setData(e);
//            msg.setMsg("发生异常");
//        }
//        L.info("method callInterface return : " + msg);
//        return msg;
//    }
//}
