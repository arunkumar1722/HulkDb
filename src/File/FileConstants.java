package File;

public class FileConstants {
    private String defaultLocation;
    private String fileName;
    private String preferredLocation;

    public FileConstants() {
        defaultLocation = "/home/user/HulkDb/";
        fileName = "hulk.txt";
        preferredLocation = null;
    }


    public String getDefaultLocation() {
        return defaultLocation;
    }

    public void setDefaultLocation(String defaultLocation) {
        this.defaultLocation = defaultLocation;
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

    public boolean isPreferredLocationSet(){
        return preferredLocation!=null;
    }

}



