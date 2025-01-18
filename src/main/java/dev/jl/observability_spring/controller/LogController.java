package dev.jl.observability_spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/v1/logs")
@Slf4j
public class LogController {

    @GetMapping("/info")
    public ResponseEntity<Void> generateInfoLog() {
        log.info(String.format("Generate info long at: %s", Instant.now()));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/error")
    public ResponseEntity<Void> generateErrorLog() throws RuntimeException {
        throw new RuntimeException("A error occurred!");
    }

    @GetMapping("/warning")
    public ResponseEntity<Void> generateWarningLog() throws BadRequestException {
        throw new BadRequestException("Mock for bad request!");
    }
}
