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
			Thread.sleep( userId * 100*5);
//			SendMessage.i().send(Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
