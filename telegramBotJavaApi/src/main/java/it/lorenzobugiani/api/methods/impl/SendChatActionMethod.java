package it.lorenzobugiani.api.methods.impl;

import it.lorenzobugiani.api.methods.PostMethod;

public class SendChatActionMethod extends PostMethod<Void> {

  public SendChatActionMethod(int chatId, Actions action) {
    super();
    parameters.put("chat_id", String.valueOf(chatId));
    parameters.put("action", action.getCode());
  }

  @Override
  public Class<Void> getReturnType() {
    return Void.class;
  }

  @Override
  public String getMethodName() {
    return "sendChatAction";
  }

  public enum Actions {
    // @formatter:off
    TYPING("typing"),
    UPLOAD_PHOTO("upload_photo"),
    RECORD_VIDEO("record_video"),
    UPLOAD_VIDEO("upload_video"),
    RECORD_AUDIO("record_audio"),
    UPLOAD_AUDIO("upload_audio"),
    UPLOAD_DOCUMENT("upload_document"),
    FIND_LOCATION("find_location");
    // @formatter:on

    private String code;

    private Actions(String code) {
      this.code = code;
    }

    public String getCode() {
      return this.code;
    }

  }

}
