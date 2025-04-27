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
No ambiente de testes é possível verificar se a fonte de dados foi alterada, fazendo validação dos resultados com a resposta do endpoint.

Na IDE execute o arquivo AwardIntegrationTest em:
````
src/test/java/com.osvaldo.gra.integration/
````
Para alterar os dados, acesse o arquivo .json em ``src/main/java/resources/expected_award_intervals.json``

