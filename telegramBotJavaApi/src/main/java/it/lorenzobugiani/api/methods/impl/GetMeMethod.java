package it.lorenzobugiani.api.methods.impl;

import it.lorenzobugiani.api.entities.User;
import it.lorenzobugiani.api.methods.GetMethod;

public class GetMeMethod extends GetMethod<User> {

  public GetMeMethod() {
    super();
  }

  @Override
  public Class<User> getReturnType() {
    return User.class;
  }

  @Override
  public String getMethodName() {
    return "getMe";
  }

}
