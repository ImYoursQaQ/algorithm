package com.lalalahub.virtualwallet.controller;

import com.lalalahub.virtualwallet.service.VirtualWalletService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author teohubo
 */
@RestController
public class VirtualWalletController {

    @Resource
    private VirtualWalletService virtualWalletService;

    @GetMapping("/test")
    public BaseResponse<?> test(){
        return BaseResponse.buildSuccess();
    }

    @PostMapping("/debit")
    public BaseResponse<?> debitAmount(){
        Long walletId = 0L;
        BigDecimal bill = new BigDecimal("100");
        virtualWalletService.debit(walletId,bill);
        return BaseResponse.buildSuccess();
    }

}
