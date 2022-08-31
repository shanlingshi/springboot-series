package com.springboot.mongodb.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

/**
 * @author shanlingshi
 * @since 2021-09-03
 */
@Getter
@Setter
public class TransferAccount implements Serializable {

    private static final long serialVersionUID = 7665190409172218778L;

    private String targetAccount;

    private String targetUsername;

    private BigDecimal transferAmount;

}
