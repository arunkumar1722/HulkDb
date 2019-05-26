package File;

public class FileManager {

    private FileRead fileRead;
    private FileWrite fileWrite;
    private FileOptions fileOptions;


    public FileManager(FileOptions fileOptions) {
        this.fileOptions = fileOptions;
      //  fileRead = new FileRead(fileOptions.getFullPath() );
        fileWrite = new FileWrite(fileOptions.getFullPath());

       /* if (fileOptions.isPreferredLocationSet()) {
            fileRead = new FileRead(fileOptions.getPreferredLocation());
            fileWrite = new FileWrite(fileOptions.getPreferredLocation());
        } else {
            fileRead = new FileRead(fileOptions.getDefaultLocation());
            fileWrite = new FileWrite(fileOptions.getDefaultLocation());

        }
*/
    }


    public FileRead getFileRead() {
        return fileRead;
    }

    public FileWrite getFileWrite() {
        return fileWrite;
    }

    public FileOptions getFileOptions() {
        return fileOptions;
    }
}
