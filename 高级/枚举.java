#### 枚举
##### 基本概念
```java
1.为什么需要枚举
          我的理解：解决语法上没错，但逻辑上输入不合法的问题
                              【限制范围】

2.定义：
          枚举指一组固定的"常量"组成的"类型"

3.使用：
          [访问控制符] enum 枚举名{
                    常量值,常量值
          }

          例如：
          enum Genders{
          	男,女
          }
          class Student {
          	Genders sex;

          }
          public class ENUM {

          	public static void main(String[] args) {

          		Student stu = new Student();
          		stu.sex = Genders.女;
          		System.out.println(stu.sex);
          		stu.sex = Genders.valueOf("男");
          		System.out.println(stu.sex);
          		stu.sex = Genders.valueOf("nv");//无枚举常量,抛出IllegalArgumentException异常
          	}
          }
          /*
          女
          Exception in thread "main" 男
          java.lang.IllegalArgumentException: No enum constant 枚举.Genders.nv
          	at java.lang.Enum.valueOf(Unknown Source)
          	at 枚举.Genders.valueOf(ENUM.java:1)
          	at 枚举.ENUM.main(ENUM.java:19)
          */

4.枚举的好处:
          类型安全
          易于输入
          代码清晰

5.实战演练：
          根据用户输入今天星期几，对用户一周做的事情做提示

          1>我写的：
                     enum Week{//注解①
                      一,二,三,四,五,六,日
                    }
                    class ToDo
                    {
                    	Week today;

                     	public  ToDo(String  week){
                               try{
                                         this.today = Week.valueOf(week);
                               }catch(IllegalArgumentException e){
                                         System.out.println("No enum constant");
                                         System.exit(-1);//退出
                               }
                               if(today==Week.一||today==Week.二||today==Week.三
                            		   ||today==Week.四||today==Week.五)
                                         System.out.println("上班");
                               else
                                         System.out.println("休息");
                     }
                    }

                    public class Enum_Exercise01 {

                    	public static void main(String[] args) {
                    		// TODO Auto-generated method stub
                    		ToDo todo = new ToDo("一");
                    	}


          2>老师写的：
                    使用switch  case 语句          JDK7以后，switch已经支持 int、char、String、enum 类型的参数

   /**
 注解①：

                    疑问：此处为什么加public 会报错
                    查找enum 的本质是什么,感觉像是一种特殊的类
                    所以使用 public 会与主类冲突

                    枚举类和普通类的区别是什么：
                    a. 使用enum定义的枚举类默认继承了java.lang.Enum类；
                    b. 枚举类的构造器只能使用private访问控制符；
                    c. 枚举类的所有实例必须在枚举类中显式列出(, 分隔 ;结尾)。列出的实例系统会自动添加public static final修饰；
                    【增加：】java中枚举都继承自java.lang.Enum类，所以枚举类不能继承别的类，但是可以实现接口
                   原文链接：https://blog.csdn.net/Mind_programmonkey/article/details/117200105

*/
          https://www.cnblogs.com/happyPawpaw/archive/2013/04/09/3009553.html
          https://www.cnblogs.com/fantyovo/p/14769799.html?ivk_sa=1024320u
```
##### 包装类
```java
1.包装类及其作用
          1>Object：
                    Boolean
                    Number :Byte Short  Integetr Long Float Double等
                    Character

          2>作用：
                    提供了一系列实用的方法
                    "集合不允许存放基本数据类型,存放数字时,要使用包装类型,
                    但对于基本数据类型，由于有了‘装箱’和‘拆箱’的存在,因而
                    系统将自动完成基本数据类型向包装类的转换"

                    /**
                    import java.util.ArrayList;
                    import java.util.List;

                    List list = new ArrayList();
                    list.add(Object);//此处按理说是参数对象,
                    但可以直接使用基本数据类型,原因见上

                    */

          3>使用：
                    1]以每个包装类对应的某本数据类型作为参数
                    //基本教据类型-->包装类
                              double d = 88;
                              Double D = new Double(d);

                     2]除Character以外，以字符串作为参数
                              Double D = new Double("87.9");
                              System.out.println(D+1);//是88.9,不是87.91

                    3] 注意：
                              1.Character传参使用''
                              2.对于布尔类型数据,若"使用字符串传参"
                                        1>内容只要是true/false 即可,不区分大小写
                                                  Boolean b = new Boolean("TrUe");
                                                  System.out.println(b);//true

                                        2>内容若不是true/false 则结果显示false
                                                  Boolean b = new Boolean("hello");
                                                  System.out.println(b);//false
                                                  /**Boolean(String s)源码
                                                      public Boolean(String s) {
                                                          this(parseBoolean(s));
                                                      }

                                                       public static boolean parseBoolean(String s) {
                                                          return ((s != null) && s.equalsIgnoreCase("true"));
                                                      }
                                                  */



2.包装类的常用方法
          1>...value() 包装类转换成"基本类型"
                    byteValue()、shortValue()、intValue()等8种方法

                    Integer integer = new Integer(25);
                    int i =  integer.intValue();

          2> Type.toString() 以字符串形式返回包装对象表示的基本类型数据("基本类型->字符串")
                    String sex=Character.toString('男');
                    String id = Integer.toString(25);
                    /**还是那句话:由Oracle公司提供的可以重写toString的类都重写了toString方法
                    【几乎所有】
                        源码举例：
                        public static String toString(char c) {
                            return String.valueOf(c);
                        }
                    */
                    最常用的还是String str = Type + "";

          3> parse...() 除了Character,把字符串转换为相应的基本数据类型数据
                    int num=Integer.parselnt("36");
                    boolean bool=Boolean.parseBoolean("false");






          4> valueOf()Character,把字符串转换为相应包装类
                    String f1ag = "china";
                    Boolean bFlag = Boolean.valueOf(f1ag);
                    System.out.println(bFlag);//false

                    /**
                        public static Boolean valueOf(String s) {
                            return parseBoolean(s) ? TRUE : FALSE;
                        }
                    */

3.装箱和拆箱
          基本类型和包装类的自动转换
          Integer intObject = 5;
          int intValue= intObject;

          装箱:基本类型转换为包装类的对象
          拆箱:包装类对象转换为基本类型的值






```

/**
eclips快捷键：
1.:Alt + Shift + s
          构造方法：Generate Canstructor using Fields.

查看源码：
          ctr+shift+t：快速找到某个类
          ctr+t:查看当前类的子类

*/




