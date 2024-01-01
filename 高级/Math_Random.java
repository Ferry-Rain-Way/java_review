1.Math类：

java.lang.Math类提供了常用的数学运算方法
      和两个静态常量E(自然对数的底数) 和PI(圆周率)


double d = Math.random()//生成[0.0-1.0)之间的随机数
double d2 =  Math.random()*10;//生成[0-10)之间的随机数,不含10
int random = (int)(Math.random()*10);//0-9之间的整数随机数
Math.random()*10 + 1;//


2.Random类：
      1>【步骤：】
            import java.util.Random;
            Random random = new Random();
            random.next...();
            /*例如：random.nextInt();
            生成随机数的范围：int范围
            */
            random.next...(Type);
             /*例如：random.nextInt(10);
            生成随机数的范围：0-10
      */

      2>随机数种子
      Random random = new Random(种子);//可以是无参的
      注意：对于相同的种子,生成的随机数是相同的且是固定的
                  对于不同的种子,生成的随机数是不同的,
                  如果是无参的构造方法,即没有“显式”的种子,
                        但“隐式”的种子是存在的,且对于每一次使用构造方法,
                        几乎每一次的种子都不一样


      3>常用的尽量保证随机数不同的方法
            1.无参
            2.将当前的毫秒做种子


Date 类：
/*

帮助文档：
getTime:
public long getTime()

返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
返回：自 1970 年 1 月 1 日 00:00:00 GMT 以来此日期表示的毫秒数。
 */

		package Test;
		import java.util.*;
		public class TestDate {

			public static void main(String[] args) {
				// TODO Auto-generated method stub

				//1.创建第一个Date对象
				Date date0  = new Date ();
				double timeOne = date0.getTime()/1000.0;//改成秒数

				//System.out.printf("%.0f\n",timeOne);

				//2.时间间隔
				Scanner sc = new Scanner(System.in);
				String str = sc.nextLine();

				//3.创建第二个Date对象

				Date date1  = new Date ();
				double timeSecond = date1.getTime()/1000.0;//改成秒数
				//System.out.printf("%.0f\n",timeSecond);

				System.out.printf("%.0f\n",timeSecond-timeOne);//计算时间差

			}

		}







