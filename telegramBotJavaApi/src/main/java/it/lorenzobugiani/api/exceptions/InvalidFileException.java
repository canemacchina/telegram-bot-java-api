package it.lorenzobugiani.api.exceptions;

public class InvalidFileException extends Exception {

  private static final long serialVersionUID = 632017168554348845L;

  public InvalidFileException() {
    super();
  }

  public InvalidFileException(String message) {
    super(message);
  }

  public InvalidFileException(Throwable cause) {
    super(cause);
  }

  public InvalidFileException(String message, Throwable cause) {
    super(message, cause);
  }

}
