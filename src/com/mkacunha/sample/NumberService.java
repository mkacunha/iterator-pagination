package com.mkacunha.sample;

import java.util.Iterator;

public class NumberService {


    public Iterator<Number> findAll() {
        return new NumberIterator(new NumberClient());
    }

}
