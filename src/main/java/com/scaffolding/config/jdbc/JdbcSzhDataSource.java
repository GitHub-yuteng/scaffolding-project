package com.scaffolding.config.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

/**
 * @author whh-yt
 */
@Configuration
@MapperScan(basePackages = "com.whhim.szh.mapper.dao.szh",sqlSessionFactoryRef = "szh_default_sqlSessionFactory")
public class JdbcSzhDataSource {

    @Value("${szh.Hikar.jdbcUrl}")
    private String jdbcUrl;
    @Value("${szh.Hikar.username}")
    private String username;
    @Value("${szh.Hikar.password}")
    private String password;
    @Value("${szh.Hikar.readOnly}")
    private boolean readOnly;
    @Value("${szh.Hikar.connectionTimeout}")
    private long connectionTimeout;
    @Value("${szh.Hikar.idleTimeout}")
    private long idleTimeout;
    @Value("${szh.Hikar.maxLifetime}")
    private long maxLifetime;
    @Value("${szh.Hikar.maximumPoolSize}")
    private int maximumPoolSize;
    @Value("${szh.Hikar.connectionTestQuery}")
    private String connectionTestQuery;
    @Value("${szh.Hikar.leakDetectionThreshold}")
    private long leakDetectionThreshold;


    /**
     * Hikar连接池的DataSource
     *
     * @return
     */
    @Bean(name="szh_default_dataSource")
    public DataSource lottery_default_dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setName("szh_default_dataSource");
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setInitialSize(2);
        dataSource.setMaxActive(100);
        dataSource.setMinIdle(50);
        dataSource.setTestWhileIdle(true);
        try{
            dataSource.setFilters("stat");
        }catch (Exception e){
        }
        dataSource.setMaxWait(60000);
        dataSource.setTimeBetweenEvictionRunsMillis(60000);
        dataSource.setMinEvictableIdleTimeMillis(300000);
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);
        dataSource.setPoolPreparedStatements(true);
        dataSource.setMaxOpenPreparedStatements(100);
        dataSource.setConnectionProperties("druid.stat.slowSqlMillis=5000");
        dataSource.setConnectionProperties("druid.stat.logSlowSql=true");
        return dataSource;
    }

    @Bean(name = "szh_default_sqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(lottery_default_dataSource());
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:**/mapper/szh/**/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "szh_default_transactionManager")
    @Primary
    public DataSourceTransactionManager testTransactionManager() {
        return new DataSourceTransactionManager(lottery_default_dataSource());
    }

    @Bean("szh_default_transactionTemplate")
    public TransactionTemplate transactionTemplate() {
        TransactionTemplate transactionTemplate = new TransactionTemplate();
        transactionTemplate.setTransactionManager(testTransactionManager());
        //PROPAGATION_REQUIRED：如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。这是最常见的选择。
        //PROPAGATION_NESTED：如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则执行与PROPAGATION_REQUIRED类似的操作。
        //当使用PROPAGATION_NESTED时，底层的数据源必须基于JDBC 3.0，并且实现者需要支持保存点事务机制。
        transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        return transactionTemplate;
    }

    @Bean("szh_default_jdbcTemplate")
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(lottery_default_dataSource());
        return jdbcTemplate;
    }

    @Bean(name = "szh_default_sqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory());
    }

}
