package dynamoDB.Objects;


import dynamoDB.Objects.Conversations;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;



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
}
