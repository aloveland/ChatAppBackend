package lambda;

import Activity.LoadConversationActivity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import dynamoDB.Objects.MessagesDao;
import requests.LoadConversationRequest;
import results.LoadConversationResult;
import dynamoDB.Objects.ConversationsDao;
import Activity.GetMessagesActivity;
import results.GetRecipientsResults;

import java.util.logging.Logger;

public class LoadConversationActivityProvider implements RequestHandler<LoadConversationRequest, LoadConversationResult> {
    private static Logger log = null;
    private MessagesDao messagesDao;

    public LoadConversationActivityProvider() {
        log = Logger.getLogger(LoadConversationActivityProvider.class.getName());
    }

    @Override
    public LoadConversationResult handleRequest(final LoadConversationRequest loadConversationRequest, Context context) {
        log.info("Received LoadConversationRequest: " + loadConversationRequest.toString());
        return loadConversationActivityObject().handleRequest(loadConversationRequest, context);
    }

    private LoadConversationActivity loadConversationActivityObject() {
        LoadConversationActivity loadConversationActivity = new LoadConversationActivity(messagesDao);
        return loadConversationActivity;
    }
}
