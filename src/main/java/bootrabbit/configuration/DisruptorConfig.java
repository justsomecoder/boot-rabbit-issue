package bootrabbit.configuration;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import bootrabbit.consumer.XConsumer;
import bootrabbit.event.XEvent;
import bootrabbit.event.XEventFactory;
import bootrabbit.service.XEventService;

import java.util.concurrent.Executors;

@Component
@Configuration
public class DisruptorConfig {

    @Bean
    public RingBuffer<XEvent> ringBuffer(XEventService xEventService) {
        Disruptor<XEvent> disruptor = new Disruptor<>(new XEventFactory(), 1024, Executors.newCachedThreadPool());

        disruptor.handleEventsWith(new XConsumer(xEventService));

        return disruptor.start();
    }
}
