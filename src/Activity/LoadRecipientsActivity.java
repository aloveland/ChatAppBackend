package Activity;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dynamoDB.Objects.ConversationsDao;
import dynamoDB.Objects.LoadConvo;
import dynamoDB.Objects.MessageContent;
import dynamoDB.Objects.MessagesDao;
import requests.LoadConversationRequest;
import requests.LoadRecipientsRequest;
import results.LoadConversationResult;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import results.LoadRecipientsResult;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class LoadRecipientsActivity implements RequestHandler<LoadRecipientsRequest, LoadRecipientsResult> {
    private final ConversationsDao conversationsDao;
    private static Logger log = null;

    public LoadRecipientsActivity(ConversationsDao conversationsDao) {
        log = Logger.getLogger(LoadRecipientsActivity.class.getName());
        Regions region = Regions.US_EAST_1;
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withRegion(region)
                .build();
        DynamoDBMapper mapper = new DynamoDBMapper(client);
        this.conversationsDao = new ConversationsDao(mapper);
    }

    public LoadRecipientsResult handleRequest(LoadRecipientsRequest loadRecipientsRequest, Context context) {
        log.info("inside activity this is the request " + loadRecipientsRequest.toString());
        String email = loadRecipientsRequest.getEmail();
        List<LoadConvo> recipients = conversationsDao.getAllUserConvos(email);

        LoadRecipientsResult result = new LoadRecipientsResult.Builder()
                .withRecipients(recipients)
                .build();

        return result;
    }
}
