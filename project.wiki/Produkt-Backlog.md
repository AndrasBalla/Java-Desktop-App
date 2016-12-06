Det finns en Use case och en Test case för varje fält nedan.

|**ID**|**Name**|**Type**|**Status**|**Description**|**Priority**|**Dependencies**|
|------|--------|--------|----------|---------------|-------------|------------|------------|
|1|Person|Component|Klar|En objekt som representerar en Person|High|5|
|1|Driver Passenger|Component|Klar|Ärver från person och definierar passagerare eller chafför|High|1,5|
|2|Buss|Component|Klar|Buss Objekt|High|5,1|
|3|Line|Component|Klar|Förutbestämd Buss linje|High|2,4,5|
|4|Stop|Component|Klar|Förutbestämd buss stop|High|-|
|5|Ticket|Component|Klar|Biljett Objekt|High|3|
|6|Line Database|Krav|Klar|En förutbestämd databas som erhåller buss linjer|Medium|3,9|
|7|Buss Database|Krav|Klar|En förutbestämd databas som erhåller bussar|Medium|2,9|
|8|Ticket Database|Krav|Klar|En plats där man lagar biljetter|Medium|5,9|
|9|Chaufför Databas|Krav|Klar|En databas som lagrar chaufförer|High|1|
|10|UI Window|Krav|Klar|En huvud fönster som används av under fönster|High|-| 
|11|UI NavBar|Krav|Klar|En navigerings meny|High|11|
|12|UI Overview|Krav|Klar|En fönster som visar en helhetsbild av systemet|Medium|11-12|
|13|UI Garage|Krav|Klar|En fönster som visar bussarna|High|11-12, 2, 7|
|14|UI Personal|Krav|Klar|En fönster som visar chaufförerna|High|11-12, 1 , 10|
|15|UI Linjer|Krav|Klar|En fönster där man kan hitta alla buss linjer|High|11-12, 3 , 6|
|16|UI Ticket|Krav|Klar|En fönster där man kan se biljetter|High|11-12, 5, 8|
|17|UI Boka Biljett|Krav|Klar|En fönster där man kan boka en biljett|High|11-12, 5, 8|
|18|UI detaljerad vy|Krav|Klar|En fönster där man kan visa alla detaljer av en objekt|Medium|Alla|