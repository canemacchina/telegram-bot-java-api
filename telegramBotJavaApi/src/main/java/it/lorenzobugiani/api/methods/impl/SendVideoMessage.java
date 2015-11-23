package it.lorenzobugiani.api.methods.impl;

import java.io.File;

import it.lorenzobugiani.api.Files.VideoFile;
import it.lorenzobugiani.api.entities.Message;
import it.lorenzobugiani.api.entities.ReplyMarkup;
import it.lorenzobugiani.api.methods.MultipartMethod;

public class SendVideoMessage extends MultipartMethod<Message> {
  private VideoFile video;

  private SendVideoMessage(SendVideoMessage.Builder builder) {
    super();
    parameters.put("chat_id", String.valueOf(builder.chatId));
    if (builder.duration > 0) {
      parameters.put("duration", String.valueOf(builder.duration));
    }
    if (!"".equals(builder.caption)) {
      parameters.put("caption", String.valueOf(builder.caption));
    }
    if (builder.replyToMessageId > 0) {
      parameters.put("reply_to_message_id", String.valueOf(builder.replyToMessageId));
    }
    if (!"".equals(builder.replyMarkup)) {
      parameters.put("reply_markup", String.valueOf(builder.replyMarkup));
    }
    this.video = builder.video;
  }

  @Override
  public Class<Message> getReturnType() {
    return Message.class;
  }

  @Override
  public String getMethodName() {
    return "sendVideo";
  }

  @Override
  public File getAttachment() {
    return this.video.getFile();
  }

  @Override
  public String getAttachmentName() {
    return "video";
  }

  public static class Builder {

    private int chatId;
    private VideoFile video;
    private int duration;
    private String caption;
    private int replyToMessageId;
    private String replyMarkup;

    public Builder(int chatId, VideoFile video) {
      this.chatId = chatId;
      this.video = video;
      this.caption = "";
      this.replyMarkup = "";
    }

    public Builder setDuration(int duration) {
      this.duration = duration;
      return this;
    }

    public Builder setCaption(String caption) {
      this.caption = caption;
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

    public SendVideoMessage build() {
      return new SendVideoMessage(this);
    }
  }


}
