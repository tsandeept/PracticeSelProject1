package com.indeed.getallimages;
import com.sandytech.modifiers.*;
/*public class MessageUtil {

}*/


/*
* This class prints the given message on console.
*/

public class MessageUtil extends DefaultClass {

   private String message;

   //Constructor
   //@param message to be printed
  public MessageUtil(String message){
    this.message = message;
  }
   // prints the message
   public String printMessage(){
      System.out.println(message);
      return message;
   }   
   
   public static void main(String[] args)
   {
	   MessageUtil obj = new MessageUtil("constmsg");
	   System.out.println(obj.message);
	   obj.msg();
   }
} 



