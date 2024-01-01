1.
	/**
	 * 时间：2022年3月26日18:16:00
	 * 编程目标：
	 *  运行以下程序，并写出运行结果
	 */

	/*
		在JDK 1.8中的运行结果是：
	----------------------
	R
	a
	d
	e
	r
	/
	w
	r
	i
	t
	e
	r
	例
	子
	----------------------
		总结：
	构造方法：
	    FileWriter(String fileName)
	    根据给定的文件名构造一个 FileWriter 对象。
	*/

2.
	运行结果

	Rader/writer例子



3.
package IO.实验;

import java.io.*;

public class Buffered_putStreamCopy {
    public static void main(String[] args) {

        String inPath = "D:\\English\\IntelliJ IDEA\\Test\\java高级\\src\\IO\\实验\\Buffered_putStreamCopy.java";
        String outPath = "D:\\Buffered_putStreamCopy.txt";
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1、缓冲输入流创建
             bis = new BufferedInputStream(new FileInputStream(inPath));
             //2、缓冲输出流创建
             bos = new BufferedOutputStream(new FileOutputStream(outPath));
             //3、缓冲数组
            /**
             * bis、bos输入流有个默认的缓冲区，大小为32个字节
             *创建新的缓冲数组
             * 从bis关联文件中读取数据，并将读取的数据写入bis自己的默认缓冲区中，然后再将缓冲区的内容写入buf数组中
             * 每次最多向buf数组中写入1024个字节，返回实际写入buf数组的字节个数，如果读到了文件的末尾，
             * 无法再向buf数组中写入数据，则返回-1
             */
            byte [] buf = new byte [1024];

            //4、文件读取与复制
            int len = bis.read(buf,0,1024);
            while(-1!=len){
            //不是写入buf数组，而是将buf数组中下标从0开始的到len-1为止的所有数据写入bos所关联到的文件中
            bos.write(buf,0,len);
            len = bis.read(buf);//向buf数组写入数据,等价于 bis.read(buf,0,1024);--bis.read(buf, 0, buf.length);
            }
            //5、异常捕获
        } catch(FileNotFoundException e){
            System.out.println("未查询到源文件！");
        }
        catch (IOException e) {
            System.out.println("文件复制异常！");
        }finally{
            //6、资源刷新
            try {
                bos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //7、资源关闭
            try {
                if(bos!=null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(bis!=null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        System.out.println("Buffered_putStreamCopy  End!");

    }
}

4.
package IO.实验;

import java.io.*;

/**
 *时间：2022年3月26日19:08:16
 * 编程目标：
 *      输入一个路径名,判断它是一个目录还是一个文件
 *      如果是文件名,则显示文件找出文件内容
 */
public class CatalogueOrFile {
    public static void main(String[] args) {
        String str = "D:\\English\\IntelliJ IDEA\\Test\\java高级\\src\\IO\\实验\\CatalogueOrFile.java";

        File file = new File(str);

        //测试此抽象路径名表示的文件是否是一个目录。
        if (file.isDirectory())
            System.out.println("目录");

        if (file.isFile()) {
            System.out.println("文件!" +
                    "---------------文件内容--------------");


            try {
                FileInputStream fis = new FileInputStream(str);
                InputStreamReader isr = new InputStreamReader(fis, "utf8");
                //一般为  gbk 、utf8(或写成utf-8)、UTF-16BE、UTF-16LE、UTF-16等
                BufferedReader br = new BufferedReader(isr);

                String s = br.readLine();

                while (null != s) {
                    System.out.println(s);
                    s = br.readLine();
                }


            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("-----------------------------------");
            System.out.println("CatalogueOrFile End!");


        }
    }}











import java.io.*;
import java.net.*;

public class TClient
{
	public static void main(String[] args) throws Exception
	{
		Socket s = new Socket("127.0.0.1", 8888);
		DataInputStream dis = new DataInputStream(s.getInputStream());
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());

		new ClientRead(dis).start();
		new ClientWriter(dos).start();
	}
}

class ClientRead extends Thread
{
	private DataInputStream dis = null;

	public ClientRead(DataInputStream dis)
	{
		this.dis = dis;
	}

	public void run()
	{
		while (true)
		{
			try
			{
				String str = dis.readUTF();
				System.out.println("对方说的是: " + str);
				if (str.equalsIgnoreCase("再见"))
					break;
			}
			catch (Exception e)
			{
			}
		}
	}
}

class ClientWriter extends  Thread
{
	private DataOutputStream dos = null;

	public ClientWriter(DataOutputStream dos)
	{
		this.dos = dos;
	}

	public void run()
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true)
		{
			try
			{
				String str = br.readLine();
				dos.writeUTF(str);
				if (str.equalsIgnoreCase("再见"))
					break;
			}
			catch (Exception e)
			{
			}
		}
	}

}








import java.io.*;
import java.net.*;

public class TServer
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket(8888);
		Socket s = ss.accept();
		DataInputStream dis = new DataInputStream(s.getInputStream());
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());

		new ServerRead(dis).start();
		new ServerWriter(dos).start();
	}
}

class ServerRead extends Thread
{
	private DataInputStream dis = null;

	public ServerRead(DataInputStream dis)
	{
		this.dis = dis;
	}

	public void run()
	{
		while (true)
		{
			try
			{
				String str = dis.readUTF();
				System.out.println("对方说的是: " + str);
				if (str.equalsIgnoreCase("再见"))
					break;
			}
			catch (Exception e)
			{
			}
		}
	}
}

class ServerWriter extends  Thread
{
	private DataOutputStream dos = null;

	public ServerWriter(DataOutputStream dos)
	{
		this.dos = dos;
	}

	public void run()
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true)
		{
			try
			{
				String str = br.readLine();
				dos.writeUTF(str);
				if (str.equalsIgnoreCase("再见"))
					break;
			}
			catch (Exception e)
			{
			}
		}
	}
}
