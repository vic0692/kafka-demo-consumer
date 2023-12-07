package kafkademoconsumer.kafkademoconsumer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class KafkaMessagingService {
    private static final String topic = "${topic.send-msg}";
    private static final String group = "${spring.kafka.consumer.group-id}";

    @KafkaListener(topics = topic, groupId = group, properties = {"spring.json.value.default.type=kafkademoconsumer.kafkademoconsumer.CLS"})
    public CLS getCls(CLS cls) {
        log.info("Message consumed {}", cls);
        return cls;
    }
}
