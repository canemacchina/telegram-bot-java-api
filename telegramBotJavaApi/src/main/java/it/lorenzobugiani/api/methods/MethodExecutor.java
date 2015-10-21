package it.lorenzobugiani.api.methods;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public abstract class MethodExecutor {

  private static final String API_URL = "https://api.telegram.org/bot";
  private String baseUrl;

  public MethodExecutor(String token) {
    this.baseUrl = API_URL + token + "/";
  }

  public abstract <T> T executeRequest(GetMethod<T> req);

  public abstract <T> T executeRequest(PostMethod<T> req);

  public abstract <T> T executeRequest(MultipartMethod<T> req);

  protected String generateUrlEndpoint(String methodName) {
    return this.baseUrl + methodName;
  }

  protected String createQueryString(Map<String, String> arguments) throws UnsupportedEncodingException {
    StringBuilder stringBuilder = new StringBuilder();
    String ampersand = "";
    for (Map.Entry<String, String> entry : arguments.entrySet()) {
      stringBuilder.append(ampersand).append(URLEncoder.encode(entry.getKey(), "UTF-8")).append("=").append(URLEncoder.encode(entry.getValue(), "UTF-8"));
      ampersand = "&";
    }
    return stringBuilder.toString();
  }

}
