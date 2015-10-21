package it.lorenzobugiani.api.entities;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class PhotoSize {

  @SerializedName("file_id")
  private String fileId;

  @SerializedName("width")
  private int width;

  @SerializedName("height")
  private int height;

  @SerializedName("file_size")
  private int fileSize = -1;

  public String getFileId() {
    return fileId;
  }

  public void setFileId(String fileId) {
    this.fileId = fileId;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getFileSize() {
    return fileSize;
  }

  public void setFileSize(int fileSize) {
    this.fileSize = fileSize;
  }

  @Override
  public String toString() {
    return new Gson().toJson(this);
  }

}
