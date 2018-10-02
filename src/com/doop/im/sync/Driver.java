package com.doop.im.sync;

public class Driver {

    public static void main(String[] args) {
        syncServiceImpl service = new syncServiceImpl();
        service.runJob();
    }

}
