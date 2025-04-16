package com.dk.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import java.util.*;

@SpringBootApplication
public class CrawlerBackendApp {
    public static void main(String[] args) {
        SpringApplication.run(CrawlerBackendApp.class, args);
    }
}

@RestController
@RequestMapping("/api")
class CrawlerController {

    @PostMapping(value = "/crawl", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> crawl(@RequestBody CrawlRequest request) {
        Set<String> visited = new HashSet<>();
        List<String> results = new ArrayList<>();
        crawlRecursive(request.url(), request.query(), request.depth(), 1, visited, results);
        return ResponseEntity.ok(results);
    }

    private void crawlRecursive(String url, String query, int maxDepth, int level, Set<String> visited, List<String> results) {
        if (level > maxDepth || visited.contains(url)) return;

        try {
            Document doc = Jsoup.connect(url).timeout(5000).get();
            visited.add(url);

            String text = doc.body().text();
            if (text.toLowerCase().contains(query.toLowerCase())) {
                results.add("Match at: " + url);
            }

            for (Element link : doc.select("a[href]")) {
                String next = link.absUrl("href");
                if (!visited.contains(next)) {
                    crawlRecursive(next, query, maxDepth, level + 1, visited, results);
                }
            }

        } catch (Exception e) {
            // Skip failures silently
        }
    }
}

record CrawlRequest(String url, String query, int depth) {}
