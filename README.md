## Projeto Golden Raspberry Awards - Intervalos de Prêmios
Este projeto calcula e disponibiliza os intervalos entre vitórias 
consecutivas de produtores no Golden Raspberry Awards.

### Pré requisitos
- Java 17
- Maven

### Técnologias utilizadas
- Java 17
- Spring Boot
- JUnit 5
- H2 Database

### Endpoint
- /awards/intervals

### Como utilizar (API)
Na IDE execute o arquivo GraApplication.java em:
````
src/main/java/com.osvaldo.gra/
````
o endpoint está em ``localhost:8080/awards/intervals``.

Para alterar os dados, acesse o arquivo .csv em ``src/main/java/resources/movielist.csv``


### Como utilizar (Test)
No ambiente de testes é possível verificar se algum produtor retornou no menor intervalo, no maior intervalo e se o valor especificado está em menores intervalos

Na IDE execute o arquivo AwardIntegrationTest em:
````
src/test/java/com.osvaldo.gra/
````

Para alterar os dados, acesse o arquivo .sql em ``src/main/java/resources/teste-data.sql``

