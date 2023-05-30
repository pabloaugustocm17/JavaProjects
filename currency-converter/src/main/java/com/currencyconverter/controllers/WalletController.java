package com.currencyconverter.controllers;

import com.currencyconverter.dto.WalletDTO;
import com.currencyconverter.sevices.WalletService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/wallet/")
public class WalletController {

    private final WalletService walletService;

    private final Logger logger = LoggerFactory.getLogger(WalletController.class);

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping
    public ResponseEntity<?> createWallet(
            @RequestBody WalletDTO walletDTO
    ){

        logger.info("CREATE WALLET");

        return walletService.creteWallet(walletDTO);

    }

}
