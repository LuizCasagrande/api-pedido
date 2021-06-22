drop table if exists usuario_permissao;
drop table if exists permissao;
drop table if exists usuario;

create table usuario (
    id int not null,
    email varchar not null,
    senha varchar not null,
    primary key (id)
);

create table permissao (
    id int not null,
    descricao varchar not null,
    primary key (id)
);

create table usuario_permissao (
    usuario_id int not null,
    permissao_id int not null,
    primary key (usuario_id, permissao_id),
    foreign key (usuario_id) references usuario (id),
    foreign key (permissao_id) references permissao (id)
);

insert into usuario (id, email, senha)
values (1, 'admin@email.com', '$2a$10$Mw.zO.evOH1EVWe32Hnffeq6S2h8o/wl63mjnEtDtFC7Zwf84XpC6'),
       (2, 'luiz@email.com', '$2a$10$W/PjL8WybT/mflZGD9FYjOBH4Cl.Rm/kJ.5QJyWDZv7x6KJYogAsC');

insert into permissao (id, descricao)
values (1, 'ROLE_PESQUISAR'),
       (2, 'ROLE_CADASTRAR'),
       (3, 'ROLE_REMOVER');

insert into usuario_permissao (usuario_id, permissao_id)
values (1, 1),
       (1, 2),
       (1, 3),
       (2, 1);
