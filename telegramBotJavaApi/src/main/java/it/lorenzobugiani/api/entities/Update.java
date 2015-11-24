package it.lorenzobugiani.api.entities;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class Update {

  @SerializedName("update_id")
  private int updateId;

  @SerializedName("message")
  private Message message;

  public int getUpdateId() {
    return updateId;
  }

  public void setUpdateId(int updateId) {
    this.updateId = updateId;
  }

  public Message getMessage() {
    return message;
  }

  public void setMessage(Message message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return new Gson().toJson(this);
  }
}
