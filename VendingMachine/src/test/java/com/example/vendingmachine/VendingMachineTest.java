package com.example.vendingmachine;

import com.example.vendingmachine.domain.VendingMachine_Beverage;
import com.example.vendingmachine.repository.ContainerRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendingMachineTest {

    //쿼리를 실행할 수 없으니 결과에 대한 대역을 조회하도록 세팅
    ContainerRepository repository = new ContainerRepository();

    @Test
    void 천원_넣고_음료_구매() {
        VendingMachine_Beverage vendingMachine = new VendingMachine_Beverage(repository.getContainers("Beverage"));
        vendingMachine.inputMoney(1000);
        String itemName = vendingMachine.giveItem(1);
        int outputMoney = vendingMachine.outputMoney();
        assertEquals("콜라", itemName);
        assertEquals(500, outputMoney);

        vendingMachine.inputMoney(1000);
        itemName = vendingMachine.giveItem(2);
        outputMoney = vendingMachine.outputMoney();
        assertEquals("사이다", itemName);
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

    @Test
    void 재고_부족() {
        VendingMachine_Beverage vendingMachine = new VendingMachine_Beverage(repository.getContainers("Beverage"));
        vendingMachine.inputMoney(1000);
        String itemName = vendingMachine.giveItem(1);
        int outputMoney = vendingMachine.outputMoney();
        assertEquals("콜라", itemName);
        assertEquals(500, outputMoney);

        vendingMachine.inputMoney(1000);
        itemName = vendingMachine.giveItem(1);
        outputMoney = vendingMachine.outputMoney();
        assertEquals("매진", itemName);
        assertEquals(1000, outputMoney);
    }

    @Test
    void 잔돈_부족() {
        VendingMachine_Beverage vendingMachine = new VendingMachine_Beverage(repository.getContainers("Beverage"));
        vendingMachine.inputMoney(1000);
        String itemName = vendingMachine.giveItem(1);
        int outputMoney = vendingMachine.outputMoney();
        assertEquals("콜라", itemName);
        assertEquals(500, outputMoney);

        vendingMachine.inputMoney(1000);
        itemName = vendingMachine.giveItem(1);
        outputMoney = vendingMachine.outputMoney();
        assertEquals("잔돈부족", itemName);
        assertEquals(1000, outputMoney);
    }


}
