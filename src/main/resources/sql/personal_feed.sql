select *
  from (
    select _p.*, coalesce(likes.total_likes, 0) as total_likes
      from posts _p
      left join (
        select post_id, count(liked_by) as total_likes
          from likes
          group by post_id
      ) likes
      on _p.post_id = likes.post_id
  ) as p
  where post_owner = ?
  and post_time_of_upload < ?
  order by post_time_of_upload
  desc
  limit 2;