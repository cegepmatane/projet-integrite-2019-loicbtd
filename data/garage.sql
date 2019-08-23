

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;


CREATE TABLE voiture (
    modele text,
    couleur text,
    puissance text,
    annee text,
    id integer NOT NULL
);


ALTER TABLE voiture OWNER TO postgres;

--
-- Name: voiture_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE voiture_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE voiture_id_seq OWNER TO postgres;

--
-- Name: voiture_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE voiture_id_seq OWNED BY voiture.id;



ALTER TABLE ONLY voiture ALTER COLUMN id SET DEFAULT nextval('voiture_id_seq'::regclass);


--
-- PostgreSQL database dump complete
--

