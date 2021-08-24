package com.lalalahub.virtualwallet.controller.extend;

/**
 * @author teohubo
 */
public class MysqlCredentialStorage implements CredentialStorage {
    /**
     * 获取appId对应的key
     *
     * @param appId
     * @return
     */
    @Override
    public String getCredential(String appId) {
        //mock real DB
        return "123456";
    }
}
