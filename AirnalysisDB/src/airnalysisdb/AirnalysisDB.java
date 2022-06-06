/**
 * Software Development Group Project (5COSC003W) 2018/19
 * AirNalysis Project created by Damian Wojtunik, Dimitar Shikrenov and Khalid Osman
 * AirnalysisDB, LineChart classes and elements of PropertiesDisplay class by Damian Wojtunik
 * PropertyTableModel and GUI of PropertiesDisplay by Khalid Osman
 * LoginFrame, RegisterFrame and RetrievePassFrame by Dimitar Shikrenov
 * Connection to the database and SQL logic all present in AirnalysisDB class by Damian Wojtunik
 * 
 * I. Security issues addressed in AirnalysisDB class:
 * 1. Verification if the user is not a bot using CAPTCHA (authenticateCaptcha() method).
 * 1.1. One of the numbers is converted to its written version so a computer cannot process the calculation (convertNumberToText() method).
 * 2. Password encryption and decryption using a shifting algorithm; no password is stored directly in a database,
 * only their encrypted versions (encryptPassword() and decryptPassword() methods).
 * 3. Password authentication during the log in; the account can be accessed only by providing a valid password (authenticatePassword() method).
 * 4. Secret question/answer - during the registration a user is asked to answer a question about the name of their childhood best friend. The answer
 * is then encrypted and can be used to retrieve password. A special method has been created that verified the answer to the question
 * (authoriseSecretQuestion() method).
 * 5. After three failed attempts to log in, the account will be blocked and a password retrieval will be required. To achieve so, there is a static
 * variable AirnalysisDB.failedLogInAttempts that stores the number of failed attempts. Two methods have been created to reset the number of failed 
 * attempts, either if the user logs in successfully after the second or the third time, or if they retrieve the password successfully (resetAttemptsForUsername
 * method() and resetAttemptsForEmail method()). There is also a getter method that allows the system to retrieve information on how many failed attempts occurred.
 * 6. To avoid the possibility of multiple accounts having the same username or e-mail address, there is a method that verifies if the credentials are unique
 * (checkUsernameEmailExists() method).
 * 7. The only information about the user stored for the duration of the program is the user ID, which is a unique identifier of each user in the tables.
 * All the sensitive data is encrypted and stored in a database. To retrieve them, the dedicated methods need to be used such as retrievePassword() used for
 * Password Retrieval.
 * 8. Every log in and log out of each user in time-stamped and the log is saved in the database. In case the program is suddenly closed, there is a method
 * that overrides the closing procedure of the JFrames that first logs the activity in the database and only then does it close the program (logLogInOut() method
 * and exitFrame() method).
 * 
 * 
 * II. Human-Computer Interaction issues addressed in AirnalysisDB:
 * 1. CAPTCHA authorisation's simplicity - it is based on a simple calculation of numbers smaller than 10, where one of the numbers is written as a text;
 * Moreover, the pop-up dialog is clear, neat and visible, while the result can be confirmed not only by pressing a button but also ENTER on a keyboard.
 * 2. Dynamic retrieval of the data presented - there is a special method retrieveMaxReviews that checks the current maximum number of reviews so that the user
 * can choose only from the available numbers. When the program launches, the tables and graph will always be populated.
 * 3. Chart flexibility - regardless of whether a user chooses a range of numbers where the first one is smaller than the other or greater than the other
 * e.g. 10 to 21 vs. 21 to 10, the graph will always assume that the user meant the first one (10 to 21) and will display a correct graph instead of an empty one.
 * 4. Secret question verification is not case sensitive - a special implementation in the authoriseSecretQuestion method checks the secret answer regardless of
 * the cases of letters, so even if the users enters e.g. adam or ADAM instead of Adam, the verification will be positive.
 * 5. Users are prompted with the log in page immediately after launching it - as the logging in process is crucial in using our application, the first
 * window that opens in the program is the Login page which makes it effortless and easy to log in and start using the application.
 */

package airnalysisdb;

import java.sql.Connection; 
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jfree.data.xy.XYSeries;

public class AirnalysisDB {
    
    //the connection is established for the whole duration of the program
    private static Connection connection = null;
    private static int userID = 0; //think if it's not better to store the username and get id later
    private static String loggedInTime = "";
    private static int chosenMinRevInTable;
    private static int chosenMaxRevInTable;
    private static int failedLogInAttempts;
    
    //connect() method allows the system to connect to the database where all the data necessary is stored
    private static Connection connect(){
        try{
            //this one should be used at the University
//            connection = DriverManager.getConnection(
//            "jdbc:mysql://elephant.ecs.westminster.ac.uk:3306/w1710343_0",
//            "w1710343", "ClQIFVh5oW1G");
            
            //this one should be used at home
            //before running the program, paste to the cmd: ssh -L 2222:elephant.ecs.westminster.ac.uk:3306 w1710343@compute0.westminster.ac.uk
            connection = DriverManager.getConnection(
                     "jdbc:mysql://localhost:2222/w1710343_0",
                      "w1710343", "ClQIFVh5oW1G");
        } catch(SQLException e){
            System.out.println("ERROR: MySQL Connection Failed!");
        }
        return connection;
    }
    
    public static int getFailedAttempts(){
        return failedLogInAttempts;
    }
    
    public static void setChosenMinRevInTable(int chosenMinRevInTable){
        AirnalysisDB.chosenMinRevInTable = chosenMinRevInTable;
    }
    
    public static void setChosenMaxRevInTable(int chosenMaxRevInTable){
        AirnalysisDB.chosenMaxRevInTable = chosenMaxRevInTable;
    }
    
    public static void setLoggedInTime(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        AirnalysisDB.loggedInTime = dateFormat.format(date);
    }
    
    /* retrieveUserID method takes a username as a parameter during the log in process and retrieves the user ID of that account
     * [Security Feature] - It is safer to store only the user ID which is a unique identifier as it does not immediately reveal any sensitive 
     * credentials that could be user to log in and hack the account.
     * There is also no setter method to change the value of the userID from outside of this class so this value cannot be meddled with 
     */
    public static int retrieveUserID(String username) {
        int userID = 0;
        String query = "SELECT userID FROM User WHERE userlogin = '" + username + "'";
        try{
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(query);
            while(results.next()){
                userID = results.getInt("userID");
            }
            statement.close();
            }
        catch(SQLException e){
            System.out.println("Exception!");
        }
        AirnalysisDB.userID = userID;
        return userID;
    }
    
    /* logLogInOut method logs each activity of each logged-in user. 
     * [Security Feature] - The activities are always paired and stored in one row, logInDateTime being the first value
     * (since logging in always occurs first), and the logOutDateTime being the other (as it occurs after the logging in). 
     */ 
    public static void logLogInOut() {
        try {
            connect();
            String loggedInDate = AirnalysisDB.loggedInTime;
            int id = AirnalysisDB.userID;
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Log(logInDateTime, logOutDateTime, userID) VALUES (?, ?, ?)");
            Date logDate = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String loggedOutTime = dateFormat.format(logDate);
            
            statement.setString(1, loggedInDate);
            statement.setString(2, loggedOutTime);
            statement.setInt(3, id);
            statement.executeUpdate();
        }
        catch(SQLException e){
            System.out.println("Exception!");
        }
    }
    
    /* [Security Feature] - The exitFrame method is called whenever the JFrames are closed. Firstly, the logLogInOut method is called to make sure 
     * that the log entry in inserted into the database. Only then can the program die. 
     */
    public static void exitFrame(JFrame frame){
        logLogInOut();
        frame.dispose();
        System.exit(0);
    }
    
    /* registerUser method inserts the user details into the database.
     * [Security Feature] - only encrypted passwords and secret answers are inserted to the database
     */
    public static void registerUser(String username, String encryptedPassword, String email, String name, String secretAnswer) {
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO User(userlogin, password, userName, userEmail, secretAnswer) VALUES (?, ?, ?, ?, ?)");

            stmt.setString(1, username);
            stmt.setString(2, encryptedPassword);
            stmt.setString(3, name);
            stmt.setString(4, email);
            stmt.setString(5, secretAnswer);

            stmt.executeUpdate();
            
            }
        catch(SQLException e){
            System.out.println("Exception!");
        }
    }
    
    /* This private method convertNumberToText takes an integer number, where number>0 and number<10, and returns a written representation of that number
     * [Security Feature] - this method implements another level of CAPTCHA security verification, preventing bots from running calculations
     * and returning the result easily.
     */
    private static String convertNumberToText(int number) {
        String numberInText = "";
        if(number<0 || number>10){
            numberInText = "ERROR!";
        } else if(number==0){
            numberInText = "zero";
        } else if(number==1){
            numberInText = "one";
        } else if(number==2){
            numberInText = "two";
        } else if(number==3){
            numberInText = "three";
        } else if(number==4){
            numberInText = "four";
        } else if(number==5){
            numberInText = "five";
        } else if(number==6){
            numberInText = "six";
        } else if(number==7){
            numberInText = "seven";
        } else if(number==8){
            numberInText = "eight";
        } else if(number==9){
            numberInText = "nine";
        } 
        return numberInText;
    }
    
    /* authenticateCaptcha is a simple CAPTCHA method that prompts a user with an input dialog where a simple calculation needs to be conducted 
     * [Security Feature] - this method allows the system to assess if the user is actually a human being or a bot that tries to access some data
     * [HCI] - the CAPTCHA is based on a simple calculation of numbers < 10, where one of the numbers is written as a text which should not be a problem for a human
     * [HCI] - the result should be entered to a pop-up box with an input field, clearly marked and visible. The question with the calculation is displayed over the
     * input field and the pop-up box has a title that indicated it is a CAPTCHA authentication.
     */
    public static boolean authenticateCaptcha(){
        boolean captcha = false;
        
        int a = (int) (Math.random()*10);
        int b = (int) (Math.random()*10);
        int c = (int) (Math.random()*10);
        int result = a + b - c;
        
        //the convertNumberToText method is called to change one of the integers into its written form
        String numberCInText = convertNumberToText(c);
        
        String message = "What is the result of the sum of " + a + " and " + b + " minus " + numberCInText + "?";
        
        String userInput = JOptionPane.showInputDialog(null, message, "CAPTCHA Authentication", JOptionPane.QUESTION_MESSAGE);
        try {
            int userNum = Integer.parseInt(userInput);
            if(result==userNum){
            captcha = true;
            } else {
            captcha = false;
            }
        //if the user's input is not an integer, the CAPTCHA will be set to false anyway as it obviously does not match the result
        } catch (NumberFormatException e){
            captcha = false;
        }
                       
        return captcha;
    }
    
    /* authenticatePassword method is used during the logging in process to verify that the correct password has been entered
     * [Security Features] - password for the account is verified and the access to the account is restricted in case the password is wrong
     * - since the passwords stored in the database are all encrypted, the decryption process is necessary to compare the password to the one entered by the user
     * - in case the authentication failed, the number of failed attempts is incremented and updated both in the database and in the class variable
     */
    public static boolean authenticatePassword(String username, String passwordEntered) {
        boolean authentication = false;
        String query = "SELECT userlogin, password, failedAttempts FROM User WHERE userlogin = '" + username + "'";
        try{
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(query);
            while(results.next()){
                String decryptedPassword = new String (decryptPassword(results.getString("password").getBytes()));
                if(decryptedPassword.equals(passwordEntered)){
                    authentication = true;
                } else {
                    int noFailed = results.getInt("failedAttempts");
                    noFailed++;
                    authentication = false;
                    PreparedStatement failedAttemptsStatement = connection.prepareStatement("UPDATE User SET failedAttempts = ? WHERE userlogin = ?");
                    
                    failedAttemptsStatement.setInt(1, noFailed);
                    failedAttemptsStatement.setString(2, username);
                    failedAttemptsStatement.executeUpdate();
                    failedLogInAttempts = noFailed;
                }
            }
            statement.close();
            }
        catch(SQLException e){
            System.out.println("Exception!");
        }
        return authentication;
    }
    
    /* checkUsernameEmailExists method is used to check that the username and the email address are unique
     * [Security Feature] - no account will have the same username or e-mail address so it will not be possible to accidentally log in to someone else's account 
     */
    public static boolean checkUsernameEmailExists(String username){
        boolean usernameOrEmailExists = true;
        try{
            String query = "SELECT userlogin, userEmail FROM User WHERE userlogin = '" + username + "'";
            String usernameRetrieved = "";
            String emailRetrieved = "";
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(query);
            while(results.next()){
                usernameRetrieved = results.getString("userlogin");
                emailRetrieved = results.getString("userEmail");
            }
            statement.close();
            
            if(usernameRetrieved.equals("") || emailRetrieved.equals("")){
                usernameOrEmailExists = false;
            }
            
        } catch(Exception ex){}
        
        return usernameOrEmailExists;
    
    }
    
    /* checkUsernameEmailExists method is used to check if the e-mail address entered by a user is related to any account
     * [Security Feature] - if the e-mail address does not exist in a database, no password retrieval will be displayed and the secret question will not be revealed
     */
    public static boolean confirmEmailExists(String email){
        boolean emailExists = false;
        try{
            String query = "SELECT userEmail FROM User WHERE userEmail = '" + email + "'";
            String emailRetrieved = "";
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(query);
            while(results.next()){
                emailRetrieved = results.getString("userEmail");
            }
            statement.close();
            
            if(emailRetrieved.equals(email)){
                emailExists = true;
            }
        } catch(Exception ex){}
            
        return emailExists;
    }
    
    /* resetAttemptsForEmail or -Username methods are used to reset the failed attempts of logging in to the account
     * [Security Feature] - the methods are called only if a correct verification of credentials is recorded
     */
    public static void resetAttemptsForEmail(String email) {
        try {
            PreparedStatement resetAttempts = connection.prepareStatement("UPDATE User SET failedAttempts = ? WHERE userEmail = ?");
            resetAttempts.setInt(1, 0);
            resetAttempts.setString(2, email);
            resetAttempts.executeUpdate();
            failedLogInAttempts = 0;
        } catch(Exception ex){}
    }
    
    public static void resetAttemptsForUsername(String username) {
        try{
            PreparedStatement resetAttempts = connection.prepareStatement("UPDATE User SET failedAttempts = ? WHERE userEmail = ?");
            resetAttempts.setInt(1, 0);
            resetAttempts.setString(2, username);
            resetAttempts.executeUpdate();
            failedLogInAttempts = 0;
        } catch(Exception ex){}
    }
    
    /* retrieveMaxNoReviews method checks each time the program is launched what the current maximum number of reviews is
     * [HCI] - there will be no situation where a user can choose a number greater than the maximum number of reviews which would be misleading and would display
     * empty tables and graphs
     */
    public static int retrieveMaxNoReviews(){
        int maxReview = 0;
        String query = "SELECT numberOfReviews FROM Property";
        try{
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(query);
            while(results.next()){
//                System.out.println(results.getInt("numberOfReviews"));
                if(results.getInt("numberOfReviews")>maxReview){
                    maxReview = results.getInt("numberOfReviews");
               }
            }
            statement.close();
            }
        catch(SQLException e){
            System.out.println("Exception!");
        }
        return maxReview;
    }
    
    /* propertyTableUpdate method creates a table based on the minimum and maximum number of reviews
     * [HCI] - the table will always be populated when the program launches because the numbers of reviews are verified and all the records matching are retrieved
     */
    public static PropertyTableModel propertyTableUpdate(int minReviews, int maxReviews) {
        
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> IDs = new ArrayList<>();
        ArrayList<Integer> noReviews = new ArrayList<>();
        ArrayList<Integer> minNights = new ArrayList<>();
        ArrayList<Double> prices = new ArrayList<>();
        PropertyTableModel model = new PropertyTableModel(names, IDs, noReviews, minNights, prices);
       
        
        String query = "SELECT propertyID, propertyName, propertyPrice, minimumNights, numberOfReviews FROM Property WHERE numberOfReviews >=" + minReviews + " AND numberOfReviews <= " + maxReviews;
        try{
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(query);
                      
            while(results.next()){
                names.add(results.getString("propertyName"));
                IDs.add(results.getInt("propertyID"));
                noReviews.add(results.getInt("numberOfReviews"));
                minNights.add(results.getInt("minimumNights"));
                prices.add(results.getDouble("propertyPrice"));
            }
            statement.close();
            
            model = new PropertyTableModel(names, IDs, noReviews, minNights, prices);
            
        }catch(Exception e){}
        

        try{ 
            connection.close(); 
        } catch (SQLException e){  
            System.out.println("WARNING: Failed to close database!");
            e.printStackTrace();
        }
        
        
        return model;
        }
    
    /* getLineChartList method creates a XYSeries of entries used to build and display the line chart
     * [HCI] - regardless of whether a user chooses a range of numbers where the first one is smaller than the other or greater than the other
     * e.g. 10 to 21 vs. 21 to 10, the graph will always assume that the user meant the first one and will display a correct graph instead of an empty one
     */
    public static XYSeries getLineChartList(){
        connect();
        int minValue = 0;
        int maxValue = 0;
        XYSeries series = new XYSeries("");
        if(chosenMinRevInTable<=chosenMaxRevInTable){
            minValue = chosenMinRevInTable;
            maxValue = chosenMaxRevInTable;
        } else{
            minValue = chosenMaxRevInTable;
            maxValue = chosenMinRevInTable;
        }
        
        for(int i = minValue; i<=maxValue; i++){
            int numOfProperties = 0;
            String query = "SELECT propertyID FROM Property WHERE numberOfReviews=" + i;
            try {
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(query);
            
            while(results.next()){
                numOfProperties++;
            }
            
            series.add(i, numOfProperties);
            statement.close();
              
        } catch(Exception e){
                System.out.println("Exception!");
        }
        }
        
        return series;
    }
    
    /* encryptPassword and decryptPassword methods use a byte array and a simple character shifting to encrypt and decrypt sensitive data
     * [Security Feature] - all the sensitive information is encrypted before being stored in a database
     */
    public static byte[] encryptPassword(byte[] data) {
        byte[] encryptedPassword = new byte[data.length];
        
        for(int i = 0; i < data.length; i++){
            encryptedPassword[i] = (byte) ((i %2 == 0) ? data[i] + 1 : data[i] - 1);
        }
        
        return encryptedPassword;
    }

    public static byte[] decryptPassword(byte[] data) {
        byte[] decryptedPassword = new byte[data.length];
        
        for(int i = 0; i < data.length; i++){
            decryptedPassword[i] = (byte) ((i %2 == 0) ? data[i] - 1 : data[i] + 1);
        }
        
        return decryptedPassword;
    }
    
    /* retrievePassword method is used to retrieve the encrypted password from the database and decrypt it
     * [Security Feature] - password is retrieved only when a series of steps is correctly followed (including the correct answer to the secret question)
     * - the password is decrypted at the latest stage, everywhere else the encrypted version is used
     */
    public static String retrievePassword(String email){
        String passwordRetrieved = "";
        String query = "SELECT password FROM User WHERE userEmail = '" + email + "'";
        try{
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(query);
            while(results.next()){
                passwordRetrieved = results.getString("password");
            }
            passwordRetrieved = new String(decryptPassword(passwordRetrieved.getBytes()));
        } catch(Exception ex){}
        
        return passwordRetrieved;
    }
    
    /* authoriseSecretQuestion checks if the user who uses the specified email answered the question correctly
     * [Security Feature] - to be able to retrieve a password, a user needs to answer the secret question correctly, which is verified by this method
     * - the answer to the security question is also encrypted and becomes decrypted only at the latest stage
     * [HCI] - the secret answer field is not case sensitive so even if the user enters e.g. adam instead of Adam, the verification will still be positive
     */
    public static boolean authoriseSecretQuestion(String email, String answer){
        boolean authorised = false;
        String answerRetrieved = "EMPTY";
        String query = "SELECT secretAnswer FROM User WHERE userEmail = '" + email + "'";
        try{
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(query);
            while(results.next()){
                answerRetrieved = results.getString("secretAnswer");
            }
        } catch(Exception ex){}
        
        answerRetrieved = new String(decryptPassword(answerRetrieved.getBytes()));
        
        if(answerRetrieved.toUpperCase().equals(answer.toUpperCase())){
            authorised = true;
        }
        
        return authorised;
    }
    
    /* run method displays the log in frame immediately after connecting to the database
     * [HCI] - users can log in to the application immediately after launching it which makes it easy to use it and accessable to every registered person
     */
    public void run(){
        connect();
        
        LoginFrame login = new LoginFrame();
        login.setVisible(true);
    }
    
    public static void main(String[] args){
        AirnalysisDB manager = new AirnalysisDB();
        manager.run();
    }
}
