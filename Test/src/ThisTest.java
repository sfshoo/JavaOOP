/*
 * this可以实现三类结构的描述
 * 当前类中的属性：this.属性；
 * 当前类中的方法(普通方法，构造方法)：this(),this.方法名称()；
 * 描述当前对象；
 * */
class Person{
	private String name;
	
	private Integer age;
	
//	调用当前类中的属性
	public Person(String n,Integer a) {
		this.name = n;
		this.age = a;
	}
	
// 在java程序中“{}”是作为一个结构体的边界符，
//	在程序中进行变量（参数，属性）使用时以“{}”作为一个查找边界；所以按照就近取用的原则，
//	此时构造方法未能访问到类中的属性，所以为了标记处类中的属性以及参数的区别，
//	往往会在属性前追加一个this，表示本类属性。
//	只要访问类中的属性时，要加this
	public void tell() {
		System.out.println("姓名:" + name + " 年龄:" + age);
	}
}


public class ThisTest {
	public static void main(String[] args) {
		Person person = new Person("张三", 20);
		person.tell();
	}
	
}
