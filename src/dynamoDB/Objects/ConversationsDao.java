package dynamoDB.Objects;


import dynamoDB.Objects.Conversations;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import utils.GenerateIds;


import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public class ConversationsDao {
    public static final String CATEGORY_INDEX = "category-index";
    private final DynamoDBMapper dynamoDBMapper;

    public ConversationsDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }


    public Conversations saveConversations(Conversations conversations) {
        this.dynamoDBMapper.save(conversations);
        return conversations;
    }

    public List<String> loadConversations(String email) {
        Conversations conversations = this.dynamoDBMapper.load(Conversations.class, email);
        List<String> convoIds = conversations.getConvoIds();
        return convoIds;
    }

    public List<LoadConvo> getAllUserConvos(String email){
        LoadConvo loadConvoKey = new LoadConvo();
        loadConvoKey.setEmail(email);

        DynamoDBQueryExpression<LoadConvo> queryExpression = new DynamoDBQueryExpression<LoadConvo>()
                .withHashKeyValues(loadConvoKey);
        List<LoadConvo> result = dynamoDBMapper.query(LoadConvo.class, queryExpression);
        return result;
    }
    public LoadConvo StartNewConversation(String email, String recipient){
        String convoNum = GenerateIds.GenerateMessageId();
        String conversationId = GenerateIds.GenerateMessageId();
        LoadConvo newConvo = new LoadConvo();
        newConvo.setEmail(email);
        newConvo.setconvoNum(convoNum);
        newConvo.setconversationId(conversationId);
        newConvo.setRecipient(recipient);
        dynamoDBMapper.save(newConvo);
        newConvo = new LoadConvo();
        newConvo.setEmail(recipient);
        newConvo.setconvoNum(convoNum);
        newConvo.setconversationId(conversationId);
        newConvo.setRecipient(email);
        dynamoDBMapper.save(newConvo);
        return newConvo;
    }
}
