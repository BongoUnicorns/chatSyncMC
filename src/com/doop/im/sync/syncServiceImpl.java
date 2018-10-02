package com.doop.im.sync;

import java.util.ArrayList;

public class syncServiceImpl implements syncService {
    // private long lastSyncTime = 0L;

    ConsoleConnectionImpl consoleConnection;

    ImConnectionImpl imConnection;

    /*
     * public long getLastSuccessfulSyncTime() {
     * return lastSyncTime;
     * }
     * public void setLastSuccessfulSyncTime(long time) {
     * this.lastSyncTime = time;
     * }
     */

    public void sync() {
        for (int i = 0; i <= 10;) {

            // CHECK IM connectivity
            if (!imConnection.getStatus()) {
                i++;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                i = 0;

                // if console application is active
                if (consoleConnection.getStatus()) {
                    if (!imConnection.isChatUnlocked()) {
                        imConnection.unlockChat();
                    }

                    /*
                     * if ((consoleConnection.console.getLastOutTime() >
                     * this.lastSyncTime) || (imConnection.im.getLastOutTime() >
                     * this.lastSyncTime)) {
                     * if (imConnection.im.getLastInTime() <
                     * consoleConnection.console.getLastOutTime()) {
                     * ArrayList<ArrayList<Object>> messages =
                     * consoleConnection.getRecordsSince(imConnection.im.
                     * getLastInTime());
                     * imConnection.writeMessages(messages);
                     * imConnection.im.setLastInTime(consoleConnection.console.
                     * getLastOutTime());
                     * // update im with latest updates from console,
                     * // including time
                     * // set master last sync
                     * this.setLastSuccessfulSyncTime(consoleConnection.console.
                     * getLastOutTime());
                     * }
                     * if (consoleConnection.console.getLastInTime() <
                     * imConnection.im.getLastOutTime()) {
                     * // update console with latest updates from im,
                     * // including time
                     * // set master last sync
                     * this.setLastSuccessfulSyncTime(imConnection.im.
                     * getLastOutTime());
                     * }
                     * }
                     */

                    // VERSIONING LOGIC
                    ArrayList<ArrayList<Object>> imFeed = new ArrayList<ArrayList<Object>>();
                    ArrayList<ArrayList<Object>> consoleFeed = new ArrayList<ArrayList<Object>>();

                    if (imConnection.hasUpdates()) {
                        imFeed = imConnection.im.getLatestFeed();
                        consoleConnection.writeMessages(imFeed);
                    }

                    if (consoleConnection.hasUpdates()) {
                        consoleFeed = consoleConnection.console.getLatestFeed();
                        imConnection.writeMessages(consoleFeed);
                    }

                    ArrayList<ArrayList<Object>> composite = new ArrayList<ArrayList<Object>>();

                    if (imFeed.size() > 0) {
                        for (ArrayList<Object> message : imFeed) {
                            composite.add(message);
                        }
                    }
                    if (consoleFeed.size() > 0) {
                        for (ArrayList<Object> message : consoleFeed) {
                            composite.add(message);
                        }
                    }

                    if (composite.size() > 0) {
                        imConnection.im.addToFeed(composite);
                        consoleConnection.console.addToFeed(composite);
                    }

                } else {
                    imConnection.lockChat();
                    break;
                    // terminates program!
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        // SEND EMAIL that im is unresponsive?
        // save-all the server, stop gracefully
    }

    public void runJob() {

        this.createConnections();
        this.sync();
    }

    public void createConnections() {
        consoleConnection = new ConsoleConnectionImpl();
        imConnection = new ImConnectionImpl();

        if (consoleConnection.createServer() && imConnection.connect()) {

        } else {
            // THROW EXCEPTION! FAILED TO START SERVER OR BIND TO IM
        }
    }
}
