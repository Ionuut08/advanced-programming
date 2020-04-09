package com.ionut.project.jdbc;

import com.ionut.project.jdbc.util.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlbumDAO extends DataAccessObject<Album> {

    private static final String insert = "INSERT INTO albums (id, name, artist_id, release_year)" +
            "VALUES (?, ?, ?, ?)";
    private static final String getByArtist = "SELECT name, artist_id from albums WHERE artist_id = ?";

    public AlbumDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Album create(Album dto) {
        try (PreparedStatement statement = this.connection.prepareStatement(insert)) {
            statement.setInt(1, dto.getId());
            statement.setString(2, dto.getName());
            statement.setInt(3, dto.getArtistId());
            statement.setInt(4, dto.getReleaseYear());
            statement.execute();
            int id = this.getLastValue(albumSequence);
            return this.findById(id);
//            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Album findByName(String dto) {
        return null;
    }

    @Override
    public Album findByArtist(int id) {

        Album album = new Album();
        try (PreparedStatement statement = this.connection.prepareStatement(getByArtist)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                album.setId(resultSet.getInt("artist_id"));
                album.setName(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return album;
    }

    @Override
    public Album findById(int id) {
        return null;
    }
}
