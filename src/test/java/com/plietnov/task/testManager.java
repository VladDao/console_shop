package com.plietnov.task;

import com.plietnov.task.entity.Computer;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class testManager {
    private static final InputStream STD_IN = System.in;
    private static final String LS = System.lineSeparator();
    private Manager manager = new Manager();

    @Test
    public void test() {
        Thread thread = new Thread(() -> manager.start());
        thread.start();
        //        manager.start();
        try {
            System.setIn(new ByteArrayInputStream(("all^add^".replace("^", LS)).getBytes(StandardCharsets.UTF_8)));
            Thread.sleep(5000);
            System.setIn(System.in);
            Thread.sleep(5000);
            System.setIn(new ByteArrayInputStream(("add^".replace("^", LS)).getBytes(StandardCharsets.UTF_8)));
            Thread.sleep(5000);
            System.setIn(System.in);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        List<Computer> a = new ArrayList<>();
        a.add(new Computer(1, "q", "q", "", 2));
        System.out.println(a.toString());
        Computer c = a.get(0);
        c.setId(3);
        c.setClassification("we");
        c.setNameOfProduct("qwe");
        System.out.println(a.toString());
    }

    @Test
    public void linkTest() {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>() {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > 5;
            }
        };
        for (int i = 0; i<20 ;i++){
            map.put(i,i);
        }
        System.out.println(map);
        System.out.println(map.size());



    }
}
//commands.put("showProducts", new ShowProductsCommand());
//        commands.put("add", new AddToBasketCommand());
//        commands.put("showBasket", new ShowBasketCommand());
//        commands.put("bayAll", new BuyProductsCommand());
//        commands.put("showLast", new ShowLastCommand());
//        commands.put("noCommand", new NoCommand());