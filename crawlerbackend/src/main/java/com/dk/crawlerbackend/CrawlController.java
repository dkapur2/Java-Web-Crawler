package com.dk.crawlerbackend;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;

@CrossOrigin(origins = "*") // 🔥 this is the key fix for CORS
@RestController
public class CrawlController {

    @PostMapping("/api/crawl")
    public List<String> crawl(@RequestBody CrawlRequest request) {
        String url = request.getUrl();
        String query = request.getQuery();
        int depth = request.getDepth();

        // Example static data to confirm the connection works
        List<String> matches = new ArrayList<>();
        matches.add("Match at: " + url);
        return matches;
    }
}
