package com.bmn.e_commerce.mappers;

import java.io.IOException;

public interface Mapper<P, T> {

    P mapTo(T t);

    T mapFrom(P p) throws IOException;
}
