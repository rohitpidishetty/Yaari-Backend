select user_name, profile_picture, bio_status
    from friendships _f
    join users _u
    on _u.user_name = _f.friend_id
    where _f.user_id = ?;