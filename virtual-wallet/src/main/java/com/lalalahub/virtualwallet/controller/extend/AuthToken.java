package com.lalalahub.virtualwallet.controller.extend;

import lombok.Getter;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

/**
 * @author teohubo
 */
@Getter
public class AuthToken {

    private String token;

    private long createTime;

    private Long expiredTimeInterval = 60*60*1000L;

    public AuthToken(String token, long createTime) {
        this.token = token;
        this.createTime = createTime;
    }

    public AuthToken(String token, long createTime, Long expiredTimeInterval) {
        this.token = token;
        this.createTime = createTime;
        this.expiredTimeInterval = expiredTimeInterval;
    }

    public boolean isExpired(Date current){
        return current.getTime() - this.createTime > this.expiredTimeInterval;
    }

    public boolean match(AuthToken token){
        return Objects.equals(this.token,token.getToken());
    }

    public static AuthToken createToken(ApiRequest request){
        long timeStamp = request.getTimeStamp();
        CredentialStorage mysqlCredentialStorage = new MysqlCredentialStorage();
        String credential = mysqlCredentialStorage.getCredential(request.getAppID());
        Map<String, Object> params = request.parseParams();
        params.put("creatTime",timeStamp);
        params.put("credential",credential);
        String token = generateToken(params);
        return new AuthToken(token,timeStamp);
    }

    private static String generateToken(final Map<String, Object> params) {
        StringBuilder stringBuilder = new StringBuilder();
        params.keySet().stream().sorted().forEach(key-> stringBuilder.append(params.get(key)));
        return DigestUtils.md5DigestAsHex(stringBuilder.toString().getBytes());
    }


}
