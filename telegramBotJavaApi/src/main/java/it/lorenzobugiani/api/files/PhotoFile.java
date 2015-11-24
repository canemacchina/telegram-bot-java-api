package it.lorenzobugiani.api.files;

import java.io.File;
import java.io.IOException;

import it.lorenzobugiani.api.exceptions.InvalidFileException;

public class PhotoFile extends TelegramFile {

  private static final String PHOTO_MIME_TYPE = "image";

  public PhotoFile(File file) throws InvalidFileException, IOException {
    super(file);
  }

  @Override
  protected boolean isValid() throws IOException {
    // String mimeType = new FileTypeDetector().probeContentType(this.file.toPath());
    // if (mimeType == null || !mimeType.contains(PHOTO_MIME_TYPE)) {
    // return false;
    // }
    return true;
  }

}
