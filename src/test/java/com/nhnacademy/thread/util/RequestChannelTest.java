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
import org.junit.platform.commons.function.Try;
import org.junit.platform.commons.util.ReflectionUtils;

import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class RequestChannelTest {

    @Test
    @DisplayName("기본 queueSize : 10")
    void constructorTest1() throws Exception {
        RequestChannel requestChannel = new RequestChannel();

        Try<Object> readFieldValue = ReflectionUtils.tryToReadFieldValue(RequestChannel.class, "queueSize", requestChannel);
        long queueSize = (long) readFieldValue.get();

        // 기본 생성자를 이용해서 생성된 requestChannel의 queueSize가 10인지 검증합니다.
        Assertions.assertEquals(10, queueSize);
    }

    @Test
    @DisplayName("queueSize = -5")
    void constructorTest2(){
        // RequestChannel 객체 생성 시 queueSize -5이면 IllegalArgumentException이 발생하는지 검증합니다.
        Assertions.assertThrows(IllegalArgumentException.class,()->{
           new RequestChannel(-5);
        });
    }

    @Test
    @DisplayName("addRequest : 5번")
    void addRequest_5_times() throws Exception {
        RequestChannel requestChannel = new RequestChannel();
        // requestChannel에 5개의 아무것도 실행하지 않는 작업(Executable)을 등록합니다. Executable : ()->{} 사용합니다.
        for(int i=1; i<=5; i ++) {
            requestChannel.addRequest(() -> {});
        }

        Try<Object> readFieldValue = ReflectionUtils.tryToReadFieldValue(RequestChannel.class, "requestQueue", requestChannel);
        Queue queue = (Queue) readFieldValue.get();

        Assertions.assertEquals(5,queue.size());
    }
    @Test
    @DisplayName("addRequest : 11번, 대기")
    void addRequest_11tiems() throws Exception {

        RequestChannel requestChannel = new RequestChannel(10);

        // requestChannel에 11개의 빈 작업을 등록하는 Thread를 구현하세요. 빈 작업: ()->{}
        Thread thread = new Thread(()->{
            for(int i=1; i<=11; i++){
                requestChannel.addRequest(()->{});
            }
        });

        thread.start();
        Thread.sleep(1000); // Thread가 실행되어 Request를 채울 시간을 줍니다.

        Try<Object> readFieldValue = ReflectionUtils.tryToReadFieldValue(RequestChannel.class, "requestQueue", requestChannel);
        Queue queue = (Queue) readFieldValue.get();

        // requestChannel의 queueSize = 10, 11번째 executable 객체를 추가할 수 없어 대기합니다.
        log.debug("queueSize:{}",queue.size());
        Assertions.assertEquals(10,queue.size());

        thread.interrupt();
    }

    @Test
    @DisplayName("getRequest, Queue로부터 (size:5)")
    void getRequest() throws Exception {
        RequestChannel requestChannel = new RequestChannel(10);
        for(int i=1; i<=5; i++){
            requestChannel.addRequest(()->{});
        }
        // requestChannel 작업을 할당받아 실행하세요.
        Executable executable = requestChannel.getRequest();
        executable.execute();

        Try<Object> readFieldValue = ReflectionUtils.tryToReadFieldValue(RequestChannel.class, "requestQueue", requestChannel);
        Queue queue = (Queue) readFieldValue.get();

        log.debug("queue-size:{}",queue.size());

        Assertions.assertEquals(4,queue.size());
    }

    @Test
    @DisplayName("빈 Queue로부터 getRequest")
    void getRequest_from_empty_queue() throws InterruptedException {
        RequestChannel requestChannel = new RequestChannel(10);

        Thread thread = new Thread(()->{
            requestChannel.getRequest();
        });
        thread.setName("my-thread");
        thread.start();

        Thread.sleep(2000);

        log.debug("{} : {}", thread.getName(),thread.getState());

        // Thread의 상태가 WAITING 상태인지 검증합니다.
        Assertions.assertEquals(Thread.State.WAITING, thread.getState());

        thread.interrupt();
    }

}