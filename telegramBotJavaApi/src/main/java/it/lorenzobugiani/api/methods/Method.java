package it.lorenzobugiani.api.methods;

import java.util.Map;

public interface Method<T> {

  public T executeMethod(MethodExecutor executor);

  public Map<String, String> getParameters();

  public Class<T> getReturnType();

  public String getMethodName();

}
