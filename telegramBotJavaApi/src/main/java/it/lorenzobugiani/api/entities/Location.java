package it.lorenzobugiani.api.entities;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class Location {

  @SerializedName("longitude")
  private float longitude;

  @SerializedName("latitude")
  private float latitude;

  public float getLongitude() {
    return longitude;
  }

  public void setLongitude(float longitude) {
    this.longitude = longitude;
  }

  public float getLatitude() {
    return latitude;
  }

  public void setLatitude(float latitude) {
    this.latitude = latitude;
  }

  @Override
  public String toString() {
    return new Gson().toJson(this);
  }
}
