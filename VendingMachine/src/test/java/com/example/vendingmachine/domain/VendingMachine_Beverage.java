package com.example.vendingmachine.domain;

import java.util.List;

public class VendingMachine_Beverage implements VendingMachine{

    private List<Container> containers;
    private int money;

    public VendingMachine_Beverage(List<Container> containers) {
        this.containers = containers;
    }

    @Override
    public void inputMoney(int money) {
        this.money = money;
    }

    @Override
    public int outputMoney() {
        return this.money;
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
        money -= container.getItemPrice();
        return container.getItemName();
    }
}
