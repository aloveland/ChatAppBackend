package results;

import requests.GetRecipientsRequest;

import java.util.List;

public class GetRecipientsResults {
    private List<String> recipients;

    public GetRecipientsResults(){

    }

    public List<String> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<String> recipients) {
        this.recipients = recipients;
    }
    public String toString(){
        return "Recipients " + recipients;
    }
}
