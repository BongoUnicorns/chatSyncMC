package com.doop.im.templates;

import java.util.*;

public class BaseFeed {
    protected ArrayList<ArrayList<Object>> feed = new ArrayList<ArrayList<Object>>();
    protected ArrayList<ArrayList<Object>> freshFeed = new ArrayList<ArrayList<Object>>();

    private long creationTime;
    private long lastInTime;
    private long lastOutTime;
    private ArrayList<Object> lastMessage;

    public long getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(long creationTime) {
        this.creationTime = creationTime;
    }

    public long getLastInTime() {
        return lastInTime;
    }

    public void setLastInTime(long l) {
        this.lastInTime = l;
    }

    public long getLastOutTime() {
        return lastOutTime;
    }

    public void setLastOutTime(long lastOutTime) {
        this.lastOutTime = lastOutTime;
    }

    public ArrayList<Object> getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(ArrayList<Object> lastMessage) {
        this.lastMessage = lastMessage;
    }

    public ArrayList<ArrayList<Object>> getLatestFeed() {
        ArrayList<ArrayList<Object>> messages = freshFeed;
        this.purgeLatestFeed();
        return messages;
    }

    public void purgeLatestFeed() {
        freshFeed.clear();
    }

    public void addToFeed(ArrayList<ArrayList<Object>> messages) {
        for (ArrayList<Object> snippet : messages) {
            feed.add(snippet);
        }

        // keeps size of feed in check for performance, assuming no greater than
        // 200 messages per second or so

        while (feed.size() > 200) {
            feed.remove(0);
        }
    }

    public ArrayList<ArrayList<Object>> getFeed() {
        return feed;
    }

    public boolean newMessagesExist() {
        if (freshFeed.size() > 0) {
            return false;
        } else {
            return true;
        }
    }

    // POTENTIAL PROBLEM AREA, CHECK FOR ERRORS HERE FIRST
    public void truncateFreshFeedToOnlyLatest() {
        for (int i = freshFeed.size() - 1; i > 0; i--) {
            boolean existsInFeed = false;
            for (int j = 0; j < feed.size() - 1; j++) {
                if (feed.get(j).equals(freshFeed.get(i))) {
                    existsInFeed = true;
                }
            }
            if (existsInFeed == true) {
                for (int k = 0; k < freshFeed.size() - (1 + i); k++) {
                    freshFeed.remove(k);
                }
            }
        }
    }

    public void addToLatestFromReal(ArrayList<ArrayList<Object>> realFeed) {
        freshFeed = realFeed;
        truncateFreshFeedToOnlyLatest();
    }
}
