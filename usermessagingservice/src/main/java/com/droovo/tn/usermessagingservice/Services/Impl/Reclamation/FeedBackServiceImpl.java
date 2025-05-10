package com.droovo.tn.usermessagingservice.Services.Impl.Reclamation;

import com.droovo.tn.usermessagingservice.Entites.UserDetail;
import com.droovo.tn.usermessagingservice.Repositories.UserDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import com.droovo.tn.usermessagingservice.Entites.FeedBack;
import com.droovo.tn.usermessagingservice.Repositories.FeedBackRepository;
import com.droovo.tn.usermessagingservice.Services.Reclamation.FeedBackService;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedBackServiceImpl implements FeedBackService {

    private final FeedBackRepository feedbackRepository;
    private final UserDetailRepository userDetailRepository;

    @Override
    public FeedBack addFeedback(FeedBack feedBack) {
        Object
                principal
                = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if
        (principal
                instanceof
                UserDetails) {
            UserDetails
                    userDetails
                    = (UserDetails) principal;
            String
                    username
                    = userDetails.getUsername();
// use username or userDetails as needed

            // create local date for the system time
            LocalDate ld = LocalDate.now();
            UserDetail u1 = userDetailRepository.findByEmail(username).orElse(null);
            //UserDetail u2 = userDetailRepository.findById(feedBack.getUtilisateurManagerFeedBack().getId()).orElse(null);
            feedBack.setSubmissionDate(ld);

            feedBack.setEmployee(u1);
            //feedBack.setUtilisateurManagerFeedBack(u2);
            FeedBack fCreated = feedbackRepository.save(feedBack);
            fCreated.getEmployee().setPassword(null);
//            fCreated.getUtilisateurManagerFeedBack().setPassword(null);
            return fCreated;
        }else {
            String
                    username
                    = principal.toString();
// handle cases where the principal is not an instance of UserDetails
            return null;
        }
    }

    @Override
    public FeedBack updateFeedBack(FeedBack feedBack) {
        FeedBack f = feedbackRepository.findById(feedBack.getId()).orElse(null);
        assert f != null;
        f.setType(feedBack.getType());
        f.setLabel(feedBack.getLabel());
        f.setDescription(feedBack.getDescription());
        return feedbackRepository.save(f);
    }


    @Override
    public void deleteFeedBack(Long id) {
        feedbackRepository.deleteById(id);
    }

    @Override
    public FeedBack getFeedBack(Long id) {
        return feedbackRepository.findById(id).get();
    }

    @Override
    public List<FeedBack> getAllFeedBack() {
        return feedbackRepository.findAll();
    }
    @Override
    public List<FeedBack> getUserFeedBack(long id) {
//        UserDetail user = userDetailRepository.findById(id).get();
//        return feedbackRepository.findById(user.getId());
        return null;
    }
}
