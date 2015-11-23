package it.lorenzobugiani.api.methods.impl;

import java.io.File;

import it.lorenzobugiani.api.Files.AudioFile;
import it.lorenzobugiani.api.entities.Message;
import it.lorenzobugiani.api.entities.ReplyMarkup;
import it.lorenzobugiani.api.methods.MultipartMethod;

public class SendVoiceMethod extends MultipartMethod<Message> {

  private AudioFile voice;

  private SendVoiceMethod(SendVoiceMethod.Builder builder) {
    super();
    parameters.put("chat_id", String.valueOf(builder.chatId));
    if (builder.duration > 0) {
      parameters.put("duration", String.valueOf(builder.duration));
    }
    if (builder.replyToMessageId > 0) {
      parameters.put("reply_to_message_id", String.valueOf(builder.replyToMessageId));
    }
    if (!"".equals(builder.replyMarkup)) {
      parameters.put("reply_markup", String.valueOf(builder.replyMarkup));
    }
    this.voice = builder.voice;
  }

  @Override
  public Class<Message> getReturnType() {
    return Message.class;
  }

  @Override
  public String getMethodName() {
    return "sendVoice";
  }

  @Override
  public File getAttachment() {
    return this.voice.getFile();
  }

  @Override
  public String getAttachmentName() {
    return "voice";
  }

  public static class Builder {

    private int chatId;
    private AudioFile voice;
    private int duration;
    private int replyToMessageId;
    private String replyMarkup;

    public Builder(int chatId, AudioFile voice) {
      this.chatId = chatId;
      this.voice = voice;
      this.replyMarkup = "";
    }

    public Builder setDuration(int duration) {
      this.duration = duration;
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

    public SendVoiceMethod build() {
      return new SendVoiceMethod(this);
    }
  }

}
