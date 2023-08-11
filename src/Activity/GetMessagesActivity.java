package Activity;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dynamoDB.Objects.ConversationsDao;
import requests.GetConversationsRequest;
import requests.GetMessagesRequest;
import results.GetConversationsResults;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import results.GetMessagesResult;

import java.util.List;
import java.util.logging.Logger;

public class GetMessagesActivity implements RequestHandler<GetMessagesRequest, GetMessagesResult> {
    private final ConversationsDao conversationsDao;
    private static Logger log = null;

    public GetMessagesActivity(ConversationsDao conversationsDao) {
        log = Logger.getLogger(GetMessagesActivity.class.getName());
        Regions region = Regions.US_EAST_1;
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withRegion(region)
                .build();
        DynamoDBMapper mapper = new DynamoDBMapper(client);
        this.conversationsDao = new ConversationsDao(mapper);
    }

    public GetMessagesResult handleRequest(GetMessagesRequest getMessagesRequest, Context context) {
       // String convoId = getMessagesRequest.getConvoId();
        //List<String> conversationsIdentifications = conversationsDao.loadConversations();
        //GetMessagesResult result = GetMessagesResult.builder()
                //.withConvoIds(conversationsIdentifications)
                //.build();
        //return result;
        return null;
    }
}
