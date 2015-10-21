package it.lorenzobugiani.api.entities;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class Voice {

  @SerializedName("file_id")
  private String fileId;

  @SerializedName("duration")
  private int duration;

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

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
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
