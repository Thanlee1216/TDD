package com.example.vendingmachine.domain;

public class VendingMachine_Beverage{

    private int money;

    public void inputMoney(int money) {
        this.money = money;
    }

    public int outputMoney() {
        return this.money;
    }

    public String giveItem(int itemId) {
        if(itemId == 1) {
            this.money -= 500;
            return "코카콜라";
        } else if(itemId == 2) {
            this.money -= 600;
            return "칠성사이다";
        }else if(itemId == 3) {
            this.money -= 700;
            return "레몬에이드";
        }else if(itemId == 4) {
            this.money -= 200;
            return "물";
        }else {
            return "없음";
        }
    }
}
