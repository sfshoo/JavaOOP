package JavaOOP;

class Person {
	private String name;
	private String addr;
	private char sex;
	private int age;

	public Person() {
	}

	public Person(String name, String addr) {
		this.name = name;
		this.addr = addr;
	}

	public Person(String name, String addr, char sex, int age) {
		this(name, addr);
		this.sex = sex;
		this.age = age;
	}

	public String getInfo() {
		return "姓名：" + this.name + "，地址：" + this.addr + "，性别：" + this.sex + "，年龄：" + this.age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}

class Student extends Person {
	private double math;
	private double english;

	public Student() {
	}

	public Student(double math, double english) {
// 		在进行继承关系定义时，实际上子类可以继承父类所有的操作结构，但是对于私有操作属于隐式继承，所有非私有操作属于显示继承
//		继承一旦发生，父类所有操作都可以被子类使用，并且在程序中没有考虑现实生活中败家子概念，子类至少会维持父类现有的功能
		this.math = math;
		this.english = english;
	}

	public Student(String name, String addr, char sex, int age, double math, double english) {
// 		子类构造调用父类构造方法，该句只允许放在构造方法首行，在默认化情况只会调用父类的无参构造
//		实例化子类对象的同时一定会实例化父类对象，目的是为了所有的属性可以进行空间分配
		super(name, addr, sex, age);
//		this.school = school;
		this.math = math;
		this.english = english;
	}

	public String getInfo() {
		return super.getInfo() + "，数学成绩：" + this.math + "，英语成绩：" + this.english;
	}

	public double getMath() {
		return math;
	}

	public void setMath(double math) {
		this.math = math;
	}

	public double getEnglish() {
		return english;
	}

	public void setEnglish(double english) {
		this.english = english;
	}

}

class Employee {
	private String name;
	private int age;
	private String sex;

	public Employee() {
	}

	public Employee(String name, int age, String sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public String getInfo() {
		return "姓名：" + this.name + "，年龄：" + this.age + ",性别：" + this.sex;
	}
}

class Manager extends Employee {
	private String job;
	private double salary;

	public Manager() {
	}

	public Manager(String name, int age, String sex, String job, double salary) {
		super(name, age, sex);
		this.job = job;
		this.salary = salary;
	}

	public String getInfo() {
		return "【管理层】：" + super.getInfo() + "，职务：" + this.job + "，年薪：" + this.salary;
	}
}

class Staff extends Employee {
	private String dept;
	private double salary;

	public Staff() {
	}

	public Staff(String name, int age, String sex, String dept, double salary) {
		super(name, age, sex);
		this.dept = dept;
		this.salary = salary;
	}

	public String getInfo() {
		return "【职员】：" + super.getInfo() + "，部门：" + this.dept + "，工资：" + this.salary;
	}
}

//class StringUtil {
//	public static int[] count(String string) {
//		int[] countDate = new int[2];
//		char[] array = string.toCharArray();
//		for (int i = 0; i < array.length; i++) {
//			if (array[i] == 'n' || array[i] == 'N') {
//				countDate[0]++;
//			}
//			if (array[i] == 'o' || array[i] == 'O') {
//				countDate[1]++;
//			}
//		}
//		return countDate;
//	}
//}

class StringUtil {
	private String content;

	public StringUtil(String content) {
		this.content = content;
	}

	public String getContent() {
		return this.content;
	}

	public String getInfo() {
		return this.getContent();
	}
}

class StringCount extends StringUtil {
	private int nCount;
	private int oCount;

	public StringCount(String content) {
		super(content);
		this.countChar();
	}

	public void countChar() {
		char[] data = super.getContent().toCharArray();
		for (int i = 0; i < data.length; i++) {
			if (data[i] == 'n' || data[i] == 'N') {
				this.nCount++;
			}

			if (data[i] == 'o' || data[i] == 'O') {
				this.oCount++;
			}
		}
	}

	public int getNCount() {
		return this.nCount;
	}

	public int getOCount() {
		return this.oCount;
	}

	public String getInfo() {
		return "n的个数：" + this.nCount + ",o的个数：" + this.oCount;
	}
}

class Array {
	private int[] data;
	private int foot;

	public Array(int length) {
		if (length > 0) {
			this.data = new int[length];
		} else {
			this.data = new int[1];
		}
	}

	public boolean add(int num) {
		if (this.foot < this.data.length) {
			this.data[this.foot++] = num;
			return true;
		}
		return false;
	}

	public void increament(int num) {
		int[] newData = new int[this.data.length + num];
		System.arraycopy(this.data, 0, newData, 0, data.length);
		this.data = newData;
	}

	public int[] getData() {
		return this.data;
	}

}

class SortArray extends Array {
	public SortArray(int len) {
		super(len);
	}

	public int[] getData() {
		java.util.Arrays.sort(super.getData());
		return super.getData();
	}
}

public class Inherit {
	public static void main(String[] args) {
		Student stu = new Student("张三", "天安门", '男', 17, 78.99, 98.99);
		System.out.println(stu.getInfo());

		Manager manager = new Manager("张三", 38, "女", "主管", 150000);
		Staff staff = new Staff("李四", 18, "男", "出纳", 3000);
		System.out.println(manager.getInfo());
		System.out.println(staff.getInfo());

		String str = "want you know one thing";
//		int[] result = StringUtil.count(str);
//		System.out.println("n的数量：" + result[0]);
//		System.out.println("o的数量：" + result[1]);

		StringCount sc = new StringCount(str);
		System.out.println(sc.getInfo());

		SortArray arr = new SortArray(5);
		System.out.println(arr.add(5));
		System.out.println(arr.add(9));
		System.out.println(arr.add(3));
		System.out.println(arr.add(0));
		System.out.println(arr.add(55));
		System.out.println(arr.add(11));
		arr.increament(3);
		System.out.println(arr.add(22));
		System.out.println(arr.add(14));
		System.out.println(arr.add(8));

		int[] result = arr.getData();
		for (int temp : result) {
			System.out.print(temp + "、");
		}

	}

}
