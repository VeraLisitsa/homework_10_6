create table persons(
                        name varchar(255) not null,
                        surname varchar(255) not null,
                        age int not null,
                        phone_number varchar(10),
                        city_of_living varchar(255),
                        PRIMARY KEY (name, surname, age)
)