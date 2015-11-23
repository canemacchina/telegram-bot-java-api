package it.lorenzobugiani.api.Files;

import java.io.File;
import java.io.IOException;

import it.lorenzobugiani.api.exceptions.InvalidFileException;

public class Mp3File extends TelegramFile {

  public Mp3File(File file) throws InvalidFileException, IOException {
    super(file);
  }

  private static final long MAX_SIZE = 52428800; // 50MB

  @Override
  protected boolean isValid() throws IOException {
    // FileTypeDetector typeDetector = new FileTypeDetector();
    // String mimeType = typeDetector.probeContentType(this.getFile().toPath());
    return false;
  }

}
