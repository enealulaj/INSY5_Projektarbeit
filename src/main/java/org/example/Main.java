package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
    private static final String DB_URL = "jdbc:postgresql://aws-0-eu-central-1.pooler.supabase.com:5432/postgres?user=postgres.ntewwobeaagyupptwqqz&password=en3aL!NSY$";
    private static final String DB_USER = "enelul18@htl-shkoder.com";
    private static final String DB_PASSWORD = "en3aL!NSY$";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String query = "SELECT title, description, published_at FROM books ORDER BY title ASC";

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            System.out.println("List of Books:");
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                String publishedAt = resultSet.getString("published_at");

                System.out.printf("Title: %s, Description: %s, Published At: %s%n",
                        title, description, publishedAt);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }
}