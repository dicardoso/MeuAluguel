CREATE TABLE property_types (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    is_active BOOLEAN NOT NULL
);
INSERT INTO property_types (name, is_active) VALUES ('Residencial', true);
INSERT INTO property_types (name, is_active) VALUES ('Comercial', true);

CREATE TABLE property_statuses (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    is_active BOOLEAN NOT NULL
);

INSERT INTO property_statuses (name, is_active) VALUES ('Disponível', true);
INSERT INTO property_statuses (name, is_active) VALUES ('Alugado', true);

CREATE TABLE profiles (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    is_active BOOLEAN NOT NULL
);

INSERT INTO profiles (name, is_active) VALUES ('Locatário', true);
INSERT INTO profiles (name, is_active) VALUES ('Locador', true);

CREATE TABLE properties (
    id SERIAL PRIMARY KEY,
    address VARCHAR(255) NOT NULL,
    number VARCHAR(50) NOT NULL,
    complement VARCHAR(255),
    neighborhood VARCHAR(50) NOT NULL,
    type_id INT,
    status_id INT,
    is_active BOOLEAN NOT NULL,
    CONSTRAINT fk_type FOREIGN KEY (type_id) REFERENCES property_types (id),
    CONSTRAINT fk_status FOREIGN KEY (status_id) REFERENCES property_statuses (id)
);
INSERT INTO properties (address, number, complement, neighborhood, type_id, status_id, is_active)
VALUES ('Av. Ayrton Sena', '240', '1º andar', 'Padre Zé', 1, 1,true),
       ('Rua B', '456', 'CASA', 'Bairro', 2, 2,true);

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    registry VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    address VARCHAR(255) NOT NULL,
    profile_id INT,
    is_active BOOLEAN NOT NULL,
    CONSTRAINT fk_profile FOREIGN KEY (profile_id) REFERENCES profiles (id)
);
INSERT INTO users (name, email, registry, phone, address, is_active, profile_id)
VALUES ('Marcos Antônio Cardoso da Silva', 'macarddoso@bol.com.br', '45090289468', '(00) 1234-5678', 'Rua Dep. Sóstenes Pedro, 240 - Padre Zé',true,1),
       ('José', 'jose@mail.com', '12345678910', '(00) 1234-5678', 'Rua ',true,2),
       ('Lucas', 'lucas@example.com', '12345678910', '(00) 1234-5678', 'Rua ',true,1),
       ('Maria', 'maria@example.com', '12345678910', '(00) 1234-5678', 'Rua ',true,2);

CREATE TABLE contracts (
       id SERIAL PRIMARY KEY,
       property_id BIGINT NOT NULL,
       owner_id BIGINT NOT NULL,
       renter_id BIGINT NOT NULL,
       start_date DATE NOT NULL,
       end_date DATE NOT NULL,
       sign_date DATE NOT NULL,
       maturity_date BIGINT NOT NULL,
       value DOUBLE PRECISION NOT NULL,
       is_active BOOLEAN NOT NULL,
       CONSTRAINT fk_contract_property FOREIGN KEY (property_id) REFERENCES properties(id),
       CONSTRAINT fk_contract_owner FOREIGN KEY (owner_id) REFERENCES users(id),
       CONSTRAINT fk_contract_renter FOREIGN KEY (renter_id) REFERENCES users(id)
);
INSERT INTO contracts (property_id, owner_id, renter_id, start_date, end_date, sign_date, maturity_date, value, is_active)
VALUES (1, 1, 2, '2022-01-01', '2023-01-01', '2022-01-01', 30, 1000.00, true),
       (2, 3, 4, '2022-02-01', '2023-02-01', '2022-02-01', 15, 1500.00, true);