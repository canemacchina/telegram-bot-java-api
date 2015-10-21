package it.lorenzobugiani.api.methods;

public abstract class PostMethod<T> implements Method<T> {

  @Override
  public T executeMethod(MethodExecutor executor) {
    return executor.executeRequest(this);
  }

}
