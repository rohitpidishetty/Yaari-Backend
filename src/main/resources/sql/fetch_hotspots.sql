select * from (
  select
    hotspot_id,
    hotspot_name,
    hotspot_type,
    ST_Distance_Sphere(point(lon, lat), point(?, ?)) / 1000 as distance_km
  from hotspots
  order by distance_km
) as hotspot
where distance_km <= ?;