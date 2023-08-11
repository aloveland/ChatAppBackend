package requests;

import java.util.List;

public class GetRecipientsRequest {

    private List<String> convoIds;
    private String sender;

    public GetRecipientsRequest(){}

    public List<String> getConvoIds(){
        return convoIds;
    }
    public void setConvoIds(List<String> convoIds){
        this.convoIds = convoIds;
    }
    public String getSender(){
        return sender;
    }
    public void setSender(String sender){
        this.sender = sender;
    }
    public String toString(){
        return "convoIds: " + convoIds
                + " sender: " + sender;
    }
}
