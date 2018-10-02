package com.doop.im.sync;

import java.util.*;

public interface ImConnection {
    boolean connect();

    boolean connect(String serverUrl);

    boolean getStatus();

    boolean setDescr(String description);

    boolean setChannelName(String channelName);

    boolean writeMessages(ArrayList<ArrayList<Object>> messages);

    ArrayList<ArrayList<Object>> getRecordsSince();

    boolean lockChat();

    boolean isChatUnlocked();

    boolean unlockChat();

    boolean hasUpdates();
}
