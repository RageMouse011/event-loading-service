package kz.dar.tech.eventloadingservice.feign;

import kz.dar.tech.eventloadingservice.dto.EventDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("event-service")
public interface EventClient {

    @PostMapping("events/post/sports")
    EventDTO postSportsEvent(EventDTO eventDTO);

    @PostMapping("events/post/educational")
    EventDTO postEducationalEvent(EventDTO eventDTO);

    @PostMapping("events/post/entertaining")
    EventDTO postEntertainingEvent(EventDTO eventDTO);

}
