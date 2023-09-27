CREATE TABLE users(
    id serial primary key ,
    name_user varchar(255) unique ,
    user_name varchar(255),
    email varchar(50) unique,
    password varchar(50)
);

CREATE TABLE shareholder(
    id serial primary key ,
    name_shareholder varchar(255),
    phone_number char(11),
    national_code char(10) unique
);

CREATE TABLE brand
(
    id          serial primary key,
    name_brand  varchar(255) unique ,
    website     varchar(255),
    description varchar(255)
);

CREATE TABLE shareholder_brand(
    shareholder_id int references shareholder(id),
    brand_id int references brand(id),
    primary key (shareholder_id,brand_id)
);

CREATE TABLE category(
    id serial primary key,
    name_category  varchar(255) unique ,
    description varchar(255)
);

CREATE TABLE product(
    id serial primary key ,
    name_product varchar(255),
    create_date varchar(255),
    brand_id int references brand(id),
    category_id int references category(id)
);
insert into shareholder_brand (shareholder_id, brand_id)select b.id, sh.id
                                from shareholder sh
                                join brand b  on (b.id=);


