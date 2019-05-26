package File;

public class FileOptions {
    private String defaultLocation;
    private String fileName;
    private String preferredLocation;

    public FileOptions() {
        defaultLocation = "/home/user/HulkDb/";
        fileName = "hulk.txt";
        preferredLocation = null;
    }

    public FileOptions(String fileName) {
        defaultLocation = "/home/user/HulkDb/";
        this.fileName = fileName;
        preferredLocation = null;
    }

    public FileOptions(String fileName, String filePath) {
        defaultLocation = "/home/user/HulkDb/";
        this.fileName = fileName;
        this.preferredLocation = filePath;
    }


    public String getFullPath(){
        if(isPreferredLocationSet()){
            return getPreferredLocation() + getFileName();
        }
        else {
            return getDefaultLocation() + getFileName();
        }
    }

    public String getDefaultLocation() {
        return defaultLocation;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPreferredLocation() {
        return preferredLocation;
    }

    public void setPreferredLocation(String preferredLocation) {
        this.preferredLocation = preferredLocation;
    }

    public boolean isPreferredLocationSet() {
        return preferredLocation != null;
    }

}



