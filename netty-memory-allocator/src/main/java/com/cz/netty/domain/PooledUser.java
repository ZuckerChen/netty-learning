package com.cz.netty.domain;

import io.netty.util.Recycler;
import io.netty.util.Recycler.Handle;

/**
 * @author chenzhang
 * @date 2022/9/14 9:06 上午
 */
public class PooledUser {
    private PooledUser() {
    }

    private final static Recycler<PooledUser> userRecycler = new Recycler<PooledUser>() {
        @Override
        protected PooledUser newObject(Handle<PooledUser> handle) {
            return new PooledUser(handle);
        }
    };

    private long id;
    private int age;
    private String name;
    private Recycler.Handle<PooledUser> handle;

    private PooledUser(Handle<PooledUser> handle) {
        this.handle = handle;
    }

    public static PooledUser newInstance() {
        return userRecycler.get();
    }

    public void recycle() {
        id = 0;
        age = 0;
        name = "";
        handle.recycle(this);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", age=" + age +
            ", name='" + name + '\'' +
            ", handle=" + handle +
            '}';
    }
}
