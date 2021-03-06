package it.lorenzobugiani.api.methods.impl;

import java.io.File;

import it.lorenzobugiani.api.entities.Message;
import it.lorenzobugiani.api.entities.ReplyMarkup;
import it.lorenzobugiani.api.files.PhotoFile;
import it.lorenzobugiani.api.methods.MultipartMethod;

public class SendPhotoMethod extends MultipartMethod<Message> {

  private PhotoFile photo;

  private SendPhotoMethod(SendPhotoMethod.Builder builder) {
    super();
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
    if (builder.photo == null) {
      parameters.put("photo", String.valueOf(builder.photoId));
    } else {
      this.photo = builder.photo;
    }
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
    return photo == null ? null : photo.getFile();
  }

  @Override
  public String getAttachmentName() {
    return "photo";
  }

  public static class Builder {

    private int chatId;
    private PhotoFile photo;
    private String photoId;
    private String caption;
    private int replyToMessageId;
    private String replyMarkup;

    public Builder(int chatId, PhotoFile photo) {
      this(chatId);
      this.photo = photo;
    }

    public Builder(int chatId, String photoId) {
      this(chatId);
      this.photoId = photoId;
    }

    private Builder(int chatId) {
      this.chatId = chatId;
      this.caption = "";
      this.replyToMessageId = -1;
      this.replyMarkup = "";
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
