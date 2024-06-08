package model.menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import interfaces.FileManager;

public abstract class FileManagerImpl<X> implements FileManager<X> {
	private File directory;
	private List<X> dataList;
	private List<X> usedData;
	private List<File> filesUsed;
	
	public FileManagerImpl() {
		this.usedData = new LinkedList<>();
		this.dataList = new LinkedList<>();
		this.filesUsed = new LinkedList<>();
	}
	
	public void openFileDirectory(String filepath) throws FileNotFoundException{
		File file = new File(filepath);
		if(!file.exists())
			throw new FileNotFoundException("Directory non trovata!");
		this.directory = new File(filepath);
	}
	
	public void closeFileDirectory() {
		this.directory = null;
	}
	
	public List<X> getDataList() {
		return this.dataList;
	}
	
	public List<X> getUsedData() {
		return this.usedData;
	}
	
	public File getOpenedDirectory() {
		return this.directory;
	}
	
	public List<File> getAllFiles() throws NullPointerException {
		List<File> fileList = Arrays.asList(this.directory.listFiles());
		return fileList;
	}
	
	public List<File> getFilesUsed() {
		return this.filesUsed;
	}
	
	public abstract void writeNewFile(X data);
	
	public abstract void readFromFile();
	
	public abstract void updateFile(X data);
}
