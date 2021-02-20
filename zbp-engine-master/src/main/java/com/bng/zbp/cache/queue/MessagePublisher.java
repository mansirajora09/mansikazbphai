package com.bng.zbp.cache.queue;
/**
 * @author Mansi Rajora
 */
public interface MessagePublisher {

    void publish(final String message);
}
