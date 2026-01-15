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

import java.util.LinkedList;
import java.util.Queue;

public class RequestChannel {

    // Executable 타입의 Queue
    private final Queue<Executable> requestQueue;
    // 기본 Queue Size = 10
    private static final long DEFAULT_QUEUE_SIZE = 10;
    // Queue size
    private final long queueSize;

    public RequestChannel(){
        // TODO#8-2-1 기본생성자 - DEFAULT_QUEUE_SIZE 기반으로 Queue를 생성합니다.
        this(0);
    }

    public RequestChannel(long queueSize) {
        // TODO#8-2-2 queueSize<0이면 IllegalArgumentException이 발생합니다.


        // TODO#8-2-3 queueSize, requestQueue를 초기화합니다.
        this.queueSize = 0;
        this.requestQueue = null;
    }

    public synchronized void addRequest(Executable executable){
        // TODO#8-2-4 while 조건을 수정하세요. requestQueue.size() >= queueSize이면 대기합니다.
        while(true){
            try {
                // TODO#8-2-4 wait() 호출 합니다.
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO#8-2-4 InterruptedException 발생 시 RuntimeException을 던집니다.

            }
        }

        // TODO#8-2-5 requestQueue에 executable(작업)을 추가하고 대기하고 있는 Thread를 깨웁니다.

    }

    public synchronized Executable getRequest(){
        // TODO#8-2-6 while 조건을 수정하세요. requestQueue가 비어 있다면 (작업할 것이 없다면) 대기합니다.
        while(true){
            try {
                // TODO#8-2-6 wait() 호출 합니다.
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO#8-2-6 InterruptedException 발생 시 RuntimeException을 던집니다.

            }
        }

        // TODO#8-2-7 requestQueue에서 Executable(작업)을 반환하고, 대기하고 있는 Thread를 깨웁니다.

    }

}