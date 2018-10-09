-- Script per la creazione delle tabelle del database dell'applicazione xSounds

CREATE USER xsounds WITH PASSWORD 'xsounds';

-- Domini aggiuntivi
-- Tipo dell'articolo musicale
CREATE DOMAIN TipoArticolo AS VARCHAR(3) 
    CHECK(VALUE IN('CD', 'DVD'));
-- Modalità di consegna per la spedizione dei prodotti
CREATE DOMAIN ModConsegna AS VARCHAR(8)
    CHECK(VALUE IN('Corriere', 'Posta', 'Rapida'));
-- Modalità di pagamento per un acquisto
CREATE DOMAIN ModPagamento AS VARCHAR(16)
    CHECK(VALUE IN('Bonifico', 'Carta di credito', 'Paypal'));


-- Generi musicali
DROP TABLE IF EXISTS Genere CASCADE;
CREATE TABLE Genere (
    nome    VARCHAR(100) PRIMARY KEY
); 	

-- Musicisti e band
DROP TABLE IF EXISTS Musicista CASCADE;
CREATE TABLE Musicista (
    id         INTEGER PRIMARY KEY,
    nome_arte  VARCHAR(100) NOT NULL,
    anno       INTEGER CHECK(anno >= 0 AND anno <= 2017),
    genere     VARCHAR(100) REFERENCES Genere(nome)
        ON DELETE SET NULL ON UPDATE SET NULL
);

-- Strumenti musicali
DROP TABLE IF EXISTS Strumento CASCADE;
CREATE TABLE Strumento (
    nome    VARCHAR(100) PRIMARY KEY
);

-- Articoli musicali (CD e DVD)
DROP TABLE IF EXISTS Articolo CASCADE;
CREATE TABLE Articolo (
    id        INTEGER PRIMARY KEY,
    titolo    TEXT NOT NULL,
    prezzo    NUMERIC(6,2) DEFAULT 0.00,
    quantita  INTEGER NOT NULL DEFAULT 0,
    data      DATE NOT NULL DEFAULT '2017-01-01',
    descr     TEXT,
    tipo      TipoArticolo NOT NULL,
    copertina TEXT,
    titolare  INTEGER NOT NULL
        REFERENCES Musicista(id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    CHECK(quantita >= 0),
    CHECK(prezzo >= 0.00)
);

-- Genere di appartenenza di un CD/DVD
DROP TABLE IF EXISTS Genere_appartenenza CASCADE;
CREATE TABLE Genere_appartenenza (
    id_articolo  INTEGER REFERENCES Articolo(id),
    genere       VARCHAR(100) REFERENCES Genere(nome),
    PRIMARY KEY(id_articolo, genere)
);

-- Relazione tra musicista e strumento suonato
DROP TABLE IF EXISTS Suona CASCADE;
CREATE TABLE Suona (
    id_musicista INTEGER
        REFERENCES Musicista(id) ON DELETE CASCADE ON UPDATE CASCADE,
    strumento    VARCHAR(100)
        REFERENCES Strumento(nome) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY(id_musicista, strumento)
);

-- Pezzi musicali
DROP TABLE IF EXISTS Pezzo_musicale CASCADE;
CREATE TABLE Pezzo_musicale (
    id     INTEGER REFERENCES Articolo(id)
        ON DELETE CASCADE,
    titolo TEXT,
    durata TIME CHECK(durata >= '00:00:00'),
    PRIMARY KEY(id, titolo)
);

-- Musicisti in un CD/DVD
DROP TABLE IF EXISTS Suonato_da CASCADE;
CREATE TABLE Suonato_da (
    id_articolo  INTEGER REFERENCES Articolo(id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    musicista    INTEGER REFERENCES Musicista(id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY(id_articolo, musicista)
);

-- Clienti
DROP TABLE IF EXISTS Cliente CASCADE;
CREATE TABLE Cliente (
    cod_fis     CHAR(16) PRIMARY KEY, 
    nome_utente TEXT UNIQUE,
    nome        VARCHAR(50) NOT NULL,
    cognome     VARCHAR(50) NOT NULL,
    citta       TEXT NOT NULL,
    email       TEXT NOT NULL,
    password    TEXT NOT NULL,
    n_tel       VARCHAR(20) NOT NULL,
    n_cel       VARCHAR(20),
    data        DATE
);

-- Vendite
DROP TABLE IF EXISTS Vendita CASCADE;
CREATE TABLE Vendita (
    id            SERIAL PRIMARY KEY,
    prezzo_compl  NUMERIC(6,2) NOT NULL,
    data_e_ora    TIMESTAMP NOT NULL,
    mod_consegna  ModConsegna NOT NULL,
    mod_pagamento ModPagamento NOT NULL,
    cod_pagamento VARCHAR(50) NOT NULL,    -- codice inserito in schermata Acquista a seconda del metodo
    ip            TEXT,
    cod_cliente   CHAR(16)
         REFERENCES Cliente(cod_fis) ON DELETE CASCADE
);

-- Prodotti_acquistati
DROP TABLE IF EXISTS Prodotti_acquistati CASCADE;
CREATE TABLE Prodotti_acquistati(
    id_vendita INTEGER REFERENCES Vendita(id)
        ON DELETE CASCADE ON UPDATE CASCADE, 
    id_articolomusicale INTEGER REFERENCES Articolo(id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY(id_vendita, id_articolomusicale)
);

-- Permessi utente
GRANT SELECT, UPDATE, DELETE, INSERT
  ON ALL TABLES IN SCHEMA public
  TO xsounds;
  
GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA public TO xsounds;
