USE [OMHurtowaniaLab]
GO

/* Tworzenie tabeli DimSource */
/****** Object:  Table [dbo].[DimSource]    Script Date: 12/1/2019 2:36:50 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[DimSource](
	[SourceKey] [varchar](300) NOT NULL,
	[Source] [varchar](300) NULL,
	[SourcePort] [varchar](300) NULL,
	[SourceType] [varchar](3) NULL,
 CONSTRAINT [PK_DimSource] PRIMARY KEY CLUSTERED 
(
	[SourceKey] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

INSERT INTO  [OMHurtowaniaLab].[dbo].[DimSource]
SELECT DISTINCT [Source] AS SourceKey,
  --ip albo program
  CASE (CHARINDEX(':',[Source]))
  WHEN 0
  THEN 
	[Source]
  ELSE
	LEFT([Source], cast(CHARINDEX(':',[Source])-1 as int))
	END AS Source,
-- port
  CASE (CHARINDEX(':',[Source]))
  WHEN 0
  THEN 
	[Destination]
  ELSE
	RIGHT([Source], DATALENGTH([Source]) - cast(CHARINDEX(':',[Source])as int))
	END AS [SourcePort],
--jaki rodzaj source
  CASE (CHARINDEX(':',[Source]))
  WHEN 0
  THEN 
	'App'
  ELSE
	'IP'
	END AS SourceType
FROM [OMHurtowaniaLab].[dbo].[ZoneAlarmLog]


/* Tworzenie tabeli z miesiacami */


/****** Object:  Table [dbo].[DimDateMonthName]    Script Date: 12/1/2019 3:09:10 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[DimDateMonthName](
	[MonthNum] [int] NOT NULL,
	[MonthName] [varchar](50) NULL,
 CONSTRAINT [PK_DimDateMonthName] PRIMARY KEY CLUSTERED 
(
	[MonthNum] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO


INSERT INTO [dbo].[DimDateMonthName]
           ([MonthNum]
           ,[MonthName])
     VALUES
           (1
           ,'January')
GO

INSERT INTO [dbo].[DimDateMonthName]
           ([MonthNum]
           ,[MonthName])
     VALUES
           (2
           ,'February')
GO

INSERT INTO [dbo].[DimDateMonthName]
           ([MonthNum]
           ,[MonthName])
     VALUES
           (3
           ,'March')
GO

INSERT INTO [dbo].[DimDateMonthName]
           ([MonthNum]
           ,[MonthName])
     VALUES
           (4
           ,'April')
GO

INSERT INTO [dbo].[DimDateMonthName]
           ([MonthNum]
           ,[MonthName])
     VALUES
           (5
           ,'May')
GO


INSERT INTO [dbo].[DimDateMonthName]
           ([MonthNum]
           ,[MonthName])
     VALUES
           (6
           ,'June')
GO

INSERT INTO [dbo].[DimDateMonthName]
           ([MonthNum]
           ,[MonthName])
     VALUES
           (7
           ,'July')
GO

INSERT INTO [dbo].[DimDateMonthName]
           ([MonthNum]
           ,[MonthName])
     VALUES
           (8
           ,'August')
GO

INSERT INTO [dbo].[DimDateMonthName]
           ([MonthNum]
           ,[MonthName])
     VALUES
           (9
           ,'September')
GO

INSERT INTO [dbo].[DimDateMonthName]
           ([MonthNum]
           ,[MonthName])
     VALUES
           (10
           ,'October')
GO

INSERT INTO [dbo].[DimDateMonthName]
           ([MonthNum]
           ,[MonthName])
     VALUES
           (11
           ,'November')
GO

INSERT INTO [dbo].[DimDateMonthName]
           ([MonthNum]
           ,[MonthName])
     VALUES
           (12
           ,'December')
GO

/* Tworzenie tabeli z dniami */

  CREATE TABLE [dbo].[DimDateDayOfWeekName](
	[DayOfWeekNumber] [int] NOT NULL,
	[DayOfWeekName] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_DimDateDayOfWeekName] PRIMARY KEY CLUSTERED 
(
	[DayOfWeekNumber] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]


/* Tworzenie tabeli z datami */
CREATE TABLE [dbo].[DimDate](
	[DataKey] [datetime] NOT NULL,
	[Year] [int] NULL,
	[Month] [int] NULL,
	[Day] [int] NULL,
	[DayOfWeek] [int] NULL,
	[Quarter] [int] NOT NULL,
 CONSTRAINT [PK_DimDate] PRIMARY KEY CLUSTERED 
(
	[DataKey] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO


INSERT INTO [OMHurtowaniaLab].[dbo].DimDate
SELECT DISTINCT [Data] AS DataKey, DatePart(year,[data]) AS Year, DatePart(month,[data]) AS Month, DatePart(day,[data]) AS Day, 
DatePart(WEEKDAY,[data]) AS DayOfWeek, DatePart(QUARTER,[data]) AS Quarter
FROM [OMHurtowaniaLab].[dbo].[ZoneAlarmLog]

		
		
/* Ostatnia tabela DimDestination */

/****** Object:  Table [dbo].[DimDestination]    Script Date: 12/1/2019 3:16:43 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[DimDestination](
	[DestinationKey] [varchar](300) NOT NULL,
	[Destination] [varchar](300) NULL,
	[DestinationPort] [varchar](300) NULL,
	[DestinationType] [varchar](3) NULL,
 CONSTRAINT [PK_DimDestination] PRIMARY KEY CLUSTERED 
(
	[DestinationKey] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

INSERT INTO  [OMHurtowaniaLab].[dbo].[DimDestination]
SELECT DISTINCT [Destination] AS DestinationKey,
  --IP albo program
  CASE (CHARINDEX(':',[Destination]))
  WHEN 0
  THEN 
	[Destination]
  ELSE
	LEFT([Destination], cast(CHARINDEX(':',[Destination])-1 as int))
	END AS [Destination],
  --port albo program
  CASE (CHARINDEX(':',[Destination]))
  WHEN 0
  THEN 
	[Destination]
  ELSE
	RIGHT([Destination], DATALENGTH([Destination]) - cast(CHARINDEX(':',[Destination])as int))
	END AS [DestinationPort],
--jaki rodzaj source
  CASE (CHARINDEX(':',[Source]))
  WHEN 0
  THEN 
	'App'
  ELSE
	'IP'
	END AS SourceType
FROM [OMHurtowaniaLab].[dbo].[ZoneAlarmLog]