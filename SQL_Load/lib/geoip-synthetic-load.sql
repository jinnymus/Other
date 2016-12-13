set SERVEROUTPUT ON
declare 
l NUMBER;
n number;
iterations NUMBER := 1000; --количество итераций вложенного цикла
cursor intervals is select start_interval, end_interval from dict_geo_ip
where COUNTRY like '%RU%';
begin 
for rec1 in intervals loop
  FOR i IN 1..iterations
  LOOP
     select floor(dbms_random.value(rec1.start_interval,rec1.end_interval)) into l from dual;
    --DBMS_OUTPUT.PUT_LINE(l); 
    SELECT region_id into n FROM dict_geo_regions, dict_geo_ip, dict_geo_cities 
       WHERE dict_geo_regions.region_name=dict_geo_cities.region 
       AND dict_geo_cities.id =dict_geo_ip.city_id
       AND dict_geo_ip.start_interval <= l  
       AND dict_geo_ip.end_interval >= l; 
      DBMS_OUTPUT.PUT_LINE(n); 
end loop;
end loop;
end;