INSERT INTO employee(
	employee_id, 
	employee_name, 
	age
)VALUES(
	1, '山田太郎', 30);


CREATE  TABLE IF NOT EXISTS m_user(
user_id VARCHAR(50) PRIMARY KEY, 
password VARCHAR(100),
user_name VARCHAR(50),
birthday DATE,
age INT,
marriage BOOLEAN,
role VARCHAR(50));
