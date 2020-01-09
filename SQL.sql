create table member_(
nickname  varchar(10) not null,
id varchar(30) primary key,
pwd varchar(20) not null,
phone varchar(20) not null,
verify int default 0,
address varchar(100) 
);

insert into member_ values('관리자','admin@naver.com','1234','010-1234-5678',9,'ulsan');
insert into member_ values('test1','test1ID@naver.com','1234','010-1234-5678',0,'ulsan');
insert into member_ values('test2','test2ID@naver.com','1234','010-1234-5678',0,'ulsan');
insert into member_ values('test3','test3D@naver.com','1234','010-1234-5678',0,'ulsan');


create table project(
project_num int primary key auto_increment,
ptitle varchar(20) not null,
pcontent varchar(1000) not null,
pmoney  int not null default 0,
totMoney int,
id_fk varchar(30),
pdate date not null,
pVerify int default 0 ,
regdate Timestamp default now(),
ppic1 varchar(100) not null,
phit int default 0,
FOREIGN KEY (id_fk) REFERENCES member_(id) ON UPDATE CASCADE On Delete CASCADE

);
insert into project values(null,'마음의 양식','마음의 양식',0,3600000,"admin@naver.com",20190101,1,now(),'testImage1.png',0);
insert into project values(null,'방탄커피','저칼로리 방탄커피',0,3600000,"admin@naver.com",20190101,1,now(),'testImage2.png',0);
insert into project values(null,'3D프린트' ,'3D프린트 키트 양식',0,3600000,"admin@naver.com",20190101,1,now(),'testImg3.png',0);
insert into project values(null,'향수','향 수',0,3600000,"admin@naver.com",20190101,1,now(),'testImg4.png',0);

create table reward(
	prodNum int auto_increment primary key,
	project_num_fk int,
	prodName varchar(20),
    prodPrice int,
    prodCount int,
   FOREIGN KEY (project_num_fk) REFERENCES project(project_num) ON UPDATE CASCADE On Delete CASCADE

);

insert into reward values (null,'1','책',15000,600);
insert into reward values (null,'2','방탄커피',12000,1000);
insert into reward values (null,'3','3D프린트',80000,100);
insert into reward values (null,'4','향수',6000,1500);



create table cart(
card_id int primary key auto_increment ,
id_fk varchar(30),
prodNum_fk int,
project_num_fk int,
amount int,

FOREIGN KEY (id_fk) REFERENCES member_(id) ON UPDATE CASCADE,
FOREIGN KEY (prodNum_fk) REFERENCES reward(prodNum) ON UPDATE CASCADE,
FOREIGN KEY (project_num_fk) REFERENCES project(project_num) ON UPDATE CASCADE On Delete CASCADE
);


create table personal_project(
prodNum_fk int,
id_fk varchar(30),
project_num_fk int,

FOREIGN KEY (prodNum_fk) REFERENCES reward(prodNum) ON UPDATE CASCADE,
FOREIGN KEY (id_fk) REFERENCES member_(id) ON UPDATE CASCADE,
FOREIGN KEY (project_num_fk) REFERENCES project(project_num) ON UPDATE CASCADE On Delete CASCADE

);


create table notice(
notice_num int primary key auto_increment,
nTitle varchar(30)  not null,
nContent varchar(1000) not null,
nWriter varchar(10)  not null,
nRegdate timestamp  default now(),
nhits int default 0,
npic varchar(50)


);

insert into notice(nTitle, nContent, nWriter) values('오늘의 공지',"test12342213",'관리자');
insert into notice(nTitle, nContent, nWriter) values('공지사항2',"test12342213",'관리자');
insert into notice(nTitle, nContent, nWriter) values('공지사항3',"test12342213",'관리자');

select * from member_;
select * from project;
select * from reward;
select * from notice;
select * from cart;

