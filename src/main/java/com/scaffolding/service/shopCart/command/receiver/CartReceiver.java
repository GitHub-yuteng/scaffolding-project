package com.scaffolding.service.shopCart.command.receiver;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/9 11:28 上午
 */
public interface CartReceiver {

    void clear();

    void deleteAll();

    void add();

    void update();

}
