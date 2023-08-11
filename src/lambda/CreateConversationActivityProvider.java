package lambda;

import Activity.AddMessageToConversationActivity;
import Activity.CreateConversationActivity;
import dynamoDB.Objects.MessageContent;
import dynamoDB.Objects.MessagesDao;
import requests.AddMessageToConversationRequest;
import requests.CreateConversationRequest;
import results.AddMessageToConversationResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import dynamoDB.Objects.ConversationsDao;
import requests.GetConversationsRequest;
import results.CreateConversationResult;
import results.GetConversationsResults;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class CreateConversationActivityProvider implements RequestHandler<CreateConversationRequest, CreateConversationResult> {
    private static Logger log = null;
    private ConversationsDao conversationsDao;

    public CreateConversationActivityProvider() {
        log = Logger.getLogger(CreateConversationActivityProvider.class.getName());
    }

    @Override
    public CreateConversationResult handleRequest(final CreateConversationRequest createConversationRequest, Context context) {
        log.info("Received AddMessageToConversationRequest: " + createConversationRequest.toString());
        return getAddMessageToConversationActivityObject().handleRequest(createConversationRequest, context);
    }

    private CreateConversationActivity getAddMessageToConversationActivityObject() {
        CreateConversationActivity createConversation = new CreateConversationActivity(conversationsDao);
        return createConversation;
    }
}
