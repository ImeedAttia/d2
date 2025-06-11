package com.droovo.tn.usermessagingservice.Validators;

import com.droovo.tn.usermessagingservice.Entites.Requests.UserDetailsRequest;

/**
 * UserDetailsValidator is a utility class that provides methods to validate user details such as email, phone number, and CIN.
 */
public class UserDetailsValidator {

    /**
     * Validates the email format.
     *
     * @param email the email to validate
     * @return true if the email is valid, false otherwise
     */
    public static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
    }
    /**
     * Validates the phone number format.
     *
     * @param phoneNumber the phone number to validate
     * @return true if the phone number is valid, false otherwise
     */
    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            return false;
        }
        String phoneRegex = "^\\+?[0-9]{10,15}$";
        return phoneNumber.matches(phoneRegex);
    }

    public static boolean isValidCin(int cin) {
        // Assuming CIN is a 6-digit number
        return cin >= 100000 && cin <= 999999;
    }

    /**
     * Validates the user details request.
     *
     * @param userDetailsRequest the user details request to validate
     * @return true if the user details are valid, false otherwise
     */
    public static boolean isValidUserDetails(UserDetailsRequest userDetailsRequest) {
        if (userDetailsRequest == null) {
            return false;
        }

        if (!isValidEmail(userDetailsRequest.getEmail())) {
            return false;
        }

        if (!isValidPhoneNumber(userDetailsRequest.getPhone())) {
            return false;
        }

        if (!isValidCin(userDetailsRequest.getCin())) {
            return false;
        }
        if (userDetailsRequest.getDisplayName() == null || userDetailsRequest.getDisplayName().isEmpty()) {
            return false;
        }
        if (userDetailsRequest.getUid() == null || userDetailsRequest.getUid().isEmpty()) {
            return false;
        }
        return true;
    }

}
