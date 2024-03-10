package com.tpk.JooqAccessLayer.service;

import com.tpk.JooqAccessLayer.dto.UserDao;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JooqService {

    private final DSLContext dsl;

    public List<UserDao> findAll() {
        return dsl.selectFrom(UserDao.USERS)
                .fetchInto(UserDao.class);
    }

    public List<UserDao> findByUsername(String username) {
        return dsl.selectFrom(UserDao.USERS)
                .where("username = ?", username)
                .fetchInto(UserDao.class);
    }

    public List<UserDao> findByUsernameSQL(String username) {
        return dsl.resultQuery("select * from users where username = ?",username).fetchInto(UserDao.class);
    }
}
