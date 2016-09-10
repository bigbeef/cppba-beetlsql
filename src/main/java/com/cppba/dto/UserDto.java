package com.cppba.dto;


import com.cppba.core.base.bean.BaseDto;
import com.cppba.entity.User;

public class UserDto extends BaseDto {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
