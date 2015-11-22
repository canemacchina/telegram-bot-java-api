package it.lorenzobugiani.api.methods.impl;

import java.io.File;

import it.lorenzobugiani.api.entities.Message;
import it.lorenzobugiani.api.entities.ReplyMarkup;
import it.lorenzobugiani.api.methods.MultipartMethod;

public class SendAudioMethod extends MultipartMethod<Message> {

  private File audio;

  private SendAudioMethod(SendAudioMethod.Builder builder) {
    super();
    parameters.put("chat_id", String.valueOf(builder.chatId));
    if (builder.duration > 0) {
      parameters.put("duration", String.valueOf(builder.duration));
    }
    if (!"".equals(builder.performer)) {
      parameters.put("performer", String.valueOf(builder.performer));
    }
    if (!"".equals(builder.title)) {
      parameters.put("title", String.valueOf(builder.title));
    }
    if (builder.replyToMessageId > 0) {
      parameters.put("reply_to_message_id", String.valueOf(builder.replyToMessageId));
    }
    if (!"".equals(builder.replyMarkup)) {
      parameters.put("reply_markup", String.valueOf(builder.replyMarkup));
    }
    this.audio = builder.audio;
  }

  @Override
  public Class<Message> getReturnType() {
    return Message.class;
  }

  @Override
  public String getMethodName() {
    return "sendAudio";
  }

  @Override
  public File getAttachment() {
    return this.audio;
  }

  @Override
  public String getAttachmentName() {
    return "audio";
  }

  public static class Builder {

    private int chatId;
    private File audio;
    private int duration;
    private String performer;
    private String title;
    private int replyToMessageId;
    private String replyMarkup;

    public Builder(int chatId, File audio) {
      this.chatId = chatId;
      this.audio = audio;
      this.replyMarkup = "";
    }

    public Builder setDuration(int duration) {
      this.duration = duration;
      return this;
    }

    public Builder setPerformer(String performer) {
      this.performer = performer;
      return this;
    }

    public Builder setTitle(String title) {
      this.title = title;
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

    public SendAudioMethod build() {
      return new SendAudioMethod(this);
    }
  }
}
