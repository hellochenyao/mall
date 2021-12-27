package com.pro.cart.service;

import com.pro.cart.vo.Cart;
import com.pro.cart.vo.CartItem;

import java.util.concurrent.ExecutionException;

/**
 * @author chenyao
 * date 2021-03-20
 */
public interface CartService {

    CartItem addToCart(Long skuId,Integer num) throws ExecutionException, InterruptedException;

    CartItem getCartItem(Long skuId);

    Cart getCart() throws ExecutionException, InterruptedException;

    void clearCart(String cartkey);

    void checkItem(Long skuId,Integer check);

    void changeItemCount(Long skuId,Integer num);

    void deleteItem(Long skuId);

}
