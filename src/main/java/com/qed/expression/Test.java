/**
 * 
 */
package com.qed.expression;

import com.google.gson.Gson;
import com.qed.expression.bean.KeyValue;
import com.qed.expression.bean.extendsTest.AccountBalanceDetailReturn;
import com.qed.util.DateUtil;
import com.sun.javafx.binding.IntegerConstant;
import com.sun.javafx.binding.StringFormatter;
import sun.nio.cs.UnicodeEncoder;

import java.math.BigDecimal;
import java.text.*;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author xw37
 *
 */
public class Test {
	public static void main(String[] args) {
		try {


			test45();


		} catch (Exception e) {
			System.out.println(e);
		}

	}

	private static void test45() {
		Stream.iterate(1, i -> i + 1).limit(100).forEach(System.out::println);
	}

	private static void test44() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar  = Calendar.getInstance();
		calendar.set(Calendar.MONTH, 7);
		calendar.set(Calendar.DATE, 29);
		System.out.println(sdf.format(calendar.getTime()));
		calendar.add(Calendar.MONTH, -6);
		System.out.println(sdf.format(calendar.getTime()));
	}

	private static void test43() {
		Gson gson = new Gson();
//		String ss = "{\"data\":[" +
//				"{\"f_balance\":\"1.0000\",\"n_balance\":\"509.0000\",\"plat_no\":\"WZBK-QED-C-20180108\",\"platcust\":\"201801221739360683102694\",\"sub_subject\":\"01\",\"subject\":\"01\",\"t_balance\":\"510.0000\"}," +
//				"{\"f_balance\":\"1.0000\",\"n_balance\":\"499.0000\",\"plat_no\":\"WZBK-QED-C-20180108\",\"platcust\":\"201801221739360683102694\",\"sub_subject\":\"02\",\"subject\":\"01\",\"t_balance\":\"500.0000\"}," +
//				"{\"f_balance\":\"0.0000\",\"n_balance\":\"460.0000\",\"plat_no\":\"WZBK-QED-C-20180108\",\"platcust\":\"201801221739360683102694\",\"sub_subject\":\"01\",\"subject\":\"02\",\"t_balance\":\"460.0000\"}," +
//				"{\"f_balance\":\"0.0000\",\"n_balance\":\"0.0000\",\"plat_no\":\"WZBK-QED-C-20180108\",\"platcust\":\"201801221739360683102694\",\"sub_subject\":\"02\",\"subject\":\"02\",\"t_balance\":\"0.0000\"}" +
//				"]," +
//				"\"order_no\":\"20180126134619195\",\"recode\":\"10000\",\"remsg\":\"处理成功\",\"cc.cc.sign\":\"\"}";
//		AccountBalanceDetailReturn abdr = gson.fromJson(ss, AccountBalanceDetailReturn.class);
//		System.out.println(abdr);
		List<String> list = new ArrayList<>();
		list.add("1");list.add("2");
		list.add("3");list.add("4");
		list.add("5");list.add("6");
		System.out.println(gson.toJson(list));
		list.remove(0);
		list.remove(0);
		System.out.println(gson.toJson(list));
	}

	private static void test42() {
		Gson gson = new Gson();

		Map map = new HashMap(){{put("a","aa");put("b","bb");}};

		String json = gson.toJson(map, Map.class);
		System.out.println(json);

		System.out.println("--------------");

		json = gson.toJson(json, String.class);
		System.out.println(json);

		System.out.println("--------------");

		json = gson.toJson(json, String.class);
		System.out.println(json);

	}

	//斐波那契数列
	private static void test41() {
		int n = 4;
		int result =  ff(n);
		System.out.println("ff ==> " + result);
	}

	private static int ff(int n) {
		if (0 == n) return 0;
		if (1 == n) return 1;
		System.out.println((n-2) + "|" + (n-1));
		return ff(n-2) + ff(n - 1);
	}

	private static void test40() {
		Pattern pattern = Pattern.compile("maxPage = \\d{1,10}");
		Matcher matcher = pattern.matcher("maxPage = 456abc");
		System.out.println(matcher.find());
		System.out.println(matcher.group());
		System.out.println(matcher.start());
//		System.out.println(matcher.start(3));
//		System.out.println(matcher.matches());
//		System.out.println(matcher.start());
//		System.out.println(matcher.lookingAt());
//		System.out.println(matcher.start());
	}

	private static void test39() {
		KeyValue k1 = new KeyValue(3,3);
		KeyValue k2 = new KeyValue(2,3);
		KeyValue k3 = new KeyValue(4,3);
		KeyValue k4 = new KeyValue(5,3);
		KeyValue k5 = new KeyValue(1,3);
		KeyValue k6 = new KeyValue(9,3);
		List<KeyValue> list = new ArrayList();
		list.add(k1);
		list.add(k2);
		list.add(k3);
		list.add(k4);
		list.add(k5);
		list.add(k6);

		List<KeyValue> ll = list.stream().sorted((k,v) -> v.getKey().compareTo(k.getKey())).collect(Collectors.toList());
		for (KeyValue kv : ll) {
			System.out.println(kv.getKey());
		}
	}


	private static void test38() {
		String s = "Beyond - 真的爱你_MQ.mp3";
		String regex = "([\\s+\\S+].*) - ([\\s+\\S+^_].*?)(_MQ|_HQ)\\.mp3";
//		String s = "Beyond - _MQ.mp3";
//		String regex = "([\\s+\\S+].*) - (_MQ|_HQ)?\\.mp3";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(s);
		while (matcher.find()){
			System.out.println(matcher.group(1));
			System.out.println(matcher.group(2));
			System.out.println(matcher.group(3));
		}
	}

	private static void test37() {
		String userAgent = "QEDLoan/3.8.6 (iPhone; iOS 9.3.2; Scale/3.00)";
		System.out.println(userAgent + " : " + VersionUtil.checkVersion(userAgent));
		userAgent = "QEDLoan/4.0 (iPhone; iOS 9.3.2; Scale/3.00)";
		System.out.println(userAgent + " : " + VersionUtil.checkVersion(userAgent));
		userAgent = "QEDLoan/4.0.2 (iPhone; iOS 9.3.2; Scale/3.00)";
		System.out.println(userAgent + " : " + VersionUtil.checkVersion(userAgent));
		userAgent = "QEDLoan/4.1 (iPhone; iOS 9.3.2; Scale/3.00)";
		System.out.println(userAgent + " : " + VersionUtil.checkVersion(userAgent));
	}

	private static void test36() {
		//-7 二进制转换
		//a.7的二进制0111
		//b.取反： 1000
		//c.加1： 1001
		//d.补位（java中int为32位）：11111111111111111111111111111001

		int num = -7;
		System.out.println("origin : "+Integer.toBinaryString(num));
		System.out.println("origin : "+num);
		num = -7;
		num = num << 1;
		//位移1位，末尾补0：11111111111111111111111111110010
		System.out.println("<< : " + Integer.toBinaryString(num));
		System.out.println("<< : " + num);
		num = -7;
		num = num >> 1;
		//位移1位，首位补1（因为是负数）：01111111111111111111111111111100
		System.out.println(">> : " + Integer.toBinaryString(num));
		System.out.println(">> : " + num);
		num = -7;
		num = num >>> 1;
		//位移1位，首位补0（忽略符号）：01111111111111111111111111111100
		System.out.println(">>> : " + Integer.toBinaryString(num));
		System.out.println(">>> : " + num);
	}

	private static void test35() {
		BigDecimal decimal = new BigDecimal("12.3456");
		System.out.println(decimal.doubleValue());
		System.out.println(decimal.setScale(4).doubleValue());
		System.out.println(decimal.setScale(5).doubleValue());

		System.out.println(UUID.randomUUID().toString());

//			test33();

		Double d = new Double("2.5678");
		System.out.println(d);
		System.out.println(String.valueOf(d));
	}

	private static void test34() {
//		String reg = "http://live\\.3g\\.cnfol\\.com/index.cc.cc.php\\?r=money/loadmore&jsoncallback=jsonp\\d{13}&_=\\d{13}&page=\\d{1,4}&class_ids=1538%7C1539%7C3820%7C1549%7C2321%7C1306";
//		String url = "http://live.3g.cnfol.com/index.php?r=money/loadmore&jsoncallback=jsonp1488180587691&_=1488180786121&page=3&class_ids=1538%7C1539%7C3820%7C1549%7C2321%7C1306";
//		if (url.matches(reg)) {
//            System.out.println("ok");
//        } else {
//            System.out.println("fail");
//        }
//
//		reg = "http://live\\.3g\\.cnfol\\.com/index.cc.cc.php?r=money/loadmore&jsoncallback=jsonp\\d{13}&_=\\d{13}&page=\\d{1,4}&class_ids=1538%7C1539%7C3820%7C1549%7C2321%7C1306";
//		url = "http://live.3g.cnfol.com/index.php?r=money/loadmore&jsoncallback=jsonp1488180587691&_=1488180786121&page=3&class_ids=1538%7C1539%7C3820%7C1549%7C2321%7C1306";
//		if (url.matches(reg)) {
//            System.out.println("ok");
//        } else {
//            System.out.println("fail");
//        }

		String urlurl = "http://m.wdzj.com/zhuanlan/guancha/17-3741-1.html";
		String urlurl2 = "http://m.wdzj.com/video/detail/831";
		String regreg = "http://m\\.wdzj\\.com/news/\\w+/\\d{1,10}\\.html";
		if (urlurl.matches(regreg)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		if (urlurl2.matches(regreg)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		regreg = "http://m\\.wdzj\\.com/zhuanlan/\\w+/(\\d|-)+\\.html";
		if (urlurl.matches(regreg)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}if (urlurl2.matches(regreg)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}

	private static void test33() {
		for (int i=0; i<50; i++) {
			System.out.println((i + 1) + " = " + new Random().nextInt(11));
		}
	}

	private static void test32() throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse("2016-02-29");
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.YEAR, 1);
		System.out.println(sdf.format(c.getTime()));

		String a = "abcde我们说的aced";
		String encode = Base64.getEncoder().encodeToString(a.getBytes("utf-8"));
		System.out.println(encode);
		String decode = new String(Base64.getDecoder().decode(encode.getBytes("utf-8")));
		System.out.println(decode);

		Long aa = 1122334455L;
		System.out.println(aa);
		System.out.println(aa + "");
		System.out.println(aa.toString());
		System.out.println(aa.intValue() + "");

		for (int i = 0; i < 30; i++) {
			int random = new Random().nextInt(10);
			System.out.println(random);
		}

		String access_token = "-yApz0Bo4p7RerFC5FlM_pbzanDDNTDyBhG2Wm5lwKUvtyhvbBCFkRU3mPnoxtDaVyWwq0POvacU_bZE9TEvHzwuzU1jhlTBCC8B0FuPvxA";
		String refresh_token = "wKGhwLNCYVNdQGwH30lLDfiHck9SCbseWaLzj1skGkpRJlfji-qWHuyTntrJfBCi7sbNUVtKgpNLJPaR-hakxjRYBWb290ZpvmSl9Ko-ttg";
		String img_url = "http://wx.qlogo.cn/mmopen/kb0HIx0a5S2wlN7FADLZE2wuykTlWoGoB4PrZ9tOfjH0H1w7Kic66ZfyGiaS9ByAOCH7zZ1ISUr2yPVH6CnKO12W99S2UfoePe/64";
		System.out.println(access_token.length());
		System.out.println(refresh_token.length());
		System.out.println(img_url.length());

		double d = 400179.09;
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.println(df.format(d));

		Float f = new Float("494081.09");
		System.out.println(f);

		float ff = 494081.099F;
		Float fff = 494081.099F;
		BigDecimal b = new BigDecimal(String.valueOf(f.floatValue()));
		b.setScale(2, BigDecimal.ROUND_HALF_UP);
		double bb = b.doubleValue();
		System.out.println(bb+"");

		System.out.println(Float.MAX_VALUE);
		System.out.println(Float.MIN_VALUE);

//		float f = 494081.09F;
//		Float ff = new Float("1194081.15234");
//		Float fff = new Float("12345678.9123");
//		BigDecimal a = new BigDecimal(String.valueOf(f));
//		double d = a.doubleValue();
//		System.out.println("d="+d);

//			double dd = 123456789.123456789123456789;
//			System.out.println(dd);

		System.out.println(new Date().getTime());
	}

	private static void test31() {
		String a = "a_abc";
		String b = "b_";
		String c = "c_a_b_";
		String[] arr = a.split("_");
		int i = 0;
		for (String aa : arr) {
			System.out.print(++i + " : " + aa);
			System.out.print(" | ");
		}
		System.out.println("");

		i = 0;
		arr = b.split("_");
		for (String aa : arr) {
			System.out.print(++i + " : " + aa);
			System.out.print(" | ");
		}
		System.out.println("");

		i = 0;
		arr = c.split("_");
		for (String aa : arr) {
			System.out.print(++i + " : " + aa);
			System.out.print(" | ");
		}
		System.out.println("");
	}

	private static String getOperationDurationNew() throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date begin = sdf.parse("2015-01-20");
		Date now = new Date();
		String duration = "";
		if (begin.getTime() > now.getTime()) return duration;
		int year = 0;
		int month = 0;
		int day = 0;

		Calendar beginC = Calendar.getInstance();
		beginC.setTime(begin);
		beginC.set(Calendar.HOUR_OF_DAY, 0);
		beginC.set(Calendar.SECOND, 0);
		beginC.set(Calendar.MINUTE, 0);
		beginC.set(Calendar.MILLISECOND, 0);

		Calendar nowC = Calendar.getInstance();
		nowC.setTime(now);
		nowC.set(Calendar.HOUR_OF_DAY, 0);
		nowC.set(Calendar.SECOND, 0);
		nowC.set(Calendar.MINUTE, 0);
		nowC.set(Calendar.MILLISECOND, 0);

		for(int i=0; i<100; i++) {
			if (beginC.get(Calendar.YEAR) == nowC.get(Calendar.YEAR)) {
				break;
			} else {
				beginC.add(Calendar.YEAR, 1);
				year++;
			}
		}

		if (beginC.getTimeInMillis() > nowC.getTimeInMillis()) {
			beginC.add(Calendar.YEAR, -1);
			year--;
		}

		for(int i=0; i<11; i++) {
			if (beginC.getTimeInMillis() <= nowC.getTimeInMillis()) {
				beginC.add(Calendar.MONTH, 1);
				month++;
			} else {
				break;
			}
		}

		day = DateUtil.countDiffDay(beginC.getTime(), nowC.getTime());

		duration = year + "|" + month + "|" + day;
		return duration;
	}


	private static void test30() {
		String detail = "<p><a href=\"http://www.baidu.com\" target=\"_blank\">abc</a></p>";
		String regex = "(https?:\\/\\/)?([\\da-z\\.-]+)\\.([a-z\\.]{2,6})([\\/\\w \\.-]*)*\\/?";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(detail);
		if (matcher.find()) {
			String url = matcher.group();
			System.out.println("===== url : " + url);
		}
	}

	private static void test29() {
		String code = UUID.randomUUID().toString();
		System.out.println(code);
	}

	private static String test28() {
		String formatName = "";
		List<String> twoCharacterSurnameList = Arrays.asList("欧阳","太史","端木","上官","司马","东方","独孤",
				"南宫","万俟","闻人","夏侯","诸葛","尉迟","公羊","赫连","澹台","皇甫","宗政","濮阳","公冶","太叔","申屠",
				"公孙","慕容","仲孙","钟离","长孙","宇文","司徒","鲜于","司空","闾丘","子车","亓官","司寇","巫马","公西",
				"颛孙","壤驷","公良","漆雕","乐正",
				"宰父","谷梁","拓跋","夹谷","轩辕","令狐","段干","百里","呼延","东郭","南门","羊舌","微生","公户","公玉",
				"公仪","梁丘","公仲","公上","公门","公山","公坚","左丘","公伯","西门","公祖","第五","公乘","贯丘","公皙",
				"南荣","东里","东宫","仲长","子书","子桑","即墨","达奚","褚师","吴铭");

		String[] nameArray = new String[]{"公", "公孙", "公孙只", "老公孙"};


		for (String name : nameArray) {
			if (name.length() == 1) {
				formatName = "*";
			} else if (name.length() == 2) {
				formatName = "*" + name.substring(1);
			} else {
				boolean flag = false;
				for (String tcs : twoCharacterSurnameList) {
					if (name.matches("^" + tcs + "[\\u4e00-\\u9fa5]*")) {
						formatName = name.replace(tcs, "**");
						flag = true;
						break;
					}
				}
				if (!flag)
					formatName = "*" + name.substring(1);
			}
		}
		return formatName;
	}

	private static void test27() {
//		String redeemConfirTime = "T+3";
//		int offDay = 0;
//		if (redeemConfirTime.matches("T\\+[0-9]{1,2}")) {
//			redeemConfirTime = redeemConfirTime.replace("T+", "");
//			offDay = Integer.parseInt(redeemConfirTime);
//		}
//		System.out.println(offDay);

		//正浮点数
		String reg = "[1-9][0-9]*\\.[0-9]*|0\\.[0-9]*[1-9][0-9]*";
		System.out.println("1.3".matches(reg));
		System.out.println("3.4".matches("[0-9]\\.[0-9]"));

		reg = "([1-9][0-9]*\\.[0-9]*|0\\.[0-9]*[1-9][0-9]*)%";
		System.out.println("1.3%".matches(reg));
	}

	/**
	 * 查询收益日期(T+n)
	 * @param date
	 * 			起始日期
	 * @param offDay
	 * 			n (T+n)
	 * @return
	 */
	private static Date getExpectedDate(Date date, int offDay) {
		Date expectedDate = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(date);

		//下午三点，第二个交易日
        if (c.get(Calendar.HOUR_OF_DAY) == 15) {
            c.add(Calendar.DAY_OF_MONTH, 1);
        }

		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.MILLISECOND, 0);

		//起始日期处于当前星期的位置索引
		int dayOfWeekBefore = c.get(Calendar.DAY_OF_WEEK);
		//DAY_OF_WEEK数据处理，修改周一为第一天（1），周日为最后一天（7）
		dayOfWeekBefore = dayOfWeekBefore - 1;
		if (0 == dayOfWeekBefore) dayOfWeekBefore = 7;

		//预计日期的相对索引（不考虑周末的情况）
		int dayOfWeekAfter = dayOfWeekBefore + offDay;

		int offDayAdd = 0; //偏差值


		//计算偏差值（周末）
		int offDayFinal = offDay;
		while (dayOfWeekBefore <= dayOfWeekAfter) {
			offDayAdd = 0;
			for (int i = dayOfWeekBefore; i <= dayOfWeekAfter; i++) {
				if (i % 7 == 6 || i % 7 == 0) {
					offDayAdd++;
				}
			}
			dayOfWeekBefore = dayOfWeekAfter + 1;
			dayOfWeekAfter += offDayAdd;
			offDayFinal += offDayAdd;
		}

		//获取最终预计日期
		c.add(Calendar.DAY_OF_MONTH, offDayFinal);
		expectedDate = c.getTime();

		return expectedDate;
	}


	public static void test26() {
		Date nowDate = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(nowDate);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.MILLISECOND, 0);

		c.add(Calendar.DAY_OF_MONTH, 18);

		System.out.println(c.get(Calendar.DAY_OF_WEEK));
		System.out.println(c.getTime());
	}

	public static void test25() {
		String[] ignoreIps = new String[]{"1.2", "3.4", "5.6"};
		String remoteAddr = "3.4";
		int i = Arrays.binarySearch(ignoreIps, remoteAddr);
		System.out.println(i);
	}

	public static void test24() {
		Integer[] jz = new Integer[]{63,426,507,856,1490,2154,2301,3262,3875,4414,4415,4687,4771,4965,5117,6699,7138,7434,7450,8174,9151,10946,11002,13069,13814,13987,15155,16962,191,826,1911,6257,13827};
		List<Integer> jzList = Arrays.asList(jz);
		System.out.println(jzList.size());
		Integer[] hz = new Integer[]{16,2317,2537,3203,7464,9310,10642,10983,13947,13984,16962,20492,20495,21680,22034,22097,22102,4414,13069};
		List<Integer> hzList = Arrays.asList(hz);

		for (int i = 0; i < jzList.size(); i++) {
			for (int j = 0; j < jzList.size(); j++) {
				if (jzList.get(i) == jzList.get(j) && i != j) {
					System.out.println("jz contains ->" + i);
				}
			}
		}
		System.out.println("-------------------");
		for (int i = 0; i < hzList.size(); i++) {
			for (int j = 0; j < hzList.size(); j++) {
				if (hzList.get(i) == hzList.get(j) && i != j) {
					System.out.println("hz contains ->" + i);
				}
			}
		}
		System.out.println("-------------------");
		for (Integer i : hzList) {
			if (jzList.contains(i)) {
				System.out.println("jz contains hz ->" + i);
			}
		}
		System.out.println("-------------------");
		for (Integer i : jzList) {
			if (hzList.contains(i)) {
				System.out.println("hz contains jz ->" + i);
			}
		}
	}

	private static void test23() {
		Long a = 135L;
		int b = 135;
		System.out.println(a.intValue() == b);
	}
	private static void test22() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar ac = Calendar.getInstance();
		ac.set(Calendar.HOUR_OF_DAY, 0);
		ac.set(Calendar.MINUTE, 0);
		ac.set(Calendar.SECOND, 0);
		ac.set(Calendar.MILLISECOND, 0);
		ac.add(Calendar.YEAR, -1);
		ac.set(Calendar.DAY_OF_MONTH, 1);
		System.out.println(sdf.format(ac.getTime()));

		int a = 5;
		Integer b = new Integer(7);
		Integer c = 9;
		System.out.println((double)a);
		System.out.println((double)b);
		System.out.println((double)c);

		Float f = new Float("5.1234");
		Double d = new Double("5.1234");
		Double d2 = new Double("5.1234");
		Long l = new Long("5");

		System.out.println(d == new BigDecimal(String.valueOf(f)).doubleValue());
		System.out.println(new BigDecimal(String.valueOf(f)).doubleValue() < d.doubleValue());
	}

	private static void test21() {
		String ss = "这是第{0}个测试，测试结果：{1}";
		System.out.println(MessageFormat.format(ss, 1, "成功"));
		ss = "http://pc.51qed.com/invest/success-{0}-{1}.html";
		System.out.println(MessageFormat.format(ss, 12, 34));
	}
	private static void test20() {
		System.out.println(Calendar.getInstance().getTime());
	}

	private static void test19() {
		System.out.println(new StringBuilder("410802201605191234".substring(6,14)).insert(6,"-").insert(4,"-").toString());
	}

	private static  void test18() {
			String a = "abc";
			String b = "abc";
			String c = new String("abc");
			System.out.println(a.equals(b));
			System.out.println(a.equals(c));
			System.out.println(b.equals(c));

			StringBuilder sb = new StringBuilder("01234567");
			System.out.println(sb.substring(0,sb.length() - 1));
	}


	private static void test17() throws Exception {
		String format = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date d1 = sdf.parse("2017-06-23");
		Date d2 = sdf.parse("2016-06-23");
		System.out.println(countDiffDay(d1,d2));


		BigDecimal b = new BigDecimal("1000").multiply(new BigDecimal("0.18"))
				.multiply(new BigDecimal(Integer.toString(24)))
				.multiply(new BigDecimal("100").subtract(new BigDecimal("5"))
						.divide(new BigDecimal("100")))
				.divide(new BigDecimal("365"), 2, BigDecimal.ROUND_FLOOR);
		System.out.println(b);
	}

	private static void test16() {
		test16_test("我","测试","中文","我的天呐");
	}

	private static void test16_test(String ... args) {
		String msg = "测试代码，你输入的分别是\"{0}\"、\"{1}\"和\"{3}\"";
		System.out.println(MessageFormat.format(msg, args));
	}
	private static void test15() {
		String[] l = {"abc"};
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println(sdf.parse("2016-02-16"));
		} catch (Exception e) {
			
		}
		
		Double a = 0.0;
		System.out.println(a == 0);
	}
	
	private static void test14() {
		int a = 123_456_789;
		int b = 010; //八位
		int c = 0x11; //十六位
		int d = 0b11; //二进制
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
	}
	
	private static void test13() {
		Stream<List<Integer>> s = Stream.of(Arrays.asList(1),Arrays.asList(4,5,6),Arrays.asList(2,9,3));
		s.flatMap(x -> x.stream()).sorted((x,y) -> y.compareTo(x)).forEach(System.out::println);
		s = Stream.of(Arrays.asList(1),Arrays.asList(4,5,6),Arrays.asList(2,9,3));
		List<Integer> l = s.flatMap(x -> x.stream()).sorted((x,y) -> y.compareTo(x)).collect(Collectors.toList());
		System.out.println("=======================");
		l.stream().peek(System.out::println).map(x -> x*x).forEach(System.out::println);
	}
	
	private static void test12() {
		IntStream.range(1, 5).forEach(System.out::println);
		System.out.println("==========================");
		IntStream.rangeClosed(1, 5).forEach(System.out::println);
	}
	
	private static void test11() {
		List<String> l = Arrays.asList("1","13","5","0","-9","73","113");
		List<Integer> ll = l.stream().map(Integer::valueOf).collect(Collectors.toList());
		System.out.println(ll.stream().allMatch(x -> x > 10));
		System.out.println(ll.stream().mapToInt(x -> x).max().getAsInt());
	}
	
	private static void test10() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, -90);
		System.out.println(c.getTime());
		c.setTime(new Date());
		c.add(Calendar.DAY_OF_MONTH, -99);
		System.out.println(c.getTime());
	}
	
	private static void test9() {
		Date d1 = Test.getDateFromString("2016-01-25 14:24:11");
		Date d2 = Test.getDateFromString("2015-09-21 12:24:11");
		System.out.println(Test.countDiffDay(d1, d2));
		
		d1 = Test.getDateFromString("2016-01-25 14:24:11");
		d2 = Test.getDateFromString("2016-01-31 15:24:11");
		System.out.println(Test.countDiffDay(d1, d2));
	}
	
	public static Date getDateFromString(String s) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return sdf.parse(s);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static int countDiffDay(Date d1, Date d2) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(d1);
		c1.set(Calendar.HOUR_OF_DAY, 0);
		c1.set(Calendar.SECOND, 0);
		c1.set(Calendar.MINUTE, 0);
		c1.set(Calendar.MILLISECOND, 0); 
		c2.setTime(d2);
		c2.set(Calendar.HOUR_OF_DAY, 0);
		c2.set(Calendar.SECOND, 0);
		c2.set(Calendar.MINUTE, 0);
		c2.set(Calendar.MILLISECOND, 0);
		int returnInt = 0;
		if (c1.before(c2)) { //c1日期小于c2
			while (c1.before(c2)) {
				c1.add(Calendar.DAY_OF_MONTH, 1);
				returnInt++;
			}
		} else {
			while (c2.before(c1)) {
				c2.add(Calendar.DAY_OF_MONTH, 1);
				returnInt++;
			}
		}
		return (returnInt);
	}
	
	private static void test8() {
		Predicate<String> p1 = (s) -> s.contains("a");
		Predicate<String> p2 = (s) -> s.contains("b");
		
		List<String> list = Arrays.asList("abc","ddc","acdb");
		
		list.stream().filter(p1.or(p2)).forEach((s) -> System.out.println(s));
		
		list.stream().filter(p1.or(p2)).collect(Collectors.toList());
		
		list = list.stream().filter(p1.or(p2)).collect(Collectors.toList());
		
		System.out.println(list.size());
	}
	
	private static void test7() {
		List<String> list = Arrays.asList("1","2","3","4","5");
		System.out.println(list.stream().map(Integer::parseInt).reduce((a,b)->a+b).get());
	}
	
	private static void test6() {
		java.util.stream.Stream.generate(Math::random).limit(5).forEach(System.out::println);
	}
	
	private static void test5() {
		Predicate<String> p1 = (s) -> s.contains("a");
		Predicate<String> p2 = (s) -> s.contains("b");
		
		List<String> list = Arrays.asList("abc","ddc","acdb");
		
		list.stream().filter(p1.or(p2)).forEach((s) -> System.out.println(s));
	}
	
	private static void test4() {
		List<String> list = Arrays.asList("a", "b", "c");
		filter(list,(str)->str.equals("b"));
	}
	
	private static void filter(List<String> list, Predicate<String> p) {
		list.forEach(l ->{
			if (p.test(l)) {
				System.out.println("true");
			} else {
				System.out.println("false");
			}
			
		});
	}
	
	private static void test3() {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.forEach(l -> System.out.println(l));
		list.forEach(System.out::print);
	}
	
	private static void test1() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, -90);
		System.out.println(c.get(Calendar.YEAR)+"-"+(c.get(Calendar.MONTH) + 1)+"-"+c.get(Calendar.DATE));
		
		c.setTime(new Date());
		c.add(Calendar.YEAR, 2015);
		c.set(Calendar.MONDAY, 9);
		c.set(Calendar.DATE, 15);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	}
	
	private static void test2() {
		String str1 = "1234";
		String str2 = "23m45";
		System.out.println(str1.matches("\\d{1,3}"));
		System.out.println(str2.matches("\\d*"));
	}
}
