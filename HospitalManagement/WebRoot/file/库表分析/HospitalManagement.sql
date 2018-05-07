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
	TypeCode	varchar(20)     not null ,  --字段编码
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
	Dep_Id			int                not null IDENTITY(1000,1),     --科室编号
	Dep_Name		varchar(20)        not null,                      --科室名称
	Dep_Address		text               not null                       --科室位置
)
GO

--医生表
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Doctor')
	DROP TABLE Doctor
GO
CREATE TABLE Doctor
(
	Doc_Id			varchar(20)       not null,      --医生编号
	TrueName		varchar(20)       not null,      --真实姓名
	IdCard			varchar(18)       not null,      --身份证号
	Doc_Sex			varchar(20),                     --医生性别
	Doc_Birthday	varchar(20),                     --生日
	SchoolRecord	varchar(20),                     --学历
	TelePhone		varchar(11),                     --电话号码
	Office_Phone	varchar(20),                     --办公室电话
	Onjob_Static	varchar(20),                     --在职状态
	Email			varchar(50),                     --邮箱
	DepartmentId	int               not null       --部门Id
)
GO

--用户表
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'User')
	DROP TABLE [User]
GO
CREATE TABLE [User]
(
	[User_Id]		varchar(20)        not null,       --用户编号
	User_Password	varchar(20)        not null,       --用户密码
	CreateTime		varchar(30)        not null,       --创建时间
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
	RoldId      int            not null IDENTITY(1000,1),         --角色编号   
	RoldName    varchar(20)    not null,                          --角色名称
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
	Pri_Id          int             not null IDENTITY(1000,1),     --权限编号
	Pri_Name        varchar(20)     not null,                   --权限名称
	Parent_Id       int,                                        --上级权限编号
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
	RP_ID        int     not null IDENTITY(1000,1), --编号
	Role_Id      int     not null,                  --角色编号
	Pri_Id       int     not null                   --权限编号
)
GO

--患者信息表
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Patient')
	DROP TABLE Patient
GO
CREATE TABLE Patient
(
	Pat_Id                    int           not null IDENTITY(1000,1),--患者编号
	Pat_Password              varchar(20)   not null,                 --密码
	Pat_Name                  varchar(20)   not null,                 --患者名称
	Pat_Card				  varchar(18),							  --身份证号
	Pat_Sex                   varchar(20),							  --性别
	Pat_Birthday              varchar(20),                            --生日
	Pat_Phone                 varchar(20),                            --电话
	Pat_Address               text,                                   --地址
	Pat_Symotoms              text,                                   --过敏症状
	Genetic_Disorders         text                                    --遗传病史 
)
GO

--挂号信息表
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Registered')
	DROP TABLE Registered
GO
CREATE TABLE Registered
(
	Reg_Id              int            not null IDENTITY(1,1),--挂号编号
	Pat_Id              int            not null,              --患者编号
	Reg_Time            varchar(20)    not null,              --挂号时间
	Dep_Id              int            not null,              --科室编号
	Reg_Type            varchar(20)    not null,              --挂号类别
	Reg_Price           float          not null,              --挂号金额
	Reg_Static          varchar(20)    not null,              --状态
	IsPay               int                                   --挂号是否付款
)
GO

--药品表
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Drug')
	DROP TABLE Drug
GO
CREATE TABLE Drug
(
	Drug_Id                   int             not null IDENTITY(1,1), --药品编号
	Drug_Name                 varchar(20)     not null,               --药品名称
	Drug_Alias                text,                                   --曾用名
	Drug_Shape                varchar(20)     not null,               --剂型
	Drug_Type                 varchar(20)     not null,               --药品类别
	Drug_Number               int             not null,               --库存
	Drug_Price                float           not null,               --药品价格
	Drug_Consumption          text,                                   --用法用量
	Attention                 text                                    --注意事项
)
GO

--药品过期时间表
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'DrugTime')
	DROP TABLE DrugTiem
GO
CREATE TABLE DrugTime
(
	Drug_Id				int				not null,	--外键
	[Date]				varchar(20)		not null,	--进货时间
	Drug_Number			int				not null,	--进货数量
	Drug_Production		varchar(30)     not null,	--生产日期
	Drug_Expiration		varchar(30)     not null,	--过期时间
)
GO

--药品适应症表
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Symptom')
	DROP TABLE Symptom
GO
CREATE TABLE Symptom
( 
	Sym_Instructions      varchar(20)     not null,       --症状说明
	Drug_Id               int             not null        --药品编号
)
GO

--处方表
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Prescription')
	DROP TABLE Prescription
GO
CREATE TABLE Prescription
(
	Pre_Id              int       not null IDENTITY(1,1),      --处方编号
	Reg_Id              int       not null,                    --挂号信息编号
	Drug_Id             int       not null                     --药品编号
)
GO

--固定症状表
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'FixedSysmptoms')
	DROP TABLE FixedSysmptoms
GO
CREATE TABLE FixedSysmptoms
(
	FS_Id             int       not null IDENTITY(1,1),    --固定症状编号
	Sysmptoms         text      not null                   --固定症状
)
GO

--固定处方表
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'FixedPrescription')
	DROP TABLE FixedPrescription
GO
CREATE TABLE FixedPrescription
(
	FS_Id             int       not null,         --固定症状编号
	Drug_Id           int       not null          --药品编号
)
GO

--新闻表
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'News')
	DROP TABLE News
GO
CREATE TABLE News
(
	New_Id              varchar(20)       not null,      --新闻编号
	New_Type            varchar(20)       not null,      --新闻类型
	New_Title           text              not null,      --新闻标题
	New_Subtitle        text              not null,      --副标题
	New_Con             text              not null,      --新闻正文
	New_Date            varchar(20)       not null       --新闻时间
) 
GO

--报表表
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Report')
	DROP TABLE Report
GO
CREATE TABLE Report
(
	Rep_Id              varchar(20)       not null,      --报表编号
	Rep_Author          varchar(20)       not null,      --提交人
	Rep_Review          varchar(20)       not null,      --审查人员
	Rep_Con             text              not null,      --报表内容
	Rep_Reply           text              not null,      --回复内容
	Rep_Type            varchar(20)       not null,      --报表类型
	Rep_Parent          varchar(20)       not null       --父级编号
)
GO

alter table Dictionary                                        --数据字典表约束
add
constraint pk_typecode  primary key(TypeCode),                --给字段编码添加主键约束
constraint ck_IsVisible check(IsVisible = 0 or IsVisible = 1) --0为true，1为false
GO

alter table [User]                                            --用户表约束
add
constraint pk_UserId  primary key([User_Id]),                 --给用户编号添加主键约束
constraint ck_UserPassword check(len(User_Password)>=6),      --用户密码最少六位
constraint df_CreateTime default (getdate()) for CreateTime,  --默认当前时间 
constraint df_ModifyTime default (getdate()) for ModifyTime   --默认当前时间
GO

alter table Department                                        --科室表约束
add
constraint pk_Dep_Id  primary key(Dep_Id)                     --给科室编号添加主键约束
GO

alter table Doctor                                            --医生表约束
add 
constraint fk_DocId foreign key (Doc_Id)                      --用户表外键
references [User]([User_Id]), 
constraint ck_IdCard check(len(IdCard)=18),                   --身份证必须为18位
constraint fk_DepartmentId foreign key (DepartmentId)         --科室表外键
references Department(Dep_Id)
GO

alter table [Role]                                            --角色表约束
add
constraint pk_RoldId  primary key(RoldId),                       --给角色编号添加主键
constraint df_RoleCreateTime default (getdate()) for CreateTime, --默认当前时间 
constraint df_RoleModifyTime default (getdate()) for ModifyTime, --默认当前时间
constraint ck_Enabled check([Enabled] = 0 or [Enabled] = 1)      --0为true，1为false
GO

alter table Privilege                                                 --权限表约束
add
constraint pk_PriId primary key(Pri_Id),                              --权限编号添加主键约束
constraint df_PrivilegeCreateTime default (getdate()) for CreateTime, --默认当前时间 
constraint df_PrivilegeModifyTime default (getdate()) for ModifyTime, --默认当前时间 
constraint ck_PrivilegeEnabled check([Enabled] = 0 or [Enabled] = 1)           --0为true，1为false
GO

alter table RolePrivilege                      --角色权限表约束                  
add
constraint pk_RPID primary key(RP_ID),         --角色权限编号添加主键约束 
constraint fk_RoleId foreign key (Role_Id)     --角色表外键
references [Role](RoldId), 
constraint fk_PriId  foreign key  (Pri_Id)     --权限表外键
references Privilege(Pri_Id)
GO

alter table Patient                                     --患者信息表约束
add
constraint pk_PatId  primary key(Pat_Id),               --给患者编号添加主键	
constraint ck_PatPassword check(len(Pat_Password)>=6)   --最少六位
GO

alter table Registered                                  --挂号信息表约束
add
constraint pk_Reg_Id  primary key(Reg_Id),              --给挂号编号添加主键约束
constraint fk_PatId foreign key (Pat_Id)                --给患者编号增加外键约束
references Patient(Pat_Id),
constraint fk_Dep_Id foreign key(Dep_Id)                --给科室编号添加外键
references Department(Dep_Id),
constraint df_RegTime default (getdate()) for Reg_Time, --挂号时间默认当前时间
constraint ck_IsPay check(IsPay=0 and IsPay=1)          --只能等于0或者1（0位true，1为FALSE）
GO

alter table Drug                                          --药品表约束
add
constraint pk_Drug  primary key(Drug_Id),                 --给药品编号添加主键
constraint ck_DrugPrice check(Drug_Price>0)              --药品价格必须大于0
GO

alter table DrugTime
add
constraint FK_DrugTime foreign key(Drug_Id) references Drug(Drug_Id), -- 过期表外键
constraint PK_DrugTime primary key clustered(Drug_Id,[Date]), -- 过期表主键
constraint ck_DrugExpiration check(convert(datetime,Drug_Expiration)>convert(datetime,Drug_Production))--生产日期
GO

alter table Symptom                                       --药品适应病症表约束
add
constraint fk_DrugId foreign key (Drug_Id)                --给药品编号增加外键约束
references Drug(Drug_Id)
GO

alter table Prescription                                --处方表
add
constraint pk_PreId  primary key(Pre_Id),               --给处方编号添加主键约束
constraint fk_RegId foreign key (Reg_Id)                --给挂号信息编号增加外键约束
references Registered(Reg_Id),
constraint fk_PrescriptionDrugId foreign key(Drug_Id)   --给药品编号添加外键约束
references Drug(Drug_Id)
GO

alter table FixedSysmptoms                              --固定症状表约束
add
constraint pk_Id  primary key(FS_Id)                    --给固定症状编号添加主键约束
GO

alter table FixedPrescription                           --固定处方表约束
add
constraint fk_FSId foreign key(FS_Id)                   --给固定症状编号添加外键约束
references FixedSysmptoms(FS_Id),
constraint fk_FDrugId  foreign key(Drug_Id)             --给药品编号添加外键约束
references Drug(Drug_Id)
GO

alter table News                                         --给新闻表添加约束
add
constraint pk_NewId  primary key(New_Id),                --给新闻编号添加主键约束
constraint df_NewDate default (getdate()) for New_Date   --新闻时间默认为当前时间
GO            