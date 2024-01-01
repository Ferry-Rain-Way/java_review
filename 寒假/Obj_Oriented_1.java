Object_Oriented_1



96.
```java
Singleton模式主要作用是保证在Java应用程序中，一个类Class只有一个实例存在。
一般Singleton模式通常有几种种形式:
第一种形式: 定义一个类，它的构造函数为private的，
它有一个static的private的该类变量，在类初始化时实例化，
通过一个public的getInstance方法获取对它的引用,继而调用其中的方法。

class Singleton
{
  private static  Singleton singleton = new Singleton();
  private Singleton(){}
  public static Singleton getInstance()
  {
    return singleton;
  }
}
public class Obj_Oriented_1_96{
	public static void main(String[] args)
	{
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		if(s1==s2)//比较地址
		  System.out.println("true");
		else
		  System.out.println("false");

		System.out.println(s1);
		System.out.println(s2);
	}
}

```

97.112.
面向对象的特征有哪些方面？
封装、继承、抽象、多态4个主要的特征

98.
讨论：

Java中继承是单继承，
对应就有多继承的概念，

单继承和多重继承优缺点，

Java如何实现多继承的功能呢？（查资料后讨论）

99.
类的属性和行为可以继承，但是类的构造方法（构造器能够继承吗？）
不能

105.107.
继承、封装和多态


110.

面向对象设计的一个原则，开闭原则（OCP）

就是说，软件中的模块，类，以及功能，应该能够在不修改现有代码的基础上增加新功能
“开”指的是组件功能的扩展是开放的
“闭”指的是现有的代码是关闭的
"软件实体应当对扩展开放，对修改关闭"
实现开闭原则最关键的是“抽象”，
就是将系统所有可能的行为抽象成一个抽象底层，
然后这个抽象底层提供所有具体实现的方法特征，
所以这要求对系统的设计有一定的预见性

113.
构造器（constructor）是否可以被重写（override），其规范是什么？
构造器(构造方法)Constructor 不能被继承，因此不能重写 Override，
但可以被重载 Overload（同名不同参）


114.
可以有多个类，但只能有一个public的类，并且public的类必须与文件名一致

117.
静态块（static{}）
（1） static关键字还有一个比较关键的作用，用来形成静态代码块（static{}(即static块)）以优化程序性能。
（2） static块可以置于类中的任何地方，类中可以有多个static块。
（3） 在类初次被加载的时候执行且仅会被执行一次（这是优化性能的原因！！！），
            会按照static块的顺序来执行每个static块，一般用来初始化静态变量和调用静态方法。

            结果是集合{父类static，子类static，父类大括号，父类构造函数，子类大括号，子类构造函数}的一个子集

            {}大括号里的是初始化块，这里面的代码在创建java对象时执行，而且在构造器之前！
            其实初始化块就是构造器的补充，初始化块是不能接收任何参数的，
            定义的一些所有对象共有的属性、方法等内容时就可以用初始化块了初始化！！
            好处是可以提高初始化块的复用，提高整个应用的可维护性。


120.
皇帝是中国帝制时期最高统治者的称号，每朝的某个时期只有 一个皇帝
例如清朝的乾隆时期。利用单例模式模拟皇帝的唯一性。
class QianLong
{
  private static  QianLong qian = new QianLong();
  private QianLong(){}
  public static QianLong getInstance()
  {
    return qian;
  }
}

public class Obj_Oriented_1_120{
	public static void main(String[] args)
	{
		QianLong qi = QianLong.getInstance();
	}
}

122.【内部类知识】
class MinAndMax
{
  GetMinAndMax，
}
public class  Obj_Oriented_1_122 {
	public static void main(String[] args) {
	// TODO Auto-generated method stub

	}
}


125.
设计一个表示书本的Book类，要求入下：

1.  私有化的数据成员包括书名，出版社名，作者（可能有多个，采用字符串数组），价格，页数。

2. 有三个构造方法：（1）空构造方法；（2）初始化书名，出版社名和作者三个数据成员的构造方法；（3）初始化所有数据成员的构造方法。利用this关键字区别形参和数据成员。

3. 写出所有的setter和getter方法来读取和设置私有化的数据成员。利用this关键字引用数据成员

4. 功能方法：（1）输出书名、出版社名和作者的方法；（2）输出书籍所有信息的方法；

                          （3）翻开到某页的方法；（4）在某页做笔记的方法。

二、对Book类测试要求如下：

1. 有3本书需要使用构造方法初始化书名，出版社名和作者，然后利用setter方法设置价格和页数。

2. 输出这3本书的所有信息，并统计这3本书的总价格。

3. 在一本书的第289页做笔记，笔记内容是“环境保护，从我做起”。


package Obj_Oriented_1;
class Book
{
  //1.
  private String title,PublisherName;
  private String [] author;
  private double price;
  private int page;
  public String []note = new String [100];//存放笔记
  public int sum = 0;//计数
  private int [][]myNote = new int [100][2];//笔记页数|是否存在笔记

  //2.
  public Book(){setmyNote();}
  public Book(String title,String PublisherName,String [] author)
  {
    this.setTitle(title);
    this.setPublisherName(PublisherName);
    this.setAuthor(author);
    setmyNote();
  }
  public Book(String title,String PublisherName,String [] author,double price,int page)
  {
    this.setTitle(title);
    this.setPublisherName(PublisherName);
    this.setAuthor(author);
    this.setPrice(price);
    this.setPage(page);
    setmyNote();
  }
  //3.
  public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublisherName() {
		return PublisherName;
	}
	public void setPublisherName(String publisherName) {
		PublisherName = publisherName;
	}
	public String [] getAuthor() {
		return author;
	}
	public void setAuthor(String [] author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int [][] getmyNote() {
		return myNote;
	}
	public void  setmyNote() {
		myNote[0][1] = 0;//没有笔记
	}
  //4.输出书名、出版社名和作者的方法；
  public void  show1()
  {
    System.out.println("书名:" + getTitle() + "出版社名:" + getPublisherName());
    System.out.printf("作者:");
    for(int i=0;i<getAuthor().length;i++)
      System.out.printf(getAuthor()[i] + " ");
  }
  public void  show2()
  {
   show1();
   System.out.println("\nprice:" + price + "￥  "+ "page:" + page );
  }

  //判断Page页是存在笔记
  public int exist(int page)
  {
    int flag = -1;

    for(int i=0;i<getmyNote().length;i++)
    {
    	if(getmyNote()[0][1]==0)
    	{
    		flag = -1;//没有笔记
    		break;
    	}

    	if(getmyNote()[i][0]==page&&getmyNote()[i][1]==0)
    		flag=-1;
    	else if(getmyNote()[i][0]==page&&getmyNote()[i][1]==1)
    	{
    		flag=i;break;//存在笔记!
    	}else {
    		//待查找page不存在，即:未添加笔记
    		flag = -1;
    	}

    }
    return flag;
  }

  //翻页
  public void turnToPage(int page)
  {
    System.out.println("为您翻到" + getTitle()  + page + "页");
    //如果有笔记输出
    if(exist( page)!=-1)
      System.out.println("Note:" + note[exist( page)]+"\n");

  }
  //添加笔记
  public String[] writeNote(int page,String str)
  {
    if(exist( page)==-1)
    {
    	this.note[sum] = str;//存放
    	getmyNote()[sum][0] = page;
    	getmyNote()[sum][1] = 1;
    	sum++;
    }else
    	System.out.println(getTitle()  + page + "页"+"已存在笔记\n");
	  return note;

  }

}

public class  Obj_Oriented_1_125 {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
		String [][]author =
			{
					{"夏目漱石"},{"袁天罡","李淳风",""},{"Arthur Conan Doyle"}
			};
		Book [] book = {
			    new Book("《吾輩は猫である》","上海译出版社",author[0]),
			    new Book("《推背图》","不详",author[1]),
			    new Book("《The Adventure of Sherlock Holmes》","比顿圣诞年刊",author[2])

			  };

		 book[0].setPage(254);//随便写的
		 book[0].setPrice(34.5);
		 book[1].setPage(211);
		 book[1].setPrice(55.0);
		 book[2].setPage(121);
		 book[2].setPrice(33);

    //输出信息\统计价格
    double Price = 0D;
		 for(int i=0;i<book.length;i++)
		 {
			 book[i].show2();
			 Price +=book[i].getPrice();
			 System.out.println();
		 }
    System.out.println("总金额:" + Price+"￥\n");

  //添加笔记：
  //3. 在一本书的第289页做笔记，笔记内容是“环境保护，从我做起”。
    book[2].writeNote(289,"环境保护，从我做起");
    //System.out.println(temp[0]);
    book[2].turnToPage(289);

    book[2].writeNote(289,"Hello World!");//存在笔记执行失败
    book[1].writeNote(23,"Hello World!"); //执行成功
    book[1].turnToPage(23);
	}
}

/**运行结果：
----------------------
书名:《吾輩は猫である》出版社名:上海译出版社
作者:夏目漱石
price:34.5￥  page:254

书名:《推背图》出版社名:不详
作者:袁天罡 李淳风
price:55.0￥  page:211

书名:《The Adventure of Sherlock Holmes》出版社名:比顿圣诞年刊
作者:Arthur Conan Doyle
price:33.0￥  page:121

总金额:122.5￥

为您翻到《The Adventure of Sherlock Holmes》289页
Note:环境保护，从我做起

《The Adventure of Sherlock Holmes》289页已存在笔记

为您翻到《推背图》23页
Note:Hello World!

----------------------

*/













126.

class Person
{
  private String ID,name,nativePlace,address;
  private char Gender;
  private int age;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNativePlace() {
		return nativePlace;
	}
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public char getGender() {
		return Gender;
	}
	public void setGender(char gender) {
		Gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void eating(String food)
	{
		System.out.println("能吃的食物" + food);
	}

	public void shopping(String goods)
	{
		System.out.println("购买" + goods);
	}
	public void sleeping(int time)
	{
		System.out.println("睡觉" + time + "小时");

	}


	public void printPerson()
	{
		System.out.println("身份证号码" + getID() + "姓名"+getName() +"性别"
				+getGender()+ "年龄" +getAge()+ "籍贯" +getNativePlace() +"住址" + getAddress() );
	}
}


public class   Obj_Oriented_1_126{

	public static void main(String[] args) {
	// TODO Auto-generated method stub
		Person p1 = new Person();
		p1.setAddress("江苏");
		p1.setAge(21);
		p1.setGender('男');
		p1.setID("340321********2779");
		p1.setName("郭洪宇");
		p1.setNativePlace("安徽");
		p1.eating("水果");
		p1.shopping("可乐");
		p1.sleeping(10);
		p1.printPerson();
	}
}
/*
能吃的食物水果
购买可乐
睡觉10小时
身份证号码340321********2779姓名郭洪宇性别男年龄21籍贯安徽住址江苏

*/








127.
/*
定义Person类（属性有姓名，年龄)，完成如下任务：
（1）在Test类中定义方法Boolean contains(Person[]per，Person temp),
        该方法判断Person数组是否有Person对象temp，
        如果数组中存在与per相同的Person对象返回boolean；//疑问：是与temp相同的对象吗

（2）定义showPerson(Person[] per)输出Person对象数组所有元素；

（3）对上面定义的方法进行测试。
*/

class Person
{
      String name;
      int age;

    public Person(String name,int age)
    {
      this.name = name;
      this.age = age;
    }
      //重写Perso类中equals()方法
      @Override
      public Boolean equals(Object obj)
      {
      //先转型
        Person person = (Person)obj;
        return (person.name + person.age).equals(this.name + this.age);
      }
}


public class   Obj_Oriented_1_127{

	public static void main(String[] args) {
	// TODO Auto-generated method stub
  Person [] per = {
    new Person("张三",18),
    new Person("李四",23),
    new Person("王五",16)
  };
  Person temp1 = new Person("张三",23);
  Person temp2 = new Person("张三",18);
  showPerson(per);
  System.out.println("temp1" + contains(per, temp1) + "\ntemp2" + contains(per, temp2));
	}
  public static 	boolean contains(Person[]per,Person temp)
  {
    Boolean FLAG = false;
    for(Person person :per)
      if(person.equals(temp))
        FLAG = true;

    return FLAG;
  }
 public static void  showPerson(Person[] per)
 {
   for(Person person:per)
     System.out.println("姓名:" + person.name +"  年龄:" + person.age);
 }
}

/**
姓名:张三  年龄:18
姓名:李四  年龄:23
姓名:王五  年龄:16
temp1false
temp2true

*/



128.

"快捷键":Alt + Shift + s
构造方法：Generate Canstructor using Fields.



class Employees
{
  /*某职工信息有工号，姓名，性别、开始工作年份、部门，职务（如项目经理、采购员等等），
  职称（分为员级、中级和高级等等）、应发工资部分包括基本工资、职务工资、职称工资（员级1200、中级2100，高级3500）、
  出差补贴、误餐补贴、地区补贴，扣除部分包括房租费、水费、电费、扣税*/
  //1-1
  private int jobNumber;
  private String name,Gender,yearOfEmployment,department,post,title;
  private double wagesPayable,basicSalary,JobSalary,TitleSalary,
                 travelAllowance,mealAllowance,regionalSubsidies,
                 deductionOfFunds,rent,waterCharges,electricityCharges,taxDeduction;


//1-2
//一个空构造方法，一个初始化职工号，姓名和部门的构造方法，一个能初始化所有数据成员的构造方法；
  public Employees() {}
  public Employees(String name, String department, int jobNumber) {
		super();
		this.name = name;
		this.department = department;
		this.jobNumber = jobNumber;
	}
  public Employees(int jobNumber, String name, String gender, String yearOfEmployment, String department, String post,
			String title,  double basicSalary, double jobSalary, double titleSalary,
			double travelAllowance, double mealAllowance, double regionalSubsidies,  double rent,
			double waterCharges, double electricityCharges) {
			super();
			this.jobNumber = jobNumber;
			this.name = name;
			Gender = gender;
			this.yearOfEmployment = yearOfEmployment;
			this.department = department;
			this.post = post;
			this.title = title;
			this.basicSalary = basicSalary;
			JobSalary = jobSalary;
			TitleSalary = titleSalary;
			this.travelAllowance = travelAllowance;
			this.mealAllowance = mealAllowance;
			this.regionalSubsidies = regionalSubsidies;
			this.rent = rent;
			this.waterCharges = waterCharges;
			this.electricityCharges = electricityCharges;

		}
	@Override
	public String toString() {
		return "Employees [jobNumber=" + jobNumber + ", name=" + name + ", Gender=" + Gender + ", yearOfEmployment="
				+ yearOfEmployment + ", department=" + department + ", post=" + post + ", title=" + title
				+ ", wagesPayable=" + wagesPayable + ", basicSalary=" + basicSalary + ", JobSalary=" + JobSalary
				+ ", TitleSalary=" + TitleSalary + ", travelAllowance=" + travelAllowance + ", mealAllowance="
				+ mealAllowance + ", regionalSubsidies=" + regionalSubsidies + ", deductionOfFunds=" + deductionOfFunds
				+ ", rent=" + rent + ", waterCharges=" + waterCharges + ", electricityCharges=" + electricityCharges
				+ ", taxDeduction=" + taxDeduction + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getYearOfEmployment() {
		return yearOfEmployment;
	}
	public void setYearOfEmployment(String yearOfEmployment) {
		this.yearOfEmployment = yearOfEmployment;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getWagesPayable() {
		return wagesPayable;
	}
	public void setWagesPayable(double wagesPayable) {
		this.wagesPayable = wagesPayable;
	}
	public double getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}
	public double getJobSalary() {
		return JobSalary;
	}
	public void setJobSalary(double jobSalary) {
		JobSalary = jobSalary;
	}
	public double getTitleSalary() {
		return TitleSalary;
	}
	public void setTitleSalary(double titleSalary) {
		TitleSalary = titleSalary;
	}
	public double getTravelAllowance() {
		return travelAllowance;
	}
	public void setTravelAllowance(double travelAllowance) {
		this.travelAllowance = travelAllowance;
	}
	public double getMealAllowance() {
		return mealAllowance;
	}
	public void setMealAllowance(double mealAllowance) {
		this.mealAllowance = mealAllowance;
	}
	public double getRegionalSubsidies() {
		return regionalSubsidies;
	}
	public void setRegionalSubsidies(double regionalSubsidies) {
		this.regionalSubsidies = regionalSubsidies;
	}
	public double getDeductionOfFunds() {
		return deductionOfFunds;
	}
	public void setDeductionOfFunds(double deductionOfFunds) {
		this.deductionOfFunds = deductionOfFunds;
	}
	public double getRent() {
		return rent;
	}
	public void setRent(double rent) {
		this.rent = rent;
	}
	public double getWaterCharges() {
		return waterCharges;
	}
	public void setWaterCharges(double waterCharges) {
		this.waterCharges = waterCharges;
	}
	public double getElectricityCharges() {
		return electricityCharges;
	}
	public void setElectricityCharges(double electricityCharges) {
		this.electricityCharges = electricityCharges;
	}
	public double getTaxDeduction() {
		return taxDeduction;
	}
	public void setTaxDeduction(double taxDeduction) {
		this.taxDeduction = taxDeduction;
	}
	public int getJobNumber() {
		return jobNumber;
	}
	public void setJobNumber(int jobNumber) {
		this.jobNumber = jobNumber;
	}

//1-4
/*功能方法有：计算职工的应发工资，计算职工的扣除工资部分，
                    计算职工的实发工资，取得职工的基本信息（职工号，姓名，性别，开始工作年份，部门），取得职工的所有个人信息。*/
  public    double    WagesPayable()
  {
    double wagesPayable = basicSalary+JobSalary+TitleSalary+travelAllowance+mealAllowance+regionalSubsidies+deductionOfFunds+rent+waterCharges+electricityCharges+taxDeduction;
    this.setWagesPayable(wagesPayable);
    return wagesPayable;
  }


  public double DeductionOfFunds()
  {
    //扣税（3000及以下不扣税，工资超过3000-8000，按8%扣除；8000以上按15%扣除）。
    double taxDeduction=0;
    if( WagesPayable()>3000&& WagesPayable()<=8000)
            taxDeduction = WagesPayable()*0.08;
    if(WagesPayable()>8000)
            taxDeduction = WagesPayable()*0.15;
    this.setTaxDeduction(taxDeduction);
	double deductionOfFunds  = rent +waterCharges+electricityCharges+taxDeduction;
    this.setDeductionOfFunds(deductionOfFunds);
    return deductionOfFunds;
  }
  public double netSalary()
  {
    double net_salary = WagesPayable() - DeductionOfFunds();
    return  net_salary>0?net_salary:-1;//实发工资应该>0;
  }
}

public class  Obj_Oriented_1_128   {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
/**
测试要求：
       （1）某微型企业有职工5人，分别设置5人的基本信息；
       （2）计算企业某月的应该给职工发的平均工资（应发部分）；
       （3）计算某月企业应该扣除的总费用（包括扣除部分）；
       （4）输出某月最高和最低工资的职员信息；
       （5）输出企业所有职员的基本信息。

*/
	//2-1
		Employees [] microEnterprise = {

				new Employees(0, "张三","男","2021-01-02","司法部","经理","高级",7080,1000,3500,350,300,120,3500,210,105),
				new Employees(1, "李四","男","2021-01-02","技术部","员工","高级",8888,1000,3500,350,300,120,3500,210,105),
				new Employees(2, "王五","男","2021-01-02","运营部","员工","高级",7080,1000,3500,350,300,120,3500,210,105),
				new Employees(3, "桂英","女","2021-01-02","售后部","员工","高级",7080,1000,3500,350,300,120,3500,210,105),
				new Employees(4, "铁柱","男","2021-01-02","技术部","经理","高级",7080,1000,3500,350,300,120,3500,210,105),
				new Employees(5, "王二狗","男","2021-01-02","技术部","经理","高级",2000,1000,3500,350,300,120,3500,210,105)
		};
	//2-2
	double Sum1 = 0D,average =0D,Sum2=0D;
	for(Employees em:microEnterprise)
	{
		Sum1+=em.WagesPayable();
		Sum2+=em.DeductionOfFunds();

	}
	average = Sum1/microEnterprise.length;
	System.out.println("平均工资"+average + "\n总扣除费用" + Sum2);

	//2-3 & 2-4
	Employees minSalary=microEnterprise[0],maxSalary=microEnterprise[0];
	for(int i=0;i<microEnterprise.length;i++)
	{
		if(minSalary.WagesPayable()>microEnterprise[i].WagesPayable())
			minSalary = microEnterprise[i];
		if(maxSalary.WagesPayable()<microEnterprise[i].WagesPayable())
			maxSalary = microEnterprise[i];
		System.out.println(microEnterprise[i]);
	}
	System.out.println("最高工资\n" + maxSalary);
	System.out.println("最低工资\n" + minSalary);
	}
}
/**运行结果：
----------------------
平均工资15619.666666666666
总扣除费用36947.7
Employees [jobNumber=0, name=张三, Gender=男, yearOfEmployment=2021-01-02, department=司法部, post=经理, title=高级, wagesPayable=24829.5, basicSalary=7080.0, JobSalary=1000.0, TitleSalary=3500.0, travelAllowance=350.0, mealAllowance=300.0, regionalSubsidies=120.0, deductionOfFunds=6239.75, rent=3500.0, waterCharges=210.0, electricityCharges=105.0, taxDeduction=2424.75]
Employees [jobNumber=1, name=李四, Gender=男, yearOfEmployment=2021-01-02, department=技术部, post=员工, title=高级, wagesPayable=27179.9, basicSalary=8888.0, JobSalary=1000.0, TitleSalary=3500.0, travelAllowance=350.0, mealAllowance=300.0, regionalSubsidies=120.0, deductionOfFunds=6510.95, rent=3500.0, waterCharges=210.0, electricityCharges=105.0, taxDeduction=2695.95]
Employees [jobNumber=2, name=王五, Gender=男, yearOfEmployment=2021-01-02, department=运营部, post=员工, title=高级, wagesPayable=24829.5, basicSalary=7080.0, JobSalary=1000.0, TitleSalary=3500.0, travelAllowance=350.0, mealAllowance=300.0, regionalSubsidies=120.0, deductionOfFunds=6239.75, rent=3500.0, waterCharges=210.0, electricityCharges=105.0, taxDeduction=2424.75]
Employees [jobNumber=3, name=桂英, Gender=女, yearOfEmployment=2021-01-02, department=售后部, post=员工, title=高级, wagesPayable=24829.5, basicSalary=7080.0, JobSalary=1000.0, TitleSalary=3500.0, travelAllowance=350.0, mealAllowance=300.0, regionalSubsidies=120.0, deductionOfFunds=6239.75, rent=3500.0, waterCharges=210.0, electricityCharges=105.0, taxDeduction=2424.75]
Employees [jobNumber=4, name=铁柱, Gender=男, yearOfEmployment=2021-01-02, department=技术部, post=经理, title=高级, wagesPayable=24829.5, basicSalary=7080.0, JobSalary=1000.0, TitleSalary=3500.0, travelAllowance=350.0, mealAllowance=300.0, regionalSubsidies=120.0, deductionOfFunds=6239.75, rent=3500.0, waterCharges=210.0, electricityCharges=105.0, taxDeduction=2424.75]
Employees [jobNumber=5, name=王二狗, Gender=男, yearOfEmployment=2021-01-02, department=技术部, post=经理, title=高级, wagesPayable=18225.5, basicSalary=2000.0, JobSalary=1000.0, TitleSalary=3500.0, travelAllowance=350.0, mealAllowance=300.0, regionalSubsidies=120.0, deductionOfFunds=5477.75, rent=3500.0, waterCharges=210.0, electricityCharges=105.0, taxDeduction=1662.75]
最高工资
Employees [jobNumber=1, name=李四, Gender=男, yearOfEmployment=2021-01-02, department=技术部, post=员工, title=高级, wagesPayable=27179.9, basicSalary=8888.0, JobSalary=1000.0, TitleSalary=3500.0, travelAllowance=350.0, mealAllowance=300.0, regionalSubsidies=120.0, deductionOfFunds=6510.95, rent=3500.0, waterCharges=210.0, electricityCharges=105.0, taxDeduction=2695.95]
最低工资
Employees [jobNumber=5, name=王二狗, Gender=男, yearOfEmployment=2021-01-02, department=技术部, post=经理, title=高级, wagesPayable=18225.5, basicSalary=2000.0, JobSalary=1000.0, TitleSalary=3500.0, travelAllowance=350.0, mealAllowance=300.0, regionalSubsidies=120.0, deductionOfFunds=5477.75, rent=3500.0, waterCharges=210.0, electricityCharges=105.0, taxDeduction=1662.75]

----------------------

*/


























130.
/**
设计一个学生类，要求如下：

1. 学生基本特征包括学号，姓名，Java程序设计和数据结构课程成绩；

2. 设计一个能初始化学号，姓名等特征的构造方法；另一个构造方法能初始化所有学生特征；

3. 学生行为包括：(1)计算某个学生的总分和平均分;
(2)输出学生的学号、姓名、总分和平均分；（3）设计一个学生上课的方法，该方法有3个参数，
一个参数表示上课时间，另一个参数表示课程名称，第三个参数表示上课地点。

测试要求如下：

1.创建包括所有特征的2个学生对象；

2.  输出这2个学生的总分和平均分；

3. 第一个学生在2017年9月29日，在3223学习Java课程；第二个学生在2017年9月29日，在1402学习数据结构。
*/

class Student
{
  //1.
    String StudentID;
	String name;
    double javaScore,dataStructureScore,Sum,Avg;
 //2.
    public Student(String studentID, String name) {
    	super();
    	StudentID = studentID;
    	this.name = name;
    }

    public Student(String studentID, String name, double javaScore, double dataStructureScore) {
		super();
		StudentID = studentID;
		this.name = name;
		this.javaScore = javaScore;
		this.dataStructureScore = dataStructureScore;
		Sum = 0D;
		Avg = 0D;
		SumAvg();
	}

//3-1
 public void SumAvg()
 {
   this.Sum = javaScore + dataStructureScore;
   this.Avg = Sum/2;
 }
 //3-2
 @Override
 public String toString()
 {
   return "学号  " +  StudentID + "姓名  "+ name + "总分  "+Sum + "平均分  "+Avg;
 }
 //3-3
 public void Study(String time,String lesson ,String classRom)
 {
   System.out.println(name + "在" + classRom + "上" + lesson +"课");
 }

}
public class Obj_Oriented_1_130 {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
//测试
		Student stu1 = new Student("TS0322","狂徒",100,100);
		Student stu2 = new Student("TS0321","张三",89,98);
		System.out.println("总分"+stu1.Sum +"平均分"+stu1.Avg);
		System.out.println("总分"+stu2.Sum +"平均分"+stu2.Avg);

		System.out.println(stu1 +"\n" + stu2);
		stu1.Study("2017-09-29", "Java", "3223");
		stu2.Study("2017-09-29", "数据结构", "1402");
	}
}

/*
总分200.0平均分100.0
总分187.0平均分93.5
学号  TS0322姓名  狂徒总分  200.0平均分  100.0
学号  TS0321姓名  张三总分  187.0平均分  93.5
狂徒在3223上Java课
张三在1402上数据结构课

*/

132.
/**
设计CPU类，要求如下：
  （1）私有数据成员包括型号，频率，价格，寄存器；
  （2）一个空构造方法，一个初始化型号，频率，价格的构造方法；
  （3）写出设置寄存器和读取寄存器数据的setter和getter方法；
  （4）功能方法：模拟CPU发出运算指令从内存中读取数据到寄存器，把CPU中寄存器的数据写入内存。

设计内存类RAM，要求如下：
  （1）频率，大小，当前保存的数据；
  （2）一个空构造方法；
  （3）一个setter方法把数据保存在RAM中，一个getter方法取得RAM中的数据。

测试要求：构造一个CPU对象，测试两个功能方法。
*/
package Obj_Oriented_1;

class CPU
{

  String model,frequency,register;
  double price;
  public CPU() {
		super();
	}

	public CPU(String model, String frequency, double price) {
		super();
		this.model = model;
		this.frequency = frequency;
		this.price = price;
	}
	public String getter() {
	return register;
}
	public void setter(String register) {
		this.register = register;
	}

	public int control(RAM ram)
	{
		if(ram.getter()!=null)
		{
			this.setter(ram.getter());//获取内存信息->寄存器

		}else
		{
			System.out.println("内存为空");
			return -1;
		}
		//对获取的信息稍做修改在传回到内存
		this.setter("嘿嘿Hello World!");
		//回传
		ram.setter(this.getter());
		return 0;
	}
}

//内存
class RAM
{
  String frequency,dataSave=null;
 int size;
 public RAM() {
	super();
 }

 public RAM(String frequency, String dataSave, int size) {
	super();
	this.frequency = frequency;
	this.dataSave = dataSave;
	this.size = size;
}

public void setter(String dataSave)
 {
	 this.dataSave = dataSave;
 }
 public String getter()
 {
	 return this.dataSave;
 }

}

public class  Obj_Oriented_1_132{

	public static void main(String[] args) {
	// TODO Auto-generated method stub
		//CPU
		CPU cpu = new CPU("Matisse","3.8-4.6GHz",3099);
		RAM ram = new RAM();
		cpu.control(ram);
		ram.setter("测试信息！");
		System.out.println("ram.dataSave ->" + ram.dataSave + "\ncpu.register->" +  cpu.register);

		System.out.println("cpu.control(ram)");cpu.control(ram);
		System.out.println("ram.dataSave ->" + ram.dataSave + "\ncpu.register->" +  cpu.register);
	}
}
/**
内存为空
ram.dataSave ->测试信息！
cpu.register->null
cpu.control(ram)
ram.dataSave ->嘿嘿Hello World!
cpu.register->嘿嘿Hello World!
*/


