-- Inserção para a tabela buyer
INSERT INTO buyer (birth_date, cpf, email, first_name, last_name, phone)
VALUES ('1990-01-01', '12345678901', 'john.doe@example.com', 'John', 'Doe', '123456789'),
       ('1985-05-15', '98765432109', 'jane.smith@example.com', 'Jane', 'Smith', '987654321');

-- Inserção para a tabela place
INSERT INTO place (max_capacity, city, country, description, name, number, street)
VALUES (100, 'New York', 'USA', 'Main event location', 'Central Park', '10', '5th Avenue'),
       (150, 'Los Angeles', 'USA', 'Another great place', 'LA Convention Center', '15', 'Olympic Blvd');

-- Inserção para a tabela event
INSERT INTO event (max_capacity, place_id, category, description, name)
VALUES (500, 1, 'Music', 'Concert by a famous artist', 'Summer Festival'),
       (200, 2, 'Technology', 'Tech conference with workshops', 'Tech Summit 2025');

-- Inserção para a tabela event_dates
INSERT INTO event_dates (dates, event_id)
VALUES ('2025-06-15 20:00:00', 1),
       ('2025-07-20 09:00:00', 2);

-- Inserção para a tabela promoter
INSERT INTO promoter (cpf, email, name, password)
VALUES ('98765432100', 'promoter@example.com', 'Alice Green', 'securepassword'),
       ('11223344556', 'bob.promo@example.com', 'Bob Brown', 'anotherpassword');

-- Inserção para a tabela purchase
INSERT INTO purchase (purchase_date, buyer_id)
VALUES ('2025-01-25', 1),
       ('2025-01-26', 2);

-- Inserção para a tabela ticket_field
INSERT INTO ticket_field (name, value)
VALUES ('VIP Access', 'true'),
       ('Early Access', 'false');

-- Inserção para a tabela ticket_type
INSERT INTO ticket_type (price, quantity, name)
VALUES (50.0, 100, 'General Admission'),
       (150.0, 50, 'VIP Pass');

-- Inserção para a tabela event_tickets_distribution
INSERT INTO event_tickets_distribution (event_id, tickets_distribution_key, type_value)
VALUES (1, 1, 100),
       (2, 2, 50);

-- Inserção para a tabela ticket
INSERT INTO ticket (event_id, ticket_type_id, user_id)
VALUES (1, 1, 1),
       (2, 2, 2);

-- Inserção para a tabela purchase_ticket
INSERT INTO purchase_ticket (purchase_id, ticket_id)
VALUES (1, 1),
       (2, 2);

-- Inserção para a tabela ticket_dates
INSERT INTO ticket_dates (dates, ticket_id)
VALUES ('2025-06-15', 1),
       ('2025-07-20', 2);

-- Inserção para a tabela ticket_type_fields
INSERT INTO ticket_type_fields (fields_id, ticket_type_id)
VALUES (1, 1),
       (2, 2);
