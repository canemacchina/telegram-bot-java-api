package it.lorenzobugiani.api.methods;

import java.util.HashMap;
import java.util.Map;

abstract class AbstractMethod<T> implements Method<T> {

  protected Map<String, String> parameters;

  public AbstractMethod() {
    this.parameters = new HashMap<>();
  }

  @Override
  public Map<String, String> getParameters() {
    return parameters;
  }

}
