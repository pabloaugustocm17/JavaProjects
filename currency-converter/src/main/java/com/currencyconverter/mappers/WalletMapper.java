package com.currencyconverter.mappers;

import com.currencyconverter.dto.WalletDTO;
import com.currencyconverter.model.User;
import com.currencyconverter.model.Wallet;
import org.springframework.stereotype.Component;

@Component("Wallet Mapper")
public class WalletMapper {

    public static Wallet walletMapper(WalletDTO walletDTO, User user){

        return new Wallet(
                walletDTO.from(),
                walletDTO.money(),
                user
        );

    }

}
