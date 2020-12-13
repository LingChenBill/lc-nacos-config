package com.lc.cloud.nacosconfig.config;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.listener.AbstractListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Nacos config配置类.
 * @description: NacosConfigManager监听nacos中配置文件的修改.
 * @author: lingchen
 * @date: 2020/12/13
 */
@Configuration
@Slf4j
public class NacosConfig {

    @Autowired
    private NacosConfigManager nacosConfigManager;

    @Bean
    public ApplicationRunner runner() {
        return args -> {
            String dataId = "lc-nacos-config.properties";
            String group = "DEFAULT_GROUP";
            nacosConfigManager.getConfigService().addListener(dataId, group, new AbstractListener() {
                @Override
                public void receiveConfigInfo(String configInfo) {
                    log.info("[Nacos Config's Listen] : " + configInfo);
                }
            });
        };
    }
}
