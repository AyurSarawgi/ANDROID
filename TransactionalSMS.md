# ANDROID
My Major Android Projects

 ## TransactionalSMS
  
   #MainActivity  
 
   1. Ask and check for the permission to read sms of mobile phone .
     
   2. Creating a bottom navigation menu with three buttons to start a creditFragment, debitFragment and an activity 'Mainactivity2' repectively.

   3. Create 2 fragments and 1 activity of name mentioned above.

#creditFragment
 
   4. This fragment is for fetching the all the credited sms of bank and retrieve all the credit amount

   5. By creating listview , all the credit sms are shown in listviw in creditFragment

   6. To fetch all the bank sms , there is a condition given below, where body contains all the sms.

                if ((body.contains("Credited") || body.contains("credited") ) &&  (!body.contains("failed")) ) 
                    {
                      if (number.matches("[a-zA-Z0-9]{2}-[a-zA-Z0-9]{6}"))
                       {
                           //we get all the bank sms contains credited in it
                       }
                     }

   7. Inside the above codition , there is also a other condition shown below to fetch the credited amount from sms.

                Pattern regEx
                            = Pattern.compile(" (?i)(?:(?:RS|INR|MRP)\\.?\\s?)(\\d+(:?\\,\\d+)?(\\,\\d+)?(\\.\\d{1,2})?)");
                  Matcher m = regEx.matcher(body);

   8. Using if m is matches and  while loop getting the credit amount from each messages and can get total credited amount.

   9. Sharing the total credit amount through intent to the "MainActivity2" to display credited amount in pie chart. 


#debitFragment
 
   10. This fragment is for fetching the all the debited sms of bank and retrieve all the debit amount

   11. By creating listview , all the debit sms are shown in listviw in creditFragment

   12. To fetch all the bank sms , there is a condition given below, where body contains all the sms.

                if ((body.contains("Debited") || body.contains("debited") ) &&  (!body.contains("failed")) ) 
                    {
                      if (number.matches("[a-zA-Z0-9]{2}-[a-zA-Z0-9]{6}"))
                       {
                           //we get all the bank sms contains debited in it
                       }
                     }

   13. Inside the above codition , there is also a other condition shown below to fetch the debited amount from sms.

                Pattern regEx
                            = Pattern.compile(" (?i)(?:(?:RS|INR|MRP)\\.?\\s?)(\\d+(:?\\,\\d+)?(\\,\\d+)?(\\.\\d{1,2})?)");
                  Matcher m = regEx.matcher(body);

   14. Using if m is matches and  while loop getting the debitt amount from each messages and can get total debited amount.

   15. Sharing the total credit amount through intent to the "MainActivity2" to display debited amount in pie chart. 

#MainActivity2

   16. This activity is to showing the total credited and total debited amount in a pie chart.

   17. Getting the total credit and total debit amount from creditFragment and debitFragment repectively through intent. 

* (Unfortunately I'm getting 0 and 0 for both total credit amount and total debit amount because this data will transferred only by creating Interface (Unable to create it due to deadline))

   18. Created a pie chart using third party library "MPAndroidChart" 

   19. Adding depenency and repository for that library in build.Gradle file 
     
   20. Dependecy --     implementation 'com.github.PhilJay:MPAndroidChart:v2.2.4' 

       Repository--     maven { url "https://jitpack.io" }

   21. This Pie Chart shows the information about your Total Expansive and Total Income.
