package za.co.mahadew.damien.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by DAMIEN6 on 23/10/2016.
 */
@RestController
//@Rest Controller - provides a class with only rest services - no need to have a view
public class BaseRestController {

    @RequestMapping("/")
    public String exampleHelloWorld() {
        //Returns String as body of HttpResponse
        return "hello world";
    }

}
