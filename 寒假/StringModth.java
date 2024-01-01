package StringANDStringBuffer;







import java.util.Scanner;

public class String常用方法 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = null;
		//		String str2 = null;
		Scanner sc = new Scanner(System.in);
		str = sc.next();
		//		str2 = sc.next();
		/*忽略大小写判断是否相同
			try {

				System.out.println(str.equalsIgnoreCase(str2)?"相同":"不同");
			}catch(NullPointerException e)
			{
				System.out.println("空指针异常");
			}
		字母
		*/
		int UPPERCASE =0,LOWERCASE=0,NOTALETTER=0;

		for(int i=0;i<str.length();i++)
		{
			char ch = str.charAt(i);
			if(ch>='A'&&ch<='Z')UPPERCASE++;
			else if(ch>='a'&&ch<='z')LOWERCASE++;
			else NOTALETTER++;
		}

		System.out.println("大写："+UPPERCASE+"\n小写"+LOWERCASE+"\n非字母"+NOTALETTER);
		大写

	}

}

