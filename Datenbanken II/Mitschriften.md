# Datenbanken II

[TOC]

## DBMS
### Vorteile DBMS vs FS
* keine Redundanz
* Datenkonsistenz und Integrität
* einfache Wiederherstellung
* flexibel
* einfacher Zugriff
* vielfältige Sicherheitsmöglichkeiten
* Mehrbenutzerverwaltung
* API zum Datenabruf
* einzelne Datensätze schneller erreichbar durch Index
### Nachteile DBMS vs FS
* hohe Kosten
* Komplexität
* Performanceverlust durch Overhead
* Mehr Speicherplatz durch Backup + Index

## Verwaltung Hintergrundspeicher
### Zweck
* Daten zur Verarbeitung bereitstellen
* Daten langfristig speichern
* Daten sehr langfristig und preiswert archivieren
  * unter Inkaufnahme langsamer Zugriffszeiten

### Flashspeicher
* Nachteil
  * Löschoperation langsam: Lesezugriff eines Blockes 25 us, Löschen eines Blockes 2 ms
  * Lebensdauer der Zellen begrenzt
  * Defragmentierung auf Betriebssystemebene kontraproduktiv
    Einsatz Flashspeicher => begrenzte Lebensdauer der Datenbank
> DBMS nutzen stärken von Flash nicht aus, sind auf <u>sequentielles</u> Lesen und nicht auf wahlfreie Leseoperationen ausgelegt

### ECC (Error Correction Codes)
* separate Übertragung aller Stellen an denen eine "1" steht in ECC

* Korrekturbits stehen immer an Stelle Pos $2^x$ (x=0,1,2)

### Langzeitarchivierung
Die Lebensdauer setzt sich aus folgenden Teilaspekten zusammen:
* Physische Haltbarkeit des Mediums garantiert die **Unversehrtheit** der Daten
* Das Vorhandensein von Geräten udn Treibern garantiert die **Lesbarkeit**