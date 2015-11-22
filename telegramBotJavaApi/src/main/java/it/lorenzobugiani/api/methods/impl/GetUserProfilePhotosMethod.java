package it.lorenzobugiani.api.methods.impl;

import it.lorenzobugiani.api.entities.UserProfilePhotos;
import it.lorenzobugiani.api.methods.PostMethod;

public class GetUserProfilePhotosMethod extends PostMethod<UserProfilePhotos> {

  private GetUserProfilePhotosMethod(GetUserProfilePhotosMethod.Builder builder) {
    super();
    parameters.put("user_id", String.valueOf(builder.userId));
    if (builder.offset > 0) {
      parameters.put("offset", String.valueOf(builder.offset));
    }
    parameters.put("limit", String.valueOf(builder.limit));
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
    private int offset;
    private int limit;

    public Builder(int user_id) {
      this.userId = user_id;
      this.offset = -1;
      this.limit = 100;
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
