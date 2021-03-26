/*
 * 数据表与简单java类的基本映射如下
 *  数据实体表设计 = 类的定义；
 *  表的字段 = 类的成员属性；
 *  表的外键 = 引用关联；
 *  表的一行记录 = 类的一个实体记录；
 *  表的多行记录 = 对象数组；
 * 
 * 多种关联关系
 *  一个部门有多个雇员
 *  一个雇员属于一个部门
 *  一个雇员属于一个领导
 *  
 *  根据部门信息以下内容
 *   一个部门的完整信息
 *   一个部门下所有雇员的信息
 *   一个雇员对应的领导的信息
 *  根据雇员信息获得以下内容
 *   雇员所属部门的完整信息
 *   雇员所属领导的完整信息
 *   
 * 	解决表与java简单类之间映射的步骤，先抛弃所有的关键字，
 *   创建类的基本组成，再通过引用配置关联字段的关系
 * */

class Deptm {
	private long deptno;
	private String dname;
	private String loc;
	private Empl[] emps;

	public Deptm(long deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}

	public Deptm() {
	}

	public String getInfo() {
		return "【部门信息】部门编号：" + this.deptno + "、部门名称：" + this.dname + "、部门位置：" + this.loc;
	}

	public void setEmps(Empl[] emp) {
		this.emps = emp;
	}

	public Empl[] getEmps() {
		return this.emps;
	}
}

class Empl {
	private long empno;
	private String ename;
	private String job;
	private double sal;
	private double comm;
	private Deptm dept;
	private Empl mgr;

	public Empl(long empno, String ename, String job, double sal, double comm) {
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.sal = sal;
		this.comm = comm;
	}

	public Empl() {
	}

	public String getInfo() {
		return "【雇员信息】雇员编号：" + this.empno + "、雇员姓名：" + this.ename + "、雇员岗位：" + this.job + "、基本工资：" + this.sal + "、佣金："
				+ this.comm;
	}

	public void setDept(Deptm dept) {
		this.dept = dept;
	}

	public void setMgr(Empl emp) {
		this.mgr = emp;
	}

	public Deptm getDept() {
		return this.dept;
	}

	public Empl getMgr() {
		return this.mgr;
	}

}

class Item {
	private Long id;
	private String title;
	private SubItem[] subitem;

	public Item(Long id, String title) {
		this.id = id;
		this.title = title;
	}

	public String getInfo() {
		return "【分类信息】iid:" + this.id + "、title:" + this.title;
	}

	public void setSubItem(SubItem[] subitem) {
		this.subitem = subitem;
	}

	public SubItem[] getSubItem() {
		return this.subitem;
	}
}

class SubItem {
	private Long sid;
	private String title;
	private Item item;

	public SubItem(Long sid, String title) {
		this.sid = sid;
		this.title = title;
	}

	public String getInfo() {
		return "【子分类信息】sid:" + this.sid + "、title" + this.title;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Item getItem() {
		return this.item;
	}
}

class Member {
	private String mid;
	private String name;
	private Product[] product;
	private Role[] roles;

	public Member(String mid, String name) {
		this.mid = mid;
		this.name = name;
	}

	public String getInfo() {
		return "【用户信息】mid:" + this.mid + "、name:" + this.name;
	}

	public void setProduct(Product[] product) {
		this.product = product;
	}

	public Product[] getProduct() {
		return this.product;
	}

	public void setRoles(Role[] role) {
		this.roles = role;
	}

	public Role[] getRoles() {
		return this.roles;
	}
}

class Product {
	private long pid;
	private String title;
	private double price;
	private Member[] member;

	public Product(long pid, String title, double price) {
		this.pid = pid;
		this.title = title;
		this.price = price;
	}

	public String getInfo() {
		return "【商品信息】pid:" + this.pid + "、titlt:" + this.title + "、price:" + this.price;
	}

	public void setMember(Member[] member) {
		this.member = member;
	}

	public Member[] getMember() {
		return this.member;
	}
}

class Role {
	private long rid;
	private String title;
	private Member[] members;
	private Privilege[] privileges;

	public Role(long rid, String title) {
		this.rid = rid;
		this.title = title;
	}

	public String getInfo() {
		return "【角色信息】rid:" + this.rid + "、title:" + this.title;
	}

	public void setMembers(Member[] member) {
		this.members = member;
	}

	public Member[] getMembers() {
		return this.members;
	}

	public void setPrivileges(Privilege[] privilege) {
		this.privileges = privilege;
	}

	public Privilege[] getPrivileges() {
		return this.privileges;
	}
}

class Privilege {
	private long pid;
	private String title;
	private Role role;

	public Privilege(long pid, String title) {
		this.pid = pid;
		this.title = title;
	}

	public String getInfo() {
		return "【权限信息】pid:" + this.pid + "、title:" + this.title;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Role getRole() {
		return this.role;
	}
}

public class FormAndMapping {
	public static void main(String[] args) {
//		实际开发过程分为两步骤：
//		 根据表的结构进行对象的配置
//		 根据需求通过结构获取数据

//		第一步，根据关系进行类的定义
		Deptm dept = new Deptm(10, "财务部", "上海");
		Empl empA = new Empl(7369L, "Smith", "CLERK", 800.00, 0.0);
		Empl empB = new Empl(7566L, "Ford", "MANAGER", 2450.00, 0.0);
		Empl empC = new Empl(7839L, "King", "PRESIDENT", 5000.00, 0.0);
//		第二步，为对象进行关联配置
		empA.setDept(dept);// 设置雇员与部门的关系
		empB.setDept(dept);
		empC.setDept(dept);
		empA.setMgr(empB);// 设置雇员与领导的关系
		empB.setMgr(empC);
		dept.setEmps(new Empl[] { empA, empB, empC });// 部门与雇员
//		第三步，根据关系获取数据
		System.out.println(dept.getInfo());
		System.out.println("----------------------------------------------------");

		for (int i = 0; i < dept.getEmps().length; i++) {
			System.out.println(dept.getEmps()[i].getInfo());
			if (dept.getEmps()[i].getMgr() != null) {
				System.out.println(dept.getEmps()[i].getMgr().getInfo());
			}
		}
		System.out.println("----------------------------------------------------");
		System.out.println(empB.getDept().getInfo());
		System.out.println("----------------------------------------------------");
//		一对多映射
		Item item = new Item(1L, "图书");
		SubItem[] subitem = new SubItem[] { new SubItem(10L, "编程图书"), new SubItem(10L, "图形图像类图书") };
		item.setSubItem(subitem);

		for (int i = 0; i < subitem.length; i++) {
			subitem[i].setItem(item);
		}

		System.out.println(item.getInfo());
		for (int i = 0; i < item.getSubItem().length; i++) {
			System.out.println("\t|-" + item.getSubItem()[i].getInfo());
		}
		System.out.println("----------------------------------------------------");

//		多对多映射
//		第一步，根据结构设置对象数据
		Member memberA = new Member("sdf", "张三");
		Member memberB = new Member("rgv", "李四");
		Product productA = new Product(1L, "Java开发图书", 79.8);
		Product productB = new Product(2L, "非常大的B耳机", 2400.0);
		Product productC = new Product(3L, "小米手机", 3000.0);
		memberA.setProduct(new Product[] { productA, productB, productC });
		memberB.setProduct(new Product[] { productA });
		productA.setMember(new Member[] { memberA, memberB });
		productB.setMember(new Member[] { memberA });
		productC.setMember(new Member[] { memberA });
//		第二步，根据要求获取数据
		System.out.println("-------------------根据用户查看浏览商品信息------------------");
		System.out.println(memberA.getInfo());
		for (int i = 0; i < memberA.getProduct().length; i++) {
			System.out.println("\t|-" + memberA.getProduct()[i].getInfo());
		}
		System.out.println("-------------------根据商品找到被浏览的记录------------------");
		System.out.println(productA.getInfo());
		for (int i = 0; i < productA.getMember().length; i++) {
			System.out.println("\t|-" + productA.getMember()[i].getInfo());
		}

		System.out.println("----------------------------------------------------");
		Role roleA = new Role(1L, "系统服务");
		Role roleB = new Role(2L, "备份管理");
		Role roleC = new Role(3L, "人事管理");
		Privilege priA = new Privilege(1000L, "系统初始化");
		Privilege priB = new Privilege(1001L, "系统还原");
		Privilege priC = new Privilege(1002L, "系统还原");
		Privilege priD = new Privilege(1003L, "备份员工数据");
		Privilege priE = new Privilege(1004L, "备份部门数据");
		Privilege priF = new Privilege(1005L, "备份公文数据");
		Privilege priG = new Privilege(1006L, "增加员工");
		Privilege priH = new Privilege(1007L, "编辑员工");
		Privilege priI = new Privilege(1008L, "浏览员工");
		Privilege priJ = new Privilege(1009L, "员工离职");

		roleA.setPrivileges(new Privilege[] { priA, priB, priC });
		roleB.setPrivileges(new Privilege[] { priD, priE, priF });
		roleC.setPrivileges(new Privilege[] { priG, priH, priI, priJ });

		priA.setRole(roleA);
		priB.setRole(roleA);
		priC.setRole(roleA);
		priD.setRole(roleB);
		priE.setRole(roleB);
		priF.setRole(roleB);
		priG.setRole(roleC);
		priH.setRole(roleC);
		priI.setRole(roleC);
		priJ.setRole(roleC);

		roleA.setMembers(new Member[] { memberA, memberB });
		roleB.setMembers(new Member[] { memberA, memberB });
		roleC.setMembers(new Member[] { memberB });
		memberA.setRoles(new Role[] { roleA, roleB });
		memberB.setRoles(new Role[] { roleA, roleB, roleC });

		System.out.println("-------------------通过用户查找权限------------------");
		System.out.println(memberB.getInfo());
		for (int i = 0; i < memberB.getRoles().length; i++) {
			System.out.println("\t|-" + memberB.getRoles()[i].getInfo());
			for (int j = 0; j < memberB.getRoles()[i].getPrivileges().length; j++) {
				System.out.println("\t\t|-" + memberB.getRoles()[i].getPrivileges()[j].getInfo());
			}
		}
		System.out.println("-------------------通过角色查找信息------------------");
		System.out.println(roleB.getInfo());
		System.out.println("-------------------浏览角色下所有的权限------------------");
		for (int i = 0; i < roleB.getPrivileges().length; i++) {
			System.out.println("\t|-" + roleB.getPrivileges()[i].getInfo());
		}
		System.out.println("-------------------浏览角色下的所有用户------------------");
		for (int i = 0; i < roleB.getMembers().length; i++) {
			System.out.println("\t|-" + roleB.getMembers()[i].getInfo());
		}
	}
}
