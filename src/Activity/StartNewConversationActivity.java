package Activity;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dynamoDB.Objects.ConversationsDao;
import dynamoDB.Objects.LoadConvo;
import dynamoDB.Objects.MessageContent;
import dynamoDB.Objects.MessagesDao;
import requests.StartNewConversationRequest;
import results.StartNewConversationResult;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class StartNewConversationActivity implements RequestHandler<StartNewConversationRequest, StartNewConversationResult> {
    private final ConversationsDao conversationsDao;
    private static Logger log = null;

    public StartNewConversationActivity(ConversationsDao conversationsDao) {
        log = Logger.getLogger(StartNewConversationActivity.class.getName());
        Regions region = Regions.US_EAST_1;
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withRegion(region)
                .build();
        DynamoDBMapper mapper = new DynamoDBMapper(client);
        this.conversationsDao = new ConversationsDao(mapper);
    }

    public StartNewConversationResult handleRequest(StartNewConversationRequest startNewConversationRequest, Context context) {
        log.info("inside activity this is the request " + startNewConversationRequest.toString());
        String email = startNewConversationRequest.getEmail();
        String recipient = startNewConversationRequest.getRecipient();
        LoadConvo newConvo = conversationsDao.StartNewConversation(email, recipient);

        StartNewConversationResult result = new StartNewConversationResult.Builder()
                .withLoadConvo(newConvo)
                .build();

        return result;
    }
}
