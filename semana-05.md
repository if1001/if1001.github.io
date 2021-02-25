# IF1001 - Programação para Dispositivos Móveis - 2020.1

## Semana 5 - Background Processing

### Objetivo

O objetivo desta semana é compreender conceitos importantes relacionados ao conceito de *background threads* em Android, em particular a noção de *Main/UI Thread*, a importância de rodar tarefas longas em *background threads* e como gerenciar *Threads* diretamente e via *coroutines*. 

Ao fim da semana, você deve ser capaz de responder às seguintes perguntas: 

- Quais são as tarefas de responsabilidade da *Main/UI Thread* em Android?
- Por qual razão não é possível atualizar a UI fora da *Main/UI Thread*?
- O que torna *coroutines* uma solução mais "barata" do que usar threads diretamente?

### Código escrito durante a aula

- [BackgroundProcessing App](https://github.com/if1001/if1001.github.io/tree/master/2021-02-24/BackgroundProcessing)

### Tutoriais recomendados para complementar aprendizagem

- [Use Kotlin Coroutines in your Android App](https://codelabs.developers.google.com/codelabs/kotlin-coroutines/#0)
- [Kotlin Coroutines Tutorial for Android: Getting Started](https://www.raywenderlich.com/1423941-kotlin-coroutines-tutorial-for-android-getting-started)

### Leitura Obrigatória
- [Guide to background processing](https://developer.android.com/guide/background?hl=en)
- [Kotlin coroutines on Android](https://developer.android.com/kotlin/coroutines)

### Material complementar

- **Threads** 
  - [Running Android tasks in background threads](https://developer.android.com/guide/background/threading?hl=en)
  - [Communicate with the UI thread](https://developer.android.com/training/multiple-threads/communicate-ui)
  - [Threading in Android - A detailed walkthrough on Android threading](https://medium.com/better-programming/threading-in-android-129b8688436a)
  - [Understanding `Activity.runOnUiThread()`](https://medium.com/@yossisegev/understanding-activity-runonuithread-e102d388fe93)
  - [ThreadPoster: Explicit and Unit Testable Multi-Threading in Android](https://www.techyourchance.com/threadposter-explicit-unit-testable-multi-threading-library-for-android/)
  - [Difference between the main thread and UI thread](https://stackoverflow.com/questions/40784584/difference-between-the-main-thread-and-ui-thread)

- **Coroutines** 
  - [Use coroutines in common Android use cases](https://developer.android.com/courses/pathways/android-coroutines)
  - [Coroutines Guide - Kotlin docs](https://kotlinlang.org/docs/reference/coroutines/coroutines-guide.html)
  - [Mastering Kotlin Coroutines In Android - Step By Step Guide](https://blog.mindorks.com/mastering-kotlin-coroutines-in-android-step-by-step-guide)
  - [Kotlin Coroutines in Android Reference Guide](https://www.techyourchance.com/kotlin-coroutines-android-reference-guide/)
  - [Kotlin Coroutines And Threading Fundamentals](https://proandroiddev.com/kotlin-coroutines-and-threading-fundamentals-9fd0130437ae)
  - [Kotlin Coroutines in Complex Features](https://www.techyourchance.com/kotlin-coroutines-in-complex-scenarios/)
  - [A Bottom-Up View of Kotlin Coroutines](https://www.infoq.com/articles/kotlin-coroutines-bottom-up/)

- **Concorrência**
  - [Notes on structured concurrency, or: Go statement considered harmful](https://vorpus.org/blog/notes-on-structured-concurrency-or-go-statement-considered-harmful/)

- **Vídeos**
  - [Explained - Android UI thread/main thread](https://www.youtube.com/watch?v=kpFwxJFYnOo)
  - [Main Thread vs Background Thread - Developing Android Apps](https://www.youtube.com/watch?v=FWwMA-sdOgk)
  - [Understand Kotlin Coroutines on Android (Google I/O'19)](https://www.youtube.com/watch?v=BOHK_w09pVA)
  - [Kotlin Coroutines 101 - Android Conference Talks](https://www.youtube.com/watch?v=ZTDXo0-SKuU)
  - [Android Coroutines: How to manage async tasks in Kotlin](https://www.youtube.com/watch?v=6manrgTPzyA)
  - [Kotlin Coroutines](https://www.youtube.com/watch?v=BXwuYykIxbk)
  - [KotlinConf 2019: Coroutines! Gotta catch 'em all! by Florina Muntenescu & Manuel Vivo](https://www.youtube.com/watch?v=w0kfnydnFWI)
  - [Kotlin Coroutines: Explore what are coroutines in kotlin. Threads vs. Coroutines](https://www.youtube.com/watch?v=C38lG2wraoo)
  - [COROUTINES IN KOTLIN 1.3 ► 4 concepts you MUST KNOW](https://www.youtube.com/watch?v=fHG1mepeOCI&feature=emb_title)
  - [Kotlin Coroutines Beginner Example (Android)](https://www.youtube.com/watch?v=F63mhZk-1-Y)
  - [Kotlin Coroutines playlist](https://www.youtube.com/playlist?list=PLQkwcJG4YTCQcFEPuYGuv54nYai_lwil_)
  
- **Podcasts**
  - [AndroIdiots Podcast 7 : Unmasking Kotlin Coroutines](https://medium.com/androidiots/androidiots-podscast-7-unmasking-kotlin-coroutines-ce2711269d3b)
  - [AndroIdiots Podcast 16: Android Process LifeCycle](https://medium.com/androidiots/androidiots-podcast-16-android-process-lifecycle-5cdba10fa431)
  - [Talking Kotlin: Coroutines with Roman Elizarov](https://talkingkotlin.com/coroutines-with-roman-elizarov/)
  - [Coroutines in Kotlin with Filip Babić – Podcast S10 E04](https://www.raywenderlich.com/9837139-coroutines-in-kotlin-with-filip-babic-podcast-s10-e04)