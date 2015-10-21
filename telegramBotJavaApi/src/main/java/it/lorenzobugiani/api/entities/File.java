package it.lorenzobugiani.api.entities;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class File {

  @SerializedName("file_id")
  private String fileId;

  @SerializedName("file_size")
  private int fileSize;

  @SerializedName("file_path")
  private String filePath;

  public String getFileId() {
    return fileId;
  }

  public void setFileId(String fileId) {
    this.fileId = fileId;
  }

  public int getFileSize() {
    return fileSize;
  }

  public void setFileSize(int fileSize) {
    this.fileSize = fileSize;
  }

  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  @Override
  public String toString() {
    return new Gson().toJson(this);
  }

}
