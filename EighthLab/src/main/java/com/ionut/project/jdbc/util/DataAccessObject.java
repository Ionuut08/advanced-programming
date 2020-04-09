package com.ionut.project.jdbc.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DataAccessObject <T extends DataTransferObject> {

    protected final Connection connection;
    protected final static String LAST_VAL = "SELECT LAST_INSERT_ID() FROM";
    protected final static String artistSequence = "artistSeq";
    protected final static String albumSequence = "albumSeq";


    public DataAccessObject(Connection connection) {
        super();
        this.connection = connection;
    }

    public abstract T create(T dto);
    public abstract T findByName(String dto);
    public abstract T findByArtist(int dto);
    public abstract T findById(int id);

    protected int getLastValue(String sequence) {
        int key = 0;
        String sql = LAST_VAL + sequence;

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                key = resultSet.getInt(1);
            }
            return key;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
