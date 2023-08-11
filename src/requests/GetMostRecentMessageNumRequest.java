package requests;

import java.util.List;

public class GetMostRecentMessageNumRequest {

    private String convoId;

    public GetMostRecentMessageNumRequest() {
    }

    public GetMostRecentMessageNumRequest(String convoId) {
        this.convoId = convoId;
    }

    public String getConvoId() {
        return convoId;
    }

    public void setConvoId(String convoId) {
        this.convoId = convoId;
    }

    @Override
    public String toString() {
        return "GetMostRecentMessageNumRequest{" +
                "convoId='" + convoId + '\'' +
                '}';
    }
}
