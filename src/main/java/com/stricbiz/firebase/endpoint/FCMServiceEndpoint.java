package com.stricbiz.firebase.endpoint;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin
@RequestMapping(value = "/fcm")
public class FCMServiceEndpoint {
    @PostMapping("/subscribe")
    public ResponseEntity<String> subscribe(@RequestBody String body,
                                            HttpServletRequest request,
                                            HttpServletResponse response) {
        return new ResponseEntity<String>("Your code to subscribe.", HttpStatus.OK);
    }

    @PostMapping("/unsubscribe")
    public ResponseEntity<String> unSubscribe(@RequestBody String body,
                                            HttpServletRequest request,
                                            HttpServletResponse response) {
        return new ResponseEntity<String>("Your code to unsubscribe.", HttpStatus.OK);
    }

    @PostMapping("/sendMessage")
    public ResponseEntity<String> sendMessage(@RequestBody String body,
                                            HttpServletRequest request,
                                            HttpServletResponse response) {
        return new ResponseEntity<String>("Your code to send message.", HttpStatus.OK);
    }
}
