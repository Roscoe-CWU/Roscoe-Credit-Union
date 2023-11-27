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
