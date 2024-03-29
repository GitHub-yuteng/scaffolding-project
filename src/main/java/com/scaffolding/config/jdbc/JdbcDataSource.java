package com.scaffolding.config.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author yt
 */
@Configuration
@MapperScan(basePackages = {"com.whhim.hxh.mapper"}, sqlSessionFactoryRef = "default_sqlSessionFactory")
public class JdbcDataSource {

    @Autowired
    private MybatisPlusInterceptor mybatisPlusInterceptor;

    public final static String DEFAULT_TRANSACTION_MANAGER = "default_transactionManager";
    public final static String DEFAULT_TRANSACTION_TEMPLATE = "default_transactionTemplate";

    private final static String JDBC_URL = "jdbc:postgresql://192.200.3.31:5432/wxscan_tst";
    private final static String USERNAME = "whh_dee";
    private final static String PASSWORD = "whh_dee201*";



    /**
     * Hikar连接池的DataSource
     *
     * @return
     */
    @Bean(name = "default_dataSource")
    public DataSource dataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setName("node-01-pgsql");
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(JDBC_URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        dataSource.setInitialSize(5);
        dataSource.setMaxActive(20);
        dataSource.setMinIdle(5);
        dataSource.setTestWhileIdle(true);
        dataSource.setFilters("stat");
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

    @Bean(name = "default_sqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dataSource());
        MybatisConfiguration configuration = new MybatisConfiguration();
        //读取null值设置
        configuration.setCallSettersOnNulls(true);
        configuration.setMapUnderscoreToCamelCase(true);
        bean.setConfiguration(configuration);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		bean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
        Interceptor[] plugins = {mybatisPlusInterceptor};
        bean.setPlugins(plugins);
        return bean.getObject();
    }

    @Bean(name = JdbcDataSource.DEFAULT_TRANSACTION_MANAGER)
    @Primary
    public DataSourceTransactionManager testTransactionManager() throws SQLException {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean(value = JdbcDataSource.DEFAULT_TRANSACTION_TEMPLATE)
    public TransactionTemplate transactionTemplate() throws SQLException {
        TransactionTemplate transactionTemplate = new TransactionTemplate();
        transactionTemplate.setTransactionManager(testTransactionManager());
        //PROPAGATION_REQUIRED：如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。这是最常见的选择。
        //PROPAGATION_NESTED：如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则执行与PROPAGATION_REQUIRED类似的操作。
        //当使用PROPAGATION_NESTED时，底层的数据源必须基于JDBC 3.0，并且实现者需要支持保存点事务机制。
        transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        return transactionTemplate;
    }

    @Bean("default_jdbcTemplate")
    public JdbcTemplate jdbcTemplate() throws SQLException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean(name = "default_sqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory());
    }
}
