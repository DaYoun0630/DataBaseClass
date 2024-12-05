package com.project.funding.mapper;

import com.project.funding.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    // 사용자 정보 저장 (SQL 정의는 XML에 있음)
    void insertUser(User user);

    // 사용자 정보 조회 (ID로 조회, SQL 정의는 XML에 있음)
    User getUserById(Long id);

    // 모든 사용자 조회 (SQL 정의는 XML에 있음)
    List<User> getAllUsers();

    // 사용자 정보 업데이트 (SQL 정의는 XML에 있음)
    void updateUser(User user);

    // 사용자 삭제 (SQL 정의는 XML에 있음)
    void deleteUser(Long id);
}
