package pool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class TaskPool
{
	ThreadPoolExecutor executor = null;

	public void initPool()
	{
		executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>());
	}

	public void addTask(long id)
	{
		Task t = new Task(id);
		executor.execute(t);
	}

	public static void main(String[] args)
	{
		TaskPool pool = new TaskPool();
		pool.initPool();
		for (int i = 0; i < 10; i++)
		{
			pool.addTask(i);
		}
		while (true)
		{
			System.out.println("线程池中线程数目：" + pool.executor.getActiveCount()
					+ "，队列中等待执行的任务数目：" + pool.executor.getQueue().size()
					+ "，已执行完别的任务数目："
					+ pool.executor.getCompletedTaskCount());
			if (pool.executor.getCompletedTaskCount() >= 10)
			{
				break;
			}
			try
			{
				Thread.sleep(100*5);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		pool.executor.shutdown();
	}
}
