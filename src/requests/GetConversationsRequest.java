package requests;

import java.util.List;

public class GetConversationsRequest {

    private String email;
    private List<String> convoIds;
    private String recipient;

    public GetConversationsRequest() {
    }

    public GetConversationsRequest(String email) {
        this.email = email;
    }

    public GetConversationsRequest(Builder builder) {
        this.email = builder.email;
        this.convoIds = builder.convoIds;
        this.recipient = builder.recipient;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getConvoIds() {
        return convoIds;
    }

    public void setConvoIds(List<String> convoIds) {
        this.convoIds = convoIds;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public static final class Builder {
        private String email;
        private List<String> convoIds;
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

        public Builder withConvoIds(List<String> convoIds) {
            this.convoIds = convoIds;
            return this;
        }

        public Builder withRecipient(String recipient) {
            this.recipient = recipient;
            return this;
        }

        public GetConversationsRequest build() {
            return new GetConversationsRequest(this);
        }
    }

    @Override
    public String toString() {
        return "GetConversationsRequest{" +
                "email='" + email + '\'' +
                ", convoIds=" + convoIds +
                ", recipient='" + recipient + '\'' +
                '}';
    }
}
