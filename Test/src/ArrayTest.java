/*一维数组
 * 数组动态初始化，初始化后数组每个元素的保存内容为其对应数据类型的默认值
 *  声明并初始化数组
 *   数据类型 数组名称[] = new 数据类型[长度]
 *   数据类型[] 数组名称 = new 数据类型[长度]
 *
 * 数组静态初始化，在数组定义时就为其设置好内容
 *  简化格式：数据类型 数组名称[] = {数据1，数据2，数据3}
 *  完整格式：数据类型 数组名称[] = new 数据类型[]{数据1，数据2，数据3}
 * 
 *二维数组
 * 动态数组：
 *  数据类型[][] 数组名称 = new 数据类型[长度][长度]
 * 静态数组：
 * 	数据类型[][] 数据名称 = new 数据类型[][] {{},{},{}}
 **/
class Persona {
	private String name;
	private int age;

	public Persona(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getInfo() {
		return "姓名： " + this.name + " 年龄：" + this.age;
	}
}

class ArrayUtil {// 一个操作数组的工具类
	private int sum;
	private double avg;
	private int max;
	private int min;

	// 计算数组内容的和、均值、最大值、最小值
	public void getData(int[] array) {
		this.max = array[0];
		this.min = array[0];

		for (int i = 0; i < array.length; i++) {
			this.sum += array[i];

			if (this.max < array[i]) {
				this.max = array[i];
			}

			if (this.min > array[i]) {
				this.min = array[i];
			}
		}

		this.avg = this.sum / array.length;
	}

	// 数组排序
	public static void sortArray(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int x = array[j];
					array[j] = array[j + 1];
					array[j + 1] = x;
				}
			}
		}
	}

	// 数组反转
	public static int[] reverseArrayAlpha(int[] array) {
		int[] arrayReversal = new int[array.length];
		int foot = array.length - 1;
		for (int i = 0; i < array.length; i++) {
			arrayReversal[foot--] = array[i];
		}
		array = arrayReversal;
		return array;
	}

	public static void reverseArrayBeta(int[] array) {
		int center = array.length / 2;
		int head = 0;
		int tail = array.length - 1;
		for (int j = 0; j <= center; j++) {
			int x = array[head];
			array[head] = array[tail];
			array[tail] = x;
			head++;
			tail--;
		}
	}

	// 数组拷贝
	public static void copyArray(int[] src, int sindex, int[] dsc, int dindex, int len) {
		for (int i = 0; i < len; i++) {
			dsc[dindex++] = src[sindex++];
		}
	}

	// 可变参数
	public static int sum(int... data) {
		int sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		return sum;
	}

	public int getSum() {
		return sum;
	}

	public double getAvg() {
		return avg;
	}

	public int getMax() {
		return max;
	}

	public int getMin() {
		return min;
	}

}

public class ArrayTest {
	public static void main(String[] args) {
		int[] data = new int[] { 10, 20, 30 };// 静态初始化
//		int[] data = new int[3];// 动态初始化
//		data[0] = 11;// 为数组设置内容
//		data[1] = 35;
//		data[2] = 101;
		int[] temp = data;// 引用传递，temp引用指向data所指向的堆内存
		temp[0] = 99;

		// 一维数组
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}

		// foreach
		// 好处是避免下标操作
		for (int numb : data) {// 自动循环，将data每个元素交给num
			System.out.println(numb);
		}

		// 二维数组
		int[][] array = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(array[i][j]);
			}
			System.out.println();
		}

		// foreach
		for (int[] arrayI : array) {
			for (int arrayJ : arrayI) {
				System.out.print(arrayJ + "、");
			}
			System.out.println();
		}

		// 数组与方法
//		int[] dataAlpha = arrayInitialize();
//		arrayUpdate(dataAlpha);
//		arrayPrint(dataAlpha);

		int[] dataBeta = new int[] { 1, 2, 3, 4, 5 };
		ArrayUtil arrayUtil = new ArrayUtil();
		arrayUtil.getData(dataBeta);

		System.out.println("数组内容总和： " + arrayUtil.getSum());
		System.out.println("数组内容均值： " + arrayUtil.getAvg());
		System.out.println("数组内容最大值: " + arrayUtil.getMax());
		System.out.println("数组内容最小值: " + arrayUtil.getMin());
//		主方法所在的类是主类，主类不希望涉及过于复杂的功能，
//		 所以开发过程中，主方法相当于是客户端，对于客户端代码尽量简单一点，
//		 这时候最好的做法是将一系列的计算过程交给程序类完成。

//		数组排序
		int[] dataGarma = new int[] { 9, 6, 3, 8, 5, 2, 7, 4, 1 };
		ArrayUtil.sortArray(dataGarma);
		printArray(dataGarma);

//		数组反转
		int[] dataDelte = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
//		做法一，循环次数较多，会产生垃圾空间
		printArray(ArrayUtil.reverseArrayAlpha(dataDelte));

//		做法二，循环次数降低，if判断增加了时间复杂度，减少了无用对象产生，提升性能
		ArrayUtil.reverseArrayBeta(dataDelte);
		printArray(dataDelte);

//		数组相关类库
//		 数组排序
		int[] arr = new int[] { 11, 89, 125, 9, 3, 5, 28 };
		java.util.Arrays.sort(arr);
		printArray(arr);

//		 数组拷贝
//		 System.arraycopy(源数组,源数组开始点,目标数组,目标数组开始点,拷贝长度);
		int[] arra = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] arrb = new int[] { 11, 22, 33, 44, 55, 66, 77, 88, 99 };
//		System.arraycopy(arra, 3, arrb, 3, 3);
//		printArray(arrb);
		ArrayUtil.copyArray(arra, 3, arrb, 3, 3);
		printArray(arrb);

//		可变参数
		System.out.println(ArrayUtil.sum(1, 2, 3));

//		对象数组：长度固定，所有数据都是线性保存的，根据索引访问，速度较快，时间复杂度为1。
//		 动态初始化：类[] 数组名称 = new 类[长度] 每个元素都是null
//		 静态初始化：类[] 数组名称 = new 类[] {对象,对象,对象}
//		动态初始化
//		Persona[] persona = new Persona[3];
//		persona[0] = new Persona("张三", 10);
//		persona[1] = new Persona("李四", 20);
//		persona[2] = new Persona("王五", 30);
//		静态初始化
		Persona[] persona = new Persona[] { new Persona("张三", 10), new Persona("李四", 20), new Persona("王五", 30) };

		for (int i = 0; i < persona.length; i++) {
			System.out.println(persona[i].getInfo());
		}

	}

//	public static int[] arrayInitialize() {
//		int[] arr = new int[] { 1, 2, 3, 4, 5 };
//		return arr;
//	}

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "、");
		}
		System.out.println();
	}

//	public static void arrayUpdate(int[] array) {
//		for (int i = 0; i < array.length; i++) {
//			array[i] *= 2;
//		}
//	}

}
