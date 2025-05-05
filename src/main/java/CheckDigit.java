public class CheckDigit  
{   
  /** Returns the check digit for num, as described in part (a).  
   *  Precondition: The number of digits in num is between one and six, inclusive.  
   *                num >= 0  
   */  
  public static int getCheck(int num) 
  {  
    int sum = 0;
    int numDigits = getNumberOfDigits(num);
    for (int i = 1; i <= numDigits; i++)
    {
      int digit = getDigit(num, i);
      sum += digit * i;
    }
    return sum % 10;
  }

  /** Returns true if numWithCheckDigit is valid, or false otherwise. 
   *  Precondition: The number of digits in numWithCheckDigit is between two and seven, inclusive.
   *                numWithCheckDigit >= 0     
   */     
  public static boolean isValid(int numWithCheckDigit)    
  {      
    int numDigits = getNumberOfDigits(numWithCheckDigit);
    int checkDigit = numWithCheckDigit % 10; // last digit
    int originalNum = numWithCheckDigit / 10; // all digits except last
    return getCheck(originalNum) == checkDigit;
  }    
   
  /** Returns the number of digits in num. */    
  public static int getNumberOfDigits(int num)    
  {      
    if (num < 10)
      return 1;
    return 1 + getNumberOfDigits(num / 10);    
  }    
   
  /** Returns the nth digit of num (from left to right).     
   *  Precondition: n >= 1 and n <= the number of digits in num     
   */    
  public static int getDigit(int num, int n)    
  {      
    int numDigits = getNumberOfDigits(num);
    int divisor = (int) Math.pow(10, numDigits - n);
    return (num / divisor) % 10;
  }     
}
