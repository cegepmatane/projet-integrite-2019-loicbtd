-------------------------------------------------------------------------------
-- TABLES PRINCIPALES
-------------------------------------------------------------------------------
DROP TABLE IF EXISTS voiture;
DROP TABLE IF EXISTS marque;

CREATE TABLE marque (
    id_marque serial PRIMARY KEY,
    nom text,
    couleur_logo text,
    slogan text,
    date_creation integer
);

CREATE TABLE voiture (
    id_voiture serial PRIMARY KEY ,
    modele text,
    couleur text,
    puissance integer,
    annee integer,
    id_marque integer,
    CONSTRAINT marque_voiture_fk
        FOREIGN KEY (id_marque)
        REFERENCES marque(id_marque)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);


-------------------------------------------------------------------------------
-- PROCÉDURES STOCKÉES CRUD
-------------------------------------------------------------------------------

-- MARQUE - SELECT with id
DROP FUNCTION IF EXISTS selectionner_marque(id integer);
CREATE FUNCTION selectionner_marque(id integer)
    RETURNS VOID
    LANGUAGE 'plpgsql'
AS $$
    BEGIN
        SELECT nom, couleur_logo, slogan, date_creation FROM marque WHERE id_marque = id;
    END
$$;

-- MARQUE - INSERT
DROP FUNCTION IF EXISTS inserer_marque(new_nom text, new_couleur_logo text, new_slogan text, new_date_creation integer);
CREATE FUNCTION inserer_marque(new_nom text, new_couleur_logo text, new_slogan text, new_date_creation integer)
    RETURNS VOID
    LANGUAGE 'plpgsql'
AS $$
BEGIN
    INSERT INTO marque(nom, couleur_logo, slogan, date_creation)
    VALUES(new_nom, new_couleur_logo, new_slogan, new_date_creation);
END
$$;

-- MARQUE - UPDATE
DROP FUNCTION IF EXISTS modifier_marque(id integer, nom text, couleur_logo text, slogan text, date_creation integer);
CREATE FUNCTION modifier_marque(id integer, new_nom text, new_couleur_logo text, new_slogan text, new_date_creation integer)
    RETURNS VOID
    LANGUAGE 'plpgsql'
AS $$
BEGIN
    UPDATE marque SET
        nom = new_nom,
        couleur_logo = new_couleur_logo,
        slogan = new_slogan,
        date_creation = new_date_creation
    WHERE id_marque = id;
END
$$;

-- MARQUE -  DELETE
DROP FUNCTION IF EXISTS supprimer_marque(id integer);
CREATE FUNCTION supprimer_marque(id integer)
    RETURNS VOID
    LANGUAGE 'plpgsql'
AS $$
BEGIN
    DELETE FROM marque WHERE id_marque = id;
END
$$;

-------------------------------------------------------------------------------
-- JOURNALISATION (triggers & functions)
-------------------------------------------------------------------------------

-- TABLE
DROP TABLE IF EXISTS journal;
CREATE TABLE journal (
     id_journal serial PRIMARY KEY ,
     moment timestamp with time zone,
     operation text,
     objet text,
     description text
);

-- AJOUT - MARQUE
DROP TRIGGER IF EXISTS evenement_ajout_marque ON marque;
DROP FUNCTION IF EXISTS journaliser_ajout_marque();

CREATE FUNCTION journaliser_ajout_marque()
    RETURNS TRIGGER
    LANGUAGE 'plpgsql'
AS $$
DECLARE
    description text;
BEGIN
    description := 'modele: '||NEW.nom || ' vitesse: ' || NEW.couleur_logo || ' poids: ' ||  NEW.slogan || ' prix: ' || NEW.date_creation;
    INSERT INTO journal(moment,operation,objet,description) VALUES(NOW(), 'AJOUT', 'marque', description);
    return NEW;
END
$$;

CREATE TRIGGER evenement_ajout_marque
    BEFORE INSERT ON marque
    FOR EACH ROW
    EXECUTE PROCEDURE journaliser_ajout_marque();

-- MODIFICATION - MARQUE
DROP TRIGGER IF EXISTS evenement_modification_marque ON marque;
DROP FUNCTION IF EXISTS journaliser_modifier_marque();

CREATE FUNCTION journaliser_modifier_marque()
    RETURNS TRIGGER
    LANGUAGE 'plpgsql'
AS $$
DECLARE
    description text;
    descriptionAncien text;
    descriptionNouveau text;
BEGIN
    descriptionAncien := 'modele: '||OLD.nom || ' vitesse: ' || OLD.couleur_logo || ' poids: ' ||  OLD.slogan || ' prix: ' || OLD.date_creation;
    descriptionNouveau := 'modele: '||NEW.nom || ' vitesse: ' || NEW.couleur_logo || ' poids: ' ||  NEW.slogan || ' prix: ' || NEW.date_creation;
    description := descriptionAncien || ' ==> ' || descriptionNouveau;
    INSERT INTO journal(moment,operation,objet,description) VALUES(NOW(), 'AJOUT', 'marque', description);
    return NEW;
END
$$;

CREATE TRIGGER evenement_modification_marque
    BEFORE UPDATE ON marque
    FOR EACH ROW
EXECUTE PROCEDURE journaliser_modifier_marque();

-- SUPPRESSION - MARQUE
DROP TRIGGER IF EXISTS evenement_suppression_marque ON marque;
DROP FUNCTION IF EXISTS journaliser_suppression_marque();

CREATE FUNCTION journaliser_suppression_marque()
    RETURNS TRIGGER
    LANGUAGE 'plpgsql'
AS $$
DECLARE
    description text;
BEGIN
    description := 'modele: '||OLD.nom || ' vitesse: ' || OLD.couleur_logo || ' poids: ' ||  OLD.slogan || ' prix: ' || OLD.date_creation;
    INSERT INTO journal(moment,operation,objet,description) VALUES(NOW(), 'AJOUT', 'marque', description);
    return NEW;
END
$$;

CREATE TRIGGER evenement_suppression_marque
    BEFORE DELETE ON marque
    FOR EACH ROW
EXECUTE PROCEDURE journaliser_suppression_marque();


-------------------------------------------------------------------------------
-- STATISTIQUES
-------------------------------------------------------------------------------

-- MARQUE
DROP TABLE IF EXISTS statistique_marque;
CREATE TABLE statistique_marque (
     id_marque_statistique serial PRIMARY KEY ,
     moment timestamp with time zone,
     nombre_marque integer,
     annee_moyenne decimal,
     checksum text
);

CREATE FUNCTION generer_statistique_marque()
    RETURNS TRIGGER
    LANGUAGE 'plpgsql'
AS $$
DECLARE
    description text;
BEGIN
    description := 'modele: '||OLD.nom || ' vitesse: ' || OLD.couleur_logo || ' poids: ' ||  OLD.slogan || ' prix: ' || OLD.date_creation;
    INSERT INTO statistique_marque(moment,nombre_marque,annee_moyenne,checksum) VALUES(NOW(), 'AJOUT', 'marque', description);
    return NEW;
END
$$;

-- VOITURE
DROP TABLE IF EXISTS generer_statistique_voiture;
CREATE TABLE statistique_voiture (
    id_voiture_statistique serial PRIMARY KEY ,
    moment timestamp with time zone,
    nombre_voiture integer,
    puissance_moyenne decimal,
    checksum text
);

CREATE FUNCTION generer_statistique_voiture()
    RETURNS TRIGGER
    LANGUAGE 'plpgsql'
AS $$
DECLARE
    description text;
BEGIN
    description := 'modele: '||OLD.nom || ' vitesse: ' || OLD.couleur_logo || ' poids: ' ||  OLD.slogan || ' prix: ' || OLD.date_creation;
    INSERT INTO journal(moment,operation,objet,description) VALUES(NOW(), 'AJOUT', 'marque', description);
    return NEW;
END
$$;


-- Aggrégation
DROP TABLE IF EXISTS statistique_marque_voiture;
CREATE TABLE statistique_marque_voiture (
     id_marque_voiture_statistique serial PRIMARY KEY ,
     moment timestamp with time zone,
     marque text,
     nombre_voiture integer,
     checksum text
);