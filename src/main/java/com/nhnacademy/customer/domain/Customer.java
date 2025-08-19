/*
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * + Copyright 2024. NHN Academy Corp. All rights reserved.
 * + * While every precaution has been taken in the preparation of this resource,  assumes no
 * + responsibility for errors or omissions, or for damages resulting from the use of the information
 * + contained herein
 * + No part of this resource may be reproduced, stored in a retrieval system, or transmitted, in any
 * + form or by any means, electronic, mechanical, photocopying, recording, or otherwise, without the
 * + prior written permission.
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 */

package com.nhnacademy.customer.domain;

import com.nhnacademy.customer.exception.InsufficientFundsException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

@Slf4j
public class Customer {

    private final long id;
    private final String name;

    private int money;

    public Customer(long id, String name, int money) {
        //TODO#1-1 id < 1 or name null or "" or money < 0이면 IllegalArgumentException이 발생합니다.


        //TODO#1-2 id, name, money를 초기화합니다.
        this.id=0;
        this.name="";
    }

    public long getId() {
        //TODO#1-3 method를 구현하세요, id를 반환합니다.
        return 0;
    }

    public String getName() {
        //TODO#1-4 method를 구현하세요, name을 반환 합니다.
        return "";
    }

    public int getMoney() {
        //TODO#1-5 method를 구현하세요, money를 반환 합니다.
        return 0;
    }

    public void pay(int amount) throws InsufficientFundsException {
        //TODO#1-6 amount(결제할 금액) < 0 IllegalArgumentException이 발생합니다.

        //TODO#1-7 money(회원 보유금액) < amount(결제할 금액)이면 InsufficientFundsException이 발생합니다.

        //TODO#1-8 method를 구현합니다. money에서 amount만큼 차감합니다.


        log.debug("customer: {}, pay : {}", this, amount);
    }

    @Override
    public String toString() {
        //TODO#1-9 id, name, money 반환될 수 있도록 구현합니다.

        return "";
    }

    //TODO#1-10 customer 객체 비교를 위해서(비교 기준은 id, name, money 일치)
    @Override
    public boolean equals(Object o) {
        return false;
    }

    //TODO#1-11  (id, name, money) 기준으로 hashCode() 구현
    @Override
    public int hashCode() {
        return 0;
    }
}
