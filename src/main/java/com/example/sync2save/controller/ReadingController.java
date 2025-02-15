package com.example.sync2save.controller;

import com.example.sync2save.dto.ReadingDTO;
import com.example.sync2save.model.Reading;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

import com.example.sync2save.service.ReadingService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/readings")
@CrossOrigin("*")
public class ReadingController {

    private final ReadingService readingService;

    public ReadingController(ReadingService readingService) {

        this.readingService = readingService;
    }

    @GetMapping
    public ResponseEntity<List<ReadingDTO>> getAllReadings() {
        return ResponseEntity.ok(readingService.getAllReadings());
    }

    @GetMapping("/{readingId}")
    public ResponseEntity<?> getReadingsReadingById(@PathVariable("readingId") long readingId) {
        return ResponseEntity.ok(readingService.getReadingById(readingId));
    }


    @PostMapping("/{policyId}")
    public ResponseEntity<?> createReading(@PathVariable long policyId, @RequestBody Reading reading) {
        Optional<ReadingDTO> createdReading = readingService.createReading(policyId, reading);
        if(createdReading.isPresent()) {
            return ResponseEntity.ok(createdReading.get());
        } else {
            return ResponseEntity.badRequest().body("Reading not found");
        }
    }

    @PutMapping("/{policyId}/{readingId}")
    public ResponseEntity<?> updateReading(@PathVariable Long policyId,
                                           @PathVariable Long readingId,
                                           @RequestBody Reading reading) {
        Optional<ReadingDTO> optionalIssueDTO = this.readingService.updateReading(policyId, readingId, reading);
        if(optionalIssueDTO.isPresent()) {
            return ResponseEntity.ok(optionalIssueDTO.get());
        } else {
            return ResponseEntity.badRequest().body("User not found");
        }
    }

    @DeleteMapping("/{readingId}")
    public ResponseEntity<Void> deleteReading(@PathVariable Long readingId) {
        boolean deleted = readingService.deleteReading(readingId);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
