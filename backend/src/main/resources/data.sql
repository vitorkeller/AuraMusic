MERGE INTO users (username, email, password, role, created_at) KEY(username) VALUES ('professor', 'professor@fatec.sp.gov.br', '123456', 'ADMIN', CURRENT_TIMESTAMP);
MERGE INTO users (username, email, password, role, created_at) KEY(username) VALUES ('vitor', 'vitor@email.com', 'senha123', 'USER', CURRENT_TIMESTAMP);
MERGE INTO users (username, email, password, role, created_at) KEY(username) VALUES ('admin', 'admin@auramusic.com', '123', 'ADMIN', CURRENT_TIMESTAMP);
