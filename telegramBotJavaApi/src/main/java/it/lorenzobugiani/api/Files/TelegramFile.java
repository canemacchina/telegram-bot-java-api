package it.lorenzobugiani.api.Files;

import java.io.File;
import java.io.IOException;

import it.lorenzobugiani.api.exceptions.InvalidFileException;

public abstract class TelegramFile {

  private File file;

  public TelegramFile(File file) throws InvalidFileException, IOException {
    this.file = file;
    if (!this.isValid()) {
      this.file = null;
      throw new InvalidFileException("File is invalid. Read Telegram documentation to check file restrictions");
    }
  }

  public File getFile() {
    return this.file;
  }

  protected abstract boolean isValid() throws IOException;

}
