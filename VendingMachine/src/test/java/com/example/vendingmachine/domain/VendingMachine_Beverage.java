package com.example.vendingmachine.domain;

public class VendingMachine_Beverage{

    private int money;
    private Container_Beverage container_Beverage_Coke;
    private Container_Beverage container_Beverage_Sprite;
    private Container_Beverage container_Beverage_Lomonade;
    private Container_Beverage container_Beverage_Water;

    public VendingMachine_Beverage(){
        container_Beverage_Coke = new Container_Beverage();
        container_Beverage_Sprite = new Container_Beverage();
        container_Beverage_Lomonade = new Container_Beverage();
        container_Beverage_Water = new Container_Beverage();

        container_Beverage_Coke.setItemId(1);
        container_Beverage_Sprite.setItemId(2);
        container_Beverage_Lomonade.setItemId(3);
        container_Beverage_Water.setItemId(4);

        container_Beverage_Coke.setItemName("콜라");
        container_Beverage_Sprite.setItemName("사이다");
        container_Beverage_Lomonade.setItemName("레몬에이드");
        container_Beverage_Water.setItemName("물");

        container_Beverage_Coke.setItemCount(1);
        container_Beverage_Sprite.setItemCount(1);
        container_Beverage_Lomonade.setItemCount(1);
        container_Beverage_Water.setItemCount(1);

        container_Beverage_Coke.setItemPrice(500);
        container_Beverage_Sprite.setItemPrice(600);
        container_Beverage_Lomonade.setItemPrice(700);
        container_Beverage_Water.setItemPrice(200);
    }

    public void inputMoney(int money) {
        this.money = money;
    }

    public int outputMoney() {
        return this.money;
    }

    public String giveItem(int itemId) {
        if(itemId == 1) {
            if(container_Beverage_Coke.getItemCount() <= 0) return "매진";
            this.money -= container_Beverage_Coke.getItemPrice();
            container_Beverage_Coke.setItemCount(container_Beverage_Coke.getItemCount() - 1);
            return container_Beverage_Coke.getItemName();
        } else if(itemId == 2) {
            if(container_Beverage_Sprite.getItemCount() <= 0) return "매진";
            this.money -= container_Beverage_Sprite.getItemPrice();
            container_Beverage_Sprite.setItemCount(container_Beverage_Sprite.getItemCount() - 1);
            return container_Beverage_Sprite.getItemName();
        }else if(itemId == 3) {
            if(container_Beverage_Lomonade.getItemCount() <= 0) return "매진";
            this.money -= container_Beverage_Lomonade.getItemPrice();
            container_Beverage_Lomonade.setItemCount(container_Beverage_Lomonade.getItemCount() - 1);
            return container_Beverage_Lomonade.getItemName();
        }else if(itemId == 4) {
            if(container_Beverage_Water.getItemCount() <= 0) return "매진";
            this.money -= container_Beverage_Water.getItemPrice();
            container_Beverage_Water.setItemCount(container_Beverage_Water.getItemCount() - 1);
            return container_Beverage_Water.getItemName();
        }else {
            return "없음";
        }
    }
}
