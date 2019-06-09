create database [prj321_authen_author]

use [prj321_authen_author]

create table [Account] (
	[username] varchar(255) not null primary key,
	[password] varchar(255) not null
);

create table [Role] (
	[role_id] int not null IDENTITY(1,1) primary key ,
	[role_name] varchar(255) not null
);

create table [Feature] (
	[servlet_path] varchar(255) not null primary key,
	[feature_name] varchar(255) not null
);

create table [Role_Account] (
	[username] varchar(255) not null,
	[role_id] int not null,
	constraint [fk_username]
		foreign key ([username]) references [Account] ([username])
		on delete cascade,
	constraint [fk_role_id]
		foreign key ([role_id]) references [Role] ([role_id])
		on delete cascade
);

create table [Role_Feature] (
	[role_id] int not null,
	[servlet_path] varchar(255) not null,
	constraint [fk_role_id_feature]
		foreign key ([role_id]) references [Role] ([role_id])
		on delete cascade,
	constraint [fk_servlet_path_feature]
		foreign key ([servlet_path]) references [Feature] ([servlet_path])
		on delete cascade
);

insert into [Account] ([username], [password]) values ('kflbidc123', '123456')
insert into [Account] ([username], [password]) values ('kflbidc1234', '123456')
insert into [Account] ([username], [password]) values ('kflbidc12345', '123456')

insert into [Role] ([role_name]) values ('admin')
insert into [Role] ([role_name]) values ('mod')
insert into [Role] ([role_name]) values ('guest')

insert into [Feature] ([servlet_path], [feature_name]) values ('/insert','Insert')
insert into [Feature] ([servlet_path], [feature_name]) values ('/list','List')

insert into [Role_Account] ([username],[role_id]) values ('kflbidc123',1);
insert into [Role_Account] ([username],[role_id]) values ('kflbidc1234',2);
insert into [Role_Account] ([username],[role_id]) values ('kflbidc12345',3);

insert into [Role_Feature] ([role_id], [servlet_path]) values ('1', '/insert')
insert into [Role_Feature] ([role_id], [servlet_path]) values ('1', '/list')
insert into [Role_Feature] ([role_id], [servlet_path]) values ('2', '/list')

select * from [Feature]

select * from [Account] where [Account].[username] = 'kflbidc123' and [Account].[password] = '123456'


