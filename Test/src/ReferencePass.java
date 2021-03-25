class Personb {
	private String name;
	private int age;
	private Cara cara;
	private Personb[] personb;

	public Personb(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void getInfo() {
		System.out.println("姓名：" + this.name + " 年龄：" + this.age);
	}

	public Personb[] getPersonb() {
		return personb;
	}

	public void setPersonb(Personb[] personb) {
		this.personb = personb;
	}

	public void setCara(Cara cara) {
		this.cara = cara;
	}

	public Cara getCara() {
		return this.cara;
	}
}

class Cara {
	private String name;
	private double price;
	private Personb personb;

	public Cara(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public void getInfo() {
		System.out.println("汽车品牌型号：" + name + "价格：" + price);
	}

	public Personb getPerson() {
		return personb;
	}

	public void setPersonb(Personb personb) {
		this.personb = personb;
	}

}

public class ReferencePass {
	public static void main(String[] args) {
//		声明对象设置关系
		Personb personb = new Personb("张三", 28);
		Cara cara = new Cara("劳斯莱斯", 8000000);
		personb.setCara(cara);
		cara.setPersonb(personb);
//		根据关系获取数据
		personb.getCara().getInfo();
		cara.getPerson().getInfo();

		Personb childA = new Personb("李四", 10);
		Personb childB = new Personb("王五", 20);
		childA.setCara(new Cara("BMW X1", 1000000));
		childB.setCara(new Cara("法拉利", 20000000));
		personb.setPersonb(new Personb[] { childA, childB });
		for (int i = 0; i < personb.getPersonb().length; i++) {
			personb.getPersonb()[i].getCara().getInfo();
		}

	}
}
