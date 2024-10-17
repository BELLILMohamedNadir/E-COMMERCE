package com.bmn.e_commerce.services.interfaces;

import com.bmn.e_commerce.models.User;

public interface Services<T, V>{
    T create(T t) throws Exception;
    T find(V id) throws Exception;
}
