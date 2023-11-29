# Algo3
Trabajos prácticos de la materia Algoritmos y Programación 3 de la Facultad de Ingeniería de la Universidad de Buenos Aires

[Link a nuestro drive](https://drive.google.com/drive/folders/1HU6PrcDPuZ-awIRpnUNtXc-FN-g0Q1ba?usp=sharing)

## Requisitos previos
- Java 17
- Maven 3.9.2

## Cómo correrlo
1. Abrir una terminal en la carpeta principal del proyecto
2. Ejecutar el comando "mvn compile" para compilar
3. Al terminar el anterior, ejecutar el comando "java -cp "./target/classes" org.fiuba.algotres.JuegoTerminal" para correr el proyecto por consola o "mvn clean javafx:run" para correrlo usando javafx

## Aclaraciones

### Consola
- Los emojis, en ciertas consolas, no se muestran y pueden llegar a aparecer como "??"
- El juego tiene una función de limpieza de consola que en casos muy particulares puede no funcionar (consolas de IDE, Git Bash, entre otros) o incluso mostrar un caracter raro

### JavaFX
- Los nombres de las imagenes de pokemons deben respetar el formato nombre-back.gif y nombre-front.gif
- El nombre de las imagenes de entidades como pokemons y climas debe ser el mismo que se encuentra en el json del que se carga dicha información