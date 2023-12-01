package edu.neu.csye7374;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SaiAkhil
 */
public class Driver {
    public static void main(String[] args) {
        System.out.println("============Main Execution Start===================\n\n");

        //Add your code in between these two print statements
        
        HashMap<Integer, MyCloneable> map = new HashMap<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            map.put(c - 'A'+ 1, new MyCloneable.MyCloneableItem.MyCloneableItemBuilder().setId(c - 'A'+1).setName(String.valueOf(c)).setPrice(1.99 + (c - 'A' )).build());
        }

        MyCloneable.MyCloneableAbstractFactoryAPI factory = new MyCloneable.MyCloneableAbstractFactory();
        factory.load(map);

        for (Map.Entry<Integer, MyCloneable> entry : map.entrySet()) {
            MyCloneable item = factory.getObject(entry.getKey());
            System.out.println(item);
        }

        System.out.println("\n\n============Main Execution End===================");
    }
}
