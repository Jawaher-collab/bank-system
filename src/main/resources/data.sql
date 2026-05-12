INSERT INTO customers (first_name, last_name, email, username, password, role, enabled, failed_attempts, account_locked)
VALUES ('Mohammed', 'Ali', 'mohammed@bank.com', 'mohammed',
        '$2a$10$vDdu4vGbirder9EOWL6U8etM82SzEAagUT2Wb/wKyJ8h/KEGHwFcK',
        'ROLE_USER', true, 0, false);

INSERT INTO customers (first_name, last_name, email, username, password, role, enabled, failed_attempts, account_locked)
VALUES ('Sara', 'Ahmed', 'sara@bank.com', 'sara',
        '$2a$10$vDdu4vGbirder9EOWL6U8etM82SzEAagUT2Wb/wKyJ8h/KEGHwFcK',
        'ROLE_USER', true, 0, false);

INSERT INTO customers (first_name, last_name, email, username, password, role, enabled, failed_attempts, account_locked)
VALUES ('Khalid', 'Mahmoud', 'khalid@bank.com', 'khalid',
        '$2a$10$vDdu4vGbirder9EOWL6U8etM82SzEAagUT2Wb/wKyJ8h/KEGHwFcK',
        'ROLE_USER', true, 0, false);

INSERT INTO customers (first_name, last_name, email, username, password, role, enabled, failed_attempts, account_locked)
VALUES ('Admin', 'User', 'admin@bank.com', 'admin',
        '$2a$10$7wio0V/J2JIiXv0uUEfJAer3H3oy2vKx0q8af5QuMZItoM1NW4XRq',
        'ROLE_ADMIN', true, 0, false);
INSERT INTO customers (first_name, last_name, email, username, password, role, enabled, failed_attempts, account_locked)
VALUES ('Test', 'User', 'test@bank.com', 'testuser',
        '$2a$10$Sdca0eG.S6Pp.2c9jQiF4OGNlTHd74Yg5/I4eQrQXubsWWYZ1A5xO',
        'ROLE_ADMIN', true, 0, false);



INSERT INTO accounts (owner, balance, type, status, customer_id)
VALUES ('Mohammed', 5000, 'SAVINGS', 'ACTIVE', 1);

INSERT INTO accounts (owner, balance, type, status, customer_id)
VALUES ('Sara', 3000, 'CHECKING', 'ACTIVE', 2);



