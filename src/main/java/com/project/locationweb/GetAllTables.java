package com.project.locationweb;

import com.project.locationweb.util.DBTablePrinterUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class GetAllTables {

    public void printAllTablesFromDatabase() throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/locationdb", "root", "sevo1389");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Just pass the connection and the table name to printTable()
        DBTablePrinterUtil.printTable(conn, "locations");

        // COMPANY DB->
        List<String> tableNames = new ArrayList<String>();
        //Getting the connection
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/companydb", "root", "sevo1389");
        //Creating a Statement object
        Statement stmt = con.createStatement();
        //Retrieving the data
        ResultSet rs = stmt.executeQuery("SHOW TABLES");
        System.out.println("Tables in the current database: ");
        while (rs.next()) {
            System.out.print(rs.getString(1));
            System.out.println();
            tableNames.add(rs.getString(1));
        }

        Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/companydb", "root", "sevo1389");
        Statement stmt1 = conn1.createStatement();
        for (int i = 0; i < tableNames.size(); i++) {
            System.out.println(tableNames.get(i).toUpperCase(Locale.ROOT));
            DBTablePrinterUtil.printTable(conn1, tableNames.get(i));
        }
    }
}
