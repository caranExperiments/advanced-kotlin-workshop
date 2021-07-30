# 🖥 Lab 7: Packaging Your Ktor Service

## Objectives
1. Apply the Gradle Application Plugin to the project
2. Package the application using the `installDist` Gradle task
3. Run the executable from the command line to deploy your server locally
4. Use curl or the browser to verify your service is working

## Hints
`curl http://0.0.0.0:8080`
`curl http://0.0.0.0:8080/joke`
`curl -u password:password http://0.0.0.0:8080/joke`

## Challenge 1
Deploy your application to Heroku

1. Setup Heroku CLI on your machine
2. Assign `embeddedServer` port from env variable if exists `val port = System.getenv("PORT").toIntOrNull() ?: 8080`
3. Add `Procfile` with `web: ./build/install/<project name>/bin/<project name>
4. Add `app.json` with the following info
```json
{
  "name": "Hello Ktor World!",
  "description": "A sample Ktor project",
  "image": "heroku/java",
  "addons": [ "heroku-postgresql" ]
}
```

4. cd into working directory and run `heroku create <new heroku project name>`
5. Run heroku git:remote -a <new heroku project name>
6. git push heroku main

## Challenge 2
- Follow [these instructions](https://ktor.io/docs/docker.html) to deploy/run your app via Docker

## 💡 Helpful Resources
- [Gradle Application Plugin](https://ktor.io/docs/gradle-application-plugin.html)
- [Publish via Heroku](https://dev.to/kotlin/publishing-server-side-kotlin-applications-ktor-on-heroku-2ce4)
- [Heroku Deployment](https://ktor.io/docs/heroku.html)
- [Package as Docker Container](https://ktor.io/docs/docker.html)
- [Deploy to Google App Engine](https://ktor.io/docs/google-app-engine.html)