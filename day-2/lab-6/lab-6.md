# 🖥 Lab 6: Building a Joke Service with Ktor

## Objectives
1. Create a new Ktor server project in IntelliJ with the following Ktor Features
   1. Routing
   2. Basic Authentication
   3. Default Headers
   4. Call Logging
   5. HTML DSL
   6. Content Negotiation
   7. kotlinx.serialization
2. Enable auto reload
   1. Go to Run Configurations -> VM Options and add `-Dio.ktor.development=true`
   2. Update `embeddedServer()` config to include `watchPaths = listOf("classes")`
3. Deploy the project in continuous development mode and observe auto reload of changes after rebuild
4. Configure status pages for `NotFound` and `Unauthorized` status
5. Configure basic name/password authentication
6. Configure DefaultHeaders
7. Configure CallLogging
8. Configure json ContentNegotiation
9. Configure routing
   1. Add `/` route and respond with `Hello World!`
   2. Add `/joke` route behind authentication
      1. Respond be returning an instance of a `Joke` class

```kotlin
@Serializable
data class Joke(
    val setup: String,
    val punchline: String
)
```


## 💡 Helpful Resources
- [Ktor Site](https://ktor.io/)
- [Creating a New Ktor Project](https://ktor.io/docs/intellij-idea.html)
- [Creating a Server](https://ktor.io/docs/create-server.html)
- [Routing in Ktor](https://ktor.io/docs/routing-in-ktor.html)
- [Handling Requests](https://ktor.io/docs/requests.html)
- [Status Pages](https://ktor.io/docs/status-pages.html)
- [Basic Authentication](https://ktor.io/docs/basic.html)
