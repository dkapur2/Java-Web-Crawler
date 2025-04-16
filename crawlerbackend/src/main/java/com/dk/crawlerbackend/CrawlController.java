package com.dk.crawlerbackend;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;

@CrossOrigin(origins = "+")
@RestController
public class CrawlController {

    @PostMapping("/api/crawl")
    public List<String> crawl(@RequestBody CrawlRequest request) {
        String url = request.getUrl();
        String query = request.getQuery();
        int depth = request.getDepth();

        List<String> matches = new ArrayList<>();
        matches.add("Match at: " + url);
        return matches;
    }
}
