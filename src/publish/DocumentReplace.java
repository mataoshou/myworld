package publish;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class DocumentReplace
{
	public static void main(String[] args)
	{
		String[] paths= {
				"E:\\WebProjects\\rmpp\\ShineOn_CMS\\",
				"E:\\WebProjects\\rmpp\\ShineOn-VMS\\",
				"E:\\WebProjects\\rmpp\\ShineOn-Topic\\",
				"E:\\WebProjects\\rmpp\\ShineOn-CC1.1\\",
				"E:\\WebProjects\\rmpp\\ShineOn-CC2.0\\",
				"E:\\WebProjects\\rmpp\\ShineOn-News\\",
				"E:\\WebProjects\\rmpp\\ShineOn-Clue\\",
				"E:\\WebProjects\\rmpp\\ShineOn-Crawl\\",
				"E:\\WebProjects\\rmpp\\ShineOn-Censor\\",
				"E:\\WebProjects\\rmpp\\ShineOn-EQM\\",
				"E:\\WebProjects\\rmpp\\ShineOn-NCS\\",
				"E:\\WebProjects\\rmpp\\ShineOn-IMS\\"
				};
		File source = new File("c:/HibernateSessionFactory.java");
		for(String s : paths)
		{
			File f = new File(s,"src\\shineon\\db\\HibernateSessionFactory.java");
			if(f.exists())
			{
				f.delete();
				System.out.println("删除:"+f.getPath());
			}
			try
			{
				FileUtils.copyFile(source, new File(f.getParent() ,source.getName()));
				System.out.println("添加最新的文件："+f.getPath());
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
