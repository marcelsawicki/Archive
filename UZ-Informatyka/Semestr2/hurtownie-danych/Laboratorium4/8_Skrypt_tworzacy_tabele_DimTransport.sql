/* ostatnia tabela DimTransport */

USE [OMHurtowaniaLab]
GO

/****** Object:  Table [dbo].[DimTransport]    Script Date: 12/1/2019 2:23:18 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[DimTransport](
	[TransportKEY] [varchar](300) NOT NULL,
	[Transport] [varchar](300) NULL,
	[TransportType] [varchar](300) NULL,
	[TransportSubType] [varchar](300) NULL,
	[TransportFlags] [varchar](300) NULL,
 CONSTRAINT [PK_DimTransport1] PRIMARY KEY CLUSTERED 
(
	[TransportKEY] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO


INSERT INTO [OMHurtowaniaLab].[dbo].[DimTransport](TransportKEY,Transport,TransportType,TransportSubType,TransportFlags)
SELECT DISTINCT [Transport] AS TransportKEY,
CASE (PATINDEX('Auto',Transport)) 
	WHEN 1 THEN RIGHT([Transport], 4) 
	ELSE
	(CASE (PATINDEX('ICMP%',Transport)) WHEN 1 THEN 'ICMP' 
		ELSE
		(CASE (PATINDEX('Manual%',Transport)) WHEN 1 THEN 'Manual'
			ELSE
				(CASE (PATINDEX('TCP%',Transport)) WHEN 1 THEN 'TCP'

					ELSE
						(CASE (PATINDEX('UDP%',Transport)) WHEN 1 THEN 'UDP'
						ELSE 'N/A'
					END) 
				END) 
			END) 
		END)
END AS Transport,

CASE (PATINDEX('%type%',Transport))
	WHEN 7 THEN SUBSTRING([OMHurtowaniaLab].[dbo].[ZoneAlarmLog].[Transport],12,PATINDEX('%/%',Transport)-PATINDEX('%type%',Transport)-5)
	ELSE
		''
	END AS TransportType,
CASE (PATINDEX('%subtype%',Transport))
	WHEN 0 THEN ' '
	ELSE
		SUBSTRING([OMHurtowaniaLab].[dbo].[ZoneAlarmLog].[Transport],PATINDEX('%subtype%',[OMHurtowaniaLab].[dbo].[ZoneAlarmLog].[Transport])+8,1) /*porawiony blad ze znakiem ':' */
	END AS TransportSubType,
CASE (PATINDEX('%flags%',Transport))
	WHEN 0 THEN ' '
	ELSE
		SUBSTRING([OMHurtowaniaLab].[dbo].[ZoneAlarmLog].[Transport],12,PATINDEX('%)%',Transport)-PATINDEX('%flags%',Transport)-6) 
	END AS TransportFlags
FROM [OMHurtowaniaLab].[dbo].[ZoneAlarmLog]

--TransportKEY, Transport, TransportType, TransportSubType, TransportFlags
