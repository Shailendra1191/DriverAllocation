package com.schoudhary.DriverAllocation.commons;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {
    AtomicLong generator = new AtomicLong();

    public Long getNewId(){
        return generator.incrementAndGet();
    }
}
