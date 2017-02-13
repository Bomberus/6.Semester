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