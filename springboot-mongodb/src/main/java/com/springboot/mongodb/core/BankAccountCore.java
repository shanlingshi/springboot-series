package com.springboot.mongodb.core;
import com.springboot.mongodb.bean.CreateAccount;
import java.math.RoundingMode;

import com.springboot.mongodb.bean.BankAccount;
import com.springboot.mongodb.service.BankAccountService;
import java.math.BigDecimal;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author shanlingshi
 * @since 2021-09-03
 */
@Component
public class BankAccountCore {

    @Resource
    private BankAccountService bankAccountService;

    @Transactional
    public void create(CreateAccount createAccount) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccount(createAccount.getAccount());
        bankAccount.setUsername(createAccount.getUsername());
        bankAccount.setSurplusAmount(createAccount.getSurplusAmount());

        bankAccountService.init(bankAccount);
    }

    @Transactional
    public void transfer(String sourceAccount, String targetAccount, BigDecimal amount) {
        BankAccount source = bankAccountService.oneByAccount(sourceAccount);
        BankAccount target = bankAccountService.oneByAccount(targetAccount);

        if (source.getSurplusAmount().compareTo(amount) < 0) {
            throw new RuntimeException("Sorry, your credit is running low");
        }

        source.setSurplusAmount(source.getSurplusAmount().subtract(amount).setScale(4, RoundingMode.CEILING));
        bankAccountService.update(source);
        // 打开注释测试事务
//        if (1 == 1) {
//            throw new RuntimeException("Bank account transfer failed");
//        }

        target.setSurplusAmount(target.getSurplusAmount().add(amount).setScale(4, RoundingMode.CEILING));
        bankAccountService.update(target);
        // 打开注释测试事务
//        if (1 == 1) {
//            throw new RuntimeException("Bank account transfer failed");
//        }
    }

}
