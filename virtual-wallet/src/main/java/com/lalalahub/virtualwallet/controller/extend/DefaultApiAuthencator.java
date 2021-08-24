package com.lalalahub.virtualwallet.controller.extend;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class DefaultApiAuthencator implements ApiAuthencator {

    private CredentialStorage storage;

    public DefaultApiAuthencator() {
        storage = new MysqlCredentialStorage();
    }

    public DefaultApiAuthencator(CredentialStorage storage) {
        this.storage = storage;
    }

    @Override
    public void auth(String url) {
        ApiRequest apiRequest = ApiRequest.buildFromUrl(url);
        auth(apiRequest);
    }

    @Override
    public void auth(ApiRequest apiRequest) {
        long timeStamp = apiRequest.getTimeStamp();
        AuthToken clientAuthToken = new AuthToken(apiRequest.getToken(),timeStamp);
        Date current = new Date();
        if (clientAuthToken.isExpired(current)) {
            throw new RuntimeException("Token is expired!!!");
        }
        AuthToken serverAuthToken = AuthToken.createToken(apiRequest);
        if (!serverAuthToken.match(clientAuthToken)) {
            throw new RuntimeException("Token verfication failed!!!");
        }
    }

    @Override
    public void auth(HttpServletRequest httpServletRequest) {
        ApiRequest apiRequest = ApiRequest.buildFromServlet(httpServletRequest);
        auth(apiRequest);
    }

}