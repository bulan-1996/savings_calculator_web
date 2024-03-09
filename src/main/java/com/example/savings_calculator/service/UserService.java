package com.example.savings_calculator.service;

import javax.sql.DataSource;

import org.springframework.stereotype.Service;

import com.example.savings_calculator.dto.UserDTO;
import com.example.savings_calculator.entity.User;
import com.example.savings_calculator.repository.UserRepository;

/**
 *  UserテーブルService
 */
@Service
public class UserService {
	private final UserRepository userRepository;
	private final DataSource dataSource;
//	private final JdbcTemplate jdbcTemplate;
	
	// userRepositoryインスタンスを注入
	public UserService(UserRepository userRepository, DataSource dataSource) {
        this.userRepository = userRepository;
        this.dataSource = dataSource;
//        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
	// ユーザー情報をデータベースに保存する処理
	public void saveUser(UserDTO userDTO) {
		String email = userDTO.getEmail();
		User existingUser = userRepository.findByEmail(email);
		
		if (existingUser != null) {
			// 既にユーザーが存在する場合、更新処理を行う
			existingUser.setDisplayName(userDTO.getDisplayName());
            existingUser.setEmailVerified(userDTO.getEmailVerified());
            existingUser.setUid(userDTO.getUid());
            userRepository.save(existingUser);
		} else {
			// 新規追加
			User user = new User();
	        user.setDisplayName(userDTO.getDisplayName());
	        user.setEmail(userDTO.getEmail());
	        user.setEmailVerified(userDTO.getEmailVerified());
	        user.setUid(userDTO.getUid());
	        userRepository.save(user);
		}
    }
	// emailアドレスの情報からuserテーブル情報を取得
	public UserDTO getUserByEmail(String email) {
		// Userテーブルからemailアドレスでidを取得する処理を実装
		User user = userRepository.findByEmail(email);
		return convertToDto(user);
	}
	/**
	 * UserオブジェクトからUserDTOに変換
	 * @param user
	 * @return
	 */
	private UserDTO convertToDto(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setDisplayName(user.getDisplayName());
		userDTO.setEmail(user.getEmail());
		userDTO.setEmailVerified(user.getEmailVerified());
		userDTO.setUid(user.getUid());
		return userDTO;
	}
	
	// 他のビジネスロジックやデータベース操作のメソッドもここに追加する
	// 直接SQLクエリを実行する例
//    public void executeSqlQuery(String sql) {
//		jdbcTemplate.execute(sql);
//    }
}
