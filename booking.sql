--
-- Drop tables:
--

DROP TABLE aufenthalt CASCADE;
DROP TABLE betrieb CASCADE;
DROP TABLE buchung CASCADE;
DROP TABLE einheit CASCADE;
DROP TABLE gast CASCADE;
DROP TABLE kategorie CASCADE;
DROP TABLE preis CASCADE;
DROP TABLE social CASCADE;


--
-- Create tables:
--

CREATE TABLE betrieb (
    uid VARCHAR(14) NOT NULL,
    name VARCHAR(128) NOT NULL,
    typ VARCHAR(32) NOT NULL,
    sterne INT,
    adresse VARCHAR(256) NOT NULL,
    tel VARCHAR(15) NOT NULL,
    email VARCHAR(256) NOT NULL,
    fax VARCHAR(15),
    website VARCHAR(256),
    PRIMARY KEY (uid)
);

CREATE TABLE social (
    uid VARCHAR(14) NOT NULL,
    plattform VARCHAR(256) NOT NULL,
    account VARCHAR(64) NOT NULL,
    PRIMARY KEY (uid, plattform, account),
    FOREIGN KEY (uid) REFERENCES betrieb(uid) ON DELETE CASCADE
);

CREATE TABLE kategorie (
    katbez VARCHAR(128) NOT NULL,
    beschreibung VARCHAR(2048),
    betten INT NOT NULL,
    flaeche REAL NOT NULL,
    PRIMARY KEY (katbez)
);

CREATE TABLE einheit (
    uid VARCHAR(14) NOT NULL,
    zimmer VARCHAR(128) NOT NULL,
    katbez VARCHAR(128) NOT NULL,
    PRIMARY KEY (uid, zimmer),
    FOREIGN KEY (uid) REFERENCES betrieb(uid) ON DELETE CASCADE,
    FOREIGN KEY (katbez) REFERENCES kategorie(katbez) ON DELETE CASCADE
);

CREATE TABLE preis (
    katbez VARCHAR(128) NOT NULL,
    vondatum DATE NOT NULL,
    bisdatum DATE NOT NULL,
    pensionsart VARCHAR(128) NOT NULL,
    preis NUMERIC(12, 2) NOT NULL,
    PRIMARY KEY (katbez, vondatum, bisdatum, pensionsart),
    FOREIGN KEY (katbez) REFERENCES kategorie(katbez) ON DELETE CASCADE
);

CREATE TABLE gast (
    gastnr SERIAL,
    vorname VARCHAR(128) NOT NULL,
    nachname VARCHAR(128) NOT NULL,
    titel VARCHAR(128) NOT NULL,
    geburtsdatum DATE NOT NULL,
    wohnadresse VARCHAR(256) NOT NULL,
    tel VARCHAR(15) NOT NULL,
    email VARCHAR(256) NOT NULL,
    PRIMARY KEY (gastnr)
);

CREATE TABLE buchung (
    buchungnr SERIAL,
    uid VARCHAR(14) NOT NULL,
    zimmer VARCHAR(128) NOT NULL,
    anreise DATE NOT NULL,
    abreise DATE NOT NULL,
    gastnr INT NOT NULL,
    PRIMARY KEY (buchungnr),
    FOREIGN KEY (uid, zimmer) REFERENCES einheit(uid, zimmer) ON DELETE CASCADE,
    FOREIGN KEY (gastnr) REFERENCES gast(gastnr) ON DELETE CASCADE
);

CREATE TABLE aufenthalt (
    buchungnr INT NOT NULL,
    gastnr INT NOT NULL,
    PRIMARY KEY (buchungnr, gastnr),
    FOREIGN KEY (buchungnr) REFERENCES buchung(buchungnr) ON DELETE CASCADE,
    FOREIGN KEY (gastnr) REFERENCES gast(gastnr) ON DELETE CASCADE
);


--
-- Create triggers:
--

CREATE OR REPLACE FUNCTION check_duplicate()
RETURNS trigger AS
$$
BEGIN
    IF EXISTS
    (
        SELECT 1 FROM buchung
        WHERE NEW.uid = uid AND NEW.zimmer = zimmer
        AND (NEW.anreise, NEW.abreise) OVERLAPS (anreise, abreise)
    )
    THEN
        RETURN NULL;
    ELSE
        RETURN NEW;
    END IF;
END;
$$
LANGUAGE plpgsql;

DROP TRIGGER IF EXISTS on_buchung ON buchung;
CREATE TRIGGER on_buchung
BEFORE INSERT ON buchung
FOR EACH ROW
EXECUTE PROCEDURE check_duplicate();


--
-- Insert values:
--

INSERT INTO betrieb VALUES ('AT0123456789', 'Company One', 'Hotel', 5, 'Klagenfurt', '+0123456789', 'one@company.com', NULL, NULL);
INSERT INTO betrieb VALUES ('AT1234567890', 'Company Two', 'Pension', NULL, 'Villach', '+1234567890', 'two@company.com', NULL, NULL);
INSERT INTO betrieb VALUES ('AT2345678901', 'Company Three', 'Ferienwohnung', NULL, 'Spittal', '+2345678901', 'three@company.com', NULL, NULL);
INSERT INTO betrieb VALUES ('AT3456789012', 'Company Four', 'Ferienhaus', NULL, 'Wolfsberg', '+3456789012', 'four@company.com', NULL, NULL);
INSERT INTO betrieb VALUES ('AT4567890123', 'Company Five', 'Hotel', NULL, 'Hermagor', '+4567890123', 'five@company.com', NULL, NULL);

INSERT INTO social VALUES ('AT0123456789', 'Twitter', 'zero');
INSERT INTO social VALUES ('AT1234567890', 'Twitter', 'uno');
INSERT INTO social VALUES ('AT2345678901', 'Twitter', 'due');
INSERT INTO social VALUES ('AT3456789012', 'Twitter', 'tre');
INSERT INTO social VALUES ('AT4567890123', 'Twitter', 'quattro');

INSERT INTO kategorie VALUES ('Besenkammer', 'Lorem ipsum dolor sit amet, consectetur adipisici elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquid ex ea commodi consequat.', 1, 2.0);
INSERT INTO kategorie VALUES ('Einzelzimmer', 'Lorem ipsum dolor sit amet, consectetur adipisici elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquid ex ea commodi consequat.', 1, 7.0);
INSERT INTO kategorie VALUES ('Doppelzimmer', 'Lorem ipsum dolor sit amet, consectetur adipisici elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquid ex ea commodi consequat.', 2, 9.0);
INSERT INTO kategorie VALUES ('Seeblick Klein', 'Lorem ipsum dolor sit amet, consectetur adipisici elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquid ex ea commodi consequat.', 2, 11.0);
INSERT INTO kategorie VALUES ('Seeblick Groß', 'Lorem ipsum dolor sit amet, consectetur adipisici elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquid ex ea commodi consequat.', 2, 13.0);

INSERT INTO einheit VALUES ('AT0123456789', '001', 'Besenkammer');
INSERT INTO einheit VALUES ('AT1234567890', '101', 'Einzelzimmer');
INSERT INTO einheit VALUES ('AT2345678901', '201', 'Doppelzimmer');
INSERT INTO einheit VALUES ('AT3456789012', '301', 'Seeblick Klein');
INSERT INTO einheit VALUES ('AT4567890123', '401', 'Seeblick Groß');

INSERT INTO preis VALUES ('Besenkammer', NOW(), NOW(), 'Vollpension', 30.00);
INSERT INTO preis VALUES ('Einzelzimmer', NOW(), NOW(), 'Halbpension', 40.00);
INSERT INTO preis VALUES ('Doppelzimmer', NOW(), NOW(), 'Frühstück', 50.00);
INSERT INTO preis VALUES ('Seeblick Klein', NOW(), NOW(), 'Vollpension', 60.00);
INSERT INTO preis VALUES ('Seeblick Groß', NOW(), NOW(), 'Halbpension', 80.00);

INSERT INTO gast VALUES (DEFAULT, 'AV', 'AN', 'Herr', NOW(), 'Somewhere', '+0', 'a@outlook.com');
INSERT INTO gast VALUES (DEFAULT, 'BV', 'BN', 'Frau', NOW(), 'Somewhere', '+1', 'b@outlook.com');
INSERT INTO gast VALUES (DEFAULT, 'CV', 'CN', 'Herr', NOW(), 'Somewhere', '+2', 'c@outlook.com');
INSERT INTO gast VALUES (DEFAULT, 'DV', 'DN', 'Frau', NOW(), 'Somewhere', '+3', 'd@outlook.com');
INSERT INTO gast VALUES (DEFAULT, 'EV', 'EN', 'Herr', NOW(), 'Somewhere', '+4', 'e@outlook.com');

INSERT INTO buchung VALUES (DEFAULT, 'AT0123456789', '001', NOW(), NOW(), 1);
INSERT INTO buchung VALUES (DEFAULT, 'AT1234567890', '101', NOW(), NOW(), 1);
INSERT INTO buchung VALUES (DEFAULT, 'AT2345678901', '201', NOW(), NOW(), 1);
INSERT INTO buchung VALUES (DEFAULT, 'AT3456789012', '301', NOW(), NOW(), 1);
INSERT INTO buchung VALUES (DEFAULT, 'AT4567890123', '401', NOW(), NOW(), 1);

INSERT INTO aufenthalt VALUES (1, 1);
INSERT INTO aufenthalt VALUES (2, 2);
INSERT INTO aufenthalt VALUES (3, 3);
INSERT INTO aufenthalt VALUES (4, 4);
INSERT INTO aufenthalt VALUES (5, 5);