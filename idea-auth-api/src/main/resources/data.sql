--- clientId:secret
INSERT INTO oauth_client_details (client_id, client_secret, authorized_grant_types,scope, authorities)
VALUES ('clientId','$2a$10$BC2apvSdwkaSktscU1rHw.y1VoyOuqqmhLCn7qAQhafO5E41QIbBC','password,refresh_token,check_token','read,write','ADMIN,USER');
-- admin:admin
INSERT INTO users (username, password, activated, email) VALUES ('admin', '$2a$10$ki4/cE0Rz133Aj.fj1bn6efCyFzXglv5f98iuC2fdD/BNkVRBDEXS', true,'admin123@gmail.com');

INSERT INTO authority (name) VALUES ('USER');
INSERT INTO authority (name) VALUES ('ADMIN');
INSERT INTO authority (name) VALUES ('MANAGER');

INSERT INTO user_authority (username,authority) VALUES ('admin', 'ADMIN');
INSERT INTO user_authority (username,authority) VALUES ('admin', 'USER');

