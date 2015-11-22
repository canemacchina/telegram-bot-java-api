package it.lorenzobugiani.api.methods.impl;

import java.io.File;

import it.lorenzobugiani.api.entities.Message;
import it.lorenzobugiani.api.entities.ReplyMarkup;
import it.lorenzobugiani.api.methods.MultipartMethod;

public class SendDocumentMethod extends MultipartMethod<Message> {

  private File document;

  private SendDocumentMethod(SendDocumentMethod.Builder builder) {
    super();
    parameters.put("chat_id", String.valueOf(builder.chatId));
    if (builder.replyToMessageId > 0) {
      parameters.put("reply_to_message_id", String.valueOf(builder.replyToMessageId));
    }
    if (!"".equals(builder.replyMarkup)) {
      parameters.put("reply_markup", String.valueOf(builder.replyMarkup));
    }
    this.document = builder.document;
  }

  @Override
  public Class<Message> getReturnType() {
    return Message.class;
  }

  @Override
  public String getMethodName() {
    return "sendDocument";
  }

  @Override
  public File getAttachment() {
    return this.document;
  }

  @Override
  public String getAttachmentName() {
    return "document";
  }

  public static class Builder {

    private int chatId;
    private File document;
    private int replyToMessageId;
    private String replyMarkup;

    public Builder(int chatId, File document) {
      this.chatId = chatId;
      this.document = document;
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

    public SendDocumentMethod build() {
      return new SendDocumentMethod(this);
    }
  }

}
