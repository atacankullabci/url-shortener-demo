# url-shortener-demo

A URL shortener in hexagonal (ports and adapters) architecture with Spring Boot. The domain has no Spring dependency; storage is a swappable adapter.

## Run

```bash
./mvnw spring-boot:run
```

```bash
# shorten
curl -X POST localhost:8080/api/urls -H "Content-Type: application/json" -d '{"longUrl":"https://example.com/some/long/path"}'
# → 201 Created, {"shortUrl": "<base-url>1"}

# redirect
curl -i localhost:8080/1
# → 302 Found, Location: https://example.com/some/long/path  (404 if unknown)
```

## Structure

```
domain/                 framework-free: UrlShortenerService, ShortUrl, Base62
domain/port/out/        ShortUrlRepository (outbound port)
adapter/in/web/         REST controller
adapter/out/memory/     ConcurrentHashMap repository
adapter/out/jpa/        Spring Data JPA repository (H2), entity + mapper
config/BeanConfig       wires the domain into Spring and picks the adapter
```

Choose the storage adapter in `application.properties`:

```properties
url.shortener.repository=memory   # or: jpa
```

## Design decisions

| Topic | Decision | Why |
|---|---|---|
| Short code | Sequential ID (`AtomicLong`) encoded in Base62 | Short, collision-free codes with no retry loop |
| Domain isolation | Domain classes have no Spring annotations; `BeanConfig` creates them | Business logic can be tested and reused without the framework |
| Adapter choice | `@ConditionalOnProperty` | Switch storage without touching the domain |
| Redirect | `302 Found` | Lets the service keep seeing (and later count) each visit; `301` would be cached by browsers |

## Known limits / next steps

- The ID counter lives in memory, so with the JPA adapter it restarts from 0 after a restart and would collide with stored codes. Next step: take the ID from a database sequence.
- Domain unit tests for `Base62` and the service (encode/decode round trip, unknown code).
- Return `Optional` instead of `null` for an unknown code.
