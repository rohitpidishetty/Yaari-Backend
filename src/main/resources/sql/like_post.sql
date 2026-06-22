insert into
    likes (post_id, liked_by, liked_at)
    values (?, ?, now());
