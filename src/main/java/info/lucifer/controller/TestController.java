package info.lucifer.controller;

import info.lucifer.entity.Test;
import info.lucifer.repository.TestRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
@Slf4j
public class TestController {

    private final TestRepository testRepository;

    @PostConstruct
    void demo(){
        log.info("Bean created successful");
        if(testRepository == null){
            log.info("Test repository not attached");
        } else {
            log.info("Test repository attached successfully");
        }
    }

    @GetMapping
    public ResponseEntity<Test> test() {
        return ResponseEntity.ok(testRepository.findById(1L).get());
    }

}
