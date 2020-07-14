create schema brasfut;
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
INSERT INTO usr_usuario VALUES(0,"São Paulo","saopaulo@email.com","senha");

INSERT INTO usr_usuario VALUES(0,"Corinthians","corinthians@email.com","maloqueiro");


create table aut_autorizacao (
aut_id bigint unsigned not null auto_increment,
aut_nome varchar(20) not null,
primary key (aut_id),
unique key uni_aut_nome (aut_nome)
);

INSERT INTO aut_autorizacao VALUES(1,"adm");


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

INSERT INTO uau_usuario_autorizacao VALUES(1,1);

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
