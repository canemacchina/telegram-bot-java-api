package it.lorenzobugiani.api.methods.impl;

import java.io.File;

import it.lorenzobugiani.api.entities.Message;
import it.lorenzobugiani.api.entities.ReplyMarkup;
import it.lorenzobugiani.api.files.AudioFile;
import it.lorenzobugiani.api.methods.MultipartMethod;

public class SendAudioMethod extends MultipartMethod<Message> {

  private AudioFile audio;

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
    if (builder.audio == null) {
      parameters.put("audio", String.valueOf(builder.audioId));
    } else {
      this.audio = builder.audio;
    }
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
    return audio == null ? null : audio.getFile();
  }

  @Override
  public String getAttachmentName() {
    return "audio";
  }

  public static class Builder {

    private int chatId;
    private AudioFile audio;
    private String audioId;
    private int duration;
    private String performer;
    private String title;
    private int replyToMessageId;
    private String replyMarkup;

    public Builder(int chatId, AudioFile audio) {
      this(chatId);
      this.audio = audio;
    }

    public Builder(int chatId, String audioId) {
      this(chatId);
      this.audioId = audioId;
    }

    private Builder(int chatId) {
      this.chatId = chatId;
      this.duration = -1;
      this.performer = "";
      this.title = "";
      this.replyToMessageId = -1;
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
