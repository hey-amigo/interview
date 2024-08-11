Схема БД
контрагент, индивидуальный предприниматель, организация, счет
Запрос 1: вывести total_balance сумму остатков на счетах всех организаций
Запрос 2: вывести counterpart.id, balance > 100 всех контрагентов баланс котороых более 100

counterpart(int id, boolean active)
individual_entrepreneur(int id, varchar first_name, varchar last_name, uuid account_id)
organization(int id, varchar name, int account_id)
account(int id, bigint balance)

create table if not exists counterpart (
id int primary key,
active boolean
);

create table if not exists account (
id int primary key,
balance bigint
);

create table if not exists individual_entrepreneur (
id int primary key,
first_name varchar,
last_name varchar,
account_id int,
constraint fk_counterpart foreign key(id) references counterpart(id),
constraint fk_account foreign key(account_id) references account(id)
);

create table if not exists organization (
id int primary key,
name varchar,
account_id int,
constraint fk_counterpart foreign key(id) references counterpart(id),
constraint fk_account foreign key(account_id) references account(id)
);

insert into counterpart (id, active)
values
    (1, true),
    (2, true),
    (3, true),
    (4, true),
    (5, true),
    (6, true),
    (7, true),
    (8, true);

insert into account (id, balance)
values
    (1, 100),
    (2, 130),
    (3, 45),
    (4, 90),
    (5, 1000),
    (6, 3200),
    (7, 2580),
    (8, 980);

insert into individual_entrepreneur (id, first_name, last_name, account_id)
values
    (1, 'Иван', 'Иванов', 1),
    (2, 'Петр', 'Петров', 2),
    (3, 'Андрей', 'Андреев', 3),
    (4, 'Семен', 'Семенов', 4);

insert into organization (id, name, account_id)
values
    (5, 'Ромашка', 5),
    (6, 'Одуванчик', 6),
    (7, 'Колокольчик', 7),
    (8, 'Роза', 8);

select sum(account.balance) from organization
join account on organization.account_id = account.id

select counterpart.id, account.balance  from individual_entrepreneur
join counterpart on individual_entrepreneur.id = counterpart.id
join account on individual_entrepreneur.account_id = account.id
where account.balance > 100
union
select counterpart.id, account.balance  from organization
join counterpart on organization.id = counterpart.id
join account on organization.account_id = account.id
where account.balance > 100
