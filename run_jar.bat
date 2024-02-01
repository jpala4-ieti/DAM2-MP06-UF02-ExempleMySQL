@echo off
java --add-opens java.base/java.lang=ALL-UNNAMED ^
     --add-opens java.base/java.nio=ALL-UNNAMED ^
     --add-opens java.base/java.util=ALL-UNNAMED ^
     -jar .\target\project-name-1.0.0.jar
