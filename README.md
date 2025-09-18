# NotesServiceTask

## Zadanie techniczne

### Stwórz prosty serwis REST do zarządzania notatkami. Każda notatka należy do konkretnego autora. Serwis powinien być zaimplementowany w języku Java 17+, z wykorzystaniem Spring Boot, Spring Data JPA oraz bazy danych H2.


### 1.Encje:
#### Author
   - id — Long, autoinkrementacja
   - name — String, pole obowiązkowe


#### Note
- id — Long, autoinkrementacja
- title — String, pole obowiązkowe
- content — String, pole opcjonalne
- createdAt — LocalDateTime, ustawiane automatycznie przy tworzeniu
- author — relacja ManyToOne z Author, pole obowiązkowe


### 2. Wymagana funkcjonalność API:
#### Authors
- POST /authors — utworzenie nowego autora
- GET /authors — pobranie listy wszystkich autorów
- GET /authors/{id} — pobranie autora po ID


#### Notes
- POST /notes — utworzenie nowej notatki
- GET /notes — pobranie listy wszystkich notatek
- GET /notes/{id} — pobranie notatki po ID
- DELETE /notes/{id} — usunięcie notatki po ID


### 3. Wymagania obowiązkowe:
- Użycie Spring Boot
- Użycie Swagger
- Użycie Spring Data JPA
- Baza danych: H2
- Obsługa błędów
- Budowanie projektu za pomocą Maven


#### Uwagi dodatkowe:
- Projekt można utworzyć przy pomocy Spring Initializr.