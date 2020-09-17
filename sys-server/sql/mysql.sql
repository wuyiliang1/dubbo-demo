create table sys_user
(
	id bigint not null,
	create_date datetime null,
	update_date datetime null,
	del_flag tinyint null,
	username varchar(50) null,
	mobile varchar(20) null,
	password varchar(100) null,
	constraint sys_user_pk
		primary key (id)
);

create table sys_token
(
	id bigint not null,
	create_date datetime null,
	update_date datetime null,
	del_flag tinyint null,
	user_id bigint null,
	token varchar(300) null,
	constraint sys_token_pk
		primary key (id)
);