package it.lorenzobugiani.api.methods.impl;

import java.io.File;

import it.lorenzobugiani.api.entities.Message;
import it.lorenzobugiani.api.entities.ReplyMarkup;
import it.lorenzobugiani.api.files.VoiceFile;
import it.lorenzobugiani.api.methods.MultipartMethod;

public class SendVoiceMethod extends MultipartMethod<Message> {

  private VoiceFile voice;

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
    if (builder.voice == null) {
      parameters.put("voice", String.valueOf(builder.voiceId));
    } else {
      this.voice = builder.voice;
    }
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
    return this.voice == null ? null : this.voice.getFile();
  }

  @Override
  public String getAttachmentName() {
    return "voice";
  }

  public static class Builder {

    private int chatId;
    private VoiceFile voice;
    private String voiceId;
    private int duration;
    private int replyToMessageId;
    private String replyMarkup;

    public Builder(int chatId, VoiceFile voice) {
      this(chatId);
      this.voice = voice;
    }

    public Builder(int chatId, String voiceId) {
      this(chatId);
      this.voiceId = voiceId;
    }

    private Builder(int chatId) {
      this.chatId = chatId;
      this.duration = -1;
      this.replyToMessageId = -1;
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
