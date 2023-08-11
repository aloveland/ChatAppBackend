package results;

public class GetMostRecentMessageNumResult {

    private String convoId;
    private int mostRecent;

    public GetMostRecentMessageNumResult() {
    }

    public GetMostRecentMessageNumResult(String convoId, int mostRecent) {
        this.convoId = convoId;
        this.mostRecent = mostRecent;
    }

    public String getConvoId() {
        return convoId;
    }

    public void setConvoId(String convoId) {
        this.convoId = convoId;
    }

    public int getMostRecent() {
        return mostRecent;
    }

    public void setMostRecent(int mostRecent) {
        this.mostRecent = mostRecent;
    }

    @Override
    public String toString() {
        return "GetMostRecentMessageNumResult{" +
                "convoId='" + convoId + '\'' +
                ", mostRecent=" + mostRecent +
                '}';
    }
}
