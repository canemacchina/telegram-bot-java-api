package it.lorenzobugiani.api.methods;

import java.io.File;

import it.lorenzobugiani.api.exceptions.RequestException;

public abstract class MultipartMethod<T> extends AbstractMethod<T> {

  @Override
  public T execute(MethodExecutor executor) throws RequestException {
    return executor.executeRequest(this);
  }

  public abstract File getAttachment();

  public abstract String getAttachmentName();

}
