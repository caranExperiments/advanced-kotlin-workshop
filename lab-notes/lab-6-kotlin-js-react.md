# 🖥 Lab 6: Building a Basic React App Using Kotlin/JS

## Objectives
1. Create a new Kotlin/JS React application w/ Kotlin Gradle buildscripts
2. Review Gradle project configuration
3. Deploy project to Browser in continuous mode and observe hot reload functionality
4. Update document title using DOM api bindings
5. Modify `StyleSheet` object to customize styling of project
6. Update `WelcomeState` to include an `val input: String` and `val languages: List<String>` properties
7. Add `"kotlin"` as the single initial language when setting the initial `WelcomeState`
8. Update the text input `onChangeFunction` so it updates `WelcomeState.input`
9. Add a button next to the text input that, when clicked, adds the input text to `WelcomeState.languages`
10. Below the text input and button, and a label saying "Programming Languages"
11. Create a new `ProgrammingLanguagesList` class that extends `RComponent`
12. Create a `LanguagesListProps` interface containing a single `var langauges: List<String>` property
13. Update `ProgrammingLanguagesList` class declaration to take `LanguageListProps` as its props type
14. Within `ProgrammingLanguagesList.render()` iterate over `props.langauges` and draw a `p{}` for each string
15. Below the "Programming Languages" label, render the new `ProgrammingLanguagesList` component using a call to `child()`
16. Generate executable using `browserDevelopmentWebpack` Gradle Task

## 💡 Helpful Resources
- [Get Started with Kotlin/JS for React](https://kotlinlang.org/docs/js-get-started.html)
- [Codelab: Building Web Applications with React and Kotlin/JS](https://play.kotlinlang.org/hands-on/Building%20Web%20Applications%20with%20React%20and%20Kotlin%20JS/01_Introduction)
- [Generation of External Dependencies with dukat](https://kotlinlang.org/docs/js-external-declarations-with-dukat.html)
- [React Hello World](https://reactjs.org/docs/hello-world.html)