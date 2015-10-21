package it.lorenzobugiani.api.entities;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/**
 * This object represents a message.
 *
 * Any getters labeled <i>optional</i> might return a default value (such as {@code null}).
 *
 * @see <a href="https://core.telegram.org/bots/api#message">https://core.telegram.org/bots/api#
 *      message</a>
 */
public class Message {

  @SerializedName("message_id")
  private int messageId;

  @SerializedName("from")
  private User from;

  @SerializedName("date")
  private int date;

  @SerializedName("chat")
  private Chat chat;

  @SerializedName("forward_from")
  private User forwardFrom;

  @SerializedName("forward_date")
  private int forwardDate;

  @SerializedName("reply_to_message")
  private Message replyToMessage;

  @SerializedName("text")
  private String text;

  @SerializedName("audio")
  private Audio audio;

  @SerializedName("document")
  private Document document;

  @SerializedName("photo")
  private List<PhotoSize> photo;

  @SerializedName("sticker")
  private Sticker sticker;

  @SerializedName("video")
  private Video video;

  @SerializedName("voice")
  private Voice voice;

  @SerializedName("caption")
  private String caption;

  @SerializedName("contact")
  private Contact contact;

  @SerializedName("location")
  private Location location;

  @SerializedName("new_chat_participant")
  private User newChatParticipant;

  @SerializedName("left_chat_participant")
  private User leftChatParticipant;

  @SerializedName("new_chat_title")
  private String newChatTitle;

  @SerializedName("new_chat_photo")
  private List<PhotoSize> newChatPhoto;

  @SerializedName("delete_chat_photo")
  private boolean deleteChatPhoto;

  @SerializedName("group_chat_created")
  private boolean groupChatCreated;

  private transient MessageType type;

  public int getMessageId() {
    return messageId;
  }

  public void setMessageId(int messageId) {
    this.messageId = messageId;
  }

  public User getFrom() {
    return from;
  }

  public void setFrom(User from) {
    this.from = from;
  }

  public int getDate() {
    return date;
  }

  public void setDate(int date) {
    this.date = date;
  }

  public Chat getChat() {
    return chat;
  }

  public void setChat(Chat chat) {
    this.chat = chat;
  }

  public User getForwardFrom() {
    return forwardFrom;
  }

  public void setForwardFrom(User forwardFrom) {
    this.forwardFrom = forwardFrom;
  }

  public int getForwardDate() {
    return forwardDate;
  }

  public void setForwardDate(int forwardDate) {
    this.forwardDate = forwardDate;
  }

  public Message getReplyToMessage() {
    return replyToMessage;
  }

  public void setReplyToMessage(Message replyToMessage) {
    this.replyToMessage = replyToMessage;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Audio getAudio() {
    return audio;
  }

  public void setAudio(Audio audio) {
    this.audio = audio;
  }

  public Document getDocument() {
    return document;
  }

  public void setDocument(Document document) {
    this.document = document;
  }

  public List<PhotoSize> getPhoto() {
    return photo;
  }

  public void setPhoto(List<PhotoSize> photo) {
    this.photo = photo;
  }

  public Sticker getSticker() {
    return sticker;
  }

  public void setSticker(Sticker sticker) {
    this.sticker = sticker;
  }

  public Video getVideo() {
    return video;
  }

  public void setVideo(Video video) {
    this.video = video;
  }

  public Voice getVoice() {
    return voice;
  }

  public void setVoice(Voice voice) {
    this.voice = voice;
  }

  public String getCaption() {
    return caption;
  }

  public void setCaption(String caption) {
    this.caption = caption;
  }

  public Contact getContact() {
    return contact;
  }

  public void setContact(Contact contact) {
    this.contact = contact;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public User getNewChatParticipant() {
    return newChatParticipant;
  }

  public void setNewChatParticipant(User newChatParticipant) {
    this.newChatParticipant = newChatParticipant;
  }

  public User getLeftChatParticipant() {
    return leftChatParticipant;
  }

  public void setLeftChatParticipant(User leftChatParticipant) {
    this.leftChatParticipant = leftChatParticipant;
  }

  public String getNewChatTitle() {
    return newChatTitle;
  }

  public void setNewChatTitle(String newChatTitle) {
    this.newChatTitle = newChatTitle;
  }

  public List<PhotoSize> getNewChatPhoto() {
    return newChatPhoto;
  }

  public void setNewChatPhoto(List<PhotoSize> newChatPhoto) {
    this.newChatPhoto = newChatPhoto;
  }

  public boolean isDeleteChatPhoto() {
    return deleteChatPhoto;
  }

  public void setDeleteChatPhoto(boolean deleteChatPhoto) {
    this.deleteChatPhoto = deleteChatPhoto;
  }

  public boolean isGroupChatCreated() {
    return groupChatCreated;
  }

  public void setGroupChatCreated(boolean groupChatCreated) {
    this.groupChatCreated = groupChatCreated;
  }

  @Override
  public String toString() {
    return new Gson().toJson(this);
  }

  public MessageType getType() {
    if (type == null)
      determineType();
    return type;
  }

  private void determineType() {
    if (text != null) {
      type = MessageType.TEXT;
    } else if (audio != null) {
      type = MessageType.AUDIO;
    } else if (document != null) {
      type = MessageType.DOCUMENT;
    } else if (photo != null) {
      type = MessageType.PHOTO;
    } else if (sticker != null) {
      type = MessageType.STICKER;
    } else if (video != null) {
      type = MessageType.VIDEO;
    } else if (voice != null) {
      type = MessageType.VOICE;
    } else if (contact != null) {
      type = MessageType.CONTACT;
    } else if (location != null) {
      type = MessageType.LOCATION;
    } else if (newChatParticipant != null) {
      type = MessageType.NEW_CHAT_PARTICIPANT;
    } else if (leftChatParticipant != null) {
      type = MessageType.LEFT_CHAT_PARTICIPANT;
    } else if (newChatTitle != null) {
      type = MessageType.NEW_CHAT_TITLE;
    } else if (newChatPhoto != null) {
      type = MessageType.NEW_CHAT_PHOTO;
    } else if (deleteChatPhoto) {
      type = MessageType.DELETE_CHAT_PHOTO;
    } else if (groupChatCreated) {
      type = MessageType.GROUP_CHAT_CREATED;
    } else {
      type = MessageType.UNKNOWN;
    }
  }

  public enum MessageType {
    TEXT, AUDIO, DOCUMENT, PHOTO, STICKER, VIDEO, VOICE, CONTACT, LOCATION, NEW_CHAT_PARTICIPANT, LEFT_CHAT_PARTICIPANT, NEW_CHAT_TITLE, NEW_CHAT_PHOTO, DELETE_CHAT_PHOTO, GROUP_CHAT_CREATED, UNKNOWN
  }
}
