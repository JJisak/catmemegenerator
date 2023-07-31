package net.enjoy.springboot.registrationlogin.catapp;


import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Controller
@RequestMapping("/")
public class MemeController {

    @GetMapping
    public String index(Model model) {
        model.addAttribute("memeForm", new MemeForm());
        return "cat";
    }

    @GetMapping("/cat")
    public String catPage(Model model) {
        model.addAttribute("memeForm", new MemeForm());
        return "cat";
    }

    @PostMapping("/generate-meme")
    public String generateMeme(@RequestParam("text") String text, Model model) throws IOException {
        String memeUrl = generateMemeUrl(text);
        Meme meme = new Meme(text, memeUrl);
        model.addAttribute("memeUrl", memeUrl);
        model.addAttribute("memeForm", new MemeForm());
        return "cat";

    }


    private String generateMemeUrl(String text) throws IOException {
        String encodedText = URLEncoder.encode(text, StandardCharsets.UTF_8);
        encodedText = encodedText.replace("+", "%20");
        String url = "https://cataas.com/cat/says/" + encodedText;
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        try (CloseableHttpResponse response = client.execute(request)) {
            byte[] imageBytes = IOUtils.toByteArray(response.getEntity().getContent());
            String base64Image = Base64.getEncoder().encodeToString(imageBytes);
            return "data:image/jpeg;base64," + base64Image;
        }
    }

}
