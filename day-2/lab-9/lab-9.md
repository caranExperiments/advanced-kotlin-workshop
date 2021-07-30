# 🖥 Lab 9: Building a Kotlin Multiplatform Application

## Objectives
1. Use Ktor to make a network request to the Pokemon api `https://pokeapi.co/api/v2/pokemon/?limit=151`
3. Use kotlinx.serialization to deserialize the response
4. Use expect/actual to create a presenter class makes the network request and exposes a `StateFlow<List<Pokemon>>`
5. Consume this presenter from both Android and iOS apps to display the results of the network request

## 💡 Helpful Resources
- [Pokemon API](https://pokeapi.co/docs/v2#pokemon)
- [Setting Up a Ktor Client](https://ktor.io/docs/client.html)
- [kotlinx.serialization](https://github.com/Kotlin/kotlinx.serialization)
- [kotlinx Libraries on GitHub](https://github.com/kotlin)
- [Kotlin Multiplatform Libraries List](https://github.com/AAkira/Kotlin-Multiplatform-Libraries)