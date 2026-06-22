select _u.user_name, _u.profile_picture
  from users _u
  right join (
    select _l.liked_by, _l.liked_at
      from likes _l
      where post_id = ?
  ) liked_by_users
  on _u.user_name = liked_by_users.liked_by;

