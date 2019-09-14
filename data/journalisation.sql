-- -- compter marques
-- SELECT count(id_voiture) as nombreMarques FROM marque;


-- -- journalisation
-- DROP FUNCTION journaliser();
-- CREATE or REPLACE FUNCTION journaliser()
--     RETURNS trigger
--     LANGUAGE 'plpgsql'

-- AS $$
-- DECLARE

-- BEGIN
--     return NEW;
-- END
-- $$


-- -- exemple fonction avec boolean
-- CREATE or REPLACE FUNCTION estPlusPetit(a integer, b integer)
--     RETURNS boolean
--     LANGUAGE 'plpgsql'

-- AS $$
-- DECLARE

-- BEGIN
--     return a<b;
-- END
-- $$


-- -- insert
-- CREATE or REPLACE FUNCTION ajouterMarque(nom text)
-- 	RETURNS void
--     LANGUAGE 'sql'

-- AS $$
--     INSERT INTO marque(nom) values(nom);
-- $$


-- -- direBonjour
-- CREATE or REPLACE FUNCTION direBonjour(nom text)
-- 	RETURNS text
--     LANGUAGE 'plpgsql'

-- AS $$
-- DECLARE 
--     message text;
-- BEGIN
--     message := 'Bonjour ' || nom;
--     return message;
-- END
-- $$

-- select direBonjour('Loïc')


-- insert
CREATE or REPLACE FUNCTION ajouterMarque(nom text)
	RETURNS void
    LANGUAGE 'sql'

AS $$
    INSERT INTO marque(nom) values(nom);
$$

-- journaliserAjout()
CREATE or REPLACE FUNCTION journaliserAjoutMarque()
	RETURNS trigger
    LANGUAGE 'plpgsql'

AS $$
DECLARE 
    nouvelleMarque text;
    desciptions text;
BEGIN
    desciptions := NEW.nom || ' (' || NEW.couleur || ')';

    INSERT INTO journal(moment,operation,desciptions,objet) VALUES(NOW(), 'AJOUT', nouvelleMarque, 'marque');
    
    return NEW;
END
$$

CREATE TRIGGER evenementAjoutMarque
    BEFORE INSERT ON marque 
    FOR EACH ROW EXECUTE PROCEDURE 
        journaliserAjoutMarque();

INSERT INTO marque(nom) VALUES ('test')





-- update
CREATE or REPLACE FUNCTION modifierMarque(index integer, nouveauNom text)
	RETURNS void
    LANGUAGE 'sql'

AS $$
    UPDATE marque
	SET nom=nouveauNom
	WHERE id_voiture=index;
$$

-- journaliserModfier()
CREATE or REPLACE FUNCTION journaliserModifierMarque()
	RETURNS trigger
    LANGUAGE 'plpgsql'

AS $$
DECLARE 
    nouvelleMarque text;

BEGIN

    INSERT INTO journal(moment,operation,desciptions,objet) VALUES(NOW(), 'MOFIFICATION', nouvelleMarque, 'marque');
    
    return NEW;
END
$$

CREATE TRIGGER evenementModifierMarque
    BEFORE UPDATE ON marque 
    FOR EACH ROW EXECUTE PROCEDURE 
        journaliserModifierMarque();

UPDATE marque
	SET nom=nouveauNom
	WHERE id_voiture=index;