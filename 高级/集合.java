----------------------------------------------------------------------------------
1.框架图
Collection 接口
	List
		ArrayList
		LinkedList
		----------------------------------------------------------------------------------
		1.Collection接口中有一个方法iterator() 可以返回一个Iterator接口的对象It
			使用该对象的it.hasNext()来判断当前游标的后面还是否存在元素，如果存在返回直，否则返回假
			使用该对象的it.next()方法返回当前"游标"扫过的元素,如果不存在,抛出NoSuchElementException异常

		----------------------------------------------------------------------------------
		2."Collections类"中有很多静态方法,可以提供给List、ArrayList、LinkedList集合使用
			例如排序,倒置,复制,填充,二分查找【使用前先排序】
		----------------------------------------------------------------------------------




	Set
		HashSet -- 重写hashCode 、equals方法【性能优于TreeSet,排序除外】

		TreeSet -- 向此集合中添加的对象的"类"需要实现Comparable接口

	Map
		HashMap
		TreeMap
		----------------------------------------------------------------------------------
		    Object put(Object key, Object value)
		    Object get(Object key)//注意Map接口中并没有Object get(Object value)
		    boolean isEmpty()
		    void clear()
		    int size()
		    boolean containsKey(Object key)
		    boolean containsValue(Object value)

		keySet()
		返回此映射中所包含的键的 Set 视图。该 set 受映射的支持，所以对映射的更改将反映在该 set 中，
		反之亦然。如果在对 set 进行迭代的同时修改了映射（通过迭代器自己的 remove 操作除外），则迭
		代结果是不确定的。该 set 支持元素的移除，通过 Iterator.remove、Set.remove、removeAll、
		retainAll 和 clear 操作可从该映射中移除相应的映射关系。它不支持 add 或 addAll 操作。
		----------------------------------------------------------------------------------


		两个程序【一部分】TestHashMap_1.java&TestHashMap_2.java
		----------------------------------------------------------------------------------
		HashMap hm = new HashMap();
		hm.put(1001, new Student(1001, "zhangsan", 20));  //自动封装
		hm.put(1003, new Student(1003, "lisi", 30)); //自动封装
		hm.put(new Integer(1004), new Student(1004, "wangwu", 10));
		hm.put(1002, new Student(1002, "baichi", 20)); //自动封装

		//遍历所有的元素
		System.out.println("hm容器中所有的元素是:");
		Set s = hm.keySet();  //获取到当前容器键的集合，实际就是Integer对象的集合
		Iterator it = s.iterator();
		while (it.hasNext()){
			//int Key = (Integer)it.next();   // (Integer) 不能省， 利用了自动拆分技术
			Integer Key = (Integer)it.next();
			System.out.println(hm.get(Key));
		}

		System.out.println("直接查找某一元素");
		System.out.println( hm.get(1003) );
		System.out.println( hm.get(1005) );	  //如果找不到 则直接返回null，而不是抛出异常
		----------------------------------------------------------------------------------
		Map m1 = new HashMap();
		m1.put("one", 1);
		m1.put("two", 2);
		m1.put("three", 3);
		System.out.println("1-> " + m1);
		System.out.println("2-> " + m1.size());
		m1.put(66.6, 'm');  //Map中键和值的类型是任意的，这也是Map强大的重要表现
		m1.put(123L, 34);
		System.out.println("3-> " + m1.size());
		System.out.println("4-> " + m1);

		System.out.println(m1.containsKey("three")); //true  ontainsKey 不要写成了containKey
		System.out.println(m1.containsValue(34));  //true
		System.out.println(m1.containsValue(123L));  //false
		----------------------------------------------------------------------------------


