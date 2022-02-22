package com.rindra.hopital.API;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/testapi")
public class TestApi {
    @RequestMapping("/mamerina")
    public int test_fotsiny(){

        return 1;
    }
}
