DROP INDEX IF EXISTS user_unique_idx;
DROP TABLE IF EXISTS app_user;
DROP SEQUENCE IF EXISTS app_user_seq;

CREATE SEQUENCE app_user_seq
  START 1000;

CREATE TABLE "app_user" (
  id     BIGINT PRIMARY KEY          DEFAULT nextval('app_user_seq'),
  apikey text NOT NULL,
  alias  text,
  movies  text,
  CONSTRAINT phone_constraint UNIQUE (apikey),
  CONSTRAINT seo_id_constraint UNIQUE (alias)
);

CREATE INDEX "user_unique_idx"
  ON "app_user" (apikey, alias);

CREATE OR REPLACE FUNCTION app_user_bi()
  RETURNS TRIGGER AS $app_user_bi$
BEGIN
  IF NEW.alias IS NULL
  THEN
    NEW.alias := NEW.apikey;
  END IF;

  RETURN NEW;
END;

$app_user_bi$
LANGUAGE plpgsql;
CREATE TRIGGER app_user_bi
  BEFORE INSERT OR UPDATE
  ON "app_user"
  FOR EACH ROW EXECUTE PROCEDURE app_user_bi();


