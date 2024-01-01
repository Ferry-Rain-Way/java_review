/**
泛型容器类：

*/
package com.pro_1;

import java.util.ArrayList;


public class NoteBook {
private ArrayList<String> notes = new ArrayList<String>();

	public static void main(String[] args) {
		String[] str = new String [2];
		str[0] = "First";
		str[1] = "Seconed";
		NoteBook nb = new NoteBook();
		nb.add("First");
		nb.add("Seconed");
		System.out.println(nb.getSize());


	}

	public void add(String s)
	{
		notes.add(s);
		/*
		notes.add(10);
		false 在类型为ArrayList的方法add(int, String)不适用于参数(int)
		*/
	}

	public int getSize()
	{
		return notes.size();
	}

	public String  getNote(int index)
	{

		return "";

	}
	public boolean remove(int index)
	{
		return true;
	}


	public String[] List()
	{


		return new String[10];
	}



}


/*
DeBug调试：
->选择断点
->运行程序		【debug】
-> 查看变量等 【右侧】
->下一步			【左上角】
->运行				【直至结束】
*/





