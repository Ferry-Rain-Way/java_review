1.
             代码：
                          //生成集合ai,构造一个具有指定初始容量为10的空列表
                          //查阅源码可知,当使用空构造方法时,初始容量也为10
                          ArrayList ai = new ArrayList(10);

                          //将指定的元素插入此列表中的指定位置。向右移动当前位于该位置的元素（如果有）以及所有后续元素（将其索引加 1）
                          ai.add(0, new Integer(20));
                          ai.add(1, new Long(1234));
                          ai.add(2, new String("xyz"));
                          ai.add(3, new Object());

                          //获取ai 列表的第1、2个元素
                          Integer i=(Integer) ai.get(0);
                          String s = (String) ai.get(2);
                          //将获取的第一个元素向上转型
                          Object o = ai.get(0);


                          //Begin该部分同上不在赘述-----
                          List ls = new ArrayList(10);

                          ls.add(0, new String("abc"));
                          ls.add(1, new Integer(2));
                          ls.add(2, new Date());
                          //End---------------------

                           //输出ai
                          //“改错：Integer ->Object ”
                          for(Object num:ai){
                          System.out.println(num);     }

                          //输出ls
                          for(Object obj:ls)
                          {
                          	  System.out.println(obj);
                          }
                          /**---------------------
                          运行结果：
                          20
                          1234
                          xyz
                          java.lang.Object@52e922
                          abc
                          2
                          Sat Mar 12 10:37:59 CST 2022


                         ------------------------ */


2.
             题目：
             (2)编写程序掌握List集合的基本使用，要求如下:
                          1) 创建一个只能容纳String对象名为name 的ArrayList集合;
                          2)按顺序往集合中添加5个字符串对象:“张三”、“李四”、“王五”“马六”、“赵七”
                          3)对集合进行遍历,分别打印集合中的每个元素的位置与内容;
                          4)首先打印集合的大小，然后删除集合中的第.3个元素,并显示删除元素的
                                       内容,然后再打印目前集合中第3个元素的内容，并再次打印集合的大小

             代码：
                          import java.util.LinkedList;
                          public class StudentList  {

                          	public static void main(String[] args) {
                          	// TODO Auto-generated method stub

                                       //1) 创建一个只能容纳String对象名为name 的ArrayList集合;
                                                    LinkedList <String>  stuList = new LinkedList<>();
                                       // 2)按顺序往集合中添加5个字符串对象:“张三”、“李四”、“王五”“马六”、“赵七”
                                                    stuList.add("张三");
                                                    stuList.add("李四");
                                                    stuList.add("王五");
                                                    stuList.add("马六");
                                                    stuList.add("赵七");
                                       // 3)对集合进行遍历,分别打印集合中的每个元素的位置与内容;
                                                    for(int i=0;i<stuList.size();i++){
                                                    System.out.println("第" + (i+1)+ "个元素:" + stuList.get(i));
                                                    }
                                       /*4)首先打印集合的大小，然后删除集合中的第3个元素,并显示删除元素的
                                       内容,然后再打印目前集合中第3个元素的内容，并再次打印集合的大小*/
                                                    System.out.println("目前的集合大小为:" + stuList.size());
                                                    //删除前保存元素
                                                    Object obj = stuList.get(2);//此处使用String也可,get(index);下标从零开始
                                                    stuList.remove(2);
                                                    System.out.println("删除的第三个元素内容为:" + obj);

                                                    //删除后的第三个元素
                                                    System.out.println("删除操作后,集合的第三个元素内容为:" + stuList.get(2));
                                                    System.out.println("删除操作后,集合的大小为:" + stuList.size());

                          	}
                          }

3.
             题目：
             (3)编写程序掌握Map集合的基本使用，要求如下:

                          1)创建一个只能容纳String对象的person的HashMap集合;

                          2)往集合中添加5个“键-值”对象:
                                       id->”1”
                                       name->”张三”
                                       sex->”男”
                                       age->”25”
                                       love->”爱学Java”
                          3)对集合进行遍历,分别打印集合中的每个元素的键与值;
                          4)首先打印集合的大小，然后删除集合中的键为age的元素,并显示删除元素
                          的内容，并再次打印集合的大小

             代码：

                          import java.util.HashMap;
                          import java.util.Iterator;
                          import java.util.Map;
                          import java.util.Set;

                          class Person <T>{
                               T value;
                              public   Person (T value){
                                           this.value = value;
                              }


                              //重写hasCode()方法
                              @Override
                              public int hashCode(){
                                           return this.value.hashCode();
                              }
                              //重写equals()方法
                              @Override
                              public boolean equals(Object obj){
                                           Person<T> p = (Person<T>)obj;
                                           return p.value.equals(this.value);
                              }
                          }
                          public class Person_HashMap {

                          public static void main(String[] args) {
                              	// TODO Auto-generated method stub
                              	//1)创建一个只能容纳String对象的person的HashMap集合;//没太懂这句话是啥意思就这么写了
                              	             Map<String,Person>  hm = new HashMap<String,Person> ();
                              	//2)往集合中添加5个“键-值”对象:
                                                        hm.put("id",new Person<String>("1"));
                                                        hm.put("name",new Person<String>("张三"));
                                                        hm.put("sex",new Person<String>("男"));
                                                        hm.put("age",new Person<String>("25"));
                                                        hm.put("love",new Person<String>("爱学Java"));
                                           //3)对集合进行遍历,分别打印集合中的每个元素的键与值;
                                                        Set<String> s = hm.keySet();
                                                        Iterator it = s.iterator();
                                                        while(it.hasNext()){
                                                                     String Key = (String)it.next();
                                                                      System.out.println("键: " + Key + "->值: "  + hm.get(Key).value);
                                                        }
                                           /*  4)首先打印集合的大小，然后删除集合中的键为age的元素,并显示删除元素
                                                        的内容，并再次打印集合的大小*/
                                                        System.out.println(hm.size());
                                                        //删除元素前进行保存
                                                        Object key = "age";
                                                        Object value = hm.get(key).value;//hm.get(key)获得Person对象
                                                        //删除
                                                        hm.remove(key);
                                                        //显示该元素内容
                                                        System.out.println(" 移除元素的内容是：" + value);
                                                        //打印集合大小
                                                        System.out.println(hm.size());
                                       }

                          }

                          /**
                          运行结果：
                                       键: love->值: 爱学Java
                                       键: sex->值: 男
                                       键: name->值: 张三
                                       键: id->值: 1
                                       键: age->值: 25
                                       5
                                        移除元素的内容是：25
                                       4
                          */




