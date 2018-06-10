create or replace TYPE        card_obj IS OBJECT(
       msisdn number(19), 
       pan number(19), 
       expire date
       );

create or replace TYPE        card_table IS TABLE OF CARD_OBJ;

create or replace function        get_table
   (number_msisdn_in IN number )
return card_table
is
card_table_v card_table := card_table();
     n integer := 0;
  begin
     for r in (select MSISDN,PAN,EXPIRE from CARDS INNER JOIN SUBSCRIBERS ON SUBSCRIBER_ID=SUBSCRIBERS.ID WHERE SUBSCRIBERS.msisdn=number_msisdn_in)
     loop
        card_table_v.extend;
        n := n + 1;
        card_table_v(n) := card_obj(r.MSISDN,r.pan,r.expire);
     end loop;
     return card_table_v;
  end;