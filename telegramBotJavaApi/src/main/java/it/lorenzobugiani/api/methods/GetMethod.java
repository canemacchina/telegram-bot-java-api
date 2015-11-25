package it.lorenzobugiani.api.methods;

import it.lorenzobugiani.api.exceptions.RequestException;

public abstract class GetMethod<T> extends AbstractMethod<T> {

  @Override
  public T execute(MethodExecutor executor) throws RequestException {
    return executor.executeRequest(this);
  }

}
