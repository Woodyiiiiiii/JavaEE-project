package com.woody.service.impl;

import com.woody.service.AccountService;

import java.util.*;

/**
 * 业务层实现类
 */
public class AccountServiceImpl3 implements AccountService {

    // 复杂类型或集合的注入
    private String[] strings;
    private List<String> list;
    private Set<String> stringSet;
    private Map<String, String> stringStringMap;
    private Properties properties;

    public void setStrings(String[] strings) {
        this.strings = strings;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setStringSet(Set<String> stringSet) {
        this.stringSet = stringSet;
    }

    public void setStringStringMap(Map<String, String> stringStringMap) {
        this.stringStringMap = stringStringMap;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void saveAccount() {
        System.out.println(Arrays.toString(strings));
        System.out.println(list);
        System.out.println(stringSet);
        System.out.println(stringStringMap);
        System.out.println(properties);
    }
}
