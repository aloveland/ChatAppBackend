package Activity;

//import alec.financetracker.converters.ExpenditureConverter;
//import dynamodb.ExpendituresDAO;
//import alec.financetracker.dynamodb.objects.Expenditure;
import com.amazonaws.services.dynamodbv2.model.Get;
import dynamoDB.Objects.ConversationsDao;
import requests.GetConversationsRequest;
//import requests.GetConversationsResult;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import results.GetConversationsResults;

import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class GetConversationsActivity implements RequestHandler<GetConversationsRequest, GetConversationsResults> {
    private final ConversationsDao conversationsDao;
    private static Logger log = null;

    public GetConversationsActivity(ConversationsDao conversationsDAO) {
        log = Logger.getLogger(GetConversationsActivity.class.getName());
        Regions region = Regions.US_EAST_1;
        AmazonDynamoDB client = (AmazonDynamoDB) ((AmazonDynamoDBClientBuilder) AmazonDynamoDBClientBuilder.standard()
                .withCredentials(DefaultAWSCredentialsProviderChain.getInstance()))
                .withRegion(region)
                .build();
        DynamoDBMapper mapper = new DynamoDBMapper(client);
        this.conversationsDao = new ConversationsDao(mapper);
    }

    public GetConversationsResults handleRequest(GetConversationsRequest getConversationsRequest, Context context) {
        String email = getConversationsRequest.getEmail();
        List<String> conversationsIdentifications = conversationsDao.loadConversations(email);
        GetConversationsResults results = GetConversationsResults.builder().withConvoIds(conversationsIdentifications).build();
        return results;
    }
}