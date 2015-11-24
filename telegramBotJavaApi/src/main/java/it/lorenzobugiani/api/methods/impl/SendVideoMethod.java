package it.lorenzobugiani.api.methods.impl;

import java.io.File;

import it.lorenzobugiani.api.entities.Message;
import it.lorenzobugiani.api.entities.ReplyMarkup;
import it.lorenzobugiani.api.files.VideoFile;
import it.lorenzobugiani.api.methods.MultipartMethod;

public class SendVideoMethod extends MultipartMethod<Message> {
  private VideoFile video;

  private SendVideoMethod(SendVideoMethod.Builder builder) {
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
    if (builder.video == null) {
      parameters.put("video", String.valueOf(builder.videoId));
    } else {
      this.video = builder.video;
    }
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
    return this.video == null ? null : this.video.getFile();
  }

  @Override
  public String getAttachmentName() {
    return "video";
  }

  public static class Builder {

    private int chatId;
    private VideoFile video;
    private String videoId;
    private int duration;
    private String caption;
    private int replyToMessageId;
    private String replyMarkup;

    public Builder(int chatId, VideoFile video) {
      this(chatId);
      this.video = video;
    }

    public Builder(int chatId, String videoId) {
      this(chatId);
      this.videoId = videoId;
    }

    private Builder(int chatId) {
      this.chatId = chatId;
      this.duration = -1;
      this.caption = "";
      this.replyToMessageId = -1;
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

    public SendVideoMethod build() {
      return new SendVideoMethod(this);
    }
  }


}
