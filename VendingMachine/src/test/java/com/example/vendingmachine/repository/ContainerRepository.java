package com.example.vendingmachine.repository;

import com.example.vendingmachine.domain.Container;
import com.example.vendingmachine.domain.Container_Beverage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * dao 대역
 */
@Repository
public class ContainerRepository {

    public List<Container> getContainers(String category) {
        List<Container> containers = new ArrayList<>();
        if(category.equals("Beverage")) {
            Container container = new Container_Beverage();
            container.setItemId(1);
            container.setItemName("콜라");
            container.setItemCount(1);
            container.setItemPrice(500);
            containers.add(container);

            container = new Container_Beverage();
            container.setItemId(2);
            container.setItemName("사이다");
            container.setItemCount(2);
            container.setItemPrice(600);
            containers.add(container);

            container = new Container_Beverage();
            container.setItemId(3);
            container.setItemName("레몬에이드");
            container.setItemCount(1);
            container.setItemPrice(700);
            containers.add(container);

            container = new Container_Beverage();
            container.setItemId(4);
            container.setItemName("물");
            container.setItemCount(10);
            container.setItemPrice(200);
            containers.add(container);
        }
        return containers;
    }
}
