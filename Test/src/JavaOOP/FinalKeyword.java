package JavaOOP;
//final定义不能被继承的类，不能被覆写的方法，以及常量

// final类
final class Channel {

}

class ChannelA {
	// 常量，常量往往是共享的，使用全局常量来定义public static final
	public static final int ON = 1;
	public static final int OFF = 0;

	// final方法
	public final void connect() {
		ON = 2;
	}
}

class TVChannel extends ChannelA {
	public void connect() {
	}
}

public class FinalKeyword {
	public static void main(String[] args) {
//		String info = "caco";
		final String info = "caco";

		String strA = "cocacola";
		String strB = "co" + info + "la";

//		System.out.println(strA == strB);// false
		System.out.println(strA == strB);// true
	}

}
