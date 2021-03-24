/*数组动态初始化，初始化后数组每个元素的保存内容为其对应数据类型的默认值
 * 声明并初始化数组
 *  数据类型 数组名称[] = new 数据类型[长度]
 *  数据类型[] 数组名称 = new 数据类型[长度]
 *
 *数组静态初始化，在数组定义时就为其设置好内容
 * 简化格式：数据类型 数组名称[] = {数据1，数据2，数据3}
 * 完整格式：数据类型 数组名称[] = new 数据类型[]{数据1，数据2，数据3}
 **/

public class ArrayTest {
	public static void main(String[] args) {
		int[] data = new int[] {5,84,36};// 静态初始化
//		int[] data = new int[3];// 动态初始化
//		data[0] = 11;// 为数组设置内容
//		data[1] = 35;
//		data[2] = 101;
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}
}
