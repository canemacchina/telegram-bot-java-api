package it.lorenzobugiani.api.methods;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import com.google.common.reflect.TypeParameter;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.vdurmont.emoji.EmojiManager;

import it.lorenzobugiani.api.entities.Message;
import it.lorenzobugiani.api.entities.ReplyKeyboardMarkup;
import it.lorenzobugiani.api.entities.ReplyMarkup;
import it.lorenzobugiani.api.entities.User;
import it.lorenzobugiani.api.entities.UserProfilePhotos;
import it.lorenzobugiani.api.exceptions.InvalidFileException;
import it.lorenzobugiani.api.exceptions.RequestException;
import it.lorenzobugiani.api.files.PhotoFile;
import it.lorenzobugiani.api.methods.impl.GetMeMethod;
import it.lorenzobugiani.api.methods.impl.GetUserProfilePhotosMethod;
import it.lorenzobugiani.api.methods.impl.SendMessageMethod;
import it.lorenzobugiani.api.methods.impl.SendPhotoMethod;

public class SimpleMethodExecutor extends MethodExecutor {

  public SimpleMethodExecutor(String token) {
    super(token);
  }

  @Override
  public <T> T executeRequest(GetMethod<T> method) {
    try {
      String urlString = this.generateUrlEndpoint(method.getMethodName());
      Map<String, String> param = method.getParameters();
      if (param != null && !param.isEmpty()) {
        urlString += "?" + this.createQueryString(param);
      }
      URL url = new URL(urlString);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("GET");
      T resp = parseResponse(connection, method.getReturnType());
      connection.disconnect();
      return resp;
    } catch (

    MalformedURLException e)

    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (

    IOException e)

    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (

    RequestException e)

    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;

  }

  @Override
  public <T> T executeRequest(PostMethod<T> method) {
    try {
      URL url = new URL(this.generateUrlEndpoint(method.getMethodName()));
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("POST");
      Map<String, String> param = method.getParameters();
      if (param != null && !param.isEmpty()) {
        String paramSerialized = new Gson().toJson(param);
        connection.setRequestProperty("Content-length", String.valueOf(paramSerialized.length()));
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoInput(true);
        connection.setDoOutput(true);
        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
        writer.write(paramSerialized);
        writer.close();
      }
      T resp = parseResponse(connection, method.getReturnType());
      connection.disconnect();
      return resp;
    } catch (MalformedURLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (RequestException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public <T> T executeRequest(MultipartMethod<T> method) {
    try {
      MultipartUtility multipart = new MultipartUtility(this.generateUrlEndpoint(method.getMethodName()));
      Map<String, String> param = method.getParameters();
      for (Map.Entry<String, String> entry : param.entrySet()) {
        multipart.addFormField(entry.getKey(), entry.getValue());
      }
      if (method.getAttachment() != null) {
        multipart.addFilePart(method.getAttachmentName(), method.getAttachment());
      }
      HttpURLConnection connection = multipart.finish();
      T resp = parseResponse(connection, method.getReturnType());
      connection.disconnect();
      return resp;
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (RequestException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }

  private String read(InputStream in) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
    try {
      String line;
      StringBuilder stringBuilder = new StringBuilder();
      while ((line = reader.readLine()) != null) {
        stringBuilder.append(line);
      }
      return stringBuilder.toString();
    } finally {
      reader.close();
    }
  }

  private <T> T parseResponse(HttpURLConnection connection, Class<T> clazz) throws RequestException {
    try {
      if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
        @SuppressWarnings("serial")
        TypeToken<TelegramResponse<T>> t = new TypeToken<TelegramResponse<T>>() {}.where(new TypeParameter<T>() {}, TypeToken.of(clazz));
        TelegramResponse<T> ret = new Gson().fromJson(this.read(connection.getInputStream()), t.getType());
        return ret.getResult();
      } else {
        throw new RequestException(
            "Request return HTTP error code " + connection.getResponseCode() + " for the url " + connection.getURL() + ".\n Error desc is: " + this.read(connection.getInputStream()));
      }
    } catch (JsonSyntaxException e) {
      throw new RequestException(e);
    } catch (IOException e) {
      throw new RequestException(e);
    }
  }

  private class MultipartUtility {
    private static final String LINE_FEED = "\r\n";
    private static final String CHARSET = "UTF-8";
    private final String boundary;
    private HttpURLConnection httpConn;
    private OutputStream outputStream;
    private PrintWriter writer;

    private MultipartUtility(String requestURL) throws IOException {

      // creates a unique boundary based on time stamp
      boundary = "===" + System.currentTimeMillis() + "===";

      URL url = new URL(requestURL);
      httpConn = (HttpURLConnection) url.openConnection();
      httpConn.setRequestMethod("POST");
      // httpConn.setUseCaches(false);
      httpConn.setDoOutput(true);
      httpConn.setDoInput(true);
      httpConn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
      outputStream = httpConn.getOutputStream();
      writer = new PrintWriter(new OutputStreamWriter(outputStream, CHARSET), true);
    }

    public void addFormField(String name, String value) {
      writer.append("--" + boundary).append(LINE_FEED);
      writer.append("Content-Disposition: form-data; name=\"" + name + "\"").append(LINE_FEED);
      writer.append("Content-Type: text/plain; charset=" + CHARSET).append(LINE_FEED);
      writer.append(LINE_FEED);
      writer.append(value).append(LINE_FEED);
      writer.flush();
    }

    public void addFilePart(String fieldName, File uploadFile) throws IOException {
      String fileName = uploadFile.getName();
      writer.append("--" + boundary).append(LINE_FEED);
      writer.append("Content-Disposition: form-data; name=\"" + fieldName + "\"; filename=\"" + fileName + "\"").append(LINE_FEED);
      writer.append("Content-Type: " + URLConnection.guessContentTypeFromName(fileName)).append(LINE_FEED);
      writer.append("Content-Transfer-Encoding: binary").append(LINE_FEED);
      writer.append(LINE_FEED);
      writer.flush();

      FileInputStream inputStream = new FileInputStream(uploadFile);
      byte[] buffer = new byte[4096];
      int bytesRead = -1;
      while ((bytesRead = inputStream.read(buffer)) != -1) {
        outputStream.write(buffer, 0, bytesRead);
      }
      outputStream.flush();
      inputStream.close();

      writer.append(LINE_FEED);
      writer.flush();
    }

    public HttpURLConnection finish() throws IOException {
      writer.append(LINE_FEED).flush();
      writer.append("--" + boundary + "--").append(LINE_FEED);
      writer.close();
      return httpConn;
    }
  }

  public static void main(String[] args) throws InvalidFileException, IOException {
    MethodExecutor executor = new SimpleMethodExecutor("159614546:AAF-XwSgLNkfnH_PeIsUm0iNF9xqDVxTuS8");

    GetMeMethod req = new GetMeMethod();
    User ret1 = req.executeMethod(executor);

    GetUserProfilePhotosMethod req2 = new GetUserProfilePhotosMethod.Builder(43889768).setLimit(100).setOffset(0).build();
    UserProfilePhotos ret2 = req2.executeMethod(executor);

    ReplyMarkup m = new ReplyKeyboardMarkup.Builder().row("A", "B").row("B", "C").setOneTimeKeyboard().build();
    SendPhotoMethod req3 = new SendPhotoMethod.Builder(43889768, new PhotoFile(new File(SimpleMethodExecutor.class.getClassLoader().getResource("img.jpg").getFile()))).setReplyMarkup(m).build();
    Message ret3 = req3.executeMethod(executor);

    // testo con faccina
    // https://github.com/vdurmont/emoji-java
    SendMessageMethod req4 = new SendMessageMethod.Builder(43889768, "testo di prova " + EmojiManager.getForAlias("+1").getUnicode()).build();
    Message ret4 = req4.executeMethod(executor);
  }

}
