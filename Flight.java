import java.util.ArrayList; // imports the Array List class

public class Flight {
    /**
     * variable to store the departure location of the flight
     */
    private String depart; 
    /**
     * variable to store the destination location of the flight
     */
    private String destination;
    /**
     * variable to store the date of the flight
     */
    private int date;
    /**
     * variable to store the plane name of the flight
     */
    private String plane;
    /**
     * An array list of all the seats on the flight
     */
    private ArrayList<SeatRecord> seats = new ArrayList<SeatRecord>();

    /**
     * Constructor of the flight class
     * @param depart flight departure location
     * @param destination flight destination location
     * @param date date of flight
     * @param plane name of flight plane
     */
    public Flight(String depart, String destination, int date, String plane){
        this.depart = depart; // sets global variable depart to local variable depart passed through the constructor
        this.destination = destination; // sets global variable destination to local variable destination passed through the constructor
        this.date = date; // sets global variable date to local variable date passed through the constructor
        this.plane = plane; // sets global variable plane to local variable depart passed through the constructor

        // for loop to create 10 elements of the array list seats (creates 10 seats)
        for(int i = 0; i < 10; i++){
            seats.add(new SeatRecord());
        }
    }

   public void setAvailable(boolean available, int seatNum)
   {
      seats.get(seatNum).setAvailable(available);
   }

   /**
   * Sets the first name of the client for a particular seat
   * @param name the first name of the client
   * @param seatNum the seat number, counting from 0 so that it matches array index
   * Created: William Cheng, June 1 at 1355
   */
   public void setFirstName(String name, int seatNum)
   {
      seats.get(seatNum).setFirstName(name);
   }
   
   /**
   * Sets the last name of the client for a particular seat
   * @param name the last name of the client
   * @param seatNum the seat number, counting from 0 so that it matches array index
   * Created: William Cheng, June 1 at 1401
   */
   public void setLastName(String name, int seatNum)
   {
      seats.get(seatNum).setLastName(name);
   }
   
   /**
   * Sets the email of the client for a particular seat
   * @param email the email of the client
   * @param seatNum the seat number, counting from 0 so that it matches array index
   * Created: William Cheng, June 1 at 1402
   */
   public void setEmail(String email, int seatNum)
   {
      seats.get(seatNum).setEmail(email);
   }
   
   /**
   * Sets the date of birth of the client for a particular seat
   * @param dob the date of birth of the client
   * @param seatNum the seat number, counting from 0 so that it matches array index
   * Created: William Cheng, June 1 at 1403
   */
   public void setDOB(String dob, int seatNum)
   {
      seats.get(seatNum).setDOB(dob);
   }
   
   /**
   * Sets the phone number of the client for a particular seat
   * @param phone the phone number of the client
   * @param seatNum the seat number, counting from 0 so that it matches array index
   * Created: William Cheng, June 1 at 1405
   */
   public void setPhone(String phone, int seatNum)
   {
      seats.get(seatNum).setPhone(phone);
   }

    // returns
    public String getDepart(){
        return depart;
    }

    public String getDestination(){
        return destination;
    }

    public int getDate(){
        return date;
    }

    public String getPlane(){
        return plane;
    }
    
    /**
    * Gets the first name of the client for a particular seat
    * @param seatNum the seat number, counting from 0 so that it matches array index
    * @return the first name of the client
    * Created: William Cheng, June 9 at 1420
    */
    public String getFirstName(int seatNum)
    {
      return seats.get(seatNum).getFirstName();
    }
    
    /**
    * Gets the last name of the client for a particular seat
    * @param seatNum the seat number, counting from 0 so that it matches array index
    * @return the last name of the client
    * Created: William Cheng, June 9 at 1426
    */
    public String getLastName(int seatNum)
    {
      return seats.get(seatNum).getLastName();
    }
    
    /**
    * Gets the email of the client for a particular seat
    * @param seatNum the seat number, counting from 0 so that it matches array index
    * @return the email address of the client
    * Created: William Cheng, June 9 at 1427
    */
    public String getEmail(int seatNum)
    {
      return seats.get(seatNum).getEmail();
    }
    
    /**
    * Gets the phone number of the client for a particular seat
    * @param seatNum the seat number, counting from 0 so that it matches array index
    * @return the phone number of the client
    * Created: William Cheng, June 9 at 1429
    */
    public String getPhone(int seatNum)
    {
      return seats.get(seatNum).getPhone();
    }
    
    /**
    * Gets the date of birth of the client for a particular seat
    * @param seatNum the seat number, counting from 0 so that it matches array index
    * @return the date of birth of the client
    * Cretaed: William Cheng, June 9 at 1431
    */
    public String getDOB(int seatNum)
    {
      return seats.get(seatNum).getDOB();
    }
    
    /**
    * Gets the age of the client for a particular seat
    * @param seatNum the seat number, counting from 0 so that it matches array index
    * @return the age of the client
    * Created: William Cheng, June 9 at 1436
    */
    public int getAge(int seatNum)
    {
      return seats.get(seatNum).getAge();
    }
    
    /**
    * Gets the availability of a particular seat
    * @param seatNum the seat number, counting from 0 so that it matches array index
    * @return whether or not the seat is vacant
    * Created: William Cheng, June 9 at 1438
    */
    public boolean getAvailable(int seatNum)
    {
      return seats.get(seatNum).getAvailable();
    }
    
    public String getToString(int seatNum)
    {
      return seats.get(seatNum).toString();
    }
    
    public void cancelSeat(int seatNum)
   {
      seats.set(seatNum, new SeatRecord());
   }
}
