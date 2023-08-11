package results;


import org.joda.time.field.PreciseDateTimeField;

import java.util.List;

public class GetConversationsResults {

    private String email;
    private List<String> convoIds;
    private String recipient;


    public GetConversationsResults(){
    }

    public GetConversationsResults(String email, List<String> convoIds){
        this.email = email;
        this.convoIds = convoIds;
        this.recipient = recipient;
    }
    public GetConversationsResults(Builder builder){
        this.email = builder.email;
        this.convoIds = builder.convoIds;
        this.recipient = builder.recipient;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
    public List<String> getConvoIds(){
        return convoIds;
    }
    public static Builder builder() {
        return new Builder();
    }
    public static final class Builder{
        String email;
        List<String> convoIds;
        String recipient;
        private Builder(){

        }
        public Builder wtihEmail(String email){
            this.email = email;
            return this;
        }
        public Builder withConvoIds(List<String> convoIds){
            this.convoIds = convoIds;
            return this;
        }
        public GetConversationsResults build(){
            return new GetConversationsResults(this);
        }
    }
    public String toString(){
        return "email: " + email + " convoIds: " + convoIds;
    }
}