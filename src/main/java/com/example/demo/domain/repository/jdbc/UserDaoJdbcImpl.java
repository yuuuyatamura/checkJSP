package com.example.demo.domain.repository.jdbc;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.model.User;
import com.example.demo.domain.repository.UserDao;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class UserDaoJdbcImpl implements UserDao{
	
	@Autowired
	JdbcTemplate jdbc;

	//Userテーブルの件数を取得
	@Override
	public int count() throws DataAccessException{
		//ポイント1: Objectの取得
		//全件取得してカウント
		
		int count=jdbc.queryForObject("SELECT COUNT(∗)FROM m_user", Integer.class);
		return count;
	}
	
	//Userテーブルにデータを1件insert
	@Override
	public int insertOne(User user) throws DataAccessException{
		int rowNumber = jdbc.update("INSERT INTO m_user(user_id,"
				+" password,"
				+" user_name,"
				+" birthday,"
				+" age,"
				+" marriage,"
				+" role)"
				+" VALUES(?,?,?,?,?,?,?)"
				, user.getUserId()
				, user.getPassword()
				, user.getUserName()
				, user.getBirthday()
				, user.isMarriage()
				, user.getAge()
				, user.getRole());
				
				return rowNumber;
	}
	
	//Userテーブルのデータを1件取得
	@Override
	public User selectOne(String userId) throws DataAccessException{
		return null;
	}
	
	//Userテーブルのデータを1件取得
	@Override
	public List<User> selectMany() throws DataAccessException{
		//ポイント2:複数件のselect
		//M_USERテーブルのデータを全件取得
		List<Map<String,Object>> getList = jdbc.queryForList("SELECT * FROM m_user");
		
		//結果返却用の変数
		List<User> userList = new ArrayList<>();
		
		//取得したデータを返却用のListに格納していく
		for(Map<String,Object>map:getList) {
			User user =new User();
			
			user.setUserId((String)map.get("user_id"));
			user.setPassword((String)map.get("password"));
			user.setUserName((String)map.get("user_name"));
			user.setBirthday((Date)map.get("birthday"));
			user.setAge((Integer)map.get("age"));
			user.setMarriage((Boolean)map.get("marriage"));
			user.setRole((String)map.get("Role"));
			
			userList.add(user);
		}
			//結果返却用のListに追加
			return userList;
	}
	
	//Userテーブルのデータを1件更新
	@Override
	public int updateOne(User user) throws DataAccessException{
		return 0;
	}

	//1件削除
	@Override
	public int deleteOne(String userId) throws DataAccessException {
		return 0;
	}

	//全テーブルのデータをCSVに出力
	@Override
	public void userCsvOut() throws DataAccessException {	
	}
	
}
