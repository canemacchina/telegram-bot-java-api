package it.lorenzobugiani.api.methods;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class TelegramResponse<T> {

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

  public void setOk(boolean ok) {
    this.ok = ok;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(int errorCode) {
    this.errorCode = errorCode;
  }

  public T getResult() {
    return result;
  }

  public void setResult(T result) {
    this.result = result;
  }

  @Override
  public String toString() {
    return new Gson().toJson(this);
  }

}
