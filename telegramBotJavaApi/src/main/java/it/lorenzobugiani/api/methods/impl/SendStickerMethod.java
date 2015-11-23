package it.lorenzobugiani.api.methods.impl;

import java.io.File;

import it.lorenzobugiani.api.Files.StikerFile;
import it.lorenzobugiani.api.entities.Message;
import it.lorenzobugiani.api.entities.ReplyMarkup;
import it.lorenzobugiani.api.methods.MultipartMethod;

public class SendStickerMethod extends MultipartMethod<Message> {

  private StikerFile sticker;

  private SendStickerMethod(SendStickerMethod.Builder builder) {
    super();
    parameters.put("chat_id", String.valueOf(builder.chatId));
    if (builder.replyToMessageId > 0) {
      parameters.put("reply_to_message_id", String.valueOf(builder.replyToMessageId));
    }
    if (!"".equals(builder.replyMarkup)) {
      parameters.put("reply_markup", String.valueOf(builder.replyMarkup));
    }
    if (builder.sticker == null) {
      parameters.put("sticker", String.valueOf(builder.stickerId));
    } else {
      this.sticker = builder.sticker;
    }
  }

  @Override
  public Class<Message> getReturnType() {
    return Message.class;
  }

  @Override
  public String getMethodName() {
    return "sendSticker";
  }

  @Override
  public File getAttachment() {
    return this.sticker == null ? null : this.sticker.getFile();
  }

  @Override
  public String getAttachmentName() {
    return "sticker";
  }

  public static class Builder {

    private int chatId;
    private StikerFile sticker;
    private String stickerId;
    private int replyToMessageId;
    private String replyMarkup;

    public Builder(int chatId, StikerFile sticker) {
      this(chatId);
      this.sticker = sticker;
    }

    public Builder(int chatId, String stickerId) {
      this(chatId);
      this.stickerId = stickerId;
    }

    private Builder(int chatId) {
      this.chatId = chatId;
      this.replyToMessageId = -1;
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

    public SendStickerMethod build() {
      return new SendStickerMethod(this);
    }
  }

}

