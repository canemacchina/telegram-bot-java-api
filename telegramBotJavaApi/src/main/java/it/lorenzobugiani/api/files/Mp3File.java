package it.lorenzobugiani.api.files;

import java.io.File;
import java.io.IOException;

import it.lorenzobugiani.api.exceptions.InvalidFileException;
import it.lorenzobugiani.api.utils.FileTypeDetector;

public class Mp3File extends TelegramFile {

  private static final long MAX_SIZE = 52428800; // 50MB
  private static final String MP3_MIME_TYPE = "audio/mp3";

  public Mp3File(File file) throws InvalidFileException, IOException {
    super(file);
  }

  @Override
  protected boolean isValid() throws IOException {
    String mimeType = new FileTypeDetector().probeContentType(this.file.toPath());
    if (!MP3_MIME_TYPE.equals(mimeType)) {
      return false;
    }
    if (this.file.length() > MAX_SIZE) {
      return false;
    }
    return true;
  }

}
