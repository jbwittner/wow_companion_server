DROP USER IF EXISTS 'wow_companion_user'@'localhost';
DROP USER IF EXISTS 'wow_companion_user'@'%';
DROP DATABASE IF EXISTS wow_companion_db;

CREATE DATABASE wow_companion_db;
CREATE USER 'wow_companion_user'@'localhost' IDENTIFIED BY 'WoWCompanionPass2022';

GRANT ALL PRIVILEGES ON wow_companion_db.* TO 'wow_companion_user'@'localhost';
FLUSH PRIVILEGES;
