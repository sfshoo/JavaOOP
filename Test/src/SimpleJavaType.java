class Dept {
	private Long deptno;
	private String name;
	private String loc;
	
	public Dept() {
	}

	public Dept(long deptno, String name, String loc) {
		this.deptno = deptno;
		this.name = name;
		this.loc = loc;
	}

	public String getInfo() {
		return "【部门信息】部门编号:" + this.deptno + " 部门名称:" + this.name + " 部门位置:" + this.loc;
	}

	public Long getDeptno() {
		return deptno;
	}

	public void setDeptno(Long deptno) {
		this.deptno = deptno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

}

public class SimpleJavaType {
	public static void main(String[] args) {
		Dept dept = new Dept(10L, "技术部", "北京");
		System.out.println(dept.getInfo());
	}
}
