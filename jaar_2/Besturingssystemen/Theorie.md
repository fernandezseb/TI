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
* Programmeertaal-specifiek (vb JVM)
* Emulator

Een belangrijk stuk software dat hiervoor wordt gebruikt heet de *virtual machine monitor*.
Deze heeft als doel ervoor te zorgen dat elke *gebruiker* een uniek veel van de computeromgeving heeft.

Aan de hand van virtuele machin's kunnen verschillende **verschillende besturingssystemen tegelijkertijd op 1 computer** bestaan.

### Concepten van besturingssystemen

* De gebruiker communiceert met
* de **shell** of **command interpreter** die op zijn beurt communiceert met
* **utilities** die communiceren met
* de **kernel** die communiceert met
* de **hardware**

**Processen** is een belangrijk concept binnen besturingssystemen.
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

