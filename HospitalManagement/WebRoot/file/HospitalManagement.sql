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

--�����ֵ�
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Dictionary')
	DROP TABLE Dictionary
GO
CREATE TABLE Dictionary
(
	DicId		int				identity(1,1),	--�����
	TypeCode	varchar(20)     not null,   --�ֶα���
	TypeName	varchar(20),                --�ֶ�����
	TypeValus	varchar(20),                --�ֶ�ֵ
	IsVisible	int,                        --�Ƿ�ɼ�
	Memo		text                        --��ע
)
GO

--���ұ�
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Department')
	DROP TABLE Department
GO
CREATE TABLE Department
(
	DepId			int                not null IDENTITY(1000,1),     --���ұ��
	DepName			varchar(20)        not null,                      --��������
	DepAddress		text               not null                       --����λ��
)
GO

--ҽ����
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Doctor')
	DROP TABLE Doctor
GO
CREATE TABLE Doctor
(
	DocId			varchar(20)       not null,      --ҽ�����
	TrueName		varchar(20)       not null,      --��ʵ����
	IdCard			varchar(18)       not null,      --���֤��
	DocSex			varchar(20),                     --ҽ���Ա�
	DocBirthday		varchar(20),                     --����
	SchoolRecord	varchar(20),                     --ѧ��
	TelePhone		varchar(11),                     --�绰����
	OfficePhone		varchar(20),                     --�칫�ҵ绰
	OnjobState		varchar(20),                     --��ְ״̬
	Email			varchar(50),                     --����
	DepartmentId	int               not null,      --����Id
	Duty			varchar(20)
)
GO

--�û���
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'User')
	DROP TABLE [User]
GO
CREATE TABLE [User]
(
	[UserId]		varchar(20)			not null,       --�û����
	UserPassword	varchar(20)			not null,       --�û�����
	RoleId			int					not null,	   --�û���ɫ���
	OnlineState		varchar(20)			not null,		--��ǰ�û�����״̬
	CreateTime		varchar(30)			not null,       --����ʱ��
	ModifyTime		varchar(30),                       --�޸�ʱ��
	LastLogin		varchar(20)                        --���һ�ε�¼ʱ��
)
GO

--��ɫ��
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Role')
	DROP TABLE [Role]
GO
CREATE TABLE [Role]
( 
	RoleId      int            not null IDENTITY(1000,1),         --��ɫ���   
	RoleName    varchar(20)    not null,                          --��ɫ����
	CreateTime	varchar(30)    not null,                          --��ɫ����ʱ��
	ModifyTime  varchar(30),                                      --�޸�ʱ��
	[Enabled]   int                                               --�Ƿ���øý�ɫ
)
GO

--Ȩ�ޱ�
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Privilege')
	DROP TABLE Privilege
GO
CREATE TABLE Privilege
(
	PriId			int             not null IDENTITY(1000,1),     --Ȩ�ޱ��
	PriName			varchar(20)     not null,                   --Ȩ������
	ParentId		int,                                        --�ϼ�Ȩ�ޱ��
	Memo            text,                                       --��ע
	MenuPic         text,                                       --ͼ��
	MenuUrl         text,                                       --Ȩ��·��
	DisplayOrder    varchar(10),                                --����
	CreateTime      varchar(30)     not null,                   --����ʱ��
	ModifyTime      varchar(30),                                --�޸�ʱ��
	[Enabled]       int                                         --�Ƿ���ø�Ȩ��
)
GO

--��ɫȨ�ޱ�
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'RolePrivilege')
	DROP TABLE RolePrivilege
GO
CREATE TABLE RolePrivilege
(
	RPID        int     not null IDENTITY(1000,1), --���
	RoleId      int     not null,                  --��ɫ���
	PriId       int     not null                   --Ȩ�ޱ��
)
GO

--������Ϣ��
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Patient')
	DROP TABLE Patient
GO
CREATE TABLE Patient
(
	PatId				int				not null IDENTITY(1000,1),	--���߱��
	PatNickname			varchar(20),				--�û���		  
	PatPassword			varchar(20)		not null,	--����
	PatName				varchar(20),				--��������
	PatCard				varchar(18),				--���֤��
	PatSex				varchar(20),				--�Ա�
	PatBirthday			varchar(20),				--����
	PatPhone			varchar(20),				--�绰
	PatAddress			text,						--��ַ
	PatSymotoms			text,						--����֢״
	GeneticDisorders	text						--�Ŵ���ʷ 
)
GO

--�Һ���Ϣ��
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Registered')
	DROP TABLE Registered
GO
CREATE TABLE Registered
(
	RegId				int				not null IDENTITY(1,1),--�Һű��
	PatId				int				not null,		--���߱��
	RegTime				varchar(20)		not null,		--�Һ�ʱ��
	DepId				int				not null,		--���ұ��
	DocId				varchar(20)		not null,		--ҽ�����
	RegType				varchar(20)		not null,		--�Һ����
	RegPrice			float			not null,		--�ҺŽ��
	PayState			int				not null,		--�����Ƿ񸶿�
	RegState			varchar(20)		not null,		--״̬
	IsPay               int			--�Һ��Ƿ񸶿�
)
GO

--ҩƷ��
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Drug')
	DROP TABLE Drug
GO
CREATE TABLE Drug
(
	DrugId				int				not null IDENTITY(1,1), --ҩƷ���
	DrugName			varchar(20)		not null,               --ҩƷ����
	DrugAlias			text,                                   --������
	DrugShape			varchar(20)		not null,               --����
	DrugType			varchar(20)		not null,               --ҩƷ���
	DrugNumber			int				not null,               --���
	DrugPrice			float			not null,               --ҩƷ�۸�
	DrugConsumption		text,                                   --�÷�����
	Attention			text                                    --ע������
)
GO

--ҩƷ����ʱ���
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'DrugTime')
	DROP TABLE DrugTiem
GO
CREATE TABLE DrugTime
(
	DrugId				int				not null,	--���
	[Date]				varchar(20)		not null,	--����ʱ��
	DrugNumber			int				not null,	--��������
	DrugProduction		varchar(30)     not null,	--��������
	DrugExpiration		varchar(30)     not null,	--����ʱ��
)
GO

--ҩƷ��Ӧ֢��
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Symptom')
	DROP TABLE Symptom
GO
CREATE TABLE Symptom
( 
	SymInstructions      varchar(20)     not null,       --֢״˵��
	DrugId               int             not null        --ҩƷ���
)
GO

--������
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Prescription')
	DROP TABLE Prescription
GO
CREATE TABLE Prescription
(
	DOId		int			not null,                    --������
	DrugId		int			not null,                    --ҩƷ���
	DrugNum		int			not null					--ҩƷ����
)
GO

--�����
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'DoctorOffer')
	DROP TABLE DoctorOffer
GO
CREATE TABLE DoctorOffer
(
	DOId		int identity(1,1),		--������
	DocId		varchar(20),--ҽ�����
	RegId		int,		--�Һű��
	Symptom		text		--֢״��Ϣ
)

--�̶�֢״��
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'FixedSysmptoms')
	DROP TABLE FixedSysmptoms
GO
CREATE TABLE FixedSysmptoms
(
	FSId             int       not null IDENTITY(1,1),    --�̶�֢״���
	Sysmptoms         text      not null                   --�̶�֢״
)
GO

--�̶�������
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'FixedPrescription')
	DROP TABLE FixedPrescription
GO
CREATE TABLE FixedPrescription
(
	FSId             int       not null,         --�̶�֢״���
	DrugId           int       not null          --ҩƷ���
)
GO

--ר�ұ�
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Specialist')
	DROP TABLE Specialist
CREATE TABLE Specialist
(
	SpeId			int				identity(1,1),
	DepId			int				not null,
	DocId			varchar(20)		not null,
	[DateTime]		varchar(20)		not null
)

--���ű�
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'News')
	DROP TABLE News
GO
CREATE TABLE News
(
	NewId              varchar(20)       not null,      --���ű��
	NewType            varchar(20)       not null,      --��������
	NewTitle           text              not null,      --���ű���
	NewSubtitle        text              not null,      --������
	NewCon             text              not null,      --��������
	NewDate            varchar(20)       not null       --����ʱ��
) 
GO

--�����
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Report')
	DROP TABLE Report
GO
CREATE TABLE Report
(
	RepId              varchar(20)       not null,      --������
	RepAuthor          varchar(20)       not null,      --�ύ��
	RepReview          varchar(20)       not null,      --�����Ա
	RepCon             text              not null,      --��������
	RepReply           text,      --�ظ�����
	RepType            varchar(20)       not null,      --��������
)
GO

alter table Dictionary                                        --�����ֵ��Լ��
add
constraint pk_DicId  primary key(DicId),                --���ֶα����������Լ��
constraint ck_IsVisible check(IsVisible = 0 or IsVisible = 1) --0Ϊtrue��1Ϊfalse
GO

alter table Department                                        --���ұ�Լ��
add
constraint pk_Dep_Id  primary key(DepId)                     --�����ұ���������Լ��
GO

alter table [Role]                                            --��ɫ��Լ��
add
constraint pk_RoldId  primary key(RoleId),                       --����ɫ����������
constraint df_RoleCreateTime default (getdate()) for CreateTime, --Ĭ�ϵ�ǰʱ�� 
constraint df_RoleModifyTime default (getdate()) for ModifyTime, --Ĭ�ϵ�ǰʱ��
constraint ck_Enabled check([Enabled] = 0 or [Enabled] = 1)      --0Ϊtrue��1Ϊfalse
GO

alter table [User]                                            --�û���Լ��
add
constraint pk_UserId  primary key([UserId]),                 --���û�����������Լ��
constraint fk_UserRoleId foreign key (RoleId)         --���ұ����
references Role(RoleId),
constraint ck_UserPassword check(len(UserPassword)>=6),      --�û�����������λ
constraint df_CreateTime default (getdate()) for CreateTime,  --Ĭ�ϵ�ǰʱ�� 
constraint df_ModifyTime default (getdate()) for ModifyTime   --Ĭ�ϵ�ǰʱ��
GO

alter table Doctor                                            --ҽ����Լ��
add 
constraint fk_DocId foreign key (DocId)                      --�û������
references [User]([UserId]), 
constraint ck_IdCard check(len(IdCard)=18),                   --���֤����Ϊ18λ
constraint fk_DepartmentId foreign key (DepartmentId)         --���ұ����
references Department(DepId)
GO

alter table Privilege                                                 --Ȩ�ޱ�Լ��
add
constraint pk_PriId primary key(PriId),                              --Ȩ�ޱ���������Լ��
constraint df_PrivilegeCreateTime default (getdate()) for CreateTime, --Ĭ�ϵ�ǰʱ�� 
constraint df_PrivilegeModifyTime default (getdate()) for ModifyTime, --Ĭ�ϵ�ǰʱ�� 
constraint ck_PrivilegeEnabled check([Enabled] = 0 or [Enabled] = 1)           --0Ϊtrue��1Ϊfalse
GO

alter table RolePrivilege                      --��ɫȨ�ޱ�Լ��                  
add
constraint pk_RPID primary key(RPID),         --��ɫȨ�ޱ���������Լ�� 
constraint fk_RoleId foreign key (RoleId)     --��ɫ�����
references [Role](RoleId), 
constraint fk_PriId  foreign key  (PriId)     --Ȩ�ޱ����
references Privilege(PriId)
GO

alter table Patient                                     --������Ϣ��Լ��
add
constraint pk_PatId  primary key(PatId),               --�����߱���������	
constraint ck_PatPassword check(len(PatPassword)>=6)   --������λ
GO

alter table Registered                                  --�Һ���Ϣ��Լ��
add
constraint pk_Reg_Id  primary key(RegId),              --���Һű���������Լ��
constraint fk_PatId foreign key (PatId)                --�����߱���������Լ��
references Patient(PatId),
constraint fk_Dep_Id foreign key(DepId)                --�����ұ��������
references Department(DepId),
constraint df_RegTime default (getdate()) for RegTime, --�Һ�ʱ��Ĭ�ϵ�ǰʱ��
constraint ck_IsPay check(IsPay=0 or IsPay=1)          --ֻ�ܵ���0����1��0λtrue��1ΪFALSE��
GO

alter table Drug                                          --ҩƷ��Լ��
add
constraint pk_Drug  primary key(DrugId),                 --��ҩƷ����������
constraint ck_DrugPrice check(DrugPrice>0)              --ҩƷ�۸�������0
GO

alter table DrugTime
add
constraint FK_DrugTime foreign key(DrugId) references Drug(DrugId), -- ���ڱ����
constraint PK_DrugTime primary key clustered(DrugId,[Date]), -- ���ڱ�����
constraint ck_DrugExpiration check(convert(datetime,DrugExpiration)>convert(datetime,DrugProduction))--��������
GO

alter table Symptom                                       --ҩƷ��Ӧ��֢��Լ��
add
constraint fk_DrugId foreign key (DrugId)                --��ҩƷ����������Լ��
references Drug(DrugId)
GO

alter table DoctorOffer                                        --������Լ��
add
constraint pk_DOId  primary key(DOId),	--���������������Լ��
constraint fk_DoctorOffer foreign key(DocId)
references [User]([UserId]),
constraint fk_RegId foreign key(RegId)
references Registered(RegId)
GO

alter table Prescription                                --������
add
constraint fk_PrescriptionDrugId foreign key(DrugId)   --��ҩƷ���������Լ��
references Drug(DrugId)
GO

alter table FixedSysmptoms                              --�̶�֢״��Լ��
add
constraint pk_Id  primary key(FSId)                    --���̶�֢״����������Լ��
GO

alter table FixedPrescription                           --�̶�������Լ��
add
constraint fk_FSId foreign key(FSId)                   --���̶�֢״���������Լ��
references FixedSysmptoms(FSId),
constraint fk_FDrugId  foreign key(DrugId)             --��ҩƷ���������Լ��
references Drug(DrugId)
GO

alter table News                                         --�����ű����Լ��
add
constraint pk_NewId  primary key(NewId),                --�����ű���������Լ��
constraint df_NewDate default (getdate()) for NewDate   --����ʱ��Ĭ��Ϊ��ǰʱ��
GO


--��Ӳ�������
--������û�����ݹ���Ա��ɣ��κ��˲���ɾ��

use HospitalManagement
go

--�����ֵ�
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('001','�Ա�','��','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('002','�Ա�','Ů','1')

insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('101','��ɫ','����Ա','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('102','��ɫ','Ժ��','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('103','��ɫ','��������','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('104','��ɫ','ҽ��','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('105','��ɫ','ҩ������','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('106','��ɫ','�շѹ���','1')

insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('201','����','����','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('202','����','����','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('203','����','Ƥ����','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('204','����','�����','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('205','����','��Ѫ��','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('206','����','�Կ�','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('207','����','���Ǻ��','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('208','����','�ۿ�','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('209','����','������','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('210','����','��ҽ1','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('210','����','��ҽ2','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('210','����','��ҽ3','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('211','����','�ڿ�','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('212','����','�ǿ�','1')

insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('301','��ְ״̬','��ְ','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('302','��ְ״̬','��ְ','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('303','��ְ״̬','�ݼ�','1')

insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible,Memo) values('401','�Һ����','ר�Һ�','1','5.0')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible,Memo) values('402','�Һ����','��ͨ��','1','2.5')

insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('501','���״̬','δ���','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('502','���״̬','�������','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('503','���״̬','�����','1')

insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('601','ҩƷ���','����ҩ','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('602','ҩƷ���','�Ǵ���ҩ','1')

insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('701','ҩƷ����','Ƭ��','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('702','ҩƷ����','���','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('703','ҩƷ����','������','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('704','ҩƷ����','�ڷ�Һ��','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('705','ҩƷ����','����','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('706','ҩƷ����','������','1')

insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('801','���ŷ���','����','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('802','���ŷ���','����','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('803','���ŷ���','��̬','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('804','���ŷ���','����','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('805','���ŷ���','����','1')

insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('901','��������','�ձ�','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('902','��������','�ܱ�','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('903','��������','�±�','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('904','��������','���ܽ�','1')

insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('1001','����״̬','����','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('1002','����״̬','����','1')

insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('1101','ѧ��','����','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('1102','ѧ��','����','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('1103','ѧ��','��ר','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('1104','ѧ��','����','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('1105','ѧ��','˶ʿ','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('1106','ѧ��','��ʿ','1')

insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('1201','ְ��','ҽ��','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('1202','ְ��','������','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('1203','ְ��','��������','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('1204','ְ��','��Ժ��','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('1205','ְ��','Ժ��','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('1206','ְ��','ҩ������','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('1207','ְ��','�տ����','1')

--��ɫ��
insert into Role(RoleName,CreateTime,ModifyTime,[Enabled]) values('101','2016-02-23','2017-03-23','1')
insert into Role(RoleName,CreateTime,ModifyTime,[Enabled]) values('102','2017-02-12','2017-03-23','1')
insert into Role(RoleName,CreateTime,ModifyTime,[Enabled]) values('103','2016-06-26','2017-03-23','1')
insert into Role(RoleName,CreateTime,ModifyTime,[Enabled]) values('104','2016-08-02','2017-03-23','1')
insert into Role(RoleName,CreateTime,ModifyTime,[Enabled]) values('105','2016-12-03','2017-03-23','1')
insert into Role(RoleName,CreateTime,ModifyTime,[Enabled]) values('106','2016-01-18','2017-03-23','1')

--�û���
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

--���߱��������
insert into Patient(PatCard,PatName,PatNickname,PatPassword,PatPhone) values('410325199501024512','��������','��������','123456','15256235689')
insert into Patient(PatCard,PatName,PatNickname,PatPassword,PatPhone) values('410325199412135689','bdqn','bdqn','123456','1359568956')
insert into Patient(PatCard,PatName,PatNickname,PatPassword,PatPhone) values('410366188602035623','����','����','123456','1804524569')

--���ұ������Ϣ
insert into Department values('201','��¥201')
insert into Department values('202','��¥303')
insert into Department values('203','��¥205')
insert into Department values('204','һ¥108')
insert into Department values('205','��¥208')
insert into Department values('206','��¥403')
insert into Department values('207','��¥505')
insert into Department values('208','��¥404')
insert into Department values('209','��¥508')
insert into Department values('210','��¥401')
insert into Department values('211','��¥308')
insert into Department values('212','��¥305')

--ҽ����
insert into Doctor (DocId,TrueName,IdCard,DocSex,DocBirthday,SchoolRecord,TelePhone,OfficePhone,OnjobState,Email,DepartmentId,Duty) values('201701135655','����','410326199602068956','001','1996-02-06','1104','13838838438','0379-66595689','301','zhangsan@163.com','1008','1201')
insert into Doctor (DocId,TrueName,IdCard,DocSex,DocBirthday,SchoolRecord,TelePhone,OfficePhone,OnjobState,Email,DepartmentId,Duty) values('201701135667','����','410344199602068956','001','1996-02-06','1105','1359632356','0379-66595689','301','lisi@163.com','1007','1201')
insert into Doctor (DocId,TrueName,IdCard,DocSex,DocBirthday,SchoolRecord,TelePhone,OfficePhone,OnjobState,Email,DepartmentId,Duty) values('201701135677','������','413325199602068956','001','1996-02-06','1106','1369632356','0379-66595689','301','wangmazi@163.com','1007','1201')
insert into Doctor (DocId,TrueName,IdCard,DocSex,DocBirthday,SchoolRecord,TelePhone,OfficePhone,OnjobState,Email,DepartmentId,Duty) values('201701135689','��һ','410565199602068956','002','1996-02-06','1104','13838838438','0379-66595689','301','zhaoyi@163.com','1006','1201')
insert into Doctor (DocId,TrueName,IdCard,DocSex,DocBirthday,SchoolRecord,TelePhone,OfficePhone,OnjobState,Email,DepartmentId,Duty) values('201701135692','Ǯ��','410665199602068956','001','1996-02-06','1105','13838838438','0379-66595689','301','qianer@163.com','1005','1201')
insert into Doctor (DocId,TrueName,IdCard,DocSex,DocBirthday,SchoolRecord,TelePhone,OfficePhone,OnjobState,Email,DepartmentId,Duty) values('201701135696','����','410325199402068956','001','1996-02-06','1106','13838838438','0379-66595689','301','sunsan@163.com','1006','1201')
insert into Doctor (DocId,TrueName,IdCard,DocSex,DocBirthday,SchoolRecord,TelePhone,OfficePhone,OnjobState,Email,DepartmentId,Duty) values('201701135694','����','410325199502068956','001','1996-02-06','1104','13838838438','0379-66595689','301','zhousi@163.com','1005','1201')
insert into Doctor (DocId,TrueName,IdCard,DocSex,DocBirthday,SchoolRecord,TelePhone,OfficePhone,OnjobState,Email,DepartmentId,Duty) values('201701139652','����','410325199702068956','001','1996-02-06','1105','13838838438','0379-66595689','301','zhaosi@163.com','1008','1201')
insert into Doctor (DocId,TrueName,IdCard,DocSex,DocBirthday,SchoolRecord,TelePhone,OfficePhone,OnjobState,Email,DepartmentId,Duty) values('201701131236','����','410325199802068956','001','1996-02-06','1106','13838838438','0379-66595689','301','wuqi@163.com','1008','1201')
insert into Doctor (DocId,TrueName,IdCard,DocSex,DocBirthday,SchoolRecord,TelePhone,OfficePhone,OnjobState,Email,DepartmentId,Duty) values('201701131245','֣��','410325199202068956','001','1996-02-06','1105','13838838438','0379-66595689','301','zhengliu@163.com','1008','1201')
insert into Doctor (DocId,TrueName,IdCard,DocSex,DocBirthday,SchoolRecord,TelePhone,OfficePhone,OnjobState,Email,DepartmentId,Duty) values('201701135623','����','410325199102068956','001','1996-02-06','1106','13838838438','0379-66595689','301','wanger@163.com','1005','1201')
insert into Doctor (DocId,TrueName,IdCard,DocSex,DocBirthday,SchoolRecord,TelePhone,OfficePhone,OnjobState,Email,DepartmentId,Duty) values('201701138886','˾��','410325198902068956','002','1996-02-06','1104','13838838438','0379-66595689','301','sima@163.com','1005','1201')
insert into Doctor (DocId,TrueName,IdCard,DocSex,DocBirthday,SchoolRecord,TelePhone,OfficePhone,OnjobState,Email,DepartmentId,Duty) values('201701136412','ŷ��','410325199002068956','002','1996-02-06','1104','13838838438','0379-66595689','301','ouyang@163.com','1005','1201')
insert into Doctor (DocId,TrueName,IdCard,DocSex,DocBirthday,SchoolRecord,TelePhone,OfficePhone,OnjobState,Email,DepartmentId,Duty) values('201701136512','��ľ','410325198702068956','002','1996-02-06','1105','13838838438','0379-66595689','301','duanmu@163.com','1006','1201')
insert into Doctor (DocId,TrueName,IdCard,DocSex,DocBirthday,SchoolRecord,TelePhone,OfficePhone,OnjobState,Email,DepartmentId,Duty) values('201701136596','���¾���','410373199602068956','002','1996-02-06','1106','13838838438','0379-66595689','301','aixinjueluo@163.com','1007','1201')
insert into Doctor (DocId,TrueName,IdCard,DocSex,DocBirthday,SchoolRecord,TelePhone,OfficePhone,OnjobState,Email,DepartmentId,Duty) values('201701137845','����','410325195602068956','002','1996-02-06','1106','13838838438','0379-66595689','301','gongsun@163.com','1008','1201')
insert into Doctor (DocId,TrueName,IdCard,DocSex,DocBirthday,SchoolRecord,TelePhone,OfficePhone,OnjobState,Email,DepartmentId,Duty) values('201701135633','���','410325197902068956','001','1996-02-06','1106','13838838438','0379-66595689','301','yangguo@163.com','1008','1201')


--�Һű������Ϣ
insert into Registered values('1001',GETDATE(),'1008','201701135655','1','5.80','0','501',0)
insert into Registered values('1000',GETDATE(),'1007','201701135677','1','5.80','0','501',0)
insert into Registered values('1002',GETDATE(),'1011','201701135692','1','5.80','0','501',0)
insert into Registered values('1001',GETDATE(),'1006','201701136512','1','5.80','0','501',0)


--ҩƷ��
insert into Drug (DrugName,DrugShape,DrugType,DrugNumber,DrugPrice) values('��ð����','����','�Ǵ���','5000','10')
insert into Drug (DrugName,DrugShape,DrugType,DrugNumber,DrugPrice) values('˫�����ڷ�Һ','�ڷ�Һ','�Ǵ���','5000','10')
insert into Drug (DrugName,DrugShape,DrugType,DrugNumber,DrugPrice) values('�ٷ���','Ƭ��','�Ǵ���','5000','10')
insert into Drug (DrugName,DrugShape,DrugType,DrugNumber,DrugPrice) values('���Ƚⶾ�ڷ�Һ','�ڷ�Һ','�Ǵ���','5000','10')
insert into Drug (DrugName,DrugShape,DrugType,DrugNumber,DrugPrice) values('����Ϣʹ','Ƭ��','�Ǵ���','5000','10')
insert into Drug (DrugName,DrugShape,DrugType,DrugNumber,DrugPrice) values('��˾ƥ��','����','�Ǵ���','5000','10')
insert into Drug (DrugName,DrugShape,DrugType,DrugNumber,DrugPrice) values('޽������Һ','�ڷ�Һ','�Ǵ���','5000','10')
insert into Drug (DrugName,DrugShape,DrugType,DrugNumber,DrugPrice) values('�����涡','����','�Ǵ���','5000','10')

--�����洢���̣���ȡ��ӵ���Ϣ�������ӱ��
CREATE PROCEDURE Get_Id   
(    
  @id int output 
)AS
select @id = @@IDENTITY
go