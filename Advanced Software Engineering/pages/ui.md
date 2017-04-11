## UI Entwicklung
### Sinnvoller Designprozess
- Workflow (Interface Designer) -> GUI (IF Designer / Grafiker) -> Businesslogik
(Programmierer)
### Definition von Usability
- Usability eines Produktes ist das Ausmaß, in dem es von einem Benutzer verwendet werden kann, um Ziele in einem Kontext effektiv, effizient und zufriedenstellend zu erreichen.
#### Wesentliche Elemente
-  Benutzer
-  Ziele
-  Kontext
#### Wesentliche Messgrößen
-  Effektivität
-  Effizienz
-  Zufriedenheit
#### 5Es
-  Effective: Vollständigkeit/Genauigkeit
-  Efficient: Geschwindigkeit
-  Engaging: Zufriedenheit
-  Error tolerant: Vermeidung von Fehlern
-  Easy to learn: Unterstützung bei erster Bedienung
#### User Centered Design Process
- Ziel: Benutzerfreundliche Oberfläche
- Analyse -> Design -> Implementierung -> Deployment
- Während Design und Implementierung auch Evaluation
#### Analyse
- Aufgabe: Informationen sammeln über
  Benutzer, Aktivitäten/Ziele, Umfeld
- Ziel: Mentales Modell des Produkts
Folie 9, 10, 12
##### Informationsquellen
- Marktforschung
- Interne Schulungsunterlagen
- Benutzer beobachten/interviewen
##### Informationen zum Benutzer
- Wichtigste Komponente: Benutzer
- Eigenschaften wie Name, Alter, Geschlecht, Bild, Job, Ziele, Domänenwissen, Umfeld
- Grundlage für Tester
- Vorteile:
  - Konkretes Bild eines Benutzers
  - Bessere Identifikation mit dem Benutzer
##### Mentales Modell
- Grundlage/Inhalt
  -  Probleme des Nutzers
  -  Ziele des Nutzers
  -  Daten, die der Nutzer verarbeitet
- Zusammen mit dem Kunden erstellen
- Verwendung der Begriffe des Benutzers
- Aufgabenspezifisch ohne UI-Begriffe
- => Zuerst die Funktion, dann das Aussehen
#### Objekt-Aktions-Analyse
- Welche Objekte und Aktionen gibt es?
- Beziehungen und Hierarchien festhalten
- Keine Implementierungsdetails
#### Regeln an ein mentales Modell
- Schlichtheit/Einfachheit
- Vertrautheit
- Flexibilität
- Sicherheit
- Affordances
### Lexikon
- Wörterbuch für Begrifflichkeiten
- Verständlich für den Benutzer
- Gleiche Aktion -> Gleicher Begriff
- Kompakt
- => Konsistenz zwischen SW und Doku
### Szenarios
- Beschreiben Abläufe einzelner Aktivitäten
- Blaupause für Usability-Test
#### Gemeinsame Diskussionsgrundlage
- Für alle einsehbar
- Blaupause für erste Implementierung
#### Vorteile
- Ziel / Aktivitäten bezogen: Festlegung von Relevanz und Beziehungen
- Wichtigkeit: Ordnung der einzelnen Komponenten
- Konsistenz: Definition allg. Aktionen, Verwendung einheitlicher UI, Einfache Korrekturmög.
### Design
- Aufgabe: Umfang und Aussehen der SW festlegen
- Anzahl der Features, Wichtigkeit der Features, Bedienkonzepte (Workflow)
- Ziel: Prototyp für Usability Tests und weitere Entwicklung
#### Umfang der Software
- Sicht des Benutzers Grundlage für die UI
- Verwende natürliche Abläufe und Begriffe
- So wenig Beschränkungen wie möglich
- Anzahl Features vs. Komplexität
- => Sichtweise des Benutzers auf die Aufgabe zählt
#### Anzahl Features versus Komplexität
- Standardwerte
- Templates
- Wizards
- Schrittweise Offenlegung
- Generische Befehle
- Aufgabenspezifisches Design
- Anpassungsfähigkeit
- Standardfall einfach erreichbar
  -  Arten: Anzahl Benutzer, Aufrufhäufigkeit
-  UI sorgfältig planen
- Benutzer die Kontrolle überlassen
- Minimale Änderung bei neuen Daten
#### Gestaltprinzipien
- Gute Beschreibung menschlicher Wahrnehmung
- Gute Richtline für UI-Design
- Grundlage für Bedienkonzepte
- Sind allgemeingültig
- Kombination ist möglich
- Erkenntnis über unterwünschte Gruppierung und Fokussierung
- Nach UI-Entwurf Prinzipien überprüfen und unerwünschte Effekte entfernen
- Prinzipien:
  -  Proximity: Nähe gruppiert
  -  Similarity: Ähnlichkeit gruppiert
  -  Closure: Offene Objekte werden geschlossen wahrgenommen
  - Figure/Ground: Einteilung in Voder- und Hintergrund (Vordergrund: Fokus)
  - Common Fate: Gemeinsame Bewegung wirken gruppiert
### Evaluation
- Paper Prototyping
- Expert Review
- Usability Testing
### Implementierung
- Antwortverhalten
- Gestaltungsrichtlinien
- GUI-Tests
### Usability nach Auslieferung
- Feldtest
- Logoanalyse
- Langzeitstudien
