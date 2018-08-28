package sys.bean;

import java.io.Serializable;

public class FileBean implements Serializable  {
	private String path;
	private String fileName;
	public FileBean(){};
	public FileBean(String path,String name)
	{
		this.path = path;
		this.fileName = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	@Override
	public String toString() {
		return String.format("path:%s , fileName:%s", path,fileName);
	}
}
