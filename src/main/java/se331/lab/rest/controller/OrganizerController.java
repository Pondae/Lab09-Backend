package se331.lab.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se331.lab.rest.service.OrganizerService;

@RestController
public class OrganizerController {
    @Autowired
    OrganizerService organizerService;
    @GetMapping("/organizers")
    ResponseEntity<?> getOrganizers() {
        return ResponseEntity.ok(organizerService.getAllOrganizer());
    }
}
