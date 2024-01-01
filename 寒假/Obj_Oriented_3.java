94.
/*
对输入的字符串进行判断。要求如下：

（1） 自定义一个异常类NotPositiveException，继承Exception，
 (2) 输入一个字符串str，利用Integer的parseInt(str)方法把字符串str解析成整数x；
  3)如果x是负整数或零，抛出NotPositiveException对象；
 (4)如果不能解析成功，捕获parseInt(str)方法抛出的NumberFormatException异常
（5）如果有其它异常也能使程序正常结束不被中断（提示：需要捕获Exception异常）。

运行结果如下图所示。


*/
```java
import java.util.*;
//自定义异常
class NotPositiveException extends Exception
{
  public NotPositiveException()
  {
    super("输出应是大于0的整数\n");//e1.printStackTrace();输出结果
  }
}

public class  Obj_Oriented_3_94{

	public static void main(String[] args) {
	// TODO Auto-generated method stub
	System.out.println("输入一个正整数:");
	Scanner    sc = new Scanner(System.in);
	String str = sc.next();
//模块化处理,判断转化结果
	if(conversion(str)!=-1)
		System.out.println("输入了正确数据:"+conversion(str));

	//统一输出 “输入”信息
  System.out.println("输入的是:" + str);

	}
//转化
  public static int conversion(String str)
  {
    int x  = -1;
    try
    {
      x =  Integer.parseInt(str);
      if(0==x||x<=0)
      {
    	x=-1;  throw new NotPositiveException();
    	/*此处由于正常情况下Integer.parseInt()
    	可以转化负整,但不是题目要求的结果，故x=-1,做标记*/
      }
    }
    catch(NotPositiveException e1) {
    	//e1.printStackTrace();
    	System.out.println("应该输出大于0的整数!");
    }
    catch (NumberFormatException e2){
      System.out.println(str + "不是整数字符串！");
    }
    catch(Exception e3){
      System.out.println("请检查是否存在有其他异常！");
    }
    return x;
  }
}































```
95
/*
自定义酒驾异常类AlcoholException，
该类有一个构造方法返回提示信息。
定义检车类Check，有一个公共静态方法drunkDriving()对血液中的酒精含量进行判断，
如果血液酒精含量＞80则抛出酒驾异常对象（醉驾信息），如果20≤酒精含量≤80也抛出酒驾异常对象（酒驾信息），
该方法中不对抛出的酒驾异常对象进行捕获，而是throws他们。

定义测试类Demo，输入血液中酒精含量，调用Check的drunkDriving()方法检查酒驾情况。
*/
import java.util.*;
class AlcoholException extends Exception
{
  public AlcoholException(String mgs)
  {
        super(mgs);//返回错误信息
  }
}

class Check
{
  public static void drunkDriving(int alcoholContent)throws AlcoholException// 酒精含量
  {
      if(alcoholContent>80)
          throw new AlcoholException("酒精含量>80!");
      if(alcoholContent<=80&&alcoholContent>=20)
          throw new AlcoholException("20≤酒精含量≤80");
  }
}

public class  Obj_Oriented_3_95 {

	public static void main(String[] args)throws AlcoholException {
	// TODO Auto-generated method stub
  	System.out.println("输入血液中酒精含量");
  	Scanner    sc = new Scanner(System.in);
  	int  alcoholContent= sc.nextInt();
  	Check.drunkDriving(alcoholContent);
	}
}
/**
输入血液中酒精含量
89
Exception in thread "main" Obj_Oriented_3.AlcoholException: 酒精含量>80!
	at Obj_Oriented_3.Check.drunkDriving(Obj_Oriented_3_95.java:16)
	at Obj_Oriented_3.Obj_Oriented_3_95.main(Obj_Oriented_3_95.java:29)

*/

编写一个程序，从键盘读入一个实数，然后检查实数是否小于0，如果小于0，就抛出异常，否则输出这个数的平方根

import java.util.*;
class NegativeNumberException extends Exception
{
  public NegativeNumberException()
  {
    super("负数异常");
  }
}
public class  Obj_Oriented_3_96 {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
	System.out.println("请输入一个非负数！");
	Scanner sc  = new Scanner(System.in);
	double s = sc.nextDouble();
	try {
		if(s>=0)
			  System.out.println(Math.sqrt(s));
		else
			 throw new NegativeNumberException();
	}catch(NegativeNumberException e) {
		e.printStackTrace();
	}
	}
}


定义一个方法，该方法能够捕捉文件打开异常、数组下标越界异常，抛出除数为0异常。
package Obj_Oriented_3;

import java.io.FileNotFoundException;

public class  Obj_Oriented_3_97 {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
    CatchException();
	}
	public static  void  CatchException() throws ArithmeticException
	{
    	  try{
    		  	throw new FileNotFoundException();

    	  }catch(ArrayIndexOutOfBoundsException  e){

    	  }catch( FileNotFoundException e){

    	  }
	}
}




第一种方式：全类名的方式获取字节码文件

Class class2 = Class.forName("day27.Dog");//通过类名的全路径获取字节码文件

第二种方式：通过 类名.class 的方式获取字节码文件
Class class1 = Dog.class; //通过类名.class 获取字节码文件


第三种方式：通过 对象获取字节码文件
Dog dog = new Dog(); //创建对象
Class class3 = dog.getClass(); //通过类创建的对象获取字节码文件


飞机和小鸟都能够在天上飞，但飞的方法不同，
例如飞机通过发动机产生动力进行飞行，小鸟通过翅膀进行飞行。
把飞行方式抽象成飞行接口Fly中的方法，飞机和小鸟实现了飞行接口
下图显示了接口与类之间的关系，请写代码实现这个UML模型。

需要写出测试类Demo，完成如下测试：
创建飞机和小鸟对象，测试飞行方法。

interface Flyltf
{
  int FLY_CONSTANT = 56;
  void fly();
}
class Plane implements Flyltf
{
    String name;
    public Plane(String name)
    {
       this.name=name
    }
    boolean start()
    {
            System.out.println("开始飞行");
    }
    @Override
    public void fly()
    {
      System.out.println("飞机飞行");
    }
}
class Bird implements Flyltf
{
    String name;
    public Bird(String name)
    {
       this.name=name
    }
    void tweet()
    {
      System.out.println("吱喳");
    }
    @Override
    public void fly()
    {
      System.out.println("鸟飞行");
    }
}
