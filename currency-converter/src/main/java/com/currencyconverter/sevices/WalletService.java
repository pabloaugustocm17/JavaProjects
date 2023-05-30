package com.currencyconverter.sevices;

import com.currencyconverter.dto.WalletDTO;
import com.currencyconverter.mappers.WalletMapper;
import com.currencyconverter.model.User;
import com.currencyconverter.model.Wallet;
import com.currencyconverter.repositories.UserRepository;
import com.currencyconverter.repositories.WalletRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public class WalletService {

    private final WalletRepository walletRepository;

    private final UserRepository userRepository;

    private final Logger logger = LoggerFactory.getLogger(WalletService.class);

    public WalletService(WalletRepository walletRepository,
                         UserRepository userRepository) {
        this.walletRepository = walletRepository;
        this.userRepository = userRepository;
    }

    public ResponseEntity<?> creteWallet(WalletDTO walletDTO){

        UUID id_user = walletDTO.id_user();

        Optional<User> user = userRepository.findById(id_user);

        if(user.isEmpty()){
            logger.error("USER NOT FOUND");
            return new ResponseEntity<>("User not found", HttpStatusCode.valueOf(403));
        }

        Optional<Wallet> wallet = walletRepository.findWalletUserByFrom(id_user, walletDTO.from());

        if(wallet.isPresent()){

            Wallet wallet_flush = wallet.get();
            Double money_actual = wallet_flush.getMoney();
            Double money_increment = walletDTO.money();

            wallet_flush.setMoney(money_actual + money_increment);

            walletRepository.saveAndFlush(wallet_flush);

            return ResponseEntity.ok("Wallet already exist and increment " + money_increment + " from " +
                    walletDTO.from() + "\n" +
                    "By id: " + wallet_flush.getId());

        }else{

            Wallet wallet_save = WalletMapper.walletMapper(walletDTO, user.get());

            walletRepository.saveAndFlush(wallet_save);

            return ResponseEntity.ok(wallet_save.getId());

        }


    }
}

