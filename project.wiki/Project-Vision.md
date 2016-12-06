# **Vision Document**

##**Backgrund och Problembeskrivning**

Systemet ska hjälpa företag som jobbar med kollektiv trafik att hantera biljetter, tillgångar i form av fordon och personal samt information angående linje trafik. Den ska också ha en web application där kunder kan boka biljetter för buss resan.

## **Mål-grupp**

Användarna av detta system kan delas in i två stora grupper.

### **1.1 Anställda**
Den första gruppen är anställda hos kunden som kommer att använda systemet. Denna grupp kan brytas ner till: chaufförer, system administratörer och kundtjänst personal. Denna gruppen kan ha en blandad erfarenhets nivå när det kommer till datorer samt näst intill ingen programmerings erfarenhet detta betyder att de behöver en bra användargränssnitt.

### 1.2 Kunder/Resenärer 
Den andra gruppen består av personer som bokar deras biljetter hemma på en hemsida. Denna målgruppen är väldig stor och svår att analysera.

## **Marknad**

Systemet riktar sig till företag som tillhandahåller kollektiv trafik inom Sverige.

## **Konkurrerande system**

Det finns redan ett antal system på marknaden som erbjuder heltäckande lösningar för kollektiv trafik. Ett svensk exempel är Trivector och Gunnebo. Det är en tuff marknad eftersom det finns många aspekter som man behöver tänka på så som säkerhet och hanteringen av personlig information. Utöver det så måste systemet ta hänsyn till regler både från staten och facket vilket bara ökar komplexiteten.

## **Krav**

Systemet skall hjälpa anställda med det dagliga arbetet för att öka effektivitet och för att samla företagets åtagande i en application. Den ska hålla koll på bokade biljetter och erbjuda en lösning där kunder kan boka biljetter hemifrån . Sköta företagets tillgångar i form av bussar och personal genom att erhålla all relevant information som rör fordon eller personer. Systemet ska hantera och spara information rörande linje trafiken. För att uppfylla de här kraven den färdiga produkten behöver innefatta en desktop application, en webb application och en server som sköter kommunikationen mellan de.

Hantera tillgångar (Lägga till, ändra och skapa)

* Buss 
* Personal i form av chaufförer
* Förutbestämda buss linjer
* Spara och visa bokade biljetter
* Samt erbjuda ett Boknings system för biljetter

## **Teknik** 

### Java

Jag valde att arbeta med Java att skapa min Desktop applikation för att kunna lära mig nya teknik.

### JavaFx

Valet av JavaFx var enkel för att skapa en användargränssnitt både för att jag har använt den tidigare och för att den är väl utformad och enkel att använda.

### Firebase

Detta är en tjänst som erbjuder en enkel API att jobba med för kommunikation och en plats att förvara sin data.

### Gradle 

Gradle används för att bygga ihop applikationen och för automatiserad testning.



_Andras Balla - UDM15_