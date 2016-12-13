package com.jmx.example;

/**
 * Created by Kumar on 11/30/2016.
 */
public interface ISystemConfigMXBean {
    void setThreadCount(int noOfThreads);
    int getThreadCount();
    void setSchemaName(String name);
    String getSchemaName();
    String doConfig();

}
