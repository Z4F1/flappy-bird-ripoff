# Flappy Bird Ripoff!

> Laget av Pelle Pastoor

**NB! Dette var egentlig et skole prosjekt**

**Sjekk ut topp 20 scores som har blitt posta [her.](https://flappy.floatinggoat.no/)**

Github repo's for nettsiden: [Backend](https://github.com/Z4F1/flappy-backend) og [Frontend](https://github.com/Z4F1/flappy-frontend)

Dette er da min versjon av Flappy Bird som jeg valgte å lage til Åpen oppgave. Jeg har programmert alt selv, men noen av assets'ene er hentet fra [denne github repositorien](https://github.com/samuelcust/flappy-bird-assets) (Det er de som ikke har flappy i navnet. De som har flappy i navnet har jeg laget i tillegg). Det jeg har gjort er rett og slett å lage en enkel game "engine" som jeg da bruker for å utvikle Flappy Bird. Jeg har prøvd å lage denne game engine'en så det er mulig å bruke det for å utvikle andre spill også. Et spesifikt mål var at vinduet skulle være resizable og ikke hadde noe problem med å maksimere seg, noe jeg mener er en finishing touch som er viktig.

I information mappen finner du en `.pdf` fil, som inneholder klassediagrammet delt i to deler. Den første siden sier bare noe om hva de ulike boksene betyr, den andre siden handler om game engine klassene, og siste side er klassen som hører til flappy bird spillet.

## Struktur

Jeg har strukturert dette i 3 mapper; "flappy" som da er faktiske spill logikken osv., "game" som da er game engine filene, og "main" er bare for å starte spillet.

Innenfor de to førstnevnte så har vi også en struktur på mappene. Der har vi controller, view, model og events som er hoved. Har også en textures som bare er for å laste inn bilde og hente de. I flappy har jeg bare hatt behov for model og view. Jeg har en FlappyMain klasse som da er for å laste inn og starte alt.

## Instruksjoner

### 1. Installering av Java

Det aller første som er nødvendig er at det må være installert en java versjon. På java sine egne nettsider har de gode instruksjoner for enhver datamaskin: [Java instruksjoner](https://www.java.com/en/download/help/download_options.html). Når det kommer til å kjøre filen er det litt forskjellig fra operativ system til operativ system.

### 2. Laste ned spillet

Det er to måter å gjøre dette på. Den ene er ved å klone prosjektet med `git`, altså `git clone {prosjekt url}`, men det enkleste er nok metode 2. 

Metode 2 er å laste ned som `.zip` fil. Dette gjør du ved å trykk på "download" knappen som er til venstre for "Clone" knappen. Her velger du da alternativet "zip" og laster ned. Deretter åpner du filen og "extract" et sted du vil ha det.

### 3. Kjøre programmet

Når du skal kjøre programmet må du, uansett hvilke operativ system du har, gå inn på release. Der finner du det du trenger for å kjøre spillet.

#### Windows

På windows er det egentlig ganske tungvint, men jeg har gjort det så enkelt som mulig. Bare dobbelt klikk på `START-WINDOWS.bat` og den vil da åpne det som kalles en command line, som kjører `.jar` filen.

#### Mac OS

Her er det faktisk veldig enkelt, for du kan nemlig bare åpne den som ett hvert program. Dette kommer av at Mac OS har det som kalles JavaLauncher som har mulighet til å åpne og kjøre `.jar` filer.

#### Linux

Dersom du har installert Java, er det noen linux systemer som har noe lignende Mac OS, men dette er ikke alltid tilfellet. Derimot, ettersom du har linux går jeg utifra at du kan bruke terminalen så det skal jeg da gå gjennom. 

### Bruke terminalen

> Dette kan gjøres på alle maksiner.

Åpne terminalen din, og naviger med `cd` kommandoen til release mappen. Når du er der så skal du kjøre kommandoen `java -jar flappy-bird-ripoff.jar`. Dette skal da starte `.jar` filen og spillet.

### 4. Spille spillet

Nå som du kan starte spillet må du kunne spille spillet. Når du kommer til start skjermen kan du velge mellom å bruke musepekeren til å trykke på skjermen for å starte, eller du kan velge å bruke space. Dette er også tastene du bruker for å holde deg opp, altså hoppe.

Målet er da å komme forbi flest mulig "pipes" som de kalles og da får du poeng. Du taper ved å enten treffe et av rørene, eller ved å treffe bakken.

Når du har tapt har du 1 tekstboks som viser score og 3 røde knapper. Den ene knappen er for å restarte, den andre hvor det står "submit" er for å poste din score på nettsiden, og til slutt har du en "scores" knapp som åpner nettsiden hvor du kan se alle scores som har blitt posta.
