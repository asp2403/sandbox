package aspopov.streamrabbitbinder.processor.service;

import aspopov.streamrabbitbinder.common.domain.Message;

public interface ProcessorService {
    void processMessage(Message message);
}
