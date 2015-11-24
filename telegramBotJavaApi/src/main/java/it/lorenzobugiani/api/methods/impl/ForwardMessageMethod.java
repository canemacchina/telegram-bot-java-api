package it.lorenzobugiani.api.methods.impl;

import it.lorenzobugiani.api.entities.Message;
import it.lorenzobugiani.api.methods.PostMethod;

public class ForwardMessageMethod extends PostMethod<Message> {


  public ForwardMessageMethod(int chatId, int fromChatId, int messageId) {
    super();
    parameters.put("chat_id", String.valueOf(chatId));
    parameters.put("from_chat_id", String.valueOf(fromChatId));
    parameters.put("message_id", String.valueOf(messageId));
  }

  @Override
  public Class<Message> getReturnType() {
    return Message.class;
  }

  @Override
  public String getMethodName() {
    return "forwardMessage";
  }

}
