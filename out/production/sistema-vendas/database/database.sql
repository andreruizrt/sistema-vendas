BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "PESSOA_TR01" (
	"ID"	INTEGER NOT NULL,
	"NOME"	VARCHAR(250) NOT NULL,
	"CPFCNPJ"	VARCHAR(20) NOT NULL,
	"EMAIL"	TEXT NOT NULL,
	"TELEFONE"	VARCHAR(20) NOT NULL,
	"RUA"	VARCHAR(250) NOT NULL,
	"NUMERO"	VARCHAR(20) NOT NULL,
	"COMPLEMENTO"	VARCHAR(250) NOT NULL,
	"BAIRRO"	VARCHAR(250) NOT NULL,
	"CIDADE"	VARCHAR(250) NOT NULL,
	"UF"	VARCHAR(2) NOT NULL,
	"TIPO"	VARCHAR(1) NOT NULL,
	PRIMARY KEY("ID" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "USUARIO_TR01" (
	"ID"	INTEGER NOT NULL,
	"USUARIO"	VARCHAR(250) NOT NULL,
	"SENHA"	VARCHAR(250) NOT NULL,
	"IDVENDEDOR"	INTEGER NOT NULL,
	PRIMARY KEY("ID" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "COMPRA_TR01" (
	"ID"	INTEGER NOT NULL,
	"IDFORNECEDOR"	INTEGER NOT NULL,
	"DTCOMPRA"	TIMESTAMP NOT NULL,
	PRIMARY KEY("ID" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "PRODUTO_TR01" (
	"ID"	INTEGER NOT NULL,
	"DESCRICAO"	VARCHAR(250) NOT NULL,
	"CODIGOBARRAS"	VARCHAR(13) NOT NULL,
	"FABRICANTE"	VARCHAR(250) NOT NULL,
	"QTDESTOQUE"	INTEGER NOT NULL,
	"PRECO"	DECIMAL(15, 2) NOT NULL,
	PRIMARY KEY("ID" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "ITEM_COMPRA_TR01" (
	"IDCOMPRA"	INTEGER NOT NULL,
	"IDPRODUTO"	INTEGER NOT NULL,
	"QTDPRODUTO"	INTEGER NOT NULL,
	PRIMARY KEY("IDCOMPRA")
);
CREATE TABLE IF NOT EXISTS "VENDA_TR01" (
	"ID"	INTEGER NOT NULL,
	"IDCLIENTE"	INTEGER NOT NULL,
	"IDVENDEDOR"	INTEGER NOT NULL,
	"DTVENDA"	TIMESTAMP NOT NULL,
	PRIMARY KEY("ID")
);
CREATE TABLE IF NOT EXISTS "ITEM_VENDA_TR01" (
	"IDVENDA"	INTEGER NOT NULL,
	"IDPRODUTO"	INTEGER,
	"QTDPRODUTO"	INTEGER
);
INSERT INTO "PESSOA_TR01" VALUES (1,'Masha','239.454.343-00','mmaha0@ft.com','(024) 96899-0854','Miller','210','Plaza','Morning','Devesa','DI','C');
INSERT INTO "PESSOA_TR01" VALUES (2,'Darcey','120.212.494-41','ddelasalle1@cisco.com','(017) 90388-4162','Valley Edge','996','Hill','Merchant','Boticas','CM','F');
INSERT INTO "PESSOA_TR01" VALUES (3,'Elnora','210.878.925-18','egoskar2@census.gov','(014) 93595-0469','Buell','311','Way','Prairie Rose','Henglian','TV','F');
INSERT INTO "PESSOA_TR01" VALUES (4,'Bill','287.034.147-53','bnunson3@ebay.co.uk','(068) 90365-3746','Kingsford','560','Point','Russell','Oekefan','KF','C');
INSERT INTO "PESSOA_TR01" VALUES (5,'Karena','084.788.839-64','kbartzen4@imgur.com','(000) 93855-3923','Warbler','368','Parkway','Pearson','Garland','BH','V');
INSERT INTO "PESSOA_TR01" VALUES (6,'Camey','654.877.531-20','cyegorev5@hao123.com','(052) 96041-6029','Longview','587','Street','Eagan','Watari','CZ','C');
INSERT INTO "PESSOA_TR01" VALUES (7,'Emmalee','027.683.198-81','egerssam6@youtu.be','(096) 98270-2592','Holmberg','528','Way','Packers','Xianyang','HH','V');
INSERT INTO "PESSOA_TR01" VALUES (8,'Kirby','730.785.834-80','kdymond7@ask.com','(049) 95202-4820','Park Meadow','187','Point','Pankratz','Agnibilékrou','EC','F');
INSERT INTO "PESSOA_TR01" VALUES (9,'Marisa','500.416.251-14','mloeber8@vkontakte.ru','(086) 97170-4112','Grayhawk','312','Pass','Miller','Shuangzhu','EN','F');
INSERT INTO "PESSOA_TR01" VALUES (10,'Joseito','076.402.713-27','jricarde9@hibu.com','(076) 92033-8616','Charing Cross','575','Point','East','Labuan','NZ','C');
INSERT INTO "PESSOA_TR01" VALUES (11,'Sileas','545.361.834-34','sbriscoea@tripadvisor.com','(067) 95049-9393','Mifflin','117','Point','David','Quixeramobim','VV','C');
INSERT INTO "PESSOA_TR01" VALUES (12,'Bale','157.582.439-52','blawlieb@hubpages.com','(043) 90407-7245','Rockefeller','501','Way','Anhalt','Carregado','KX','F');
INSERT INTO "PESSOA_TR01" VALUES (13,'Rorke','072.351.422-98','rhayesc@about.me','(094) 93186-3696','Corscot','232','Alley','Sommers','Penhold','VN','V');
INSERT INTO "PESSOA_TR01" VALUES (14,'Annnora','735.538.206-22','ahallibertond@earthlink.net','(008) 94259-9510','Prairieview','733','Hill','Sugar','Trikora','UP','C');
INSERT INTO "PESSOA_TR01" VALUES (15,'Carlyn','041.825.573-35','ccoveleye@51.la','(047) 99490-7284','Columbus','680','Parkway','Sauthoff','Huacheng','HD','V');
INSERT INTO "PESSOA_TR01" VALUES (16,'Gasper','432.767.253-55','gsaywellf@artisteer.com','(025) 95434-8027','Killdeer','402','Center','Independence','Aoji-ri','EI','C');
INSERT INTO "PESSOA_TR01" VALUES (17,'Bjorn','575.619.934-51','bguidonig@soundcloud.com','(055) 96701-4155','Dahle','955','Pass','Luster','Si That','QZ','C');
INSERT INTO "PESSOA_TR01" VALUES (18,'Rosette','836.065.651-72','rmatish@msn.com','(069) 90640-6943','Manitowish','476','Parkway','Orin','Duantan','SN','V');
INSERT INTO "PESSOA_TR01" VALUES (19,'Prent','050.296.913-20','pinchi@statcounter.com','(028) 91075-9272','Dakota','704','Center','Ridgeway','Osiek nad Notecią','EK','V');
INSERT INTO "PESSOA_TR01" VALUES (20,'Dorothea','867.262.315-78','dgoodburj@archive.org','(053) 99872-5795','Pennsylvania','328','Point','Linden','Al Muharraq','IZ','V');
INSERT INTO "PESSOA_TR01" VALUES (21,'Rosalind','391.434.899-94','rhousonk@reuters.com','(068) 96532-3252','Anthes','192','Lane','Del Mar','Sayán','RT','V');
INSERT INTO "PESSOA_TR01" VALUES (22,'Tully','837.889.574-19','tgraingel@arizona.edu','(077) 96158-3743','Namekagon','255','Pass','Corry','Na''ale','NV','V');
INSERT INTO "PESSOA_TR01" VALUES (23,'Jacklyn','362.494.537-44','jfenelonm@google.de','(066) 96618-4130','Hanson','936','Hill','Gerald','Sukamaju','RB','V');
INSERT INTO "PESSOA_TR01" VALUES (24,'Melony','245.460.262-56','mcatteln@spotify.com','(099) 98865-2757','Fairview','549','Terrace','Ilene','Tashkent','AX','F');
INSERT INTO "PESSOA_TR01" VALUES (25,'Nonah','371.230.876-94','nknutseno@scribd.com','(045) 92475-4631','Dakota','703','Parkway','Brown','Baochang','IO','V');
INSERT INTO "PESSOA_TR01" VALUES (26,'Sadye','066.219.779-91','smichep@surveymonkey.com','(081) 97475-3934','Sunnyside','144','Alley','Michigan','Lagodekhi','QL','V');
INSERT INTO "PESSOA_TR01" VALUES (27,'Jud','670.780.946-17','jdooherq@etsy.com','(055) 93564-3581','Bowman','430','Pass','Esch','Tosu','ZP','F');
INSERT INTO "PESSOA_TR01" VALUES (28,'Aguie','927.546.875-68','amathanr@wired.com','(092) 91463-9078','Daystar','832','Plaza','Maywood','Daying','HW','F');
INSERT INTO "PESSOA_TR01" VALUES (29,'Silas','076.501.004-67','scoxwells@usgs.gov','(042) 90351-7573','Jay','663','Pass','Vahlen','Shabqadar','AJ','C');
INSERT INTO "PESSOA_TR01" VALUES (30,'Elsworth','880.203.677-72','edominect@yellowbook.com','(031) 95122-8197','Sloan','612','Point','Morrow','Weitian','GP','C');
INSERT INTO "PESSOA_TR01" VALUES (31,'Marisa','764.984.023-95','mkenyamu@spotify.com','(004) 93856-3431','Lukken','873','Road','Troy','Tariji','PX','V');
INSERT INTO "PESSOA_TR01" VALUES (32,'Hedi','032.441.226-06','hescoffierv@forbes.com','(041) 98058-5239','Pond','693','Plaza','Mandrake','Täby','WR','V');
INSERT INTO "PESSOA_TR01" VALUES (33,'Gale','355.926.746-32','grichensw@quantcast.com','(066) 99404-7080','Derek','950','Crossing','Doe Crossing','Villa Urquiza','GV','C');
INSERT INTO "PESSOA_TR01" VALUES (34,'Celestine','652.575.184-55','ckinderx@google.it','(086) 94592-9303','Debs','250','Lane','Banding','Nantang','ZX','C');
INSERT INTO "PESSOA_TR01" VALUES (35,'Neile','024.911.529-09','nreinhardty@ycombinator.com','(046) 96784-6320','Mallard','956','Road','Northwestern','Lužani','BK','F');
INSERT INTO "PESSOA_TR01" VALUES (36,'Dorris','663.038.898-26','dallanbyz@yahoo.com','(036) 98992-1601','Hauk','873','Road','Cordelia','Konkwesso','VT','V');
INSERT INTO "PESSOA_TR01" VALUES (37,'Carin','177.616.540-55','crosenboim10@ustream.tv','(009) 90040-6678','Farragut','833','Avenue','Fuller','Grammatikó','NP','C');
INSERT INTO "PESSOA_TR01" VALUES (38,'Burnard','124.749.033-63','bvasiltsov11@amazon.co.jp','(073) 98888-6569','Tennessee','534','Terrace','Sauthoff','Meylan','CW','V');
INSERT INTO "PESSOA_TR01" VALUES (39,'Kaila','208.563.917-01','kfairhead12@npr.org','(093) 93158-3582','Veith','944','Avenue','Dexter','Tras Cerros','HQ','V');
INSERT INTO "PESSOA_TR01" VALUES (40,'Oona','537.935.955-56','obuston13@huffingtonpost.com','(061) 99354-2573','Spohn','499','Avenue','Fremont','Ballisodare','AN','F');
INSERT INTO "PESSOA_TR01" VALUES (41,'Darn','575.516.081-71','dconahy14@amazon.de','(097) 91476-9006','Randy','178','Circle','Lakeland','Santiago','ZJ','C');
INSERT INTO "PESSOA_TR01" VALUES (42,'Dania','342.847.772-55','ddowney15@howstuffworks.com','(061) 95797-9683','High Crossing','541','Alley','Quincy','Kanye','IH','F');
INSERT INTO "PESSOA_TR01" VALUES (43,'Nolana','428.063.349-19','narnau16@scientificamerican.com','(049) 94311-4546','Larry','944','Trail','Shoshone','Santana de Parnaíba','NC','V');
INSERT INTO "PESSOA_TR01" VALUES (44,'Jasper','803.931.137-04','jlugton17@npr.org','(024) 96721-5082','Coolidge','683','Way','Barnett','Jiuhe','OZ','C');
INSERT INTO "PESSOA_TR01" VALUES (45,'Robenia','927.197.319-33','rcianelli18@sfgate.com','(003) 92338-6234','Norway Maple','366','Avenue','Sunbrook','Raymond','VY','F');
INSERT INTO "PESSOA_TR01" VALUES (46,'Shea','687.693.260-50','smuffett19@netscape.com','(080) 90445-4746','Colorado','454','Lane','Acker','Dalamdesa Kalapadua','PH','C');
INSERT INTO "PESSOA_TR01" VALUES (47,'Lynnell','264.437.517-41','lfrogley1a@wsj.com','(042) 96161-5961','Golf View','763','Terrace','Moulton','Kobyzhcha','OB','V');
INSERT INTO "PESSOA_TR01" VALUES (48,'Beatrice','881.073.927-84','brappoport1b@blogspot.com','(059) 96949-4919','Magdeline','423','Crossing','Meadow Valley','San Agustin','VV','F');
INSERT INTO "PESSOA_TR01" VALUES (49,'Ricki','938.838.123-08','rcasaccia1c@github.com','(033) 91254-4660','Havey','626','Place','Esch','La Huerta','KC','F');
INSERT INTO "PESSOA_TR01" VALUES (50,'Irving','402.413.868-44','igonsalvo1d@gizmodo.com','(093) 97180-5641','Sundown','256','Place','Pleasure','Irará','EQ','V');
INSERT INTO "PESSOA_TR01" VALUES (51,'Jane','030.544.020-67','jmcglaud1e@tiny.cc','(030) 95114-4343','Monica','776','Place','7th','Sanok','WH','F');
INSERT INTO "PESSOA_TR01" VALUES (52,'Riannon','747.470.709-72','rcastana1f@un.org','(095) 92630-8988','Nelson','654','Road','Fordem','Neni','SJ','F');
INSERT INTO "PESSOA_TR01" VALUES (53,'Stevena','284.519.971-56','stomasik1g@bloglines.com','(031) 93682-6419','Commercial','607','Street','Buhler','Huolianpo','OE','V');
INSERT INTO "PESSOA_TR01" VALUES (54,'Krystyna','240.460.078-61','kcrewther1h@aol.com','(019) 96405-5552','Vernon','445','Park','Derek','Yukhnov','KV','V');
INSERT INTO "PESSOA_TR01" VALUES (55,'Niki','368.821.019-25','nstrank1i@cnet.com','(063) 93363-9917','Kropf','871','Way','Forest Run','Norfolk County','QP','C');
INSERT INTO "PESSOA_TR01" VALUES (56,'Lutero','792.248.505-61','ldyne1j@omniture.com','(091) 93411-5153','Northview','301','Plaza','Brickson Park','Beitai','BI','C');
INSERT INTO "PESSOA_TR01" VALUES (57,'Justinn','881.509.155-22','jkeats1k@gov.uk','(051) 98408-0710','Lawn','788','Hill','Carberry','Cimonyong','NY','C');
INSERT INTO "PESSOA_TR01" VALUES (58,'Hillyer','911.859.877-95','hboig1l@msn.com','(016) 97767-5494','Milwaukee','515','Crossing','Eagan','Banjar Kajanan','YV','V');
INSERT INTO "PESSOA_TR01" VALUES (59,'Camala','001.538.314-52','cvan1m@yahoo.com','(065) 95660-3995','Saint Paul','463','Park','Cardinal','Oleiros','NE','F');
INSERT INTO "PESSOA_TR01" VALUES (60,'Moyna','590.079.638-74','mvause1n@technorati.com','(055) 99320-1008','5th','201','Road','Ronald Regan','Ash Shawātī','VM','V');
INSERT INTO "PESSOA_TR01" VALUES (61,'Emmalee','377.901.423-11','emabbe1o@xing.com','(059) 96710-9851','Warrior','142','Center','Westend','Bodø','WS','C');
INSERT INTO "PESSOA_TR01" VALUES (62,'Kiley','241.925.795-32','kflaune1p@wordpress.com','(085) 94431-3620','Myrtle','400','Place','Iowa','Inglewood','RT','C');
INSERT INTO "PESSOA_TR01" VALUES (63,'Anna','077.888.760-84','amanjot1q@skyrock.com','(043) 91691-3138','Summer Ridge','112','Plaza','Debs','Yashiro','SR','V');
INSERT INTO "PESSOA_TR01" VALUES (64,'Guillaume','448.516.187-83','gavrahamian1r@mashable.com','(014) 98714-5262','Southridge','146','Center','Dryden','Lafia','ZA','C');
INSERT INTO "PESSOA_TR01" VALUES (65,'Lari','719.023.486-96','lstickford1s@alexa.com','(041) 95376-3363','Redwing','796','Lane','Weeping Birch','Bolhos','FH','F');
INSERT INTO "PESSOA_TR01" VALUES (66,'Faunie','096.070.803-35','fpaolucci1t@nature.com','(085) 95924-7399','Holmberg','671','Parkway','Victoria','Frashër','HP','C');
INSERT INTO "PESSOA_TR01" VALUES (67,'Stanwood','203.210.799-75','salty1u@over-blog.com','(070) 92996-2265','Claremont','774','Point','Village Green','Sambirobyong','US','F');
INSERT INTO "PESSOA_TR01" VALUES (68,'Nananne','156.786.061-43','ngallimore1v@sohu.com','(039) 93891-2173','Buell','743','Alley','Darwin','Ilyich','DG','V');
INSERT INTO "PESSOA_TR01" VALUES (69,'Jere','007.053.672-34','jcaulcott1w@illinois.edu','(012) 98488-3664','Hagan','575','Way','8th','Dongqianhu','ZA','C');
INSERT INTO "PESSOA_TR01" VALUES (70,'Alanson','146.552.845-93','abolin1x@comsenz.com','(050) 99044-0050','Milwaukee','841','Point','Bobwhite','Kamojimachō-jōgejima','LW','F');
INSERT INTO "PESSOA_TR01" VALUES (71,'Udell','984.180.804-30','usummerside1y@latimes.com','(036) 92409-8555','Sycamore','299','Center','Meadow Valley','Mercaderes','UP','C');
INSERT INTO "PESSOA_TR01" VALUES (72,'Abelard','305.414.655-07','aroskrug1z@cyberchimps.com','(068) 95544-4976','Prentice','689','Avenue','Rigney','Xingxi','FV','F');
INSERT INTO "PESSOA_TR01" VALUES (73,'Hanny','551.622.099-84','hawin20@rediff.com','(062) 96838-6992','Arkansas','371','Way','Kipling','Luhanka','MD','V');
INSERT INTO "PESSOA_TR01" VALUES (74,'Meggi','299.275.839-85','mwestcar21@hp.com','(073) 97361-8430','Charing Cross','674','Park','Larry','Sovetsk','JK','V');
INSERT INTO "PESSOA_TR01" VALUES (75,'Cole','823.767.882-01','chuster22@cornell.edu','(085) 91680-6001','Village Green','158','Plaza','Bellgrove','Chalan Pago-Ordot Village','MB','C');
INSERT INTO "PESSOA_TR01" VALUES (76,'Avram','332.041.841-65','afinch23@vk.com','(031) 92080-1458','Artisan','213','Circle','Pearson','Rio das Pedras','XO','F');
INSERT INTO "PESSOA_TR01" VALUES (77,'Tammie','152.647.464-10','tcuesta24@marketwatch.com','(051) 94941-3493','1st','386','Parkway','Elka','Lingyuan','XJ','C');
INSERT INTO "PESSOA_TR01" VALUES (78,'Daniele','070.328.532-15','dbowdrey25@imgur.com','(069) 98446-3871','Quincy','369','Circle','Sullivan','Cape Town','UQ','C');
INSERT INTO "PESSOA_TR01" VALUES (79,'Harmonia','620.843.396-32','hoblein26@usa.gov','(042) 97369-2897','Paget','561','Center','Burning Wood','Arani','QM','V');
INSERT INTO "PESSOA_TR01" VALUES (80,'Catlin','366.475.353-47','cgratrex27@mozilla.com','(071) 99374-5028','Cardinal','623','Crossing','Loftsgordon','Sumberejo','SW','F');
INSERT INTO "PESSOA_TR01" VALUES (81,'Gisele','760.199.187-79','geby28@cnn.com','(041) 96407-0561','Colorado','897','Hill','Colorado','Kotabumi','YF','C');
INSERT INTO "PESSOA_TR01" VALUES (82,'Carole','500.510.695-27','cmathen29@blogtalkradio.com','(095) 98862-0335','Aberg','822','Hill','Eastlawn','Juncalito Abajo','CR','C');
INSERT INTO "PESSOA_TR01" VALUES (83,'Levon','008.226.254-49','ldownage2a@cnn.com','(042) 94709-8666','Golf Course','917','Drive','Grover','Birnin Kebbi','TZ','C');
INSERT INTO "PESSOA_TR01" VALUES (84,'Rowan','617.376.359-68','rpinckstone2b@paginegialle.it','(069) 97115-0819','Fordem','565','Circle','Duke','Malabor','EI','C');
INSERT INTO "PESSOA_TR01" VALUES (85,'Marylynne','929.821.203-08','mmasedon2c@plala.or.jp','(036) 92386-6600','Morningstar','791','Place','Mayfield','Zhenyuan','OC','F');
INSERT INTO "PESSOA_TR01" VALUES (86,'Vassily','323.891.566-55','vbircher2d@cbc.ca','(081) 97026-0812','Portage','481','Center','Schmedeman','Kavála','FV','C');
INSERT INTO "PESSOA_TR01" VALUES (87,'Lilian','555.351.086-98','lgantley2e@posterous.com','(042) 99304-4968','Portage','258','Place','Dakota','Gus’-Zheleznyy','PA','F');
INSERT INTO "PESSOA_TR01" VALUES (88,'Reggy','332.675.603-40','rgommes2f@1und1.de','(029) 99917-2366','Elmside','937','Place','Manley','Malakal','SS','C');
INSERT INTO "PESSOA_TR01" VALUES (89,'Lorinda','235.742.597-57','larnowicz2g@army.mil','(053) 92623-6298','Jana','680','Lane','Sutherland','Sandweiler','PG','C');
INSERT INTO "PESSOA_TR01" VALUES (90,'Garv','450.553.944-89','ghousbey2h@google.cn','(030) 91252-6170','Scofield','613','Avenue','Mariners Cove','Dongshangen','OT','C');
INSERT INTO "PESSOA_TR01" VALUES (91,'Sena','477.095.068-26','ssymington2i@vk.com','(006) 90277-9907','Fisk','822','Terrace','Bartelt','Laliki','QZ','C');
INSERT INTO "PESSOA_TR01" VALUES (92,'Joane','845.603.142-11','jpiggen2j@hibu.com','(083) 98040-1309','Norway Maple','846','Court','Corben','Louisville','ZY','C');
INSERT INTO "PESSOA_TR01" VALUES (93,'Donnamarie','379.310.739-38','dchasmoor2k@rediff.com','(065) 93803-7263','Prairie Rose','215','Parkway','Linden','Zambrów','MM','C');
INSERT INTO "PESSOA_TR01" VALUES (94,'Dorris','950.576.340-72','dtruter2l@jalbum.net','(030) 99422-7038','Leroy','556','Terrace','Vermont','Palmira','ZN','C');
INSERT INTO "PESSOA_TR01" VALUES (95,'Stearn','819.064.689-63','ssuermeier2m@cnn.com','(072) 97527-1062','Blackbird','783','Terrace','Kipling','Pampas Chico','TJ','F');
INSERT INTO "PESSOA_TR01" VALUES (96,'Orville','615.855.027-83','ojacks2n@prlog.org','(022) 90927-4373','Nelson','910','Drive','Loeprich','Nīkêh','RQ','F');
INSERT INTO "PESSOA_TR01" VALUES (97,'Viki','371.903.471-39','vwestberg2o@plala.or.jp','(009) 92760-0234','Little Fleur','556','Park','American','Svetlyy','QJ','F');
INSERT INTO "PESSOA_TR01" VALUES (98,'Sayre','733.266.643-59','sdecaville2p@yahoo.com','(043) 95547-9254','Moland','750','Pass','Lighthouse Bay','Magdalena','ME','F');
INSERT INTO "PESSOA_TR01" VALUES (99,'Isabeau','406.379.836-04','igarside2q@technorati.com','(001) 94911-7726','Forster','584','Pass','Sutteridge','Venustiano Carranza','TW','F');
INSERT INTO "PESSOA_TR01" VALUES (100,'Abbi','675.261.843-11','acharman2r@scribd.com','(099) 97791-3715','Buena Vista','997','Avenue','Erie','Seattle','GV','C');
COMMIT;
