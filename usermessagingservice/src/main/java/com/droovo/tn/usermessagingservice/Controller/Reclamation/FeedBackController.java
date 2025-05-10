package com.droovo.tn.usermessagingservice.Controller.Reclamation;


<<<<<<< HEAD
=======
import com.droovo.tn.usermessagingservice.Entites.FeedBack;
import com.droovo.tn.usermessagingservice.Services.Reclamation.FeedBackService;
>>>>>>> rebuild
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
<<<<<<< HEAD
import com.droovo.tn.usermessagingservice.Entites.FeedBack;
import com.droovo.tn.usermessagingservice.Services.Reclamation.FeedBackService;
=======
>>>>>>> rebuild

import java.util.List;

@RestController
@CrossOrigin("*")
<<<<<<< HEAD
@RequestMapping("/FeedBack")
=======
@RequestMapping("/feedBacks")
>>>>>>> rebuild
@AllArgsConstructor
public class FeedBackController {

    private final FeedBackService feedBackService;
    @PostMapping
    public ResponseEntity<FeedBack> addFeedback(@RequestBody FeedBack feedBack) {
<<<<<<< HEAD
        FeedBack FeedBackresponse = feedBackService.addFeedback(feedBack);
        return new ResponseEntity<FeedBack>(HttpStatus.CREATED);

=======
        return new ResponseEntity<>(feedBackService.addFeedback(feedBack),HttpStatus.CREATED);
>>>>>>> rebuild
    }
    @GetMapping
    public ResponseEntity<List<FeedBack>> getAllFeedback() {
        List<FeedBack> feedBacks = feedBackService.getAllFeedBack();
        return new ResponseEntity<>(feedBacks, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<FeedBack> updateFeedBack(@PathVariable long id, @RequestBody FeedBack feedBack) {
        feedBack.setId(id);
<<<<<<< HEAD
        FeedBack savedFeedBack = feedBackService.updateFeedBack(feedBack);
        return new ResponseEntity<>(savedFeedBack, HttpStatus.OK);
=======
        feedBackService.updateFeedBack(feedBack);
        return new ResponseEntity<>(feedBack, HttpStatus.OK);
>>>>>>> rebuild
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