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

package com.nhnacademy.nhnmart.product.repository.impl;

import com.nhnacademy.nhnmart.product.domain.Product;
import com.nhnacademy.nhnmart.product.repository.ProductRepository;

import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class MemoryProductRepository implements ProductRepository {
    /*
        MemoryProductRepository를 구현합니다.
        - List, Map, Set 등 memory 기반의 저장소를 사용하여 구현합니다.
        - List, Map, Set의 구현체는 multi thread 환경에서 Thread Safety 해야 합니다.
        - MemoryProductRepository는 파싱한 product 객체를 저장소이며 product 데이터 관련된 처리를 합니다.
    */

    private final ConcurrentMap<Long, Product> productConcurrentMap = new ConcurrentHashMap<>();

    @Override
    public void save(Product product) {
        //TODO#6-4-1 product 저장

    }
    @Override
    public Optional<Product> findById(long id) {
        //TODO#6-4-2 id에 해당되는 product 조회
        return null;
    }

    @Override
    public void deleteById(long id) {
        //TODO#6-4-3 id에 해당하는 product 삭제

    }

    @Override
    public boolean existById(long id) {
        //TODO#6-4-4 id에 해당하는 product 존재 여부를 체크해서 반환합니다.
        return false;
    }

    @Override
    public long count() {
        //TODO#6-4-5 전체 product 수 반환
        return 0;
    }

    @Override
    public int countQuantityById(long id) {
        //TODO#6-4-6 id에 해당되는 product의 수량 반환(즉 재고 확인)
        return 0;
    }

    @Override
    public void updateQuantityById(long id, int quantity) {
        //TODO#6-4-7 id에 해당되는 product의 수량 변경

    }

}
