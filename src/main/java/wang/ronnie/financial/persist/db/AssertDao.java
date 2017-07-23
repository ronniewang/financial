package wang.ronnie.financial.persist.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import wang.ronnie.financial.persist.model.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by ronniewang on 17/7/19.
 */
@Repository
public class AssertDao {

    @Autowired
    @Qualifier("assertInsert")
    private SimpleJdbcInsert insertActor;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void insert(Assert a) {

        SqlParameterSource paramSource = new MapSqlParameterSource()
                .addValue("amount", a.getAmount())
                .addValue("create_time", new Date())
                .addValue("update_time", new Date())
                .addValue("create_user", a.getCreateUser())
                .addValue("update_user", a.getUpdateUser())
                .addValue("name", a.getName())
                .addValue("month", a.getMonth())
                .addValue("year", a.getYear())
                .addValue("type", a.getType());
        insertActor.execute(paramSource);
    }

    public void delete(int id) {

        String sql = "DELETE FROM `assert` WHERE id = :id";
        SqlParameterSource paramSource = new MapSqlParameterSource()
                .addValue("id", id);
        namedParameterJdbcTemplate.update(sql, paramSource);
    }

    public List<Assert> findById(int id) {

        String sql = "SELECT * FROM `assert` WHERE id = :id";
        SqlParameterSource paramSource = new MapSqlParameterSource().addValue("id", id);
        return namedParameterJdbcTemplate.query(sql, paramSource, new AssertRowMapper());
    }

    private static class AssertRowMapper implements RowMapper<Assert> {

        @Override
        public Assert mapRow(ResultSet resultSet, int rowNum) throws SQLException {

            Assert a = new Assert();
            a.setId(resultSet.getInt("id"));
            a.setAmount(resultSet.getInt("amount"));
            a.setCreateTime(resultSet.getDate("create_time"));
            a.setUpdateTime(resultSet.getDate("update_time"));
            a.setCreateUser(resultSet.getString("create_user"));
            a.setUpdateUser(resultSet.getString("update_user"));
            a.setName(resultSet.getString("name"));
            a.setMonth(resultSet.getInt("month"));
            a.setYear(resultSet.getInt("year"));
            a.setType(resultSet.getInt("type"));
            return a;
        }
    }
}
