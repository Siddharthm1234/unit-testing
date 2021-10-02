-- don't need to do explicitly because H2
-- Will need to do if using Persistent Dev DB for Testing also
delete from item where id in (1,2,3);
