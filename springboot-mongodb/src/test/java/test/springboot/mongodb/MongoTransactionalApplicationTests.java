package test.springboot.mongodb;

import com.springboot.mongodb.MongoTransactionalApplication;
import com.springboot.mongodb.bean.CreateAccount;
import com.springboot.mongodb.core.BankAccountCore;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MongoTransactionalApplication.class)
public class MongoTransactionalApplicationTests {

    @Resource
    private BankAccountCore bankAccountCore;

    /**
     * 测试增删改查
     */
    @Test
    public void create() {
        CreateAccount zhangsan = new CreateAccount();
        zhangsan.setAccount("6222021807379524377");
        zhangsan.setUsername("张三");
        zhangsan.setSurplusAmount(BigDecimal.valueOf(1000).setScale(4, RoundingMode.CEILING));
        bankAccountCore.create(zhangsan);

        CreateAccount lisi = new CreateAccount();
        lisi.setAccount("6222024161091314169");
        lisi.setUsername("李四");
        bankAccountCore.create(lisi);
    }

    /**
     * 测试增删改查
     */
    @Test
    public void transfer() {
        // 张三
        String sourceAccount = "6222021807379524377";
        // 李四
        String targetAccount = "6222024161091314169";
        // 转账金额
        BigDecimal transferAmount = BigDecimal.valueOf(50).setScale(4, RoundingMode.CEILING);

        bankAccountCore.transfer(sourceAccount, targetAccount, transferAmount);
    }

}
