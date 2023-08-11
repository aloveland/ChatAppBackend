package Activity;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dynamoDB.Objects.Conversations;
import dynamoDB.Objects.ConversationsDao;
import dynamoDB.Objects.MessagesDao;
import requests.AddMessageToConversationRequest;
import requests.CreateConversationRequest;
import requests.GetConversationsRequest;
import results.AddMessageToConversationResult;
import results.CreateConversationResult;
import results.GetConversationsResults;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import utils.GenerateIds;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class CreateConversationActivity implements RequestHandler<CreateConversationRequest, CreateConversationResult> {
    private final ConversationsDao conversationsDao;
    private static Logger log = null;

    public CreateConversationActivity(ConversationsDao conversationsDao) {
        log = Logger.getLogger(GetConversationsActivity.class.getName());
        Regions region = Regions.US_EAST_1;
        AmazonDynamoDB client = (AmazonDynamoDB) ((AmazonDynamoDBClientBuilder) AmazonDynamoDBClientBuilder.standard()
                .withCredentials(DefaultAWSCredentialsProviderChain.getInstance()))
                .withRegion(region)
                .build();
        DynamoDBMapper mapper = new DynamoDBMapper(client);
        this.conversationsDao = new ConversationsDao(mapper);
    }

    public CreateConversationResult handleRequest(CreateConversationRequest createConversationRequest, Context context) {
        // Your implementation logic goes here
        String recipientOne = createConversationRequest.getRecipientOne();
        String recipientTwo = createConversationRequest.getRecipientTwo();


        List<String> oneList = new ArrayList<>();
        List<String> twoList = new ArrayList<>();
        String newConvo = GenerateIds.GenerateMessageId();
        oneList = conversationsDao.loadConversations(recipientOne);
        twoList = conversationsDao.loadConversations(recipientTwo);
        oneList.add(newConvo);
        twoList.add(newConvo);

        // Example: Save the message to conversation
        Conversations convo = new Conversations();
        convo.setConvoIds(oneList);
        convo.setEmail(recipientOne);
        conversationsDao.saveConversations(convo);
        convo.setConvoIds(twoList);
        convo.setEmail(recipientTwo);
        conversationsDao.saveConversations(convo);

        // Example: Return the result
        CreateConversationResult results = new CreateConversationResult(recipientOne,recipientTwo, newConvo);
        return results;
    }
}
