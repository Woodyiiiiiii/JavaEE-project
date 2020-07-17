package com.woody.domain;

import java.util.List;

public class QueryVo {
    private User user;

    private List<Integer> ids;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getId() {
        return ids;
    }

    public void setId(List<Integer> id) {
        this.ids = id;
    }
}
