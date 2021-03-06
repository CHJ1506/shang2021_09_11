package com.chenhua.shang2021;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import org.junit.Test;

/**
 * @ClassName: codeGenerator
 * @Description: 逆向工程，代码生成器
 * @Author: ChenHuaJian  Email: 1052156496@qq.com
 * @Date: 2021/9/11 21:19
 * @Version: 1.0
 **/
public class codeGenerator {


    @Test
    public void codegen(){

        //全局配置 设置  (注意为 代码生成器的包)
        GlobalConfig config = new GlobalConfig();


        config.setActiveRecord(true) // 是否支持AR模式
                .setAuthor("chenhuajian") // 作者
                .setOutputDir("F:\\work\\NeedtoImport_ProjectPack\\shang2021_09_11\\shang2021-admin-component\\src\\main\\java") // 生成路径(不包括包名)
                .setFileOverride(true)  // 文件覆盖
                .setIdType(IdType.AUTO) // 主键策略
                .setServiceName("%sService")  // 设置生成的service接口的名字的首字母是否为I
                // IEmployeeService
                .setBaseResultMap(true)
                .setOpen(false)  //是否打开输出目录
                .setBaseColumnList(true);


        //2. 数据源配置
        DataSourceConfig dsConfig  = new DataSourceConfig();
        dsConfig.setDbType(DbType.MYSQL)  // 设置数据库类型
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUrl("jdbc:mysql://localhost:3306/workchat?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT")  //连接地址，包括表名
                .setUsername("root")
                .setPassword("123456");


        //3. 策略配置
        StrategyConfig stConfig = new StrategyConfig();
        stConfig.setCapitalMode(true) //全局大写命名
                .setNaming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略
                .setTablePrefix("t_")   //表的前缀
                .setColumnNaming(NamingStrategy.underline_to_camel)//下划线转驼峰
                .setInclude("t_admin");  // 生成的表

        //4. 包名策略配置
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("com.chenhua.shang2021")
                .setMapper("mapper")
                .setService("service")
                .setController("controller")
                .setEntity("beans")
                .setXml("mapper");

        //5. 整合配置（把以上配置bean的实例传进来，得到全局配置对象）
        AutoGenerator ag = new AutoGenerator();




        ag.setGlobalConfig(config)
                .setDataSource(dsConfig)
                .setStrategy(stConfig)
                .setPackageInfo(pkConfig);

        //6. 执行 全局配置对象的execute()方法
        ag.execute();




    }



    @Test
    public void testBean(){



    }






}
