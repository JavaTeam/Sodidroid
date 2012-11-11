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
	