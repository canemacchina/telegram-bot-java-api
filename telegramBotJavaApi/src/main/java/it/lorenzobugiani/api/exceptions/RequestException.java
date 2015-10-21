package it.lorenzobugiani.api.exceptions;

public class RequestException extends Exception {

  private static final long serialVersionUID = -4872590129105405800L;

  public RequestException() {
    super();
  }

  public RequestException(String message) {
    super(message);
  }

  public RequestException(Throwable cause) {
    super(cause);
  }

  public RequestException(String message, Throwable cause) {
    super(message, cause);
  }

}
