package lambda;

import Activity.GetRecipientsActivity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import dynamoDB.Objects.MessagesDao;
import requests.GetMessagesRequest;
import requests.GetRecipientsRequest;
import results.GetMessagesResult;
import dynamoDB.Objects.ConversationsDao;
import Activity.GetMessagesActivity;
import results.GetRecipientsResults;

import java.util.logging.Logger;

public class GetRecipientsActivityProvider implements RequestHandler<GetRecipientsRequest, GetRecipientsResults> {
    private static Logger log = null;
    private MessagesDao messagesDao;

    public GetRecipientsActivityProvider() {
        log = Logger.getLogger(GetRecipientsActivityProvider.class.getName());
    }

    @Override
    public GetRecipientsResults handleRequest(final GetRecipientsRequest getRecipientsRequest, Context context) {
        log.info("Received GetMessagesRequest: " + getRecipientsRequest.toString());
        return getRecipientsActivityObject().handleRequest(getRecipientsRequest, context);
    }

    private GetRecipientsActivity getRecipientsActivityObject() {
        GetRecipientsActivity getRecipientsActivity = new GetRecipientsActivity(messagesDao);
        return getRecipientsActivity;
    }
}
