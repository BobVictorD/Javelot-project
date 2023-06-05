SET SCHEMA 'public';

DROP SEQUENCE IF EXISTS ville_id_seq;
DROP SEQUENCE IF EXISTS releve_meteo_id_seq;

CREATE SEQUENCE ville_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

CREATE SEQUENCE releve_meteo_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

DROP TABLE IF EXISTS releve_meteo;
DROP TABLE IF EXISTS ville;


CREATE TABLE ville (
	id int4 NOT NULL,
	nom varchar(255) NOT NULL,
	latitude float(53),
	longitude float(53),
	date_creation timestamp NOT NULL,
	date_modification timestamp NOT NULL,
	CONSTRAINT ville_pkey PRIMARY KEY (id)
);

CREATE TABLE releve_meteo (
	id int4 NOT NULL,
	date_releve timestamp NOT NULL,
	temperature float(53),
	date_creation timestamp NOT NULL,
	date_modification timestamp NOT NULL,
	ville_id int4 NOT NULL,
	CONSTRAINT releve_meteo_pkey PRIMARY KEY (id),
	CONSTRAINT fk_releve_meteo_ville_id FOREIGN KEY (ville_id) REFERENCES ville(id)
);

