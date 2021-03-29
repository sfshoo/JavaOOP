
public class StringCommonMethod {
	public static void main(String[] args) {
//		JavaDoc
//		在JDK1.9前，所有的常用类库都会在JDK启动时进行全部加载，这样性能会有所下降，
//		 1.9开始提供有模块化设计，将一些程序类放在了不同的模块中

//		类完整定义
//		类相关说明信息
//		成员属性摘要
//		构造方法摘要(看到"Deprecated"描述表示方法不建议使用)
//		方法摘要，左为返回值，右为方法名称及参数
//		方法详细说明

//		字符串与字符转换
//		观察charAt方法
		String str = "cokecola";
		char c = str.charAt(0);
		System.out.println(c);

//		实现字符串与字符数组之间的转换
		char[] result = str.toCharArray();
		System.out.println(result);
		for (int i = 0; i < result.length; i++) {
			result[i] -= 32;
		}
		String newStr = new String(result);
		System.out.println(newStr);
		System.out.println(new String(result, 0, 3));

//		字符串数据检查
		System.out.println(isNumber(str) ? "由数字组成" : "不是由数字组成");
		System.out.println(isNumber("123") ? "由数字组成" : "不是由数字组成");

//		字符串与字节转换
//		主要目的是二进制数据传输，或者进行编码转换
//		public String(byte[] bytes)// 字节数组转换为字符串
//		public String(byte[] bytes,int offset, int length)// 部分字节数组转换为字符串
//		public byte[] getBytes()// 字符串转换为字节数组
//		public byte[] getBytes(String charsetName) throws UnsupportedEncodingException// 编码转换

//		观察字节与字符串转化
		byte[] data = str.getBytes();
		for (int i = 0; i < data.length; i++) {
			data[i] -= 32;
		}
		System.out.println(new String(data));

//		字符串比较
//		public boolean equals(Object anObject)// 区分大小写比较
//		public boolean equalsIgnoreCase(Object anObject)// 不区分大小写比较
//		public int compareTo(String anotherString)区分比较大小，返回值int，大于0就是大于，小于0就是小于，0就是等于
//		public int compareTo(String anotherString)不区分大小比较
		String strA = "COKECOlA";
		System.out.println(str.equals(strA));// false
		System.out.println(str.equalsIgnoreCase(strA));// true
		System.out.println(str.compareTo(strA));// 32
		System.out.println(strA.compareTo(str));// -32
		System.out.println(str.compareToIgnoreCase(strA));// 0

//		字符串查找
//		public boolean contains(String string)// 判断字符串是否存在,JDK1.5后加入
//		public int indexOf(String str)// 从头查找指定字符串的位置
//		public int indexOf(String str,int fromIndex)// 从指定位置查找指定字符串
//		public int lastIndexOf(String str)// 由后向前查找指定字符串的位置
//		public int lastIndexOf(String str,int fromIndex)// 从指定位置从后向前查找指定字符串
//		public boolean startsWith(String prefix)// 判断是否以指定的字符串开始
//		public boolean startsWith(String prefix,int toffset)// 由指定位置判断是否以指定字符串开始
//		public boolean endsWith(String suffix)// 判断是否以指定字符串结尾

		String strB = "la";
		System.out.println(str.contains(strB));// true
		System.out.println(str.indexOf("ke"));// 2
		System.out.println(str.indexOf("hello"));// -1
		System.out.println(str.indexOf("ke", 1));// 2
		System.out.println(str.lastIndexOf("co"));// 4
		System.out.println(str.lastIndexOf("co", 3));// 0

//		判断是否以某字符串开头或结尾
		String strC = "!!@@##$$%%";
		System.out.println(strC.startsWith("!!"));// true
		System.out.println(strC.endsWith("%%"));// true
		System.out.println(strC.startsWith("##", 4));// true

//		字符串替换
//		public String replaceAll(String regex,String replacement)// 替换全部
//		public String replaceFirst(String regex,String replacement)// 替换首个
		System.out.println(str.replaceAll("co", "xx"));// xxkexxla
		System.out.println(str.replaceFirst("co", "xx"));// xxkecola

//		字符串拆分
//		public String[] split(String regex)// 按照指定字符串全部拆分
//		public String[] split(String regex,int index)// 将字符串拆成指定个数
		String strD = "hello world hello China";
		for (int i = 0; i < strD.split(" ").length; i++) {
			System.out.println(strD.split(" ")[i]);
		}
		// hello
		// world
		// hello
		// China

		for (int i = 0; i < strD.split(" ", 3).length; i++) {
			System.out.println(strD.split(" ", 3)[i]);
		}
		// hello
		// world
		// hello China

//		可能会遇到拆不了的情况，因为正则表达式的缘故，这时使用\\进行转义
		String strE = "192.168.0.1";
		String[] resultA = strE.split("\\.");
		for (int i = 0; i < strE.split("\\.").length; i++) {
			System.out.println(strE.split("\\.")[i]);
		}
		// 192
		// 168
		// 0
		// 1

//		字符串截取
//		public String substring(int beginIndex)// 由指定位置开始截取到结尾
//		public String substring(int beginIndex, int endIndex)// 截取范围内子字符串
		System.out.println(strE.substring(4));// 168.0.1
		System.out.println(strE.substring(4, 7));// 168
		String user = "China-photo-张三.jpg";
		int beginIndex = user.indexOf("-", user.indexOf("photo")) + 1;
		int endIndex = user.lastIndexOf(".");
		System.out.println(user.substring(beginIndex, endIndex));// 张三

	}

	public static boolean isNumber(String string) {
		char[] result = string.toCharArray();
		for (int i = 0; i < result.length; i++) {
			if (result[i] < '0' || result[i] > '9') {
				return false;
			}
		}
		return true;
	}

}
