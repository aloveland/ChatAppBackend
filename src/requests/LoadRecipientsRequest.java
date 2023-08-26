package requests;

public class LoadRecipientsRequest {

    private String email;

    public LoadRecipientsRequest() {
    }

    public LoadRecipientsRequest(String email) {
        this.email = email;
    }

    public LoadRecipientsRequest(Builder builder) {
        this.email = builder.email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static final class Builder {
        private String email;

        private Builder() {
        }

        public static Builder newInstance() {
            return new Builder();
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public LoadRecipientsRequest build() {
            return new LoadRecipientsRequest(this);
        }
    }

    @Override
    public String toString() {
        return "LoadRecipientsRequest{" +
                "email='" + email + '\'' +
                '}';
    }
}
