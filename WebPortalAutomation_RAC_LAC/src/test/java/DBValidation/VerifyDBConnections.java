package DBValidation;

import java.sql.Connection;
import java.sql.ResultSet;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.DBUtils;

public class VerifyDBConnections {

    @Test
    public void verifyInvoiceHeaderData() {

        Connection connection = null;

        try {
            connection = DBUtils.getConnection();

            String query =
                    "select top 50 * from AppData_INT_Sales_Invoice_Header order by sih_id desc";

            ResultSet rs = DBUtils.executeQuery(connection, query);

            Assert.assertTrue(rs.next(), "❌ No records found in Invoice Header table");

            while (rs.next()) {
                System.out.println("Invoice No: " + rs.getString(1));
            }

        } catch (Exception e) {
            Assert.fail("❌ DB validation failed", e);
        } finally {
            DBUtils.closeConnection(connection);
        }
    }
}
