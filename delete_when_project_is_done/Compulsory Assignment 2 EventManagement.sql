USE MASTER
GO
DROP DATABASE CSe21A_EventManagement
GO
CREATE DATABASE CSe21A_EventManagement
GO
USE CSe21A_EventManagement
GO

CREATE TABLE [Admin]
(
    [ID] int IDENTITY,
    [FullName] NVARCHAR(30) NULL,
    [UserID] NVARCHAR(30) NULL,
    [Password] NVARCHAR(30) NULL,

    CONSTRAINT PK_Admin_ID PRIMARY KEY (ID)
)

CREATE TABLE [EventCoordinator]
(
    [ID] int IDENTITY,
    [FullName] NVARCHAR(30) NULL,
    [UserID] NVARCHAR(30) NULL,
    [Password] NVARCHAR(30) NULL,

    CONSTRAINT PK_EventCoordinator_ID PRIMARY KEY (ID)
)

CREATE TABLE [Customer]
(
    [ID] int IDENTITY,
    [FullName] NVARCHAR(30) NULL,
    [Email] NVARCHAR(70) NULL,

    CONSTRAINT PK_Customer_ID PRIMARY KEY (ID)

)


CREATE TABLE [Event]
(
    [ID] INT IDENTITY,
    [Title] NVARCHAR(30) NULL,
    [Artist] NVARCHAR(20) NULL,
    [Description] NVARCHAR(255) NULL,
    [Location] NVARCHAR(255) NULL,
    [Price] DECIMAL(7,2) NULL,
    [VIP_Price] DECIMAL(7,2) NULL,
    [Drink_Price] DECIMAL(7,2) NULL,
    [Food_Price] DECIMAL(7,2) NULL,
    [Contact_Mail] NVARCHAR(70) NULL,
    [Start_Data] DATETIME2 NOT NULL ,
    [End_Data] DATETIME2 NOT NULL,
    
    CONSTRAINT PK_Event_ID PRIMARY KEY (ID)
)

CREATE TABLE [Ticket]
(
    [ID] INT IDENTITY(69,1) NOT NULL,
    [Customer_ID] INT NOT NULL,
    [Event_ID] INT,
    [Price] INT NOT NULL,
    [IsPaid] BIT NULL,
    [IsSeated] BIT NULL,
    [IsVIP] BIT NULL,
    [IsDrink] BIT NULL,
    [IsFood] BIT NULL,
    [Row] NVARCHAR(20),
    [Seat] NVARCHAR(20)

   CONSTRAINT Ticket_ID PRIMARY KEY (Customer_ID, Event_ID),
   CONSTRAINT FK_Customer_ID FOREIGN KEY(Customer_ID) REFERENCES Customer(ID),
   CONSTRAINT FK_EventID FOREIGN KEY(Event_ID) REFERENCES [Event](ID)
)

CREATE TABLE [CoordinatorsOnEvent]
(
    [Event_ID] INT,
    [EventCoordinator_ID] INT,

    CONSTRAINT PK_EventID_EventCoordinatorID PRIMARY KEY (Event_ID, EventCoordinator_ID),
    CONSTRAINT FK_CoordinatorsOnEventID FOREIGN KEY(EventCoordinator_ID) REFERENCES EventCoordinator(ID),
    CONSTRAINT FK_Event_ID FOREIGN KEY(Event_ID) REFERENCES [Event](ID),
)

create table [Email]
(
    [EmailCredentials] VARCHAR(70) NULL,
    [PasswordCredentials] VARCHAR(30) NULL
)

INSERT INTO Email (EmailCredentials, PasswordCredentials) VALUES ('event_easv@outlook.com', 'EasvEvent2022'

ALTER TABLE [Ticket] ADD CONSTRAINT [FK_Event] FOREIGN KEY([Event_ID])
REFERENCES [Event] ([ID])
ON DELETE CASCADE