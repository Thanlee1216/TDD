package com.example.vendingmachine.domain;

public interface VendingMachine {

    //돈을 받는다
    void inputMoney(int money);

    //거스름돈을 준다
    int outputMoney();

    //상품을 준다
    String giveItem(int itemId);
}
