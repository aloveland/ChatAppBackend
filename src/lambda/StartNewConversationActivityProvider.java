package lambda;

import Activity.StartNewConversationActivity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import dynamoDB.Objects.ConversationsDao;
import requests.StartNewConversationRequest;
import results.StartNewConversationResult;

import java.util.logging.Logger;

public class StartNewConversationActivityProvider implements RequestHandler<StartNewConversationRequest, StartNewConversationResult> {
    private static Logger log = null;
    private ConversationsDao conversationsDao;

    public StartNewConversationActivityProvider() {
        log = Logger.getLogger(StartNewConversationActivityProvider.class.getName());
    }

    @Override
    public StartNewConversationResult handleRequest(final StartNewConversationRequest startNewConversationRequest, Context context) {
        log.info("Received StartNewConversationRequest: " + startNewConversationRequest.toString());
        return startNewConversationActivityObject().handleRequest(startNewConversationRequest, context);
    }

    private StartNewConversationActivity startNewConversationActivityObject() {
        StartNewConversationActivity startNewConversationActivity = new StartNewConversationActivity(conversationsDao);
        return startNewConversationActivity;
    }
}
