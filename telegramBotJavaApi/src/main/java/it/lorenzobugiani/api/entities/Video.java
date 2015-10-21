package it.lorenzobugiani.api.entities;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class Video {

  @SerializedName("file_id")
  private String fileId;

  @SerializedName("width")
  private int width;

  @SerializedName("height")
  private int height;

  @SerializedName("duration")
  private int duration;

  @SerializedName("thumb")
  private PhotoSize thumb;

  @SerializedName("mime_type")
  private String mimeType;

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

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public PhotoSize getThumb() {
    return thumb;
  }

  public void setThumb(PhotoSize thumb) {
    this.thumb = thumb;
  }

  public String getMimeType() {
    return mimeType;
  }

  public void setMimeType(String mimeType) {
    this.mimeType = mimeType;
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
