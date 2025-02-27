insert into buyer (birth_date, cpf, email, first_name, last_name, phone) values
                                                                             ('1990-05-20', '123.456.789-00', 'buyer1@example.com', 'John', 'Doe', '555-1234'),
                                                                             ('1985-08-15', '987.654.321-00', 'buyer2@example.com', 'Jane', 'Smith', '555-5678');

insert into place (max_capacity, city, country, description, name, number, street) values
                                                                                       (500, 'New York', 'USA', 'Concert Hall', 'Madison Square Garden', '4', '7th Ave'),
                                                                                       (300, 'Los Angeles', 'USA', 'Theater', 'Dolby Theatre', '5', 'Hollywood Blvd');

insert into promoter (cpf, email, name, password) values
                                                      ('111.222.333-44', 'promoter1@example.com', 'Alice Johnson', 'securepass1'),
                                                      ('555.666.777-88', 'promoter2@example.com', 'Bob Brown', 'securepass2');

insert into event (max_capacity, place_id, promoter_id, category, description, name) values
                                                                                         (500, 1, 1, 'Music', 'Rock Concert', 'Rock Fest 2025'),
                                                                                         (300, 2, 2, 'Theater', 'Broadway Show', 'Phantom of the Opera');

insert into event_dates (dates, event_id) values
                                              ('2025-06-15 20:00:00', 1),
                                              ('2025-07-10 19:30:00', 2);

insert into promoter_events (events_id, promoter_id) values
                                                         (1, 1),
                                                         (2, 2);

insert into purchase (purchase_date, buyer_id) values
                                                   ('2025-02-20', 1),
                                                   ('2025-02-21', 2);

insert into ticket_field (name, value) values
                                           ('Seat', 'A10'),
                                           ('VIP Access', 'Yes');

insert into ticket_type (price, name) values
                                          (100.00, 'Regular'),
                                          (200.00, 'VIP');

insert into event_ticket_types (event_id, ticket_types_id) values
                                                               (1, 1),
                                                               (2, 2);

insert into ticket (event_id, ticket_type_id, user_id) values
                                                           (1, 1, 1),
                                                           (2, 2, 2);

insert into purchase_tickets (purchase_id, tickets_id) values
                                                           (1, 1),
                                                           (2, 2);

insert into ticket_dates (dates, ticket_id) values
                                                ('2025-06-15', 1),
                                                ('2025-07-10', 2);

insert into ticket_distribuition (ticket_type_id, value) values
                                                             (1, 50),
                                                             (2, 20);

insert into event_ticket_distribuitions (event_id, ticket_distribuitions_id) values
                                                                                 (1, 1),
                                                                                 (2, 2);

insert into ticket_type_fields (fields_id, ticket_type_id) values
                                                               (1, 1),
                                                               (2, 2);
