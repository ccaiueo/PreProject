package com.example.demo.login.domain.repository.jdbc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.repository.UserDao;
@Repository
public class UserDaoJdbcImpl implements UserDao{

	@Autowired
	JdbcTemplate jdbc;

	@Override
	public int count() throws DataAccessException{

		// Objectの取得
		// 全県取得してカウント
		int count = jdbc.queryForObject("SELECT COUNT(*) FROM m_user", Integer.class);

		return count;
	}

    // Userテーブルにデータを1件insert.
    @Override
    public int insertOne(User user) throws DataAccessException {

        //１件登録
        int rowNumber = jdbc.update("INSERT INTO m_user(user_id,"
                + " password,"
                + " user_name,"
                + " birthday,"
                + " age,"
                + " sex,"
                + " role)"
                + " VALUES(?, ?, ?, ?, ?, ?, ?)",
                user.getUserId(),
                user.getPassword(),
                user.getUserName(),
                user.getBirthday(),
                user.getAge(),
                user.isSex(),
                user.getRole());

        return rowNumber;
    }

	@Override
	public User selectOne(String userId) throws DataAccessException{

		return null;
	}

    // Userテーブルの全データを取得.
    @Override
    public List<User> selectMany() throws DataAccessException {

        // M_USERテーブルのデータを全件取得
        List<Map<String, Object>> getList = jdbc.queryForList("SELECT * FROM m_user");

        // 結果返却用の変数
        List<User> userList = new ArrayList<>();

        // 取得したデータを結果返却用のListに格納していく
        for (Map<String, Object> map : getList) {

            //Userインスタンスの生成
            User user = new User();

            // Userインスタンスに取得したデータをセットする
            user.setUserId((String) map.get("user_id")); //ユーザーID
            user.setPassword((String) map.get("password")); //パスワード
            user.setUserName((String) map.get("user_name")); //ユーザー名
            user.setBirthday((Date) map.get("birthday")); //誕生日
            user.setAge((Integer) map.get("age")); //年齢
            user.setSex((Boolean) map.get("sex")); //結婚ステータス
            user.setRole((String) map.get("role")); //ロール

            //結果返却用のListに追加
            userList.add(user);
        }

        return userList;
    }

	@Override
	public int updateOne(User user) throws DataAccessException{

		return 0;
	}

	@Override
	public int deleteOne(String UserId) throws DataAccessException{

		return 0;
	}

	@Override
	public void userCsvOut() throws DataAccessException{

	}

}
