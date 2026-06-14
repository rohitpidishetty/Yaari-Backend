select *
    from posts
    where post_owner = ?
    order by post_time_of_upload
    desc;