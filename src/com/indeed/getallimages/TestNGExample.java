package com.indeed.getallimages;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGExample {
   String message = "Hello World";	
   MessageUtil messageUtil = new MessageUtil(message);

   @Test
   public void testPrintMessage() {	  
      Assert.assertEquals(message,messageUtil.printMessage());
   }
}
