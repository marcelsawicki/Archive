USE [OMHurtowaniaLab]
GO

/****** Object:  Table [dbo].[ZoneAlarmLog]    Script Date: 11/23/2019 7:09:51 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[ZoneAlarmLog](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Zdarzenie] [varchar](50) NULL,
	[Data] [datetime] NULL,
	[Czas] [datetime] NULL,
	[Source] [varchar](300) NULL,
	[Destination] [varchar](300) NULL,
	[Transport] [varchar](300) NULL,
 CONSTRAINT [PK_ZoneAlarmLog] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO


