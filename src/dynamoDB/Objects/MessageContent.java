package dynamoDB.Objects;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

@DynamoDBTable(tableName = "MessageContent")
public class MessageContent {

    private String convoId;
    private String MessageId;
    private String sender;
    private String receiver;
    private String message;
    private String date;
    private int messageNum;

    @DynamoDBHashKey(attributeName = "convoId")
    public String getConvoId() {
        return convoId;
    }

    public void setConvoId(String convoId) {
        this.convoId = convoId;
    }

    @DynamoDBRangeKey(attributeName = "MessageId")
    public String getMessageId() {
        return MessageId;
    }

    public void setMessageId(String messageId) {
        this.MessageId = messageId;
    }
    @DynamoDBAttribute(attributeName = "sender")
    public String getSender(){
        return sender;
    }
    public void setSender(String sender){
        this.sender = sender;
    }
    @DynamoDBAttribute(attributeName = "receiver")
    public String getReceiver(){
        return receiver;
    }
    public void setReceiver(String receiver){
        this.receiver = receiver;
    }
    @DynamoDBAttribute(attributeName = "date")
    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date = date;
    }
    @DynamoDBAttribute(attributeName = "message")
    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message = message;
    }
    @DynamoDBIndexHashKey(globalSecondaryIndexName = "sortMessages", attributeName = "messageNum")
    public int getMessageNum() {
        return messageNum;
    }

    public void setMessageNum(int messageNum) {
        this.messageNum = messageNum;
    }

    // Other attributes, getters, and setters...

    @Override
    public String toString() {
        return "MessageContent{" +
                "convoId='" + convoId + '\'' +
                ", messageId='" + MessageId + '\'' +
                ", sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                ", message='" + message + '\'' +
                ", date='" + date + '\'' +
                ", messageNum=" + messageNum +
                '}';
    }
}
