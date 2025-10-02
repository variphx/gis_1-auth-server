INSERT INTO roles (authority) VALUES
('ADMIN'),
('USER');

INSERT INTO users (username, password) VALUES
('admin', '$2a$12$Gmir50rnfastt3IFywKJzOv3pNOsDJirGN3li926van8/R/e/NSq.'),
('user', '$2a$12$Gmir50rnfastt3IFywKJzOv3pNOsDJirGN3li926van8/R/e/NSq.');

INSERT INTO user_roles (user_id, role_id) VALUES
(1, 1),
(2, 2);
