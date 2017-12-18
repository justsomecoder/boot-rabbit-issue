package bootrabbit.event;

import com.lmax.disruptor.EventFactory;

public class XEventFactory implements EventFactory<XEvent> {

    @Override
    public XEvent newInstance() {
        return new XEvent();
    }
}
