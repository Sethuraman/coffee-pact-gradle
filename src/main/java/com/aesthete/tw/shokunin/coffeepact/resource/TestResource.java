package com.aesthete.tw.shokunin.coffeepact.resource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sethur on 26/03/2016.
 */
@RestController
public class TestResource {

    @RequestMapping(value = "/menu")
    public ResponseEntity<String> test(){
        final HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>("{\"coffees\": [\n" +
                "                {\n" +
                "                  \"name\": \"long black\",\n" +
                "                  \"order_path\": \"/order/long-black\",\n" +
                "                  \"price\": 3,\n" +
                "                  \"caffeine_level\": 8,\n" +
                "                  \"milk_ratio\": 0\n" +
                "                },\n" +
                "                {\n" +
                "                  \"name\": \"flat white\",\n" +
                "                  \"order_path\": \"/order/flat-white\",\n" +
                "                  \"price\": 3.5,\n" +
                "                  \"caffeine_level\": 5,\n" +
                "                  \"milk_ratio\": 2\n" +
                "                },\n" +
                "                {\n" +
                "                  \"name\": \"latte\",\n" +
                "                  \"order_path\": \"/order/latte\",\n" +
                "                  \"price\": 3.5,\n" +
                "                  \"caffeine_level\": 5,\n" +
                "                  \"milk_ratio\": 3\n" +
                "                },\n" +
                "                {\n" +
                "                  \"name\": \"espresso\",\n" +
                "                  \"order_path\": \"/order/espresso\",\n" +
                "                  \"price\": 2,\n" +
                "                  \"caffeine_level\": 10,\n" +
                "                  \"milk_ratio\": 0\n" +
                "                },\n" +
                "                {\n" +
                "                  \"name\": \"machiato\",\n" +
                "                  \"order_path\": \" /order/machiato\",\n" +
                "                  \"price\": 2.5,\n" +
                "                  \"caffeine_level\": 10,\n" +
                "                  \"milk_ratio\": 0.5\n" +
                "                }\n" +
                "              ]}", httpHeaders, HttpStatus.OK);
    }

    @RequestMapping(value = "/order/{orderId}", method = RequestMethod.GET)
    public ResponseEntity<String> test2(@PathVariable int orderId){
        final HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>("{\"status\":\"QUEUED\"}", httpHeaders, HttpStatus.OK);
    }

    @RequestMapping(value = "/order/{drinkType}", method = RequestMethod.POST)
    public ResponseEntity<String> test3(@PathVariable String drinkType, @RequestBody String data){
        final HttpHeaders httpHeaders= new HttpHeaders();
        System.out.println(data);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>("{\"order\": \"/order/123\",\n" +
                "          \"wait_time\": \"5\"}", httpHeaders, HttpStatus.CREATED);
    }
}
