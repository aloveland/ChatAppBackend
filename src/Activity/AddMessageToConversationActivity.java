package Activity;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dynamoDB.Objects.ConversationsDao;
import dynamoDB.Objects.MessagesDao;
import requests.AddMessageToConversationRequest;
import requests.GetConversationsRequest;
import results.AddMessageToConversationResult;
import results.GetConversationsResults;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class AddMessageToConversationActivity implements RequestHandler<AddMessageToConversationRequest, AddMessageToConversationResult> {
    private final MessagesDao messagesDao;
    private static Logger log = null;

    public AddMessageToConversationActivity(MessagesDao messagesDao) {
        log = Logger.getLogger(GetConversationsActivity.class.getName());
        Regions region = Regions.US_EAST_1;
        AmazonDynamoDB client = (AmazonDynamoDB) ((AmazonDynamoDBClientBuilder) AmazonDynamoDBClientBuilder.standard()
                .withCredentials(DefaultAWSCredentialsProviderChain.getInstance()))
                .withRegion(region)
                .build();
        DynamoDBMapper mapper = new DynamoDBMapper(client);
        this.messagesDao = new MessagesDao(mapper);
    }

    public AddMessageToConversationResult handleRequest(AddMessageToConversationRequest addMessageToConversationRequest, Context context) {
        // Your implementation logic goes here
        String convoId = addMessageToConversationRequest.getConvoId();
        String sender = addMessageToConversationRequest.getSender();
        String message = addMessageToConversationRequest.getMessage();
        String receiver = addMessageToConversationRequest.getReceiver();

        // Example: Save the message to conversation
        messagesDao.addMessage(convoId, sender, receiver,message);

        // Example: Return the result
        AddMessageToConversationResult results = new AddMessageToConversationResult(convoId, sender, message);
        return results;
    }
}
