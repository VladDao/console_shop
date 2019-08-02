package com.plietnov.task;

import org.apache.log4j.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        Util.initLocale();
        LOGGER.info(Util.getResource("language_menu"));
        Util.setLocale(Util.readFromConsole());
        Init init = new Init();
        Manager manager = new Manager(init.getCommandContainer());
        init.init();
        manager.start();
    }
}