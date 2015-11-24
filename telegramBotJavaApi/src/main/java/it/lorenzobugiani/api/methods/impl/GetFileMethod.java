package it.lorenzobugiani.api.methods.impl;

import it.lorenzobugiani.api.entities.File;
import it.lorenzobugiani.api.methods.GetMethod;

public class GetFileMethod extends GetMethod<File> {

  public GetFileMethod(String fileId) {
    super();
    parameters.put("file_id", fileId);
  }

  @Override
  public Class<File> getReturnType() {
    return File.class;
  }

  @Override
  public String getMethodName() {
    return "getFile";
  }

}
