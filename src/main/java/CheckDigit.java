public class CheckDigit 
{
  / Returns the check digit for num, as described in part (a).
Precondition: The number of digits in num is between one and
six, inclusive.
num >= 0
*/
public static int getCheck(int num) 
{
int sum = 0;
int numDigits = getNumberOfDigits(num);

for (int i = 1; i <= numDigits; i++) {
int digit = getDigit(num, i);
int weight = 8 - i; // weights go 7, 6, 5, ...
sum += digit * weight;
}


    return sum % 10;
  }

  / Returns true if numWithCheckDigit is valid, or false otherwise.
Precondition: The number of digits in numWithCheckDigit is between two and seven, inclusive.
numWithCheckDigit >= 0
*/
public static boolean isValid(int numWithCheckDigit)
{
int checkDigit = numWithCheckDigit % 10;
int originalNum = numWithCheckDigit / 10;

    return getCheck(originalNum) == checkDigit;
  }

  / Returns the number of digits in num. */
  public static int getNumberOfDigits(int num)
  {
    if (num < 10)
      return 1;
    return 1 + getNumberOfDigits(num / 10);
  }

  / Returns the nth digit of num.
Precondition: n >= 1 and n <= the number of digits in num
*/
public static int getDigit(int num, int n)
{
int pos = getNumberOfDigits(num) - n;
while (pos > 0) {
num /= 10;
pos--;}
return num % 10;}
}
