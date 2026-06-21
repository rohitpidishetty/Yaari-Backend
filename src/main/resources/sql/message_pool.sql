select _u.user_name,
       _u.profile_picture,
       message_pool.sender_username,
       message_pool.receiver_username,
       message_pool.message_payload
from users _u
  join (
    select *
      from (
          select m.*,
                case
                    when sender_username = ?
                        then receiver_username
                    else sender_username
                end as friend_username,
                row_number() over (
                    partition by
                        case
                            when sender_username = ?
                                then receiver_username
                            else sender_username
                        end
                    order by messaged_at desc
                ) as rn
          from messages m
          where sender_username = ?
            or receiver_username = ?
      ) t
    where rn = 1
    order by messaged_at desc
  ) message_pool
where _u.user_name = message_pool.friend_username;
