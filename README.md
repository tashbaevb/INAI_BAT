# 2D RPG "Crime Solving Adventure BAT"

Welcome to the 2D RPG "Crime Solving Adventure BAT"! In this exciting game you will find yourself in a mysterious city where your task is to investigate a crime and find the culprit. Use your detective skills, interview the residents, explore the houses and uncover the mysteries of this world.

![Game Screenshot](/src/main/resources/com/example/inai_bat/images/screenshots/Bildschirmfoto%202023-12-23%20um%2003.10.26.png)
![Game Screenshot](/src/main/resources/com/example/inai_bat/images/screenshots/Bildschirmfoto%202023-12-23%20um%2003.46.39.png)
![Game Screenshot](/src/main/resources/com/example/inai_bat/images/screenshots/Bildschirmfoto%202023-12-23%20um%2003.45.54.png)
![Game Screenshot](/src/main/resources/com/example/inai_bat/images/screenshots/Bildschirmfoto%202023-12-30%20um%2007.43.23.png)


## Setup instructions

1. **System Requirements:**
    - Java 8 or higher
    - JavaFX
    - MySQL
    - FXGL

2. **Dependency Setup:**
    - Make sure you have Java with JavaFX support installed.
    - Create a MySQL database and import the provided SQL script (`inai_bat.sql`).

3. **Game Launch:**
    - Run the project using your development environment that provided you with the code, or run `java -jar INAI_BAT.jar` at the command line.

## Project structure

```plaintext
├── README.md
├── inai_bat.sql
├── mvnw
├── mvnw.cmd
├── out
│   └── artifacts
│       └── INAI_BAT
│           └── INAI_BAT.jar
├── pom.xml
├── src
│   └── main
│       ├── java
│       │   ├── com
│       │   │   └── example
│       │   │       └── inai_bat
│       │   │           ├── MainApplication.java
│       │   │           ├── config
│       │   │           │   ├── JdbcDao.java
│       │   │           │   └── MusicPlayer.java
│       │   │           ├── controller
│       │   │           │   ├── LoginController.java
│       │   │           │   ├── MainMenuController.java
│       │   │           │   ├── RegisterController.java
│       │   │           │   ├── firstMap
│       │   │           │   ├── pauseMenu
│       │   │           │   ├── secondMap
│       │   │           │   └── thirdMap
│       │   │           ├── entity
│       │   │           │   ├── KgPlayer.java
│       │   │           │   └── Player.java
│       │   │           ├── kgController
│       │   │           ├── service
│       │   │           │   ├── TextAnimator.java
│       │   │           │   └── TextOutput.java
│       │   │           └── views
│       │   │               └── ParallaxBackground.java
│       │   └── module-info.java
│       └── resources
│           ├── com
│           └── player
└── target
```


## 

Thank you for participating in the 2D RPG "Crime Solving Adventure BAT"! Your support and interest in the game are important to us. Enjoy your journey in the world of detective mysteries!

Developers:
- https://github.com/tashbaevb
- https://github.com/Albrut

If you have any questions, feedback or suggestions, feel free to contact us:

- Email: tashbaevvb@gmail.com
- LinkedIn: https://www.linkedin.com/in/baitur-tashbaev/

Thanks again, and we hope you enjoy your adventure in the world of Crime Solving Adventure BAT!
