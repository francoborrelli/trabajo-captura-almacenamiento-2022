

-- public.brands definition

-- Drop table

-- DROP TABLE public.brands;

CREATE TABLE public.brands (
	id int8 NOT NULL,
	name varchar(255) NULL,
	"version" int4 NOT NULL,
	tsvector_search tsvector,
	CONSTRAINT brands_pkey PRIMARY KEY (id)
);

-- public.products definition

-- Drop table

-- DROP TABLE public.products;

CREATE TABLE public.products (
	id int8 NOT NULL,
	description varchar(255) NULL,
	name varchar(255) NULL,
	"version" int4 NOT NULL,
	brand_id int8 NOT NULL,
	tsvector_search tsvector,
	CONSTRAINT products_pkey PRIMARY KEY (id)
);


-- public.products foreign keys
ALTER TABLE public.products ADD CONSTRAINT fka3a4mpsfdf4d2y6r8ra3sc8mv FOREIGN KEY (brand_id) REFERENCES public.brands(id);


CREATE INDEX products_search_idx ON public.products USING GIN(tsvector_search);
CREATE INDEX brands_search_idx ON public.brands USING GIN(tsvector_search);

CREATE OR REPLACE FUNCTION public.set_tsvector_for_brands()
RETURNS trigger AS
$BODY$
BEGIN
  NEW.tsvector_search = to_tsvector('english', NEW.name);
  RETURN NEW;
END;
$BODY$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION public.set_tsvector_for_products()
RETURNS trigger AS
$BODY$
BEGIN
  NEW.tsvector_search = to_tsvector('english', NEW.name);
  RETURN NEW;
END;
$BODY$
LANGUAGE plpgsql;


CREATE TRIGGER set_tsvector_for_brands
BEFORE insert or update
ON public.brands
FOR EACH ROW
EXECUTE PROCEDURE public.set_tsvector_for_brands();

CREATE TRIGGER set_tsvector_for_products
BEFORE insert or update
ON public.products
FOR EACH ROW
EXECUTE PROCEDURE public.set_tsvector_for_products();