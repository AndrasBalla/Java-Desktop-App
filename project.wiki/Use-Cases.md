* [Use Case 1 Person](https://github.com/1dv430/ab223sq-project/wiki/Use-Cases#use-case-1-person)
* [Use Case 2 Buss](https://github.com/1dv430/ab223sq-project/wiki/Use-Cases#use-case-2-buss)
* [Use Case 3 Linje](https://github.com/1dv430/ab223sq-project/wiki/Use-Cases#use-case-3-linje)
* [Use Case 4 Stop](https://github.com/1dv430/ab223sq-project/wiki/Use-Cases#use-case-4-stop)
* [Use Case 5 Biljett](https://github.com/1dv430/ab223sq-project/wiki/Use-Cases#use-case-5-biljett)
* [Use Case 6 Linje Databas](https://github.com/1dv430/ab223sq-project/wiki/Use-Cases#use-case-6-linje-databas)
* [Use Case 7 Buss Databas](https://github.com/1dv430/ab223sq-project/wiki/Use-Cases#use-case-7-buss-databas)
* [Use Case 8 Biljett Databas](https://github.com/1dv430/ab223sq-project/wiki/Use-Cases#use-case-8-biljett-databas)
* [Use Case 9 Chaufför Databas](https://github.com/1dv430/ab223sq-project/wiki/Use-Cases#use-case-9-chauff%C3%B6r-databas)
* [Use Case 10 UI Window](https://github.com/1dv430/ab223sq-project/wiki/Use-Cases#use-case-10-ui-window)
* [Use Case 11 UI NavBar](https://github.com/1dv430/ab223sq-project/wiki/Use-Cases#use-case-11-ui-navbar)
* [Use Case 12 UI Overview](https://github.com/1dv430/ab223sq-project/wiki/Use-Cases#use-case-12-ui-overview)
* [Use Case 13 UI Garage](https://github.com/1dv430/ab223sq-project/wiki/Use-Cases#use-case-13-ui-garage)
* [Use Case 14 UI Personal](https://github.com/1dv430/ab223sq-project/wiki/Use-Cases#use-case-14-ui-personal)
* [Use Case 15 UI Linjer](https://github.com/1dv430/ab223sq-project/wiki/Use-Cases#use-case-15-ui-linjer)
* [Use Case 16 UI Biljett](https://github.com/1dv430/ab223sq-project/wiki/Use-Cases#use-case-16-ui-biljett)
* [Use Case 17 UI Boka Biljett](https://github.com/1dv430/ab223sq-project/wiki/Use-Cases#use-case-17-ui-boka-biljett)
* [Use Case 18 UI Detaljerad Vy](https://github.com/1dv430/ab223sq-project/wiki/Use-Cases#use-case-18-ui-detaljerad-vy)

## Use Case 1 Person

Huvudsaklig användare: System

Kriterier: UI, Biljett

### Use Case 1.2 Passagerare 

Huvudsaklig användare: Arbetare eller Kund

Händelse förlopp: 

1. Användaren anger namn och person nummer vid biljett bokning
1. Användaren trycker på knappen beställ.

Alternativ händelse förlopp:

1. Namnen eller person numret är felaktig och systemet ber om en ny. 

### Use Case 1.2 Chaufför  

Huvudsaklig användare: Arbetare

Händelse förlopp: 

1. Öppnar panelen _Personnel_
1. Användaren anger namn ,person nummer och chaufför id.
1. Användaren trycker på knappen _Add_.

Alternativ händelse förlopp:

1. Namnen eller person numret är felaktig och systemet ber om en ny. 

## Use Case 2 Buss

Huvudsaklig användare: System och Arbetare

Kriterier: UI, Chaufför(1.2)

Händelse förlopp: 

1. Öppnar panelen _Garage_
1. Användaren anger registrerings nummer, buss id och status.
1. Användaren trycker på knappen _Add_. 

Alternativ händelse förlopp:

1. Registrerings numret eller id är felaktig och systemet ber om en ny.

## Use Case 3 Linje

Huvudsaklig användare: Arbetare eller kund

Kriterier: UI, Buss(2), Stop(4), Linje Databas(6)

Händelse förlopp: 

1. Användaren går till sidan _Buss Lines_ 
1. Det finns en lista med alla linjer deras id, startpunkt och destination.
1. Användaren trycker på en av linjerna. 
1. Detaljerad vy av Linjen med alla stop.

Alternativ händelse förlopp:

1. Listan är tom.
1. Användaren anger Linje id och väljer ett Buss och trycker på knappen _Add_
1. Systemet ber om en ny Linje id om den angivna är ogiltig.

## Use Case 4 Stop

Huvudsaklig användare: Arbetare

Kriterier: UI

Händelse förlopp: 

1. Användaren går till sidan _Buss Lines_ 
1. Det finns en lista med alla linjer deras id, startpunkt och destination.
1. Användaren trycker på en av linjerna. 
1. Ange ett id , plats och namn.
1. Tryck på _Add._

Alternativ händelse förlopp:

1. Användaren angav ingen namn och kan inte Spara med en tom fält
1. Ogiltig id : systemet ber om en ny

## Use Case 5 Biljett

Huvudsaklig användare: Arbetare eller kund

Kriterier: UI, Linje(3), Stop(4), Passagerare(1.2)

Händelse förlopp: 

1. Användaren trycker på knappen Boka Biljett
1. Väljer en Linje 
1. Väljer avgång och destination 
1. Anger namn och person nummer 
1. Väljer datum
1. Trycker på knappen Boka
1. Systemet presenterar en detaljerad vy av biljetten med angivna info samt pris.

Alternativ händelse förlopp:

1. Systemet kan be om en giltig namn och person nummer
1. Alla fält måste vara ifyllda för att boka.

## Use Case 6 Linje Databas

Huvudsaklig användare: System och Arbetare

Kriterier: UI, Linje(3), Stop(4)

Händelse förlopp: 

1. Användaren trycker på knappen _Buss Lines_ 
1. Systemet hämtar information från databasen och skapar en lista med alla linjerna
1. En lista med alla Linjer presenteras på sidan 

Alternativ händelse förlopp:

1. Databasen returnera en tom sträng inga linjer presenteras

### Use Case 7 Buss Databas

Huvudsaklig användare: System och Arbetare

Kriterier: UI, Buss(2)

Händelse förlopp: 

1. Öppnar panelen Garage
1. Systemet hämtar information från databasen och skapar en lista med alla bussarna
1. Det finns en lista med alla bussarna. 

Alternativ händelse förlopp:

1. Listan är tom.

### Use Case 8 Biljett Databas

Huvudsaklig användare: System och Arbetare

Kriterier: UI, Biljett(5)

Händelse förlopp: 

1. Trycker på knappen _Tickets_
1. Systemet hämtar information från databasen och presenterar en lista.
1. Trycker på knappen Historik
1. Systemet hämtar information och visar använda biljetter(3 månader bakåt)
 
Alternativ händelse förlopp:

1. Listan är tom.

### Use Case 9 Chaufför Databas

Huvudsaklig användare: System och Arbetare

Kriterier: UI, Driver(1)

Händelse förlopp: 

1. Trycker på knappen _Personnel_
1. Systemet hämtar information från databasen och presenterar en lista.

Alternativ händelse förlopp:

1. Listan är tom.

### Use Case 10 UI Window

Huvudsaklig användare: System och Arbetare

Kriterier: -

Händelse förlopp:

1. Öppnar applikationen. 
1. En fönster visas med en meny visas på toppen.
1. En navigerings meny finns på den vänstra sidan.
1. En klocka finns längst ner i den högra hörnen.

Alternativ händelse förlopp: -

### Use Case 11 UI NavBar

Huvudsaklig användare: Användare

Kriterier: Use Case 10 UI Window

Händelse förlopp:

1. Öppnar applikationen. 
1. En fönster visas med en meny visas på toppen.
1. En navigerings meny finns på den vänstra sidan.
1. En klocka finns längst ner i den högra hörnen.
1. I navigeringsmenyn så finns det 6 knappar (Overview, Garage, Personnel, Buss lines, Tickets och Book Ticket)
1. När man trycker på knappen så visas den sidan.

Alternativ händelse förlopp: -

### Use Case 12 UI Overview

Huvudsaklig användare: System och Arbetare

Kriterier: Test Case 10 UI window

Händelse förlopp:

1. Öppnar applikationen. 
1. Som standard så visas overview skärmen när man öppnar applikationen.
1. Här kan man se notiser som användare har lagt in. 
1. Man kan lägga till notiser till fönstret för andra att se.

Alternativ händelse förlopp: -


### Use Case 13 UI Garage

Huvudsaklig användare: Användare

Kriterier: Test Case 10 UI Window, Test Case 7 Buss Database.

Händelse förlopp:

1. Öppnar applikationen. 
1. Trycker på knappen _Garage_
1. En lista med bussar visas på skärmen
1. Samt möjlighet att lägga till bussar.

Alternativ händelse förlopp: -

### Use Case 14 UI Personal

Huvudsaklig användare: Användare

Kriterier: Test Case 10 UI Window, Test Case 1 Chaufför, Test Case 9 Chaufför databas

Händelse förlopp:

1. Öppnar applikationen. 
1. Trycker på knappen _Personnel_
1. En lista med chaufförer visas på skärmen
1. Samt möjlighet att lägga till nya.

Alternativ händelse förlopp: -

### Use Case 15 UI Linjer

Huvudsaklig användare: System och Arbetare

Kriterier: Test Case 10 UI Window, Test Case 3 Linje, Test Case 6 Linjer databas

Händelse förlopp:

1. Öppnar applikationen. 
1. Trycker på knappen _Buss Lines_
1. En lista med Linjer visas på skärmen
1. Samt möjlighet att lägga till nya.

Alternativ händelse förlopp: -

### Use Case 15.2 UI Linjer

Huvudsaklig användare: System och Arbetare

Kriterier: Test Case 10 UI Window, Test Case 3 Linje, Test Case 6 Linjer databas

Händelse förlopp:

1. Öppnar applikationen. 
1. Trycker på knappen _Buss Lines_
1. En lista med Linjer visas på skärmen
1. Trycker på knappen _Detailed View_
1. Väljer ut en linje.
1. En skärm visas med en lista av buss hållplatser som tillhör den utvalda linjen.
1. Samt möjlighet att lägga till nya.

Alternativ händelse förlopp: -

### Use Case 16 UI Biljett

Huvudsaklig användare: System och Arbetare

Kriterier: Test Case 10 UI Window, Test Case 5 Biljett, Test Case 8 Biljett databas

Händelse förlopp:

1. Öppnar applikationen. 
1. Trycker på knappen _Tickets_
1. En lista med biljetter visas på skärmen

Alternativ händelse förlopp: -

### Use Case 17 UI Boka Biljett

Huvudsaklig användare: System och Arbetare

Kriterier: Biljett Databas ID 8

Händelse förlopp:

1. Öppnar applikationen. 
1. En fönster visas med en meny visas på toppen.
1. En navigerings meny finns på den vänstra sidan.
1. Tryck på knappen Boka Biljett 
1. Fyll i alla fält och tryck på knappen Submit

Alternativ händelse förlopp: -

1. I fall nån av fälten är tomma visas ett felmeddelande 
1. Eller om en av inmatningen är ogiltig visas ett felmeddelande 

### Use Case 18 UI detaljerad vy

Huvudsaklig användare: System och Arbetare

Kriterier: -

Händelse förlopp:

1. Öppnar applikationen. 
1. En fönster visas med en meny visas på toppen.
1. En navigerings meny finns på den vänstra sidan.
1. Tryck på knappen Buss Lines och sen Detailed View 
1. här får man välja en Linje 
1. Då visas det en lista med alla stop på den linjen.
