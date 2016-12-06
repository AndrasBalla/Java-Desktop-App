* [Test Case 1 Person](https://github.com/1dv430/ab223sq-project/wiki/Test-Cases#test-case-1-person)
* [Test Case 2 Buss](https://github.com/1dv430/ab223sq-project/wiki/Test-Cases#test-case-2-buss)
* [Test Case 3 Linje](https://github.com/1dv430/ab223sq-project/wiki/Test-Cases#test-case-3-linje)
* [Test Case 4 Stop](https://github.com/1dv430/ab223sq-project/wiki/Test-Cases#test-case-4-stop)
* [Test Case 5 Biljett](https://github.com/1dv430/ab223sq-project/wiki/Test-Cases#test-case-5-biljett)
* [Test Case 6 Linje Databas](https://github.com/1dv430/ab223sq-project/wiki/Test-Cases#test-case-6-linje-databas)
* [Test Case 7 Buss Databas](https://github.com/1dv430/ab223sq-project/wiki/Test-Cases#test-case-7-buss-databas)
* [Test Case 8 Biljett Databas](https://github.com/1dv430/ab223sq-project/wiki/Test-Cases#test-case-8-biljett-databas)
* [Test Case 9 Chaufför Databas](https://github.com/1dv430/ab223sq-project/wiki/Test-Cases#test-case-9-chaufför-databas)
* [Test Case 10 UI window](https://github.com/1dv430/ab223sq-project/wiki/Test-Cases#test-case-10-ui-window)
* [Test Case 11 UI NavBar](https://github.com/1dv430/ab223sq-project/wiki/Test-Cases#test-case-11-ui-navbar)
* [Test Case 12 UI Overview](https://github.com/1dv430/ab223sq-project/wiki/Test-Cases#test-case-12-ui-overview)
* [Test Case 13 UI Garage](https://github.com/1dv430/ab223sq-project/wiki/Test-Cases#test-case-13-ui-garage)
* [Test Case 14 UI Personal](https://github.com/1dv430/ab223sq-project/wiki/Test-Cases#test-case-14-ui-personal)
* [Test Case 15 UI Linjer](https://github.com/1dv430/ab223sq-project/wiki/Test-Cases#test-case-15-ui-linjer)
* [Test Case 16 UI Biljett](https://github.com/1dv430/ab223sq-project/wiki/Test-Cases#test-case-16-ui-biljett)
* [Test Case 17 UI Boka Biljett](https://github.com/1dv430/ab223sq-project/wiki/Test-Cases#test-case-17-ui-boka-biljett)
* [Test Case 18 UI Detaljerad vy](https://github.com/1dv430/ab223sq-project/wiki/Test-Cases#test-case-18-ui-detaljerad-vy)

## Test Case 1 Person

Test Data: 
* String id: Första 4 nummer måste vara en giltig födelseår för någon som är mellan 10-100 år gammal, nästa 4 nummer måste vara en giltig månad och dag. De sista fyra måste vara nummer mellan 0-9.
* String name: En sträng med för och efternamn.

Preconditions: None

Test Steg: 
* Skapa en giltig Objekt både som Driver och Passenger.
* Skapa en ogiltig objekt. 

Förväntad utfall:
* Objektet sparas i databasen och är redo för användning.
* Felmeddelande visas på skärmen.

### Test Case 1.2 Passenger

Test Data: Giltig Biljett(5) 

Preconditions: Biljett(5). TBA

Test Steg: 
* Skapa en giltig passagerare
* Skapa en ogiltig passagerare

Förväntad utfall:
* Passageraren sparas.
* Ett felmeddelande visas.

### Test Case 1.3 Chaufför 

Preconditions: Test Case 1 Person

Test Data: Giltig DriverId: String 5 siffror.

Test Steg: 
* Skapa en giltig Chaufför med en giltig ID
* Skapa en ogiltig Objekt med dålig Id

Förväntad utfall:
* Chauffören är redo för användning.
* Systemet ska be om en giltig ID

## Test Case 2 Buss

Preconditions: Test Case 1 Person

Test Data: String Id 3 siffror, String RegId (XXX000), String active ("true"eller"false").

Test Steg:
* Ny Buss Objekt 
* Ange en giltig Id 
* Ange en giltig regId
* Ange true eller false.

Förväntad utfall:
* En buss redo att köra.

### Test Case 2.2 Buss

Test Steg: 
* Ny Buss Object 
* Ange en ogiltig regId "A2C123"/Giltig regId
* Ange en ogiltig id
* Ange nåt som inte är true eller false

Förväntad utfall:
* Systemet ska be om giltig inmatning.

## Test Case 3 Linje

Test Data: Stop Objekt, String Id (måste vara två siffror)

Preconditions: Inga

Test Steg:
* Skapa ny Linje Objekt
* Tilldela ett ID
* Tilldela flera Stop Objekt
* Tilldela Buss Objekt

Förväntad utfall:
* Linjen presenteras.
* Om ogiltig ID felmeddelande visas.

### Test Case 4 Stop

Test Data: String id som är två siffror, String plats och string namn.

Preconditions: Inga

Test Steg:
* Skapa en ny Stop Objekt
* Tilldela den ett id,namn och plats

Förväntad utfall:

* En giltig stop Objekt.
* Om inmatningen var ogiltig så ska systemet be om ny data.

### Test Case 5 Biljett 

Test Data: String id fyra siffror, String lineId, Stop destination, Stop avgång, String passengerName, String kostnad, String färd datum och String köp datum. 

Preconditions: Linje(3), Stop(4), Passenger(1)

Test Steg:
* Skapa ny biljett Objekt 

### Test Case 6 Linje Databas

Test Data: Linje Objekt 

Preconditions: Test Case 3 Linje

Test steg: 
* Lägg til flera linje objekt
* Lägg till samma linje flera gånger.

Förväntad utfall: 
* Listan är sparad och presenteras.
* Systemet sparar linjen bara en gång och visar ett felmeddelande för dubbla inputs.

### Test Case 7 Buss Databas

Test Data: Buss Objekt

Preconditions: Test Case 2 Buss

Test steg: 
* Lägg til flera buss objekt
* Lägg till samma buss flera gånger.

Förväntad utfall: 
* Listan är sparad och presenteras.
* Systemet sparar bussen bara en gång och visar ett felmeddelande för dubbla inputs.

### Test Case 8 Biljett Databas

Test Data: Biljett Objekt

Preconditions: Test Case 5 Biljett

Test steg: 
* Lägg til flera biljett objekt
* Lägg till samma biljett flera gånger.

Förväntad utfall: 
* Listan är sparad och presenteras.
* Systemet sparar biljetten bara en gång och visar ett felmeddelande för dubbla inputs.

### Test Case 9 Chaufför Databas

Test Data: Chaufför Objekt

Preconditions: Test Case 1 Chaufför

Test steg: 
* Lägg til flera chaufför objekt
* Lägg till samma chaufför flera gånger.

Förväntad utfall: 
* Listan är sparad och presenteras.
* Systemet sparar chauffören bara en gång och visar ett felmeddelande för dubbla inputs.

### Test Case 10 UI Window

Test Data: ingen

Preconditions: inga
Test steg: 
* Öppna applikationen.

Förväntad utfall: 
* En meny längst upp med knappar för system, inställningar och hjälp
* en navigerings meny på den vänstra sidan.
* en klocka längst ner i den högra hörnen.

### Test Case 11 UI NavBar

Test Data: ingen

Preconditions: Test Case 10 UI Window
Test steg: 
* Öppna applikationen.

Förväntad utfall: 
* en navigerings meny finns på den vänstra sidan.
* Den innehåller 6 knappar (Overview, Garage, Personell, Buss Lines, Tickets, Book ticket)
* Knappar leder till rätt sida när man trycker på de.

### Test Case 12 UI Overview

Test Data: ingen

Preconditions: Test Case 10 Window
Test steg: 
* Öppna applikationen.

Förväntad utfall: 
* Overview skärmen visas som standard så den finns i mitten av applikationen.
* Det finns en fält där man kan skriva in sina notiser.
* notiserna man skriver in sparas och visas på skärmen.
* Ett felmeddelande visas om skriver notisen på fel sätt.

### Test Case 13 UI Garage

Test Data: ingen

Preconditions: Test Case UI Window, Test Case 11 UI Navbar, Test Case 7 Buss databas

Test steg: 
* Öppna applikationen.
* Tyck på knappen _Garage_

Förväntad utfall: 
* En lista med bussar presenteras på skärmen.
* Det finns möjlighet att lägga till nya bussar.

### Test Case 13.2 UI Garage

Test Data: ingen

Preconditions: Test Case UI Window, Test Case 11 UI Navbar, Test Case 7 Buss databas
Test steg: 
* Öppna applikationen.
* Tyck på knappen _Garage_
* Matar in information och trycker på knappen _Add_ eller _Remove_

Förväntad utfall: 
* En lista med bussar presenteras på skärmen med eller utan den angivna bussen.
* Systemet ska presentera ett meddelande för användaren om ett nytt buss har samma värde som en befintlig
* Systemet ska be om giltig indata om den angivna var felaktig.

### Test Case 14 UI Personal

Test Data: ingen

Preconditions: Test Case 10 UI Window, Test Case 11 Navbar, Test Case 9 Chaufför Databas. 
Test steg: 
* Öppna applikationen.
* Tryck på knappen _Personnel_

Förväntad utfall: 
* En lista med chaufförer presenteras.
* Under listan finns det möjlighet att lägga till eller ta bort

### Test Case 14.2 UI Personal

Test Data: ingen

Preconditions: Test Case UI Window, Test Case 11 UI Navbar, Test Case 7 Buss databas
Test steg: 
* Öppna applikationen.
* Tyck på knappen _Personnel_
* Matar in information och trycker på knappen _Add_ eller _Remove_

Förväntad utfall: 
* En lista med chaufförer presenteras på skärmen med eller utan den angivna chauffören.
* Systemet ska presentera ett meddelande för användaren om ett nytt chaufför har samma värde som en befintlig
* Systemet ska be om giltig indata om den angivna var felaktig.

### Test Case 15 UI Linjer

Test Data: ingen

Preconditions: Test Case 10 UI Window, Test Case 11 Navbar, Test Case 6 Linje Databas.
Test steg: 
* Öppna applikationen.
* Tryck på knappen _Buss Lines_

Förväntad utfall: 
* En lista med linjer presenteras
* Under Listan så finns det möjlighet att lägga till nya linjer dess läggs till utan stop från början.

### Test Case 16 UI Biljett

Test Data: ingen

Preconditions: Test Case 10 UI Window, Test Case 11 Navbar, Test Case 8 Biljett Databas.
Test steg: 
* Öppna applikationen.
* Tryck på knappen _Tickets_

Förväntad utfall: 
* EN lista med bokade biljetter presenteras.


### Test Case 17 UI Boka Biljett

Test Data: ingen

Preconditions: Test Case 10 UI Window, Test Case 11 Navbar, Test Case 8 Biljett Databas.
Test steg: 
* Öppna applikationen.
* Tryck på knappen _Book Ticket_

Förväntad utfall:
* en navigerings meny på den vänstra sidan.
* En sida visas där man kan boka ett biljett. 
* Fyll i alla fält med giltig data och tryck på Sumbit

### Test Case 17.2 UI Boka Biljett

Test Data: ingen

Preconditions: Test Case 10 UI Window, Test Case 11 Navbar, Test Case 8 Biljett Databas.
Test steg: 
* Öppna applikationen.
* Tryck på knappen _Book Ticket_

Förväntad utfall:
* en navigerings meny på den vänstra sidan.
* En sida visas där man kan boka ett biljett. 
* Om en av fälten är tomma eller data är ogiltig då visas det ett felmeddelande

### Test Case 18 UI Detaljerad Vy

Test Data: ingen

Preconditions: inga
Test steg: 
* Öppna applikationen.
* Tryck på knappen _Buss Lines_
* Tryck på knappen _Detailed View_
* Välj en linje från drop down listan

Förväntad utfall: 
* en navigerings meny på den vänstra sidan.
* en klocka längst ner i den högra hörnen.
* En tabell med alla stop visas.

### Test Case 19 Add Button

Test steg: 
* Öppna en fönster där man kan lägga till data till en tabell
* Fyll i alla fält och tryck på _Add_

Förväntad utfall: 
* Data sparas och visas i tabellen
* Vid fel ska data in sparas och ett felmeddelande skall visas.

### Test Case 20 Edit Button

Test steg: 
* Öppna en fönster där man kan lägga till data till en tabell
* Fyll i alla fält och tryck på _Edit_

Förväntad utfall: 
* Data sparas och visas i tabellen
* Vid fel ska data in sparas och ett felmeddelande skall visas.

### Test Case 21 Remove

Test steg: 
* Öppna en fönster där man kan lägga till data till en tabell
* Fyll i Id fältet och tryck på _Remove_

Förväntad utfall: 
* Data tas bort och tabellen uppdateras
* Vid fel ska data inte ändras och ett felmeddelande skall visas.