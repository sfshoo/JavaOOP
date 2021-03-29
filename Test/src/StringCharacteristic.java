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
		System.out.println(strA == strB);// false
//		想要实现准确的字符串判断，使用public boolean equals(String)
		System.out.println(strA.equals(strB));// true
//		==进行的是数值比较，如果用于对象比较比较的是两个内存地址
//		equals()是类所提供的一个比较方法，可以直接进行字符串内容的判断
		int x = 10;
		int y = 10;
		System.out.println(x == y);// true

//		程序中不会提供字符串这类基本数据类型，提供的只是String类，所以任何使用""定义的字符串常量描述的都是一个String类的匿名对象
//		所谓String类对象的直接赋值，是将一个匿名对象设置一个具体的引用名称，程序中的确没有字符串常量，有的是String匿名对象
		System.out.println("cola".equals(strA));// true
//		字符串常量可以调用equals()方法实现对象相等的判断
//		对象相等判断小技巧：如果某些数据需要用户输入，并且要求这些数据为一个指定的内容情况下建议将字符串常量写在前面
//		String input = "pepsi";
//		System.out.println(input.equals("pepsi"));// true
		String input = null;
//		System.out.println(input.equals("pepsi"));// Exception in thread "main" java.lang.NullPointerException
//		System.out.println("pepsi".equals(input));equals()方法提供了一个回避null的判断，
//		 将字符串常量写在前面,永远都不会出现NullPointerException,字符串常量是匿名对象，已经开辟好了一块堆内存空间

//		两种实例化方式的比较
//		直接赋值操作
		String strC = "cola";
		System.out.println(strA == strC);// true
//		采用直接赋值操作的过程中，对字符串而言可以实现池数据的自动保存，如果再有相同数据定义时，可以减少对象的产生，以提升性能
//		特点：自动将直接赋值的对象保存在字符串池中

//		构造方法赋值操作
		String strD = new String("cola");
		System.out.println(strA == strD);// false
//		此时会开辟两块内存空间，而后只会用一块，另一个由于字符串常量所定义的匿名对象将成为垃圾空间
//		构造方法实例化的对象属于自己专用的内存空间，但是String类中提供了一种手工入池的方法，public String intern()

//		String对象(常量)池
//		Java中对象池分为两种：
//			静态常量池：指的是程序(.class)在加载时会自动将此程序中保存的字符串，普通常量，类和方法的信息等等，全部进行分配
//			动态常量池：当程序(.class)加载之后，可能会有些变量，这时提供的常量池
		String strE = "co" + "la";
		System.out.println(strA == strE);// true
//		strA和strE内容都是静态常量数据(匿名对象),所以在程序加载时会自动处理好相应连接

		String info = "la";
		String strF = "co" + info;
		System.out.println(strA == strF);// false
//		程序在加载时并不确定info的内容，在strF进行字符串连接时info采用的是变量，
//		 变量是可以修改的，所以它不认为strF是一个最终的结果
		
//		Java主方法
//		public static void main(String[] args)
//		public:描述一种访问权限，主方法是一切的开始，开始点一定是公开的
//		static:程序的执行是通过类名称完成的，static表示此方法由类直接调用
//		void:主方法是一切起点，起点一但开始就没有返回的可能
//		main:是系统定义好的方法
//		String[] args:字符串数组，实现程序启动参数的接收
		
//		在程序执时可以设置参数，每个参数之间使用空格分割，若参数本身拥有空格，则必须使用""包装
		for (String arg:args) {
			System.out.println(arg);
		}
		
	}

}
