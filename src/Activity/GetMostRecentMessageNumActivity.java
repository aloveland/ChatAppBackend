package Activity;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.s3.internal.eventstreaming.Message;
import dynamoDB.Objects.MessagesDao;
import requests.AddMessageToConversationRequest;
import requests.GetMostRecentMessageNumRequest;
import results.AddMessageToConversationResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import results.GetMostRecentMessageNumResult;

import java.util.logging.Logger;

public class GetMostRecentMessageNumActivity implements RequestHandler<GetMostRecentMessageNumRequest, GetMostRecentMessageNumResult> {
    private final MessagesDao messagesDao;
    private static Logger log = null;

    public GetMostRecentMessageNumActivity(MessagesDao messagesDao) {
        log = Logger.getLogger(GetMostRecentMessageNumActivity.class.getName());
        Regions region = Regions.US_EAST_1;
        AmazonDynamoDB client = (AmazonDynamoDB) ((AmazonDynamoDBClientBuilder) AmazonDynamoDBClientBuilder.standard()
                .withCredentials(DefaultAWSCredentialsProviderChain.getInstance()))
                .withRegion(region)
                .build();
        DynamoDBMapper mapper = new DynamoDBMapper(client);
        this.messagesDao = new MessagesDao(mapper);
    }

    public GetMostRecentMessageNumResult handleRequest(GetMostRecentMessageNumRequest getMostRecentMessageNumRequest, Context context) {
        // Your implementation logic goes here
        String convoId = getMostRecentMessageNumRequest.getConvoId();

        // Example: Get the most recent message number for the conversation
        int mostRecent = messagesDao.LoadMostRecentMessage(convoId);

        // Example: Return the result
        GetMostRecentMessageNumResult result = new GetMostRecentMessageNumResult(convoId, mostRecent);
        return result;
    }
}
