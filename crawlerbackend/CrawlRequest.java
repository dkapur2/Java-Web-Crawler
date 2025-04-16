package com.dk.crawlerbackend;

public class CrawlRequest {
    private String url;
    private String query;
    private int depth;

    public String getUrl() {
        return url;
    }

    public String getQuery() {
        return query;
    }

    public int getDepth() {
        return depth;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}
