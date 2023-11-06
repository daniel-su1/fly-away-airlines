import java.time.LocalDate; // imports the LocalDate class
import java.time.Period; // imports the Period class

public class SeatRecord {
   /**
    * This is a boolean check for the availability of the seat
    */
   private boolean available = true;
   /**
    * This string is the first name of the customer
    */
   private String firstName;
   /**
    * This string is the last name of the customer
    */
   private String lastName;
   /**
    * This string is the email of the customer
    */
   private String email;
   /**
    * This string is the phone number of the customer
    */
   private String phone;
   /**
    * This string is the date of birth of the customer
    */
   private String dob;
   /**
    * This integer is the age of the customer
    */
   private int age;

   /**
    * Constructor of an instance of SeatRecord to store customer data
    * 
    * @param firstName customer's firstname
    * @param lastName  customer's lastname
    * @param email     customer's email
    * @param phone     customer's phone
    * @param dob       customer's dob
    * @param available the availability of the seat
    */
   public SeatRecord(String firstName, String lastName, String email, String phone, String dob, boolean available) {
      this.firstName = firstNameFormat(firstName);
      this.lastName = lastNameFormat(lastName);
      this.email = emailFormat(email);
      this.phone = phoneFormat(phone);
      this.dob = dobFormat(dob);
      setAge(this.dob);
      this.available = available;
   }
   
   /**
   * Default constructor
   * Created: William Cheng, June 1 at 1346
   */
   public SeatRecord()
   {
      firstName = "";
      lastName = "";
      email = "";
      phone = "";
      dob = "";
      available = true;
   }

   /**
   * Method to set the first name
   * @param firstName the first name
   * Created: William Cheng, May 31 at 1319
   */
   public void setFirstName(String firstName)
   {
      this.firstName = firstNameFormat(firstName);
   }
   
   /**
   * Method to set the last name
   * @param lastName the last name
   * Created: William Cheng, May 31 at 1322
   */
   public void setLastName(String lastName)
   {
      this.lastName = lastNameFormat(lastName);
   }
   
   /**
   * Method to set the email
   * @param email the email address
   * Created: William Cheng, May 31 at 1323
   */
   public void setEmail(String email)
   {
      this.email = emailFormat(email);
   }
   
   /**
   * Method to set the phone number
   * @param phone the phone number
   * Created: William Cheng, May 31 at 1325
   */
   public void setPhone(String phone)
   {
      this.phone = phoneFormat(phone);
   }
   
   /**
   * Method to set the date of birth
   * @param dob the date of birth
   * Created: William Cheng, May 31 at 1327
   * Modified: William Cheng, June 1 at 1406: Make the age also be set at the same time as the DOB
   */
   public void setDOB(String dob)
   {
      this.dob = dobFormat(dob);
      setAge(this.dob);
   }

   /**
    * Method to set the age
    * 
    * @param dob variable for the date of birth
    *            source for content outside of course material:
    *            https://www.geeksforgeeks.org/find-the-duration-of-difference-between-two-dates-in-java/#:~:text=getTime()%20%E2%80%93%20d1.,between%20the%20two%20specifies%20dates.
    */
   public void setAge(String dob) {
      String[] dobStrings = dob.split("/"); // splits the date of birth
      LocalDate start = LocalDate.of(Integer.parseInt(dobStrings[2]), Integer.parseInt(dobStrings[1]), Integer.parseInt(dobStrings[0])); // converts date of birth into a
                                                                                   // LocaDate and sets it as the start
                                                                                   // date
      LocalDate end = LocalDate.now(); // sets current date as end date
      Period diff = Period.between(start, end); // calculates the difference in time between the start and end date
      age = diff.getYears(); // saves the age as the difference in years between the start and end date
   }

   /**
    * Method that sets the availability of the seat
    * 
    * @param available the availability of the seat
    */
   public void setAvailable(boolean available) {
      this.available = available; // sets available
   }

   /**
    * Method that returns the first name
    * 
    * @return the first name of the customer
    */
   public String getFirstName() {
      return firstName;
   }

   /**
    * Method that returns the last name
    * 
    * @return the last name of the customer
    */
   public String getLastName() {
      return lastName;
   }

   /**
    * Method that returns the email
    * 
    * @return the email of the customer
    */
   public String getEmail() {
      return email;
   }

   /**
    * Method that returns the phone number
    * 
    * @return the phone number of the customer
    */
   public String getPhone() {
      return phone;
   }

   /**
    * Method that returns the date of birth
    * 
    * @return the date of birth of the customer
    */
   public String getDOB() {
      return dob;
   }

   /**
    * Method that returns the age
    * 
    * @return the age of the customer
    */
   public int getAge() {
      return age;
   }

   /**
    * Method that returns the availability of the seat
    * 
    * @return the availability of the seat
    */
   public boolean getAvailable() {
      return available;
   }

   /**
    * Method that formats and returns input in first name format when called
    * 
    * @return the formatted first name
    */
   private String firstNameFormat(String firstName) {
      return firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
   }

   /**
    * Method that formats and returns input in last name format when called
    * 
    * @return the formatted last name
    */
   private String lastNameFormat(String lastName) {
      return lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
   }

   /**
    * Method that formats and returns input in email format when called
    * 
    * @return the formatted email
    */
   private String emailFormat(String email) {
      return email.toLowerCase();
   }

   /**
    * Method that formats and returns phone format when called
    * 
    * @return the formatted email
    */
   private String phoneFormat(String phone) {
      if (phone.length() == 10) { // if phone length is 10 inserts "-" accordingly
         return phone.substring(0, 3) + "-" + phone.substring(3, 6) + "-" + phone.substring(6);
      } else {
         try {
            String[] parts = phone.split(" ");
            return parts[0] + "-" + parts[1] + "-" + parts[2];
         } catch (Exception e) {
            return phone;
         }
      }
   }

   /**
    * Method that formats and returns input in date of birth format when called
    * 
    * @return the formatted date of birth
    */
   private String dobFormat(String dob) {
      if (dob.length() == 10) {
         return dob.substring(0, 2) + "/" + dob.substring(3, 5) + "/" + dob.substring(6);
      } else if (dob.length() == 8) {
         return dob.substring(0, 2) + "/" + dob.substring(2, 4) + "/" + dob.substring(4);
      } else {
         return "";
      }
   }

    /**
    * toString method, contains displayed text when instance is printed
    * 
    * @return the formatted text to be displayed
    */
   public String toString() {
      return firstName+" "+lastName+" "+email+" "+phone+" "+dob+" "+age+" "+available;
   }
}
