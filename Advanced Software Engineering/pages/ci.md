## Continuous Delivery

### Definition

-   Vorgehensweise: soll sicherstellen, dass

 o SW immer in einem auslieferbaren Zustand ist

1.  Und automatisiert ausgeliefert (deployed) werden kann

-   Durch: Einführung einer hochautomatisierten
     Deployment-Pipeline (Lean-orientiert)

### Antipatterns

-   Manuelles Deployment in Produktion

-   Entwicklung/Tests nicht in produktivähnlicher Umgebung

-   Manuelle Verwaltung der Konfiguration

-   Manuelle Tests

### Release versus Deploy

-   Release: Version einer SW, die für Veröffentlichung außerhalb der
     Entwicklung geplant ist

-   release: Version einer SW wird einer best. Nutzergruppe zur
     Verfügung gestellt

-   Release-Kandidat: Jeder Stand einer SW, der als Release infrage
     kommt (CD -&gt; jede Version)

-   Deploy: Installation und Konfiguration einer Anw. in einer
     Zielumgebung

### Prinzipien

-   Wiederholbarer, verlässlicher Auslieferungsprozess

-   Möglichst hohe Automatisierung

-   Versioniere alles

-   Wenn es wehtut -&gt; mach es häufiger (Identifizierung)

-   Hohe Qualität

-   Fertig heißt deployed (min. auf Testsys.)

-   Jeder ist für Auslieferungsprozess verantwortlich (DevOps)

-   Kontinuierliche Verbesserung des Prozesses

### Deployment-Pipeline

-   Code durchläuft mehrere Phasen (Stages)

-   Jede Phase ist ein Quality Gate

-   Mit jeder Phase: Vertrauen in Funktion/Deploybarkeit steigt,
     Feedback-Geschwindigkeit sinkt

-   Beispiel: Commit Stage -&gt; Akzeptanztest -&gt; Kapazitätstest
     -&gt; Manuelle Tests -&gt; Release

### Bezug zu Lean Manufacturing?

### Richtlinien

-   Artefakte (Deliverables) werden in Commit-Phase genau einmal gebaut

-   Gleiche Deployment-Strategie u. Tools für alle Zielumgebunne

-   Nach Deployment: Smoke-Tests

-   Alle Tests in produktionsähnlicher Umgebung

-   Jede Änderung sofort durch Pipeline

-   Fehler? -&gt; Pipeline stoppen

-   Jeder Build -&gt; Schlägt fehl oder Release-Candidate

### Commit-Phase

**Aufgaben**

-   Kompilieren, Interne Release-Nummer erzeugen

-   Automatisierte Tests

-   Automatisierte statische Analyse

-   Erzeugung aller Artefakte für spätere Phasen (Doku, Testdaten)
     -&gt; Artefakt-Repository

**Artefakt-Repository**

-   Speichert alle erzeugten Artefakte

-   Spätere Phase: über ID auf Artefakt zugreifen

-   Verzeichnusstruktur auf Fileserver oft ausreichend

-   -&gt; Backup, aufräumen

### Akzeptanztest-Phase

**Aufgaben**

-   Zielumgebungen aufsetzen

-   Deployment der Artefakte in Zielumgebungen

-   Ausführen der Tests: Akzeptanz und Smoke

**Smoke-Tests**

-   Testet grundsätzliche Funktion vor Detailprüfung

-   Beispiel: Request gg. Anwendung

**Verteilung von Tests**

-   Autom. Akz.-Tests teuer in Erstellung/Unterhaltung

-   Wenn, dann: „Happy Path“ testen

<img src="./media/image18.jpeg" width="350" height="192" />

### Weitere Test-Phasen

-   Exploratory Testing

-   User Acceptance Tests

-   Lasttests

-   Sicherheitstests

### Deployment-Antipatterns

-   Doku statt Autom.

-   Untersch. Tools für untersch. Umgebungen

-   Manuelle Rollbacks

-   Manuelle Änderungen an Produktivumgebung

###Deployment-Bestpractices

-   Automatisierter Rollback-Plan

-   Blue-Green-Deployment

-   Canary Releases

-   Feature Toggles

-   Parallel Code Paths

<img src="./media/image19.jpeg" width="254" height="149" />

### Blue-Green-Deployment

-   Zwei identische Produktivumgebungen (doppelte Kosten)

-   Eine ist produktiv, andere ist Staging-Umgebung

-   Erlaubt schneller Rollback

### Canary-Releases

-   Beide Version gleichzeitig in Betrieb

-   Schritt für Schritt User umleiten

-   + Last kann langsam erhöht werden, + schnelles Rollback

-   - Höhere Kosten für Infra., - Routing komplex

### Features Toggles

-   Schalter, um best. Funktionen zu aktivieren

-   Möglich, wenn alle im Main-Branch arbeiten

-   - unübersichtlich

-   -&gt; Features in kleine Einheiten aufteilen

### Parallel Code Paths

-   Alter/neuer Code parallel ausführen

-   Ergebnisse vergleichen -&gt; Abweichung loggen

-   Keine Abweichung -&gt; Alten Code entfernen

-   + Prüfen von Refactoring

### CD-Tools

-   Infrastructure as Code-Tools

-   Virtualisierung (docker)

-   Build-Tools (maven)

-   Dependency-Management (maven)

-   Dependency-Tools (capistrano)

### Schritte zur Deployment-Pipeline

-   Wertstrom identifizieren

-   Walking Skeleton erstellen

-   Build, Deployment autom.

-   Unit Tests / Code Analyse autom.

-   Akzeptanztests autom.

-   Releases autom.

#### Vorteile

-   Weniger Risiko durch häufige Deployments

-   Schnelles Feedback

-   Mehr Vertrauen / Sicherheit in Funktionsfähigkeit

-   Schnelle, wiederholbare Prozesse statt Doku

-   Forciert Zusammenarbeit

#### Nachteile

-   Große Umstellung

-   Hoher Initialaufwand

-   Ggf. hohe Kosten (Akzeptanztests, HW, …)
