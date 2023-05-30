package com.currencyconverter.dto;

import java.util.UUID;

public record WalletDTO(

        String from,

        Double money,

        UUID id_user
) {
}
