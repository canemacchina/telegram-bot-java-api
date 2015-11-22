package it.lorenzobugiani.api.methods.impl;

import it.lorenzobugiani.api.entities.Message;
import it.lorenzobugiani.api.entities.ReplyMarkup;
import it.lorenzobugiani.api.methods.PostMethod;

public class SendLocationMethod extends PostMethod<Message> {

  private SendLocationMethod(SendLocationMethod.Builder builder) {
    super();
    parameters.put("chat_id", String.valueOf(builder.chatId));
    parameters.put("latitude", String.valueOf(builder.latitude));
    parameters.put("longitude", String.valueOf(builder.longitude));
    if (builder.replyToMessageId > 0) {
      parameters.put("reply_to_message_id", String.valueOf(builder.replyToMessageId));
    }
    if (!"".equals(builder.replyMarkup)) {
      parameters.put("reply_markup", String.valueOf(builder.replyMarkup));
    }
  }

  @Override
  public Class<Message> getReturnType() {
    return Message.class;
  }

  @Override
  public String getMethodName() {
    return "sendLocation";
  }

  public static class Builder {

    private int chatId;
    private float latitude;
    private float longitude;
    private int replyToMessageId;
    private String replyMarkup;

    public Builder(int chatId, float latitude, float longitude) {
      this.chatId = chatId;
      this.latitude = latitude;
      this.longitude = longitude;
      this.replyMarkup = "";
    }

    public Builder setReplyToMessageId(int replyToMessageId) {
      this.replyToMessageId = replyToMessageId;
      return this;
    }

    public Builder setReplyMarkup(ReplyMarkup replyMarkup) {
      this.replyMarkup = replyMarkup == null ? "" : replyMarkup.serialize();
      return this;
    }

    public SendLocationMethod build() {
      return new SendLocationMethod(this);
    }
  }

}
