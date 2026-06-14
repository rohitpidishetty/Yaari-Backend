select *
  from posts
  where post_owner in (
    select friend_id
      from friendships
      where user_id = ?
      union
      select ?
  )
  and (
    post_time_of_upload < ?
  )
order by post_time_of_upload
desc
limit 4;