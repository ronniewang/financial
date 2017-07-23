package wang.ronnie.financial.persist.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import wang.ronnie.financial.persist.model.Game;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by ronniewang on 17/7/19.
 */
@Repository
public class GameDao {

    @Autowired
    @Qualifier("gameInsert")
    private SimpleJdbcInsert gameActor;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void insert(Game game) {

        SqlParameterSource paramSource = new MapSqlParameterSource()
                .addValue("person", game.getPerson())
                .addValue("create_time", new Date())
                .addValue("thing", game.getThing())
                .addValue("day", game.getDay())
                .addValue("score", game.getScore());
        gameActor.execute(paramSource);
    }

    public List<Game> findByPerson(String person) {

        String sql = "SELECT * FROM `game` WHERE person = :person";
        SqlParameterSource paramSource = new MapSqlParameterSource().addValue("person", person);
        return namedParameterJdbcTemplate.query(sql, paramSource, new GameRowMapper());
    }

    public void delete(int id) {

        String sql = "DELETE FROM `game` WHERE id = :id";
        SqlParameterSource paramSource = new MapSqlParameterSource()
                .addValue("id", id);
        namedParameterJdbcTemplate.update(sql, paramSource);
    }

    private static class GameRowMapper implements RowMapper<Game> {

        @Override
        public Game mapRow(ResultSet resultSet, int rowNum) throws SQLException {

            Game game = new Game();
            game.setId(resultSet.getInt("id"));
            game.setCreateTime(resultSet.getDate("create_time"));
            game.setPerson(resultSet.getString("person"));
            game.setThing(resultSet.getString("thing"));
            game.setScore(resultSet.getInt("score"));
            game.setDay(resultSet.getDate("day"));
            return game;
        }
    }
}
