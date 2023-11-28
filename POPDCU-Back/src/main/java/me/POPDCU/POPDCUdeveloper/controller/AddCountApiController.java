package me.POPDCU.POPDCUdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.POPDCU.POPDCUdeveloper.domain.College;
import me.POPDCU.POPDCUdeveloper.dto.AddCountRequest;
import me.POPDCU.POPDCUdeveloper.repositroy.AddCountRepository;
import me.POPDCU.POPDCUdeveloper.service.AddCountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AddCountApiController {
    private final AddCountService addCountService;


    @PatchMapping("/api/count/id/{id}")
    public ResponseEntity<College> addCountIdJson(@PathVariable long id, @RequestBody AddCountRequest addCountRequest){
        College addCountCollege = addCountService.addCountId(id, addCountRequest.getCountNumber());
        return ResponseEntity.ok()
                .body(addCountCollege);
    }
    @PatchMapping("/api/count/name/{collegeName}")
    public ResponseEntity<College> addCountNameJson(@PathVariable String collegeName, @RequestBody AddCountRequest addCountRequest){
        College addCountCollege = addCountService.addCountName(collegeName, addCountRequest.getCountNumber());
        return ResponseEntity.ok()
                .body(addCountCollege);
    }

    @PatchMapping("/api/count/id/{id}/{number}")
    public ResponseEntity<College> addCountId(@PathVariable("id") long id, @PathVariable("number") long addCount){
        College addCountCollege = addCountService.addCountId(id,addCount);
        return ResponseEntity.ok()
                .body(addCountCollege);
    }
    @PatchMapping("/api/count/name/{collegeName}/{number}")
    public ResponseEntity<College> addCountName(@PathVariable("collegeName") String collegeName, @PathVariable("number") long addCount){
        College addCountCollege = addCountService.addCountName(collegeName,addCount);
        return ResponseEntity.ok()
                .body(addCountCollege);
    }
}
