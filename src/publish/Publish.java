package publish;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.commons.io.FileUtils;

public class Publish {
	public void publishPackage(File root, String fileName)
			throws InterruptedException {
		try {

			String cd = "cd /d " + root.getPath();
			String path = fileName;
			System.out.println(cd + " && " + path);

			ProcessBuilder pBuilder = new ProcessBuilder(cd + " && " + path);
			pBuilder.command("cmd.exe", "/C", "cd", "/d", root.getPath(), "&&",
					path);
			System.out.println(pBuilder.command());
			Process process = pBuilder.start();
			// InputStream is = process.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(
					process.getInputStream(), "gb2312"));
			String readLine = br.readLine();
			while (readLine != null) {
				System.out.println(readLine); // 既有正常输出和error message。
				readLine = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deleteZIP(File root) {
		File[] fs = root.listFiles();
		for (File f : fs) {
			if (f.getName().toLowerCase().endsWith("zip")) {
				f.delete();
				System.out.println(".....删除 ...." + f.getPath());
			}
		}
	}

	public void copyFile(File root) throws IOException {
		File[] fs = root.listFiles();
		for (File f : fs) {
			if (f.getName().toLowerCase().endsWith("zip")) {
				File dest = new File("c:/pub", f.getName());
				dest.getParentFile().mkdirs();
				FileUtils.copyFile(f, dest);
			}
		}
	}

	public boolean delete(File file) {
		if (!file.exists()) {// 验证路径是否存在
			System.out.println(file.getPath() + "   路径不存在！");
			return false;
		}
		if (!file.isDirectory()) {// 验证是否是文件夹
			file.delete();// 文件直接删除
			System.out.println("删除文件" + file.getPath());
			return true;
		}
		// 遍历文件夹下的文件或文件夹，进行删除
		File[] files = file.listFiles();
		for (File f : files) {
			delete(f);// 递归删除
		}
		file.delete();// 删除文件夹
		System.out.println("删除文件夹" + file.getPath());
		return true;

	}

	public static void main(String[] args) throws InterruptedException,
			IOException {
		String[] paths = { 
				"E:\\WebProjects\\rmpp\\ShineOn_CMS\\",
				"E:\\WebProjects\\rmpp\\ShineOn-VMS1.1\\",
				"E:\\WebProjects\\rmpp\\ShineOn-Topic\\",
				"E:\\WebProjects\\rmpp\\ShineOn-Uauth\\",
				"E:\\WebProjects\\rmpp\\ShineOn-News\\",
				"E:\\WebProjects\\rmpp\\ShineOn-Media\\",
				"E:\\WebProjects\\rmpp\\ShineOn-Crawl\\",
				"E:\\WebProjects\\rmpp\\ShineOn-Censor\\",
				"E:\\WebProjects\\rmpp\\ShineOn-Clue\\",
				"E:\\WebProjects\\rmpp\\ShineOn-CC2.0\\",
				"E:\\WebProjects\\rmpp\\ShineOn-IMS\\",
				};
		String fileName = "autoRelease.cmd";
		Publish p = new Publish();
		p.delete(new File("c:/pub"));
		for (String s : paths) {
			File f = new File(s);
			File realse = new File(f,fileName);
			if (!realse.exists()) {
				FileUtils.copyFile(new File(f, "MakeRelease.cmd"),
						realse);
				String str = getContent(realse, "UTF-8");
				str = str.replace("pause", "");
				putString(realse, str, "UTF-8");
				System.out.println("添加新的发布文件"+f.getPath());
			}
			if (f.exists()) {
				p.deleteZIP(f);
				p.publishPackage(f, fileName);
				p.copyFile(f);
			}
		}
	}

	// 获取文章内容
	public static String getContent(File f, String charset) throws IOException {
		if (f.exists()) {
			FileInputStream input = new FileInputStream(f);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			int n = 0;
			byte[] b = new byte[1024 * 10];
			while (true) {
				n = input.read(b);
				if (n < 0)
					break;
				out.write(b, 0, n);
			}
			return out.toString(charset);
		}
		return null;
	}

	public static void putString(File f, String str, String charset) {
		if (f.exists()) {
			FileOutputStream out = null;
			try {
				out = new FileOutputStream(f);
				out.write(str.getBytes(charset));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
