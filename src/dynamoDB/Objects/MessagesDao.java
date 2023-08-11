package dynamoDB.Objects;

import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.PutItemSpec;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.amazonaws.services.dynamodbv2.model.*;
import com.amazonaws.services.s3.internal.eventstreaming.Message;
import dynamoDB.Objects.Conversations;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import utils.GenerateIds;


import java.util.*;

public class MessagesDao {
    public static final String CATEGORY_INDEX = "category-index";
    private final DynamoDBMapper dynamoDBMapper;

    public MessagesDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }


    public Message saveConversations(Message message) {
        this.dynamoDBMapper.save(message);
        return message;
    }
    public int LoadMostRecentMessage(String convoId) {
        ConversationData data = dynamoDBMapper.load(ConversationData.class, convoId);
        if(data == null){
            return -1;
        }else{
            return data.getMostRecent();
        }
    }
    public List<MessageContent> loadMessages(String convoId, int scrollNum) {
        int mostRecent = LoadMostRecentMessage(convoId);
        int start = mostRecent - (scrollNum * 3);
        int end = mostRecent - ((scrollNum - 1) * 3);
        List<MessageContent> result = new ArrayList<>();
        if (((scrollNum - 1) * 3) < 0) {
            return result;
        }
        if (start < 0) {
            start = 1;
        }
        Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
        eav.put(":v1", new AttributeValue().withS(convoId));
        eav.put(":v2", new AttributeValue().withN(Integer.toString(start)));
        eav.put(":v3", new AttributeValue().withN(Integer.toString(end)));

        DynamoDBQueryExpression<MessageContent> queryExpression = new DynamoDBQueryExpression<MessageContent>()
                .withIndexName("sortMessages")
                .withConsistentRead(false)
                .withKeyConditionExpression("convoId = :v1 and messageNum between :v2 and :v3")
                .withExpressionAttributeValues(eav)
                .withProjectionExpression("convoId, messageId, sender, receiver, message, #dt, messageNum")
                .withExpressionAttributeNames(Collections.singletonMap("#dt", "date"));

        return dynamoDBMapper.query(MessageContent.class, queryExpression);
    }

    public String loadRecipient(String convoId, String sender){
        AttributeValue value = new AttributeValue();
        value.setS(convoId);
        Map<String, AttributeValue> attributeValues = new HashMap<>();
        attributeValues.put(":pkValue", new AttributeValue().withS(convoId));

        // Create a query expression
        String queryExpression = "convoId = :pkValue";

        // Execute the query using DynamoDBMapper
        List<MessageContent> messages = dynamoDBMapper.query(MessageContent.class, new DynamoDBQueryExpression<MessageContent>()
                .withKeyConditionExpression(queryExpression)
                .withExpressionAttributeValues(attributeValues));
        System.out.println("THIS IS RETURNED: " + messages.get(0).toString());
        String recipientOne = messages.get(0).getSender();
        String recipientTwo = messages.get(0).getReceiver();
        System.out.print("this is recipients returned  " + recipientOne + " recipientTwo " + recipientTwo + " size " + messages.size() + " object printer " + messages.get(0).toString());
        if (!(sender.equals(recipientOne))){
            return recipientOne;
        }else{
            return recipientTwo;
        }
    }
    public MessageContent addMessage(String convoId, String sender, String reciever,String message){
        MessageContent newMsg = new MessageContent();
        newMsg.setConvoId(convoId);
        newMsg.setSender(sender);
        newMsg.setMessage(message);
        newMsg.setReceiver(reciever);
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        newMsg.setDate(formattedDateTime);
        int recent = LoadMostRecentMessage(convoId);
        System.out.println("recent is: " + recent);
        ConversationData data = new ConversationData();
        if(recent == -1){
            newMsg.setMessageNum(1);
            data.setMostRecent(1);
        }else{
            newMsg.setMessageNum(recent + 1);
            data.setMostRecent(recent + 1);
        }
        data.setConvoId(convoId);
        dynamoDBMapper.save(data);
        newMsg.setMessageId(GenerateIds.GenerateMessageId());
        System.out.println("right before save " + newMsg);

        dynamoDBMapper.save(newMsg);
        return newMsg;

    }
}
