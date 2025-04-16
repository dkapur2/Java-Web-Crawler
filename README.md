# Java Web Crawler API

This is a lightweight Java-based web crawler built with Spring Boot and JSoup. It powers a frontend app that allows users to input a starting URL, a search query, and a max crawl depth — and returns pages that match the query.

### 🌐 Live Demo
[Frontend](https://dkapur.com/crawler) — powered by Vercel  
[Backend API](https://your-backend.onrender.com/api/crawl) — hosted on Render *(update with your real link)*

---

## 🚀 Features

- Recursively crawls websites starting from a user-defined URL
- Matches pages that contain a given search term
- Depth-limited (up to 6 levels deep)
- Returns matching page URLs in JSON format

---

## 🛠 Technologies Used

- Java 17
- Spring Boot
- JSoup
- Maven
- Render (backend deployment)
- Vercel (frontend deployment)

---

## 📦 API Usage

**POST** `/api/crawl`

```json
{
  "url": "https://en.wikipedia.org/",
  "query": "AI",
  "depth": 3
}
```

**Response:**

```json
[
  "Match at: https://en.wikipedia.org/wiki/Artificial_intelligence",
  "Match at: https://en.wikipedia.org/wiki/Machine_learning"
]
```

---

## 📁 Project Structure

```
src/
├── main/
│   └── java/com/dk/crawler/
│       └── CrawlerbackendApplication.java
└── test/
```

---

## 🧑‍💻 How to Run Locally

```bash
./mvnw spring-boot:run
```

---

## ✍️ Author

[Dhruv Kapur](https://dkapur.com)
