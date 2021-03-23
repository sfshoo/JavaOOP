
public class MemoryAnalysis {
	public static void main(String[] args) {
		
		Person per1 = new Person();
		
		Person per2 = new Person();
		
		per1.setName("张三");
		per1.setAge(20);
		
		per2.setName("李四");
		per2.setAge(30);
		
		per1 = per2;
		per2.setAge(80);
		
		per2.tell();

/*  
 	没有被栈内存指向的堆内存空间就是垃圾空间，所有垃圾都会被
	GC(GarbageCollector 垃圾收集器)定期回收，并释放无用内存空间，
	如果垃圾过多，一定会影响到GC的处理性能，从而降低程序的整体性能，
	所以开发时，垃圾产生的越少越好。
*/

	}
}

class Person {// 定义一个类

	private String name;// 人员的姓名

	private Integer age;// 年龄

	/*
	   方法名称与类名称一致
	   构造方法不允许设置返回值类型，即没有返回值定义
	   构造方法是在new实例化对象的时候调用
	 */
//	定义有参构造函数
	public Person (String n,Integer a) {
		this.name = n;// 为类中的属性赋值
		this.age = a;
	}
	

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void tell() {
		System.out.println("姓名: " + name + ",年龄: " + age);
	}
}

