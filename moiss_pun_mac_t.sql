-- =========================================================================
-- $Header$
--
-- Name                               : moiss_pun_mac_t.sql
--
-- Description     : Table Creation Scripts for  Moiss Punching Machine Project
--
--
-- Who                                            Remarks                                 Date
-- --------------                           --------------------------------------- -----------------
-- Gowtham Raam.J -4iApps                         1.0 - Initial Version                 05-Dec-2013
-- =========================================================================
/*TABLE -1     :           VIEW DOCUMENT            */
CREATE TABLE MOISS_PUNCH_INFO
(
PUNCH_INFO_ID              NUMBER                 NOT NULL,         
PUNCH_CODE 		   VARCHAR2(30),
EMPLOYEE_NUMBER            VARCHAR2(30), 
EMPLOYEE_NAME              VARCHAR(240),                    
PUNCH_DATE                 VARCHAR2(30),
STATE                      VARCHAR2(30),
NEW_STATE                  VARCHAR2(30),
EXCEPTION                  VARCHAR2(30),
DEPARTMENT                 VARCHAR2(30),      
MAN_ENTRY_YN               VARCHAR2(1),
REMARKS                    VARCHAR2(2000), 
PROC_YN			   VARCHAR(1),					--PROCESS FLAG
PROC_USER_ID		   VARCHAR(30),					--PROCESS USER ID
PROC_DATE		   VARCHAR(60),					--PROCESS DATE
ATT_ID			   VARCHAR(60),					--ATT ID FROM MOISS_EMP_ATTENDANCE WHICH IS A SEQUENCE NUMBER GETS STORED
ATTRIBUTE_CATEGORY         VARCHAR2(240),
ATTRIBUTE1                 VARCHAR2(240),
ATTRIBUTE2                 VARCHAR2(240),
ATTRIBUTE3                 VARCHAR2(240),
ATTRIBUTE4                 VARCHAR2(240),
ATTRIBUTE5                 VARCHAR2(240),
ATTRIBUTE6                 VARCHAR2(240),
ATTRIBUTE7                 VARCHAR2(240),
ATTRIBUTE8                 VARCHAR2(240),
ATTRIBUTE9                 VARCHAR2(240),
ATTRIBUTE10                VARCHAR2(240),
CREATED_BY                 NUMBER,
CREATION_DATE              DATE,
LAST_UPDATED_BY            NUMBER,
LAST_UPDATE_DATE           DATE,
LAST_UPDATE_LOGIN          NUMBER
);


ALTER TABLE MOISS_PUNCH_INFO ADD 
CONSTRAINT MOISS_PUNCH_INFO_ID_PK PRIMARY KEY (PUNCH_INFO_ID) USING INDEX;

 



CREATE SEQUENCE MOISS_PUNCH_INFO_ID_S START WITH 1 NOCYCLE  NOCACHE ;            --FOR SEQUENCE NUMBER ON TABLE 1



GRANT ALL ON MOISS_PUNCH_INFO TO APPS;
GRANT ALL ON MOISS_PUNCH_ID_S TO APPS;