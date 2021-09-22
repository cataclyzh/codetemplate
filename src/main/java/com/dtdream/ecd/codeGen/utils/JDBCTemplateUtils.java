package com.dtdream.ecd.codeGen.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.dtdream.ecd.codeGen.entity.Database;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.HashMap;
import java.util.Map;

public class JDBCTemplateUtils {

    private static Map<Long,JdbcTemplate> templateMap=new HashMap<>();

    public static JdbcTemplate genJdbcTemplate(Database database){
        DruidDataSource dataSource = new DruidDataSource();
        //设置相应的参数
        //1、数据库驱动类
        dataSource.setDriverClassName(database.getDriverClassName());
        //2、url，用户名，密码
        dataSource.setUrl(getConnectionInfo(database));
        dataSource.setUsername(database.getUserName());
        dataSource.setPassword(database.getUserPwd());
        //3、初始化连接大小
        dataSource.setInitialSize(1);
        //4、连接池最大数据量
        //5、连接池最大小空闲
        dataSource.setMinIdle(1);
        //6、最大等待时间 单位毫秒
        //7、指明连接是否被空闲连接回收器(如果有)进行检验
        dataSource.setPoolPreparedStatements(true);
        //8、运行一次空闲连接回收器的时间间隔（60秒）
        dataSource.setTimeBetweenEvictionRunsMillis(60 * 1000);
        //9、验证时使用的SQL语句
        //10、借出连接时不要测试，否则很影响性能
        //11、申请连接的时候检测，如果空闲时间大于  timeBetweenEvictionRunsMillis，执行validationQuery检测连接是否有效
        dataSource.setTestWhileIdle(false);
       return new JdbcTemplate(dataSource);
    }

    public static String getConnectionInfo(Database database){
        if(database.getDatabaseType().equalsIgnoreCase("MYSQL")) {
            String connectionInfo = "jdbc:mysql://%s:%s/%s?characterEncoding=utf8&useInformationSchema=true";
            return String.format(connectionInfo,database.getDatabaseIp(),database.getPort(),database.getDatabaseName());
        }if(database.getDatabaseType().equalsIgnoreCase("ORACLE")){
            String connectionInfo = "jdbc:oracle:thin:@//%s:%s/%s";
            return String.format(connectionInfo,database.getDatabaseIp(),database.getPort(),database.getDatabaseName());
        }if(database.getDatabaseType().equalsIgnoreCase("HIVE")){
            String connectionInfo = "jdbc:hive2://%s:%s/%s";
            return String.format(connectionInfo,database.getDatabaseIp(),database.getPort(),database.getDatabaseName());
        }else{
            return "";
        }
    }
}
