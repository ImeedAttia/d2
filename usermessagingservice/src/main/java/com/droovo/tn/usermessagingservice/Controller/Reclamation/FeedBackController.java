package com.droovo.tn.usermessagingservice.Controller.Reclamation;



import com.droovo.tn.usermessagingservice.Entites.FeedBack;
import com.droovo.tn.usermessagingservice.Services.Reclamation.FeedBackService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/feedBacks")
@AllArgsConstructor
public class FeedBackController {

    private final FeedBackService feedBackService;
    @PostMapping
    public ResponseEntity<FeedBack> addFeedback(@RequestBody FeedBack feedBack) {
        FeedBack FeedBackresponse = feedBackService.addFeedback(feedBack);
        return new ResponseEntity<>(feedBackService.addFeedback(feedBack),HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<FeedBack>> getAllFeedback() {
        List<FeedBack> feedBacks = feedBackService.getAllFeedBack();
        return new ResponseEntity<>(feedBacks, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<FeedBack> updateFeedBack(@PathVariable long id, @RequestBody FeedBack feedBack) {
        feedBack.setId(id);
        feedBackService.updateFeedBack(feedBack);
        return new ResponseEntity<>(feedBack, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteFeedBack(@PathVariable long id) {
        feedBackService.deleteFeedBack(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/myFeedBacks/{id}")
    public ResponseEntity<List<FeedBack>> getUserFeedback(@PathVariable long id) {
        List<FeedBack> feedBacks = feedBackService.getUserFeedBack(id);
        return new ResponseEntity<>(feedBacks, HttpStatus.OK);
    }

}