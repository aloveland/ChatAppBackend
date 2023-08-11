package requests;

public class CreateConversationRequest {
    private String recipientOne;
    private String recipientTwo;

    public CreateConversationRequest() {
    }

    public CreateConversationRequest(String recipientOne, String recipientTwo) {
        this.recipientOne = recipientOne;
        this.recipientTwo = recipientTwo;
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

    @Override
    public String toString() {
        return "CreateConversationRequest{" +
                "recipientOne='" + recipientOne + '\'' +
                ", recipientTwo='" + recipientTwo + '\'' +
                '}';
    }
}
