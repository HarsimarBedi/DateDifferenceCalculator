AUSTRALIA POST DATE DIFFERENCE CALCULATOR

This project tends to calculate the difference of number of days between two dates provided. This has been developed using JAVA 8+, Spring Boot 4 and RESTful API’s.

How to import the project?

1.	Open Eclipse and select File > Import from the menu.
2.	 Choose Existing Projects into Workspace under General and click Next.
3.	 In the Import dialog:
•	Select archive file and browse to the ZIP file.
•	Check the project in the Projects list.
•	Ensure Copy projects into workspace is checked.
•	Click Finish.

How to run the application?

•	Right click on the “DateDifferenceCalculatorApplication” class.
•	Select Run As -> Spring Boot App

To Test the API
•	Use a tool like Postman to send a POST request to http://localhost:8080/api/dates/calculate with the following JSON payload:


{
    "date1": "12 12 2010",
    "date2": "15 12 2000"
}
               You can change the dates as per your wish as well. Also, above mentioned is just an example.
	
	To Test the Tests
•	Unit Tests:
•	Right-click on the DateServiceTest class in the Project Explorer.
•	Select Run As -> JUnit Test.
•	Integration Tests:
•	Right-click on the DateControllerIntegrationTest class in the Project Explorer.
•	Select Run As -> JUnit Test.


NOTE: The output does not include the end date.

					


