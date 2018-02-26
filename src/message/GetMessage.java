package message;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class GetMessage
{
	public void get() throws IOException
	{
		Socket s = new Socket("127.0.0.1", 1024);
		InputStream input = s.getInputStream();
		ByteArrayOutputStream is = new ByteArrayOutputStream();
		try
		{
			byte[] b = new byte[1024 * 4];
			int n = 0;
			while (true)
			{
				n = input.read(b);
				if (n == -1)
					break;
				
				System.out.println(n);
				is.write(b, 0, n);
			}
		} finally
		{
			input.close();
			System.out.println(is.toString("UTF-8"));
			is.close();
			s.close();
		}
	}

	public static void main(String[] args) throws IOException
	{
		GetMessage get = new GetMessage();
		get.get();
	}
}
