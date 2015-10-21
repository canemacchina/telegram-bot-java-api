package it.lorenzobugiani.api.methods.impl;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import it.lorenzobugiani.api.entities.Message;
import it.lorenzobugiani.api.entities.ReplyMarkup;
import it.lorenzobugiani.api.methods.MultipartMethod;

public class SendPhotoMethod extends MultipartMethod<Message> {

  private Map<String, String> parameters;
  private File photo;

  private SendPhotoMethod(SendPhotoMethod.Builder builder) {
    this.parameters = new HashMap<>();
    parameters.put("chat_id", String.valueOf(builder.chatId));
    if (!"".equals(builder.caption)) {
      parameters.put("caption", String.valueOf(builder.caption));
    }
    if (builder.replyToMessageId > 0) {
      parameters.put("reply_to_message_id", String.valueOf(builder.replyToMessageId));
    }
    if (!"".equals(builder.replyMarkup)) {
      parameters.put("reply_markup", String.valueOf(builder.replyMarkup));
    }
    this.photo = builder.photo;
  }

  @Override
  public Map<String, String> getParameters() {
    return parameters;
  }

  @Override
  public Class<Message> getReturnType() {
    return Message.class;
  }

  @Override
  public String getMethodName() {
    return "sendPhoto";
  }

  @Override
  public File getAttachment() {
    return photo;
  }

  @Override
  public String getAttachmentName() {
    return "photo";
  }

  public static class Builder {

    private int chatId;
    private File photo;
    private String caption = "";
    private int replyToMessageId = -1;
    private String replyMarkup = "";

    public Builder(int chatId, File photo) {
      this.chatId = chatId;
      this.photo = photo;
    }

    public Builder setCaption(String caption) {
      this.caption = caption == null ? "" : caption;
      return this;
    }

    public Builder setReplyToMessageId(int replyToMessageId) {
      this.replyToMessageId = replyToMessageId;
      return this;
    }

    public Builder setReplyMarkup(ReplyMarkup replyMarkup) {
      this.replyMarkup = replyMarkup == null ? "" : replyMarkup.serialize();
      return this;
    }

    public SendPhotoMethod build() {
      return new SendPhotoMethod(this);
    }

  }

}
