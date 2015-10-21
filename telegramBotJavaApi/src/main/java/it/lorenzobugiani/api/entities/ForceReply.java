package it.lorenzobugiani.api.entities;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class ForceReply implements ReplyMarkup {


  @SerializedName("force_reply")
  private boolean forceReply = true;
  @SerializedName("selective")
  private boolean selective = false;

  public boolean isForceReply() {
    return forceReply;
  }

  public void setForceReply(boolean forceReply) {
    this.forceReply = forceReply;
  }

  public boolean isSelective() {
    return selective;
  }

  public void setSelective(boolean selective) {
    this.selective = selective;
  }

  @Override
  public String serialize() {
    return new Gson().toJson(this);
  }

  @Override
  public String toString() {
    return new Gson().toJson(this);
  }
}
