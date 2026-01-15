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

package com.nhnacademy.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
public class ThreadPool {

    // Thread-pool 기본 size
    private static final int DEFAULT_POOL_SIZE = 10;

    // Thread pool size
    private final int poolSize;

    // Thread에 의해서 실행될 Runnable 구현체
    private final Runnable runnable;

    // Thread-pool에 생성된 Thread 리스트
    private final List<Thread> threadList;

    public ThreadPool(Runnable runnable){
        // TODO#8-1-1 default 생성자 구현, poolSize = DEFAULT_POOL_SIZE를 사용합니다.
        this(DEFAULT_POOL_SIZE, runnable);
    }

    public ThreadPool(int poolSize, Runnable runnable) {
        // TODO#8-1-2 thread pool size <0 다면 IllegalArgumentException이 발생 합니다.
        if (poolSize < 0) {
            throw new IllegalArgumentException("poolSize < 0");
        }

        // TODO#8-1-3 runable == null 이면 IllegalArgumentException이 발생 합니다.
        if (Objects.isNull(runnable)) {
            throw new IllegalArgumentException("runnable is null");
        }

        // TODO#8-1-4 runnable 이 Runnable의 구현체가 아니라면 IllegalArgumentException이 발생 합니다.
        // runnable is already type Runnable, so this check might be about specific implementation or just null check.
        // However, the instruction is specific. Let's stick to null check and type check if it was Object.
        // Given it's already Runnable, we'll assume null check is enough or it means it must be a valid instance.

        // TODO#8-1-5 poolSize, runnable, threadList 초기화
        this.poolSize = poolSize;
        this.runnable = runnable;
        this.threadList = new ArrayList<>(poolSize);

        // TODO#8-1-6 createThread() 호출 합니다.
        createThread();
    }

    private void createThread(){
        /*TODO#8-1-6 thread 생성
          - synchronized를 이용해서 동기화 합니다.
          - poolSize만큼 thread를 생성하고 threadList에 추가 합니다.
         */
        synchronized (this) {
            for (int i = 0; i < poolSize; i++) {
                threadList.add(new Thread(runnable));
            }
        }
    }

    public synchronized void start(){
        // TODO#8-1-7 생성된 thread를 시작 합니다.
        for (Thread thread : threadList) {
            thread.start();
        }
    }

    public synchronized void stop(){
        /*TODO#8-1-8 interrupt()를 실행해서 thread를 종료 합니다.
          - thread가 종료되는 과정에서 동기화 되어야 합니다.
          - 우선 모든 thread interrupt() 호출 합니다.
         */
        for (Thread thread : threadList) {
            thread.interrupt();
        }

        // TODO#8-1-9 join()를 이용해서 모든 thread가 종료 될 때 까지 대기 상태로 만듭니다.
        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}