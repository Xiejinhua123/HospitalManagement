USE HospitalManagement
--数据字典
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('001','性别','男','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('002','性别','女','1')

insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('101','角色名称','超级管理员','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('102','角色名称','管理员','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('103','角色名称','院长','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('104','角色名称','科室主任','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('105','角色名称','医生','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('106','角色名称','药房管理','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('107','角色名称','收费管理','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('108','角色名称','员工','1')

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

insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('1301','药品单位','盒','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('1302','药品单位','粒','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('1303','药品单位','片','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('1304','药品单位','瓶','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('1305','药品单位','包','1')
insert into Dictionary (TypeCode,TypeName,TypeValus,IsVisible) values('1306','药品单位','支','1')


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

--添加用户
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201701135688','123456','1001','2017-01-13','2017-01-13','2017-01-13','赵','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1000',0,'1201')
insert into Users 
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201701135676','123456','1001','2017-01-13','2017-01-13','2017-01-13','钱','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1001',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201701135671','123456','1001','2017-01-13','2017-01-13','2017-01-13','孙','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1002',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201701135672','123456','1001','2017-01-13','2017-01-13','2017-01-13','李','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1003',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201701135673','123456','1001','2017-01-13','2017-01-13','2017-01-13','周','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1004',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201701135674','123456','1001','2017-01-13','2017-01-13','2017-01-13','吴','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1005',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201701135675','123456','1001','2017-01-13','2017-01-13','2017-01-13','郑','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1006',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201701135678','123456','1001','2017-01-13','2017-01-13','2017-01-13','王','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1007',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201701135679','123456','1001','2017-01-13','2017-01-13','2017-01-13','司马','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1008',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201701135607','123456','1001','2017-01-13','2017-01-13','2017-01-13','欧阳','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1009',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201701135617','123456','1001','2017-01-13','2017-01-13','2017-01-13','找一','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1010',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201701135627','123456','1001','2017-01-13','2017-01-13','2017-01-13','赵四','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1001',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201701135637','123456','1001','2017-01-13','2017-01-13','2017-01-13','六五','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1006',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201701135647','123456','1001','2017-01-13','2017-01-13','2017-01-13','七八','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1001',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201701135657','123456','1001','2017-01-13','2017-01-13','2017-01-13','三二一','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1002',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201701135667','123456','1001','2017-01-13','2017-01-13','2017-01-13','王佳','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1003',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201701135687','123456','1001','2017-01-13','2017-01-13','2017-01-13','刘青','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1001',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201701135697','123456','1001','2017-01-13','2017-01-13','2017-01-13','叶凡','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1002',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201701135077','123456','1001','2017-01-13','2017-01-13','2017-01-13','昊天','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1003',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201701135177','123456','1001','2017-01-13','2017-01-13','2017-01-13','孙悟空','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1003',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201701135277','123456','1001','2017-01-13','2017-01-13','2017-01-13','猪八戒','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1003',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201701135377','123456','1001','2017-01-13','2017-01-13','2017-01-13','李逵','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1003',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201701135477','123456','1001','2017-01-13','2017-01-13','2017-01-13','松江','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1004',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201701135577','123456','1001','2017-01-13','2017-01-13','2017-01-13','宋江','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1004',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201701135777','123456','1001','2017-01-13','2017-01-13','2017-01-13','罗贯中','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1004',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201701135877','123456','1001','2017-01-13','2017-01-13','2017-01-13','王一','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1004',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201701135977','123456','1001','2017-01-13','2017-01-13','2017-01-13','李世民','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1004',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201701100677','123456','1001','2017-01-13','2017-01-13','2017-01-13','努尔哈赤','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1005',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201701131677','123456','1001','2017-01-13','2017-01-13','2017-01-13','皇太极','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1005',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201701132677','123456','1001','2017-01-13','2017-01-13','2017-01-13','康熙皇帝','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1005',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201701133677','123456','1001','2017-01-13','2017-01-13','2017-01-13','刘莉莉','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1006',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201701134677','123456','1001','2017-01-13','2017-01-13','2017-01-13','张国荣','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1006',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201701136677','123456','1001','2017-01-13','2017-01-13','2017-01-13','刘德华','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1006',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201701137677','123456','1001','2017-01-13','2017-01-13','2017-01-13','章子怡','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1006',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201701138677','123456','1001','2017-01-13','2017-01-13','2017-01-13','刘若英','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1007',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201701139677','123456','1001','2017-01-13','2017-01-13','2017-01-13','各有','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1007',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201771135677','123456','1001','2017-01-13','2017-01-13','2017-01-13','葛优','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1007',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201781135677','123456','1001','2017-01-13','2017-01-13','2017-01-13','胖子','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1007',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201791135677','123456','1001','2017-01-13','2017-01-13','2017-01-13','瘦子','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1008',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201761135677','123456','1001','2017-01-13','2017-01-13','2017-01-13','刘','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1008',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201751135677','123456','1001','2017-01-13','2017-01-13','2017-01-13','航航','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1008',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201741135677','123456','1001','2017-01-13','2017-01-13','2017-01-13','张国','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1009',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201711135677','123456','1001','2017-01-13','2017-01-13','2017-01-13','王两','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1009',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201721135677','123456','1001','2017-01-13','2017-01-13','2017-01-13','老虎','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1009',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('201731135677','123456','1001','2017-01-13','2017-01-13','2017-01-13','狮子','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1009',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('401701135677','123456','1001','2017-01-13','2017-01-13','2017-01-13','刘','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1011',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('501701135677','123456','1001','2017-01-13','2017-01-13','2017-01-13','王三','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1011',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('601701135677','123456','1001','2017-01-13','2017-01-13','2017-01-13','赵三','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1011',0,'1201')
insert into Users
(UsersId,UserPassword,OnlineState,CreateTime,ModifyTime,LastLogin,TrueName,IdCard,DocSex,DocBirthday,TelePhone,OnjobState,Email,DepId,IsSpecialist,Duty)
values('701701135677','123456','1001','2017-01-13','2017-01-13','2017-01-13','张三','410325188302234523','001','1883-02-23','13838838438','301','123456@163.com','1011',0,'1201')
--修改用户
update users set OnlineState = 1002

--添加患者
insert into Patient (PatPassword,PatName,PatCard,PatSex,PatBirthday,PatPhone,PatAddress,PatSymotoms,GeneticDisorders,OnlineState,CreateTime,ModifyTime,LastLogin)
values('123456','北大青鸟','410325199601035689','001','1996-01-03','1369632356','河南洛阳','花粉','精神病','1001','2017-01-03','2017-01-03','2017-05-03')
insert into Patient (PatPassword,PatName,PatCard,PatSex,PatBirthday,PatPhone,PatAddress,PatSymotoms,GeneticDisorders,OnlineState,CreateTime,ModifyTime,LastLogin)
values('123456','bdqn','410325199601035689','001','1996-01-03','1369632356','河南洛阳','花粉','精神病','1001','2017-01-03','2017-01-03','2017-05-03')

insert into Patient (PatPassword,PatName,PatCard,PatSex,PatBirthday,PatPhone,PatAddress,PatSymotoms,GeneticDisorders,OnlineState,CreateTime,ModifyTime,LastLogin)
values('123456','豪豪','410325199601035689','001','1996-01-03','1369632356','河南洛阳','花粉','精神病','1001','2017-01-03','2017-01-03','2017-05-03')

insert into Patient (PatPassword,PatName,PatCard,PatSex,PatBirthday,PatPhone,PatAddress,PatSymotoms,GeneticDisorders,OnlineState,CreateTime,ModifyTime,LastLogin)
values('123456','123','410325199601035689','001','1996-01-03','1369632356','河南洛阳','花粉','精神病','1001','2017-01-03','2017-01-03','2017-05-03')
--修改患者状态
update patient set OnlineState = 1002

--添加测试挂号信息
insert into Registered ( RegId,PatId,AppointmentTime,RegTime,DepId,UsersId,RegType,RegPrice,PayState,RegState,IsPay ) values
( '201701051203561001','1001',null,'2017-05-16','1001','201701133677','401',5,0,'501',0 )
insert into Registered ( RegId,PatId,AppointmentTime,RegTime,DepId,UsersId,RegType,RegPrice,PayState,RegState,IsPay ) values
( '201706051203561002','1002',null,'2017-05-16','1002','201701131677','401',5,0,'501',0 )
insert into Registered ( RegId,PatId,AppointmentTime,RegTime,DepId,UsersId,RegType,RegPrice,PayState,RegState,IsPay ) values
( '201705051203561003','1003',null,'2017-05-16','1003','201701132677','401',5,0,'501',0 )
insert into Registered ( RegId,PatId,AppointmentTime,RegTime,DepId,UsersId,RegType,RegPrice,PayState,RegState,IsPay ) values
( '201704051203561001','1001',null,'2017-05-16','1004','201701134677','401',5,0,'501',0 )
insert into Registered ( RegId,PatId,AppointmentTime,RegTime,DepId,UsersId,RegType,RegPrice,PayState,RegState,IsPay ) values
( '201703051203561002','1002',null,'2017-05-16','1005','201701135077','401',5,0,'501',0 )
insert into Registered ( RegId,PatId,AppointmentTime,RegTime,DepId,UsersId,RegType,RegPrice,PayState,RegState,IsPay ) values
( '201702051203561003','1003',null,'2017-05-16','1006','201701135177','401',5,0,'501',0 )

--添加角色信息
insert into Roles (RoleName,CreateTime,ModifyTime,Enableds)
values('101','2017-05-22','2017-05-22','1')
insert into Roles (RoleName,CreateTime,ModifyTime,Enableds)
values('102','2017-05-22','2017-05-22','1')
insert into Roles (RoleName,CreateTime,ModifyTime,Enableds)
values('103','2017-05-22','2017-05-22','1')
insert into Roles (RoleName,CreateTime,ModifyTime,Enableds)
values('104','2017-05-22','2017-05-22','1')
insert into Roles (RoleName,CreateTime,ModifyTime,Enableds)
values('105','2017-05-22','2017-05-22','1')
insert into Roles (RoleName,CreateTime,ModifyTime,Enableds)
values('106','2017-05-22','2017-05-22','1')
insert into Roles (RoleName,CreateTime,ModifyTime,Enableds)
values('107','2017-05-22','2017-05-22','1')
insert into Roles (RoleName,CreateTime,ModifyTime,Enableds)
values('108','2017-05-22','2017-05-22','1')


insert into Privilege (PriName,ParentId,Memo,MenuPic,MenuUrl,DisplayOrder,CreateTime,ModifyTime,Enableds)
values('就诊',null,'无','icon-heart','doctoroffer.jsp','1','2017-05-22','2017-05-22',1)
insert into Privilege (PriName,ParentId,Memo,MenuPic,MenuUrl,DisplayOrder,CreateTime,ModifyTime,Enableds)
values('收费',null,'无','icon-th-list','tool.jsp','1','2017-05-22','2017-05-22',1)
insert into Privilege (PriName,ParentId,Memo,MenuPic,MenuUrl,DisplayOrder,CreateTime,ModifyTime,Enableds)
values('取药',null,'无','icon-align-justify','checked_medicine.jsp','1','2017-05-22','2017-05-22',1)

insert into Privilege (PriName,ParentId,Memo,MenuPic,MenuUrl,DisplayOrder,CreateTime,ModifyTime,Enableds)
values('用户管理',null,'无','icon-user','user.jsp','1','2017-05-22','2017-05-22',1)

insert into Privilege (PriName,ParentId,Memo,MenuPic,MenuUrl,DisplayOrder,CreateTime,ModifyTime,Enableds)
values('我的信息',null,'无','icon-adjust','url','1','2017-05-22','2017-05-22',1)

insert into Privilege (PriName,ParentId,Memo,MenuPic,MenuUrl,DisplayOrder,CreateTime,ModifyTime,Enableds)
values('患者管理',null,'无','icon-user','patient.jsp','1','2017-05-22','2017-05-22',1)

insert into Privilege (PriName,ParentId,Memo,MenuPic,MenuUrl,DisplayOrder,CreateTime,ModifyTime,Enableds)
values('数据字典维护',null,'无','icon-th','dictionary.jsp','1','2017-05-22','2017-05-22',1)

insert into Privilege (PriName,ParentId,Memo,MenuPic,MenuUrl,DisplayOrder,CreateTime,ModifyTime,Enableds)
values('角色管理',null,'无','icon-tags','role.jsp','1','2017-05-22','2017-05-22',1)
insert into Privilege (PriName,ParentId,Memo,MenuPic,MenuUrl,DisplayOrder,CreateTime,ModifyTime,Enableds)
values('权限管理',null,'无','icon-lock','authority.jsp','1','2017-05-22','2017-05-22',1)
insert into Privilege (PriName,ParentId,Memo,MenuPic,MenuUrl,DisplayOrder,CreateTime,ModifyTime,Enableds)
values('科室管理',null,'无','icon-align-justify','department.jsp','1','2017-05-22','2017-05-22',1)

insert into Privilege (PriName,ParentId,Memo,MenuPic,MenuUrl,DisplayOrder,CreateTime,ModifyTime,Enableds)
values('药品管理',null,'无','icon-map-marker','drug.jsp','1','2017-05-22','2017-05-22',1)

insert into Privilege (PriName,ParentId,Memo,MenuPic,MenuUrl,DisplayOrder,CreateTime,ModifyTime,Enableds)
values('药品入库',null,'无','icon-map-marker','drugruku.jsp','1','2017-05-22','2017-05-22',1)

insert into Privilege (PriName,ParentId,Memo,MenuPic,MenuUrl,DisplayOrder,CreateTime,ModifyTime,Enableds)
values('报表管理',null,'无','icon-list-alt','report.jsp','1','2017-05-22','2017-05-22',1)

insert into Privilege (PriName,ParentId,Memo,MenuPic,MenuUrl,DisplayOrder,CreateTime,ModifyTime,Enableds)
values('提交报表',null,'无','icon-list-alt','url','1','2017-05-22','2017-05-22',1)
insert into Privilege (PriName,ParentId,Memo,MenuPic,MenuUrl,DisplayOrder,CreateTime,ModifyTime,Enableds)
values('查阅报表',null,'无','icon-list-alt','url','1','2017-05-22','2017-05-22',1)

insert into Privilege (PriName,ParentId,Memo,MenuPic,MenuUrl,DisplayOrder,CreateTime,ModifyTime,Enableds)
values('新闻管理',null,'无','icon-globe','NewsManage.jsp','1','2017-05-22','2017-05-22',1)

insert into Privilege (PriName,ParentId,Memo,MenuPic,MenuUrl,DisplayOrder,CreateTime,ModifyTime,Enableds)
values('固定处方管理',null,'无','icon-book','url','1','2017-05-22','2017-05-22',1)

insert into Privilege (PriName,ParentId,Memo,MenuPic,MenuUrl,DisplayOrder,CreateTime,ModifyTime,Enableds)
values('科室员工管理',1003,'无','icon-user','url','2','2017-05-22','2017-05-22',1)

insert into Privilege (PriName,ParentId,Memo,MenuPic,MenuUrl,DisplayOrder,CreateTime,ModifyTime,Enableds)
values('查看所有药品',1010,'无','icon-map-marker','url','2','2017-05-22','2017-05-22',1)

insert into Privilege (PriName,ParentId,Memo,MenuPic,MenuUrl,DisplayOrder,CreateTime,ModifyTime,Enableds)
values('查看就诊信息',null,'无','icon-align-left','url','1','2017-05-22','2017-05-22',1)

insert into Privilege (PriName,ParentId,Memo,MenuPic,MenuUrl,DisplayOrder,CreateTime,ModifyTime,Enableds)
values('查看固定处方',null,'无','img','icon-book','1','2017-05-22','2017-05-22',1)

--给用户绑定角色
insert into UserRole (UserId,RoleId) values('201701131677','1000')
insert into UserRole (UserId,RoleId) values('201701131677','1007')

--角色绑定权限
--超级管理员
insert into RolePrivilege (RoleId,PriId) values( '1000','1003' )
insert into RolePrivilege (RoleId,PriId) values( '1000','1005' )
insert into RolePrivilege (RoleId,PriId) values( '1000','1006' )
insert into RolePrivilege (RoleId,PriId) values( '1000','1007' )
insert into RolePrivilege (RoleId,PriId) values( '1000','1008' )
insert into RolePrivilege (RoleId,PriId) values( '1000','1009' )
insert into RolePrivilege (RoleId,PriId) values( '1000','1010' )
insert into RolePrivilege (RoleId,PriId) values( '1000','1011' )
insert into RolePrivilege (RoleId,PriId) values( '1000','1012' )
insert into RolePrivilege (RoleId,PriId) values( '1000','1015' )
insert into RolePrivilege (RoleId,PriId) values( '1000','1016' )
--管理员
insert into RolePrivilege (RoleId,PriId) values( '1001','1003' )
insert into RolePrivilege (RoleId,PriId) values( '1001','1005' )
insert into RolePrivilege (RoleId,PriId) values( '1001','1007' )
insert into RolePrivilege (RoleId,PriId) values( '1001','1008' )
insert into RolePrivilege (RoleId,PriId) values( '1001','1009' )
insert into RolePrivilege (RoleId,PriId) values( '1001','1010' )
insert into RolePrivilege (RoleId,PriId) values( '1001','1011' )
insert into RolePrivilege (RoleId,PriId) values( '1001','1012' )
insert into RolePrivilege (RoleId,PriId) values( '1001','1015' )
insert into RolePrivilege (RoleId,PriId) values( '1001','1016' )
--院长
insert into RolePrivilege (RoleId,PriId) values( '1002','1003' )
insert into RolePrivilege (RoleId,PriId) values( '1002','1005' )
insert into RolePrivilege (RoleId,PriId) values( '1002','1009' )
insert into RolePrivilege (RoleId,PriId) values( '1002','1010' )
insert into RolePrivilege (RoleId,PriId) values( '1002','1012' )
insert into RolePrivilege (RoleId,PriId) values( '1002','1014' )
insert into RolePrivilege (RoleId,PriId) values( '1002','1015' )
--科室主任
insert into RolePrivilege (RoleId,PriId) values( '1003','1010' )
insert into RolePrivilege (RoleId,PriId) values( '1003','1013' )
insert into RolePrivilege (RoleId,PriId) values( '1003','1014' )
insert into RolePrivilege (RoleId,PriId) values( '1003','1015' )
insert into RolePrivilege (RoleId,PriId) values( '1003','1017' )
insert into RolePrivilege (RoleId,PriId) values( '1003','1016' )
--医生
insert into RolePrivilege (RoleId,PriId) values( '1004','1000' )
insert into RolePrivilege (RoleId,PriId) values( '1004','1013' )
insert into RolePrivilege (RoleId,PriId) values( '1004','1020' )
insert into RolePrivilege (RoleId,PriId) values( '1004','1019' )
insert into RolePrivilege (RoleId,PriId) values( '1004','1018' )
--药房管理
insert into RolePrivilege (RoleId,PriId) values( '1005','1002' )
insert into RolePrivilege (RoleId,PriId) values( '1005','1010' )
insert into RolePrivilege (RoleId,PriId) values( '1005','1011' )
--收费管理
insert into RolePrivilege (RoleId,PriId) values( '1006','1001' )
--员工
insert into RolePrivilege (RoleId,PriId) values( '1007','1004' )