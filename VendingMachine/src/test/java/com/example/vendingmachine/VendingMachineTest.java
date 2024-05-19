package com.example.vendingmachine;

import com.example.vendingmachine.domain.VendingMachine_Beverage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendingMachineTest {

    @Test
    void 천원_넣고_음료_구매() {
        VendingMachine_Beverage vendingMachine = new VendingMachine_Beverage();
        vendingMachine.inputMoney(1000);
        String itemName = vendingMachine.giveItem(1);
        int outputMoney = vendingMachine.outputMoney();
        assertEquals("코카콜라", itemName);
        assertEquals(500, outputMoney);

        vendingMachine.inputMoney(1000);
        itemName = vendingMachine.giveItem(2);
        outputMoney = vendingMachine.outputMoney();
        assertEquals("칠성사이다", itemName);
        assertEquals(400, outputMoney);

        vendingMachine.inputMoney(1000);
        itemName = vendingMachine.giveItem(3);
        outputMoney = vendingMachine.outputMoney();
        assertEquals("레몬에이드", itemName);
        assertEquals(300, outputMoney);

        vendingMachine.inputMoney(1000);
        itemName = vendingMachine.giveItem(4);
        outputMoney = vendingMachine.outputMoney();
        assertEquals("물", itemName);
        assertEquals(800, outputMoney);
    }

}
