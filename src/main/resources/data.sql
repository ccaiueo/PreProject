/*
///////////////////////////////////////////
// メモ
///////////////////////////////////////////
//
// データベースに初期データを入れるsqlファイル
// H2データベース用だったがテーブル作れなかったので使ってない
//
// 他のDBでもapplication.propertiesに ↓ を書けば使えるはずなので一旦消さずにおいておく
//
// 		spring.datasource.schema=classpath:schema.sql
// 		spring.datasource.data=classpath:data.sql
//
///////////////////////////////////////////
*/

// 従業員テーブルのデータ
INSERT INTO employee (employee_id, employee_name, age)
VALUES (1, '山田 太郎', 30);

// ユーザーマスタのデータ（アドミン権限）
INSERT INTO m_user (user_id, user_name, password, birthday, age, sex, role)
VALUES('yamada@xxx.co.jp','山田太郎','password','1990-01-01',28,false,'ROLE_ADMIN');