# Input, output, redirection

Net zoals bij Java werken UNIX en GNU/Linux met concept van input, output en error streams. De concepten in Java zijn zelfs genomen uit UNIX.

## stdout

* Overschrijven: proces > file
* Toevoegen (append): proces >> file

## stderr

* proces 2> file

## stdout + err
* proces > file 2>&1

## stdin
proces < file

## Tussen processen
* proces1 | proces2


## Voorbeelden

* ```find / -type d``` (Zoek in de root directory naar bestanden van het type directory.)

* ```find / -type d > output.txt``` (Alle uitvoer (behalve error boodschappen) worden naar output.txt uitgeschreven.)


* ```find / -type d 2> output.txt``` (Alle foutboodschappen worden uitgeschreven.)


* ```find / -type d > output.txt 2> errors.txt``` (Alle uitvoer naar output.txt, alle errors nar errors.txt.)


* ```find / -type d > output.txt 2>&1``` (Beide worden naar output.txt geschreven.)

* ```find / -type d | grep sbin``` (We zoeken in de stdout naar sbin, de foutboodschappen worden niet doorzocht door grep omdat dit naar stderr gaat.)


* ```find / -type d 2> /dev/null  | grep sbin``` (We redirecten de foutboodschappen naar "de vuilbak" van GNU/Linux, de stdout van find gaat naar grep.)


# Text editing

* ```awk '{print $2;}' users.txt``` ($2 staat voor de tweede kolom.)
* ```sed 's/patroon/vervangtekst/g' users.txt``` (Tekst vervangen in users.txt, de g (optioneel) staat voor global, dit gebruik je om alle voorkomens op een lijn te verwijderen.)
* Interessant om te weten: ```ip a |  awk '/inet[^6]/ {print $2}'````
