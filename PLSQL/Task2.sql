create or replace Function Get_Count
   (number_msisdn_in IN number )

   RETURN number
IS
   count_result number;
BEGIN
  SELECT COUNT(*) into count_result FROM SUBSCRIBERS INNER JOIN
     CARDS ON SUBSCRIBERS.ID=CARDS.SUBSCRIBER_ID WHERE SUBSCRIBERS.msisdn=number_msisdn_in;
RETURN count_result;
END;