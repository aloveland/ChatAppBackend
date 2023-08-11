package lambda;

//import alec.financetracker.dynamodb.ExpendituresDAO;
import Activity.GetConversationsActivity;
import requests.GetConversationsRequest;
import results.GetConversationsResults;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import dynamoDB.Objects.ConversationsDao;
import requests.GetConversationsRequest;

import java.util.logging.LogManager;
import java.util.logging.Logger;


public class GetConversationsActivityProvider implements RequestHandler<GetConversationsRequest, GetConversationsResults>{
    private static Logger log = null;
    private ConversationsDao conversationsDao;

    public GetConversationsActivityProvider(){
        log = Logger.getLogger(GetConversationsActivityProvider.class.getName());
    }

    @Override
    public GetConversationsResults handleRequest(final GetConversationsRequest getConversationsRequest, Context context){
        log.info("Recived GetConversationsRequest{ " + getConversationsRequest.toString() + "}");
        return getGetConversationsActivityObject().handleRequest(getConversationsRequest, context);
    }
    private GetConversationsActivity getGetConversationsActivityObject(){
        GetConversationsActivity getConversationsActivity = new GetConversationsActivity(conversationsDao);
        return getConversationsActivity;
    }


}