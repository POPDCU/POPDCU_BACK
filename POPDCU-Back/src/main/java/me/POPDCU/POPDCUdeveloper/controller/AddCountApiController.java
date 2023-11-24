package me.POPDCU.POPDCUdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.POPDCU.POPDCUdeveloper.domain.College;
import me.POPDCU.POPDCUdeveloper.dto.AddCountRequest;
import me.POPDCU.POPDCUdeveloper.repositroy.AddCountRepository;
import me.POPDCU.POPDCUdeveloper.service.AddCountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequiredArgsConstructor
@RestController
public class AddCountApiController {
    private final AddCountService addCountService;

    @PatchMapping("/api/count/id/{id}")
    public ResponseEntity<College> addCountId(@PathVariable long id, @RequestBody AddCountRequest addCountRequest){
        College addCountCollege = addCountService.addCountId(id,addCountRequest);
        return ResponseEntity.ok()
                .body(addCountCollege);
    }
    @PatchMapping("/api/count/name/{collegeName}")
    public ResponseEntity<College> addCountName(@PathVariable String collegeName, @RequestBody AddCountRequest addCountRequest){
        College addCountCollege = addCountService.addCountName(collegeName,addCountRequest);
        return ResponseEntity.ok()
                .body(addCountCollege);
    }
}
