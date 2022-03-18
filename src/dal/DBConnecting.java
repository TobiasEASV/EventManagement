package dal;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class DBConnecting {
    private static final String PROP_FILE = ".data/database.settings";
    private SQLServerDataSource ds;

    /**
     * reading from a file database.settings. to setup the database.
     * not included in the github repo so to access the database,
     * create a new folder named ".data" if is not there, and include a file called database.settings. (login information is in the rapport.)
     * Set et up like in database.settings.example
     *
     * @throws IOException
     */
    public DBConnecting() throws IOException {
        Properties databaseProperties = new Properties();
        databaseProperties.load(new FileInputStream(PROP_FILE));

        String server = databaseProperties.getProperty("Server");
        String database = databaseProperties.getProperty("Database");
        String user = databaseProperties.getProperty("User");
        String password = databaseProperties.getProperty("Password");

        ds = new SQLServerDataSource();
        ds.setServerName(server);
        ds.setDatabaseName(database);
        ds.setUser(user);
        ds.setPassword(password);
    }

    /**
     *  Get the database connection.
     * @return the database connection.
     * @throws SQLServerException
     */
    public Connection getConnection() throws SQLServerException {
        return ds.getConnection();
    }
}
