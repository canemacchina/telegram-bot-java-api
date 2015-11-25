package it.lorenzobugiani.api.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class ReplyKeyboardMarkup implements ReplyMarkup {

  @SerializedName("keyboard")
  private List<List<String>> keyboard;

  @SerializedName("resize_keyboard")
  private boolean resizeKeyboard;

  @SerializedName("one_time_keyboard")
  private boolean oneTimeKeyboard;

  @SerializedName("selective")
  private boolean selective;

  private ReplyKeyboardMarkup(Builder builder) {
    keyboard = builder.keyboard;
    resizeKeyboard = builder.resizeKeyboard;
    oneTimeKeyboard = builder.oneTimeKeyboard;
    selective = builder.selective;
  }

  @Override
  public String serialize() {
    return new Gson().toJson(this);
  }

  @Override
  public String toString() {
    return new Gson().toJson(this);
  }

  public static class Builder {

    private List<List<String>> keyboard;
    private boolean resizeKeyboard;
    private boolean oneTimeKeyboard;
    private boolean selective;

    public Builder() {
      keyboard = new ArrayList<>();
    }

    public Builder row(String... buttons) {
      keyboard.add(Arrays.asList(buttons));
      return this;
    }

    public Builder add(int width, String... buttons) {
      List<String> row = new ArrayList<>(width);
      for (int i = 0; i < buttons.length; i++) {
        row.add(buttons[i]);

        if ((i + 1) % width == 0) {
          keyboard.add(row);
          row.clear();
        }
      }

      if (row.size() > 0)
        keyboard.add(row);

      return this;
    }

    public Builder setResizeKeyboard() {
      this.resizeKeyboard = true;
      return this;
    }

    public Builder setOneTimeKeyboard() {
      this.oneTimeKeyboard = true;
      return this;
    }

    public Builder setSelective() {
      this.selective = true;
      return this;
    }

    public ReplyKeyboardMarkup build() {
      return new ReplyKeyboardMarkup(this);
    }
  }

}
