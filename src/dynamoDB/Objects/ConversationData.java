package dynamoDB.Objects;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

@DynamoDBTable(tableName = "ConversationData")
public class ConversationData {

    private String convoId;
    private int mostRecent;

    @DynamoDBHashKey(attributeName = "convoId")
    public String getConvoId() {
        return convoId;
    }

    public void setConvoId(String convoId) {
        this.convoId = convoId;
    }

    @DynamoDBAttribute(attributeName = "mostRecent")
    public int getMostRecent() {
        return mostRecent;
    }

    public void setMostRecent(int mostRecent) {
        this.mostRecent = mostRecent;
    }
}

