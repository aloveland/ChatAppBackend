package results;

public class CreateConversationResult {
    private String recipientOne;
    private String recipientTwo;
    private String convoId;

    public CreateConversationResult() {
    }

    public CreateConversationResult(String recipientOne, String recipientTwo, String convoId) {
        this.recipientOne = recipientOne;
        this.recipientTwo = recipientTwo;
        this.convoId = convoId;
    }

    public String getRecipientOne() {
        return recipientOne;
    }

    public void setRecipientOne(String recipientOne) {
        this.recipientOne = recipientOne;
    }

    public String getRecipientTwo() {
        return recipientTwo;
    }

    public void setRecipientTwo(String recipientTwo) {
        this.recipientTwo = recipientTwo;
    }

    public String getConvoId() {
        return convoId;
    }

    public void setConvoId(String convoId) {
        this.convoId = convoId;
    }

    @Override
    public String toString() {
        return "CreateConversationResult{" +
                "recipientOne='" + recipientOne + '\'' +
                ", recipientTwo='" + recipientTwo + '\'' +
                ", convoId='" + convoId + '\'' +
                '}';
    }
}
