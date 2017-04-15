## DevOps

### Was ist DevOps?

#### Defintion
-   Development Operations, Bewegung
-   Ziel: Reduzierung der Time-To-Market einer Änderungseinheit - bei
     gleichzeitiger Gewährleistung hoher Qualität
-   Erreichen durch: Konsequente Anwendung von Lean-Prinzipien auf
     gesamten SW-Wertstrom

#### Warum DevOps?
-   Entwickler sollen Veränderungen schnell umsetzen
-   Admins sollen Sicherheit/Stabilität der Systeme gewährtleisten
-   -&gt; Zielkonflikt, Silo-Denken (starkes Abteilungsdenken),
     Stereotypen, Mauer zw. Dev und Ops
-   -&gt; Agile Methoden erhöhen Dev-Geschw. -&gt; Mehr Druck auf Ops

### Conway’s Law

Teams, die nicht gut zusammenarbeiten produzieren Lösungen, die nicht
gut zusammenarbeiten

### Konsequenzen von Silodenken
-   Mehr/Längere Systemausfälle
-   Mehr Fehler
-   Höheres Risiko
-   Angst vor Veränderung
-   Längere Time-To-Market, schlechtere Qualität
-   Wertstrom stoppt an der Mauer zu Operations
-   Viel Zeit geht verloren (Verschwendung) – Features fertig, aber
     nicht produktiv verfügbar

Folie 18? 26?

### DevOps-Prinzipien – CALMS
#### Culture
##### Ziel
-   Hauptziel von DevOps: Veränderung der Organisationskultur
-   Silos zu Kollaboration
-   Schuldzuweisung zu gemeinsamer Verantwortung
-   Für die erstellten Produkte/Leistungen und Prozesse

##### Definition von Organisationskultur
-   Abstraktes, komplexes Konzept, schwer messbar
-   Glaubenssätze, Haltungen, welche ein Kontext für alles in der
     Organistation bilden
-   Hat Einfluss auf Erreichen der Ziele
##### Kulturmerkmale von DevOps
-   Respekt
-   Vertrauen
-   No-Blame
-   Growth Mindset
-   Gemeinsame Anreize
-   Kollaboration
##### Blame-Kultur – No-Blame-Kultur
-   Nicht Individuen, sondern Situationen führen zu Fehlern
-   Suche nach Ursachen statt nach einem Sündenbock
-   Blame Kultur: Fehler werden verschleiert (Verschwendung)
##### 5-Why-Methode
-   Methode zur Bestimmung von Ursache und Wirkung
-   So lange „Warum“ fragen bis Ursache klar ist
##### Fixed Mindset vs. Growth Mindset
-   Fixed: Fähigkeiten sind gegeben, Fehler sind Resultat ungenügender
     Fähigkeiten, Tendenz sich nicht blamieren zu wollen
-   Growth: Fähigkeiten können verbessert werden, Fehler sind
     Gelegenheit zu verbessern, Tendenz nach Rückschlägen
     weiterzuarbeiten
##### Gemeinsame Anreize
Team wird belohnt, bei Lieferung von Wert für Kunden, gemeinsame
Verbesserung des Flusses von Wert zum Kunden

##### Kollaboration
-   Abhängig vom Unternehmen
-   Beispiel: Bereichsübergreifende Teams, Austausch von Experten etc.

#### Automation
##### Automatisierung
-   Wesentliches Hilfsmittel zur Optimierung des Wertstroms
-   Durch: Eliminierung von Verschwendung und Einführung eines def.
     Arbeitsablaufs
-   Wichtig ist, zu wissen, wann es sich lohnt zu automatisieren und
     wann nicht

##### Automatisierungsstufen

- Automatisierte Entwicklungsumgebung (Setup, build, test, check)

- Continuous Integration
  -   Automatisierter Bauvorgang aller Artefakte (deliverables)

  -   Automatisierte Tests

  -   Automatisierte Code-Analyse

  -   **SW kann immer gebaut werden und erfüllt gewisse
         Qualitätskriterien**

-  Continuous Delivery: CI + Staging

    -   Automatisierte Installation/Konfiguration der Zielumgebungen

    -   Automatisierte Akzeptanz- und Kapazitätstests

    -   Automatisiertes Deployment in Testumgebungen

    -   ABER: **Manuelles Auslösen des Deployments in Produktion, SW
         könnte jederzeit** **deployed werden**

-  Continuous Deployment : CD + Automatisches Deployment

    -   Änderung alle Stages erfolgreich durchlaufen? -&gt; automatisch
         deployed

##### DevOps und Automatisierung

-   Ziel ist nicht die Automatisierung des Wertstroms

-   Bereichsübergreifende Automatisierung zwischen Entwicklung und
     Produktivbetrieb -&gt; Zusammenarbeit bzgl. Installation und
     Konfiguration der Zielumgebungen

-   Lösung: Infrastructure as Code

##### Infrastructure as Code

-   Infrastruktur wie SW behandeln

-   Anweisungen für das Aufsetzen der Umgebungen -&gt; Teil des
     Quellcodes

-   Änderung an Infrastruktur -&gt; Änderung an Quellcode

-   Keine Blaupause für ein Unternehmen -&gt; Angepasst an Abläufe,
     Rechenzentren etc.

-   Beispiele: Ansible, Chef

##### Vorteile von Infrastructure as Code

-   Keine Shadow-IT
-   Erhöhung der Effizienz
-   Infrastruktur wird mit Code kontinuierlich getestet/verwaltet
-   Änderungen an Infrastruktur werden versioniert
-   Zusammenarbeit von Dev und Ops wird forciert

##### Wann lohnt sich Automatisierung

-   Wenn im relevanten Maß Zeit gespart wird: Legacy-Systeme einzubinden
     kostet viel Zeit
-   Zeitinvestitionen sind nicht immer vergleichbar (Rollback-Script
     versus Change Log)
-   Zeitersparnis kann auch anderen zugutekommen und multipliziert sich
     dann

##### Automatisierungs-Paradoxon

Je höher der Grad der Automatisierung, umso kompetenter der Verwalter

###### Automatisierungs-Ironie

Grundlagen des Prozesses werden verlernt, Problem: Fehlerfall

### Lean

#### Was ist Lean?

-   Philosophie
-   Ziel: Kontinuierliche Verbesserung eines Prozesses
-   Durch: Eliminierung von Verschwendung, Bedürfnisse der Kunden sind
     Ausgangspunkt allen Handelns

#### Verschwendungen

-   Muda: Menschliche Aktivität, die Ressourcen verbraucht, aber keinen
     Wert erzeugt

    - Bsp: Materialbewegung, Bestände, Wartezeit, Überproduktion,
         Korrekturen/Fehler

-   Mura: Unausgeglichenheit, Unausgewogenheit, Inkonsistenz

-   Muri: Überlastung von Menschen/Maschinen

#### Lean-Prinzipien

1.  Zu produzierenden Wert aus Sicht des Kunden definieren

    -   Wert: Leistung, die den Anforderungen des Kunden hinsichtlich
         Qualität, Verfügbarkeit, Preis entspricht ( was der Kunde
         kauft )

2.  Wertstrom identifizieren

    -   Alle nicht wertschöpfenden und wertschöpfenden Aktivitäten, die
         notwendig sind, um ein Produkt/DL herzustellen/anzubieten

    -   Ziel des Wertstroms: Kunden zufriedenstellen

    -   Jeder Wertstrom umfasst 1 oder mehrere Geschäftsprozesse

    -   Unterscheidung nach

        1.  Wertschöpfender Tätigkeit

        2.  Nicht wertschöpfende Tätigkeit, die unvermeidbar ist

        3.  Nicht wertschöpfende Tätigkeit, die vermeidbar
             ist (Verschwendung)

    -   Dient insb. der Aufdeckung von Verschwendung

    -   Forciert ganzheitliche Betrachtung aller am Wertstrom
         beteiligten Prozesse

    -   Trägt bei zu Siloübergreifende Optimierung des Gesamtprozesses

Beispiel für einen Wertstrom

<img src="./media/image17.jpeg" width="400" height="162" />

1.  Fluss-Prinzip umsetzen

    -   Produkt/Leistung soll zum Kunden fließen, möglichst:

        1.  Kontinuierlich

        2.  Mit wenigen Wartezeiten / Umwegen

        3.  Über alle Abteilungen/Stationen hinweg

        4.  In kleinen Änderungseinheiten (z.B. Features)

            1.  Geringere Mean Time To Repair

            2.  Geringere Time To Market

    -   Erreicht durch Beseitigung der identifizierten Verschwendung

2.  Pull-Prinzip einführen

    -   Nur produzieren, was der Kunde und wann er es will

3.  Perfektion anstreben

    -   4 Schritte werden kontinuierlich gemessen und hinterfragt

    -   -&gt; Verbesserungspotentiale

    -   Ziel: Jede Tätigkeit/jedes Gut trägt zum Wert für den Kunden bei

### Metrics

#### Intention: DevOps messen

-   Messen damit kontinuierlich verbessert werden kann

-   Klassische Metriken für SW-Entwicklung

-   Metriken, die die Leistungsfähigkeit des gesamten Wertstroms
     aufdecken

#### Klassische SW-Metriken

-   Lines of Code, Zyklomatische Komplexität, Testabdeckung, Stil

#### Klassische Ops-Metriken

-   Uptime, Antwortzeiten, Ressourcen-Auslastung

#### DevOps-Metriken
- Betreffen gesamten Wertstrom

| **Durchsatz**  | **Stabilität**    |
| ---------------| ----------------  |
| Häufigkeit von Deployments in Produktion   | Mittlere Reparaturzeit   |
| Änderungs-Durchlaufzeit  | Fehlerrate in Produktion                   |

- Häufigkeit von Deployments in Produktion

1.  Einfach messbar, ggf. Unterscheidung in erfolgreich / nicht
     erfolgreich

-   Änderungs-Durchlaufzeit „Change Lead Time“

    1.  Zeit von Änderungseinheit von Beginn der Arbeit bis zum
         Deployment in Produktion

    1.  Frage: Wann beginnt Arbeit? -&gt; Erfassen der Änderungseinheit

    1.  = Time To Market

    1.  Zykluszeit: Ab Beginn der Entwicklung bis Ende der Entwicklung

-   Mittlere Reperaturzeit –Mean Time To Repair (MTTR)

    1.  Zeit zw. Feststellung eines Fehlers in Produktion und dessen
         Beseitigung
    1.  Z.B. Durchlaufzeit von Issues „Bug“

-   Fehlerrate in Produktion „Change Failure Rate“

    1.  Zahl der Bugs in Produktion

 o Einfach messbar, ggf. unterscheidbar nach Schwere, Messung von
 Reaktionszeit

#### Zusammenhang zwischen Durchsatz und Stabilität

*Häufige Deployments und kurze Durchlaufzeiten
können Stabilität, Fehlerrate und
Reaktionszeiten extrem verbessern.*

### Share

-   Verantwortung, Ziele, Information, Wissen, Code und Tools, …

-   Know-How: Verstehen von Ebenen überhalb und unterhalb der eigenen
     Ebene

#### Kritik

-   Sicherheit/Stabilität manchmal wichtiger als Geschwindigkeit, wird
     vernachlässigt

-   Ggf. Architektur ungeeignet

-   Ggf. Anforderung ungeeignet

#### Fazit

-   Abhängig von Organisation, Kultur, Softwareausstattung

-   Beginnen mit schneller Auslieferung ohne Qualitätseinbußen

-   Herausfinden, wo DevOps Sinn macht: Wo Geschwindigkeit wichtig ist

-   Mehr als IT-Methode: Unternehmensweite Transformation

-   Kann Produktivität und Markteinführungszeiten von SW verbessern

#### Ausblick

-   DevSec: Sicherheit in den Prozessen verankern

-   Bimodale IT: Zwei Arten von IT, traditionell (Tagesgeschäft) und
     agil (Innovation)
