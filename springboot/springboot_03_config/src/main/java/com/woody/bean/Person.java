package com.woody.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * yaml语法示例
 *
 * 将配置文件中的每一个属性的值，映射到这个组件中
 * @ConfigurationProperties 告诉SpringBoot将本类中的所有属性和配置文件相关的配置进行绑定
 * prefix = "person" 配置文件中哪个模块与下面的属性一一配对
 *
 * 注意：只有这个组件是容器中的组件，才能使用容器中@ConfigurationProperties提供的功能
 *
 * @ConfigurationProperties(prefix = "person") 默认从全局配置文件中获取值
 * @PropertySource(value = {"classpath:person.properties"}) 加载指定文件
 */
@Component
@ConfigurationProperties(prefix = "person")
//@Validated  // 表示需要校验
//@PropertySource(value = {"classpath:person.properties"})
public class Person {

    /**
     * @Value 相当于
     * <bean class="Person">
     *      <property name="lastName" value="字面量/${key}从环境变量，配置文件中获取值/#{SpEL}"/>
     * </bean>
     */
//    @Value("${person.last-name}")
//    @Email // 表示lastName必须是邮箱格式
    private String lastName;
//    @Value("#{11 * 2}")
    private Integer age;
//    @Value("true")
    private Boolean boss;
    private Date birth;

    private Map<String, Object> maps;
    private List<Object> list;
    private Dog dog;

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", maps=" + maps +
                ", list=" + list +
                ", dog=" + dog +
                '}';
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
