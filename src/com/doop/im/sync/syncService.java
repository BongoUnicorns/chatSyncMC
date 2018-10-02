package com.doop.im.sync;

public interface syncService {
    //long getLastSuccessfulSyncTime();
    void sync();
    void runJob();
    void createConnections();
}
