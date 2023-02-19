package kz.dar.tech.eventloadingservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@FeignClient("media-service")
public interface MediaClient {

    @PostMapping("/photos/upload")
    ResponseEntity<String> uploadPhoto(
            MultipartFile file
    );

    @GetMapping("/photos/{id}")
    ResponseEntity<byte[]> downloadPhoto(
        @PathVariable(name = "id") Long id
    );
}
