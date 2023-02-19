package kz.dar.tech.eventloadingservice.service;

import kz.dar.tech.eventloadingservice.dto.EventDTO;
import kz.dar.tech.eventloadingservice.feign.EventClient;
import kz.dar.tech.eventloadingservice.feign.MediaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class EventLoadingService {

    private final EventClient eventClient;
    private final MediaClient mediaClient;

    public HashMap<EventDTO, ResponseEntity<String>> postEducationalEventWithPhoto(
            EventDTO eventDTO,
            MultipartFile file
    ) {
        HashMap<EventDTO, ResponseEntity<String>> result = new HashMap<>();
        EventDTO pureEvent = eventClient.postEducationalEvent(eventDTO);
        ResponseEntity<String> purePhoto = mediaClient.uploadPhoto(file);
        result.put(pureEvent, purePhoto);
        return result;

    }
}
