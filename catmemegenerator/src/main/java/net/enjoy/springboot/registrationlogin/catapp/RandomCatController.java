package net.enjoy.springboot.registrationlogin.catapp;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RandomCatController {

    private static final String CAT_API_URL = "https://cataas.com";

    @GetMapping("/randomcat")
    public ResponseEntity<byte[]> getRandomCat() {
        String apiUrl = CAT_API_URL + "/cat";

        return fetchAndReturnCatImage(apiUrl);
    }

    @GetMapping("/cat/says/{text}")
    public ResponseEntity<byte[]> getCatWithText(@PathVariable String text) {
        String apiUrl = CAT_API_URL + "/cat/says/" + text;

        return fetchAndReturnCatImage(apiUrl);
    }

    @GetMapping("/c/s/{text}")
    public ResponseEntity<byte[]> getCustomCatMeme(@PathVariable String text) {
        String apiUrl = CAT_API_URL + "/c/s/" + text;

        return fetchAndReturnCatImage(apiUrl);
    }

    private ResponseEntity<byte[]> fetchAndReturnCatImage(String apiUrl) {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<byte[]> response = restTemplate.getForEntity(apiUrl, byte[].class);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);

        return new ResponseEntity<>(response.getBody(), headers, HttpStatus.OK);
    }
}
