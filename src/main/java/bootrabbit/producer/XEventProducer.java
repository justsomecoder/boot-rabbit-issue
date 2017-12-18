package bootrabbit.producer;

import com.lmax.disruptor.RingBuffer;
import bootrabbit.event.XEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class XEventProducer {

    private final RingBuffer<XEvent> ringBuffer;

    @Autowired
    public XEventProducer(RingBuffer<XEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void processEvent(XEvent xEvent) {
//        ringBuffer.publishEvent(TRANSLATOR, xEvent);
    }
}
