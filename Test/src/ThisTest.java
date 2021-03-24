import java.math.BigDecimal;

/*
 * this可以实现三类结构的描述
 * 当前类中的属性：this.属性；
 * 当前类中的方法(普通方法，构造方法)：this(),this.方法名称()；
 * 描述当前对象；
 * */
class PersonAlpha {
	private String name;

	private Integer age;

	public PersonAlpha() {
		System.out.println("一个新的Person类对象实例化了");
	}

	public PersonAlpha(String name) {
		this();// 调用本类无参构造
		this.setName(name);
	}

//	调用当前类中的属性
//	public Person(String n,Integer a) {
//		this.name = n;
//		this.age = a;
//	}

// 在java程序中“{}”是作为一个结构体的边界符，
//	在程序中进行变量（参数，属性）使用时以“{}”作为一个查找边界；所以按照就近取用的原则，
//	此时构造方法未能访问到类中的属性，所以为了标记处类中的属性以及参数的区别，
//	往往会在属性前追加一个this，表示本类属性。
//	只要访问类中的属性时，要加this

	public PersonAlpha(String n, Integer a) {
		this(n);// 调用单参构造方法
		this.setAge(a);
	}

// 构造方法必须在实例化新对象时调用，所以this()语句只允许放在构造函数的首行
// 构造函数互相调用时，注意留出口

	public void tell() {
		System.out.println("姓名:" + name + " 年龄:" + age);
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

class Emp {

	private Long id;

	private String name;

	private String department;

	private double salary;

	public Emp() {
		this(1000L, "无名氏", null, 0.0);
	}

	public Emp(Long id) {
		this(id, "新员工", "未定", 0.0);
	}

	public Emp(Long id, String name, String dept) {
		this(id, name, dept, 2500.00);
	}

	public Emp(Long id, String name, String dept, double salary) {
		this.id = id;
		this.name = name;
		this.department = dept;
		this.salary = salary;
	}

	public String getInfo() {
		return "雇员编号：" + this.id + "、雇员姓名：" + this.name + "、所在部门：" + this.department + "、基本工资：" + this.salary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}

public class ThisTest {
	public static void main(String[] args) {
		PersonAlpha personalpha = new PersonAlpha("张三", 20);
		personalpha.tell();

		Emp emp = new Emp(9527L, "Smith", "Accounting");
		System.out.println(emp.getInfo());
		
	}

}
