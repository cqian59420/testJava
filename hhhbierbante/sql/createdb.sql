create table bus_appointfee(
appointId int primary key,
appointTotalFee Decimal not null,
appointDiscountFee Decimal,
appointCouponFee Decimal,
appointAfterDiscountFee Decimal

);

create table bus_appointrecord( 
appointId int primary key AUTO_INCREMENT, 
patientName varchar(100) not null , 
 createDate Date  not null comment '新建日期' 
);


CREATE TABLE Phone (
 id BIGINT NOT NULL ,
 number VARCHAR(255) ,
 PRIMARY KEY ( id )
);

CREATE TABLE PhoneDetails (
 id BIGINT NOT NULL ,
 provider VARCHAR(255) ,
 technology VARCHAR(255) ,
 phone_id BIGINT ,
 PRIMARY KEY ( id )
);