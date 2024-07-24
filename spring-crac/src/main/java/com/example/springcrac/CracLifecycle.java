package com.example.springcrac;

import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicBoolean;

@Component
class CracLifecycle implements SmartLifecycle {

    private final AtomicBoolean running = new AtomicBoolean(false);

    @Override
    public void start() {
        if (this.running.compareAndSet(false, true))
            System.out.println("CRAC starting");
    }

    @Override
    public void stop() {
        if (this.running.compareAndSet(true, false))
            System.out.println("CRAC stopping");

    }

    @Override
    public boolean isRunning() {
        return this.running.get();
    }
}
