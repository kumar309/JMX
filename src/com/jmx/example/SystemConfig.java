package com.jmx.example;

import com.jmx.example.ISystemConfigMBean;

import javax.management.DynamicMBean;

/**
 * Created by Kumar on 11/30/2016.
 */
public class SystemConfig implements ISystemConfigMBean {
    private int noOfThreads;
    private String name;

    public SystemConfig(int noOfThreads, String name) {
        this.noOfThreads = noOfThreads;
        this.name = name;
    }

    @Override
    public void setThreadCount(int noOfThreads) {
        this.noOfThreads = noOfThreads;

    }

    @Override
    public int getThreadCount() {
        return  noOfThreads;
    }

    @Override
    public void setSchemaName(String name) {
        this.name= name;
    }

    @Override
    public String getSchemaName() {
        return name;
    }

    @Override
    public String doConfig() {
        return "No of threads:"+ noOfThreads + "SchemaName:"+ name;
    }

}
