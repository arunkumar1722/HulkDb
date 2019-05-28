package File;

import java.io.File;
/**
 * FileManager Reponsible for managing File Operations
 * Employs FileRead, FileWrite and FileOptions Classes.
 * */
public class FileManager {

    private FileRead fileRead;
    private FileWrite fileWrite;
    private FileOptions fileOptions;


    public FileManager(FileOptions fileOptions) {
        this.fileOptions = fileOptions;
        if (checkifFileexists(fileOptions.getFullPath())) {
            fileOptions.setAlreadyExists(true);
            System.out.println("Already existing file has been opened.");
            fileRead = new FileRead(fileOptions.getFullPath());
            //fileWrite = new FileWrite(fileOptions.getFullPath());
        } else {
            System.out.println("A new file has been created ");
            fileOptions.setAlreadyExists(false);
            fileWrite = new FileWrite(fileOptions.getFullPath());
            //   fileRead = new FileRead(fileOptions.getFullPath());
        }
    }


    public FileRead getFileRead() {
        return fileRead;
    }

    public FileWrite getFileWrite() {
        if(fileWrite==null)
            return  fileWrite = new FileWrite(fileOptions.getFullPath());
        return fileWrite;
    }

    public FileOptions getFileOptions() {
        return fileOptions;
    }

    private boolean checkifFileexists(String filePath) {
        File f = new File(filePath);
        return f.exists() && !f.isDirectory();
    }
}
