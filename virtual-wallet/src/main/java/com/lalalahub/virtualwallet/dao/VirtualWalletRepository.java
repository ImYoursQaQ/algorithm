package com.lalalahub.virtualwallet.dao;

import com.lalalahub.virtualwallet.dao.entity.VirtualWalletEntity;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * @author teohubo
 */
@Repository
public class VirtualWalletRepository {
    public VirtualWalletEntity getWalletEntity(Long walletId) {
        return null;
    }

    public BigDecimal getBalance(Long walletId) {
        return null;
    }

    public void updateBalance(Long walletId, BigDecimal balance) {

    }
}
