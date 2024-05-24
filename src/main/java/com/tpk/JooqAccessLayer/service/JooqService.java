package com.tpk.JooqAccessLayer.service;

import com.tpk.JooqAccessLayer.dto.AddressDao;
import com.tpk.JooqAccessLayer.dto.UserDao;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.tpk.JooqAccessLayer.dto.UserDao.USERS;

@Service
@RequiredArgsConstructor
public class JooqService {

    private final DSLContext dsl;

    public List<UserDao> findAll() {
        return dsl.selectFrom(USERS)
                .fetchInto(UserDao.class);
    }

    public List<UserDao> findByUsername(String username) {
        return dsl.selectFrom(USERS)
                .where("username = ?", username)
                .fetchInto(UserDao.class);
    }

    public List<UserDao> findByUsernameSQL(String username) {
        return dsl.resultQuery("select * from users where username = ?",username).fetchInto(UserDao.class);
    }

    public List<AddressDao> findAllAddress() {
        return dsl.selectFrom(AddressDao.ADDRESS).fetchInto(AddressDao.class);
    }

    public Result<?> findAllJoinTable() {
        return dsl
                .select()
                .from(USERS)
                .join(AddressDao.ADDRESS)
                .on( USERS + "." + UserDao.USERID
                        + "=" +
                        AddressDao.ADDRESS + "." +  AddressDao.USERID)
                .fetch();
    }

}
