-- ADMIN

insert into AMMINISTRATORE values(1, 'Carlo', 'Martello');
insert into AMMINISTRATORE values(2, 'Sandra', 'Raimondi');
insert into AMMINISTRATORE values(3, 'Sara', 'Banda');
insert into AMMINISTRATORE values(4, 'Eugenio', 'Verdi');

-- CORSO

insert into CORSO values(corso_seq.nextval, 'Java', '12-MAR-2022', '16-MAR-2022', 'Corso di Java Advanced', 720, '12A');
insert into CORSO values(corso_seq.nextval, 'JavaScript', '11-MAR-2022', '18-MAR-2022', 'Corso di JavaScript Basic', 100, '4C');
insert into CORSO values(corso_seq.nextval, 'Java EE', '25-APR-2022', '12-MAG-2022', 'Corso di Java EE', 530, '7B');
insert into CORSO values(corso_seq.nextval, 'PHP', '27-MAR-2022', '01-APR-2022', 'Corso di PHP Intermediate', 900, '8L');

-- DOCENTE

insert into DOCENTE values(docente_seq.nextval, 'Max', 'Ghianda', '');
insert into DOCENTE values(docente_seq.nextval, 'Ettore', 'Mirabile', '');
insert into DOCENTE values(docente_seq.nextval, 'Antonia', 'Penna', '');
insert into DOCENTE values(docente_seq.nextval, 'Artura', 'Spillatrice', '');
insert into DOCENTE values(docente_seq.nextval, 'Ettora', 'Pila', '');