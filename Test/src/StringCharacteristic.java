/*
 * String类之所以能保存字符串是因为定义了一个数组，字符串的每个字符都是保存在数组中
 * JDK1.8之前String保存的是字符数组，1.9之后保存的是字节数组
 * 字符串是对数组包装的一种特殊包装应用，但同时包装的是数组，字符串内容是无法改变的
 * String除了直接赋值，也可以靠构造函数赋值
 * */
public class StringCharacteristic {
	public static void main(String[] args) {
		String str = new String("cosuef");
//		String str = "cosidf";
		System.out.println(str);
		String strA = "cola";
		String strB = new String("cola");
		System.out.println(strA==strB);//false
//		想要实现准确的字符串判断，使用public boolean equals(String)
		System.out.println(strA.equals(strB));
//		==进行的是数值比较，如果用于对象比较比较的是两个内存地址
//		equals()是类所提供的一个比较方法，可以直接进行字符串内容的判断
		int x= 10;
		int y = 10;
		System.out.println(x==y);
		System.out.println("cola".equals(strA));
//		所谓String类对象的直接赋值，是将一个匿名对象设置一个具体的引用名称，
//		 程序中的确没有字符串常量，有的是String匿名对象
//		小技巧：如果某些数据需要用户输入，并且要求这些数据为一个指定的内容情况下建议将字符串常量写在前面
	
//		直接赋值的实例化模式
	}
	
}
