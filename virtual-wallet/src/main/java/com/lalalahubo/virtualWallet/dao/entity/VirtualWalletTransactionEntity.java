package com.lalalahubo.virtualWallet.dao.entity;

import com.lalalahubo.virtualWallet.common.TransactionType;

import java.math.BigDecimal;

/**
 * @author teohubo
 */
public class VirtualWalletTransactionEntity {
    private BigDecimal amount;
    private long createTime;
    private TransactionType type;
    private Long fromWalletId;

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public TransactionType getType() {
        return type;
    }

    public void setFromWalletId(Long fromWalletId) {
        this.fromWalletId = fromWalletId;
    }

    public Long getFromWalletId() {
        return fromWalletId;
    }
}
