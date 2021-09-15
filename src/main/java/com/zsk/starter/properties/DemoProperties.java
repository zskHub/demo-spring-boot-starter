package com.zsk.starter.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author : zsk
 * @CreateTime : 2021-09-14   11:56
 */
@ConfigurationProperties(prefix = "demo")
public class DemoProperties {
    private String userName;

    private String workType;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }
}
