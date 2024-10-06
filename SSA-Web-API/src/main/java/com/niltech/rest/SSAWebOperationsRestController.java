package com.niltech.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ssa-web-api")
public class SSAWebOperationsRestController {

    @GetMapping("/find/{ssn}")
    public ResponseEntity<String> getStateBySSN(@PathVariable Integer ssn) {
        
        // Check if SSN length is not equal to 9
        if (String.valueOf(ssn).length() != 9) {
            return new ResponseEntity<>("Invalid SSN", HttpStatus.BAD_REQUEST);
        }

        // Get state code from SSN
        int stateCode = ssn % 100;
        String stateName;

        // Determine the state name based on state code
        switch (stateCode) {
            case 1:
                stateName = "Washington DC";
                break;
            case 2:
                stateName = "Ohio";
                break;
            case 3:
                stateName = "Texas";
                break;
            case 4:
                stateName = "California";
                break;
            case 5:
                stateName = "Florida";
                break;
            default:
                stateName = "Invalid SSN";
        }

        return new ResponseEntity<>(stateName, HttpStatus.OK);
    }

}
