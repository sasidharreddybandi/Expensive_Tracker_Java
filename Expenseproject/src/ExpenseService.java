import javax.xml.transform.Result;
import java.sql.*;
import java.util.Scanner;

public class ExpenseService {

    public void addexpence(){
        Scanner sc=new Scanner(System.in);
        try(Connection con=Databaseconnection.getConnection()) {

            System.out.print("Enter amount:");
            double amount=sc.nextDouble();
            if(amount <=0){
                throw new Exception("Amount must be positive!");
            }

            System.out.println("Enter category:");
            String Category=sc.next();
            Date date=new Date(System.currentTimeMillis());

            String query="INSERT INTO expense(amount,category,date)values(?,?,?)";

        //Executes parameterized SQL queries (recommended for security and performance).
            PreparedStatement ps=con.prepareStatement(query);
            ps.setDouble(1,amount);
            ps.setString(2, Category);
            ps.setDate(3,java.sql.Date.valueOf(date.toLocalDate()));

            ps.execute();
            System.out.println("Expense added successfully!");
        } catch (SQLException e) {
            System.out.println(("Error:" + e.getMessage()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public void viewexpence() throws Exception {
        try(Connection con=Databaseconnection.getConnection()){


            String query="select * from expense" +
                    "";
            Statement stm=con.createStatement();
            ResultSet rs= stm.executeQuery(query);

            while(rs.next()){
                System.out.println(
                        rs.getDouble("amount")+"|"+
                        rs.getString("Category")+"|"+
                        rs.getDate("date")+"|"+
                        rs.getInt("id_no"));


            }
        } catch (Exception e) {
            System.out.println("Error:"+" "+e.getMessage());
        }

    }
    public void generatereport(){
        try(Connection con=Databaseconnection.getConnection()) {

            String query="select category,sum(amount) as total from expense group by category";
            //Statement is an interface in JDBC that is used to execute simple SQL queries that do not require input parameters.
            Statement st= con.createStatement();
            //ResultSet
            //Holds data returned by a query.
            ResultSet rs=st.executeQuery(query);

            System.out.println("\n ---monthly Report---");
            while (rs.next()) {
                System.out.println(
                        rs.getString("category") + " : " +
                                rs.getDouble("total")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println("Error:"+" "+e.getMessage());
        }


    }

}
