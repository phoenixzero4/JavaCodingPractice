USE PHOENIX_DATA;

INSERT INTO USERS ( USERS.FIRSTNAME, USERS.LASTNAME )
VALUES            ( 'Phoenix',       'Paul'         ),
                  ( 'Gloria',        'Froese'       ),
                  ( 'William',       'Paul'         ),
                  ( 'Alexandra',     'Paul'         ),
                  ( 'Brodi',         'Paul'         );

INSERT INTO USERDATA ( USERID, PASSWORD,   CREATED      )
VALUES               ( 1,      'password', CURRENT_DATE ),
                     ( 2,      'letmein',  CURRENT_DATE ),
                     ( 3,      'dad',      CURRENT_DATE ),
                     ( 4,      'gisleepy', CURRENT_DATE );

INSERT INTO USERDATA ( USERID, PASSWORD, CREATED )
VALUES ( 5, 'pass', CURRENT_DATE );

SELECT *
FROM USERS U,
     USERDATA UD
WHERE U.ID = UD.USERID;