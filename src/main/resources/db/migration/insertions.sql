
INSERT INTO buyer (cpf, email, first_name, last_name, phone)
VALUES
    ('12345678901', 'johndoe@example.com', 'John', 'Doe', '123456789'),
    ('98765432100', 'janedoe@example.com', 'Jane', 'Doe', '987654321');


INSERT INTO place (city, country, description, max_capacity, name, number, street)
VALUES
    ('New York', 'USA', 'Main concert venue', 5000, 'Madison Square Garden', '123', 'Main Street'),
    ('Rio de Janeiro', 'Brazil', 'Football stadium', 80000, 'Maracanã', '456', 'Avenida Principal');


INSERT INTO event (category, description, max_capacity, name, place_id)
VALUES
    ('Music', 'Rock concert', 5000, 'Rock Fest 2025', 1),
    ('Sports', 'Football final', 80000, 'World Cup Final', 2);


INSERT INTO event_dates (event_id, dates)
VALUES
    (1, '2025-06-15 20:00:00'),
    (2, '2025-07-30 17:00:00');


INSERT INTO purchase (purchase_date, buyer_id)
VALUES
    ('2025-01-10', 1),
    ('2025-01-12', 2);


INSERT INTO ticket_field (name, value)
VALUES
    ('carteira_cadeirante', '123456'),
    ('acesso_vip', '987654');


INSERT INTO ticket_type (name, price, quantity)
VALUES
    ('Standard', 50.00, 1000),
    ('VIP', 150.00, 200);


INSERT INTO event_tickets_distribution (event_id, type_value, tickets_distribution_key)
VALUES
    (1, 500, 1),
    (2, 1000, 2);


INSERT INTO ticket (event_id, ticket_type_id, user_id)
VALUES
    (1, 1, 1),
    (2, 2, 2);


INSERT INTO purchase_ticket (purchase_id, ticket_id)
VALUES
    (1, 1),
    (2, 2);


INSERT INTO ticket_dates (ticket_id, dates)
VALUES
    (1, '2025-06-15'),
    (2, '2025-07-30');


INSERT INTO ticket_type_fields (ticket_type_id, fields_id)
VALUES
    (1, 1),
    (2, 2);
