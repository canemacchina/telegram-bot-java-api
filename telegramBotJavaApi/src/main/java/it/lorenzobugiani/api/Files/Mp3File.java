package it.lorenzobugiani.api.Files;

import java.io.File;
import java.io.IOException;

import it.lorenzobugiani.api.exceptions.InvalidFileException;
import it.lorenzobugiani.api.utils.FileTypeDetector;

public class Mp3File extends TelegramFile {

  public Mp3File(File file) throws InvalidFileException, IOException {
    super(file);
  }

  private static final long MAX_SIZE = 52428800; // 50MB

  @Override
  protected boolean isValid() throws IOException {
    String mimeType = new FileTypeDetector().probeContentType(this.file.toPath());
    if(!mimeType.equals("audio/mp3")){
      return false;
    }
    if(this.file.length() > MAX_SIZE){
      return false;
    }
    return true;
  }
  
}
