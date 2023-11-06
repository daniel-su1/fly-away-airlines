public class DataCheck
{

   /**
   * Method which will determine the validity of the entered date of birth
   * @param dob the date of birth
   * @return whether or not the date of birth is valid
   * Created: William Cheng, from May 17 at 1405 to May 17 at 1443
   */
   public static boolean dobCheck(String dob)
   {
      //Accepted format is dd/mm/yyyy
      
      String[] split; //Declares a String array to store the split components of the dob
      int year; //Declares an int variable to store the year
      int month; //Declares an int variable to store the month
      int day; //Declares an int variable to store the day
      
      if(dob.length() != 10) //dob must be 10 characters long
      {
         return false;
      }
      else if(dob.charAt(2) != '/' || dob.charAt(5) != '/') //dob must have slashes here: xx\xx\xxxx
      {
         return false;
      }
      else
      {
         split = dob.split("/");
         
         try //day, month, and year must be integers
         {
            day = Integer.parseInt(split[0]); //Stores an int value of the day in day
            month = Integer.parseInt(split[1]); //Stores an int value of the month in month
            year = Integer.parseInt(split[2]); //Stores an int value of the year in year
         }
         catch (Exception e)
         {
            return false;
         }
         
         if(year > 2022 || year < 1872) //Must be born from 1872 to 2022
         {
            return false;
         }
         else if(month > 12 || month < 1) //Must have birth month from 1 to 12
         {
            return false;
         }
         else if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) //If month has 31 days
         {
            if(day < 1 || day > 31) //Day must be between 1 and 31
            {
               return false;
            }
         }
         else if(month == 4 || month == 6 || month == 9 || month == 11) //If month has 30 days
         {
            if(day < 1 || day > 30) //Day must be between 1 and 30
            {
               return false;
            }
         }
         else if(month == 2) //If month is February
         {
            if(year%4 == 0) //If year of birth is a leap year
            {
               if(day < 1 || day > 29) //Day must be between 1 and 29
               {
                  return false;
               }
            }
            else //If year of birth is not a leap year
            {
               if(day < 1 || day > 28) //Day must be between 1 and 28
               {
                  return false;
               }
            }
         }
      }
      
      return true; //Otherwise, dob is completely valid
   }
   
   
   /**
   * Method which will determine the validity of the entered first name
   * @param firstName the entered first name
   * @return whether or not the first name is valid
   * Created: William Cheng, from May 18 at 1301 to May 18 at 1314
   */
   public static boolean firstNameCheck(String firstName)
   {
      String test = firstName.trim(); //Takes away excess spaces
      
      for(int i = 0; i < test.length(); i ++) //Runs through all characters of the name
      {
         if(!(test.charAt(i) >= 'A' && test.charAt(i) <= 'Z') && !(test.charAt(i) >= 'a' && test.charAt(i) <= 'z')) //Name must only consist of letters
         {
            return false;
         }
      }
      
      return true; //Otherwise, first name is completely valid
   }
   
   /**
   * Method which will determine the validity of the entered last name
   * @param lastName the entered last name
   * @return whether or not the last name is valid
   * Created: William Cheng, from May 18 at 1318
   */
   public static boolean lastNameCheck(String lastName)
   {
      String test = lastName.trim(); //Takes away excess spaces
      
      for(int i = 0; i < test.length(); i ++) //Runs through all characters of the name
      {
         if(!(test.charAt(i) >= 'A' && test.charAt(i) <= 'Z') && !(test.charAt(i) >= 'a' && test.charAt(i) <= 'z') && test.charAt(i) != ' ' && test.charAt(i) != '-') //Name must only consist of letters, spaces, and dashes
         {
            return false;
         }
      }
      return true;
   }
   
   
   /**
   * Method which will determine the validity of the entered email
   * @param email the entered email
   * @return boolean of whether the email is valid or invalid
   * Created: Jing Wang, from May 20 at 1256
   * Modified: William Cheng, from May 24 1355 to May 24 1435
   * Modified: Jing Wang, from May 30 1922 to May 30 1924
   */
   public static boolean emailCheck(String email)
   {
      String test = email.trim(); //Takes away excess spaces
      int charCount = 0; //Keeps track of the number of @ signs found within the email
      int periodCount = 0; //Keeps track o fnumber of periods found within the email
      
      if(test.charAt(0) == '@') //Returns false if the first character is '@'
      {
         return false;
      }
      
      if(test.charAt(test.length()-1) == '.' || test.charAt(test.length()-1) == '@') //Returns false if the last character is '.' or '@'
      {
         return false;
      }
      
      for(int i = 0; i < test.length(); i++) //Runs through all characters of the email and checks for invalid components
      {
         if(test.charAt(i) == '@') //Counts how many '@' are in the string
         {
            charCount++;
         }
         
         if(test.charAt(i) == '.') //Counts how many '.' are in the string
         {
            periodCount++;
         }
         
         else if(!(test.charAt(i) >= 'A' && test.charAt(i) <= 'Z') && !(test.charAt(i) >= 'a' && test.charAt(i) <= 'z') && !(test.charAt(i) >= '0' && test.charAt(i) <= '9') && test.charAt(i) != '.' && test.charAt(i) != '@') //Email characters must be alphanumeric
         {
            return false;
         }
      }
      
      if(charCount != 1 || periodCount != 1) //Returns false if there are more than 1 '@' in the string
      {
         return false;
      }
      
      return true; //Returns true if all checks go through without returning false
   }

   /**
   * Method which will determine the validity of the entered phone
   * @param phone the entered phone
   * @return boolean of whether the phone is valid or invalid
   * Created: Jing Wang, from May 20 at 1308
   * Modified: William Cheng, from May 24 at 1439 to May 24 at 1455
   * Modified: William Cheng, from May 25 at 1300 to 1317
   */
   public static boolean phoneCheck(String phone)
   {
      String test = phone.trim(); //Takes away excess spaces
            
      if(test.length() == 10)
      {
         try //Checks if the entire string are numbers by attempting to convert it to Int
         {
             Integer.parseInt(test);
         } 
         catch (NumberFormatException nfe) 
         {
             return false;
         }
      }
      else if(test.length() == 12)
      {
         if((test.charAt(3) == ' ' || test.charAt(3) == '-') && test.charAt(7) == test.charAt(3)) //Number "sections" must be separated by either space or dash
         {
            String[] testComp = test.split(test.charAt(3)+"");
            if(testComp.length != 3) //Phone number must have 3 "sections"
            {
               return false;
            }
            try
            {
               for(int i = 0; i < testComp.length; i ++) //Each section of phone number must be comprised entirely of numbers
               {
                  Integer.parseInt(testComp[i]);
               }
            }
            catch (Exception e)
            {
               return false;
            }
         }
         else 
         {
            return false;
         }
      }
      else 
      {
         return false;
      }
      
      return true;
   } 
}

