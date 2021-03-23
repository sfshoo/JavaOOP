class Message{
	
	private String title;
	
	public Message(String t) {
		this.title = t;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}

class People {// 定义一个类

	private String name;// 人员的姓名

	private Integer age;// 年龄

	/*
	   方法名称与类名称一致
	   构造方法不允许设置返回值类型，即没有返回值定义
	   构造方法是在new实例化对象的时候调用
	 */
//	定义有参构造函数
	public People(Message msg,Integer a) {
		this.name = msg.getTitle();// 为类中的属性赋值
		this.age = a;
	}

	public People() {}

	public void tell() {
		System.out.println("姓名: " + name + ",年龄: " + age);
	}
	
	public Message getInfo() {
		return new Message(name + ":" + age);
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
}

public class ConstuctionMehtod {
	public static void main(String[] args) {
//		People person = new People("张三", 20);// 声明并实例化对象
//		People person = new People();
//		person.tell();
		
		Message msg = new Message("ZL");
		People people = new People(msg, 20);
		msg = people.getInfo();
		System.out.println(msg.getTitle());
	}

}

/*
 * 之前的实例化格式：1、People 2、people = 3、new 4、People();
 * 当前的实例化格式：1、People 2、people = 3、new 4、People("张三",20)
 * People:定义对象的所属类型，类型决定了可以调用的方法
 * people:对象的名称
 * new:开辟一块新的堆内存空间
 * People("张三",20)调用有参构造方法，People()调用无参构造方法
 * 为了满足完整性，每个类都有构造方法，若定义类时未定义构造方法，
 * java会创建一个默认的构造方法
 * */

/*
 * 构造方法为什不返回数据？/ 既然不返回数据，为什么不采用void关键字？
 * 编译器根据代码结构编译处理的，执行的时候也是根据代码结构处理的
 * 若在构造函数上使用了void，那么此结构就与普通方法结构完全相同，
 * 方法与构造方法的区别：构造方法在对象实例化时调用的，普通方法是在实例化之后调用的
 * 
 * 构造方法是一种方法，那就有重载的特点，而构造方法重载的时候只需要考虑参数的类型以及数量
 * 
 * */
