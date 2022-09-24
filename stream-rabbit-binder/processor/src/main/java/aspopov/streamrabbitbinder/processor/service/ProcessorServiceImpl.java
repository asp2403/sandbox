package aspopov.streamrabbitbinder.processor.service;

import aspopov.streamrabbitbinder.common.domain.Message;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

@Service
public class ProcessorServiceImpl implements ProcessorService {
    @Override
    @StreamListener(target= Sink.INPUT)
    public void processMessage(Message message) {
        System.out.println("Received Message: " + message.toString());
    }
}
