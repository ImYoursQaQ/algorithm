package com.lalalahubo.virtualWallet.dao;

import com.lalalahubo.virtualWallet.dao.entity.VirtualWalletEntity;
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
