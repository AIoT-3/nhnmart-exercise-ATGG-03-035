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

package com.nhnacademy.nhnmart.entring;

import com.nhnacademy.customer.domain.Customer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.platform.commons.function.Try;
import org.junit.platform.commons.util.ReflectionUtils;

@Slf4j
class EnteringQueueTest {
    EnteringQueue enteringQueue;
    @BeforeEach
    void setUp() {
        enteringQueue = new EnteringQueue();

        /*
            Customer{id=1, name='NHN아카데미1', money=1000000}
            ~
            Customer{id=99, name='NHN아카데미99', money=1000000}
            1~99 고객을 생성 후 enteringQueue 대기열에 등록합니다.
         */

        for (int i = 0; i < 99; i++) {
            Customer customer = new Customer(i + 1, String.format("NHN아카데미%d", i + 1), 100_0000);
            log.debug("{}", customer);
            enteringQueue.addCustomer(customer);
        }
    }

    @Test
    @DisplayName("default queue capacity = 100")
    void constructorTest_InitCapacity() throws Exception {
        // TODO#3-9 EnteringQueue.class의 capacity 필드가 100인지 검증합니다. (ReflectionUtils 사용)

    }

    @Test
    void addCustomer() throws Exception {
        // TODO#3-10 id=100인 고객을 enteringQueue에 등록하고 검증합니다.

    }

    @Test
    @DisplayName("queue - poll test")
    void getCustomer() {
        // TODO#3-11 enteringQueue에서 enteringQueue.getCustomer() 호출 시 반환되는 값을 검증합니다.

    }

    @Test
    @DisplayName("blocking queue test : queue size : 100, 101번째 customer를 추가한다면, consumer에 의해서 소비될 때까지 대기합니다.")
    void blockingTest() throws Exception {
        // TODO#3-12 producer Thread를 구현합니다.
        // id=100, id=101 고객을 추가합니다.

        // TODO#3-13 2초 대기 후 enteringQueue.getCustomer()를 호출하여 소비할 수 있도록 consumer Thread를 구현합니다.

        // TODO#3-14 producer 또는 consumer가 실행 중이라면 대기합니다. yield()를 이용해서 구현하세요.

        // TODO#3-15 enteringQueue의 size가 100인지 검증합니다.

    }
}