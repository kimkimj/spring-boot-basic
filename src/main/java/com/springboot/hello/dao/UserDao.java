package com.springboot.hello.dao;

import com.springboot.hello.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class UserDao {
    //private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    public UserDao(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        //this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    RowMapper<User> rowMapper = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User(rs.getString("id"), rs.getString("name"), rs.getString("password"));
            return user;
        }
    };

    //return type을 void -> int로 변경: UserDao 메소드의 리턴타입과 맞추기 위해
    public int add(User user) {
        return jdbcTemplate.update("INSERT INTO users VALUE(?, ?, ?);", user.getId(), user.getName(), user.getPassword());
    }

    public int deleteById(String id) {
        return jdbcTemplate.update("DELETE FROM users WHERE id = ?", id);
    }

    public int deleteAll() {
        return jdbcTemplate.update("DELETE * FROM users");
    }

    public User findById(String id) throws SQLException {
        /*
         Map<String, String> env = System.getenv();
        Connection c;
        try {
            // DB접속 (ex sql workbeanch실행)
            c = dataSource.getConnection();

            // Query문 작성
            PreparedStatement pstmt = c.prepareStatement("SELECT * FROM users WHERE id = ?");
            pstmt.setString(1, id);

            // Query문 실행
            ResultSet rs = pstmt.executeQuery();
            User user = null;
            if (rs.next()) {
                user = new User(rs.getString("id"), rs.getString("name"),
                        rs.getString("password"));
            }

            rs.close();
            pstmt.close();
            c.close();

            if (user == null) throw new RuntimeException();

            return user;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
         */
        return this.jdbcTemplate.queryForObject("select * from users where id = ?", rowMapper, id);
    }

    public List<User> selectAll() {
        return jdbcTemplate.query("SELECT * FROM USERS", rowMapper);
    }

    // 이렇게 하면 User 객체를 return 할 수 있다
    public User selectById(String id) {
        return jdbcTemplate.queryForObject("SELECT * FROM USERS WHERE ID = ? ", rowMapper,id);
    }
}