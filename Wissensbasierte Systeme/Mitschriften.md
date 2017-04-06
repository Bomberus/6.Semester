# Wissensbasierte Systeme
[TOC]
## Geschichtliche Hintergründe
### Kategorien künstlicher Intelligenz
#### Denken
##### Menschliches Denken
* Entscheidungsfindung* Problemlösung
##### Rationales DenkenFormeln und Verfahren
#### Handeln
##### Menschliches Handeln
Maschine führen Tätigkeiten aus, die eine gewisse Intelligenz erfordern
##### Rationales Handeln
Entwickeln von intelligenten Verfahren ?
### Turing - Test
* Verarbeitung natürlicher Sprache* Wissenspräsentation* Automatisches logisches Schließen* (Maschinenlernen)
### Sprachinteraktion ELIZA
## Wissensbasierte Systeme
Ziel ist **intelligentes Problemlösungsverfahren** zu realisieren. 
### Aspekte
* Repräsentation* Verarbeitung* Erwerb von Wissen* kein bereich kann unabhängig des anderen betrachtet werden
### Objekte
- Entitäten -> Werte, Daten/Fakten, Objekte- Beziehung zwischen Entitäten -> Mengenzugehörigkeit- Metaregeln zur Verarbeitung von Enitäten und denren Beziehung -> Wissen

## Wissens
### Deduktion
Sokrates ist ein Mensch.
Alle Menschen sind sterblich.

---
Sokrates ist sterblich

### Induktion
Sokrates ist sterblich.
Sokrates ist ein Mensch.

---
Alle Menschen sind sterblich.
### Abduktion
Diese Bohnen sind weiß.
Alle Bohnen aus diesem Sack sind weiß.

---
Die Bohnen sind aus diesem Sack.

## Aufgaben Induktion / Deduktion / Abduktion
### Entscheiden Sie, um was es sich handelt
Alle Kater sind schwarz.
Felix ist schwarz.
=>Felix ist ein Kater.

Induktion

Felix ist ein Kater.
Alle Kater sind schwarz.
=> Felix ist schwarz.

Deduktion

### Folgende Sachverhalte sind bekannt...
* Jens wacht auf.
* Jens holt einen Wischlappen.
* Wenn Jens aufwacht und sein Zimmer säubert, freut sich Jens Mutter.
* Wenn Jens einen Wischlappen holt, dann säubert er das Zimmer.

**Formulieren Sie die Aussagen in die Struktur, die in dieser Vorlesung eingeführt wurde.**

j - Jens
m - Mutter
WL - Wischlappen
Z - Zimmter

1) wachtAuf(j)
2) holt(j, Wischlappen) und existiert(WL)

* und säubert(j, Z) und existiert(Z) -> freuen(m)
* -> saubert(j, Z)

### Regelsysteme

a(x):x Element von A, b(x):x Element von B, usw.

R1 : a(x) -> b(x)

R2: b(x), c(x) -> d(x)

R3: a(x), c(x)  -> f(x)

R4: a(x), e(x) -> f(x)