class PersonBeta {
	private String name;
	private int age;
	static String country = "中华民国";
	/*
	 * static虽然定义在类中，但是并不受类实例化对象的控制，
	 *  static属性可以在没有实例化对象的时候使用
	 * */

	/*
	 * 在类设计的时候首选一定是非static属性(95%)，而考虑到公共信息存储的情况
	 *  才会使用static属性，非static属性必须在实例化对象产生后才能使用，
	 *  static属性可以在没有实例化对象的产生时候访问
	 * */
	public PersonBeta() {}
	
	public PersonBeta(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getInfo() {
		return "姓名：" + this.name + " 年龄：" + this.age + " 国家：" + PersonBeta.country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	/*
	 * static方法只能调用static属性或static方法
	 * 非static方法允许调用static熟悉或static方法
	 *  所有的static属性和方法可以在没有实例化对象的情况下访问，所有非static属性和方法必须在有实例化对象情况下访问
	 * */
	public static String getCountry() {
		return country;
	}

	public static void setCountry(String country) {
		PersonBeta.country = country;
	}

}

//	static定义的属性和方法都不是代码编写之初所考虑的内容，
//	 只有在回避实例化对象调用并且描述公共属性的情况下才考虑使用static定义的属性或方法

public class StaticPropAndMethod {
	public static void main(String[] args) {
		System.out.println(PersonBeta.country);
		PersonBeta perA = new PersonBeta("张三", 10);
		PersonBeta perB = new PersonBeta("李四", 15);
		PersonBeta perC = new PersonBeta("王五", 16);
		perA.setCountry("中华人民共和国");// static属性最好由类名称调用
		System.out.println(perA.getInfo() + "\n" + perB.getInfo() + "\n" + perC.getInfo());
	}

}
