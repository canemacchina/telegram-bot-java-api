package it.lorenzobugiani.api.methods.impl;

import java.util.HashMap;
import java.util.Map;

import it.lorenzobugiani.api.entities.Message;
import it.lorenzobugiani.api.entities.ReplyMarkup;
import it.lorenzobugiani.api.methods.PostMethod;

public class SendMessageMethod extends PostMethod<Message> {

  private Map<String, String> parameters;

  private SendMessageMethod(SendMessageMethod.Builder builder) {
    this.parameters = new HashMap<>();
    parameters.put("chat_id", String.valueOf(builder.chatId));
    parameters.put("text", String.valueOf(builder.text));
    if (!"".equals(builder.parseMode)) {
      parameters.put("parse_mode", String.valueOf(builder.parseMode));
    }
    parameters.put("disable_web_page_preview", String.valueOf(builder.disableWebPagePreview));
    if (builder.replyToMessageId > 0) {
      parameters.put("reply_to_message_id", String.valueOf(builder.replyToMessageId));
    }
    if (!"".equals(builder.replyMarkup)) {
      parameters.put("reply_markup", String.valueOf(builder.replyMarkup));
    }
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
    return "sendMessage";
  }

  public static class Builder {

    private int chatId;
    private String text;
    private String parseMode = "";
    private boolean disableWebPagePreview = false;
    private int replyToMessageId;
    private String replyMarkup;

    public Builder(int chatId, String text) {
      this.chatId = chatId;
      this.text = text;
    }

    public Builder setParseMode() {
      this.parseMode = "Markdown";
      return this;
    }

    public Builder setDisableWebPagePreview(boolean disableWebPagePreview) {
      this.disableWebPagePreview = disableWebPagePreview;
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

    public SendMessageMethod build() {
      return new SendMessageMethod(this);
    }

  }


}
