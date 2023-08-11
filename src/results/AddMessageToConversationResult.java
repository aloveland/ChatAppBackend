package results;

public class AddMessageToConversationResult {

    private String convoId;
    private String sender;
    private String message;

    public AddMessageToConversationResult() {
    }

    public AddMessageToConversationResult(String convoId, String sender, String message) {
        this.convoId = convoId;
        this.sender = sender;
        this.message = message;
    }

    public String getConvoId() {
        return convoId;
    }

    public void setConvoId(String convoId) {
        this.convoId = convoId;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
