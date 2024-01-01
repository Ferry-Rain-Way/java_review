### 7> 泛型

#### 什么是泛型

##### 背景

```java
JAVA推出泛型以前，程序员可以构建一个元素类型为Object
的集合，该集合能够存储任意的数据类型对象，而在使用该集合的
过程中，需要程序员明确知道存储每个元素的数据类型，否则很容
易引发ClassCastExceptian异常。

ArrayList list = new ArrayList();
list.add("hello");
list.add(12);
list.add(true);

for(int i=0;i<list.size();i++)
{
    Object obj = list.get(i);
    String str = (String)obj;//当obj 为Integer对象时，抛出异常
    System.out.println(str);
}

```



##### 泛型的概念

```java
泛型的概念
Jeva泛型 (generics) 是JDK5中引入的一个新特性，泛型提供了编译时类型安全监测机制，
该机制允许我们在编译时检测到非法的类型数据结构。
泛型的本质就是"参数化类型"，也就是所操作的数据类型被指定为一个参数

```



##### 泛型的好处

```java
类型安全
消除了强制类型的转换
```



#### 泛型类、泛型接口

##### 泛型类

###### 1.泛型类的定义语法

```java
1.泛型类的定义语法
    class 类名 <泛型标识,泛型标识,...>
    {
        private 泛型标识 变量名;
        ..........
    }

    常用的泛型标识：T、E、K、V

E - Element (在集合中使用，因为集合中存放的是元素)
T - Type（Java 类）
K - Key（键）
V - Value（值）
N - Number（数值类型）
？ -  表示不确定的java类型
S、U、V  - 2nd、3rd、4th types
```

###### 2.泛型类的使用语法

```java

2.泛型类的使用语法 //泛型类在创建对象的时候，来指定操作的具体数据类型.
    1> 类名<具体的数据类型> 对象名  = new 类名<具体的数据类型>();

	2> Java1.7以后，"后面"的<>中的具体的数据类型可以省略不写
    	类名<具体的数据类型> 对象名= new 类名<>():
	3> 泛型类在创建对象的时候，没有指定类型，将按照Object类型来操作
    4> 泛型类不支持基本数据类型
	5> 同一泛型类，根据不同的数据类型创建的对象，本历上是同一类型
        【即：类类型】

举例：

    class Test <K,V>{
        private K name;
        private V age;

        public Test(K name, V age) {
            super();
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Test [name=" + name + ", age=" + age + "]";
        }
    }
    public class test_01 {

        public static void main(String[] args) {
        // TODO Auto-generated method stub
        Test<String,Integer> t1 = new Test<>("冰墩墩",21);
		System.out.println(t1);
		Test<String,Double> t2 = new Test<>("冰墩墩2",22.0);
		System.out.println(t2);
		//泛型类在创建对家的时候，没有指定类型，将按照Object类型来操作
		Test t3 = new Test("s",3);
		System.out.println(t3);
		//
		System.out.println(t1.getClass());
		System.out.println(t2.getClass());
		System.out.println(t1.getClass()==t2.getClass());
        }
    }
   //---------------运行结果： ---------------
   Test [name=冰墩墩, age=21]
    Test [name=冰墩墩2, age=22.0]
    Test [name=s, age=3]
    class 泛型.Test
    class 泛型.Test
    true


```



###### 从泛型类派生子类

```java
    子类也是泛型类，子类和父类的标识要一致,或子类中含有父类的泛型标识
        class ChildGeneric<T> extends Generic //此时父类默认 Object 类型
        class ChildGeneric<T> extends Generic<T>
        class ChildGeneric<T,K,V> extends Generic<T>
    子类不是泛型类，父类要明确泛型的数据类型
    	class ChildGeneric extends Generic<String>

```


#####  泛型接口

```java
泛型接口的定义语法
interface 接口名称 <泛型标识,泛型标识,...>
{
    泛型标识 方法名();
    ....

}
实现类不是泛型类，接口要明确数据类型
实现类也是泛型类，实现类和接口的泛型标识要一致,或实现类包含接口泛型标识
    //泛型接口
    interface GenericInterface <T>{
    	T getValue();
    }
    //泛型类
    class  TestGenic implements GenericInterface<String>{
    	@Override
    	public String getValue()
    	{

    		return "";
    	}
    }

    class TestGe <T,E> implements GenericInterface<T>{
    	@Override
    	public T getValue()
    	{
    		T a1 = null;
    		return a1;
    	}
    }
```



##### 泛型方法
```java
    1.
        泛型类,是在实例化类的时候指明泛型的具体类型
        泛型方法,是在调用方法的时候指明泛型的具体类型

    2.语法:
        修饰符 <T,E,...> 返回值类型 方法名(形参列表){
            方法体..
        }

    3.public与返回值中间<T>非常重要,可以理解为声明此方法为泛型方法

    4.只有声明了<T>的方法才是泛型方法,泛型类中的使用了泛型标识的成员方法
        并不是泛型方法

    5.  <T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T

    6.与泛型类的定义一样,此处T可以随便写为任意标识，常见的如T、E、K、V等形
        式的参数常用于表示泛型

    7.泛型方法中泛型标识列表中的方法与泛型类的泛型列表无关

    8.非泛型类中可以含有泛型方法

    9.泛型方法可以设置为 static ,含泛型标识的非泛型方法不可声明为 static
        换句话说,如果static方法要使用泛型能力,就必须使其成为泛型方法


/**--------
拓展：
对象名.getClass().getSimpleName()
可以达到查看此对象的类型
----------*/
//我看到的比较有意思的一个方法
    public <E> void print(E... e)
    {
        for(E e1:e){
            System.out.println(e);
        }
    }
```



#### 类型通配符

##### 什么是类型通配符
```java
    类型通配符一般是使用"?"代替具体的类实参
    所以,类型通配符是类型实参,而不是类型形参

    class Box <E>
    {
    	private E first;

    	public E getFirst() {
    		return first;
    	}

    	public void setFirst(E first) {
    		this.first = first;
    	}

    }


    class TestBox{
        public static void main (String [] args)
        {
            Box<Number> box1 = new Box<>();
            box1.setFirst(100);
            showBox(box1);



            Box<Integer> box2 = new Box<>();
            box2.setFirst(200);
            showBox(box2);//注意此处
            /**
            错误分析:
                按照我们通常的思维：Integer Extends Number
                根据多态的思想，此处是正确的,但注意,我们说不管
                是 Integer ,Number ,Object 在此处其本质都是同
                一种类型，类类型，因而无法构成重载

            */
        }

    //    public static void showBox(Box<Number> box)
    //    {
    //        Number first = box.getFirst();
    //        System.out.println(first);
    //    }
        public static void showBox(Box<?>box) {

        }
      //  public static void showBox(Box<Integer> box)
       // {
          /**
          error
          分析：根据泛型的使用语法知识我们知道：

          >	5> 同一泛型类，根据不同的数据类型创建的对象，本历上是同一类型
          >【即：类类型】

             他们的本都是同一类型，即Box类类型,对于个数相同，类型相同的
             方法，他们是无法构成重载的
          */
    //    }
    }
```





##### 类型通配符的上限

```java

语法
    类/接口 <? extends 实参类型>

    要求该泛型的类型，只能是实参类型，或实参类型的子类类型
    "重点：类型通配符的上限 list 是无法添加元素的,即使你的格式是正确的"
    例如:现在有
        Animals
        Cat extends Animals
        MinCat extends Cat

    public static void main (String []args){
        ArrayList<Animals> animals = new ArrayList<>();
        ArrayList<Cat> cat = new ArrayList<>();
        ArrayList<MinCat> mincat = new ArrayList<>();

        //showAnimal(animals);//error
        showAnimal(cat);//true
        showAnimal(mincat);//true

    }
    有一方法：
//1.泛型上限通配行，传递的集合类型，只能是Cat 或Cat的子类类型

    public static void showAnimal(ArrayList<? extends Cat> list){//类型通配符的上限为Cat
/*
"重点：类型通配符的上限 list 是无法添加元素的,即使你的格式是正确的"
list.add(new Cat());//error

解释：使用上限通配符，无法确定当前类型，比如当前类型为MinCat ,
            但你对list中添加 new Cat()明显这是不正确的就，也是解释不通的
*/
    }


对于addAll()方法，也遵循这样的规律：
当A被B继承,B被C继承
当B 创建对象时，b.addAll(t);
//则t只能是 b对象 或者是 c对象
```


##### 类型通配符的下限

```java
语法

类/接口<? super 实参类型>

    要求该泛型的类型，只能是实参类型，或实参类型的父类类型

    类型通配符下限list 中可以添加 当前限制的类型和其子类类型
    举例：
          public static void showAnimal(ArrayList<? super < Cat> list){
              list.add(new MinCat());
              list.add(new Cat());
              /*list.add(new Animals());//error
              我的分析：
             类型通配符下限list  集合的当前类型虽然不确定，
             但可以肯定的是 当前类型一定是Cat 的父类或 Cat 类型
             因而在此处可以添加 Cat 以及MinCat 对象，这是不违反
             多态的向下转型的知识的
          */
          }


```















