# Buss System

Författare: _Andras Balla_

Lnu namn : _ab223sq_

Datum : _2016.06.01_

# Abstrakt 

Denna rapport handlar om ett Project i Kursen Individuellt mjukvaruutvecklingsprojekt vid Linnéuniversitetet under våren 2016.

Rapporten beskriver Java applikationen _Buss System_ vilket ska underlätta det dagliga verksamheten för ett företag som erbjuder person transport med hjälp av bussar.

# Inledning och bakgrund 

### Mål

Målet för projektet var att skapa en desktop applikation vilket skulle samla ett transportföretags tillgångar på ett ställe. Jag valde att anpassa den till ett företag som har transporter med buss men det är enkelt att lägga till extra funktionalitet eller anpassa den till lastbilar. Applikationen skulle ha en backend där all information sparas och där alla klienter kan hämta information i real tid. 

### Teknik

För att skapa desktop applikationen använde jag mig av Java, CSS och Gradle. För backend delen valde jag en färdig produkt [Firebase.com](https://www.firebase.com/) där all information sparas samt tjänsten erbjuder en API för kommunikation. Kombinationen av Java/JavaFX, Css och Gradle är en beprövad method som är väl dokumenterad.

### Arbetssätt 

Projektet börjades med att skapa en Vision samt en kravspecifikation vilket skulle lägga ner grunderna för arbetet. Därefter har jag följt en iterativ utvecklingsprocess med veckolånga iterationer. Varje iteration planerades i detalj både med arbetsuppgifter och tidsplanering.

# Positiva erfarenheter

Personligen blev jag positivt överraskad av alla min valda tekniker. Först var JavaFX vilket jag valde att skriva för hand istället för att använda någon form av automatisk method. Det finna väldigt många hjälp medel att använda sig av för att skapa en snygg användargränssnitt med hjälp av JavaFX min favorit blev Tabellen eftersom den är smidig att skapa och använda för att lagra samt presentera information. 

JavaFX är en stark verktyg att använda men den tekniken som har sparat mest tid var CSS det är väldigt smidigt att du kan ladda in en CSS fil till din applikation. Detta sparar väldigt mycket tid eftersom den inbyggda CSS som finns i JavaFX måste sättas individuellt för varje element så om en knapp har 5 regler som skapar utseendet då får du 5 rader kod för varje knapp du skapar. Med CSS kan du bara ange reglerna en gång och det kommer gälla för alla knappar. Detta ger ett bra underlag och sen erbjuder också special fall vid behov.

Sist kommer Firebase vilket har överraskat mig med all extra funktionalitet som den erbjuder. Jag fick tillgång till en API som uppfyllde alla mina behov när det gäller kommunikation med server och utöver mina egna krav var det enkelt att synka alla klienter med servern vilket är ett stort bonus.

För att fortsätta på detta sättet i framtiden behöver jag bara läsa på de tekniker jag har tillgänglig och hitta de hjälpmedel som finns inbyggda samt använda de.

# Negativa erfarenheter

På det negativa sidan hamnar veckoplaneringen. Det tog några iterationer innan jag själv kunde skapa ett bra plan och tidsfördelning. 

Utöver det hade jag inte särskilt många problem. Ibland förekom en del begränsningar med de valda teknikerna som till ex Tabellerna I Java FX behöver en special anpassad Objekt för att kunna ta emot data. Det finns ett antal lösningar, jag valde att skapa två Objekt vilket medför att jag fick ofta konvertera mina Objekt fram och tillbaka. Detta gör min kod mycket mer svårläst.

I början hade jag problem med API till Firebase men allt det löste sig när jag hittade deras Javadoc vilket hjälpte mig väldigt mycket senare i mitt arbete.

För att undvika dessa problem i framtiden behöver jag bli bättre att undersöka nya tekniker innan jag börjar använda de och helt enkelt fortsätta planera mitt arbete veckovis för att få ett bättre uppfattning om hur mycket jag kan få gjort under en vecka och hur lång tid det skulle ta.

# Sammanfattning

Min applikation är inte något som kan säljas till företag men den var aldrig tänkt att bli heller. Det jag har fått ut av detta arbete är att känna på och uppskatta att arbeta iterativt samt att jag har lärt mig mycket om hur man ska gå tillväga att skapa en desktop applikation. Det största positiva är att jag har hittat Firebase vilket är en verktyg jag kommer fortsätta att använda mig av i framtiden eftersom den erbjuder så mycket för en utvecklare. 
