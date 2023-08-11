package lambda;

import Activity.GetMostRecentMessageNumActivity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import dynamoDB.Objects.ConversationsDao;
import dynamoDB.Objects.MessagesDao;
import requests.GetMostRecentMessageNumRequest;
import results.GetMostRecentMessageNumResult;

import java.util.logging.Logger;

public class GetMostRecentMessageNumProvider implements RequestHandler<GetMostRecentMessageNumRequest, GetMostRecentMessageNumResult> {
    private static Logger log = null;
    private MessagesDao messagesDao;

    public GetMostRecentMessageNumProvider() {
        log = Logger.getLogger(GetMostRecentMessageNumProvider.class.getName());
    }

    @Override
    public GetMostRecentMessageNumResult handleRequest(final GetMostRecentMessageNumRequest getMostRecentMessageNumRequest, Context context) {
        log.info("Received GetMostRecentMessageNumRequest: " + getMostRecentMessageNumRequest.toString());
        return getMostRecentMessageNumActivityObject().handleRequest(getMostRecentMessageNumRequest, context);
    }

    private GetMostRecentMessageNumActivity getMostRecentMessageNumActivityObject() {
        GetMostRecentMessageNumActivity getMostRecentMessageNumActivity = new GetMostRecentMessageNumActivity(messagesDao);
        return getMostRecentMessageNumActivity;
    }
}
