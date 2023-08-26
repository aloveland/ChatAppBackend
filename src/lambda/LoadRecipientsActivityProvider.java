package lambda;

import Activity.LoadRecipientsActivity;  // Assuming you've renamed the activity class
import Activity.LoadRecipientsActivity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import dynamoDB.Objects.ConversationsDao;
import dynamoDB.Objects.MessagesDao;
import requests.GetRecipientsRequest;    // Assuming this is the new request object
import requests.LoadRecipientsRequest;
import results.GetRecipientsResults;     // Assuming this is the new result object
import results.LoadRecipientsResult;

import java.util.logging.Logger;

public class LoadRecipientsActivityProvider implements RequestHandler<LoadRecipientsRequest, LoadRecipientsResult> {
    private static Logger log = null;
    private ConversationsDao conversationsDao;

    public LoadRecipientsActivityProvider() {
        log = Logger.getLogger(LoadRecipientsActivityProvider.class.getName());
    }

    @Override
    public LoadRecipientsResult handleRequest(final LoadRecipientsRequest loadRecipientsRequest, Context context) {
        log.info("Received GetRecipientsRequest: " + loadRecipientsRequest.toString());
        return loadRecipientActivityObject().handleRequest(loadRecipientsRequest, context);
    }

    private LoadRecipientsActivity loadRecipientActivityObject() {
        LoadRecipientsActivity loadRecipientsActivity = new LoadRecipientsActivity(conversationsDao);
        return loadRecipientsActivity;
    }
}
