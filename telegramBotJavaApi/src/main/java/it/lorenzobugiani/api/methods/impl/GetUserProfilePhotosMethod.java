package it.lorenzobugiani.api.methods.impl;

import java.util.HashMap;
import java.util.Map;

import it.lorenzobugiani.api.entities.UserProfilePhotos;
import it.lorenzobugiani.api.methods.PostMethod;

public class GetUserProfilePhotosMethod extends PostMethod<UserProfilePhotos> {

  private Map<String, String> parameters;

  private GetUserProfilePhotosMethod(GetUserProfilePhotosMethod.Builder builder) {
    this.parameters = new HashMap<>();
    parameters.put("user_id", String.valueOf(builder.userId));
    if (builder.offset > 0) {
      parameters.put("offset", String.valueOf(builder.offset));
    }
    parameters.put("limit", String.valueOf(builder.limit));
  }

  @Override
  public Map<String, String> getParameters() {
    return parameters;
  }

  @Override
  public Class<UserProfilePhotos> getReturnType() {
    return UserProfilePhotos.class;
  }

  @Override
  public String getMethodName() {
    return "getUserProfilePhotos";
  }

  public static class Builder {

    private int userId;
    private int offset = -1;
    private int limit = 100;

    public Builder(int user_id) {
      this.userId = user_id;
    }

    public Builder setOffset(int offset) {
      this.offset = offset;
      return this;
    }

    public Builder setLimit(int limit) {
      this.limit = limit;
      return this;
    }

    public GetUserProfilePhotosMethod build() {
      return new GetUserProfilePhotosMethod(this);
    }

  }

}
