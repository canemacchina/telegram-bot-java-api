package it.lorenzobugiani.api.files;

import java.io.File;
import java.io.IOException;

import it.lorenzobugiani.api.exceptions.InvalidFileException;

public class VideoFile extends TelegramFile {

  private static final long MAX_SIZE = 52428800; // 50MB
  private static final String MP4_MIME_TYPE = "audio/mp4";

  public VideoFile(File file) throws InvalidFileException, IOException {
    super(file);
  }

  @Override
  protected boolean isValid() throws IOException {
    // String mimeType = new FileTypeDetector().probeContentType(this.file.toPath());
    // if (!MP4_MIME_TYPE.equals(mimeType)) {
    // return false;
    // }
    if (this.file.length() > MAX_SIZE) {
      return false;
    }
    return true;
  }

}

