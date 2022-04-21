//package com.sharding.xa.config;
//
//
//import com.atomikos.icatch.jta.J2eeTransactionManager;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.jta.JtaTransactionManager;
//
//import javax.transaction.TransactionManager;
//import javax.transaction.UserTransaction;
//
///**
// * @Author: ray
// * @Date: 2022/4/19 13:30
// **/
//@Configuration
//public class TransactionConfig {
//    @Bean
//    public TransactionManager atomikosTransactionManager() {
//        return new J2eeTransactionManager();
//    }
//
//    @Bean
//    public PlatformTransactionManager txManager() throws Throwable {
//        JtaTransactionManager jtaTransactionManager = new JtaTransactionManager();
//        jtaTransactionManager.setAllowCustomIsolationLevels(true);
//        jtaTransactionManager.setTransactionManager(atomikosTransactionManager());
//        UserTransaction ut = userTransaction();
//        jtaTransactionManager.setUserTransaction(ut);
//        return  jtaTransactionManager;
//    }
//}
