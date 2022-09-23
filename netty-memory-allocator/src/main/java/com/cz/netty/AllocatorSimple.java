package com.cz.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;

/**
 * @author chenzhang
 * @date 2022/7/20 7:20 下午
 */
public class AllocatorSimple {
    public static void main(String[] args) {
        poolThreadCache();
    }

    /**
     * 直接内存 -- PoolThreadCache
     */
    private static void poolThreadCache() {
        PooledByteBufAllocator allocator = PooledByteBufAllocator.DEFAULT;
        //分配Normal <=16M
        //ByteBuf buffer = allocator.buffer(1024*1024*16);

        //分配Small <=28k
        //ByteBuf buffer1 = allocator.buffer(1024*11);


        //分配分配Normal-走本地缓存
        //ByteBuf buffer2 = allocator.buffer(1024 * 30);
        //buffer2.release();
        //ByteBuf buffer3 = allocator.buffer(1024 * 30);

        //分配分配Small-走本地缓存
        ByteBuf buffer4 = allocator.buffer(1024 *9);
        ByteBuf buffer5 = allocator.buffer(1024 *9);
        buffer4.release();

        //分配分配Huge
        //ByteBuf buffer2 = allocator.buffer(1024*1024*32);
    }
}
