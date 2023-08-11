package Activity;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dynamoDB.Objects.ConversationsDao;
import dynamoDB.Objects.MessageContent;
import dynamoDB.Objects.MessagesDao;
import requests.LoadConversationRequest;
import results.LoadConversationResult;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class LoadConversationActivity implements RequestHandler<LoadConversationRequest, LoadConversationResult> {
    private final MessagesDao messagesDao;
    private static Logger log = null;

    public LoadConversationActivity(MessagesDao messagesDao) {
        log = Logger.getLogger(LoadConversationActivity.class.getName());
        Regions region = Regions.US_EAST_1;
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withRegion(region)
                .build();
        DynamoDBMapper mapper = new DynamoDBMapper(client);
        this.messagesDao = new MessagesDao(mapper);
    }

    public LoadConversationResult handleRequest(LoadConversationRequest loadConversationRequest, Context context) {
        log.info("inside activity this is the request " + loadConversationRequest.toString());
        String convoId = loadConversationRequest.getConvoId();
        List<MessageContent> messages = messagesDao.loadMessages(convoId, loadConversationRequest.getScrollNum());

        LoadConversationResult result = new LoadConversationResult.Builder()
                .withConvoId(convoId)
                .withScrollNum(loadConversationRequest.getScrollNum())
                .withMessages(messages)
                .build();

        return result;
    }
}
