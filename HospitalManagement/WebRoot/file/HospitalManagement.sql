USE master
GO
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

--数据字典
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Dictionary')
	DROP TABLE Dictionary
GO
CREATE TABLE Dictionary
(
	DicId		int				identity(1,1),	--表编码
	TypeCode	varchar(20)     not null,   --字段编码
	TypeName	varchar(20),                --字段名称
	TypeValus	varchar(20),                --字段值
	IsVisible	int,                        --是否可见
	Memo		text                        --备注
)
GO

--科室表
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Department')
	DROP TABLE Department
GO
CREATE TABLE Department
(
	DepId			int                not null IDENTITY(1000,1),     --科室编号
	DepName			varchar(20)        not null,                      --科室名称
	DepAddress		text               not null                       --科室位置
)
GO

--医生表
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Doctor')
	DROP TABLE Doctor
GO
CREATE TABLE Doctor
(
	DocId			varchar(20)       not null,      --医生编号
	TrueName		varchar(20)       not null,      --真实姓名
	IdCard			varchar(18)       not null,      --身份证号
	DocSex			varchar(20),                     --医生性别
	DocBirthday		varchar(20),                     --生日
	SchoolRecord	varchar(20),                     --学历
	TelePhone		varchar(11),                     --电话号码
	OfficePhone		varchar(20),                     --办公室电话
	OnjobState		varchar(20),                     --在职状态
	Email			varchar(50),                     --邮箱
	DepartmentId	int               not null,      --部门Id
	Duty			varchar(20)
)
GO

--用户表
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'User')
	DROP TABLE [User]
GO
CREATE TABLE [User]
(
	[UserId]		varchar(20)			not null,       --用户编号
	UserPassword	varchar(20)			not null,       --用户密码
	RoleId			int					not null,	   --用户角色编号
	OnlineState		varchar(20)			not null,		--当前用户在线状态
	CreateTime		varchar(30)			not null,       --创建时间
	ModifyTime		varchar(30),                       --修改时间
	LastLogin		varchar(20)                        --最后一次登录时间
)
GO

--角色表
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Role')
	DROP TABLE [Role]
GO
CREATE TABLE [Role]
( 
	RoleId      int            not null IDENTITY(1000,1),         --角色编号   
	RoleName    varchar(20)    not null,                          --角色名称
	CreateTime	varchar(30)    not null,                          --角色创建时间
	ModifyTime  varchar(30),                                      --修改时间
	[Enabled]   int                                               --是否禁用该角色
)
GO

--权限表
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Privilege')
	DROP TABLE Privilege
GO
CREATE TABLE Privilege
(
	PriId			int             not null IDENTITY(1000,1),     --权限编号
	PriName			varchar(20)     not null,                   --权限名称
	ParentId		int,                                        --上级权限编号
	Memo            text,                                       --备注
	MenuPic         text,                                       --图标
	MenuUrl         text,                                       --权限路径
	DisplayOrder    varchar(10),                                --排序
	CreateTime      varchar(30)     not null,                   --创建时间
	ModifyTime      varchar(30),                                --修改时间
	[Enabled]       int                                         --是否禁用该权限
)
GO

--角色权限表
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'RolePrivilege')
	DROP TABLE RolePrivilege
GO
CREATE TABLE RolePrivilege
(
	RPID        int     not null IDENTITY(1000,1), --编号
	RoleId      int     not null,                  --角色编号
	PriId       int     not null                   --权限编号
)
GO

--患者信息表
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Patient')
	DROP TABLE Patient
GO
CREATE TABLE Patient
(
	PatId				int				not null IDENTITY(1000,1),	--患者编号
	PatNickname			varchar(20),				--用户名		  
	PatPassword			varchar(20)		not null,	--密码
	PatName				varchar(20),				--患者名称
	PatCard				varchar(18),				--身份证号
	PatSex				varchar(20),				--性别
	PatBirthday			varchar(20),				--生日
	PatPhone			varchar(20),				--电话
	PatAddress			text,						--地址
	PatSymotoms			text,						--过敏症状
	GeneticDisorders	text						--遗传病史 
)
GO

--挂号信息表
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Registered')
	DROP TABLE Registered
GO
CREATE TABLE Registered
(
	RegId				int				not null IDENTITY(1,1),--挂号编号
	PatId				int				not null,		--患者编号
	RegTime				varchar(20)		not null,		--挂号时间
	DepId				int				not null,		--科室编号
	DocId				varchar(20)		not null,		--医生编号
	RegType				varchar(20)		not null,		--挂号类别
	RegPrice			float			not null,		--挂号金额
	PayState			int				not null,		--处方是否付款
	RegState			varchar(20)		not null,		--状态
	IsPay               int			--挂号是否付款
)
GO

--药品表
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Drug')
	DROP TABLE Drug
GO
CREATE TABLE Drug
(
	DrugId				int				not null IDENTITY(1,1), --药品编号
	DrugName			varchar(20)		not null,               --药品名称
	DrugAlias			text,                                   --曾用名
	DrugShape			varchar(20)		not null,               --剂型
	DrugType			varchar(20)		not null,               --药品类别
	DrugNumber			int				not null,               --库存
	DrugPrice			float			not null,               --药品价格
	DrugConsumption		text,                                   --用法用量
	Attention			text                                    --注意事项
)
GO

--药品过期时间表
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'DrugTime')
	DROP TABLE DrugTiem
GO
CREATE TABLE DrugTime
(
	DrugId				int				not null,	--外键
	[Date]				varchar(20)		not null,	--进货时间
	DrugNumber			int				not null,	--进货数量
	DrugProduction		varchar(30)     not null,	--生产日期
	DrugExpiration		varchar(30)     not null,	--过期时间
)
GO

--药品适应症表
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Symptom')
	DROP TABLE Symptom
GO
CREATE TABLE Symptom
( 
	SymInstructions      varchar(20)     not null,       --症状说明
	DrugId               int             not null        --药品编号
)
GO

--处方表
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Prescription')
	DROP TABLE Prescription
GO
CREATE TABLE Prescription
(
	DOId		int			not null,                    --就诊编号
	DrugId		int			not null,                    --药品编号
	DrugNum		int			not null					--药品数量
)
GO

--就诊表
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'DoctorOffer')
	DROP TABLE DoctorOffer
GO
CREATE TABLE DoctorOffer
(
	DOId		int identity(1,1),		--就诊编号
	DocId		varchar(20),--医生编号
	RegId		int,		--挂号编号
	Symptom		text		--症状信息
)

--固定症状表
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'FixedSysmptoms')
	DROP TABLE FixedSysmptoms
GO
CREATE TABLE FixedSysmptoms
(
	FSId             int       not null IDENTITY(1,1),    --固定症状编号
	Sysmptoms         text      not null                   --固定症状
)
GO

--固定处方表
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'FixedPrescription')
	DROP TABLE FixedPrescription
GO
CREATE TABLE FixedPrescription
(
	FSId             int       not null,         --固定症状编号
	DrugId           int       not null          --药品编号
)
GO

--专家表
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Specialist')
	DROP TABLE Specialist
CREATE TABLE Specialist
(
	SpeId			int				identity(1,1),
	DepId			int				not null,
	DocId			varchar(20)		not null,
	[DateTime]		varchar(20)		not null
)

--新闻表
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'News')
	DROP TABLE News
GO
CREATE TABLE News
(
	NewId              varchar(20)       not null,      --新闻编号
	NewType            varchar(20)       not null,      --新闻类型
	NewTitle           text              not null,      --新闻标题
	NewSubtitle        text              not null,      --副标题
	NewCon             text              not null,      --新闻正文
	NewDate            varchar(20)       not null       --新闻时间
) 
GO

--报表表
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Report')
	DROP TABLE Report
GO
CREATE TABLE Report
(
	RepId              varchar(20)       not null,      --报表编号
	RepAuthor          varchar(20)       not null,      --提交人
	RepReview          varchar(20)       not null,      --审查人员
	RepCon             text              not null,      --报表内容
	RepReply           text,      --回复内容
	RepType            varchar(20)       not null,      --报表类型
)
GO

alter table Dictionary                                        --数据字典表约束
add
constraint pk_DicId  primary key(DicId),                --给字段编码添加主键约束
constraint ck_IsVisible check(IsVisible = 0 or IsVisible = 1) --0为true，1为false
GO

alter table Department                                        --科室表约束
add
constraint pk_Dep_Id  primary key(DepId)                     --给科室编号添加主键约束
GO

alter table [Role]                                            --角色表约束
add
constraint pk_RoldId  primary key(RoleId),                       --给角色编号添加主键
constraint df_RoleCreateTime default (getdate()) for CreateTime, --默认当前时间 
constraint df_RoleModifyTime default (getdate()) for ModifyTime, --默认当前时间
constraint ck_Enabled check([Enabled] = 0 or [Enabled] = 1)      --0为true，1为false
GO

alter table [User]                                            --用户表约束
add
constraint pk_UserId  primary key([UserId]),                 --给用户编号添加主键约束
constraint fk_UserRoleId foreign key (RoleId)         --科室表外键
references Role(RoleId),
constraint ck_UserPassword check(len(UserPassword)>=6),      --用户密码最少六位
constraint df_CreateTime default (getdate()) for CreateTime,  --默认当前时间 
constraint df_ModifyTime default (getdate()) for ModifyTime   --默认当前时间
GO

alter table Doctor                                            --医生表约束
add 
constraint fk_DocId foreign key (DocId)                      --用户表外键
references [User]([UserId]), 
constraint ck_IdCard check(len(IdCard)=18),                   --身份证必须为18位
constraint fk_DepartmentId foreign key (DepartmentId)         --科室表外键
references Department(DepId)
GO

alter table Privilege                                                 --权限表约束
add
constraint pk_PriId primary key(PriId),                              --权限编号添加主键约束
constraint df_PrivilegeCreateTime default (getdate()) for CreateTime, --默认当前时间 
constraint df_PrivilegeModifyTime default (getdate()) for ModifyTime, --默认当前时间 
constraint ck_PrivilegeEnabled check([Enabled] = 0 or [Enabled] = 1)           --0为true，1为false
GO

alter table RolePrivilege                      --角色权限表约束                  
add
constraint pk_RPID primary key(RPID),         --角色权限编号添加主键约束 
constraint fk_RoleId foreign key (RoleId)     --角色表外键
references [Role](RoleId), 
constraint fk_PriId  foreign key  (PriId)     --权限表外键
references Privilege(PriId)
GO

alter table Patient                                     --患者信息表约束
add
constraint pk_PatId  primary key(PatId),               --给患者编号添加主键	
constraint ck_PatPassword check(len(PatPassword)>=6)   --最少六位
GO

alter table Registered                                  --挂号信息表约束
add
constraint pk_Reg_Id  primary key(RegId),              --给挂号编号添加主键约束
constraint fk_PatId foreign key (PatId)                --给患者编号增加外键约束
references Patient(PatId),
constraint fk_Dep_Id foreign key(DepId)                --给科室编号添加外键
references Department(DepId),
constraint df_RegTime default (getdate()) for RegTime, --挂号时间默认当前时间
constraint ck_IsPay check(IsPay=0 or IsPay=1)          --只能等于0或者1（0位true，1为FALSE）
GO

alter table Drug                                          --药品表约束
add
constraint pk_Drug  primary key(DrugId),                 --给药品编号添加主键
constraint ck_DrugPrice check(DrugPrice>0)              --药品价格必须大于0
GO

alter table DrugTime
add
constraint FK_DrugTime foreign key(DrugId) references Drug(DrugId), -- 过期表外键
constraint PK_DrugTime primary key clustered(DrugId,[Date]), -- 过期表主键
constraint ck_DrugExpiration check(convert(datetime,DrugExpiration)>convert(datetime,DrugProduction))--生产日期
GO

alter table Symptom                                       --药品适应病症表约束
add
constraint fk_DrugId foreign key (DrugId)                --给药品编号增加外键约束
references Drug(DrugId)
GO

alter table DoctorOffer                                        --就诊表表约束
add
constraint pk_DOId  primary key(DOId),	--给就诊编号添加主键约束
constraint fk_DoctorOffer foreign key(DocId)
references [User]([UserId]),
constraint fk_RegId foreign key(RegId)
references Registered(RegId)
GO

alter table Prescription                                --处方表
add
constraint fk_PrescriptionDrugId foreign key(DrugId)   --给药品编号添加外键约束
references Drug(DrugId)
GO

alter table FixedSysmptoms                              --固定症状表约束
add
constraint pk_Id  primary key(FSId)                    --给固定症状编号添加主键约束
GO

alter table FixedPrescription                           --固定处方表约束
add
constraint fk_FSId foreign key(FSId)                   --给固定症状编号添加外键约束
references FixedSysmptoms(FSId),
constraint fk_FDrugId  foreign key(DrugId)             --给药品编号添加外键约束
references Drug(DrugId)
GO

alter table News                                         --给新闻表添加约束
add
constraint pk_NewId  primary key(NewId),                --给新闻编号添加主键约束
constraint df_NewDate default (getdate()) for NewDate   --新闻时间默认为当前时间
GO


--添加测试数据
--该数据没有数据管理员许可，任何人不得删除

use HospitalManagement
go

--数据字典
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('001','性别','男','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('002','性别','女','1')

insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('101','角色','管理员','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('102','角色','院长','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('103','角色','科室主任','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('104','角色','医生','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('105','角色','药房管理','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('106','角色','收费管理','1')

insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('201','科室','儿科','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('202','科室','妇科','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('203','科室','皮肤科','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('204','科室','放射科','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('205','科室','心血管','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('206','科室','脑科','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('207','科室','耳鼻喉科','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('208','科室','眼科','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('209','科室','肿瘤科','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('210','科室','中医1','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('210','科室','中医2','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('210','科室','中医3','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('211','科室','内科','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('212','科室','骨科','1')

insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('301','在职状态','在职','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('302','在职状态','离职','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('303','在职状态','休假','1')

insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible,Memo) values('401','挂号类别','专家号','1','5.0')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible,Memo) values('402','挂号类别','普通号','1','2.5')

insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('501','诊断状态','未诊断','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('502','诊断状态','正在诊断','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('503','诊断状态','已诊断','1')

insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('601','药品类别','处方药','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('602','药品类别','非处方药','1')

insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('701','药品剂型','片剂','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('702','药品剂型','针剂','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('703','药品剂型','颗粒剂','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('704','药品剂型','口服液剂','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('705','药品剂型','软膏剂','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('706','药品剂型','凝胶剂','1')

insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('801','新闻分类','人物','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('802','新闻分类','事物','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('803','新闻分类','动态','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('804','新闻分类','疾病','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('805','新闻分类','科研','1')

insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('901','报表类型','日报','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('902','报表类型','周报','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('903','报表类型','月报','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('904','报表类型','年总结','1')

insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('1001','在线状态','在线','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('1002','在线状态','下线','1')

insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('1101','学历','初中','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('1102','学历','高中','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('1103','学历','大专','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('1104','学历','本科','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('1105','学历','硕士','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('1106','学历','博士','1')

insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('1201','职务','医生','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('1202','职务','副主任','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('1203','职务','科室主任','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('1204','职务','副院长','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('1205','职务','院长','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('1206','职务','药方管理','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('1207','职务','收款管理','1')

--角色表
insert into Role(RoleName,CreateTime,ModifyTime,[Enabled]) values('101','2016-02-23','2017-03-23','1')
insert into Role(RoleName,CreateTime,ModifyTime,[Enabled]) values('102','2017-02-12','2017-03-23','1')
insert into Role(RoleName,CreateTime,ModifyTime,[Enabled]) values('103','2016-06-26','2017-03-23','1')
insert into Role(RoleName,CreateTime,ModifyTime,[Enabled]) values('104','2016-08-02','2017-03-23','1')
insert into Role(RoleName,CreateTime,ModifyTime,[Enabled]) values('105','2016-12-03','2017-03-23','1')
insert into Role(RoleName,CreateTime,ModifyTime,[Enabled]) values('106','2016-01-18','2017-03-23','1')

--用户表
insert into [User] (UserId,UserPassword,RoleId,OnlineState,CreateTime,ModifyTime,LastLogin) values('201701135623','123456','1000','1002','2017-01-16','2017-02-14','2017-03-23')
insert into [User] (UserId,UserPassword,RoleId,OnlineState,CreateTime,ModifyTime,LastLogin) values('201701138886','123456','1001','1002','2016-12-16','2017-02-14','2017-03-23')
insert into [User] (UserId,UserPassword,RoleId,OnlineState,CreateTime,ModifyTime,LastLogin) values('201701136512','123456','1002','1002','2017-01-16','2017-02-14','2017-03-23')
insert into [User] (UserId,UserPassword,RoleId,OnlineState,CreateTime,ModifyTime,LastLogin) values('201701137845','123456','1002','1002','2017-01-16','2017-02-14','2017-03-23')
insert into [User] (UserId,UserPassword,RoleId,OnlineState,CreateTime,ModifyTime,LastLogin) values('201701136596','123456','1002','1002','2017-01-16','2017-02-14','2017-03-23')
insert into [User] (UserId,UserPassword,RoleId,OnlineState,CreateTime,ModifyTime,LastLogin) values('201701136412','123456','1002','1002','2017-01-16','2017-02-14','2017-03-23')
insert into [User] (UserId,UserPassword,RoleId,OnlineState,CreateTime,ModifyTime,LastLogin) values('201701135692','123456','1003','1002','2017-01-16','2017-02-14','2017-03-23')
insert into [User] (UserId,UserPassword,RoleId,OnlineState,CreateTime,ModifyTime,LastLogin) values('201701135689','123456','1003','1002','2017-01-16','2017-02-14','2017-03-23')
insert into [User] (UserId,UserPassword,RoleId,OnlineState,CreateTime,ModifyTime,LastLogin) values('201701135696','123456','1003','1002','2017-01-16','2017-02-14','2017-03-23')
insert into [User] (UserId,UserPassword,RoleId,OnlineState,CreateTime,ModifyTime,LastLogin) values('201701135694','123456','1003','1002','2017-01-16','2017-02-14','2017-03-23')
insert into [User] (UserId,UserPassword,RoleId,OnlineState,CreateTime,ModifyTime,LastLogin) values('201701135667','123456','1003','1002','2017-01-16','2017-02-14','2017-03-23')
insert into [User] (UserId,UserPassword,RoleId,OnlineState,CreateTime,ModifyTime,LastLogin) values('201701135633','123456','1003','1002','2017-01-16','2017-02-14','2017-03-23')
insert into [User] (UserId,UserPassword,RoleId,OnlineState,CreateTime,ModifyTime,LastLogin) values('201701135655','123456','1003','1002','2017-01-16','2017-02-14','2017-03-23')
insert into [User] (UserId,UserPassword,RoleId,OnlineState,CreateTime,ModifyTime,LastLogin) values('201701135677','123456','1003','1002','2017-01-16','2017-02-14','2017-03-23')
insert into [User] (UserId,UserPassword,RoleId,OnlineState,CreateTime,ModifyTime,LastLogin) values('201701139652','123456','1004','1002','2017-01-16','2017-02-14','2017-03-23')
insert into [User] (UserId,UserPassword,RoleId,OnlineState,CreateTime,ModifyTime,LastLogin) values('201701131236','123456','1005','1002','2017-01-16','2017-02-14','2017-03-23')
insert into [User] (UserId,UserPassword,RoleId,OnlineState,CreateTime,ModifyTime,LastLogin) values('201701131245','123456','1005','1002','2017-01-16','2017-02-14','2017-03-23')

--患者表添加数据
insert into Patient(PatCard,PatName,PatNickname,PatPassword,PatPhone) values('410325199501024512','北大青鸟','北大青鸟','123456','15256235689')
insert into Patient(PatCard,PatName,PatNickname,PatPassword,PatPhone) values('410325199412135689','bdqn','bdqn','123456','1359568956')
insert into Patient(PatCard,PatName,PatNickname,PatPassword,PatPhone) values('410366188602035623','张三','张三','123456','1804524569')

--科室表添加信息
insert into Department values('201','二楼201')
insert into Department values('202','三楼303')
insert into Department values('203','二楼205')
insert into Department values('204','一楼108')
insert into Department values('205','二楼208')
insert into Department values('206','四楼403')
insert into Department values('207','五楼505')
insert into Department values('208','四楼404')
insert into Department values('209','五楼508')
insert into Department values('210','四楼401')
insert into Department values('211','三楼308')
insert into Department values('212','三楼305')

--医生表
insert into Doctor (DocId,TrueName,IdCard,DocSex,DocBirthday,SchoolRecord,TelePhone,OfficePhone,OnjobState,Email,DepartmentId,Duty) values('201701135655','张三','410326199602068956','001','1996-02-06','1104','13838838438','0379-66595689','301','zhangsan@163.com','1008','1201')
insert into Doctor (DocId,TrueName,IdCard,DocSex,DocBirthday,SchoolRecord,TelePhone,OfficePhone,OnjobState,Email,DepartmentId,Duty) values('201701135667','李四','410344199602068956','001','1996-02-06','1105','1359632356','0379-66595689','301','lisi@163.com','1007','1201')
insert into Doctor (DocId,TrueName,IdCard,DocSex,DocBirthday,SchoolRecord,TelePhone,OfficePhone,OnjobState,Email,DepartmentId,Duty) values('201701135677','王麻子','413325199602068956','001','1996-02-06','1106','1369632356','0379-66595689','301','wangmazi@163.com','1007','1201')
insert into Doctor (DocId,TrueName,IdCard,DocSex,DocBirthday,SchoolRecord,TelePhone,OfficePhone,OnjobState,Email,DepartmentId,Duty) values('201701135689','赵一','410565199602068956','002','1996-02-06','1104','13838838438','0379-66595689','301','zhaoyi@163.com','1006','1201')
insert into Doctor (DocId,TrueName,IdCard,DocSex,DocBirthday,SchoolRecord,TelePhone,OfficePhone,OnjobState,Email,DepartmentId,Duty) values('201701135692','钱二','410665199602068956','001','1996-02-06','1105','13838838438','0379-66595689','301','qianer@163.com','1005','1201')
insert into Doctor (DocId,TrueName,IdCard,DocSex,DocBirthday,SchoolRecord,TelePhone,OfficePhone,OnjobState,Email,DepartmentId,Duty) values('201701135696','孙三','410325199402068956','001','1996-02-06','1106','13838838438','0379-66595689','301','sunsan@163.com','1006','1201')
insert into Doctor (DocId,TrueName,IdCard,DocSex,DocBirthday,SchoolRecord,TelePhone,OfficePhone,OnjobState,Email,DepartmentId,Duty) values('201701135694','周四','410325199502068956','001','1996-02-06','1104','13838838438','0379-66595689','301','zhousi@163.com','1005','1201')
insert into Doctor (DocId,TrueName,IdCard,DocSex,DocBirthday,SchoolRecord,TelePhone,OfficePhone,OnjobState,Email,DepartmentId,Duty) values('201701139652','赵四','410325199702068956','001','1996-02-06','1105','13838838438','0379-66595689','301','zhaosi@163.com','1008','1201')
insert into Doctor (DocId,TrueName,IdCard,DocSex,DocBirthday,SchoolRecord,TelePhone,OfficePhone,OnjobState,Email,DepartmentId,Duty) values('201701131236','吴七','410325199802068956','001','1996-02-06','1106','13838838438','0379-66595689','301','wuqi@163.com','1008','1201')
insert into Doctor (DocId,TrueName,IdCard,DocSex,DocBirthday,SchoolRecord,TelePhone,OfficePhone,OnjobState,Email,DepartmentId,Duty) values('201701131245','郑六','410325199202068956','001','1996-02-06','1105','13838838438','0379-66595689','301','zhengliu@163.com','1008','1201')
insert into Doctor (DocId,TrueName,IdCard,DocSex,DocBirthday,SchoolRecord,TelePhone,OfficePhone,OnjobState,Email,DepartmentId,Duty) values('201701135623','王二','410325199102068956','001','1996-02-06','1106','13838838438','0379-66595689','301','wanger@163.com','1005','1201')
insert into Doctor (DocId,TrueName,IdCard,DocSex,DocBirthday,SchoolRecord,TelePhone,OfficePhone,OnjobState,Email,DepartmentId,Duty) values('201701138886','司马','410325198902068956','002','1996-02-06','1104','13838838438','0379-66595689','301','sima@163.com','1005','1201')
insert into Doctor (DocId,TrueName,IdCard,DocSex,DocBirthday,SchoolRecord,TelePhone,OfficePhone,OnjobState,Email,DepartmentId,Duty) values('201701136412','欧阳','410325199002068956','002','1996-02-06','1104','13838838438','0379-66595689','301','ouyang@163.com','1005','1201')
insert into Doctor (DocId,TrueName,IdCard,DocSex,DocBirthday,SchoolRecord,TelePhone,OfficePhone,OnjobState,Email,DepartmentId,Duty) values('201701136512','端木','410325198702068956','002','1996-02-06','1105','13838838438','0379-66595689','301','duanmu@163.com','1006','1201')
insert into Doctor (DocId,TrueName,IdCard,DocSex,DocBirthday,SchoolRecord,TelePhone,OfficePhone,OnjobState,Email,DepartmentId,Duty) values('201701136596','爱新觉罗','410373199602068956','002','1996-02-06','1106','13838838438','0379-66595689','301','aixinjueluo@163.com','1007','1201')
insert into Doctor (DocId,TrueName,IdCard,DocSex,DocBirthday,SchoolRecord,TelePhone,OfficePhone,OnjobState,Email,DepartmentId,Duty) values('201701137845','公孙','410325195602068956','002','1996-02-06','1106','13838838438','0379-66595689','301','gongsun@163.com','1008','1201')
insert into Doctor (DocId,TrueName,IdCard,DocSex,DocBirthday,SchoolRecord,TelePhone,OfficePhone,OnjobState,Email,DepartmentId,Duty) values('201701135633','杨过','410325197902068956','001','1996-02-06','1106','13838838438','0379-66595689','301','yangguo@163.com','1008','1201')


--挂号表添加信息
insert into Registered values('1001',GETDATE(),'1008','201701135655','1','5.80','0','501',0)
insert into Registered values('1000',GETDATE(),'1007','201701135677','1','5.80','0','501',0)
insert into Registered values('1002',GETDATE(),'1011','201701135692','1','5.80','0','501',0)
insert into Registered values('1001',GETDATE(),'1006','201701136512','1','5.80','0','501',0)


--药品表
insert into Drug (DrugName,DrugShape,DrugType,DrugNumber,DrugPrice) values('感冒颗粒','颗粒','非处方','5000','10')
insert into Drug (DrugName,DrugShape,DrugType,DrugNumber,DrugPrice) values('双黄连口服液','口服液','非处方','5000','10')
insert into Drug (DrugName,DrugShape,DrugType,DrugNumber,DrugPrice) values('百服宁','片剂','非处方','5000','10')
insert into Drug (DrugName,DrugShape,DrugType,DrugNumber,DrugPrice) values('清热解毒口服液','口服液','非处方','5000','10')
insert into Drug (DrugName,DrugShape,DrugType,DrugNumber,DrugPrice) values('扑热息痛','片剂','非处方','5000','10')
insert into Drug (DrugName,DrugShape,DrugType,DrugNumber,DrugPrice) values('阿司匹林','胶囊','非处方','5000','10')
insert into Drug (DrugName,DrugShape,DrugType,DrugNumber,DrugPrice) values('藿香真气液','口服液','非处方','5000','10')
insert into Drug (DrugName,DrugShape,DrugType,DrugNumber,DrugPrice) values('雷尼替丁','胶囊','非处方','5000','10')

--创建存储过程，获取添加的信息的自增加编号
CREATE PROCEDURE Get_Id   
(    
  @id int output 
)AS
select @id = @@IDENTITY
go