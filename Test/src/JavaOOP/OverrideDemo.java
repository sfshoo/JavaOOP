package JavaOOP;

class Channel {
	private String info = "cocacola";

	public void connect() {
		System.out.println("【Channel类】进行资源的连接");
	}

	public void fun() {
		this.connect();
	}

	public String getInfo() {
		return this.info;
	}
}

class DatabaseChannel extends Channel {
//	子类定义了与父类同名的属性，叫做属性覆盖
	String info = "pepsi";

//	覆写的方法权限不能比覆写前的权限严格
//	若父类方法是private，对于子类来说是不可见的，此时子类覆写该方法其实就是定义了一个新方法
	public void connect() {
//		super.connect();
		System.out.println("【DatabaseChannel类】进行数据库资源链接");
	}

	public void fun() {
//		this先查找本类的方法和属性，若不存在则查找父类的；super跳过子类，直接查找父类的。
//		this和super都能调用构造方法，this()调用本类构造，super()是子类调用父类构造，两个语句都必须放在首行，所以不能同时出现
//		this可以表示当前对象
		System.out.println(super.getInfo());
		System.out.println(this.info);
	}
}

public class OverrideDemo {
	public static void main(String[] args) {
//		子类定义了与父类方法名称，参数类型以及个数完全相同的方法时就称为方法覆写
		DatabaseChannel channel = new DatabaseChannel();
		channel.fun();
	}
}
