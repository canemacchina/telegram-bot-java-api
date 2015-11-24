package it.lorenzobugiani.api.methods.impl;

import com.google.common.base.Preconditions;

import it.lorenzobugiani.api.entities.Updates;
import it.lorenzobugiani.api.methods.PostMethod;

public class GetupdatesMethod extends PostMethod<Updates> {

  private GetupdatesMethod(GetupdatesMethod.Builder builder) {
    super();
    parameters.put("offset", String.valueOf(builder.offset));
    parameters.put("limit", String.valueOf(builder.limit));
    parameters.put("timeout", String.valueOf(builder.timeout));
  }

  @Override
  public Class<Updates> getReturnType() {
    return Updates.class;
  }

  @Override
  public String getMethodName() {
    return "getUpdates";
  }

  public static class Builder {

    private int offset;
    private int limit;
    private int timeout;

    public Builder(int offset) {
      this.offset = offset;
      this.limit = 100;
      this.timeout = 0;
    }

    public Builder setOffset(int offset) {
      this.offset = offset;
      return this;
    }

    public Builder setLimit(int limit) {
      Preconditions.checkArgument(limit >= 0 && limit <= 100, "Limit must be 0 <= limit <= 100");
      this.limit = limit;
      return this;
    }

    public Builder setTimeout(int timeout) {
      this.timeout = timeout;
      return this;
    }

    public GetupdatesMethod build() {
      return new GetupdatesMethod(this);
    }

  }

}
