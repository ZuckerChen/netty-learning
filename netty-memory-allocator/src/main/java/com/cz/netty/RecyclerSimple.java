package com.cz.netty;

import com.cz.netty.domain.PooledUser;

/**
 * @author chenzhang
 * @date 2022/9/14 8:36 上午
 */
public class RecyclerSimple {

    public static void main(String[] args) {
        PooledUser pooledUser1 = PooledUser.newInstance();
        pooledUser1.setId(123);
        pooledUser1.setAge(18);
        pooledUser1.setName("Lisa");
        pooledUser1.recycle();

        PooledUser pooledUser2 = PooledUser.newInstance();
        System.out.println(pooledUser2);
        System.out.println(pooledUser1 == pooledUser2);

    }
}
