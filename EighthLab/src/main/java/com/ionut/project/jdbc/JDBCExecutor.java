package com.ionut.project.jdbc;

import com.ionut.project.jdbc.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCExecutor {

    public static void main(String[] args) throws SQLException {
        DatabaseConnectionManager connectionManager = DatabaseConnectionManager.getInstance();
        try {
            /* Establishing the connection */
            Connection connection = connectionManager.getConnection();

            /* Testing the insert method */
            /* Album */

            AlbumDAO albumDAO = new AlbumDAO(connection);
//
//            Album album = new Album();
//            album.setId(5);
//            album.setName("The Summer");
//            album.setReleaseYear(1717);
//            album.setArtistId(5);
//            albumDAO.create(album);

            /* Artist */

//            ArtistDAO artistDAO = new ArtistDAO(connection);
//
//            Artist artist = new Artist();
//            artist.setName("Mozart");
//            artist.setCountry("Italy");
//            artistDAO.create(artist);



            /* Testing findByArtist method */

            /* Album */

//            Album album = albumDAO.findByArtist(4);
//            System.out.println(album.getName());

            /* Artist*/

//            Artist artist = artistDAO.findByName("Ionut");
//            System.out.println(artist.getId());
//            System.out.println(artist.getCountry());

            /* Closing the connection */

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
