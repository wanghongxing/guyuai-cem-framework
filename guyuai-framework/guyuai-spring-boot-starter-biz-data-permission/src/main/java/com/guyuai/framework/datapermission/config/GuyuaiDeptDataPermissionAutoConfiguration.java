//package com.guyuai.framework.datapermission.config;
//
//import com.guyuai.framework.datapermission.core.rule.dept.DeptDataPermissionRule;
//import com.guyuai.framework.datapermission.core.rule.dept.DeptDataPermissionRuleCustomizer;
//import com.guyuai.framework.security.core.LoginUser;
//import com.guyuai.module.system.api.permission.PermissionApi;
//import org.springframework.boot.autoconfigure.AutoConfiguration;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.context.annotation.Bean;
//
//import java.util.List;
//
///**
// * 基于部门的数据权限 AutoConfiguration
// *
// * @author 谷雨源码
// */
//@AutoConfiguration
//@ConditionalOnClass(LoginUser.class)
//@ConditionalOnBean(value = {PermissionApi.class, DeptDataPermissionRuleCustomizer.class})
//public class GuyuaiDeptDataPermissionAutoConfiguration {
//
//    @Bean
//    public DeptDataPermissionRule deptDataPermissionRule(PermissionApi permissionApi,
//                                                         List<DeptDataPermissionRuleCustomizer> customizers) {
//        // 创建 DeptDataPermissionRule 对象
//        DeptDataPermissionRule rule = new DeptDataPermissionRule(permissionApi);
//        // 补全表配置
//        customizers.forEach(customizer -> customizer.customize(rule));
//        return rule;
//    }
//
//}
