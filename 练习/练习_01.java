-----------------------------------------------------------------
1.增加标识 boolean flag = true;int i=0;
				while(flag){
					if(i==6)
						flag=false;
					.....
				}
2.当标识为6,break;
3.System.exit(0);
.....
-----------------------------------------------------------------
package String练习_01;
import java.util.Scanner;

public class CountNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//输入
		Scanner sc = new Scanner (System.in);
		String str = sc.next();
		sc.close();
		int [] n = new int [10];
	    Boolean flag = true;//合法标识
		for(int i=0;i<str.length();i++)
		{
				//判斷
				if(Character.isDigit(str.charAt(i)))
					{
						n[Integer.valueOf(str.charAt(i)+"")]++;
						//n[Integer.parseInt(str.charAt(i)+"")]++;
					}
				else
				{
					flag = false;
					break;
				}
		}

		//判断是否可直接输出-true -输出
		if(flag)
		{
			for(int i=0;i<n.length;i++)
				System.out.println(i  + ":"+ n[i]);
		}else
			System.out.println("您输入的字符串非法");


	}
}

-----------------------------------------------------------------

package String练习_01;

import java.util.Scanner;

public class ReplaceString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				//输入
				Scanner sc = new Scanner (System.in);
				System.out.println("请输入待匹配字符串");
				String str = sc.nextLine();
				/*可以使用正则表达式进行查找
				 * str.replaceAll(regex, repl)  等效于
					Pattern.compile(regex).matcher(str).replaceAll(repl)
				 */

				System.out.println("\nFind:");
				String regex = sc.next();

				System.out.println("\nReplace:");
				String repl = sc.next();

				str = str.replaceAll(regex, repl);

				System.out.println(str);
				sc.close();

	}

}

-----------------------------------------------------------------
package String练习_01;

import java.util.Scanner;

public class CountWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int SUM = 0;
		String []string =str.split(" ");
		for(int i=0;i<string.length;i++)
				if(!string[i].equals(""))
				{
					SUM++;
					System.out.println(string[i]);
				}
		System.out.println("SUM: " + SUM);

	}

}

-----------------------------------------------------------------


/**
 * 时间：2022年3月6日15:09:08
 * 编程目标：
 * 		利用泛型、集合的知识 完成下题

						5、菜单的价格。菜单的内容如下:“北京烤鸭：
						189元，西芹炒肉: 12.9元，酸菜鱼:69元，铁
						板牛柳:32元。”编写一个JAVA应用程序，输
						出菜单中的价格数据，并计算出菜单的总价格
						编写代码，程序运行结果如下图所示:

			拓展：本题提供了一种解决ClassCastExceptian 异常的办法
			[关键字]instanceof
			[链接](https://www.cnblogs.com/song-xingxing/p/10546552.html)

			本题见注解①

运行结果：
			------------------
			菜品北京烤鸭	价格189
			菜品西芹炒肉	价格12.9
			菜品酸菜鱼	    价格69
			菜品铁板牛柳	价格32
			302.9
			------------------
*/


package String练习_01;
import java.util.ArrayList;

class Dishes<T> {
	private String name;
	private T price;
	static ArrayList<Dishes> menu = new ArrayList<>();
	//非泛型方法
	public Dishes() {}
	public Dishes(String name,T price) {
		this.name = name;
		this.price = price;
	}

	public static void showDishes() {

		for(Dishes dishes:menu)
			System.out.println(dishes);
	}
	public static double totalPrice() {
		double sum = 0;
		for(Dishes dishes:menu) {
			//注解①-------------------------
			if( dishes.price instanceof Integer)
				sum = sum + (Integer)dishes.price;
			else
				sum = sum + (Double)dishes.price;
			//------------------------------
		}
		return sum;
	}

	@Override
	public String toString() {
		return   "菜品" + name + "\t价格" + price;
	}
}

public class Customer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dishes  dishes =  new Dishes();
		ArrayList<Dishes> list =dishes.menu;
		list.add(new Dishes<Integer>("北京烤鸭",189));
		list.add(new Dishes<Double>("西芹炒肉",12.9));
		list.add(new Dishes<Integer>("酸菜鱼",69));
		list.add(new Dishes<Integer>("铁板牛柳",32));


		dishes.showDishes();
		System.out.println(dishes.totalPrice());

	}
}

-----------------------------------------------------------------
package String练习_01;
import java.util.*;
class RandomTeacher {

	public static String[] getRandomTeachers(String []teachers,int n) {
		//生成临时空间存放随机出的教师
		String [] temp = new String[n];
		int length=0;

			//判定数组长度是否>n【人数够不够n】
		if(teachers.length == n)//不考虑随机,直接全部输出
			temp = teachers;
		else if(teachers.length>n)
				{
					Random random = new Random();
					//一直随机,直到产生要求的人数
					while(length<n) {
						String str = teachers[random.nextInt(teachers.length)];
						//除第一个外，都要查重
						if(length==0||!isExist(temp,str,length))
						{
							temp[length] = str;
							length++;
						}
					}
				}
			else
				System.out.println("教师资源紧缺,请调整方案！");

		return temp ;
	}

	//检查当前教师是否已被选中
	public static boolean isExist(String [] s,String t,int length) {
			int i=0;
			while(i<length) {
				if(s[i].equals(t))
					return true;//存在
				i++;
			}
			return false;
	}
}


public class ExaminationRoom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//教师
		 String [] teachers = {
				"教师甲",
				"教师乙",
				"教师丙",
				"教师丁",

		};
		 //输入n
		 System.out.println("请输入您需要的人数！");
		 Scanner sc = new Scanner(System.in);
		 int n = sc.nextInt();

		 //生成监考教师
		 String [] str = RandomTeacher.getRandomTeachers(teachers, n);

		 //如果返回非空，输出
		 if(str[0]!=null)
			 for(String s:str)
				 System.out.println(s);


	}
}
-----------------------------------------------------------------
