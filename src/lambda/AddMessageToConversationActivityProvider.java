package lambda;

import Activity.AddMessageToConversationActivity;
import dynamoDB.Objects.MessageContent;
import dynamoDB.Objects.MessagesDao;
import requests.AddMessageToConversationRequest;
import results.AddMessageToConversationResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import dynamoDB.Objects.ConversationsDao;
import requests.AddMessageToConversationRequest;
import requests.GetConversationsRequest;
import results.AddMessageToConversationResult;
import results.GetConversationsResults;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class AddMessageToConversationActivityProvider implements RequestHandler<AddMessageToConversationRequest, AddMessageToConversationResult>{
    private static Logger log = null;
    private MessagesDao messagesDao;

    public AddMessageToConversationActivityProvider(){
        log = Logger.getLogger(AddMessageToConversationActivityProvider.class.getName());
    }

    @Override
    public AddMessageToConversationResult handleRequest(final AddMessageToConversationRequest addMessageToConversationRequest, Context context){
        log.info("Received AddMessageToConversationRequest: " + addMessageToConversationRequest.toString());
        return getAddMessageToConversationActivityObject().handleRequest(addMessageToConversationRequest, context);
    }

    private AddMessageToConversationActivity getAddMessageToConversationActivityObject(){
        AddMessageToConversationActivity addMessageToConversationActivity = new AddMessageToConversationActivity(messagesDao);
        return addMessageToConversationActivity;
    }
}
