package it.lorenzobugiani.api.methods.impl;

import java.util.Map;

import it.lorenzobugiani.api.entities.User;
import it.lorenzobugiani.api.methods.GetMethod;

public class GetMeMethod extends GetMethod<User> {

  @Override
  public Class<User> getReturnType() {
    return User.class;
  }

  @Override
  public Map<String, String> getParameters() {
    return null;
  }


  @Override
  public String getMethodName() {
    return "getMe";
  }

}
