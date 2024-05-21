package com.example.vendingmachine.domain;

import java.util.List;

public class VendingMachine_Beverage implements VendingMachine{

    private List<Container> containers;
    private int inputMoney;
    private int defaultMoney;

    public VendingMachine_Beverage(List<Container> containers) {
        this.containers = containers;
    }

    @Override
    public void inputMoney(int inputMoney) {
        this.inputMoney = inputMoney;
    }

    @Override
    public int outputMoney() {
        return this.inputMoney;
    }

    @Override
    public String giveItem(int itemId) {
        Container container = containers.stream()
                .filter(v -> v.getItemId() == itemId)
                .findFirst()
                .get();
        if (container.getItemCount() == 0) {
            return "매진";
        }
        container.setItemCount(container.getItemCount() - 1);
        inputMoney -= container.getItemPrice();
        return container.getItemName();
    }
}
