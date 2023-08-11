package Activity;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dynamoDB.Objects.ConversationsDao;
import dynamoDB.Objects.MessagesDao;
import requests.GetConversationsRequest;
import requests.GetMessagesRequest;
import requests.GetRecipientsRequest;
import results.GetConversationsResults;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import results.GetMessagesResult;
import results.GetRecipientsResults;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class GetRecipientsActivity implements RequestHandler<GetRecipientsRequest, GetRecipientsResults> {
    private final MessagesDao messagesDao;
    private static Logger log = null;

    public GetRecipientsActivity(MessagesDao messagesDao) {
        log = Logger.getLogger(GetRecipientsActivity.class.getName());
        Regions region = Regions.US_EAST_1;
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withRegion(region)
                .build();
        DynamoDBMapper mapper = new DynamoDBMapper(client);
        this.messagesDao = new MessagesDao(mapper);
    }

    public GetRecipientsResults handleRequest(GetRecipientsRequest getRecipientsRequest, Context context) {
        log.info("inside activity this is the request " + getRecipientsRequest.toString());
        List<String> convoIds = getRecipientsRequest.getConvoIds();
        List<String>recipients = new ArrayList<>();
        for (String id : convoIds){
            String recipient = messagesDao.loadRecipient(id, getRecipientsRequest.getSender());
            recipients.add(recipient);
        }
        GetRecipientsResults result = new GetRecipientsResults();
        result.setRecipients(recipients);

        return result;
    }
}
