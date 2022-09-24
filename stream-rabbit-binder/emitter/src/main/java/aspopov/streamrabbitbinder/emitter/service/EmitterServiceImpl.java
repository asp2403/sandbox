package aspopov.streamrabbitbinder.emitter.service;

import aspopov.streamrabbitbinder.common.domain.Message;
import aspopov.streamrabbitbinder.common.domain.MessageType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class EmitterServiceImpl implements EmitterService {

    private final static Logger logger = LoggerFactory.getLogger(EmitterServiceImpl.class);

    private final static String[] DANGER_MESSAGES = {"Access Violation", "Null Pointer Exception", "Stack Overflow"};
    private final static String[] SIMPLE_MESSAGES = {"User Logged In", "User Logged Out", "Operation Complete"};

    private final Source source;

    public EmitterServiceImpl(Source source) {
        this.source = source;
    }

    @Override
    @Scheduled(initialDelay = 1000, fixedDelay = 3000)
    public void emitMessage() {
        var isDanger = new Random().nextBoolean();
        String msg;
        MessageType msgType;
        if (isDanger) {
            msgType = MessageType.DANGER;
            msg = DANGER_MESSAGES[new Random().nextInt(DANGER_MESSAGES.length)];
        } else {
            msgType = MessageType.SIMPLE;
            msg = SIMPLE_MESSAGES[new Random().nextInt(SIMPLE_MESSAGES.length)];
        }
        var message = new Message(msgType, msg);
        source.output().send(MessageBuilder.withPayload(message).build());
        logger.info("Message sent: " + message.toString());
    }
}
