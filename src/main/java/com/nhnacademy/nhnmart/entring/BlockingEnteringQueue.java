package com.nhnacademy.nhnmart.entring;

import com.nhnacademy.customer.domain.Customer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BlockingEnteringQueue {

    private final BlockingQueue<Customer> queue;
    private static final int DEFAULT_CAPACITY = 100;

    public BlockingEnteringQueue() {
        this(DEFAULT_CAPACITY);
    }

    public BlockingEnteringQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.queue = new ArrayBlockingQueue<>(capacity);
    }

    public void addCustomer(Customer customer) throws InterruptedException {
        queue.put(customer);
        log.info("대기열 입장: {}", customer.getName());
    }

    public Customer getCustomer() throws InterruptedException {
        Customer customer = queue.take();
        log.info("{} 마트 입장하세요.", customer.getName());
        return customer;
    }

    public int getQueueSize() {
        return queue.size();
    }
}