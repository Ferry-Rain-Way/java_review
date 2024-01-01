package Test;
/*
 * 时间：2022/3/15/15点54分
 * 编程目标：
 * 			“今天讲的东西都针对于我们自己写的类”
 * 			即：我们自己写的类为了实现某个功能而手动重写某个方法
 *
 *			【先看程序,找问题】
 *
 * 			本程序目标:为了让我们写的类在添加到
 * 			Hashtable HashSet HashMap集合之后当出现重
 * 			复添加同一个元素时,不会抛异常,且只
 * 			计算1个长度
 *
 *
 * 			一、向Set集合中添加我们自己写的类的对象
 * 					“去重”问题
 * 					“Set” 不允许重复？
 *
 * 					1-1.Set 的重复问题:当向集合中添加的对象是eclipse中的
 * 							当元素出现重复,“编辑器”报错吗？->不会
 * 							当元素出现重复,“运行”出错吗?	->不会
 * 					1-2.讨论Set 的重复问题:当向集合中添加的对象是我们自己写的
 * 							当元素出现重复,“编辑器”报错吗？->不会
 * 							当元素出现重复,“运行”出错吗?	->不会
 *
 *						思考:这是我们想要的结果吗?
 *								->很明显,不是滴
 *
 *
 * 					2.“为什么”重写HashCode()、equals()方法
 *						 	->详见:本程序目标
 *							------------------------
 *							以HashMap为例:
 *							hashCode()方法执行结果返回一个Hash值,通过Hash算法可以推出“数组下标”
 *							当对应数组为空直接讲元素添加进去，当素组元素不为空时,通过equals方法
 *							比较数组中的每一个元素,若直至数组的末尾返回的都是false,则将元素添加到
 *							数组的末尾,若比较过程中返回了true,则使用当前元素对旧元素进行覆盖
 *							-------------------------
 *							总结：先分“桶”,【hashCode()】
 *									再“查重” 【equals()】
 *		 				Hash算法：数据结构Page:293
 *							------------------------
 * 					3.那些类需要重写?
 *							->Hashtable HashSet HashMap
 * 							思考:TreeSet和TreeMap则不需要实现equals(方法和hashCode()方法
 * 								->TreeSet的实现不是基于Hash算法
 * 					4.“如何”重写HashCode()、equals()方法
 *							->“合理的”的重写HashCode()方法
 *								见【案例分析-- return 1;的合理性?】
  *							-------------------------
  *							哈希表HashMap使用不当时无法发挥性能!
  *							假设将所有的hashCode()方法返回值固定为某个值,那么会导致底层哈希表变成了
  *							纯单向链表。这种情况我们成为:散列分布不均匀。
  *							什么是散列分布均匀?
  *							假设有100个元素, 10个单向链表，那么每个单向链表上有10个节点,这是最好的，
  *							是散列分布均匀的。
  *							假设将所有的hashCode()方法返回值都设定为不一样的值,可以吗,有什么问题?
  *							不行，因为这样的话导致底层哈希表就成为-维数组了,没有链表的概念了。
  *							也是散列分布不均匀。
  *				    散列分布均匀需要你重写hashCode()方法时有一定的技巧
  *							------------------------
  *								->利用eclipse中已经重写好的类
  * 									比如常用的包装类
  * 					5.toString()重写:Alt + Shift + s + o
  *           6.HashMap集合中size的长度问题【案例:Person_HashMap】
 * 							->key相同,value值覆盖,长度只计算一个
 *              HashMap、Hashtable集合中key及value的null问题
 *              HashMap ->key,value都可以为空
 *              Hashtable ->key、value都不能为空,否则抛出空指针异常
 */

//引包
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

class Student {
	String name ;
	int age;
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	  @Override
	  public int hashCode(){
	    return (name+age).hashCode();
	  }

	  @Override
	  public boolean equals(Object obj){
	    /*旧代码：
		  Student stu = (Student)obj;
	    return (stu.name+stu.age).equals(this.name + this.age);
	    */
      /**
      时间：2022/03/17/10：08
      代码优化：
      1.类型转换
      2.空
      3.当前对象于当前对象进行比较
      */
      if(obj==null||!(obj instanceof Student))
			  return false;
		  if(obj==this)
			  return true;
		  Student stu = (Student)obj;
		  return   (stu.name+stu.age).equals(this.name + this.age);
	  }

	  @Override
	  public String toString(){
	    return "name" + this.name + "age" + this.age;
	  }

}


public class HashCode_equals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<Student> s = new HashSet<>();//注解①
		s.add(new Student("张三",21));
		s.add(new Student("李四",32));
		s.add(new Student("王五",32));


		Iterator  it = s.iterator();
		while(it.hasNext()) {
			Student stu =(Student) it.next();
			System.out.println(stu);

		}
		System.out.println(s.size());



/*
		Set<Integer> s = new HashSet<>();
		s.add(5);
		s.add(5);
		for(Integer i:s)
				System.out.println(i);

		System.out.println("s的长度:" + s.size());

/*
 * 1>如果s的长度为1 ->说明系统提供的类已经实现“去重”功能
 * 2>如果s的长度为2 ->..............没有实现“去重”...
 *
 * 结果:?
 *
 */
	}

}

/**
注解①
		Java1.7以后，"后面"的<>中的具体的数据类型可以省略不写
    	类名<具体的数据类型> 对象名= new 类名<>():
*/
--------------------------------------------------------------------------
/*
 * 时间：2022/3/15/17点03分
 * 编程目标：
 * 			“今天讲的东西都针对于我们自己写的类”
 * 			即：我们自己写的类为了实现某个功能而手动重写某个方法
 *
 * 		【先看程序,找问题】
 *
 * 			本程序目标:为了让我们写的类在添加到
 * 			ArrayList 、 LinkedList集合之后
 * 			可以实现排序
 *
 * 			二、排序Comparable接口
 *		           基本类型数据和String类型数据，它们彼此的比较标准Java语言本身已经提供好了
 *		           用户"自定义类对象"之间比较的标准Java语言本身是没有提供
 *		           所以如果一个容器中含有用户自定义类型的数据，并且我们
 *         		  需要对容器中元素进行"排序"，或"查找"某一元素时，我们就必
 *		            须得制定容器中元素与元素之间比较的标准
 *			      凡是需要进行对象比较/排序的场合均可考虎实现Comparable接口
 *
 *			  看源码、帮助文档
 *			   Ctrl + Shift + t
 *
 *
 * 升序:
 * this > obj  return 1
 * 或
 * this.A.compareTo(obj.A)
 *
 */

package Test;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;


class Person implements Comparable {
	String name ;
	int age;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Object obj) {
		Person per = (Person)obj;

		if(this.age==per.age)
			return 0;
		else if(this.age>per.age)
				return 1;
		else
			return -1;
//		return (this.name + this.age).compareTo(per.name   + per.age);
//		Integer i1 = age,i2 = per.age;
//		return i1.compareTo(i2);

	}
	@Override//注解④
	public String toString() {
		return "name:->" + this.name + "<-age" + this.age ;
	}
}

public class TestComparable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Person> s = new ArrayList<>();
		s.add(new Person("bb",45));
		s.add(new Person("ac",30));
		s.add(new Person("gh",32));


	//	s.sort(c);//正确吗？//注解②
		Collections.sort(s);//注解③
		System.out.println(s);


/*
		List<Integer> s = new ArrayList<>();
		s.add(45);
		s.add(30);
		s.add(32);
		Collections.sort(s);
		System.out.println(s);
*/
	}

}

/*
注解②:
	不正确:“说白了就是没有这个方法”
		Collection接口的实现类，如ArrayList 、 LinkedList本身
		并没有提供排序，倒置，查找等方法，这些方法是由
		Collections类来实现的，该类有很多public static方法，可
		以直接对Collection接口的实现类进行操作


注解③
	注意:Collection 和 Collections 不是同一个东西
	有s的是类,有静态方法可以使用
	没有s的是接口
 */

