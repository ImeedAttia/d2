package com.droovo.tn.usermessagingservice.Services.Reclamation;

import com.droovo.tn.usermessagingservice.Entites.FeedBack;

import java.util.List;

public interface FeedBackService {

    FeedBack addFeedback(FeedBack feedBack);
    FeedBack updateFeedBack(FeedBack feedBack);
    void deleteFeedBack(Long id);
    FeedBack getFeedBack(Long id);
    List<FeedBack> getAllFeedBack();
    List<FeedBack> getUserFeedBack(long id);

}
