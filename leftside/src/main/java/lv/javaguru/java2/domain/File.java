package lv.javaguru.java2.domain;

/**
 * Created by SM on 10/18/2014.
 */
public class File {
    private long fileId;
    private String path;
    private String fileName;
    private Byte extensionId;

    public long getFileId() {
        return fileId;
    }

    public void setFileId(long fileId) {
        this.fileId = fileId;
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

    public Byte getExtensionId() {
        return extensionId;
    }

    public void setExtensionId(Byte extensionId) {
        this.extensionId = extensionId;
    }
}
