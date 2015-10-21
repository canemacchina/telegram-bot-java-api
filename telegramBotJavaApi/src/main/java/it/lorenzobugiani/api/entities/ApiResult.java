package it.lorenzobugiani.api.entities;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class ApiResult<T> {

  @SerializedName("ok")
  private boolean ok;

  @SerializedName("description")
  private String description;

  @SerializedName("error_code")
  private int errorCode;

  @SerializedName("result")
  private T result;

  public boolean isOk() {
    return ok;
  }

  public String getDescription() {
    return description;
  }

  public int getErrorCode() {
    return errorCode;
  }

  public T getResult() {
    return result;
  }

  @Override
  public String toString() {
    return new Gson().toJson(this);
  }
}
