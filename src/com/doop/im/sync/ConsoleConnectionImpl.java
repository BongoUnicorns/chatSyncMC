package com.doop.im.sync;

import java.util.ArrayList;

public class ConsoleConnectionImpl implements ConsoleConnection {
    public Console console;

    public ConsoleConnectionImpl() {
        console = new Console();
    }

    public boolean createServer() {
        // if(successfully creates server) {
        return true;
        // }else{

        // probably throw exception instead of return false
        // return false;
        // }
    }

    public boolean createServer(String serverName) {
        // if(successfully creates server with name) {
        return true;
        // }else{

        // probably throw exception instead of return false
        // return false;
        // }
    }

    public boolean getStatus() {
        // if(successfully polls server) {
        return true;
        // }else{

        // return false;
        // }
    }

    public boolean writeMessages(ArrayList<ArrayList<Object>> messages) {
        // can also write a command, if the message structure matches a command
        // structure! select which commands are allowable-- disallow
        // op/ban/whitelist/etc/tp, disallow straight stop, replace with
        // save-all stop

        if (messages.size() > 0) {
            return true;
        } else {

            return false;
        }
    }

    public ArrayList<ArrayList<Object>> getRecordsSince() {
        ArrayList<ArrayList<Object>> ALLNEWCONSOLEDATA = new ArrayList<ArrayList<Object>>();
        ArrayList<Object> test = new ArrayList<Object>();
        test.add("testStringConsole");
        ALLNEWCONSOLEDATA.add(test);
        return ALLNEWCONSOLEDATA;
    }

    public void relayCommandsToServer() {
        // TODO Auto-generated method stub

    }

    public boolean hasUpdates() {
        console.addToLatestFromReal(getRecordsSince());
        if (console.newMessagesExist()) {
            return true;
        } else {
            return false;
        }
    }

    public String getExternalIp() {
        // if(successfully gets external IP) {
        return "external ip";
        // }else{
        // return null;
        // }
    }

    public String getPort() {
        // if(successfully gets port) {
        return "port";
        // }else{
        // return null;
        // }
    }

}
