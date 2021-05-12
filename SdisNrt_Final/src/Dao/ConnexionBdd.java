/*
 * Classe de connexion à la base de données mysql Test
 * 20/03/2021
 * author : Garbaciak
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnexionBdd {
    
    public static Connection connection=null;
    public static Statement st=null;
    public static ResultSet rs=null;
  
   
    
    // Méthode de création et d'ouverture de la connexion
    public static Connection ouvrirConnexion() {
        try {
            String url= "jdbc:mysql://localhost:3306/sdisnrt1";
            String user ="SdisNrt1";
            String mdp= "SdisNrt1";
            Class.forName("com.mysql.jdbc.Driver");     
            connection= DriverManager.getConnection(url,user,mdp);
       
            
            System.out.println("Connexion OK");
           
        } catch (SQLException ex) {
            System.out.println("Error " + ex.getMessage());
        }
        catch(ClassNotFoundException ex){
        System.out.println("Error " + ex.getMessage());
        }

    finally{
    return connection;

}
    }
        public ResultSet searchQuery(String sql){
            try{
                ouvrirConnexion();
                st=connection.createStatement();
                rs=st.executeQuery(sql);
            }
            catch(SQLException ex){
                System.out.println("Error " +ex.getMessage());
            }
            return rs;
        }
        public int UpdateQuery(String sql){
            int resultatUpdate= -1;
             try{
                ouvrirConnexion();
                st=connection.createStatement();
                resultatUpdate =st.executeUpdate(sql);
            }
            catch(SQLException ex){
                System.out.println("Error " +ex.getMessage());
            }
            return resultatUpdate;
        }
        
        

    
    // Méthode de fermeture du resultset
    public static void fermerConnexion(ResultSet rs)
    {
        if(rs!=null)
        {
            try
            {
                rs.close();
                 }
            catch(Exception e)
            {
        	System.out.println("Erreur lors de la fermeture d’une connexion dans fermerConnexion(ResultSet)");
            }
        }
    }

    // Méthode de fermeture du statement
    public static void fermerConnexion(Statement stmt)
    {
        if(stmt!=null)
        {
            try
            {
                stmt.close();
            }
            catch(Exception e)
            {
                System.out.println("Erreur lors de la fermeture d’une connexion dans fermerConnexion(Statement)");
            }
        }
    }

    /// Méthode de fermeture de la connexion
    public static void fermerConnexion(Connection con)
    {
        if(con!=null)
        {
            try
            {
                con.close();
                System.out.println("Fermeture Connexion OK");
            }
            catch(Exception e)
            {
                System.out.println("Erreur lors de la fermeture d’une connexion dans fermerConnexion(Connection)");
            }
        }
    }
}
  
