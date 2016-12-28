# Theorie besturingssystemen

## Hoofdstuk 1: Inleiding

### Wat is een besturingssysteem?

> **Programma dat het mogelijk maakt de hardware van een computer te gebruiken**

De **functies** zijn:
* Opslaan en ophalen van informatie
* Programma's afschermen
* Gegevensstroom regelen
* Prioriteiten regelen
* Het mogelijk maken om bronnen te delen
* Tijdelijke samenwerking tussen onafhankelijke programma's mogelijk maken
* Reageren op fouten
* Tijdsplanning maken

### Kort historisch overzicht


  | Functionaliteit
------|------
Eerste computers | Geen OS
Jaren 50 | Eenvoudige OS (Een programma tegelijk)
Begin '60 | Geavanceerdere OS (Meedere programma's tegelijk in het geheugen die beurtelings uitgevoerd worden en die bronnen kunnen delen)
Midden '60 | Verschillende computers van hetzelfde type gebruikten één OS
Begin '70 | OS op computers met meer dan 1 processor
Begin '80 | Gemeenschappelijk gebruik van informatie door verschillende computersystemen
Jaren '90 | Distributed computing, parallelle verwerking, ...

### Soorten besturingsystemen

#### Single-tasking
> **Systeem waarin 1 gebruiker 1 applicatie tegelijk draait**

#### Multitasking (single-user)
> **Meestal 1 gebruiker die verscheidene taken tegelijk kan uitvoeren**

#### Multi-user systemen
> **Meedere gebruikers maken simultaan gebruik van computerresources**


Hierbij is **scheduling** een belangrijk concept
> ***Scheduling* verwijst naar de manier waarop processen prioriteiten worden gegegeven in een prioriteitenwachtrij**

Er zijn verschillende soorten multi-user-systemen. Deze worden onderverdeeld afhankelijk van de soorten programma's die ze aankunnen:

Soort programma's | Responsiviteit
----------------- | --------------
Interactieve programma's | Snelle respons
Batch-programma's | geen directe respons
Real-time programma's | respons in een beperkte tijd

#### Virtuele machines
> **Computerprogramma die een computer nabootsen, waar andere programma’s op kunnen worden uitgevoerd**

Soorten:
* Programmeertaal-specifiek (vb. JVM)
* Emulator

Een belangrijk stuk software dat hiervoor wordt gebruikt heet de *virtual machine monitor*.
Deze heeft als doel ervoor te zorgen dat elke *gebruiker* een uniek veel van de computeromgeving heeft.

Aan de hand van virtuele machin's kunnen verschillende **verschillende besturingssystemen tegelijkertijd op 1 computer** bestaan.

### Concepten van besturingssystemen

* De gebruiker communiceert met
* de **shell** of **command interpreter** die op zijn beurt communiceert met
* **utilities** die communiceren met
* de **kernel** die communiceert mets
* de **hardware**

**Proces** is een belangrijk concept binnen besturingssystemen.
Een proces is:
> **een of meer reeksenopdrachten die door een besturingsprogramma worden beschouwd als een werkeenheid**

In eerste instatie spreken processen **resources** (bronnen) aan.
Enkele voorbeelden zijn
* randapparatuur
* geheugen
* bestanden
* CPU

#### Resources

Een OS moet
* zorgen voor voldoende **geheugen** voor het proces
* het gebruik van de **CPU** regelen
* de gegevensstroom regel van of naar **devices**
* **bestanden** en records kunnen lokaliseren

#### Concurrency
Processen zijn meestal niet onafhankelijk, processen worden daarom **concurrent** genoemd.

Enkele voorbeelden
* 2 processen willen dezelfde printer gebruiken
* 2 processen willen dezelfde file lezen of schrijven
* 2 processen willen communiceren

Hier ontstaan dus **conflicten**.

Het OS moet dan regelen in welke volgorde processen afgehandeld worden:

Dit gebeurt door een techniek dat **synchronisatie** heet.

#### Ontwerp-criteria
Er zijn een aantal ontwerp-criteria waar een besturingssysteem aan moet voldoen:
* consistentie
* flexibiliteit
* overdraagbaarheid

#### Compromissen
Het is vaak onmogelijk om aan alle criteria te voldoen, daarom worden sommige soms opgeofferd ten gunste van anderen.

#### Linux
Zie slides inleiding en deel Linux voorlopig.

## Hoofdstuk 2: Scheduling

### Noodzaak tot scheduling

Waarom is scheduling nodig?
> **Om efficiënt middelen (bronnen, resources) in te zetten om de taken (opdrachten, jobs) uit te voeren.**

Bij **multiprogrammering (multi-user)** moet het OS efficiënt aan de verschillende behoeften van vele gebruikers voldoen.
Processen moet resources benaderen en binnen een redelijke tijd uitgevoerd worden.

**Scheduling** is dus een belangrijk concept in het ontwerp van **multi-user**- en **multiprocessing besturingssystemen**
en in het ontwerp van een **realtimebesturingssysteem**.

> **Scheduling** verwijst naar de manier waarop processen prioriteiten worden gegeven. Deze taak wordt uitgevoerd door een **scheduler**.



### Doelstellingen van scheduling

De doelstellingen van scheduling zijn:

* doelmatigheid en tevredenheid van de gebruiker
* resources moeten effectief/efficiënt gebruikt worden (Dit op een snelle en rendabele manier.)

#### Efficiëntie

De efficiëntie met betrekking tot het gebruik van resources wordt gemeten door:
* Doorvoersnelheid *troughput*
  * Het aantal processen die per tijdseenheid door het systeem worden uitgevoerd
  * Hoge doorvoersnelheid is niet per se het best omdat het dan kan gebeuren dat grote processen nooit of pas na lange tijd worden uitgevoerd.
* Responstijd
  * Gaat over de tijd dat het duurt voor een gebruiker *antwoord* krijgt op zijn *request*. Dit houd geen rekening met de tijd die het duurt om de respons bij de gebruiker te krijgen.
* Consistentie
  * De gebruikers verwachten dat de responstijd altijd ongeveer hetzelfde is voor dezelfde acties.
* Hoeveel het de processor aan het werk houd
  * Het OS moet resources aan het werk houden.
* Prioriteiten
  * Elk proces krijgt een prioriteit volgens belangrikjheid. Het OS baseert zich hierop bij de scheduling.
  * Dit levert ook een aantal problemen:
    * Wie bepaalt de prioriteiten?
    * Wie kent ze toe?
    * Welke richtlijnen zijn er?
    * Wanneer is een proces belangrijker en verdient het daarom een hogere prioriteit?
    * Wat gebeurt er als scheduling op basis van priorieiten de systeemefficiëntie verlaagt?
* Real-time systemen
  * Het doorgaand proces krijgt hoogste prioriteit want dit verwacht snelle respons.
  * Er wordt minder belang gehect aan "rechtvaardigheid" en systeemefficiëntie. Andere processen krijgen lagere prioriteit.

Conclusie:

Scheduling is een moeilijke zaak. Het moet rekening houden met:
* Behoeften van processen
* Systeemefficiëntie
* Bestaande hardware
* Wat "eerlijk" is

Een scheduler kan niet met alles tegelijk rekening houden want er ontstaan zelfs conflicten tussen belangen.

### Uitvoeren van een proces

#### Instructiecyclus zonder onderbreking

1. START
2. Fetch next instruction (**Fetch stage**)
3. Execute instruction (**Execute stage**)
4. HALT

2\. en 4. blijven herhalen zolang er nog instructies zijn.


#### Instructiecyclus met onderbreking
1. START
2. Fetch Next instruction (**Fetch stage**)
3. Execute instruction (**Execute stage**)
4. Er kunnen twee zaken gebeuren afhankelijk van of interrupts enabled zijn:
  * Indien **disabled**, kan er terug naar 2. worden gegaan zoals bij zonder onderbreking.
  * Indien **enabled**, kan er naar de **Interrupt stage** worden gegaan. En kan een interrupt handler worden uitgevoerd. Daarna wordt terug naar 2. gegaan.
5. Indien er geen instructies meer zijn: HALT.

### Systeembeeld van een proces

Een proces bestaat uit:

* Contect
  * Id/nummer
  * Status of toestand
  * PC (program counter)
  * Prioriteit
* Instructies
* Data

De verschillende toestanden waarin een proces kan zijn:
* HOLD (is angeboden)
* READY (gereed om uit te voeren)
* SUSPENDED (is opgeschort)
* RUNNING (wordt uitgevoerd en onder besturing van de CPU)
* WAIT (wacht op iets)
* COMPLETE (volledig afgewerkt)

De verschillende toestandsovergangen zijn:
1. niet-aangeboden => HOLD
2. niet-aangeboden of HOLD => READY
3. READY => RUNNING
4. RUNNING => READY
5. RUNNING => WAIT
6. WAIT => READY
7. RUNNING => COMPLETE
8. READY => SUSPEND
9. SUSPENDED => READY

Het OS houdt voor elk proces een PCB bij. Dit bevat:
* Proces-ID
* Procestoestand
* Maximale en actuele looptijd
* Huidige resources en limieten hierop
* Procesprioriteit
* Opslaggebieden
* Locatie van de code of de segmenttabel van een proces

Er zijn verschillende niveau's van scheduling. Deze bepalen specifieke toestandsovergangen:

Naam | Toestandsovergangen
---- | ------------------
High-level (job scheduling) | 1,2,7
Op middelniveau  (intermediate level) | 5,6,8,9
Low-level scheduling | 3,4



### Strategieën voor low-level scheduling

Er zijn twee hoofdcategorieën:
* Algoritme voor **preëmptive** scheduling (processen worden onderbroken om een ander proces te hervatten)
* Algoritme voor **nonpreëmptive** scheduling (een proces moet wachten tot het andere klaar is)

Belangrijke criteria voor een scheduler zijn:
* CPU-gebruik
* throughput (doorvoersnelheid)
* wachttijd
* responstijd

De verschillende strategieên zijn
* Round Robin (RR)
  * Maakt gebruik van een vaste tijdswaarde of tijdkwantum. Wanneer deze overschreden wordt, wordt het proces onderbroken en laadt het een volgend proces in.
* FIFO of First-come-first-served-scheduling (FCFS-
  * Het proces die het eerst de CPU vraagt, wordt het eerst uitgevoerd.
* Multilevel feedback queues (MFQ)
  * Processen worden opgedeeld volgens frequentie van hun CPU bursts en in verschillende queues gestoken. Elke queue heeft een verschillende prioriteit. Als de processen hun eigenschappen veranderen worden ze dynamisch van de ene queue naar de andere *opgeheven*.
* Shortest-job-first-scheduling (SJF)
* Er zijn twee strategieën die aan korte processen een hoge prioriteit geven
  * Shortest remaining job next (SRJN) (De preëmptieve versie.)
  * Shortest job first (SJF) (De niet-preëmptieve versie.)
  
 #### Starvation
 
 > Wanneer een heel lang proces nooit uitgevoerd zal worden, noemen we dit starvation.
 
Mogelijkeden om dit op te lossen zijn:
* Negeren
* Opschorten van een aantal READY-processen
* Periodiek prioriteiten opnieuw berekenen
 
Dit kan niet optreden bij Round Robin en FIFO.
