package com.doop.im.sync;

import java.util.*;

public interface ConsoleConnection {
    boolean createServer();

    boolean createServer(String serverName);

    boolean getStatus();

    boolean writeMessages(ArrayList<ArrayList<Object>> messages);

    ArrayList<ArrayList<Object>> getRecordsSince();

    void relayCommandsToServer();

    boolean hasUpdates();

    String getExternalIp();

    String getPort();
}
