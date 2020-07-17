package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/**
 * 该类是一个配置类，不一定要在当前目录下的配置
 * 作用和bean.xml是一样的
 *
 * Spring中的新注解
 * Configuration：
 *      作用：指定当前类是一个配置类
 *      细节：当配置类作为AnnotationConfigApplicationContext对象创建的参数时，该注解可以不写
 *              如果
 * ComponentScan:
 *      作用：用于通过注解指定Spring在创建时要扫描的包
 *      属性：
 *            value：它和basePackages属性是一样的，都是用于指定创建容器时要导入的包
 *            注意：两个属性的值都是String[]数组，标准是用大括号，但如果是只有一个，就可以不用写大括号
 *      我们使用此注解等同于在xml中配置了<context:component-scan base-package="com.woody"></context:component-scan>
 * Bean:
 *      作用：用于把当前方法的返回值作为bean对象存入Spring容器中
 *      属性：
 *          name：用于指定bean的ID。当不写时，默认值是当前方法的名称
 *      细节：
 *          当我们使用注解配置方法时，如果方法有参数，Spring会去容器中查找有无可用的bean对象
 *          查找的方式和Autowired一样。
 * Import：
 *      作用：用于导入其他的配置
 *      属性：
 *          value：用于指定其他类的字节码(.class)
 *          当我们使用Import的注解之后，有Import注解的类叫做父配置类，导入的类是子配置类
 * PropertySource：
 *      作用：用于指定properties文件的位置
 *      属性：
 *          value：指定文件的名称和路径
 *              关键字：classpath，表示类路径
 */
// @Configuration
@ComponentScan(basePackages = {"com.woody"})
@Import(JdbcConfig.class)
@PropertySource("classpath:JdbcConfig.properties")
public class SpringConfiguration {



}

