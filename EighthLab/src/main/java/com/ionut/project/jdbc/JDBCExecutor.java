package com.ionut.project.jdbc;

import com.github.javafaker.Faker;
import com.ionut.project.jdbc.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class JDBCExecutor {

    public static void main(String[] args) throws SQLException {
        DatabaseConnectionManager connectionManager = DatabaseConnectionManager.getInstance();
        try {
            /* Establishing the connection */
            Connection connection = connectionManager.getConnection();

            AlbumDAO albumDAO = new AlbumDAO(connection);

            Album album = new Album();
            for (int i = 6; i < 20; i++) {
                album.setId(i);

                Faker faker = new Faker();
                String fakeAlbumName = faker.name().firstName();
                Date fakeAlbumReleaseYear = faker.date().birthday();

                album.setName(fakeAlbumName);
                album.setReleaseYear((int)(fakeAlbumReleaseYear).getTime());
                album.setArtistId(i);
                albumDAO.create(album);
            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
