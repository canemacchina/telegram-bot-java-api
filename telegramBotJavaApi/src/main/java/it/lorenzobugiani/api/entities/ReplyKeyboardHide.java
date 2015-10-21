package it.lorenzobugiani.api.entities;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class ReplyKeyboardHide implements ReplyMarkup {

  @SerializedName("hide_keyboard")
  private boolean hideKeyboard = true;
  @SerializedName("selective")
  private boolean selective = false;

  public boolean isHideKeyboard() {
    return hideKeyboard;
  }

  public void setHideKeyboard(boolean hideKeyboard) {
    this.hideKeyboard = hideKeyboard;
  }

  public boolean isSelective() {
    return selective;
  }

  public void setSelective(boolean selective) {
    this.selective = selective;
  }

  @Override
  public String toString() {
    return new Gson().toJson(this);
  }

  @Override
  public String serialize() {
    return new Gson().toJson(this);
  }
}
