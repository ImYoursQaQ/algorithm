package com.lalalahubo.virtualWallet.service;

import com.lalalahubo.virtualWallet.dao.VirtualWalletRepository;
import com.lalalahubo.virtualWallet.dao.VirtualWalletTransactionRepository;
import com.lalalahubo.virtualWallet.dao.entity.VirtualWalletEntity;
import com.lalalahubo.virtualWallet.dao.entity.VirtualWalletTransactionEntity;
import com.lalalahubo.virtualWallet.common.TransactionType;
import com.lalalahubo.virtualWallet.domain.VirtualWallet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
@Slf4j
public class VirtualWalletService {

    @Resource
    private VirtualWalletRepository walletRepo;

    @Resource
    private VirtualWalletTransactionRepository transactionRepo;

    public VirtualWallet getVirtualWallet(Long walletId) {
        VirtualWalletEntity walletEntity = walletRepo.getWalletEntity(walletId);
        return convert(walletEntity);
    }

    private VirtualWallet convert(VirtualWalletEntity walletEntity) {

        return null;
    }

    public BigDecimal getBalance(Long walletId) {
        return walletRepo.getBalance(walletId);
    }

    @Transactional
    public void debit(Long walletId, BigDecimal amount) {
        VirtualWalletEntity walletEntity = walletRepo.getWalletEntity(walletId);
        VirtualWallet wallet = convert(walletEntity);
        wallet.debit(amount);
        VirtualWalletTransactionEntity transactionEntity = new VirtualWalletTransactionEntity();
        transactionEntity.setAmount(amount);
        transactionEntity.setCreateTime(System.currentTimeMillis());
        transactionEntity.setType(TransactionType.DEBIT);
        transactionEntity.setFromWalletId(walletId);
        transactionRepo.saveTransaction(transactionEntity);
        walletRepo.updateBalance(walletId, wallet.balance());
    }

/*    @Transactional
    public void credit(Long walletId, BigDecimal amount) {
        VirtualWalletEntity walletEntity = walletRepo.getWalletEntity(walletId);
        VirtualWallet wallet = convert(walletEntity);
        wallet.credit(amount);
        VirtualWalletTransactionEntity transactionEntity = new VirtualWalletTransactionEntity();
        transactionEntity.setAmount(amount);
        transactionEntity.setCreateTime(System.currentTimeMillis());
        transactionEntity.setType(TransactionType.CREDIT);
        transactionEntity.setFromWalletId(walletId);
        transactionRepo.saveTransaction(transactionEntity);
        walletRepo.updateBalance(walletId, wallet.balance());
    }*/

    @Transactional
    public void transfer(Long fromWalletId, Long toWalletId, BigDecimal amount) {
        //...跟基于贫血模型的传统开发模式的代码一样...
        //
    }
}