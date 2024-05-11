package interfaces;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public interface FileManager<X> {
	void openFileDirectory(String filepath) throws FileNotFoundException;
	void closeFileDirectory();
	List<X> getDataList();
	List<X> getUsedData();
	File getOpenedDirectory();
	List<File> getAllFiles();
	List<File> getFilesUsed();
	void writeNewFile(X data);
	void readFromFile();
	void updateFile(X data);
}
