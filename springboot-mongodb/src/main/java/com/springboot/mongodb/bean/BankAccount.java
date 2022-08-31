package com.springboot.mongodb.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author shanlingshi
 * @since 2021-09-03
 */
@Getter
@Setter
@Document("bank_account")
public class BankAccount implements Serializable {

    private static final long serialVersionUID = 7665190409172218778L;
    @Id
    private String id;

    @Version
    private Integer version;

    private String account;

    private String username;

    private BigDecimal surplusAmount;

    @CreatedDate
    private LocalDateTime createTime;

    @LastModifiedDate
    private LocalDateTime updateTime;

}
