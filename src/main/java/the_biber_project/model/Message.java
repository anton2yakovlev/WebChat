package the_biber_project.model;

public class Message {

    private MessageType type;
    private String content;
    private String sender;
    private String color;

    public enum MessageType {
        CHAT, JOIN, LEAVE
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getColor() { return color; }

    public void setColor(String color) {
        this.color = color;
    }

}