package bootrabbit.consumer;

import com.lmax.disruptor.EventHandler;
import bootrabbit.event.XEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingConsumer implements EventHandler<XEvent> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public void onEvent(XEvent xEvent, long sequence, boolean endOfBatch) throws Exception {
        logger.info("X");
    }
}