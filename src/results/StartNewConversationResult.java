package results;

import dynamoDB.Objects.LoadConvo;

public class StartNewConversationResult {

    private String email;
    private String convoNum;
    private String conversationId;
    private String recipient;

    public StartNewConversationResult() {
    }

    public StartNewConversationResult(String email, String convoNum, String conversationId, String recipient) {
        this.email = email;
        this.convoNum = convoNum;
        this.conversationId = conversationId;
        this.recipient = recipient;
    }

    public StartNewConversationResult(Builder builder) {
        this.email = builder.email;
        this.convoNum = builder.convoNum;
        this.conversationId = builder.conversationId;
        this.recipient = builder.recipient;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConvoNum() {
        return convoNum;
    }

    public void setConvoNum(String convoNum) {
        this.convoNum = convoNum;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public static final class Builder {
        private String email;
        private String convoNum;
        private String conversationId;
        private String recipient;

        public Builder() {
        }

        public static Builder newInstance() {
            return new Builder();
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withConvoNum(String convoNum) {
            this.convoNum = convoNum;
            return this;
        }

        public Builder withConversationId(String conversationId) {
            this.conversationId = conversationId;
            return this;
        }

        public Builder withRecipient(String recipient) {
            this.recipient = recipient;
            return this;
        }
        public Builder withLoadConvo(LoadConvo loadConvo) {
            this.email = loadConvo.getEmail();
            this.convoNum = loadConvo.getconvoNum();
            this.conversationId = loadConvo.getconversationId();
            this.recipient = loadConvo.getRecipient();
            return this;
        }
        public StartNewConversationResult build() {
            return new StartNewConversationResult(this);
        }
    }

    @Override
    public String toString() {
        return "StartNewConversationResult{" +
                "email='" + email + '\'' +
                ", convoNum='" + convoNum + '\'' +
                ", conversationId='" + conversationId + '\'' +
                ", recipient='" + recipient + '\'' +
                '}';
    }
}
