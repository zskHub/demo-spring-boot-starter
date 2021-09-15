package com.zsk.starter.service.impl;

import com.zsk.starter.properties.DemoProperties;
import com.zsk.starter.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author : zsk
 * @CreateTime : 2021-09-15   22:00
 */
@Service
public class DemoServiceImplA implements DemoService {
    @Autowired
    private DemoProperties demoProperties;

    @Override
    public String getWorkingMsg() {
        return "\n" + "实现子类：A" + "\t" + "工作人:" + demoProperties.getUserName() + "\t" + "工作类型：" + demoProperties.getWorkType() + "\n";
    }

}
