INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (1, 'Johns savings', 0.0, 'SAVINGS')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (1, 'Johns checking', 50000.0, 'CHECKING')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (1, 'Johns credit', 25000.0, 'CREDIT')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (1, 'Johns credit 2', 50000.0, 'CREDIT')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

-- Account ID 2
INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (2, 'Account 2 Savings', 10000.0, 'SAVINGS')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (2, 'Account 2 Checking', 25000.0, 'CHECKING')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (2, 'Account 2 Credit', 5000.0, 'CREDIT')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

-- Account ID 3
INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (3, 'Account 3 Savings', 15000.0, 'SAVINGS')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (3, 'Account 3 Checking', 30000.0, 'CHECKING')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (3, 'Account 3 Credit', 7500.0, 'CREDIT')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

-- Account ID 4
INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (4, 'Account 4 Savings', 20000.0, 'SAVINGS')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (4, 'Account 4 Checking', 35000.0, 'CHECKING')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (4, 'Account 4 Credit', 10000.0, 'CREDIT')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

-- Account ID 5
INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (5, 'Account 5 Savings', 25000.0, 'SAVINGS')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (5, 'Account 5 Checking', 40000.0, 'CHECKING')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (5, 'Account 5 Credit', 15000.0, 'CREDIT')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

-- Account ID 6
INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (6, 'Account 6 Savings', 30000.0, 'SAVINGS')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (6, 'Account 6 Checking', 45000.0, 'CHECKING')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (6, 'Account 6 Credit', 20000.0, 'CREDIT')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

-- Account ID 7
INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (7, 'Account 7 Savings', 35000.0, 'SAVINGS')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (7, 'Account 7 Checking', 50000.0, 'CHECKING')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (7, 'Account 7 Credit', 25000.0, 'CREDIT')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

-- Account ID 8
INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (8, 'Account 8 Savings', 40000.0, 'SAVINGS')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (8, 'Account 8 Checking', 55000.0, 'CHECKING')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (8, 'Account 8 Credit', 30000.0, 'CREDIT')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

-- Account ID 9
INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (9, 'Account 9 Savings', 45000.0, 'SAVINGS')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (9, 'Account 9 Checking', 60000.0, 'CHECKING')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (9, 'Account 9 Credit', 35000.0, 'CREDIT')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

-- Account ID 10
INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (10, 'Account 10 Savings', 50000.0, 'SAVINGS')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (10, 'Account 10 Checking', 65000.0, 'CHECKING')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (10, 'Account 10 Credit', 40000.0, 'CREDIT')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

-- Account ID 11
INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (11, 'Account 11 Savings', 55000.0, 'SAVINGS')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (11, 'Account 11 Checking', 70000.0, 'CHECKING')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (11, 'Account 11 Credit', 45000.0, 'CREDIT')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

-- Account ID 12
INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (12, 'Account 12 Savings', 60000.0, 'SAVINGS')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (12, 'Account 12 Checking', 75000.0, 'CHECKING')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (12, 'Account 12 Credit', 50000.0, 'CREDIT')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

-- Account ID 13
INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (13, 'Account 13 Savings', 65000.0, 'SAVINGS')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (13, 'Account 13 Checking', 80000.0, 'CHECKING')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (13, 'Account 13 Credit', 55000.0, 'CREDIT')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

-- Account ID 14
INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (14, 'Account 14 Savings', 70000.0, 'SAVINGS')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (14, 'Account 14 Checking', 85000.0, 'CHECKING')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (14, 'Account 14 Credit', 60000.0, 'CREDIT')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

-- Account ID 15
INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (15, 'Account 15 Savings', 75000.0, 'SAVINGS')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (15, 'Account 15 Checking', 90000.0, 'CHECKING')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (15, 'Account 15 Credit', 65000.0, 'CREDIT')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

-- Account ID 16
INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (16, 'Account 16 Savings', 80000.0, 'SAVINGS')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (16, 'Account 16 Checking', 95000.0, 'CHECKING')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (16, 'Account 16 Credit', 70000.0, 'CREDIT')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

-- Account ID 17
INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (17, 'Account 17 Savings', 85000.0, 'SAVINGS')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (17, 'Account 17 Checking', 100000.0, 'CHECKING')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (17, 'Account 17 Credit', 75000.0, 'CREDIT')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

-- Account ID 18
INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (18, 'Account 18 Savings', 90000.0, 'SAVINGS')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (18, 'Account 18 Checking', 105000.0, 'CHECKING')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (18, 'Account 18 Credit', 80000.0, 'CREDIT')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

-- Account ID 19
INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (19, 'Account 19 Savings', 95000.0, 'SAVINGS')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (19, 'Account 19 Checking', 110000.0, 'CHECKING')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (19, 'Account 19 Credit', 85000.0, 'CREDIT')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

-- Account ID 20
INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (20, 'Account 20 Savings', 100000.0, 'SAVINGS')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (20, 'Account 20 Checking', 115000.0, 'CHECKING')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (20, 'Account 20 Credit', 90000.0, 'CREDIT')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

-- Account ID 21
INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (21, 'Account 21 Savings', 105000.0, 'SAVINGS')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (21, 'Account 21 Checking', 120000.0, 'CHECKING')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (21, 'Account 21 Credit', 95000.0, 'CREDIT')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

-- Account ID 22
INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (22, 'Account 22 Savings', 110000.0, 'SAVINGS')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (22, 'Account 22 Checking', 125000.0, 'CHECKING')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);

INSERT INTO BankAccount (accountID, accountName, balance, AccountType) 
VALUES (22, 'Account 22 Credit', 100000.0, 'CREDIT')
ON DUPLICATE KEY UPDATE 
accountName = VALUES(accountName), balance = VALUES(balance), AccountType = VALUES(AccountType);
