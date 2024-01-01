面向对象_01

48.
int...args




50.以下（ ）不能作为void sort(int [ ] arr)方法的重载方法。
	int sort(int ... array)



75.
自定义实现数组copy函数：
package Base_03;
public class  Base_03_75 {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
	//测试
		int src [] = {1,3,12,-1,21,2};
		int dest[] = new int [4];
		copyArray(src,1,4,dest);
		for(int temp:dest)
		System.out.print(temp +" ");
	}

	public static void copyArray(int[] src,int begin,int end,int[] dest)
	{
		if(begin>=0&&end>=begin&&(end-begin+1==dest.length))//判断是否可以合并
		{
			//合并
			int j=0;
			for(int i=begin;i<=end;i++)
				dest[j++] = src[i];
		}
	}

}
/*---------------
3 12 -1 21
----------------*/


83.

```java
import java.util.Scanner;
public class  Base_03_83 {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
  System.out.println("请输入整数n !\n");
	Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(),sum = 0,i=1;
    while(i<=n)
   	 {
        if(i%2==0||i%3==0)
        	sum = sum + i;

        i++;
     }
     System.out.println("Sum = " + sum);
	}

}
```


84.
```java
import java.util.*;
public class Base_03_84 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入操作数1");
		double A = sc.nextDouble();
		System.out.println("请输入操作符");
		String C = sc.next();
		System.out.println("请输入操作2");
		double B = sc.nextDouble();
		double Sum = 0;
		switch(C)
		{
			case "+": Sum = A+B;break;
			case "-": Sum = A-B;break;
			case "*": Sum = A*B;break;
			case "/":Sum = (B!=0D)?A/B:0;break;//分母非0
		}
		System.out.println(A + C + B + "=" + Sum);
	}

}
```

85.
同84

86.【截取字符串的函数】
```java
import java.util.*;
public class Base_03_86  {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
	Scanner sc = new Scanner(System.in);
	System.out.println("请输入字符串!");
	String str = sc.nextLine();//用于获取一行字符串，含空格、tab等
	int Sum = 0,i=0;
	//获取长度
	int length = str.length();
	//判断
	while(i<length)
	{
		char ch = str.charAt(i);
		if(ch>='0'&&ch<='9')
		Sum++;
		i++;
	}
	//输出
	System.out.println("输入字符串中共计" + Sum + "个数字")；
	}
}
```

87.
```java
public class Base_03_87 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int Sum = 0，i=1;
		while(i<100)
		{
		Sum = Sum + i;
		i+=2;
		}
	}

}
```

88.
```java
import java.util.*;
public class Base_03_88 {

	public static void main(String[] args)throws InterruptedException {
		// TODO Auto-generated method stub
			int  i = 0;
		String str = "jsu12345";
		Scanner sc = new Scanner(System.in);

		for(i=0;i<3;i++)
		{
			String str2 = sc.next();
			if(str2.equals(str))
				break;
		}

		if(i!=3)
			System.out.println("密码正确！");
		else
		{
			System.out.println("密码错误！");
			Thread.sleep(5000);
			System.out.println("退出！");
			System.exit(-1);

		}
	}
}
```

89.
```java
import java.util.*;
public class Base_03_89 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入操作数1");
		double A = sc.nextDouble();
		System.out.println("请输入操作符");
		String C = sc.next();
		char ch = C.charAt(0);
		System.out.println("请输入操作2");
		double B = sc.nextDouble();
		double Sum = 0;

		if	   (ch=='+')	Sum = A+B;
		else if(ch=='-')	Sum = A-B;
		else if(ch=='*')	Sum = A*B;
		else				Sum = (B!=0D)?A/B:0;//分母非0

		System.out.println( Sum);
	}

}
```


90.
```java
import java.util.*;
public class  Base_03_90 {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
	Scanner sc = new Scanner(System.in);
	System.out.println("请输入电视频道");
	int A = sc.nextInt();
	String str ;
	switch(A)
	{
		case 27:str = "CCTV综合";break;
		case 30:str = "CCTV中文国际";break;
		case 31:str = "CCTV体育频道";break;
		case 33:str = "CCTV新闻频道";break;
		default:str = "未查询到节目";
	}
	System.out.println(str);
	}
}

```

91.
```java
import java.util.*;
public class Base_03_91 {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
			int  i = 0;
		String str = "jsu12345";
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入密码!");
		while(i<3)
		{
			String str2 = sc.next();
			if(str2.equals(str))
				break;
				i++;
		}
		sc.close();


		if(i!=3)
			System.out.println("密码正确！");
		else
		{
			System.out.println("密码错误！");
			Thread.sleep(5000);
			System.out.println("退出！");
			System.exit(-1);

		}
	}
}
```



92.
```java
public class  Base_03_92 {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
		int n = 1237;
		Increasing(n);
		System.out.println(n);

	}
	public static int Increasing(int Flag)
	{
		int temp = 0;
		if(Flag<=5000)
		{
		  System.out.println(Flag);
		  temp = 	Increasing(Flag<<1);//递归
	      System.out.println(temp);
		}
		else
			System.out.println(Flag);//超过5000
		return Flag;

	}
}


```



93.
```java
public class  Base_03_93 {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
		System.out.println(Area(99,21));
	}

	public static int Area(double x,double y)
	{
		/*
		浮点数判断相不能用“==”
		double precision = 0.000001D;
		if(Math.abs(x-y)<precision)
			return 0;
		*/

		if(x>y)
			return 1;
		else if(x<y)
			return -1;
		else
			return 0;

	}
}


```



94.
```java

public class  Base_03__94 {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
		int [] arr= {9,3,3,2,323,90,32,2,0};
		System.out.println( minArray(arr));
		int [][] arr2 = {
				{1,3,4,12,2},
				{2,32,2,32,2,-9}
		};
		System.out.println( minArray(arr2));
	}
	public static int minArray(int []arr)
	{
		int min = arr[0],i=0;
		while(i<arr.length)
		{
			if(min>arr[i])
					min = arr[i];
			i++;
		}
		return min;
	}

	public static int minArray(int [][]arr)
	{
			int i,j,min=arr[0][0];
			for(i=0;i<arr.length;i++)
			{
				min = arr[i][0];
				for(j=0;j<arr[i].length;j++)
					if(min>arr[i][j])
						min = arr[i][j];
			}
			return min;
	}

}


```

95.
```java
public class  Base_03_95 {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
	int [] arr= {9,3,3,2,323,90,32,2,0,-1};

	bubbleSort(arr);
	show(arr);

	String []arr2 = {"hello","world","a","c","b"};
	bubbleSort(arr2);
	show(arr2);
	}

	public static void bubbleSort(int []arr)
	{
		int i=0,j=0;
		for(i=0;i<arr.length-1;i++)//轮
		{
			for(j=0;j<arr.length-i-1;j++)
				if(arr[j]>arr[j+1])
				{
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
		}
	}
	public static void bubbleSort(String []arr)
	{
		int i=0,j=0;
		for(i=0;i<arr.length-1;i++)//轮
		{
			for(j=0;j<arr.length-i-1;j++)
				if(arr[j].compareTo(arr[j+1])>0)
				{
					String temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
		}
	}
	public static void show(int []arr)
	{
		for(int i=0;i<arr.length;i++)
				System.out.printf("%d ",arr[i]);
			System.out.printf("\n");
	}

	public static void show(String []arr)
	{
		for(int i=0;i<arr.length;i++)
			System.out.printf("%s ",arr[i]);
		System.out.printf("\n");
	}
}


```


96.
```java
public class  Base_03_96 {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
		int [][]arr = {
				{-9,90},
				{100,999}
		};
		saddle(arr,2);
	}
	public static void saddle(int arr[][],int n)
	{
		int i,j,min=arr[0][0],max=arr[0][0];
			for(i=0;i<n;i++)
			{

				for(j=0;j<n;j++)
					if(min>arr[i][j])
						min = arr[i][j];
					else if(max<arr[i][j])
					 max = arr[i][j];
			}
			System.out.println("min=" + min + "max=" + max);
	}
}


```

97.
```java
public class  Base_03__97 {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
		int [] arr= {9,3,3,2,323,90,32,2,0};
		System.out.println( maxArray(arr));
		int [][] arr2 = {
				{1,3,4,12,2},
				{2,32,2,32,2,-9}
		};
		System.out.println( maxArray(arr2));
	}
	public static int maxArray(int []arr)
	{
		int max = arr[0],i=0;
		while(i<arr.length)
		{
			if(max<arr[i])
					max = arr[i];
			i++;
		}
		return max;
	}

	public static int maxArray(int [][]arr)
	{
			int i,j,max=arr[0][0];
			for(i=0;i<arr.length;i++)
			{
				max = arr[i][0];
				for(j=0;j<arr[i].length;j++)
					if(max<arr[i][j])
						max = arr[i][j];
			}
			return max;
	}

}

```

98.
```java
package Base_03;
class Student
{

		private String name;
		private double score;

		public Student(){};
		public Student(String name,double score){
			this.name = name;
			this.score = score;
		};

		public static void  max(Student[]list,int n)
		{
			//输出成绩最高的name 和 score
			Student stuMaxScore = list[0];
			for(Student stu:list)
			{
				if(stuMaxScore.score<stu.score)
					stuMaxScore = stu;
			}
			System.out.println(stuMaxScore.toString());
		}

		public static void sort(Student[]list ,int n)
		{
			//按照学生score从高到低排序
			for(int i=0;i<n-1;i++)
			{
				if(list[i].score>list[i+1].score)
				{
					Student stuTemp = list[i];
					list[i]  = list[i+1];
					list[i+1]  = stuTemp;
				}
			}

		}
		//-------增强for循环以及toString练习
		public static void show(Student[]list ,int n)
		{
			//输出
			for (Student stu : list) {
			System.out.println(stu.toString()); //逐个输出数组元素的值
			}
		}
		@Override
		public String toString()
		{
			return this.name + this.score;
		}


}



public class  Base_03_98 {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
		Student stu[] = {
			new Student("张三",100.0),
			new Student("李四",67.3),
			new Student("王五",78.6)
		};
		int n = stu.length;
		Student.max(stu, n);
		Student.show(stu,n);
		Stuednt.sort(stu,n);
		Student.show(stu,n);


	}
}


```


--------------------------------
8. (单选题)在事先不知道循环语句重复执行的次数时，可以用一个（ ）值来终止循环。
A. 布尔
B. 正
C. 负
D. 标记
我的答案: D正确答案: A


11. (单选题)
在命令提示符下以“java Test 99”运行以下程序，输出结果是（ ）。

public class Test {

public static void main(String[] args) {

			int value = Integer.parseInt(args[0]);

			switch (value) {
			case 1:
			System.out.println("1");
			case 2:
			System.out.println("2");
			break;
			default:
			System.out.println("default");
			break;}}}

A.
其它三项都不是
B. 1
C. default
D. 2

/*
预备知识：
java程序有一个主方法，是这样的public static void main(String [] args)
args[0]就是你用 "命令行编译运行"java程序时，传入的第一个参数，比如你运行一个程序，代码如下：
public class Test{
    public static void main(String [] args){
        for(int i=0;i<args.length;i++)
            System.out.println(args[i]);
    }
}
编译
javac Test.java
运行
java Test param1 param2 回车
你得到的结果是
param1
param2
也就是说args[0]是你传入的第一个参数args[2]是传入的第二个参数，以此类推。
注：命令行编译、运行java程序需要配置JDK环境变量

解答:
	题目中说在在命令提示符下以“java Test 99”运行以下程序
	即：传入的第一个参数args[0]为99
	带入switch结果为default


	如果直接eclips中运行，由于main函数默认是没参数的，
	所以String []args 数组是一个空数组，此时将
	args[0]赋值给value就会提示数组下越界，因为此时数组根本就不存在
*/


--------------------------------
