package com.doop.im.sync;

import java.util.ArrayList;

public class ImConnectionImpl implements ImConnection {
    public Im im;

    public ImConnectionImpl() {
        im = new Im();
    }

    public boolean connect() {
        // if(connects properly to the default server) {
        return true;
        // }else{
        // return false;
        // }
    }

    public boolean connect(String serverUrl) {
        // if(connects properly to the specified server) {
        return true;
        // }else{
        // return false;
        // }
    }

    public boolean getStatus() {
        // if(gets response back from server) {
        return true;
        // }else{
        // return false;
        // }
    }

    public boolean setDescr(String description) {
        // if(successfully sets description) {
        return true;
        // }else{
        // return false;
        // }
    }

    public boolean setChannelName(String channelName) {
        // if(successfully sets channel name) {
        return true;
        // }else{
        // return false;
        // }
    }

    public boolean writeMessages(ArrayList<ArrayList<Object>> messages) {
        if (messages.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<ArrayList<Object>> getRecordsSince() {

        ArrayList<ArrayList<Object>> ALLNEWIMDATA = new ArrayList<ArrayList<Object>>();
        ArrayList<Object> test = new ArrayList<Object>();
        test.add("testStringIM");
        ALLNEWIMDATA.add(test);

        return ALLNEWIMDATA;
    }

    public boolean lockChat() {
        // if(successfully locks the chat to comments, and prints out the Server
        // Is Down message with tags) {
        return true;
        // }else{
        // return false;
        // }
    }

    public boolean isChatUnlocked() {
        // if(chat is unlocked) {
        return true;
        // }else{
        // return false;
        // }
    }

    public boolean unlockChat() {
        // if(successfully unlocks the chat to comments, and prints out the
        // Server Is Up message with tags) {
        return true;
        // }else{
        // return false;
        // }
    }

    public boolean hasUpdates() {
        im.addToLatestFromReal(getRecordsSince());
        if (im.newMessagesExist()) {
            return true;
        } else {
            return false;
        }
    }

}
