package it.lorenzobugiani.api.Files;

import java.io.File;
import java.io.IOException;

import it.lorenzobugiani.api.exceptions.InvalidFileException;

public class DocumentFile extends TelegramFile {

  private static final long MAX_SIZE = 52428800; // 50MB

  public DocumentFile(File file) throws InvalidFileException, IOException {
    super(file);
  }

  @Override
  protected boolean isValid() throws IOException {
    if (this.file.length() > MAX_SIZE) {
      return false;
    }
    return true;
  }

}
