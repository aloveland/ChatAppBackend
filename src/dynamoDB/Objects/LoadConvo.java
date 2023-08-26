package dynamoDB.Objects;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

import java.util.List;
@DynamoDBTable(tableName = "UserConversations")
public class LoadConvo {
    private String email;
    private String convoNum;
    private String conversationId;
    private String recipient;

    @DynamoDBHashKey(attributeName = "email")
    public String getEmail(){
        return email;
    }

    @DynamoDBRangeKey(attributeName = "convoNum")
    public String getconvoNum(){return convoNum;}

    @DynamoDBAttribute(attributeName = "conversationId")
    public String getconversationId(){
        return conversationId;
    }

    @DynamoDBAttribute(attributeName = "recipient")
    public String getRecipient(){
        return recipient;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public void setconvoNum(String convoNum){
        this.convoNum = convoNum;
    }
    public void setconversationId(String conversationId){
        this.conversationId = conversationId;
    }
    public void setRecipient(String recipient){
        this.recipient = recipient;
    }

    @Override
    public String toString() {
        return "LoadConvo{" +
                "email='" + email + '\'' +
                ", convoNum='" + convoNum + '\'' +
                ", conversationId='" + conversationId + '\'' +
                ", recipient='" + recipient + '\'' +
                '}';
    }


}
