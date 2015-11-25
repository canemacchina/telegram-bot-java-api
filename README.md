# telegram-bot-java-api
`telegram-bot-java-api` is an unofficial JAVA implementation of [Telegram Bot Api](https://core.telegram.org/bots/api)

**Table of Contents**

- [Getting Started](#getting-started)
  - [Get the library](#get-the-library)
- [Usage](#usage)
  - [API Methods examples](#api-methods-examples)
  - [Reply Markup](#reply-markup)
- [TO DO](#to-do)
- [License](#license)

## Getting Started
### Get the library
At the time of writing this README, this library isn't published anywhere, so to use it:

* download the [latest release](https://github.com/canemacchina/telegram-bot-java-api/releases) and use the source code as you will;
* use Github as a package repository! Take look at [JitPack](https://jitpack.io/), that can turn a Github repo into a maven repository or a Gradle repository!

## Usage
To call a Telegram bot API method, first create a method executor:
```java
MethodExecutor executor = new SimpleMethodExecutor("<BOT TOKEN HERE>");
```
Then, create the API method corresponding object and execute it!
```java
Method method = //... construct an API Method
method.execute(executor);
```
### API Methods examples
**getMe**
```java
GetMeMethod method = new GetMeMethod();
System.out.println(method.execute(executor));
```
**sendMessage**
```java
SendMessageMethod method = new SendMessageMethod.Builder(<CHAT ID HERE>, <YOUR TEXT HERE>).build();
System.out.println(method.execute(executor));
```
**forwardMessage**
```java
ForwardMessageMethod method = new ForwardMessageMethod(<CHAT ID HERE>, <FROM CHAT ID HERE>, <MESSAGE ID HERE>);
System.out.println(method.execute(executor));
```
**sendPhoto**
```java
PhotoFile file = new PhotoFile(new File(<PATH TO MP3 FILE>));
SendPhotoMethod method = new SendPhotoMethod.Builder(<CHAT ID HERE>, file).build();
System.out.println(method.execute(executor));
```
or, if you want to resend a photo that is already on Telegram server:
```java
SendPhotoMethod method = new SendPhotoMethod.Builder(<CHAT ID HERE>, <FILE ID HERE>).build();
System.out.println(method.execute(executor));
```
**sendAudio**
```java
AudioFile file = new AudioFile(new File(<PATH TO MP3 FILE>));
SendAudioMethod method = new SendAudioMethod.Builder(<CHAT ID HERE>, file).build();
System.out.println(method.execute(executor));
```
or, if you want to resend an audio that is already on Telegram server:
```java
SendAudioMethod method = new SendAudioMethod.Builder(<CHAT ID HERE>, <AUDIO ID HERE>).build();
System.out.println(method.execute(executor));
```
**sendDocument**
```java
DocumentFile file = new DocumentFile(new File(<PATH TO MP3 FILE>));
SendDocumentMethod method = new SendDocumentMethod.Builder(<CHAT ID HERE>, file).build();
System.out.println(method.execute(executor));
```
or, if you want to resend a document that is already on Telegram server:
```java
SendDocumentMethod method = new SendDocumentMethod.Builder(<CHAT ID HERE>, <DOCUMENT ID HERE>).build();
System.out.println(method.execute(executor));
```
**sendSticker**
```java
StikerFile file = new StikerFile(new File(<PATH TO MP3 FILE>));
SendStickerMethod method = new SendStickerMethod.Builder(<CHAT ID HERE>, file).build();
System.out.println(method.execute(executor));
```
or, if you want to resend a sticker that is already on Telegram server:
```java
SendStickerMethod method = new SendStickerMethod.Builder(<CHAT ID HERE>, <STICKER ID HERE>).build();
System.out.println(method.execute(executor));
```
**sendVideo**
```java
VideoFile file = new VideoFile(new File(<PATH TO MP3 FILE>));
SendVideoMethod method = new SendVideoMethod.Builder(<CHAT ID HERE>, file).build();
System.out.println(method.execute(executor));
```
or, if you want to resend a video that is already on Telegram server:
```java
SendVideoMethod method = new SendVideoMethod.Builder(<CHAT ID HERE>, <VIDEO ID HERE>).build();
System.out.println(method.execute(executor));
```
**sendVoice**
```java
VoiceFile file = new VoiceFile(new File(<PATH TO MP3 FILE>));
SendVoiceMethod method = new SendVoiceMethod.Builder(<CHAT ID HERE>, file).build();
System.out.println(method.execute(executor));
```
or, if you want to resend a voice that is already on Telegram server:
```java
SendVoiceMethod method = new SendVoiceMethod.Builder(<CHAT ID HERE>, <VOICE ID HERE>).build();
System.out.println(method.execute(executor));
```
**sendLocation**
```java
SendLocationMethod method = new SendLocationMethod.Builder(<CHAT ID HERE>, <LAT>, <LONG>).build();
System.out.println(method.execute(executor));
```
**sendChatAction**
```java
SendChatActionMethod method = new SendChatActionMethod(<CHAT ID HERE>, SendChatActionMethod.Actions.<TYPE>);
System.out.println(method.execute(executor));
```
**getUserProfilePhotos**
```java
GetUserProfilePhotosMethod method = new GetUserProfilePhotosMethod.Builder(<USER ID HERE>).build();
System.out.println(method.execute(executor));
```
**getUpdates**
```java
GetupdatesMethod method = new GetupdatesMethod.Builder().build();
Update[] updates = method.execute(executor);
for (Update update : updates) {
  System.out.println(update);
}
```
**getFile**
```java
GetFileMethod method = new GetFileMethod(fileId);;
System.out.println(method.execute(executor));
```

### Reply Markup
When a method support a [Reply Keyboard Markup](https://core.telegram.org/bots/api#replykeyboardmarkup), you can construct it with the Method builder. So, for example:
```java
// Create a keyboard with 2 row of buttons
//that will be hide as soon as the user use it:
ReplyMarkup m = new ReplyKeyboardMarkup.Builder()
  .row("A", "B")
  .row("C", "D")
  .setOneTimeKeyboard()
  .build();
// Construct SendMessageMethod and attach the keyboard:
SendMessageMethod method = new SendMessageMethod.Builder(<CHAT ID HERE>, <YOUR TEXT HERE>)
  .setReplyMarkup(m)
  .build();
```
### TO DO
Javadocs. As soon as possible, I'll write some Javadoc, I promise!!

## License
MIT. See the LICENSE file for more details.