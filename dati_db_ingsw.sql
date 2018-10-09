-- Script per popolare il database

-- Generi
INSERT INTO Genere (nome)
    VALUES ('Rock'),
           ('Folk'),
           ('Classica'),
           ('Latin'),
           ('World music'),
           ('Jazz'),
           ('Punk'),
           ('Elettronica'),
           ('Metal'),
           ('Funk'),
           ('Pop');

-- Musicisti
INSERT INTO Musicista (id, nome_arte, anno, genere)
    VALUES (0, 'Pharrell Williams', 1980, 'Funk'),
           (1, 'Miley Cyrus', 1985, 'Pop'),
           (2, 'Daft Punk', 1990, 'Elettronica'),
           (3, 'Alicia Keys', 1980, 'Pop'),
           -- g i r l
           (4, 'Miles Davis', 1926, 'Jazz'), -- trumpet
           (5, 'Bill Evans', 1929, 'Jazz'),  -- piano
           -- kind of blue
           (6, 'Johnny Rotten', 1956, 'Punk'),
           (7, 'Steve Jones', 1955, 'Punk'),
           (8, 'Sid Vicious', 1957, 'Punk'),
           (9, 'Paul Cook', 1956, 'Punk'),
           (10, 'Sex Pistols', 1975, 'Punk'),
           -- never mind the bollocks
           (11, 'Clean Bandit', 2008, 'Elettronica'),
           (12, 'Jess Glynne', 1989, 'Elettronica'),
           (13, 'Sharna Bass', 1990, 'Elettronica'),
           (14, 'Love Ssega', 1990, 'Elettronica'),
           -- new eyes
           (15, 'Queen', 1970, 'Rock'),
           (16, 'Freddie Mercury', 1946, 'Rock'),
           (17, 'Brian May', 1950, 'Rock'),
           (18, 'Roger Taylor', 1950, 'Rock'), -- drum
           (19, 'John Deacon', 1950, 'Rock'),  -- bass
           -- news of the world
           (20, 'Velvet Underground', 1964, 'Rock'),
           (21, 'Lou Reed', 1942, 'Rock'),
           (22, 'John Cale', 1942, 'Rock'),
           (23, 'Sterling Morrison', 1942, 'Rock'),
           (24, 'Moe Tucker', 1944, 'Rock'),
           -- vari
           (25, 'Laura Pausini', 1970, 'Pop'),
           (26, 'Juanes', 1970, 'Pop'),
           (27, 'Johnny Hallyday', 1970, 'Pop'),
           -- io canto
           (28, 'Elisa', 1965, 'Pop'),
           -- on
           (29, 'Shakira', 1975, 'Latin'),
           -- fijaciòn oral vol. 1
           (30, 'Inna', 1985, 'Elettronica'),
           -- party never ends
           (31, 'Ed Sheeran', 1985, 'Pop'),
           (32, 'Paean', 1985, 'Pop'),
           (33, 'Johnny McDaid', 1985, 'Pop'),
           -- ÷
           (34, 'Imagine Dragons', 2005, 'Pop');
           -- evolve


INSERT INTO Strumento (nome)
    VALUES ('Voce'),
           ('Chitarra'),
           ('Basso'),
           ('Batteria'),
           ('Tromba'),
           ('Piano');

INSERT INTO Articolo (id, titolo, prezzo, quantita, data, descr, tipo, copertina, titolare)
    VALUES (0, 'G I R L', 2.90, 10, '2017-08-30',
            'G I R L è il secondo album in studio del cantante statunitense Pharrell Williams, pubblicato il 3 marzo 2014 dalle etichette Black Lot Music e Columbia in collaborazione con l''etichetta fondata da Pharrell Williams, i am OTHER.',
            'CD', NULL, 0),
           (1, 'Kind of blue', 10.00, 4, '2017-08-30',
            'Kind of Blue è un album realizzato da Miles Davis nel 1959 ed entrato nella storia del jazz, essendo fra i più venduti di sempre ed uno dei primi esempi di modal jazz.',
            'CD', NULL, 4),
           (2, 'Never mind the bollocks', 12.00, 5, '2017-08-30',
            'Never Mind the Bollocks, Here''s the Sex Pistols, pubblicato dalla Virgin Records il 28 ottobre 1977, è l''unico vero e proprio album ufficiale di studio, inciso dal gruppo punk rock Sex Pistols.',
            'CD', NULL, 10),
           (3, 'New eyes', 8.50, 15, '2017-08-30',
            'New Eyes è l''album di debutto dei Clean Bandit pubblicato il 30 maggio 2014 dall''etichetta Atlantic Records.',
            'CD', NULL, 11),
           (4, 'News of the world', 7.50, 5, '2017-08-30',
            'News of the World è il sesto album della rock-band britannica Queen, pubblicato per la prima volta in LP il 28 ottobre 1977.',
            'CD', NULL, 15),
           (5, 'Velvet Underground & Nico', 11.00, 10,'2017-08-30',
            'The Velvet Underground & Nico è il primo album dei Velvet Underground, gruppo musicale rock statunitense, registrato con la collaborazione vocale della cantante tedesca Nico nel 1966 e pubblicato nel 1967 dalla etichetta Verve Records.',
            'CD', NULL, 20),
           (6, 'Io canto', 4.99, 12, '2017-08-30',
            'Io canto è il decimo album ufficiale della cantante italiana Laura Pausini pubblicato in Italia il 10 novembre 2006 e in Francia il 13 novembre. È il suo ottavo album in studio e il primo album di cover.',
            'CD', NULL, 25),
           (7, 'On', 4.99, 17, '2017-08-30',
            'On è il nono album in studio della cantautrice italiana Elisa, pubblicato il 25 marzo 2016 dalla Sugar Music. Anticipato dal singolo No Hero, l''album segna il ritorno di Elisa alla scrittura in lingua inglese delle sue canzoni, dopo l''album completamente in italiano L''anima vola del 2013.',
            'CD', NULL, 28),
           (8, 'Fijación oral vol. 1', 4.99, 9, '2017-08-30',
            'Fijación oral vol. 1 (in inglese: Oral Fixation Vol. 1) è il sesto album della cantautrice colombiana Shakira. È il primo album in spagnolo della cantante dopo l''album ¿Dónde están los ladrones? del 1998.',
            'CD', NULL, 29),
           (9, 'Party never ends', 7.99, 9, '2017-08-30',
            'Party Never Ends è il terzo album della cantante rumena Inna, pubblicato il 1º marzo 2013 in Romania.',
            'CD', NULL, 30),
           (10, '÷', 6.00, 13, '2017-08-30',
            '÷ (stilizzazione di Divide) è il quinto album in studio del cantautore britannico Ed Sheeran, pubblicato il 3 marzo 2017 dalla Atlantic Records.',
            'CD', NULL, 31),
           (11, 'Evolve', 12.00, 5, '2017-08-30',
            'Evolve (stilizzato ƎVOLVE) è il terzo album in studio del gruppo musicale statunitense Imagine Dragons, pubblicato il 23 giugno 2017 dalla Interscope Records.',
            'CD', NULL, 34);


INSERT INTO Genere_appartenenza (id_articolo, genere)
    VALUES (0, 'Funk'),
           (1, 'Jazz'),
           (2, 'Punk'),
           (3, 'Elettronica'),
           (4, 'Rock'),
           (5, 'Rock'), 
           (6, 'Pop'),
           (7, 'Pop'),
           (8, 'Latin'),
           (9, 'Elettronica'),
           (10, 'Pop'),
           (11, 'Pop');

INSERT INTO Suonato_da (id_articolo, musicista)
    VALUES (0, 0),
           (0, 1),
           (0, 2),
           (0, 3),
           --
           (1, 4),
           (1, 5),
           --
           (2, 6),
           (2, 7),
           (2, 8),
           (2, 9),
           --
           (3, 12),
           (3, 13),
           (3, 14),
           --
           (4, 16),
           (4, 17),
           (4, 18),
           (4, 19),
           --
           (5, 21),
           (5, 22),
           (5, 23),
           (5, 24), 
           --
           (6, 25),
           (6, 26),
           (6, 27),
           --
           (7, 28),
           --
           (8, 29),
           --
           (9, 30),
           --
           (10, 31),
           (10, 32),
           (10, 33);


-- Inserimento delle copertine
UPDATE Articolo 
  SET copertina = 'img/0.jpg'
  WHERE id = 0;
  

UPDATE Articolo 
  SET copertina = 'img/1.jpg'
  WHERE id = 1;


UPDATE Articolo 
  SET copertina = 'img/2.jpg'
  WHERE id = 2;
  

UPDATE Articolo 
  SET copertina = 'img/3.jpg'
  WHERE id = 3;
  

UPDATE Articolo 
  SET copertina = 'img/4.jpg'
  WHERE id = 4;


UPDATE Articolo 
  SET copertina = 'img/5.jpg'
  WHERE id = 5;
  

UPDATE Articolo 
  SET copertina = 'img/6.jpg'
  WHERE id = 6;
  

UPDATE Articolo 
  SET copertina = 'img/7.jpg'
  WHERE id = 7;
  

UPDATE Articolo 
  SET copertina = 'img/8.jpg'
  WHERE id = 8;
  

UPDATE Articolo 
  SET copertina = 'img/9.jpg'
  WHERE id = 9;
  

UPDATE Articolo 
  SET copertina = 'img/10.jpg'
  WHERE id = 10;
  

UPDATE Articolo 
  SET copertina = 'img/11.jpg'
  WHERE id = 11;



