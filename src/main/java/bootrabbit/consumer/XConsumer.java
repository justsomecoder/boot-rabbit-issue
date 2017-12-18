package bootrabbit.consumer;

import com.lmax.disruptor.EventHandler;
import bootrabbit.event.XEvent;
import bootrabbit.service.XEventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by tim on 7/13/16.
 */
public class XConsumer implements EventHandler<XEvent> {

    private static final Logger log = LoggerFactory.getLogger(XConsumer.class);
    private final XEventService xEventService;
    private final ExecutorService threadPool;

    public XConsumer(XEventService xEventService) {
        this.xEventService = xEventService;
        threadPool = Executors.newFixedThreadPool(3);
    }

    @Override
    public void onEvent(XEvent event, long sequence, boolean endOfBatch) throws Exception {
            threadPool.submit(() -> {
//                    xEventService.addX(event);
            });
    }

}
