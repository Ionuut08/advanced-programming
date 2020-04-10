package com.ionut.project.jdbc;

import com.ionut.project.jdbc.util.DataAccessObject;
import com.mysql.cj.result.SqlDateValueFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AlbumDAO extends DataAccessObject<Album> {

    private static final String insert = "INSERT INTO albums (id, name, artist_id, release_year)" +
            "VALUES (?, ?, ?, ?)";
    private static final String getByArtist = "SELECT name, artist_id from albums WHERE artist_id = ?";
    private static final String getOne = "SELECT id, name, release_year, artist_id from albums where id = ?";
    private static final String update = "UPDATE albums SET name = ?, " +
            "release_year = ?," +
            "artist_id = ? WHERE id = ?";
    private static final String delete = "DELETE FROM albums where id = ?";

    public AlbumDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Album findById(int id) {

        Album album = new Album();
        try (PreparedStatement statement = this.connection.prepareStatement(getOne);) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                album.setId(resultSet.getInt("id"));
                album.setName(resultSet.getString("name"));
                album.setReleaseYear(resultSet.getInt("release_year"));
                album.setArtistId(resultSet.getInt("artist_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return album;
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
            return this.findById(dto.getId());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
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
    public Album update(Album dto) {
        Album album = null;
        try {
            this.connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        try (PreparedStatement statement = this.connection.prepareStatement(update);) {

            statement.setString(1, dto.getName());
            statement.setInt(2, dto.getReleaseYear());
            statement.setInt(3, dto.getArtistId());
            statement.setInt(4, dto.getId());
            statement.execute();
            /* COMMIT */
            this.connection.commit();
            album = this.findById(dto.getId());
            return album;
        } catch (SQLException e) {
            try {
                /* ROLLBACK */
                this.connection.rollback();
            } catch (SQLException exception) {
                exception.printStackTrace();
                throw new RuntimeException(exception);
            }
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        Album album = null;
        try (PreparedStatement statement = this.connection.prepareStatement(delete)) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Album> findAll() {
        return null;
    }

    @Override
    public Album findByName(String dto) {
        return null;
    }

}
