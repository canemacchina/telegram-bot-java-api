package it.lorenzobugiani.api.methods;

import java.util.Map;

import it.lorenzobugiani.api.exceptions.RequestException;

public interface Method<T> {

  public T execute(MethodExecutor executor) throws RequestException;

  public Map<String, String> getParameters();

  public Class<T> getReturnType();

  public String getMethodName();

}
