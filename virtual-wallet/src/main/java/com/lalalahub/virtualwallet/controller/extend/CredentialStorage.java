package com.lalalahub.virtualwallet.controller.extend;

/**
 * @author teohubo
 */
public interface CredentialStorage {

    /**
     * 获取appId对应的key
     * @param appId
     * @return
     */
    public String getCredential(String appId);
}
