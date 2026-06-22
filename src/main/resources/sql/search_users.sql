select *
  from users
  where user_name like ?
  or fullname like ?;