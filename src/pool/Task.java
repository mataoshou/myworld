package pool;

import java.io.IOException;

import message.SendMessage;

public class Task implements Runnable
{

	private long userId = 0;
	
	public Task(long userId)
	{
		this.userId = userId;
	}
	
	public long getUserId()
	{
		return userId;
	}
	@Override
	public void run()
	{
		try
		{
			SendMessage.i().send(Thread.currentThread().getName());
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
