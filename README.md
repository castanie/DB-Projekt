# DB-Projekt

Sie werden als Gruppe mit der Umsetzung einer Datenbankanwendung für eine regionale Buchungsplattform beauftragt. Sie erhalten folgende Informationen und Anforderungen:

### Miniwelt-Beschreibung:

Von einem Beherbergungsbetrieb sind der Name, die Adresse und Kontaktdaten (Tel, Email, Fax, Web Seite), sowie der Typ (Hotel, Pension, Ferienwohnung, Ferienhaus) und etwaige Social Media Accounts (Facebook, Twitter, Instagram, …) bekannt. Von Hotels ist darüber hinaus die Anzahl der Sterne bekannt.
Ein Beherbergungsbetrieb bietet eine oder mehrere Kategorien an. Von einer Kategorie sind dieBezeichnung, ein Beschreibungstext, die Anzahl der Betten sowie die Fläche in Quadratmeter bekannt. Ein Beherbergungsbetrieb verfügt über Einheiten. Jede Einheit gehört zu genau einer Kategorie und hat eine Bezeichnung (z.B. Zimmer 23). Diese Bezeichnung ist nur pro Betrieb eindeutig.
Für jede Kategorie sollen die Preise erfasst werden. In Hotels und Pensionen gelten Preise jeweils für einen bestimmten Gültigkeitszeitraum (von-Datum, bis-Datum) und eine Pensionsart (Vollpension, Halbpension, Frühstück) und pro erwachsene Person und Nacht. In Ferienhäusern und Ferienwohnungen gelten Preise ebenfalls für einen bestimmten Gültigkeitszeitraum. Jedoch wird hier pro Einheit und Nacht abgerechnet.
Beherbergungsbetriebe verwalten eine Gästekartei. Von Gästen sind folgende Daten relevant: Vorname, Nachname, Titel, Geburtsdatum, die Wohnadresse, sowie Kontaktinformationen (Emailadresse und Telefonnummer).
Gäste können einen Aufenthalt in einer Einheit eines Beherbergungsbetriebs buchen. Für Buchungen wird der Anreise- und Abreisetag, der Buchende (ein Gast), sowie gegebenenfalls weitere mitreisende Personen (die ebenfalls in der Gästekartei zu erfassen sind) erfasst. Es ist dabei sicherzustellen, dass eine Einheit (z.B. Zimmer 23) nicht überbelegt werden darf. Es darf also pro Einheit und Nacht immer nur eine Buchung vorliegen.

### Ihre Aufgabe:

1. Entwerfen Sie für die beschrieben Miniwelt ein konzeptuelles Modell als UML-Klassendiagramm. Geben Sie mögliche Schlüssel und eventuell getroffene Annahmen an. Achten Sie bei der Modellierung auf die Daumenregeln der guten Modellierung und auf die Modellqualität.
2. Überführen Sie das konzeptuelle Model in ein relationales Schema (SQL DDL).
+ Fügen Sie - falls nötig - Surrogatschlüssel ein.
+ Überprüfen Sie, ob Ihr Schema die BCNF und 4NF erfüllt. Wenn nicht, spalten Sie es entsprechend auf bzw. überdenken Sie Ihr UML-Klassendiagramm. Geben Sie zur Bestimmung der Normalform pro Tabelle die funktionalen Abhängigkeiten an.
+ Befüllen Sie Ihr Schema mit Beispieldaten. Mindestens 5 Datensätze pro Tabelle.
3. Implementieren Sie Klassen, um Beherbergungsbetriebe, Kategorien und Gäste anzulegen, zu ändern und zu löschen in Java (JDBC) analog zu Übungsblatt 10.
4. Darüber hinaus sind folgende Methoden in den geeigneten Klasse zu implementieren:
+ Eintragung einer neuen Buchung für eine bestimmte Einheit durch einen bestimmten Gast. Stellen Sie sicher, dass Doppelbuchungen nicht auftreten können. Dies kann wahlweise durch einen Trigger, oder durch Ihre Anwendungsmethode gesichert werden.
Tipp: Überlegen Sie sich zum Implementierung der Verhinderung von Doppelelbelegungen, welche allgemeinen Fälle von Kollisionen existieren können.
+ Schreiben Sie ein Testprogramm, das Ihre Methoden testet. Stellen Sie sicher, dass Sie in Ihrer Implementierung Transaktionen sinnvoll einsetzen, SQL Injektion Angriffe verhindert werden und Exceptions sinnvoll behandelt werden.

### Abgabe:

Geben Sie einen Projektbericht über die Punkte 1 und 2 sowie den kompilierbaren und dokumentierten Sourcecode von 3 und 4 ab (Projektverzeichnis als ZIP).

### Beurteilungskriterien:

+ Qualität des konzeptuellen Models (35%).
+ Qualität des relationalen Schemas (30%).
+ Vollständigkeit, Korrektheit und Sauberkeit der Implementierung, Robustheit gegen SQL Injection (35%).