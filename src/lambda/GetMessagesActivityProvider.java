package lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import requests.GetMessagesRequest;
import results.GetMessagesResult;
import dynamoDB.Objects.ConversationsDao;
import Activity.GetMessagesActivity;

import java.util.logging.Logger;

public class GetMessagesActivityProvider implements RequestHandler<GetMessagesRequest, GetMessagesResult> {
    private static Logger log = null;
    private ConversationsDao conversationsDao;

    public GetMessagesActivityProvider() {
        log = Logger.getLogger(GetMessagesActivityProvider.class.getName());
    }

    @Override
    public GetMessagesResult handleRequest(final GetMessagesRequest getMessagesRequest, Context context) {
        log.info("Received GetMessagesRequest: " + getMessagesRequest.toString());
        return getGetMessagesActivityObject().handleRequest(getMessagesRequest, context);
    }

    private GetMessagesActivity getGetMessagesActivityObject() {
        GetMessagesActivity getMessagesActivity = new GetMessagesActivity(conversationsDao);
        return getMessagesActivity;
    }
}
