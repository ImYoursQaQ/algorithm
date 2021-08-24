package com.lalalahub.virtualwallet.controller.extend;

import lombok.Getter;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author teohubo
 */
@Getter
public class ApiRequest {

    private String baseUrl;
    private String appID;
    private long timeStamp;
    private String token;

    public ApiRequest(String baseurl) {
        this.baseUrl = baseurl;
    }

    public ApiRequest(String baseUrl, String appId, String token, long timestamp) {
        this.baseUrl = baseUrl;
        this.appID = appId;
        this.token = token;
        this.timeStamp = timestamp;
    }

    public static ApiRequest buildFromServlet(HttpServletRequest httpServletRequest) {
        String uri = httpServletRequest.getRequestURI();
        Map<String, String> parameters = new HashMap<>();
        Enumeration<String> names = httpServletRequest.getParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            String value = httpServletRequest.getParameter(name);

            parameters.put(name, value);
        }
        String appid = parameters.get("appid");
        String token = parameters.get("token");
        String timeStamp = parameters.get("timeStamp");
        return new ApiRequest(uri,appid,token,Long.parseLong(timeStamp));
    }

    public Map<String,Object> parseParams(){
        //
        return new HashMap<>();
    }

    public static ApiRequest buildFromUrl(String url) {
        // baseUrl=urlxxx&appId=1001&timestamp=1307788865&token=a78cdef998
        // 根据URL解析出appId, token, createTime, url
        String [] reqArray = url.split("&");
        String baseUrl = reqArray[0].split("=", 2)[1];
        String appId = reqArray[1].split("=",2)[1];
        String token = reqArray[2].split("=", 2)[1];
        long timestamp = Long.parseLong(reqArray[3].split("=", 2)[1]);
        return new ApiRequest(baseUrl, appId, token, timestamp);
    }


}
