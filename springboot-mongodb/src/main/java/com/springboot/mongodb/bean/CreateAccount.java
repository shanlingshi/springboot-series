package com.springboot.mongodb.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author shanlingshi
 * @since 2021-09-03
 */
@Getter
@Setter
public class CreateAccount implements Serializable {

    private static final long serialVersionUID = 7665190409172218778L;

    private String account;

    private String username;

    private BigDecimal surplusAmount = BigDecimal.ZERO.setScale(4, RoundingMode.CEILING);

}
