package results;

import dynamoDB.Objects.LoadConvo;

import java.util.List;

public class LoadRecipientsResult {

    private List<LoadConvo> recipients;

    public LoadRecipientsResult() {
    }

    public LoadRecipientsResult(Builder builder) {
        this.recipients = builder.recipients;
    }

    public List<LoadConvo> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<LoadConvo> recipients) {
        this.recipients = recipients;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private List<LoadConvo> recipients;

        public Builder() {
        }

        public static Builder newInstance() {
            return new Builder();
        }

        public Builder withRecipients(List<LoadConvo> recipients) {
            this.recipients = recipients;
            return this;
        }

        public LoadRecipientsResult build() {
            return new LoadRecipientsResult(this);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LoadRecipientsResult{")
                .append("recipients=[");

        for (LoadConvo recipient : recipients) {
            sb.append(recipient.toString()).append(", ");
        }

        if (!recipients.isEmpty()) {
            sb.setLength(sb.length() - 2); // Remove the trailing comma and space
        }

        sb.append("]}");

        return sb.toString();
    }

}
