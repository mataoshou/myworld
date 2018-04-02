package publish;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class DocumentReplace
{
	public static void main(String[] args)
	{
		String[] paths= {
				"E:\\WebProjects\\ShineOn-RMPP\\ShineOn_CMS\\WebRoot\\WEB-INF\\lib",
				"E:\\WebProjects\\ShineOn-VMS\\WebRoot\\WEB-INF\\lib",
				"E:\\WebProjects\\ShineOn-Topic\\WebRoot\\WEB-INF\\lib",
				"E:\\WebProjects\\ShineOn-RMPP\\ShineOn-CC1.1\\WebRoot\\WEB-INF\\lib",
				"E:\\WebProjects\\ShineOn-RMPP\\ShineOn-CC\\WebRoot\\WEB-INF\\lib",
				"E:\\WebProjects\\ShineOn-News-1.1\\WebRoot\\WEB-INF\\lib",
				"E:\\WebProjects\\ShineOn-RMPP\\ShineOn-Clue\\WebRoot\\WEB-INF\\lib",
				"E:\\WebProjects\\ShineOn-Crawl\\WebRoot\\WEB-INF\\lib",
				"E:\\WebProjects\\U-Censor-V2.1\\ShineOn-Censor\\WebRoot\\WEB-INF\\lib",
				"E:\\WebProjects\\ShineOn-RMPP\\ShineOn-EQM\\WebRoot\\WEB-INF\\lib"
				};
		File source = new File("E:\\WorkSpace\\shineon-servicefilter.jar");
		for(String s : paths)
		{
			File f = new File(s,"shineon-servicefilter.jar");
			if(f.exists())
			{
				f.delete();
				System.out.println("删除:"+f.getPath());
			}
			try
			{
				FileUtils.copyFile(source, f);
				System.out.println("添加最新的文件："+f.getPath());
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
