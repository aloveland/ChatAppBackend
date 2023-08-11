package dynamoDB.Objects;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

import java.util.List;

@DynamoDBTable(tableName = "Conversations")
public class Conversations {

    private String email;
    private List<String> convoIds;

    private String recipient;
    @DynamoDBHashKey(attributeName = "email")
    public String getEmail(){
        return email;
    }
    @DynamoDBAttribute(attributeName = "convoIds")
    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.L)
    public List<String> getConvoIds(){
        return convoIds;
    }
    @DynamoDBAttribute(attributeName = "recipient")
    public String getRecipient(){
        return recipient;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public void setRecipient(String recipient){
        this.recipient = recipient;
    }
    public void setConvoIds(List<String> convoIds){
        this.convoIds = convoIds;
    }
    public String toString(){
        return "email: " + email + " convoIds: " + convoIds;
    }
}

