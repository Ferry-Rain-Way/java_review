170.
一个人拥有多个电子设备，如有1部手机，2台电脑。
请分析该问题抽象出类，然后用UML类图表示类之间的关系，并用Java语言实现。（建模为关联关系）

class SmartDevic
{
	String name;
	double price;
	public SmartDevic(){}
	public SmartDevic(String name ,double price)
 {
		this.name = name;this.price = price;
	}
	@Override
	public String    toString()
	{
		return "name: " + name + "price: " + price;
	}
}
//手机
class Phone extends SmartDevic
{
	String type;
	public Phone (){}
	public Phone (String name ,double price,String type)
	{
		super(name,price);
		this.type = type;
	}
	@Override
	public String    toString()
	{
		return super.toString() + "type: " + type;
	}
}

//计算机
class Computer extends SmartDevic
{
	String brand;
	public Computer(){}
	public Computer(String name ,double price,String brand)
	{
		super(name,price);
		this.brand = brand;
	}
		@Override
	public String    toString()
	{
		return super.toString() + "brand: " + brand;
	}
}

//人
class Person
{
	String name;
	SmartDevic [] devic;
	Person (String name,SmartDevic []devic )
	{
		this.name = name;
		this.devic = devic;
	}
	@Override
		public String    toString()
	{
		String str = name + "拥有:\n";
		for(int i=0;i<devic.length;i++)
			str = str + devic[i].toString() +"\n";//重点
		return str;
	}
}

public class  Obj_Oriented_2_170 {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
	//手机*1 电脑*2
			SmartDevic [] devic = {
				new Phone("小米",2567,"红米K0"),
				new Computer("苹果",10999,"M1"),
				new Computer("联想",5099,"YOGA")

			};

			Person ps = new Person("张三",devic);
			System.out.println(ps);
	}
}
/**
张三拥有:
name: 小米price: 2567.0type: 红米K0
name: 苹果price: 10999.0brand: M1
name: 联想price: 5099.0brand: YOGA
*/




























172. (简答题)

/**
场景：普通汽车没有GPS定位功能，为了进行导航需要加装GPS。

(1)定义Car,成员变量包括汽车品牌brand和速度speed；
(2)定义接口GPS，方法Point getLocation(Point init)获得汽车位置信息；
（3）位置类Point的成员变量x和y表示坐标；
（4）然后定义GPSCar继承Car实现GPS接口。最后进行测试。
程序一种运行结果如下图所示。提示：采用适配器模式。

汽车品牌是:哈弗
当前位置 :100.0    110.0
当前位置:120.0     130.0

*/

abstract class Car
{
	String brand;
	double speed;
}

interface GPS
{
	Point getLocation(Point init);
}

class Point
{
	int x,y;
	Point(int x,int y)
	{
		this.x = x;
		this.y = y;
	}
}


class GPSCar extends Car implements GPS
{
	Point init=new Point(100,110);//初始位置
	public GPSCar(){}
	public GPSCar(String brand ,double speed)
	{
		this.brand = brand;this.speed = speed;
	}

	@Override
	public Point getLocation(Point init)
	{
		//模拟汽车移动[位置发生移动]
		int xMove = init.x + 20,yMove = init.y+20;
		this.init =new Point(xMove,yMove);
		return this.init;
	}
	@Override
	public String toString()
	{
		return "当前位置:" + this.init.x  + " " + this.init.y;
	}
}

public class  Obj_Oriented_2_172 {

	public static void main(String[] args) {
	// TODO Auto-generated method stub

	GPSCar gc = new GPSCar("哈弗",180);
	System.out.println(gc);
	gc.getLocation(gc.init);
	System.out.println(gc);
	}
}


















173.
/*
模拟自动售货机卖商品。顾客操作流程：选择商品——>付款——>弹出商品——>找零。
设计货物抽象类Good，绿茶类GreenTea、百事可乐类Pepsi和矿泉水类MineralWater继承了Goods类，
设计工厂类GoodsFactory，方法getGoods(String name,double price)得到一种指定的商品。
一种运行结果如下图所示。采用简单工厂模式实现。

路人需要购买矿泉水
弹出矿泉水
商品名称:矿泉水，价格:2.0
*/


import java.util.Scanner;

abstract class Goods
{
	public String name;
	public double price;
	public String Type ;
	public Goods(String name,double price)
	{
	this.name=name;this.price=price;
	}
	@Override
	public String toString()
	{
		return "商品名称: "+this.name + "  \t价格: " + this.price + "\t";}
}
class GreenTea extends Goods
{

	public GreenTea(String name,double price)
  	{
		super(name,price);Type = "GreenTea";}
}
class Pepsi extends Goods
{
	public Pepsi(String name,double price)
  	{
		super(name,price);Type = "Pepsi";}
}
class MineralWater extends Goods
{

	public MineralWater(String name,double price)
  	{
		super(name,price); Type = "MineralWater";}
}
class GoodsFactory
{
	static Goods[][] goods = {
			{new GreenTea("康师傅绿茶",2.5),new GreenTea("统一绿茶",2.5),new GreenTea("小明同学",5.0) },
			{new Pepsi("百事可乐",3.0)},
			{new MineralWater("娃哈哈矿泉水",2.0),new MineralWater("农夫山泉",3.0)}
	};

	static public String getGoods(String name,double price)
	{


		double change;//找零
		String str = null;
		int flag=-1;
		for(Goods[]g:goods)
		{
			for(Goods good:g)
			{
				 if(name.equals(good.name)&&price>=good.price)
				 {
					 flag=0;
					 str =    "商品名称:" + name  + "价格: " + price + "\n找零: " + (price-good.price);
					 break;
				 }
				 else if(name == good.name&&price<good.price)
				 {
					 flag=1;
					 str = "您的小钱钱不足以购买该商品哦!请加钱或换个商品！";
					 break;
				 }
			}
			if(flag==0||flag==1)break;
		}
		if(flag==-1)
			str = "为查询到您需要的商品";
		return str;

	}

}
public class  Obj_Oriented_2_173 {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
		//货架
		//输出全部商品

				for(int i=0;i<GoodsFactory.goods.length;i++)
				{
					System.out.println("  " +  GoodsFactory.goods[i][0].Type);
					for(int j=0;j<GoodsFactory.goods[i].length;j++)
						System.out.println( "  " +GoodsFactory.goods[i][j]);
					System.out.println("--------------");
				}


		//选择商品
		System.out.println("请选择你需要的商品名称");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		System.out.println("请输入付款金额:");
		double price = sc.nextDouble();

		System.out.println(GoodsFactory.getGoods(name, price));

	}
}

/*
  GreenTea
  商品名称: 康师傅绿茶  	价格: 2.5
  商品名称: 统一绿茶  	价格: 2.5
  商品名称: 小明同学  	价格: 5.0
--------------
  Pepsi
  商品名称: 百事可乐  	价格: 3.0
--------------
  MineralWater
  商品名称: 娃哈哈矿泉水  	价格: 2.0
  商品名称: 农夫山泉  	价格: 3.0
--------------
请选择你需要的商品名称
百事可乐
请输入付款金额:
3.0
商品名称:百事可乐价格: 3.0
找零: 0.0

*/



















174.

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
       this.name=name;
    }
    boolean start()
    {
            System.out.println("开始飞行");
            return true;
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
       this.name=name;
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

public class  Obj_Oriented_2_174 {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
			Plane p1 = new Plane("马航370");
			Bird b1 = new Bird("喜鹊");
			p1.start();
			p1.fly();
			b1.tweet();
			b1.fly();
	}
}


/*
开始飞行
飞机飞行
吱喳
鸟飞行


*/

某电器工厂可以根据客户订单生产电冰箱和电扇。请利用简单工厂模式模拟客户发送订单，工厂进行生产的流程。类结构如下图所示。


package Obj_Oriented_2;

/**
某电器工厂可以根据客户订单生产电冰箱和电扇。
请利用简单工厂模式模拟客户发送订单，
工厂进行生产的流程。类结构如下图所示。
 */
package Obj_Oriented_2;

abstract class Equipment
{
	String name;

	public Equipment(String name) {
		super();
		this.name = name;
	}

}
class Fan extends Equipment
{
	double power;

	public Fan(String name, double power) {
		super(name);
		this.power = power;
	}

	@Override
	public String toString() {
		return  this.name +"power" + power ;
	}
}

class Refrigerator extends Equipment
{
	double volume;

	public Refrigerator(String name, double volume) {
		super(name);
		this.volume = volume;
	}

	@Override
	public String toString() {
		return this.name +  "volume=" + volume ;
	}

}
class MyFactory{
	public static   Equipment getlnstance(String equipmentName) {
				if(equipmentName.indexOf("风扇")!=-1?true:false)
					return new Fan(equipmentName,600);
				else if(equipmentName.indexOf("冰箱")!=-1?true:false)
					return new Refrigerator(equipmentName,70);
				else
					return null;
	}

}

class Client
{
	private String name;
	public Client (String name)
	{
		this.name = name;
		Equipment e = MyFactory.getlnstance(name);
		if(e!=null)
			System.out.println(e);
	}
}
public class  Obj_Oriented_2_175 {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
		Client c1 = new Client("美的冰箱");
	}
}
/**
美的冰箱volume=70.0
*/








交通工具有汽车、飞机、轮船和火车。所有交通工具都要共同特点，
如功率、载人数和自重等，行为有启动、转向、关闭等等。
各种具体的交通工具有不同的特征和行为。请根据上面描述画出类结构图，并用Java语言实现这些类。
package Obj_Oriented_2;


abstract class Vehicle
{
	double power;
	int carryingCapacity;
	int deadWeight;

	public Vehicle(double power, int carryingCapacity, int deadWeight) {
		super();
		this.power = power;
		this.carryingCapacity = carryingCapacity;
		this.deadWeight = deadWeight;
	}
	abstract void startUp();
	abstract void toTurnTo();
	abstract void close();
}

class Bus extends Vehicle
{

	public Bus(double power, int carryingCapacity, int deadWeight) {
		super(power, carryingCapacity, deadWeight);
		// TODO Auto-generated constructor stub
	}

	@Override
	void startUp() {
		// TODO Auto-generated method stub
		System.out.println("油电混动 启动");
	}

	@Override
	void toTurnTo() {
		// TODO Auto-generated method stub
		System.out.println("方向盘转动");
	}

	@Override
	void close() {
		// TODO Auto-generated method stub
		System.out.println("刹车");
	}

	@Override
	public String toString() {
		return "Bus [power=" + power + "千瓦, carryingCapacity=" + carryingCapacity + ", deadWeight=" + deadWeight
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
class Ship extends Vehicle
{

	public Ship(double power, int carryingCapacity, int deadWeight) {
		super(power, carryingCapacity, deadWeight);
		// TODO Auto-generated constructor stub
	}

	@Override
	void startUp() {
		// TODO Auto-generated method stub
		System.out.println("发动机 启动");
	}

	@Override
	void toTurnTo() {
		// TODO Auto-generated method stub
		System.out.println("船舵 转向");
	}

	@Override
	void close() {
		// TODO Auto-generated method stub
		System.out.println("抛锚");
	}

	@Override
	public String toString() {
		return "Ship [power=" + power + "马力, carryingCapacity=" + carryingCapacity + ", deadWeight=" + deadWeight
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
public class Obj_Oriented_2_176 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bus b = new Bus(360,59,20);
		b.startUp();b.toTurnTo();b.close();
		System.out.println(b);
		Ship s = new Ship(450,200,17);
		s.startUp();s.toTurnTo();s.close();
		System.out.println(s);


	}
}
/**
油电混动 启动
方向盘转动
刹车
Bus [power=360.0千瓦, carryingCapacity=59, deadWeight=20, getClass()=class Obj_Oriented_2.Bus, hashCode()=5433634, toString()=Obj_Oriented_2.Bus@52e922]
发动机 启动
船舵 转向
抛锚
Ship [power=450.0马力, carryingCapacity=200, deadWeight=17, getClass()=class Obj_Oriented_2.Ship, hashCode()=2430287, toString()=Obj_Oriented_2.Ship@25154f]

*/


1. 抽象出Person类，

    1.1私有化数据成员包括姓名，性别；

    1.2,一个空构造方法，一个初始化所有数据成员的构造方法；

    1.3写出所有setter和getter方法

1.4 功能方法：  操作遥控器完成对电视的控制。



2. 抽象出遥控器类：

  2.1 私有数据成员：电视机型号，遥控器颜色，遥控距离，电池寿命；

  2.2 两个构造方法，一个空构造方法，一个初始化所有数据成员的构造方法；

  2.3 写出所有的setter和getter方法

  2.4  利用功能方法完成对电视机的控制，有按钮4个，（1）打开电视机；（2）关闭电视机；

         （3）调大音量（音量范围0-40），（4）调大节目号（节目号范围1-88）。

3. 其它要求：

     3.1 在cn.edu.jsu.rjxy包中定义Person类；

     3.2 在com.163.jsu包中定义遥控器类Telecontroller

     3.3 在默认包中定义测试类Demo









