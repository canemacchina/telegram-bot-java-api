package it.lorenzobugiani.api.files;

import java.io.File;
import java.io.IOException;

import it.lorenzobugiani.api.exceptions.InvalidFileException;

public abstract class TelegramFile {

  protected File file;

  public TelegramFile(File file) throws InvalidFileException, IOException {
    this.file = file;
    if (!this.isValid()) {
      String filename = file.getName();
      this.file = null;
      throw new InvalidFileException(this.getClass().getName() + ": File " + filename + " is invalid. Read Telegram documentation to check file restrictions");
    }
  }

  public File getFile() {
    return this.file;
  }

  protected abstract boolean isValid() throws IOException;

}
