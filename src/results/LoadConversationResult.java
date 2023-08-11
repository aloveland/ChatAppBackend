package results;

import dynamoDB.Objects.MessageContent;

import java.util.List;

public class LoadConversationResult {

    private String convoId;
    private int scrollNum;
    private List<MessageContent> messages;

    public LoadConversationResult() {
    }

    public LoadConversationResult(String convoId, int scrollNum) {
        this.convoId = convoId;
        this.scrollNum = scrollNum;
    }

    public LoadConversationResult(Builder builder) {
        this.convoId = builder.convoId;
        this.scrollNum = builder.scrollNum;
        this.messages = builder.messages;
    }

    public String getConvoId() {
        return convoId;
    }

    public void setConvoId(String convoId) {
        this.convoId = convoId;
    }

    public int getScrollNum() {
        return scrollNum;
    }

    public void setScrollNum(int scrollNum) {
        this.scrollNum = scrollNum;
    }

    public List<MessageContent> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageContent> messages) {
        this.messages = messages;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static final class Builder {
        private String convoId;
        private int scrollNum;
        private List<MessageContent> messages;

        public Builder() {
        }

        public static Builder newInstance() {
            return new Builder();
        }

        public Builder withConvoId(String convoId) {
            this.convoId = convoId;
            return this;
        }

        public Builder withScrollNum(int scrollNum) {
            this.scrollNum = scrollNum;
            return this;
        }

        public Builder withMessages(List<MessageContent> messages) {
            this.messages = messages;
            return this;
        }

        public LoadConversationResult build() {
            return new LoadConversationResult(this);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LoadConversationResult{")
                .append("convoId='").append(convoId).append('\'')
                .append(", scrollNum=").append(scrollNum)
                .append(", messages=[");

        for (MessageContent message : messages) {
            sb.append(message.toString()).append(", ");
        }

        if (!messages.isEmpty()) {
            sb.setLength(sb.length() - 2); // Remove the trailing comma and space
        }

        sb.append("]}");

        return sb.toString();
    }

}
