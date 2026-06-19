use yaari;


select * 
  from users
  where user_name = "rohit_pidishetty";
  
  
select * 
  from   posts 
  where post_owner = "aman"
  order by post_time_of_upload
  desc;