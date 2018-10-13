CREATE TABLE oauth_client_details (
  client_id               VARCHAR(255) PRIMARY KEY,
  resource_ids            VARCHAR(255),
  client_secret           VARCHAR(255),
  scope                   VARCHAR(255),
  authorized_grant_types  VARCHAR(255),
  web_server_redirect_uri VARCHAR(255),
  authorities             VARCHAR(255),
  access_token_validity   INTEGER,
  refresh_token_validity  INTEGER,
  additional_information  VARCHAR(4096),
  autoapprove             SMALLINT
);

CREATE TABLE oauth_client_token (
  token_id          VARCHAR(255),
  token             BYTEA,
  authentication_id VARCHAR(255),
  user_name         VARCHAR(255),
  client_id         VARCHAR(255)
);

CREATE TABLE oauth_access_token (
  token_id          VARCHAR(255),
  token             BYTEA,
  authentication_id VARCHAR(255),
  user_name         VARCHAR(255),
  client_id         VARCHAR(255),
  authentication    BYTEA,
  refresh_token     VARCHAR(255)
);

CREATE TABLE oauth_refresh_token (
  token_id       VARCHAR(255),
  token          BYTEA,
  authentication BYTEA
);

CREATE TABLE oauth_code (
  code           VARCHAR(255),
  authentication BYTEA
);

CREATE TABLE authority (
  name VARCHAR(50) NOT NULL PRIMARY KEY
);

CREATE TABLE users
(
  id          SERIAL                 NOT NULL,
  username    CHARACTER VARYING(100) NOT NULL,
  password    CHARACTER VARYING(100) NOT NULL,
  activated   BOOLEAN DEFAULT FALSE,
  email       CHARACTER VARYING(100) NOT NULL,
  reset_token CHARACTER VARYING(100) NULL,
  CONSTRAINT user_id_key PRIMARY KEY (id),
  CONSTRAINT username_unique UNIQUE (username)
);

CREATE TABLE user_authority (
  id        SERIAL                 NOT NULL,
  username  CHARACTER VARYING(100) NOT NULL,
  authority CHARACTER VARYING(100) NOT NULL
);
ALTER TABLE public.user_authority
  ADD CONSTRAINT user_authority_user_username_fk
FOREIGN KEY (username) REFERENCES users (username);



