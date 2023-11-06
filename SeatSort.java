import java.util.ArrayList;
public class SeatSort
{
   
   public static boolean orderLast(String name1, String name2, String name3, String name4)
   {
      if(name1.charAt(0) > name2.charAt(0))
      {
         return true;
      }
      else if(name1.charAt(0) < name2.charAt(0))
      {
         return false;
      }
      else if(name1.charAt(0) == name2.charAt(0))
      {
         if(name1.length() > 1 && name2.length() > 1)
         {
            if(orderLast(name1.substring(1), name2.substring(1), name3, name4))
            {
            return true;
            } else
            {
            return false;
            }
            
         }
         
         else if(name1.length() < name2.length())
         {
            return false;
         }
         else if(name1.length() > name2.length())
         {
            return true;
         }
         else
         {
            if(orderFirst(name3, name4))
            {
            return true;
            } else
            {
            return false;
            }
         }
      }
      return false;
   }
   
   public static boolean orderFirst(String name1, String name2)
   {
      if(name1.charAt(0) > name2.charAt(0))
      {
         return true;
      }
      else if(name1.charAt(0) < name2.charAt(0))
      {
         return false;
      }
      else
      {
         if(name1.length() > 1 && name2.length() > 1)
         {
            if(orderFirst(name1.substring(1), name2.substring(1)))
            {
            return true;
            } else
            {
            return false;
            }
         }
         
         if(name1.length() < name2.length())
         {
            return true;
         }
         else
         {
            return false;
         }
      }
   }
   
   
   
   
   
   public static void main (String [] args)
   {
      ArrayList <SeatRecord> records = new ArrayList <SeatRecord> ();   //Pretending this is a list of 10 records 
      records.add(new SeatRecord("Johnnay","cheng","email@gmail.ca","1231231234","12-12-1990",true));
      records.add(new SeatRecord("Johnnyb","chen","email@gmail.ca","1231231234","12-12-1990",false)); 
      records.add(new SeatRecord("Johnnya","chang","email@gmail.ca","1231231234","12-12-1990",true));
      records.add(new SeatRecord("Johnnyc","chan","email@gmail.ca","1231231234","12-12-1990",false));
      records.add(new SeatRecord("Johnnyd","zhao","email@gmail.ca","1231231234","12-12-1990",true));
      records.add(new SeatRecord("Johnnya","zhang","email@gmail.ca","1231231234","12-12-1990",false)); 
      records.add(new SeatRecord("Johnnyaba","abc","email@gmail.ca","1231231234","12-12-1990",true));
      records.add(new SeatRecord("Johnnyc","trinh","email@gmail.ca","1231231234","12-12-1990",false));
      records.add(new SeatRecord("Johnnyd","tran","email@gmail.ca","1231231234","12-12-1990",true));
      records.add(new SeatRecord("Johnnyabc","abc","email@gmail.ca","1231231234","12-12-1990",false)); 
                         
      String[] printList = new String[10];   //Array to store the toString of the SeatRecord
      String temp;   //For swapping in the algorithm

      for(int j = 0; j < 10; j++)
      {
         printList[j] = records.get(j).toString();    //Putting the relevant info into a single string
      }

      System.out.println("Unsorted list:");

      for(int c = 0; c < printList.length; c++)
      {
         System.out.println(printList[c]);
      }
      
      for (int j = 0; j < printList.length - 1; j++)  
      {
          for (int i = j + 1;i < printList.length; i++)
          {
              String[] lnames = printList[j].split(" ");
              String[] fnames = printList[i].split(" ");
              if (orderLast(lnames[1], fnames[1], lnames[0], fnames[0]))  
              {
                  temp = printList[j];          
                  printList[j] = printList[i];
                  printList[i] = temp;
              } 
          }
      }
      
      System.out.println("Sorted list:");

      for(int c = 0; c < 10; c++)
      {
         System.out.println(printList[c]);
      }
   }
}
