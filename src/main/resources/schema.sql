/*
///////////////////////////////////////////
// メモ
///////////////////////////////////////////
//
// データベースの構造を作るsqlファイル(テーブル作成部)
// H2データベース用に作ったけど、テーブルが作れなかったので使ってない
//
// 他のDBでもapplication.propertiesに ↓ を書けば使えるはずなので一旦消さずにおいておく
//
// 		spring.datasource.schema=classpath:schema.sql
// 		spring.datasource.data=classpath:data.sql
//
///////////////////////////////////////////
*/

// 従業員テーブル
CREATE TABLE IS NOT EXISTS employee (
    employee_id INT PRIMARY KEY,
    employee_name VARCHAR(50),
    age INT
);

// ユーザーマスタ
CREATE TABLE IS NOT EXISTS m_user (

	user_id VARCHAR(50) PRIMARY KEY,
	user_name VARCHAR(50),
	password VARCHAR(100),
	birthday DATE,
	age INT,
	sex BOOLEAN,
	role VARCHAR(50)

);
