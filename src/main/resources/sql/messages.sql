select *
  from messages
  where (sender_username = ? and receiver_username = ?)
  or (sender_username = ? and receiver_username = ?)
  order by messaged_at
  asc;