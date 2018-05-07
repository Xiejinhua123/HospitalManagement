use master
go
IF EXISTS(SELECT * FROM SYSDATABASES WHERE name='HospitalManagement')
	DROP DATABASE HospitalManagement
GO
CREATE DATABASE HospitalManagement
ON
(
	NAME = 'HospitalManagement',
	FILENAME = 'D:\\HospitalManagement.MDF',
	SIZE = 10MB,
	FILEGROWTH = 2MB
)
LOG ON
(
	NAME = 'HospitalManagement_LOG',
	FILENAME = 'D:\\HospitalManagement_LOG.LDF',
	SIZE = 5MB,
	FILEGROWTH = 15%
)
GO
USE HospitalManagement
GO

--閿熸枻鎷烽敓鏂ゆ嫹閿熻纰夋嫹
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Dictionary')
	DROP TABLE Dictionary
GO
CREATE TABLE Dictionary
(
	DicId		int				primary key identity(1,1),	--閿熸枻鎷烽敓鏂ゆ嫹閿燂拷
	TypeCode	varchar(20)     not null,   --閿熻娈垫唻鎷烽敓鏂ゆ嫹
	TypeName	varchar(20),                --閿熻璁规嫹閿熸枻鎷烽敓鏂ゆ嫹
	TypeValus	varchar(20),                --閿熻璁规嫹鍊�
	IsVisible	int,                        --閿熻鍑ゆ嫹鏉夐敓锟�
	Memo		text                        --閿熸枻鎷锋敞
)
GO

--閿熸枻鎷烽敓鎻唻鎷�
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Department')
	DROP TABLE Department
GO
CREATE TABLE Department
(
	DepId			int                primary key IDENTITY(1000,1),  --閿熸枻鎷烽敓鎻唻鎷烽敓锟�
	DepName			varchar(20)        not null,                      --閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹
	DepAddress		text               not null                       --閿熸枻鎷烽敓鏂ゆ嫹浣嶉敓鏂ゆ嫹
)
GO

--閿熺煫浼欐嫹閿熸枻鎷�
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Users')
	DROP TABLE Users
GO
CREATE TABLE Users
(
	UsersId		varchar(20)			primary key,       --閿熺煫浼欐嫹閿熸枻鎷烽敓锟�
	UserPassword	varchar(20)			not null,       --閿熺煫浼欐嫹閿熸枻鎷烽敓鏂ゆ嫹
	OnlineState		varchar(20)			not null,		--閿熸枻鎷峰墠閿熺煫浼欐嫹閿熸枻鎷烽敓鏂ゆ嫹鐘舵��
	CreateTime		date				not null,       --閿熸枻鎷烽敓鏂ゆ嫹鏃堕敓鏂ゆ嫹
	ModifyTime		date,						       --閿熺潾闈╂嫹鏃堕敓鏂ゆ嫹
	LastLogin		date,							   --閿熸枻鎷烽敓鎻紮鎷疯敋閿熼摪闄呮唻鎷烽敓锟�
	TrueName		varchar(20),        --閿熸枻鎷峰疄閿熸枻鎷烽敓鏂ゆ嫹
	IdCard			varchar(18),        --閿熸枻鎷烽敓琛椼倧鎷烽敓锟�
	DocSex			varchar(20),        --鍖婚敓鏂ゆ嫹閿熺殕鎲嬫嫹
	DocBirthday		date,				--閿熸枻鎷烽敓鏂ゆ嫹
	SchoolRecord	varchar(20),        --瀛﹂敓鏂ゆ嫹
	TelePhone		varchar(11),        --閿熺晫璇濋敓鏂ゆ嫹閿熸枻鎷�
	OfficePhone		varchar(20),        --閿熷眾鍏敓鎻數璇�
	OnjobState		varchar(20),        --閿熸枻鎷疯亴鐘舵��
	Email			varchar(50),        --閿熸枻鎷烽敓鏂ゆ嫹
	DepId			int			foreign key references Department(DepId),   --閿熸枻鎷烽敓鏂ゆ嫹Id
	IsSpecialist	varchar(20)		,			--专家号或者是普通号，通过数据字典实现
	Duty			varchar(20)
)

GO

--閿熸枻鎷疯壊閿熸枻鎷�
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Role')
	DROP TABLE Roles
GO
CREATE TABLE Roles
( 
	RolesId      int            primary key IDENTITY(1000,1),         --閿熸枻鎷疯壊閿熸枻鎷烽敓锟�   
	RoleName    varchar(20)    not null,                          --閿熸枻鎷疯壊閿熸枻鎷烽敓鏂ゆ嫹
	CreateTime	date    not null,                          --閿熸枻鎷疯壊閿熸枻鎷烽敓鏂ゆ嫹鏃堕敓鏂ゆ嫹
	ModifyTime  date,						                  --閿熺潾闈╂嫹鏃堕敓鏂ゆ嫹
	Enableds   int                                               --閿熻鍑ゆ嫹閿熸枻鎷烽叾濯掗敓缂达拷
)
GO

--閿熺煫浼欐嫹閿熸枻鎷疯壊閿熸枻鎷�
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'UserRole')
	DROP TABLE UserRole
GO
CREATE TABLE UserRole
(
	URId	int				primary key IDENTITY(1000,1),	--閿熸枻鎷烽敓锟�
	UserId	varchar(20)		foreign key references Users(UsersId) not null , 	--閿熺煫浼欐嫹閿熸枻鎷烽敓锟�
	RoleId	int 			not null foreign key references Roles(RolesId)-- 閿熸枻鎷疯壊閿熸枻鎷烽敓锟�
)

--鏉冮敓鐫唻鎷�
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Privilege')
	DROP TABLE Privilege
GO
CREATE TABLE Privilege
(
	PriId			int             primary key IDENTITY(1000,1), 	--鏉冮敓鐫唻鎷烽敓锟�
	PriName			varchar(20)     not null,                   	--鏉冮敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹
	ParentId		int,                                        --閿熻緝纭锋嫹鏉冮敓鐫唻鎷烽敓锟�
	Memo            text,                                       --閿熸枻鎷锋敞
	MenuPic         text,                                       --鍥鹃敓鏂ゆ嫹
	MenuUrl         text,                                       --鏉冮敓鏂ゆ嫹璺敓鏂ゆ嫹
	DisplayOrder    int,		                                --鏉冮敓鐫瓑纭锋嫹
	CreateTime      date     not null,                   		--閿熸枻鎷烽敓鏂ゆ嫹鏃堕敓鏂ゆ嫹
	ModifyTime      date,                                		--閿熺潾闈╂嫹鏃堕敓鏂ゆ嫹
	Enableds       int                                         --閿熻鍑ゆ嫹閿熸枻鎷烽叾閿熼ズ顭掓嫹閿燂拷
)
GO

--閿熸枻鎷疯壊鏉冮敓鐫唻鎷�
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'RolePrivilege')
	DROP TABLE RolePrivilege
GO
CREATE TABLE RolePrivilege
(
	RPID        int     primary key IDENTITY(1000,1), --閿熸枻鎷烽敓锟�
	RoleId      int     not null foreign key references Roles(RolesId), 	--閿熸枻鎷疯壊閿熸枻鎷烽敓锟�
	PriId       int     not null  foreign key references Privilege(PriId)	--鏉冮敓鐫唻鎷烽敓锟�
)
GO

--閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷锋伅閿熸枻鎷�
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Patient')
	DROP TABLE Patient
GO
CREATE TABLE Patient
(
	PatId				int				primary key IDENTITY(1000,1),	--閿熸枻鎷烽敓绔唻鎷烽敓锟�	  
	PatPassword			varchar(20)		not null,	--閿熸枻鎷烽敓鏂ゆ嫹
	PatName				varchar(20),				--閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹
	PatCard				varchar(18),				--閿熸枻鎷烽敓琛椼倧鎷烽敓锟�
	PatSex				varchar(20),				--閿熺殕鎲嬫嫹
	PatBirthday			date,						--閿熸枻鎷烽敓鏂ゆ嫹
	PatPhone			varchar(20),				--閿熺晫璇�
	PatAddress			text,						--閿熸枻鎷峰潃
	PatSymotoms			text,						--閿熸枻鎷烽敓鏂ゆ嫹鐥囩姸
	GeneticDisorders	text,						--閿熻剼杈炬嫹閿熸枻鎷峰彶
	OnlineState		varchar(20)			not null,		--閿熸枻鎷峰墠閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹鐘舵��
	CreateTime		date				not null,       --閿熸枻鎷烽敓鏂ゆ嫹鏃堕敓鏂ゆ嫹
	ModifyTime		date,						       --閿熺潾闈╂嫹鏃堕敓鏂ゆ嫹
	LastLogin		date,							   --閿熸枻鎷烽敓鎻紮鎷疯敋閿熼摪闄呮唻鎷烽敓锟�
)
GO

--鑽搧閿熸枻鎷�
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Drug')
	DROP TABLE Drug
GO
CREATE TABLE Drug
(
	DrugId				int				primary key IDENTITY(1,1), --鑽搧閿熸枻鎷烽敓锟�
	DrugName			text,				--鑽搧閿熸枻鎷烽敓鏂ゆ嫹
	DrugAlias			text,						--曾用名
	DrugShape			varchar(20),				--剂型
	DrugType			varchar(20), 				--类型  处方药  非处方药
	DrugSymptom			text,						--适应症
	DrugBigUnit			varchar(20),				--大单位
	DrugSmallUnit		varchar(20),				--小单位
	Specification		varchar(20),				--规格
	DrugPrice			float,						--价格
	DrugConsumption		text,                       --禁忌
	Attention			text                        --注意事项
)
GO

--进销存
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'DrugTime')
	DROP TABLE DrugTiem
GO
CREATE TABLE DrugTime
(
	DrugTimeId			int			identity(1,1) primary key,
	DrugId				int			foreign key references Drug(DrugId),		--药品编号
	Dates				date		not null,			--进货日期
	DrugNumber			int			not null,			--总量
	DrugProduction		date		not null,			--生产日期
	DrugExpiration		int			not null,			--过期期限
	DrugCount			int			not null,			--剩余数量
)
GO

--挂号
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Registered')
	DROP TABLE Registered
GO
CREATE TABLE Registered
(
	RegId				varchar(20)			primary key,--閿熸彮鍙锋唻鎷烽敓锟�		閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓缂粹槄鎷� 鏃堕敓鎴掞紙鏃堕敓鏂ゆ嫹閿熻锛�+閿熺煫浼欐嫹閿熸枻鎷风墰閿熸枻鎷烽敓鏂ゆ嫹閿燂拷2017050611561001閿熸枻鎷�
	PatId				int				not null foreign key references Patient(PatId),		--閿熸枻鎷烽敓绔唻鎷烽敓锟�
	AppointmentTime		date		null,			--棰勭害鏃堕敓鏂ゆ嫹
	RegTime				date		not null,		--閿熸彮鐚存嫹鏃堕敓鏂ゆ嫹
	DepId				int				not null,		--閿熸枻鎷烽敓鎻唻鎷烽敓锟�
	UsersId			varchar(20)		null foreign key references Users(UsersId),			--鍖婚敓鏂ゆ嫹閿熸枻鎷烽敓锟�
	RegType				varchar(20)		not null,		--閿熸彮鐚存嫹閿熸枻鎷烽敓锟�
	RegPrice			float			not null,		--閿熸彮鍙锋枻鎷烽敓锟�
	PayState			int				not null,		--閿熸枻鎷烽敓鏂ゆ嫹閿熻鍚︿粯鍖℃嫹
	RegState			varchar(20)		not null,		--鐘舵��
	IsPay               int			--閿熸彮鐚存嫹閿熻鍚︿粯鍖℃嫹
)
GO

--閿熸枻鎷烽敓鏂ゆ嫹閿燂拷
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'DoctorOffer')
	DROP TABLE DoctorOffer
GO
CREATE TABLE DoctorOffer
(
	DOId		int primary key identity(1,1),	--閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷�
	UsersId	varchar(20) foreign key references Users(UsersId),		--鍖婚敓鏂ゆ嫹閿熸枻鎷烽敓锟�
	RegId		varchar(20) foreign key references Registered(RegId),				--閿熸彮鍙锋唻鎷烽敓锟�
	Symptom		text,				--鐥囩姸閿熸枻鎷锋伅
	Comment		text				--当前处方信息的备注（医嘱）
)

--婢跺嫭鏌熺悰锟�
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Prescription')
	DROP TABLE Prescription
GO
CREATE TABLE Prescription
(
	PreId		int			identity(1,1) primary key,
	DOId		int			not null foreign key references DoctorOffer(DOId),                    --閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷�
	DrugId		int			not null foreign key references Drug(DrugId), --鑽搧閿熸枻鎷烽敓锟�
	DrugNum		int,					--鑽搧閿熸枻鎷烽敓鏂ゆ嫹
	DrugUnit	varchar(10)	--鑽搧閿熸枻鎷蜂綅
)
GO

--閿熸暀璁规嫹鐥囩姸閿熸枻鎷�
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'FixedSysmptoms')
	DROP TABLE FixedSysmptoms
GO
CREATE TABLE FixedSysmptoms
(
	FSId			int		primary key IDENTITY(1,1),    --閿熸暀璁规嫹鐥囩姸閿熸枻鎷烽敓锟�
	DepId			int		not null foreign key references Department(DepId), --閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓锟�
	Sysmptoms		text	not null                   --閿熸暀璁规嫹鐥囩姸
)
GO

--閿熸暀璁规嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷�
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'FixedPrescription')
	DROP TABLE FixedPrescription
GO
CREATE TABLE FixedPrescription
(
	FPId		int		primary key identity(1,1), --閿熸暀璁规嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓锟�	
	FSId		int		not null foreign key references FixedSysmptoms(FSId),         --閿熸暀璁规嫹鐥囩姸閿熸枻鎷烽敓锟�
	DrugId		int		not null foreign key references Drug(DrugId)          --鑽搧閿熸枻鎷烽敓锟�
)
GO

--閿熸枻鎷烽敓鑴氭唻鎷�
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'News')
	DROP TABLE News
GO
CREATE TABLE News
(
	NewId              int		not null   identity(1,1) primary key,      --閿熸枻鎷烽敓鑴氭唻鎷烽敓锟�
	NewType            varchar(20)      not null,      --閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹
	NewTitle           text             not null,      --閿熸枻鎷烽敓鑴氭唻鎷烽敓鏂ゆ嫹
	NewSubtitle        text             not null,      --閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷�
	NewCon             text             not null,      --閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹
	NewDate            date			    not null       --閿熸枻鎷烽敓鏂ゆ嫹鏃堕敓鏂ゆ嫹
) 

GO

--閿熸枻鎷烽敓鏂ゆ嫹閿燂拷
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Report')
	DROP TABLE Report
GO
CREATE TABLE Report
(
	RepId				varchar(20)		primary key not null,	--閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷� 閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹
	RepAuthor			varchar(20)		not null foreign key references Users(UsersId),	--閿熺粨浜ら敓鏂ゆ嫹
	RepReview			varchar(20)		not null foreign key references Users(UsersId),	--閿熸枻鎷烽敓鏂ゆ嫹閿熺殕锟�
	ReportTime			date			not null,	--閿熺粨浜ゆ椂閿熸枻鎷�
	RepCon				text			not null,	--閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹
	RepReply			text,						--閿熸埅闈╂嫹閿熸枻鎷烽敓鏂ゆ嫹
	ReplyTime			date,						--閿熸埅闈╂嫹鏃堕敓鏂ゆ嫹
	RepType				varchar(20)		not null,	--閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹
)
GO