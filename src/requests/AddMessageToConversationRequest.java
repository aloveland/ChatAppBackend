package requests;

public class AddMessageToConversationRequest {

    private String convoId;
    private String sender;
    private String receiver;
    private String message;

    public AddMessageToConversationRequest() {
    }

    public AddMessageToConversationRequest(String convoId, String sender, String receiver, String message) {
        this.convoId = convoId;
        this.sender = sender;
        this.receiver = receiver;
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

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "AddMessageToConversationRequest{" +
                "convoId='" + convoId + '\'' +
                ", sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
