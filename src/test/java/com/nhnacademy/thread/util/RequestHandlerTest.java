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

package com.nhnacademy.thread.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
class RequestHandlerTest {

    @Test
    @DisplayName("RequestChannel = null")
    void constructorTest(){
        //TODO#8-3-5 RequestHandler 객체 생성 시 channel이 null이면 IllegalArgumentException이 발생하는지 검증합니다.

    }

    @Test
    @DisplayName("producer & consumer")
    void run(){
        //TODO#8-3-6 requestChannel과 requestHandler 객체를 생성합니다.
        RequestChannel requestChannel = null;
        RequestHandler requestHandler = null;

        AtomicInteger counter = new AtomicInteger();

        //TODO#8-3-7 counter.incrementAndGet()을 호출하는 countExecutable을 구현합니다.
        Executable countExecutable = null;


        //TODO#8-3-8 producer(생산자)가 requestChannel에 실행할 작업을 1초에 한 번씩 총 5회 추가합니다.
        Thread producer = new Thread(()->{
            for(int i=1; i<=5; i++){

            }
        });
        producer.start();

        //TODO#8-3-9 requestHandler를 이용해서 consumer 스레드를 생성하고 실행합니다.
        Thread consumer= null;


        //TODO#8-3-10 producer(생산자)의 작업이 끝나지 않았다면 테스트를 실행하는 main 스레드는 양보(대기)합니다.


        log.debug("counter:{}", counter.get());

        Assertions.assertEquals(5,counter.get());
    }

}