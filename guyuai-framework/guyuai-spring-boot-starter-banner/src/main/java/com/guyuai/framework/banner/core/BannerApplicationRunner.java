package com.guyuai.framework.banner.core;

import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.util.ClassUtils;

import java.util.concurrent.TimeUnit;

/**
 * 项目启动成功后，提供文档相关的地址
 *
 * @author 谷雨源码
 */
@Slf4j
public class BannerApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ThreadUtil.execute(() -> {
            ThreadUtil.sleep(1, TimeUnit.SECONDS); // 延迟 1 秒，保证输出到结尾
            log.info("\n----------------------------------------------------------\n\t" +
                            "项目启动成功！\n\t" +
                            "----------------------------------------------------------");

//            // 数据报表
//            if (isNotPresent("com.guyuai.module.report.framework.security.config.SecurityConfiguration")) {
//                System.out.println("[报表模块 guyuai-module-report - 已禁用][参考 https://doc.localhost/report/ 开启]");
//            }
//            // 工作流
//            if (isNotPresent("com.guyuai.framework.flowable.config.GuyuaiFlowableConfiguration")) {
//                System.out.println("[工作流模块 guyuai-module-bpm - 已禁用][参考 https://doc.localhost/bpm/ 开启]");
//            }
//            // 微信公众号
//            if (isNotPresent("com.guyuai.module.mp.framework.mp.config.MpConfiguration")) {
//                System.out.println("[微信公众号 guyuai-module-mp - 已禁用][参考 https://doc.localhost/mp/build/ 开启]");
//            }
//            // 商城
//            if (isNotPresent("com.guyuai.module.trade.framework.web.config.TradeWebConfiguration")) {
//                System.out.println("[商城系统 guyuai-module-mall - 已禁用][参考 https://doc.localhost/mall/build/ 开启]");
//            }
        });
    }

    private static boolean isNotPresent(String className) {
        return !ClassUtils.isPresent(className, ClassUtils.getDefaultClassLoader());
    }

}
