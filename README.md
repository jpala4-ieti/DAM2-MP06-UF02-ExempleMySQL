# Exemple de JPA amb MySQL #

### Preparació de la base de dades ###
Podeu arrancar una instància de MySQL amb Docker
```bash
docker run --name hibernate-mysql-exemple -it -e MYSQL_ROOT_PASSWORD=pass -e MYSQL_DATABASE=exemplemysql -e MYSQL_USER=usuari -e MYSQL_PASSWORD=password -p 3306:3306 mysql
```

I aturar-la i destuir-la amb
```bash
docker stop hibernate-mysql-exemple

docker rm hibernate-mysql-exemple
```

En cas de no eliminar-se ho podem forçar amb
```bash
docker rm -f hibernate-mysql-exemple
```


### Compilació i funcionament ###
Cal el 'Maven' per compilar el projecte
```bash
mvn clean
mvn compile
mvn test
mvn clean compile test
```

Per executar el projecte a Windows cal
```bash
.\run.ps1 com.project.exemplemysql.Main
```

Per executar el projecte a Linux/macOS cal
```bash
./run.sh com.project.exemplemysql.Main
```

<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-core</artifactId>
    <version>4.3.11.Final</version>
</dependency>

<dependency>
    <groupId>org.hibernate.orm</groupId>
    <artifactId>hibernate-core</artifactId>
    <version>6.4.2.Final</version>
</dependency>
