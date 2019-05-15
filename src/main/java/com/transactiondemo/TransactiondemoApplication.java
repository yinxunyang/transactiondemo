package com.transactiondemo;

import com.transactiondemo.dao.TsUserDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.PostConstruct;

@SpringBootApplication(scanBasePackages = "com.transactiondemo")
@MapperScan("com.transactiondemo.dao")
public class TransactiondemoApplication {
    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Bean
    public MapperFactoryBean<TsUserDao> initMyBatisUserDao() {
        MapperFactoryBean<TsUserDao> bean = new MapperFactoryBean<>();
        bean.setMapperInterface(TsUserDao.class);
        bean.setSqlSessionFactory(sqlSessionFactory);
        return bean;
    }

    public static void main(String[] args) {
        SpringApplication.run(TransactiondemoApplication.class, args);
    }

/*    @Autowired
    PlatformTransactionManager platformTransactionManager;

    @PostConstruct
    public void viewTransactionManager() {
        System.out.println(platformTransactionManager.getClass().getName());
    }*/
}
