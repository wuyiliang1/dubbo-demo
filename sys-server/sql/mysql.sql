create table sys_user
(
	id bigint not null,
	createDate datetime null,
	updateDate datetime null,
	username varchar(50) null,
	mobile varchar(20) null,
	password varchar(100) null,
	constraint sys_user_pk
		primary key (id)
);

