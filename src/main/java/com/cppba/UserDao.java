package com.cppba;

import com.cppba.entity.User;
import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.annotatoin.RowSize;
import org.beetl.sql.core.annotatoin.RowStart;
import org.beetl.sql.core.mapper.BaseMapper;

import java.util.List;

public interface UserDao  extends BaseMapper<User> {
    
    public List<User> select(
            @Param("age")Integer age,
            @Param("name")Integer name,
            @RowStart int start,
            @RowSize int size);
    
}