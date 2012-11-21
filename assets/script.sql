drop table if exists android_metadata;
    
create table android_metadata (
	locale TEXT DEFAULT 'en_US'
);

insert into android_metadata values ('en_US');

-- AGENCY
drop table if exists agency;

create table agency (
  _id      integer primary key,
  name    text,
  label   text,
  address text,
  longitude double,
  latitude  double,
  phone     text
);

insert into agency values(0, "Rennes",  "SODIFRANCE (siège social)", "P.A. la Bretèche <br>CS 26804 Avenue Saint Vincent<br>35768 Saint Grégoire cedex", -1.684159, 48.143693, "0299234600");
insert into agency values(1, "Nantes",  "SODIFRANCE", "4, rue du Château de l’Eraudière <br>44324 Nantes cedex 3", -1.535280, 47.243905, "0240185200");
insert into agency values(2, "Le Mans",  "SODIFRANCE", "Novaxis 2 - Bât. B <br>2, rue de la Voie Lactée <br>72000 Le Mans", 0.188875, 47.995133, "0243252500");
insert into agency values(3, "Tunis",  "SOFT-MAINT Tunisie", "Pôle Technologique El Ghazala<br>Route de Raoued<br>2088 - El Ghazala - Ariana", 10.186826, 36.894998, "");
insert into agency values(4, "Bruxelles",  "SOFT-MAINT Benelux SA", "35 rue du Congrès B - 1000 BRUXELLES", 4.366758, 50.849332, "3222272793");
insert into agency values(5, "Paris", "SODIFRANCE", "25 rue la Boétie<br>75008 Paris", 2.3164305, 48.8739260, "0149931313");
insert into agency values(6, "Noisy-le-Grand", "SODIFRANCE", "1er étage<br>410 clos de la Courtine<br>93160 Noisy-le-Grand", 2.5526100, 48.8485790,"0158841410");
insert into agency values(7, "Lyon", "SODIFRANCE", "1er étage<br>Le Gemellyon Nord<br>57, Boulevard Vivier-Merle<br>69003 Lyon", 4.8585966, 45.7579153,"0426556430");
insert into agency values(8, "Brest", "SODIFRANCE", "Prat pit<br>360, rue Robert Schumann<br>29460 Guipavas", -4.4911986, 48.3979895, "0298304320");
insert into agency values(9, "Aix-en-Provence", "SODIFRANCE", "20, Parc du Golf<br>Rue Guillibert de la Lauzière<br>13856 Aix-en-Provence", 5.3650919, 43.4821946, "0442607280");
insert into agency values(10, "Niort", "SODIFRANCE", "Centre d’affaires des Portes du Marais<br>Rue de l'Angélique<br>Z.A. de L'Ébaupin<br>79000 Bessines", -0.5143940, 46.3019530,"0549269400");
insert into agency values(11, "Orléans", "SODIFRANCE", "Madeleine - Rive de Loire<br>4, place Jean Monnet<br>45000 Orléans", 1.8785309, 47.8990278, "0238421440");
insert into agency values(12, "Toulouse", "SODIFRANCE", "15, Chemin de la Crabe<br>31300 Toulouse", 1.3772280, 43.6116190, "0561158888");
insert into agency values(13, "Tours", "SODIFRANCE", "Centre d’Affaires<br>8 rue Honoré de Balzac<br>37000 Tours", 6.4521495, 45.6304108, "0247606565");