package ResourceSQL;

import java.sql.*;

public class Main {

    //Variables globales para facilitar la conexión
    private static Statement st = null;
    private static PreparedStatement prst = null;
    private static Connection con;
    private static final String CONEXIONURL = "jdbc:mysql://dns11036.phdns11.es";

    public static void main(String[] args) {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(CONEXIONURL, "falbinana", "87654321");

            if (con != null) {

                System.out.println("Conexion a base de datos correcta.");
                System.out.println(con.toString());
                //CON UN STATETMENT NORMAL BÁSICO
                st = con.createStatement();
                //String[] campos = {"id int PRIMARY KEY AUTO_INCREMENT,", "nombre varchar(255),", "apellidos varchar(255),", "edad int"};
                //crearTabla("falbinana", campos); //Crea la tabla con el nombre y el array de los campos
                insertarDatos();  // Inserta datos en la tabla de una vez
                //insertarDatosArray(st); //Inserta los datos
                //st.executeUpdate("DELETE FROM ad2223.falbinana");  //Aqui borro los datos de la tabla y la dejo vacia

                //CON UN PREPARESTATEMENT
                /*prst = con.prepareStatement("SELECT nombre, apellidos FROM ad2223.falbinana WHERE nombre like ? ORDER BY apellidos");
                prst.setString(1, "J%");
                querySQL(prst);*/

            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Precondiciones: Debe haber conexión con el gestor de BBDD para que funcione.
     * Método para cambiar la contraseña de la BBDD.
     * Postcondiciones: La constraseña se cambia por la nueva
     */
    public static void cambiarPassword (){
        try {
            st = con.createStatement();
            st.executeUpdate("SET PASSWORD FOR 'falbinana'@'%' = password('87654321')");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Precondiciones: Debe haber conexión con el gestor de BBDD para que funcione.
     * Método para crear una tabla en una base de datos SQL.
     * @param tabla String de entrada con el nombre de la tabla.
     * @param nombresCampos String de entrada con los nombres de los campos.
     * Postcondiciones: La tabla se crea en la base de datos.
     */
    public static void crearTabla(String tabla, String[] nombresCampos) {

        String create = "CREATE TABLE ad2223." + tabla + " (";


        for (int i = 0; i < nombresCampos.length; i++) {
            create += nombresCampos[i];
        }
        create += ")";

        System.out.println(create);
        try {
            st = con.prepareStatement(create);
            st.executeUpdate(create);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Precondiciones: Debe haber conexión con el gestor de BBDD para que funcione.
     * Método para insertar datos en la BBDD con un solo INSERT
     * Postcondiciones: La tabla se llena con todos los datos aportados.
     */
    public static void insertarDatos (){
        String datos = "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Kellsie', 'Daskiewicz', 55)," +
                " ('Alvina', 'Farragher', 78)," +
                " ('Emmalee', 'Macewan', 54)," +
                " ('Lizzy', 'Cosstick', 89)," +
                " ('Saundra', 'Huzzay', 28)," +
                " ('Clementine', 'Mouncher', 24)," +
                " ('Nathalie', 'Garmons', 81)," +
                " ('Ortensia', 'Crassweller', 99)," +
                " ('Star', 'Pugh', 77)," +
                " ('Fina', 'Magnar', 15)," +
                " ('Virgilio', 'Gosnold', 78)," +
                " ('Phelia', 'Mapes', 75)," +
                " ('Terry', 'Slany', 84)," +
                " ('Cassie', 'Keane', 39)," +
                " ('Waylen', 'Samwyse', 31)," +
                " ('Bernetta', 'Pechard', 40)," +
                " ('Didi', 'Dunmore', 51)," +
                " ('Carmelina', 'Willan', 80)," +
                " ('Merilyn', 'Tremmel', 47)," +
                " ('Ilyssa', 'Noen', 25)," +
                " ('Gleda', 'Thome', 96)," +
                " ('Vivian', 'Segge', 94)," +
                " ('Arvin', 'Camous', 82)," +
                " ('Gay', 'Gallaway', 67)," +
                " ('Grannie', 'Aldins', 92)," +
                " ('Lily', 'Castanares', 34)," +
                " ('Maureen', 'Licciardo', 36)," +
                " ('Lynett', 'Agiolfinger', 23)," +
                " ('Sapphira', 'Audibert', 35)," +
                " ('Kara', 'Giannoni', 99)," +
                " ('Jeri', 'Gerardot', 55)," +
                " ('Merci', 'Simonnot', 23)," +
                " ('Fitzgerald', 'Cowlard', 13)," +
                " ('Francene', 'Benedick', 23)," +
                " ('Carlie', 'Serrell', 37)," +
                " ('Davine', 'Antoszewski', 28)," +
                " ('Shirlee', 'Woodthorpe', 70)," +
                " ('Jo-anne', 'Shardlow', 45)," +
                " ('Marcille', 'Zarfat', 16)," +
                " ('Adora', 'Calbert', 30)," +
                " ('Lotte', 'Klarzynski', 81)," +
                " ('Sigismond', 'Hartrick', 35)," +
                " ('Darrell', 'Pretor', 65)," +
                " ('Demetre', 'Isakovitch', 36)," +
                " ('Ted', 'Aldcorne', 95)," +
                " ('Deanne', 'Swanwick', 41)," +
                " ('Rozanna', 'Ripping', 49)," +
                " ('Derwin', 'Karlmann', 97)," +
                " ('Ilka', 'Kemston', 76)," +
                " ('Tymon', 'Weepers', 50)," +
                " ('Grata', 'Izaks', 69)," +
                " ('Enrico', 'McParlin', 25)," +
                " ('Corella', 'Patient', 42)," +
                " ('Julio', 'Esel', 38)," +
                " ('Shelia', 'Mee', 99)," +
                " ('Veriee', 'Ormiston', 21)," +
                " ('Hanni', 'Burless', 75)," +
                " ('Charlton', 'Doyland', 56)," +
                " ('Trudie', 'Gomer', 26)," +
                " ('Hamlin', 'Gerrish', 73)," +
                " ('Silva', 'Ainger', 45)," +
                " ('Kristen', 'Cornfield', 66)," +
                " ('Caz', 'Rushman', 89)," +
                " ('Tyrus', 'Bryenton', 40)," +
                " ('Niels', 'Pilbeam', 100)," +
                " ('Amalea', 'Newband', 61)," +
                " ('Chantal', 'Bedinn', 38)," +
                " ('Guy', 'Martinez', 77)," +
                " ('Seumas', 'Gorden', 50)," +
                " ('Desiri', 'Croot', 52)," +
                " ('Sissy', 'Ferrie', 41)," +
                " ('Anallese', 'Strelitzer', 78)," +
                " ('Ernesta', 'Hinrich', 68)," +
                " ('Wye', 'Gilbart', 94)," +
                " ('Scotti', 'Kira', 85)," +
                " ('Jerrine', 'Parkyn', 75)," +
                " ('Heida', 'Pfeuffer', 12)," +
                " ('Paulie', 'Lots', 94)," +
                " ('Coleen', 'Beetham', 59)," +
                " ('Cami', 'Danelutti', 52)," +
                " ('Marley', 'Matteuzzi', 61)," +
                " ('Nickolaus', 'Snoxell', 77)," +
                " ('Chiarra', 'Blencowe', 69)," +
                " ('Rafaellle', 'Jarratt', 24)," +
                " ('Timotheus', 'Mariner', 15)," +
                " ('Karolina', 'Harbage', 82)," +
                " ('Kaiser', 'Morville', 96)," +
                " ('Stephanus', 'Stiggles', 39)," +
                " ('Nickolaus', 'Carmichael', 18)," +
                " ('Linet', 'Nabarro', 57)," +
                " ('Yorker', 'Bonnell', 29)," +
                " ('Bernadene', 'Filchakov', 95)," +
                " ('Denyse', 'Collens', 79)," +
                " ('Kev', 'Stoffer', 89)," +
                " ('Cairistiona', 'Rowatt', 40)," +
                " ('Patton', 'Hise', 53)," +
                " ('Melodee', 'Calver', 29)," +
                " ('Adelind', 'Jiracek', 30)," +
                " ('Jakob', 'Bleazard', 51)," +
                " ('Chris', 'Allward', 56)," +
                " ('Olwen', 'Janson', 84)," +
                " ('Harrie', 'Kilpatrick', 21)," +
                " ('Tymon', 'Sondland', 27)," +
                " ('Ari', 'Chaize', 69)," +
                " ('Devland', 'Berrill', 95)," +
                " ('Shayne', 'Synnott', 85)," +
                " ('Arleyne', 'Anyene', 85)," +
                " ('Cindy', 'Whelpton', 31)," +
                " ('Shela', 'Dreng', 57)," +
                " ('Henrietta', 'Ahmad', 39)," +
                " ('Brooke', 'Casarili', 38)," +
                " ('Liuka', 'Climson', 12)," +
                " ('Eulalie', 'Sexty', 75)," +
                " ('Reyna', 'Semiraz', 64)," +
                " ('Talyah', 'Jollye', 88)," +
                " ('Lena', 'Alldis', 57)," +
                " ('Cyril', 'Domenico', 94)," +
                " ('Candida', 'Orhrt', 46)," +
                " ('Jackelyn', 'Claris', 98)," +
                " ('Terence', 'Kinner', 16)," +
                " ('Maddi', 'Jackalin', 20)," +
                " ('Opaline', 'Ballsdon', 46)," +
                " ('Timmie', 'Whetnell', 80)," +
                " ('Leon', 'Farnes', 86)," +
                " ('Cecil', 'Lawton', 94)," +
                " ('Sofia', 'Bavin', 80)," +
                " ('Sly', 'Garlant', 64)," +
                " ('Charissa', 'Slater', 22)," +
                " ('Reuven', 'Goforth', 76)," +
                " ('Max', 'Bier', 62)," +
                " ('Avrom', 'Redparth', 26)," +
                " ('Betty', 'Harlin', 52)," +
                " ('Sheff', 'McEntagart', 31)," +
                " ('Mischa', 'McCready', 55)," +
                " ('Meghan', 'Clemes', 53)," +
                " ('Roanne', 'Langabeer', 95)," +
                " ('Michel', 'Scholling', 37)," +
                " ('Ethan', 'Morley', 13)," +
                " ('Clea', 'Lembrick', 61)," +
                " ('Skye', 'Gutierrez', 16)," +
                " ('Elisa', 'Ferrarello', 59)," +
                " ('Rainer', 'Stayt', 33)," +
                " ('Natalie', 'Alenov', 61)," +
                " ('Lin', 'Seabridge', 15)," +
                " ('Jobye', 'Eary', 51)," +
                " ('Thomasa', 'Spellsworth', 74)," +
                " ('Latia', 'O''Lunney', 48)," +
                " ('Rivi', 'Klimmek', 32)," +
                " ('Michaela', 'Gorrie', 61)," +
                " ('Cindie', 'Trustie', 12)," +
                " ('Artur', 'Bunny', 80)," +
                " ('Daryle', 'Gonneau', 17)," +
                " ('Joly', 'Iacovo', 99)," +
                " ('Mano', 'Jubb', 19)," +
                " ('Dylan', 'Coughtrey', 63)," +
                " ('Mattie', 'McArtan', 99)," +
                " ('Dalenna', 'Celli', 16)," +
                " ('Chelsea', 'Bonehill', 37)," +
                " ('Giffard', 'Beal', 98)," +
                " ('Daven', 'Ellice', 37)," +
                " ('Wolfie', 'Yashnov', 70)," +
                " ('Morganne', 'Santorini', 62)," +
                " ('Melissa', 'Fotitt', 20)," +
                " ('Sheelagh', 'Hegley', 30)," +
                " ('Sloan', 'Ladel', 36)," +
                " ('Cory', 'O''Lennachain', 26)," +
                " ('Marianne', 'Hayley', 34)," +
                " ('Cass', 'Shippam', 27)," +
                " ('Genna', 'Cowdroy', 55)," +
                " ('Legra', 'Border', 30)," +
                " ('Gib', 'Walthall', 31)," +
                " ('Lynde', 'Echallie', 69)," +
                " ('Gusty', 'Rainton', 99)," +
                " ('Jasen', 'Monkley', 49)," +
                " ('Tab', 'Flowers', 88)," +
                " ('Edwin', 'Kirstein', 77)," +
                " ('Vida', 'Tschierasche', 55)," +
                " ('Stanly', 'Kief', 70)," +
                " ('Robbie', 'Poat', 22)," +
                " ('Jakie', 'Mayne', 73)," +
                " ('Grannie', 'Latour', 54)," +
                " ('Karrah', 'Pexton', 15)," +
                " ('Hew', 'Heard', 77)," +
                " ('Penelope', 'Paice', 60)," +
                " ('Blair', 'Gopsall', 92)," +
                " ('Foss', 'Cobbled', 27)," +
                " ('Ari', 'Ferrulli', 45)," +
                " ('Finley', 'Netting', 96)," +
                " ('Danice', 'Brittain', 85)," +
                " ('Arri', 'Jery', 75)," +
                " ('Theo', 'Lob', 28)," +
                " ('Myrtle', 'Kunkel', 32)," +
                " ('Franklyn', 'Perring', 69)," +
                " ('Reilly', 'Fayer', 42)," +
                " ('Daria', 'Wiffield', 19)," +
                " ('Filberto', 'Moxsom', 75)," +
                " ('Lucille', 'Reddy', 73)," +
                " ('Udale', 'Haverty', 65)," +
                " ('Adrianna', 'Lamanby', 47)," +
                " ('Cheston', 'Shirland', 79)";

        try {
            st = con.prepareStatement(datos);
            st.executeUpdate(datos);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Precondiciones: Debe haber conexión con el gestor de BBDD para que funcione.
     * Método para insertar datos en la BBDD con un array de String y múltiples INSERT
     * @param statement Recibe un statement de entrada, pero podría no recibirlo y usar el global. Estaba probando.
     * Postcondiciones: La tabla se llena con todos los datos aportados.
     */
    public static void insertarDatosArray (Statement statement){
        String datos[] = {"insert into ad2223.falbinana (nombre, apellidos, edad) values ('Kellsie', 'Daskiewicz', 55);",
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Alvina', 'Farragher', 78);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Emmalee', 'Macewan', 54);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Lizzy', 'Cosstick', 89);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Saundra', 'Huzzay', 28);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Clementine', 'Mouncher', 24);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Nathalie', 'Garmons', 81);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Ortensia', 'Crassweller', 99);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Star', 'Pugh', 77);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Fina', 'Magnar', 15);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Virgilio', 'Gosnold', 78);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Phelia', 'Mapes', 75);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Terry', 'Slany', 84);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Cassie', 'Keane', 39);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Waylen', 'Samwyse', 31);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Bernetta', 'Pechard', 40);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Didi', 'Dunmore', 51);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Carmelina', 'Willan', 80);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Merilyn', 'Tremmel', 47);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Ilyssa', 'Noen', 25);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Gleda', 'Thome', 96);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Vivian', 'Segge', 94);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Arvin', 'Camous', 82);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Gay', 'Gallaway', 67);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Grannie', 'Aldins', 92);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Lily', 'Castanares', 34);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Maureen', 'Licciardo', 36);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Lynett', 'Agiolfinger', 23);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Sapphira', 'Audibert', 35);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Kara', 'Giannoni', 99);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Jeri', 'Gerardot', 55);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Merci', 'Simonnot', 23);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Fitzgerald', 'Cowlard', 13);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Francene', 'Benedick', 23);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Carlie', 'Serrell', 37);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Davine', 'Antoszewski', 28);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Shirlee', 'Woodthorpe', 70);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Jo-anne', 'Shardlow', 45);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Marcille', 'Zarfat', 16);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Adora', 'Calbert', 30);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Lotte', 'Klarzynski', 81);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Sigismond', 'Hartrick', 35);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Darrell', 'Pretor', 65);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Demetre', 'Isakovitch', 36);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Ted', 'Aldcorne', 95);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Deanne', 'Swanwick', 41);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Rozanna', 'Ripping', 49);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Derwin', 'Karlmann', 97);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Ilka', 'Kemston', 76);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Tymon', 'Weepers', 50);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Grata', 'Izaks', 69);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Enrico', 'McParlin', 25);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Corella', 'Patient', 42);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Julio', 'Esel', 38);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Shelia', 'Mee', 99);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Veriee', 'Ormiston', 21);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Hanni', 'Burless', 75);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Charlton', 'Doyland', 56);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Trudie', 'Gomer', 26);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Hamlin', 'Gerrish', 73);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Silva', 'Ainger', 45);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Kristen', 'Cornfield', 66);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Caz', 'Rushman', 89);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Tyrus', 'Bryenton', 40);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Niels', 'Pilbeam', 100);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Amalea', 'Newband', 61);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Chantal', 'Bedinn', 38);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Guy', 'Martinez', 77);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Seumas', 'Gorden', 50);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Desiri', 'Croot', 52);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Sissy', 'Ferrie', 41);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Anallese', 'Strelitzer', 78);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Ernesta', 'Hinrich', 68);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Wye', 'Gilbart', 94);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Scotti', 'Kira', 85);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Jerrine', 'Parkyn', 75);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Heida', 'Pfeuffer', 12);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Paulie', 'Lots', 94);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Coleen', 'Beetham', 59);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Cami', 'Danelutti', 52);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Marley', 'Matteuzzi', 61);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Nickolaus', 'Snoxell', 77);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Chiarra', 'Blencowe', 69);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Rafaellle', 'Jarratt', 24);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Timotheus', 'Mariner', 15);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Karolina', 'Harbage', 82);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Kaiser', 'Morville', 96);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Stephanus', 'Stiggles', 39);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Nickolaus', 'Carmichael', 18);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Linet', 'Nabarro', 57);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Yorker', 'Bonnell', 29);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Bernadene', 'Filchakov', 95);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Denyse', 'Collens', 79);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Kev', 'Stoffer', 89);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Cairistiona', 'Rowatt', 40);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Patton', 'Hise', 53);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Melodee', 'Calver', 29);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Adelind', 'Jiracek', 30);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Jakob', 'Bleazard', 51);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Chris', 'Allward', 56);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Olwen', 'Janson', 84);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Harrie', 'Kilpatrick', 21);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Tymon', 'Sondland', 27);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Ari', 'Chaize', 69);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Devland', 'Berrill', 95);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Shayne', 'Synnott', 85);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Arleyne', 'Anyene', 85);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Cindy', 'Whelpton', 31);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Shela', 'Dreng', 57);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Henrietta', 'Ahmad', 39);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Brooke', 'Casarili', 38);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Liuka', 'Climson', 12);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Eulalie', 'Sexty', 75);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Reyna', 'Semiraz', 64);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Talyah', 'Jollye', 88);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Lena', 'Alldis', 57);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Cyril', 'Domenico', 94);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Candida', 'Orhrt', 46);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Jackelyn', 'Claris', 98);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Terence', 'Kinner', 16);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Maddi', 'Jackalin', 20);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Opaline', 'Ballsdon', 46);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Timmie', 'Whetnell', 80);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Leon', 'Farnes', 86);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Cecil', 'Lawton', 94);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Sofia', 'Bavin', 80);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Sly', 'Garlant', 64);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Charissa', 'Slater', 22);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Reuven', 'Goforth', 76);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Max', 'Bier', 62);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Avrom', 'Redparth', 26);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Betty', 'Harlin', 52);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Sheff', 'McEntagart', 31);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Mischa', 'McCready', 55);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Meghan', 'Clemes', 53);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Roanne', 'Langabeer', 95);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Michel', 'Scholling', 37);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Ethan', 'Morley', 13);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Clea', 'Lembrick', 61);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Skye', 'Gutierrez', 16);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Elisa', 'Ferrarello', 59);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Rainer', 'Stayt', 33);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Natalie', 'Alenov', 61);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Lin', 'Seabridge', 15);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Jobye', 'Eary', 51);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Thomasa', 'Spellsworth', 74);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Latia', 'O''Lunney', 48);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Rivi', 'Klimmek', 32);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Michaela', 'Gorrie', 61);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Cindie', 'Trustie', 12);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Artur', 'Bunny', 80);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Daryle', 'Gonneau', 17);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Joly', 'Iacovo', 99);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Mano', 'Jubb', 19);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Dylan', 'Coughtrey', 63);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Mattie', 'McArtan', 99);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Dalenna', 'Celli', 16);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Chelsea', 'Bonehill', 37);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Giffard', 'Beal', 98);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Daven', 'Ellice', 37);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Wolfie', 'Yashnov', 70);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Morganne', 'Santorini', 62);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Melissa', 'Fotitt', 20);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Sheelagh', 'Hegley', 30);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Sloan', 'Ladel', 36);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Cory', 'O''Lennachain', 26);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Marianne', 'Hayley', 34);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Cass', 'Shippam', 27);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Genna', 'Cowdroy', 55);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Legra', 'Border', 30);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Gib', 'Walthall', 31);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Lynde', 'Echallie', 69);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Gusty', 'Rainton', 99);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Jasen', 'Monkley', 49);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Tab', 'Flowers', 88);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Edwin', 'Kirstein', 77);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Vida', 'Tschierasche', 55);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Stanly', 'Kief', 70);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Robbie', 'Poat', 22);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Jakie', 'Mayne', 73);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Grannie', 'Latour', 54);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Karrah', 'Pexton', 15);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Hew', 'Heard', 77);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Penelope', 'Paice', 60);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Blair', 'Gopsall', 92);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Foss', 'Cobbled', 27);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Ari', 'Ferrulli', 45);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Finley', 'Netting', 96);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Danice', 'Brittain', 85);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Arri', 'Jery', 75);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Theo', 'Lob', 28);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Myrtle', 'Kunkel', 32);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Franklyn', 'Perring', 69);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Reilly', 'Fayer', 42);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Daria', 'Wiffield', 19);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Filberto', 'Moxsom', 75);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Lucille', 'Reddy', 73);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Udale', 'Haverty', 65);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Adrianna', 'Lamanby', 47);" ,
                "insert into ad2223.falbinana (nombre, apellidos, edad) values ('Cheston', 'Shirland', 79)"};

        try {
            for (int i = 0; i < datos.length; i++) {
                statement.executeUpdate(datos[i]);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Precondiciones: Debe haber conexión con el gestor de BBDD para que funcione.
     * Método para hacer una query a una BBDD SQL que solo necesita recibirla en un String y lo imprime por pantalla.
     * @param sqlSentence Un String de entrada con la query de búsqueda escrita en sql.
     * Postcondiciones: Devuelve los datos de la Query, y los muestra por pantalla normal.
     */
    public static void querySQL (String sqlSentence) {
        ResultSet lista;

        try {
            lista = st.executeQuery(sqlSentence);
            ResultSetMetaData rsmd = lista.getMetaData();
            while(lista.next()) {
                System.out.println(rsmd.getColumnName(1) + ": " + lista.getString(1) + ", " + rsmd.getColumnName(2) + ": " + lista.getString(2));
                //System.out.println(rsmd.getColumnName(1) + ": " + lista.getString(1));
            }
            lista.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Precondiciones: Debe haber conexión con el gestor de BBDD para que funcione.
     * Método para ver los datos ordenador por edad. Usa el método querySQL para ello.
     * Postcondiciones: Presenta por pantalla los datos ordenados por edad.
     * @see public static void querySQL()
     */
    public static void ordenarPorEdad (){
        String sql = "SELECT nombre, edad FROM ad2223.falbinana ORDER BY edad";
        querySQL(sql);
    }

    /**
     * Precondiciones: Debe haber conexión con el gestor de BBDD para que funcione.
     * Método para ver los datos ordenados por apellidos. Usa el método querySQL para ello.
     * Postcondiciones: Presenta por pantalla los datos ordenados por apellido.
     */
    public static void ordenarPorApellidos (){
        String sql = "SELECT nombre, apellidos FROM ad2223.falbinana ORDER BY apellidos";
        querySQL(sql);
    }

    /**
     * Precondiciones: Debe haber conexión con el gestor de BBDD para que funcione.
     * Método para ver los datos de los mayores de 30. Usa el método querySQL para ello.
     * Postcondiciones: Presenta por pantalla los datos de los mayores de 30.
     */
    public static void mayoresDe30 (){
        String sql = "SELECT nombre, edad FROM ad2223.falbinana WHERE edad > 30";
        querySQL(sql);
    }

    /**
     * Precondiciones: Debe haber conexión con el gestor de BBDD para que funcione.
     * Método para ver los datos de las personas cuyos nombres empiezan por J y ordenados por apellidos.
     * Postcondiciones: Presenta por pantalla los datos de las personas cuyos nombres empiezan por J ordenados por apellidos.
     */
    public static void nombresPorJ () {
        String sql = "SELECT nombre, apellidos FROM ad2223.falbinana WHERE nombre like 'J%' ORDER BY apellidos";
        querySQL(sql);
    }

    /**
     * Precondiciones: Debe haber conexión con el gestor de BBDD para que funcione.
     * Método para ver los datos de las personas cuyos nombre y apellidos empiecen por A y C respectivamente ordenados por edad descente.
     * Postcondiciones: Presenta por pantalla los datos de las personas cuyos nombre y apellidos empiecen por A y C respectivamente ordenados por edad descente.
     */
    public static void nombresCapellidosAmayoramenor (){
        String sql = "SELECT nombre, apellidos FROM ad2223.falbinana WHERE nombre like 'A%' and apellidos like 'C%' ORDER BY edad desc";
        querySQL(sql);
    }

    /**
     * Precondiciones: Debe haber conexión con el gestor de BBDD para que funcione.
     * Método para ver la media de edad de todas las personas usando el SELECT con el avg.
     * Postcondiciones: Presenta por pantalla la media de edad de las personas.
     */
    public static void mediaEdad (){
        String sql = "SELECT avg(edad) FROM ad2223.falbinana";
        querySQL(sql);
    }

    /**
     * Precondiciones: Debe haber conexión con el gestor de BBDD para que funcione.
     * Método que busca en la BBDD las personas cuyos nombre y apellidos contengan 'ph' y 'ma' respectivamente.
     * Postcondiciones: Presenta por pantalla las personas cuyos nombre y apellidos contengan 'ph' y 'ma' respectivamente.
     */
    public static void buscaOHyMA (){
        String sql = "SELECT nombre, apellidos FROM ad2223.falbinana WHERE nombre like '%ph%' or apellidos like '%ma%'";
        querySQL(sql);
    }

    /**
     * Precondiciones: Debe haber conexión con el gestor de BBDD para que funcione.
     * Método para buscar a las personas cuya edad esté en la franja de 24 y 32 años.
     * Postcondiciones: Presenta por pantalla las personas cuya edad esté en la franja de 24 y 32 años.
     */
    public static void franjaEdad24y32 (){
        String sql = "SELECT nombre, edad FROM ad2223.falbinana WHERE edad > 23 and edad <33";;
        querySQL(sql);
    }

    /**
     * Precondiciones: Debe haber conexión con el gestor de BBDD para que funcione.
     * Método para buscar en la BBDD a los mayores de 65 años.
     * Postcondiciones: Presenta por pantalla todas las personas mayores de 65 años.
     */
    public static void mayores65 (){
        String sql = "SELECT nombre, edad FROM ad2223.falbinana WHERE edad > 65";
        querySQL(sql);
    }

    /**
     * Precondiciones: Debe haber conexión con el gestor de BBDD para que funcione.
     * Método para agregar una columna 'laboral' con un ENUM de datos como opción después de la columna edad.
     * Postcondiciones: Agrega una columna 'laboral' a mi BBDD con un ENUM de datos.
     */
    public static void crearColumna (){
        String colum = "ALTER TABLE ad2223.falbinana ADD laboral ENUM('Estudiante','Ocupado','Parado','Jubilado') NOT NULL AFTER edad";
        try {
            st.executeUpdate(colum);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Precondiciones: Debe haber conexión con el gestor de BBDD para que funcione.
     * Método para insertar datos en la columna ENUM clasificando a las personas por edades.
     * Postcondiciones: Inserta todos los datos 'laboral' de las personas según su edad.
     */
    public static void actualizarLabolar (){
        String insertEstudiantes = "UPDATE ad2223.falbinana SET laboral = 'Estudiante' WHERE edad < 18";
        String insertOcupados = "UPDATE ad2223.falbinana SET laboral = 'Ocupado' WHERE edad >18 and edad <66 and (edad%2)=0";
        String insertParados = "UPDATE ad2223.falbinana SET laboral = 'Parado' WHERE edad >18 and edad <66 and (edad%2)!=0";
        String insertJubilados = "UPDATE ad2223.falbinana SET laboral = 'Jubilado' WHERE edad > 65";

        try {
            st.executeUpdate(insertEstudiantes);
            st.executeUpdate(insertOcupados);
            st.executeUpdate(insertParados);
            st.executeUpdate(insertJubilados);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}