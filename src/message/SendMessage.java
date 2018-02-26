package message;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SendMessage
{
	
	
	private static SendMessage one = null;
	
	private static Object m_lock= new Object();
	
	public static SendMessage i()
	{
		if(one == null)
		{
			synchronized(m_lock)
			{
				if(one==null)
				{
					one =new SendMessage(0);
				}
			}
		}
		return one;
	}
	public SendMessage()
	{
		
	}
	public SendMessage(int no)
	{
		try
		{
			this.init();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(".....结束初始化");
	}
	
	ServerSocket server = null;
	public void send(String str) throws IOException
	{
		System.out.println("....开始发送信息");
		Socket s = server.accept();
		OutputStream out =s.getOutputStream();
		System.out.println("...........开始");
		out.write(str.getBytes());
		out.close();
		s.close();
	}
	
	public void init() throws IOException{
		server = new ServerSocket(1024);
	}
}
