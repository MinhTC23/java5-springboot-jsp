CREATE DATABASE JAVA5_ASM
GO 
USE JAVA5_ASM;
-- CREATE TABLE Manufacturer ( hãng san pham )
IF OBJECT_ID (N'dbo.Manufacturer', N'U') IS NOT NULL  
DROP TABLE dbo.Manufacturer
CREATE TABLE Manufacturer(
    Id int IDENTITY(1,1) PRIMARY KEY,
    Code NVARCHAR(10) DEFAULT NULL,
    Name_Manufacturer NVARCHAR(100) DEFAULT null,
    Date_Create DATE DEFAULT NULL,
    Date_correct DATE DEFAULT NULL,
    Status INT DEFAULT NULL
)
-- CREATE TABLE Product_Line (Dong san pham)
IF OBJECT_ID (N'dbo.Product_Line', N'U') IS NOT NULL  
DROP TABLE dbo.Product_Line
CREATE TABLE Product_Line(
    Id int IDENTITY(1,1) PRIMARY KEY,
    Code NVARCHAR(10) DEFAULT NULL,
    Name NVARCHAR(100) DEFAULT NULL,
    Import_price FLOAT DEFAULT NULL,
    Price FLOAT DEFAULT NULL,
    Date_Create DATE DEFAULT NULL,
    Date_correct DATE DEFAULT NULL,
    Status INT DEFAULT NULL,
    ID_Manufacturer INT,
    FOREIGN KEY ( ID_Manufacturer) REFERENCES Manufacturer(Id)
)

IF OBJECT_ID (N'dbo.Color', N'U') IS NOT NULL  
DROP TABLE dbo.Color
CREATE TABLE Color(
    Id int IDENTITY(1,1) PRIMARY KEY,
    Code NVARCHAR(10) DEFAULT NULL,
    Name NVARCHAR(100) DEFAULT NULL,
    Date_Create DATE DEFAULT NULL,
    Date_correct DATE DEFAULT NULL,
    Status INT DEFAULT NULL
)

IF OBJECT_ID (N'dbo.Capacity', N'U') IS NOT NULL  
DROP TABLE dbo.Capacity
CREATE TABLE Capacity(
     Id int IDENTITY(1,1) PRIMARY KEY,
    Code NVARCHAR(10) DEFAULT NULL,
    Name NVARCHAR(100) DEFAULT NULL,
    Date_Create DATE DEFAULT NULL,
    Date_correct DATE DEFAULT NULL,
    Status INT DEFAULT NULL
)

IF OBJECT_ID (N'dbo.Category', N'U') IS NOT NULL  
DROP TABLE dbo.Category
CREATE TABLE Category(
    Id int IDENTITY(1,1) PRIMARY KEY,
    Code NVARCHAR(10) DEFAULT NULL,
    Name NVARCHAR(100) DEFAULT NULL,
    ID_Color INT,
    ID_Capacity INT,
    ID_Product_Line INT,
    Status INT DEFAULT NULL
    FOREIGN KEY ( ID_Color) REFERENCES Color(Id),
    FOREIGN KEY ( ID_Capacity) REFERENCES Capacity(Id),
    FOREIGN KEY ( ID_Product_Line) REFERENCES Product_Line(Id)
)

IF OBJECT_ID (N'dbo.Product_Details', N'U') IS NOT NULL  
DROP TABLE dbo.Product_Details
CREATE TABLE Product_Details(
    Id int IDENTITY(1,1) PRIMARY KEY,
    Code NVARCHAR(10) DEFAULT NULL,
    Name NVARCHAR(100) DEFAULT NULL,
    Status INT DEFAULT NULL,
    Number int DEFAULT NULL,
    Images varchar(255) DEFAULT NULL,
    ID_Category INT,
    FOREIGN KEY ( ID_Category) REFERENCES Category(Id)
)

IF OBJECT_ID (N'dbo.Customer', N'U') IS NOT NULL  
DROP TABLE dbo.Customer
CREATE TABLE Customer(
    Id int IDENTITY(1,1) PRIMARY KEY,
    Code NVARCHAR(10) DEFAULT NULL,
    Full_Name NVARCHAR(100) DEFAULT NULL,
    Gender int DEFAULT NULL, 
    Phone_Number NVARCHAR(10) DEFAULT NULL,
    Address NVARCHAR(150) DEFAULT NULL,
)

IF OBJECT_ID (N'dbo.Bill', N'U') IS NOT NULL  
DROP TABLE dbo.Bill
CREATE TABLE Bill(
    Id int IDENTITY(1,1) PRIMARY KEY,
    Code NVARCHAR(10) DEFAULT NULL,
    Purchase_date DATE NOT NULL,
    Phone_Number NVARCHAR(10) DEFAULT NULL,
    Adrress NVARCHAR(150) DEFAULT NULL,
    Status INT DEFAULT NULL,
    ID_Customer int,
    FOREIGN KEY ( ID_Customer) REFERENCES Customer(Id)
)

IF OBJECT_ID (N'dbo.Bill_Product', N'U') IS NOT NULL  
DROP TABLE dbo.Bill_Product
CREATE TABLE Bill_Product(
    Id int IDENTITY(1,1) PRIMARY KEY,
    Number int DEFAULT NULL,
    Unit_price FLOAT DEFAULT NULL,
    Amount FLOAT DEFAULT NULL,
    ID_Product_Details INT,
    ID_Bill INT,
    FOREIGN KEY ( ID_Product_Details) REFERENCES Product_Details(Id),
    FOREIGN KEY ( ID_Bill) REFERENCES Bill(Id)
)

IF OBJECT_ID (N'dbo.Cart', N'U') IS NOT NULL  
DROP TABLE dbo.Cart
CREATE TABLE Cart(
    Id int IDENTITY(1,1) PRIMARY KEY,
    Code NVARCHAR(10) DEFAULT NULL,
    Date_Create DATE DEFAULT NULL,
    Status INT DEFAULT NULL,
    ID_Customer int,
    FOREIGN KEY ( ID_Customer) REFERENCES Customer(Id)
)

IF OBJECT_ID (N'dbo.Cart_Detail', N'U') IS NOT NULL
DROP TABLE dbo.Cart_Detail
CREATE TABLE Cart_Detail(
    Id int IDENTITY(1,1) PRIMARY KEY,
    Number int DEFAULT NULL,
    Unit_price FLOAT DEFAULT NULL,
    Amount FLOAT DEFAULT NULL,
    ID_Product_Details INT,
    FOREIGN KEY ( ID_Product_Details) REFERENCES Product_Details(Id),
    Id_Cart INT,
    FOREIGN KEY ( Id_Cart) REFERENCES Cart(Id),
)
INSERT INTO JAVA5_TEST1.dbo.Manufacturer
(Code, Name_Manufacturer, Date_Create, Date_correct, Status)
VALUES('MF1', 'Android', GETDATE(), GETDATE(), 1);
INSERT INTO JAVA5_TEST1.dbo.Manufacturer
(Code, Name_Manufacturer, Date_Create, Date_correct, Status)
VALUES('MF2', 'IOS', GETDATE(), GETDATE(), 1);

INSERT INTO JAVA5_TEST1.dbo.Product_Line
(Code, Name, Import_price, Price, Date_Create, Date_correct, Status, ID_Manufacturer)
VALUES('PL1', 'IOS_Japan', 200000, 300000, GETDATE(), GETDATE(), 1, NULL);
INSERT INTO JAVA5_TEST1.dbo.Product_Line
(Code, Name, Import_price, Price, Date_Create, Date_correct, Status, ID_Manufacturer)
VALUES('PL2', 'IOS_China', 100000, 200000, GETDATE(), GETDATE(), 1, NULL);

INSERT INTO JAVA5_TEST1.dbo.Capacity
(Code, Name, Date_Create, Date_correct, Status)
VALUES('DL1', '64G', GETDATE(), GETDATE(), 1);

INSERT INTO JAVA5_TEST1.dbo.Capacity
(Code, Name, Date_Create, Date_correct, Status)
VALUES('DL2', '126G', GETDATE(), GETDATE(), 1);

INSERT INTO JAVA5_TEST1.dbo.Color
(Code, Name, Date_Create, Date_correct, Status)
VALUES('CL1', 'PINK', GETDATE(), GETDATE(), 1);
INSERT INTO JAVA5_TEST1.dbo.Color
(Code, Name, Date_Create, Date_correct, Status)
VALUES('CL2', 'Green', GETDATE(), GETDATE(), 1);

INSERT INTO JAVA5_TEST1.dbo.Customer
(Code, FullName, Gender, Phone_Number, Adrress)
VALUES('PH23404', 'Pham Tuyet Nga', 1, '0968089175', 'Thai Binh');

INSERT INTO JAVA5_TEST1.dbo.Customer
(Code, FullName, Gender, Phone_Number, Adrress)
VALUES('PH3001', 'Tran Xuan Vu', 0, '0968089112', 'Thai Binh');

INSERT INTO JAVA5_TEST1.dbo.Category
(Code, Name, ID_Color, ID_Capacity, ID_Product_Line, Status)
VALUES('CT1', 'Category 1', NULL, NULL, NULL, 1);

INSERT INTO JAVA5_TEST1.dbo.Category
(Code, Name, ID_Color, ID_Capacity, ID_Product_Line, Status)
VALUES('CT2', 'Category 2', NULL, NULL, NULL, 0);
