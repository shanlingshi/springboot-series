package com.springboot.mongodb.service;

import com.springboot.mongodb.bean.BankAccount;
import javax.annotation.Resource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

/**
 * @author shanlingshi
 * @since 2021-09-03
 */
@Component
public class BankAccountService {

    @Resource
    private MongoTemplate mongoTemplate;

    public void init(BankAccount bankAccount) {

        mongoTemplate.insert(bankAccount);
    }

    public BankAccount oneByAccount(String account) {
        Criteria criteria = new Criteria();
        criteria.and("account").is(account);

        return mongoTemplate.findOne(new Query(criteria), BankAccount.class);
    }

    public void update(BankAccount bankAccount) {

        mongoTemplate.save(bankAccount);
    }

}
