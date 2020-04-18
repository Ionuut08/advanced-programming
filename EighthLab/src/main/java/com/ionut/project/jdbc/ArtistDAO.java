package com.ionut.project.jdbc;

import com.ionut.project.jdbc.util.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ArtistDAO extends DataAccessObject<Artist> {

    private static final String insert = "INSERT INTO artists (id, name, country)" +
            "VALUES (DEFAULT, ?, ?)";
    private static final String getByName = "SELECT id, name, country FROM artists where name=?";

    public ArtistDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Artist create(Artist dto) {
        try (PreparedStatement statement = this.connection.prepareStatement(insert)) {
            statement.setString(1, dto.getName());
            statement.setString(2, dto.getCountry());
            statement.execute();
            int id = this.getLastValue(artistSequence);
            return this.findByName(getByName);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Artist findByName(String name) {

        Artist artist = new Artist();
        try (PreparedStatement statement = this.connection.prepareStatement(getByName)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                artist.setId(resultSet.getInt("id"));
                artist.setName(resultSet.getString("name"));
                artist.setCountry(resultSet.getString("country"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return artist;
    }

    @Override
    public Artist findByArtist(int dto) {
        return null;
    }

    @Override
    public Artist findById(int id) {
        return null;
    }

    @Override
    public List<Artist> findAll() {
        return null;
    }

    @Override
    public Artist update(Artist dto) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

}
