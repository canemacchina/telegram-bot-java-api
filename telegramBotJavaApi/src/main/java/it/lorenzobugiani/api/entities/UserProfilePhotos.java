package it.lorenzobugiani.api.entities;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class UserProfilePhotos {

  @SerializedName("total_count")
  private int totalCount;

  @SerializedName("photos")
  private List<List<PhotoSize>> photos;

  public int getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(int totalCount) {
    this.totalCount = totalCount;
  }

  public List<List<PhotoSize>> getPhotos() {
    return photos;
  }

  public void setPhotos(List<List<PhotoSize>> photos) {
    this.photos = photos;
  }

  @Override
  public String toString() {
    return new Gson().toJson(this);
  }
}
