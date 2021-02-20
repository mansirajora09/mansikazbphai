package com.bng.zbp.model.request;


        import com.fasterxml.jackson.annotation.JsonIgnore;

public class BaseRequest {
    @JsonIgnore
    private UserIdentityRequest userIdentityRequest;

    public UserIdentityRequest getUserIdentityRequest() {
        return userIdentityRequest;
    }

    public void setUserIdentityRequest(UserIdentityRequest userIdentityRequest) {
        this.userIdentityRequest = userIdentityRequest;
    }
}
