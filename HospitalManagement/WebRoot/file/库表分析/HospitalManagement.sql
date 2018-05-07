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
	TypeCode	varchar(20)     not null ,  --�ֶα���
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
	Dep_Id			int                not null IDENTITY(1000,1),     --���ұ��
	Dep_Name		varchar(20)        not null,                      --��������
	Dep_Address		text               not null                       --����λ��
)
GO

--ҽ����
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Doctor')
	DROP TABLE Doctor
GO
CREATE TABLE Doctor
(
	Doc_Id			varchar(20)       not null,      --ҽ�����
	TrueName		varchar(20)       not null,      --��ʵ����
	IdCard			varchar(18)       not null,      --���֤��
	Doc_Sex			varchar(20),                     --ҽ���Ա�
	Doc_Birthday	varchar(20),                     --����
	SchoolRecord	varchar(20),                     --ѧ��
	TelePhone		varchar(11),                     --�绰����
	Office_Phone	varchar(20),                     --�칫�ҵ绰
	Onjob_Static	varchar(20),                     --��ְ״̬
	Email			varchar(50),                     --����
	DepartmentId	int               not null       --����Id
)
GO

--�û���
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'User')
	DROP TABLE [User]
GO
CREATE TABLE [User]
(
	[User_Id]		varchar(20)        not null,       --�û����
	User_Password	varchar(20)        not null,       --�û�����
	CreateTime		varchar(30)        not null,       --����ʱ��
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
	RoldId      int            not null IDENTITY(1000,1),         --��ɫ���   
	RoldName    varchar(20)    not null,                          --��ɫ����
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
	Pri_Id          int             not null IDENTITY(1000,1),     --Ȩ�ޱ��
	Pri_Name        varchar(20)     not null,                   --Ȩ������
	Parent_Id       int,                                        --�ϼ�Ȩ�ޱ��
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
	RP_ID        int     not null IDENTITY(1000,1), --���
	Role_Id      int     not null,                  --��ɫ���
	Pri_Id       int     not null                   --Ȩ�ޱ��
)
GO

--������Ϣ��
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Patient')
	DROP TABLE Patient
GO
CREATE TABLE Patient
(
	Pat_Id                    int           not null IDENTITY(1000,1),--���߱��
	Pat_Password              varchar(20)   not null,                 --����
	Pat_Name                  varchar(20)   not null,                 --��������
	Pat_Card				  varchar(18),							  --���֤��
	Pat_Sex                   varchar(20),							  --�Ա�
	Pat_Birthday              varchar(20),                            --����
	Pat_Phone                 varchar(20),                            --�绰
	Pat_Address               text,                                   --��ַ
	Pat_Symotoms              text,                                   --����֢״
	Genetic_Disorders         text                                    --�Ŵ���ʷ 
)
GO

--�Һ���Ϣ��
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Registered')
	DROP TABLE Registered
GO
CREATE TABLE Registered
(
	Reg_Id              int            not null IDENTITY(1,1),--�Һű��
	Pat_Id              int            not null,              --���߱��
	Reg_Time            varchar(20)    not null,              --�Һ�ʱ��
	Dep_Id              int            not null,              --���ұ��
	Reg_Type            varchar(20)    not null,              --�Һ����
	Reg_Price           float          not null,              --�ҺŽ��
	Reg_Static          varchar(20)    not null,              --״̬
	IsPay               int                                   --�Һ��Ƿ񸶿�
)
GO

--ҩƷ��
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Drug')
	DROP TABLE Drug
GO
CREATE TABLE Drug
(
	Drug_Id                   int             not null IDENTITY(1,1), --ҩƷ���
	Drug_Name                 varchar(20)     not null,               --ҩƷ����
	Drug_Alias                text,                                   --������
	Drug_Shape                varchar(20)     not null,               --����
	Drug_Type                 varchar(20)     not null,               --ҩƷ���
	Drug_Number               int             not null,               --���
	Drug_Price                float           not null,               --ҩƷ�۸�
	Drug_Consumption          text,                                   --�÷�����
	Attention                 text                                    --ע������
)
GO

--ҩƷ����ʱ���
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'DrugTime')
	DROP TABLE DrugTiem
GO
CREATE TABLE DrugTime
(
	Drug_Id				int				not null,	--���
	[Date]				varchar(20)		not null,	--����ʱ��
	Drug_Number			int				not null,	--��������
	Drug_Production		varchar(30)     not null,	--��������
	Drug_Expiration		varchar(30)     not null,	--����ʱ��
)
GO

--ҩƷ��Ӧ֢��
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Symptom')
	DROP TABLE Symptom
GO
CREATE TABLE Symptom
( 
	Sym_Instructions      varchar(20)     not null,       --֢״˵��
	Drug_Id               int             not null        --ҩƷ���
)
GO

--������
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Prescription')
	DROP TABLE Prescription
GO
CREATE TABLE Prescription
(
	Pre_Id              int       not null IDENTITY(1,1),      --�������
	Reg_Id              int       not null,                    --�Һ���Ϣ���
	Drug_Id             int       not null                     --ҩƷ���
)
GO

--�̶�֢״��
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'FixedSysmptoms')
	DROP TABLE FixedSysmptoms
GO
CREATE TABLE FixedSysmptoms
(
	FS_Id             int       not null IDENTITY(1,1),    --�̶�֢״���
	Sysmptoms         text      not null                   --�̶�֢״
)
GO

--�̶�������
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'FixedPrescription')
	DROP TABLE FixedPrescription
GO
CREATE TABLE FixedPrescription
(
	FS_Id             int       not null,         --�̶�֢״���
	Drug_Id           int       not null          --ҩƷ���
)
GO

--���ű�
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'News')
	DROP TABLE News
GO
CREATE TABLE News
(
	New_Id              varchar(20)       not null,      --���ű��
	New_Type            varchar(20)       not null,      --��������
	New_Title           text              not null,      --���ű���
	New_Subtitle        text              not null,      --������
	New_Con             text              not null,      --��������
	New_Date            varchar(20)       not null       --����ʱ��
) 
GO

--�����
IF EXISTS(SELECT * FROM SYSOBJECTS WHERE name = 'Report')
	DROP TABLE Report
GO
CREATE TABLE Report
(
	Rep_Id              varchar(20)       not null,      --������
	Rep_Author          varchar(20)       not null,      --�ύ��
	Rep_Review          varchar(20)       not null,      --�����Ա
	Rep_Con             text              not null,      --��������
	Rep_Reply           text              not null,      --�ظ�����
	Rep_Type            varchar(20)       not null,      --��������
	Rep_Parent          varchar(20)       not null       --�������
)
GO

alter table Dictionary                                        --�����ֵ��Լ��
add
constraint pk_typecode  primary key(TypeCode),                --���ֶα����������Լ��
constraint ck_IsVisible check(IsVisible = 0 or IsVisible = 1) --0Ϊtrue��1Ϊfalse
GO

alter table [User]                                            --�û���Լ��
add
constraint pk_UserId  primary key([User_Id]),                 --���û�����������Լ��
constraint ck_UserPassword check(len(User_Password)>=6),      --�û�����������λ
constraint df_CreateTime default (getdate()) for CreateTime,  --Ĭ�ϵ�ǰʱ�� 
constraint df_ModifyTime default (getdate()) for ModifyTime   --Ĭ�ϵ�ǰʱ��
GO

alter table Department                                        --���ұ�Լ��
add
constraint pk_Dep_Id  primary key(Dep_Id)                     --�����ұ���������Լ��
GO

alter table Doctor                                            --ҽ����Լ��
add 
constraint fk_DocId foreign key (Doc_Id)                      --�û������
references [User]([User_Id]), 
constraint ck_IdCard check(len(IdCard)=18),                   --���֤����Ϊ18λ
constraint fk_DepartmentId foreign key (DepartmentId)         --���ұ����
references Department(Dep_Id)
GO

alter table [Role]                                            --��ɫ��Լ��
add
constraint pk_RoldId  primary key(RoldId),                       --����ɫ����������
constraint df_RoleCreateTime default (getdate()) for CreateTime, --Ĭ�ϵ�ǰʱ�� 
constraint df_RoleModifyTime default (getdate()) for ModifyTime, --Ĭ�ϵ�ǰʱ��
constraint ck_Enabled check([Enabled] = 0 or [Enabled] = 1)      --0Ϊtrue��1Ϊfalse
GO

alter table Privilege                                                 --Ȩ�ޱ�Լ��
add
constraint pk_PriId primary key(Pri_Id),                              --Ȩ�ޱ���������Լ��
constraint df_PrivilegeCreateTime default (getdate()) for CreateTime, --Ĭ�ϵ�ǰʱ�� 
constraint df_PrivilegeModifyTime default (getdate()) for ModifyTime, --Ĭ�ϵ�ǰʱ�� 
constraint ck_PrivilegeEnabled check([Enabled] = 0 or [Enabled] = 1)           --0Ϊtrue��1Ϊfalse
GO

alter table RolePrivilege                      --��ɫȨ�ޱ�Լ��                  
add
constraint pk_RPID primary key(RP_ID),         --��ɫȨ�ޱ���������Լ�� 
constraint fk_RoleId foreign key (Role_Id)     --��ɫ�����
references [Role](RoldId), 
constraint fk_PriId  foreign key  (Pri_Id)     --Ȩ�ޱ����
references Privilege(Pri_Id)
GO

alter table Patient                                     --������Ϣ��Լ��
add
constraint pk_PatId  primary key(Pat_Id),               --�����߱���������	
constraint ck_PatPassword check(len(Pat_Password)>=6)   --������λ
GO

alter table Registered                                  --�Һ���Ϣ��Լ��
add
constraint pk_Reg_Id  primary key(Reg_Id),              --���Һű���������Լ��
constraint fk_PatId foreign key (Pat_Id)                --�����߱���������Լ��
references Patient(Pat_Id),
constraint fk_Dep_Id foreign key(Dep_Id)                --�����ұ��������
references Department(Dep_Id),
constraint df_RegTime default (getdate()) for Reg_Time, --�Һ�ʱ��Ĭ�ϵ�ǰʱ��
constraint ck_IsPay check(IsPay=0 and IsPay=1)          --ֻ�ܵ���0����1��0λtrue��1ΪFALSE��
GO

alter table Drug                                          --ҩƷ��Լ��
add
constraint pk_Drug  primary key(Drug_Id),                 --��ҩƷ����������
constraint ck_DrugPrice check(Drug_Price>0)              --ҩƷ�۸�������0
GO

alter table DrugTime
add
constraint FK_DrugTime foreign key(Drug_Id) references Drug(Drug_Id), -- ���ڱ����
constraint PK_DrugTime primary key clustered(Drug_Id,[Date]), -- ���ڱ�����
constraint ck_DrugExpiration check(convert(datetime,Drug_Expiration)>convert(datetime,Drug_Production))--��������
GO

alter table Symptom                                       --ҩƷ��Ӧ��֢��Լ��
add
constraint fk_DrugId foreign key (Drug_Id)                --��ҩƷ����������Լ��
references Drug(Drug_Id)
GO

alter table Prescription                                --������
add
constraint pk_PreId  primary key(Pre_Id),               --����������������Լ��
constraint fk_RegId foreign key (Reg_Id)                --���Һ���Ϣ����������Լ��
references Registered(Reg_Id),
constraint fk_PrescriptionDrugId foreign key(Drug_Id)   --��ҩƷ���������Լ��
references Drug(Drug_Id)
GO

alter table FixedSysmptoms                              --�̶�֢״��Լ��
add
constraint pk_Id  primary key(FS_Id)                    --���̶�֢״����������Լ��
GO

alter table FixedPrescription                           --�̶�������Լ��
add
constraint fk_FSId foreign key(FS_Id)                   --���̶�֢״���������Լ��
references FixedSysmptoms(FS_Id),
constraint fk_FDrugId  foreign key(Drug_Id)             --��ҩƷ���������Լ��
references Drug(Drug_Id)
GO

alter table News                                         --�����ű����Լ��
add
constraint pk_NewId  primary key(New_Id),                --�����ű���������Լ��
constraint df_NewDate default (getdate()) for New_Date   --����ʱ��Ĭ��Ϊ��ǰʱ��
GO            