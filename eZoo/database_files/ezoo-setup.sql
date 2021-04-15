-- drop table animals if exists
drop table if exists animals;

create table animals (
  animalid integer primary key,
  "name" varchar (100),
  taxKingdom varchar (80),
  taxPhylum varchar (80),
  taxClass varchar (80),
  taxOrder varchar (80),
  taxFamily varchar (80),
  taxGenus varchar (80),
  taxSpecies varchar (80),
  height numeric(6,2),
  weight numeric(6,2),
  "type" varchar (80),
  healthStatus varchar (80)
);

insert into animals values (
  1,          -- id
  'Leo',      -- name
  'Animalia', -- kingdom
  'Chordata',    -- phylum
  'Mammalia',   -- class
  'Carnivora',-- animal_order
  'Felidae',  -- family
  'Panthera', -- genus
  'P. leo',   -- species
  120.88,     -- height
  400.67,     -- weight
  'Mammal (Terrestrial)',   -- type
  'Healthy'   -- healthStatus
);



-- Table: public.feeding_schedules

-- DROP TABLE public.feeding_schedules;

CREATE TABLE public.feeding_schedules
(
    schedule_id integer NOT NULL,
    feeding_time character varying(50) COLLATE pg_catalog."default",
    recurrence character varying(10) COLLATE pg_catalog."default",
    food character varying(50) COLLATE pg_catalog."default",
    notes character varying(50) COLLATE pg_catalog."default",
    animalid integer NOT NULL,
    CONSTRAINT feeding_schedules_pkey PRIMARY KEY (schedule_id)
);