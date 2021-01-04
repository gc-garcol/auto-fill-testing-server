package gc.garcol.autofilltest.core;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.concurrent.Future;

/**
 * @author thai-van
 **/
@Getter
@Slf4j
public class CustomFuture {

    private Future<?> future;

    public synchronized void stop() {
        if (Objects.nonNull(future) && !future.isCancelled()) {
            future.cancel(true);
            log.info("stopped Future {}", future.hashCode());
        }
    }

    public synchronized void push(Future<?> future) {
        stop();
        this.future = future;
    }

}
