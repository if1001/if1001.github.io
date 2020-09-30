# IF1001 - Programação para Dispositivos Móveis - 2020.3

## Semana 6 - Data Storage (Preferences & Room)

### Objetivo

O objetivo desta semana é compreender conceitos importantes relacionados ao armazenamento de dados em Android. Em particular, o uso do mecanismo de `SharedPreferences` e a biblioteca `Room`, usada para simplificar a persistência de dados em SQLite. Adicionalmente, vamos discutir a classe `LiveData` para guardar dados 'observáveis'.

Ao fim da semana, você deve ser capaz de responder às seguintes perguntas: 

- Quando devo armazenar dados em `SharedPreferences` vs. `Room`?
- De que forma `Room` melhora a experiência de usar bancos de dados em Android, comparado ao uso de `SQLiteDatabase`?

### Material usado em sala

- [Data Management app](https://github.com/if1001/if1001.github.io/tree/master/2020-09-30/DataMgmt)

### Atividades da Semana

- [Android Room with a View - Kotlin](https://codelabs.developers.google.com/codelabs/android-room-with-a-view-kotlin/#0)
- [Database Views With Room for Android](https://www.raywenderlich.com/10194335-database-views-with-room-for-android)
- [LiveData Tutorial for Android: Deep Dive](https://www.raywenderlich.com/10391019-livedata-tutorial-for-android-deep-dive)

### Leitura Obrigatória
- [Save key-value data](https://developer.android.com/training/data-storage/shared-preferences)
- [Save data in a local database using Room](https://developer.android.com/training/data-storage/room)
- [LiveData Overview](https://developer.android.com/topic/libraries/architecture/livedata?hl=en)

### Material complementar

- **`SharedPreferences`** 
  - [Android Persistence with preferences and files - Tutorial](https://www.vogella.com/tutorials/AndroidFileBasedPersistence/article.html)

- **`Room`** 
  - [7 Steps To Room](https://medium.com/androiddevelopers/7-steps-to-room-27a5fe5f99b2)
  - [Room Persistence Library](https://developer.android.com/topic/libraries/architecture/room)
  - [Room + Time](https://medium.com/androiddevelopers/room-time-2b4cf9672b98)
  - [Incrementally migrate from SQLite to Room](https://medium.com/androiddevelopers/incrementally-migrate-from-sqlite-to-room-66c2f655b377)
  - [Coroutines With Room Persistence Library](https://www.raywenderlich.com/7414647-coroutines-with-room-persistence-library)

- **`LiveData`** 
  - [When and why to use Android LiveData](https://proandroiddev.com/when-and-why-to-use-android-livedata-93d7dd949138)
  - [Understanding LiveData made simple](https://medium.com/mobile-app-development-publication/understanding-live-data-made-simple-a820fcd7b4d0)


- **`Flow`** 
  - [Learn advanced coroutines with Kotlin Flow and LiveData](https://codelabs.developers.google.com/codelabs/advanced-kotlin-coroutines/index.html?index=..%2F..index#0)
  - [LiveData with Coroutines and Flow — Part I: Reactive UIs](https://medium.com/androiddevelopers/livedata-with-coroutines-and-flow-part-i-reactive-uis-b20f676d25d7)
  - [LiveData with Coroutines and Flow — Part II: Launching coroutines with Architecture Components](https://medium.com/androiddevelopers/livedata-with-coroutines-and-flow-part-ii-launching-coroutines-with-architecture-components-337909f37ae7)
  - [Kotlin Flow on Android — Quick guide](https://proandroiddev.com/kotlin-flow-on-android-quick-guide-76667e872166)

- **Vídeos**
  - [Android Jetpack: Room](https://www.youtube.com/watch?v=SKWh4ckvFPM)
  - [The Room in the House (Android Dev Summit '18)](https://www.youtube.com/watch?v=sU-ot_Oz3AE)
  - [O que há de novo na Room (Android Dev Summit 2019)](https://www.youtube.com/watch?v=_aJsh6P00c0)
  - [Build a Modular Android App Architecture (Google I/O'19)](https://www.youtube.com/watch?v=PZBg5DIzNww)
  - [Android Jetpack: KTX - Sweeter Kotlin Android Development](https://www.youtube.com/watch?v=r_19VZ0xRO8&list=PLWz5rJ2EKKc9mxIBd0DRw9gwXuQshgmn2&index=4)
  - [Android Jetpack: LiveData](https://www.youtube.com/watch?v=OMcDk2_4LSk)
  - [Fun with LiveData (Android Dev Summit '18)](https://www.youtube.com/watch?v=2rO4r-JOQtA)
  - [Lifecycle, LiveData, ViewModels - The inner wiring by Florina Muntenescu, Google EN](https://www.youtube.com/watch?v=U6Lgym1XEBI)
  - [LiveData com coroutines e Flow (Android Dev Summit 2019)](https://www.youtube.com/watch?v=B8ppnjGPAGE)
  - [KotlinConf 2019: Asynchronous Data Streams with Kotlin Flow by Roman Elizarov](https://www.youtube.com/watch?v=tYcqn48SMT8)
  
- **Podcasts**
  - [Fragmented 095: Room Databases with Florina Muntenescu](https://fragmentedpodcast.com/episodes/95/)
  - [Fragmented 115: Architecture Components with Akshay Chordiya](https://fragmentedpodcast.com/episodes/115/)