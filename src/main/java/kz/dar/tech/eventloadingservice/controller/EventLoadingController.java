package kz.dar.tech.eventloadingservice.controller;

import kz.dar.tech.eventloadingservice.dto.EventDTO;
import kz.dar.tech.eventloadingservice.service.EventLoadingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping("/loading/event")
public class EventLoadingController {

    private final EventLoadingService eventLoadingService;

    @PostMapping("/educational")
    HashMap<EventDTO, ResponseEntity<String>> postEducationalEventWithPhoto(
            @RequestBody EventDTO eventDTO,
            @RequestParam(name = "image") MultipartFile file
            ) {
        return eventLoadingService.postEducationalEventWithPhoto(eventDTO, file);
    }
}
