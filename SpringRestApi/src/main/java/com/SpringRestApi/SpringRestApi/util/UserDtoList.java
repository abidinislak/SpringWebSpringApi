package com.SpringRestApi.SpringRestApi.util;

import com.SpringRestApi.SpringRestApi.domain.User_Dto;

import java.util.ArrayList;
import java.util.List;

public class UserDtoList
{

    List<User_Dto> list;

    public List<User_Dto> getList() {
        return list;
    }

    public void setList(List<User_Dto> list) {
        this.list = list;
    }

    public UserDtoList() {
        this.list = new ArrayList<>();
    }
}
