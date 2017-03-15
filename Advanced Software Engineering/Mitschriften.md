# Advanced Software Engineering 2

[TOC]

## Programmierprinzipien

### ToDo

- [ ] Ergänze fehlende Prinzipien
- [ ] Füge Graphen hinzu
- [ ] Erkläre kurz

### Single Responsibility

### Open Closed Principle
Elemente der Software wie Klassen, Module und Funktionen sollten
* offen für Erweiterung sein
* geschlossen für Änderungen sein

Erweiterung nur über Vererbung (optimal)

### Liskov Substitution Principle
* Abgeleitete Typen müssen schwächere Vorbedingungen haben
* Abgeleitete Typen müssen stärkere Nachbedingungen haben

> Wenn sich das Objekt so verhält, wie sein Oberklasse

```mermaid
digraph
{
Graphisches Element -> Rechteck;
Graphisches Element -> Ellipse -> Kreis;
Graphisches Element -> Text;
}
```
### Interface Segregation Principle
Anwender sollen nicht von Funktionen abhängig sein, die sie nicht brauchen
> Übergebe User nur Interface mit Funktionen, die er benötigt

### Dependency Inversion Principle
High-Level Module von Low-Level Modulen abhängig
* schlecht
* besser : High-Level Modul von Abstraktionen abhängig

Abstraktionen : nicht von Details abhängig, Details abhängig von Abstraktion

### Tell, don't ask
* Prozeduraler Code kappelt sich stark an andere Elemente

### Kiss (Keep it simple, stupid)
Herkunft in der US Navy 1960
* einfache Systeme arbeiten am besten
* Komplexität unter allen Umständen vermeiden
* Linux Arch

### SLAP (Single Level of Abstraction Principle)
* Prinzip des einfachen Abstraktionsniveau
* keine Vermischung von Arbeit und Delegation
* keine Vermischung von DB und Businesslogik
* Fördert Wiederverwendbarkeit

### GRASP

### Low Coupling
Die Abhängigkeiten verringern, um das eigene Paket von der Landschaft "abzukoppeln"
> Koppelung ist der Maß von Abhängigkeiten von Paketen und Objekten

Effekte:
* geringe Abhängigkeiten zu Änderungen in anderen Teilen
* einfacher testbar
* verständlicher, da weniger Kontext notwendig ist
* einfacher wiederverwendbar

### High Cohesion
Kohäsion ist ein Maß für die Zusammenhalt einer Klasse. Hohe Kohäsion und lose Kopplung als Fundament für idealen Code.

### Information Expert
Kapselung von Informationen
Leichtere Klassen, da Businesslogik zu den Daten verteilt wird

### Indirection

###DRY (Don’t Repeat Yourself ! )
* wiederhole dich nicht
* Anwendbar:
* Datenbankschema
* Testpläne
* Buildsystem
* Dokumentation
* Gegenteil: 
* WETYAGNI (You ain’t gonna need it)du wirst es nicht brauchen

## DevOps

- eine **Bewegung** mit dem Ziel **Time-To-Market** einer **Änderungseinheit** zu reduzieren, bei gleichzeitiger Gewährleistung **hoher Qualität**
- durch Anwendung des **Lean-Prinzip** auf den gesamten **Software-Wertstrom**

### Lean

**Philsophie**, mit Ziel, einen **Prozess** durch die **Eliminierung von Verschwendung kontinuierlich** zu verbessern und dabei die **Bedürfnisse der Kunden** als **Ausgangspunkt allen Handelns** sieht

Verschwendung erkennen:

- Materialbewegung
- Bestände::
- Bewegung
- Wartezeiten
- Verarbeitung
- Überproduktion
- Korrekturen und Fehler 

Verschwendung beseitigen:

Pull Prinzip:

- es wird nur produziert:
  - **was** der Kunde will
  - **wenn** der Kunde es will