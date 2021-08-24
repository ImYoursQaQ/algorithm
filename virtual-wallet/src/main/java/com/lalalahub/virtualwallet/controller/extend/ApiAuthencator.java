package com.lalalahub.virtualwallet.controller.extend;

import javax.servlet.http.HttpServletRequest;

public interface ApiAuthencator {

    void auth(String baseUrl);

    void auth(ApiRequest apiRequest);

    void auth(HttpServletRequest httpServletRequest);
}