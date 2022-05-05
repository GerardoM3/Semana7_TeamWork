
package Ejercicios;

import java.sql.*;

public class ConexionCRUD {
    //Marjorie Beatriz Ramírez Morales
    
    private final String servidor = "jdbc:mysql://localhost:3306/bd_estudiantes";
    private final String usuario = "root";
    private final String clave = "";
    private final String driverConector = "com.mysql.jdbc.Driver";
    private static Connection conexion;
    
    public ConexionCRUD(){
        try{
            Class.forName(driverConector);
            conexion = DriverManager.getConnection(servidor, usuario, clave);
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Conexión fallida! Error!: " + e.getMessage());
        }
    }
    //Marjorie Beatriz Ramírez Morales
    public Connection getConnection(){
        return conexion;
    }
    
    // Morena Guadalupe Peña Flores
    public void guardaeRegistros(String tabla, String camposTabla, String valoresCampos) {
        
        ConexionCRUD conectar = new ConexionCRUD();
        Connection cone = conectar.getConnection();
        try{
            
            String sqlQueryStmt = "INSERT INTO " + tabla + " (" + camposTabla + ") VALUE (" +valoresCampos + "); ";
            
            Statement stmt;
            stmt = cone.createStatement();
            stmt.executeUpdate(sqlQueryStmt);
            
            stmt.close();
            stmt.close();
            System.out.println("Registro guadado correctamente!");
        }catch(Exception e){
            System.out.println(e.getMessage());
                       
        }  
    }
    
    // Morena Guadalupe Peña Flores
    public void actualizarEliminarRegistro(String tabla, String valoresCamposNuevos, String condicion){
        
        ConexionCRUD conectar = new ConexionCRUD();
        Connection cone = conectar.getConnection();
        try{
            Statement stmt;
            String sqlQueryStmt;
            
            if(valoresCamposNuevos.isEmpty()){
                sqlQueryStmt = "DELETE FROM " + tabla +" WHERE " + condicion + ";";
            }else{
              sqlQueryStmt = " UPDATE " +tabla + " SET " + valoresCamposNuevos + " WHERE " + condicion +";";
            }
            stmt = cone.createStatement();
            stmt.executeUpdate(sqlQueryStmt);
            stmt.close();
            stmt.close();
        }catch(SQLException ex) {
            System.out.println("Ha ocurrido el siguiente error: " + ex.getMessage());
            
            
        }
    }
    
    //Gerardo Misael Monroy Moza
    public void desplegarRegistros(String tablaBuscar, String camposBuscar, String condicionBuscar) throws SQLException{
        ConexionCRUD conectar = new ConexionCRUD();
        Connection cone = conectar.getConnection();
        try{
            Statement stmt;
            String sqlQueryStmt;
            if(condicionBuscar.equals("")){
                sqlQueryStmt = "SELECT " + camposBuscar + " FROM " + tablaBuscar + ";";
            }else{
                sqlQueryStmt = "SELECT " + camposBuscar + " FROM " + tablaBuscar + " WHERE " + condicionBuscar + ";";
            }
            
            stmt = cone.createStatement();
            stmt.executeQuery(sqlQueryStmt);
            
            try(ResultSet miResultSet = stmt.executeQuery(sqlQueryStmt)){
                if(miResultSet.next()){
                    ResultSetMetaData metaData = miResultSet.getMetaData();
                    int numColumnas = metaData.getColumnCount();
                    System.out.println("<< REGISTROS ALMACENADOS >>");
                    System.out.println();
                    
                    for(int i = 1; i <= numColumnas; i++){
                        System.out.printf("%-20s\t", metaData.getColumnName(i));
                    }
                    System.out.println();
                    do{
                        for(int i = 1; i <= numColumnas; i++){
                            System.out.printf("%-20s\t", miResultSet.getObject(i));
                        }
                        System.out.println();
                    } while(miResultSet.next());
                    System.out.println();
                }else{
                    System.out.println("No se han encontrado registros");
                }
                miResultSet.close();
            }finally{
                stmt.close();
                cone.close();
            }
        }catch(SQLException ex){
            System.out.println("Ha ocurrido el siguiente error: " + ex.getMessage());
        }
    }
    
}
