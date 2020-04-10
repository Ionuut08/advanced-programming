package com.ionut.project.jdbc;

import com.ionut.project.jdbc.DatabaseConnectionManager;
import com.sun.security.jgss.GSSUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCExecutor {

    public static void main(String[] args) throws SQLException {
        DatabaseConnectionManager connectionManager = DatabaseConnectionManager.getInstance();
        try {
            /* Establishing the connection */
            Connection connection = connectionManager.getConnection();

            /* PERFORMING CRUD OPERATIONS */

            AlbumDAO albumDAO = new AlbumDAO(connection);

            Album album = new Album();
            album.setId(34);
            album.setName("The Spring Goes Along With i");
            album.setReleaseYear(1990);
            album.setArtistId(26);

            album = albumDAO.create(album);
            System.out.println(album);
            album = albumDAO.findById(album.getId());
            System.out.println(album.toString());
            album.setReleaseYear(1916);
            album = albumDAO.update(album);
            System.out.println(album.toString());
            albumDAO.delete(album.getId());

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
