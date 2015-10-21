package it.lorenzobugiani.api.methods;

import java.io.File;

public abstract class MultipartMethod<T> implements Method<T> {

  @Override
  public T executeMethod(MethodExecutor executor) {
    return executor.executeRequest(this);
  }

  public abstract File getAttachment();

  public abstract String getAttachmentName();

}
