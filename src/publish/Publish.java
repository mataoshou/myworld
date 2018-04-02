package publish;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Publish
{
	public void pub(File f)
	{
		try
		{
			
			String cd = "cd /d "+f.getParent();
			String path = f.getName();
			System.out.println(cd +" && "+path);

			ProcessBuilder pBuilder = new ProcessBuilder(
					cd +" && "+path);
			pBuilder.command("cmd.exe","/C","cd","/d",f.getParent(),"&&",path);
			System.out.println(pBuilder.command());
			Process process = pBuilder.start();
//			// 取得返回码
//			int returnCode = process.waitFor();
			
		} catch (IOException e)
		{
			
			e.printStackTrace();
		}
//		} catch (InterruptedException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	public static void main(String[] args)
	{
		String[] paths= {
				"E:\\WebProjects\\ShineOn-RMPP\\ShineOn_CMS\\MakeRelease.cmd"
				};
		Publish p =new Publish();
		for(String s : paths)
		{
			File f = new File(s);
			if(f.exists())
			{
				p.pub(f);
			}
		}
	}
}
