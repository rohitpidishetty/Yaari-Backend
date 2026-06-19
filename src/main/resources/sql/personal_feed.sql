select *
  from posts
  where post_owner = ?
  and post_time_of_upload < ?
  order by post_time_of_upload
  desc
  limit 2;