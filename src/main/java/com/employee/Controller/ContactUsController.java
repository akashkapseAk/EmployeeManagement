package com.employee.Controller;

import com.employee.Model.ContactUs;
import com.employee.Service.ContactUsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail/sent")
@CrossOrigin("*")
public class ContactUsController {

    @Autowired
    private ContactUsService contactUsService;

    private static final Logger log=LoggerFactory.getLogger(ContactUsController.class);


    @PostMapping("/")
    public ResponseEntity<?> sendContact(@RequestBody ContactUs contact)
    {
       try {

           log.info("Enter the send contact from ContactUsController{}"+contact);
           boolean result = this.contactUsService.contactUs(contact.getSubject(), contact.getMessage(), contact.getTo());
           log.info("exit the send contact from ContactUsController{}"+contact);
           return new ResponseEntity<>(result, HttpStatus.OK);
       }catch (Exception ex)
       {
           log.error("Error occurred in send mail from ContactUsController :{}"+ex.getMessage()+contact);
       }
        log.info("checking error the send contact from ContactUsController{}"+contact);
        boolean result = this.contactUsService.contactUs(contact.getSubject(), contact.getMessage(), contact.getTo());
        log.info("exit checking error the send contact from ContactUsController{}"+contact);
        return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
