package com.lalalahub.virtualwallet.dao.entity;

import com.lalalahub.virtualwallet.common.TransactionType;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author teohubo
 */
@Data
public class VirtualWalletTransactionEntity {
    private BigDecimal amount;
    private long createTime;
    private TransactionType type;
    private Long fromWalletId;

}
