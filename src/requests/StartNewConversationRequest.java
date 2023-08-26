package requests;

public class StartNewConversationRequest {

    private String email;
    private String recipient;

    public StartNewConversationRequest() {
    }

    public StartNewConversationRequest(String email, String recipient) {
        this.email = email;
        this.recipient = recipient;
    }

    public StartNewConversationRequest(Builder builder) {
        this.email = builder.email;
        this.recipient = builder.recipient;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public static final class Builder {
        private String email;
        private String recipient;

        private Builder() {
        }

        public static Builder newInstance() {
            return new Builder();
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withRecipient(String recipient) {
            this.recipient = recipient;
            return this;
        }

        public StartNewConversationRequest build() {
            return new StartNewConversationRequest(this);
        }
    }

    @Override
    public String toString() {
        return "StartNewConversationRequest{" +
                "email='" + email + '\'' +
                ", recipient='" + recipient + '\'' +
                '}';
    }
}
