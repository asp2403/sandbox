insert into author(id_author, name) values(1, 'Лев Толстой');
insert into author(id_author, name) values(2, 'Стивен Кинг');
insert into author(id_author, name) values(3, 'Дж. Р.Р. Толкин');

insert into genre(id_genre, name) values(1, 'Русская классика');
insert into genre(id_genre, name) values(2, 'Фэнтези');
insert into genre(id_genre, name) values(3, 'Ужасы');


--insert into book(id_book, title, id_author, id_genre) values (1, 'Война и мир', 1, 1);
--insert into book(id_book, title, id_author, id_genre) values (2, 'Кладбище домашних животных', 2, 3);
--insert into book(id_book, title, id_author, id_genre) values (3, 'Властелин колец', 3, 2);

insert into book(title, id_author, id_genre) values ('Война и мир', 1, 1);
insert into book(title, id_author, id_genre) values ('Кладбище домашних животных', 2, 3);
insert into book(title, id_author, id_genre) values ('Властелин колец', 3, 2);

insert into comment(id_book, comment_text) values(1, 'Восхитительно!');
insert into comment(id_book, comment_text) values(1, 'Многабукв. Ниасилил...');
insert into comment(id_book, comment_text) values(2, 'Кису жалко');
insert into comment(id_book, comment_text) values(3, 'Надо было лететь на орлах!');
