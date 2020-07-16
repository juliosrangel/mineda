create schema brasfut;

create user 'user'@'localhost' indentified by '123456';
grant select, insert, delete, update on brasfut.* to user@'localhost';

use brasfut;

create table usr_usuario (
usr_id bigint unsigned not null auto_increment,
usr_nome varchar(20) not null,
usr_email varchar(100) not null,
usr_senha varchar(100) not null,
primary key (usr_id),
unique key uni_usuario_nome (usr_nome),
unique key uni_usuario_email (usr_email)
);

use brasfut;
INSERT INTO usr_usuario VALUES(0,"king","king@email.com","$2a$10$AnZLEgRTUP.F.KIxs/Xco.aHnRATcvDa9e.BFXSzhr2tlwEBDbSxq");

create table aut_autorizacao (
aut_id bigint unsigned not null auto_increment,
aut_nome varchar(20) not null,
primary key (aut_id),
unique key uni_aut_nome (aut_nome)
);

INSERT INTO aut_autorizacao (aut_nome) VALUES('ROLE_ADMIN');

create table uau_usuario_autorizacao (
usr_id bigint unsigned not null,
aut_id bigint unsigned not null,
primary key (usr_id, aut_id),
foreign key uau_usr_fk (usr_id)
references usr_usuario (usr_id)
on delete restrict on update cascade,
foreign key uau_aut_fk (aut_id)
references aut_autorizacao (aut_id)
on delete restrict on update cascade
);

INSERT INTO uau_usuario_autorizacao (usr_id,aut_id) 
    select usr_id,aut_id 
        from usr_usuario,aut_autorizacao
          where usr_nome = 'king' 
          and aut_nome = 'ROLE_ADMIN';

create table jog_jogador (
jog_id bigint unsigned not null auto_increment,
jog_nome varchar(50) not null,
jog_data_nasc date not null,
usr_time_id bigint unsigned not null,
primary key (jog_id),
foreign key jog_usr_fk (usr_time_id)
references usr_usuario (usr_id)
on delete restrict on update cascade,
unique key uni_jog_titulo (jog_nome)
);

INSERT INTO jog_jogador VALUES(0,"Kaka",'1982/04/22', 1);
