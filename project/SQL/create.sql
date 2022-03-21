-- CORSISTA

create table corsista (
codcorsista int,
nomecorsista varchar2(30) not null,
cognomecorsista varchar2(30) not null,
precedentiformativi int,
constraint p_codicecorsista primary key (codcorsista));

-- ADMIN

create table admin (
codadmin int,
nomeadmin varchar2(30) not null,
cognomeadmin varchar2(30) not null,
constraint p_codadmin primary key (codadmin));

-- CORSO

create table corso (
codcorso int,
nomecorso varchar2(30) not null,
datainiziocorso date not null,
datafinecorso date not null,
commenticorso varchar2(200) not null,
aulacorso varchar2(30) not null,
constraint p_codcorso primary key (codcorso),
constraint data_check check (datainiziocorso < datafinecorso));

-- DOCENTE

create table docente (
coddocente int,
nomedocente varchar2(30) not null,
cognomedocente varchar2(30) not null,
cvdocente varchar2(150),
constraint p_coddocente primary key (coddocente));

-- CORSO_CORSISTA

create table corsocorsista (
codcorso int,
codcorsista int,
constraint f_codcorso foreign key (codcorso) references corso (codcorso),
constraint f_codcorsista foreign key (codcorsista) references corsista (codcorsista));

-- CORSO SEQ
create sequence corso_seq;

-- CORSISTA SEQ
create sequence corsista_seq;

-- DOCENTE SEQ
create sequence docente_seq;
