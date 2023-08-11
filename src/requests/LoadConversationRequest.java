package requests;

public class LoadConversationRequest {

    private String convoId;
    private int scrollNum;

    public LoadConversationRequest() {
    }

    public LoadConversationRequest(String convoId, int scrollNum) {
        this.convoId = convoId;
        this.scrollNum = scrollNum;
    }

    public LoadConversationRequest(Builder builder) {
        this.convoId = builder.convoId;
        this.scrollNum = builder.scrollNum;
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

    public static final class Builder {
        private String convoId;
        private int scrollNum;

        private Builder() {
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

        public LoadConversationRequest build() {
            return new LoadConversationRequest(this);
        }
    }

    @Override
    public String toString() {
        return "LoadConversationRequest{" +
                "convoId='" + convoId + '\'' +
                ", scrollNum=" + scrollNum +
                '}';
    }
}
