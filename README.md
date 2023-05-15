# Demo
All Apis that allow you to manage the relationship in your own social network as "Friend", "Unfriend", "Block", "Receive Updates" etc.

Used technologies: Java, Spring Webflux, R2DBC, Lombok, Postgre

# INSTALLATION
1. Clone this repository 
   git clone https://github.com/thuanhphan/Demo.git 
   
# API
## 1. POST {"/api/makeFriends"}
This method create a friend connection between two email addresses.

### Request body:

![Req1](https://github.com/thuanhphan/Demo/assets/44856340/5f3e884c-78b0-42ac-8721-60da784d94d3)

### Response: 

200OK:

![Res1](https://github.com/thuanhphan/Demo/assets/44856340/68f6b152-ba42-4142-baf2-96335a17d17e)

## 2. POST {"/api/getFriends"}
This method retrieve the friends list for an email address.

### Request body:

![Req2](https://github.com/thuanhphan/Demo/assets/44856340/412bdc16-0191-4c25-b330-830d5f5b4b5a)

### Response:

200OK:

![Res2](https://github.com/thuanhphan/Demo/assets/44856340/b2ba1dc7-e300-4747-acb0-13e456ca8362)

## 3. POST {"/api/getCommonFriends"}
This method retrieve the common friends list between two email addresses.
## Request body:

![Req3](https://github.com/thuanhphan/Demo/assets/44856340/a432dc79-d326-40a2-b979-1d16e2d01ddc)

## Response: 

200OK:

![Res3](https://github.com/thuanhphan/Demo/assets/44856340/154e18ad-b81b-445f-9ac5-607d7580e4f2)

## 4. POST {"/api/block"}
This method block updates from an email address.

### Request body:

![Req5](https://github.com/thuanhphan/Demo/assets/44856340/220b7faf-0a0e-4cf4-bba9-df2f8a4dc071)

### Response: 

200OK:

![Req1](https://github.com/thuanhphan/Demo/assets/44856340/5f3e884c-78b0-42ac-8721-60da784d94d3)
        
## 5. POST {"/api/subscribe"}
This method subcribe to updates from an email address.
### Request body:

![Req4](https://github.com/thuanhphan/Demo/assets/44856340/d45d1965-ec5d-4c95-8c80-5e6ccaf7d296)

### Response: 

200OK:

![Res1](https://github.com/thuanhphan/Demo/assets/44856340/68f6b152-ba42-4142-baf2-96335a17d17e)

## 6.POST {"/api/getEmailReceivers"}
This method retrieve all email addresses that can receive updates from an email address.
### Request body:

![Req6](https://github.com/thuanhphan/Demo/assets/44856340/0a863175-6bb3-486d-a9df-c909666626d2)

### Response:

200OK:

![Res6](https://github.com/thuanhphan/Demo/assets/44856340/4f898e2a-860b-407f-b340-19b5d0dcca3f)
