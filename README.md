<h1  align="center">
  <b>Welcome</b>
</h1>


# Hospital management application


This repo consits of SpringBoot application for Hospital management backend apis

# Tech Stack Used:
- SpringBoot
- H2 Database (In Memory database)
- JPA

In This, I have implemented CommandLineData once the application runs the sample data will be inserted into Database.
You can see the implementation in the main application run file.

# Mislenous Content
I have attached my Postman collection file in resources/static one can download and import it to postman.
Thanks, me later!! :)

# Staff APIs
Sign up new Staff with token and expiry of token of login for 24 hour
http://localhost:9090/api/staff/signup
![image](https://github.com/Saurabh8206/hospitalManagement/assets/66825179/3f537965-098c-497b-92ef-05a0e00569d7)


Login staff with username and password
http://localhost:9090/api/staff/login
![image](https://github.com/Saurabh8206/hospitalManagement/assets/66825179/b0ee6d8a-a417-4504-87f7-ca87823bbd3a)


GetAllStaff Present in system
http://localhost:9090/api/staff/getAll
![image](https://github.com/Saurabh8206/hospitalManagement/assets/66825179/1a5fb259-3f44-4919-a5c5-e2dd3f751f23)


Fetch Staff By StaffId
http://localhost:9090/api/staff/get-staff-by-id/1
![image](https://github.com/Saurabh8206/hospitalManagement/assets/66825179/3f8b9508-dfc5-4357-ac73-72753a60bde0)



# Patient APIs

Get Patient by status
http://localhost:9090/api/patients/status/ADMITTED
![image](https://github.com/Saurabh8206/hospitalManagement/assets/66825179/55aec9ce-8bbe-4e26-88cc-4d74cbdff168)


Admit Patient with details
http://localhost:9090/api/patients/admit
![image](https://github.com/Saurabh8206/hospitalManagement/assets/66825179/ca6f716f-ccb1-46d1-b72b-1f37a1d6b46b)


Discharge patient by it
http://localhost:9090/api/patients/discharge/1
![image](https://github.com/Saurabh8206/hospitalManagement/assets/66825179/e6186e80-975b-4524-b02a-f04e30a1ece4)


Fetch all patients in the system present
![image](https://github.com/Saurabh8206/hospitalManagement/assets/66825179/3a91e265-6e23-481a-95d0-6c11161e75d0)


