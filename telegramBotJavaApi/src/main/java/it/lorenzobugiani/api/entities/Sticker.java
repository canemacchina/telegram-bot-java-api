package it.lorenzobugiani.api.entities;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class Sticker {

  @SerializedName("file_id")
  private String fileId;

  @SerializedName("width")
  private int width;

  @SerializedName("height")
  private int height;

  @SerializedName("thumb")
  private PhotoSize thumb;

  @SerializedName("file_size")
  private int fileSize;

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

  public PhotoSize getThumb() {
    return thumb;
  }

  public void setThumb(PhotoSize thumb) {
    this.thumb = thumb;
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
