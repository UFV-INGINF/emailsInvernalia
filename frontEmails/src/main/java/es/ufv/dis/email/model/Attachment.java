package es.ufv.dis.email.model;

import com.google.gson.annotations.SerializedName;

public class Attachment {
    @SerializedName("file_name")
    private String fileNameAttachment;
    private String path;

    public Attachment() {
    }

    public Attachment(String fileNameAttachment, String path) {
        this.fileNameAttachment = fileNameAttachment;
        this.path = path;
    }

    public String getFileNameAttachment() {
        return fileNameAttachment;
    }

    public void setFileNameAttachment(String fileNameAttachment) {
        this.fileNameAttachment = fileNameAttachment;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "fileNameAttachment='" + fileNameAttachment + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
