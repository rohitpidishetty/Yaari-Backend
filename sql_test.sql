use yaari;


select * 
  from users
  where user_name = "rohit_pidishetty";
  
  
select * 
  from   posts 
  where post_owner = "rohit_pidishetty"
  and post_time_of_upload < 1749971080215
  order by post_time_of_upload
  desc
  limit 2;


select user_name, count(post_id) as total_posts
  from users _u
  join posts _p
  on _u.user_name = _p.post_owner
  group by user_name
  order by total_posts
  desc;