package io.datajek.springdata.tennisplayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class PlayerDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    // jdbcTemplate.query(sql, new BeanPropertyRowMapper<Player>(Player.class));:
    // This line uses the jdbcTemplate to execute the SQL query.
    // It returns a list of Player objects by mapping the rows from the database to Player instances using BeanPropertyRowMapper.
    // This mapper maps the columns from the result set to the corresponding fields in the Player class based on their names.
    public List<Player> getAllPlayers() {
        String sql = "SELECT * FROM PLAYER";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Player>(Player.class));
    }

    public Player getPlayerById(int id) {
        String sql = "SELECT * FROM PLAYER WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql,
                new BeanPropertyRowMapper<Player>(Player.class),
                new Object[] {id});
    }

    public int insertPlayer(Player player){
        String sql = "INSERT INTO PLAYER (ID, Name, Nationality, Birth_date, Titles) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                new Object[] {player.getId(), player.getName(), player.getNationality(),
                        new Timestamp(player.getBirthDate().getTime()), player.getTitles()});
    }
}
