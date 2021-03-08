create table dog (
	id number primary key,
	kind varchar2(12) not null,
	price number not null,
	image varchar2(12) not null,
	country  varchar2(12) not null,
	height number,
	weight number,
	content varchar2(400),
	readcount number
);
create sequence dog_seq;

insert into dog values(dog_seq.nextval,'푸들',1000,'pu.jpg','프랑스',1,20,'털많다',0);
insert into dog values(dog_seq.nextval,'불독',2000,'bul.jpg','독일',1,20,'못생겼다',0);
insert into dog values(dog_seq.nextval,'진도개',3000,'jin.jpg','대한민국',1,20,'최고다',0);
insert into dog values(dog_seq.nextval,'허스키',4000,'h.jpg','북극',1,20,'멋지다',0);
insert into dog values(dog_seq.nextval,'왈왈',5000,'new.jpg','모름',1,20,'귀엽다',0);
commit

select * from dog;

drop table dog;