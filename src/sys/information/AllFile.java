package sys.information;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

import sys.bean.FileBean;

public class AllFile {
	int count_file = 0;
	public void getAllDist() {
		File[] fs = File.listRoots();
		for (File f : fs) {
			// System.out.println(f.getPath());
			getFiles(f);
		}
	}

	public void getFiles(File f) {
		try {
			System.out.println(f.getPath());
			FileBean fb= new FileBean(f.getPath(),f.getName());
			buildSerial(fb);
			if (f.isDirectory()) {
				File[] fs = f.listFiles();
				for (File rf : fs) {
					getFiles(rf);
				}
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void buildSerial(FileBean fb) throws FileNotFoundException, IOException
	{
		count_file++;
		if(fb.getFileName()==null||fb.getFileName().length()==0){
			System.out.println("........................"+fb.getPath());
			return;
		}
		Random r = new Random();
		File root =new File("E:\\WorkSpace\\myworld\\document\\");
		String fileName = "file_" + count_file +"_"+ r.nextInt();
		if(fileName ==null||fileName.length()==0)
		{
			fileName = "file_" + count_file +"_"+ r.nextInt();
		}
		root.mkdirs();
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(root,fileName)));  
        oos.writeObject(fb);
	}
	
	public void getBean(File f) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));  
        FileBean person = (FileBean) ois.readObject();  
        System.out.println(person.toString());  
	}

	public static void main(String[] args) {
		AllFile a = new AllFile();
		a.getAllDist();
//		File[] fs = new File("E:\\WorkSpace\\myworld\\document\\").listFiles();
//		int count = 0;
//		for(File f : fs)
//		{
//			count++;
//			try {
//				a.getBean(f);
//			} catch (ClassNotFoundException
//					| IOException e) {
//				e.printStackTrace();
//				System.out.println("......." + f.getName());
//				break;
//			}
//			System.out.println("......" + count);
//		}
	}
}
