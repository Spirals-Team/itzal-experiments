#!/bin/bash
set -m

echo "Start DB"
gosu postgres pg_ctl -D /var/lib/postgresql/data start  > /dev/null &

sleep 1
cd mayocat-shop/shop/application
./startup_development.sh debug > /dev/null &
sleep 5
echo "Start Server"
curl -s -i -H "Content-Type: application/json" -X POST -d " \
  {                                                      \
    \"slug\"    : \"admin\",                             \
    \"email\"   : \"me@example.com\",                    \
    \"password\": \"password\"                           \
  }                                                      \
  "                                                      \
  http://localhost:8080/api/user/  > /dev/null

curl -i -H "Content-Type: application/json" -X PUT -d "{\"shipping\":{\"strategy\":\"flat\"}}" \
  http://admin:password@localhost:8080/api/configuration/settings > /dev/null

curl -i -H "Content-Type: application/json" -X POST -d "{\"isNew\":true,\"strategy\":\"flat\",\"rules\":[],\"title\":\"Zone\"}" \
  http://admin:password@localhost:8080/api/shipping/carrier/ > /dev/null

curl -i -H "Content-Type: application/json" -X POST -d "{\"slug\":\"\",\"_localized\":{},\"addons\":{},\"title\":\"Product\"}" \
  http://admin:password@localhost:8080/api/products/ > /dev/null

curl -i -H "Content-Type: application/json" -X POST -d "{\"_href\":\"/api/products/product\",\"slug\":\"product\",\"title\":\"Product\",\"description\":\"\",\"onShelf\":true,\"vatRate\":null,\"addons\":{},\"_embedded\":{\"images\":[],\"tenant\":{\"slug\":\"shop\",\"name\":null,\"description\":null,\"contactEmail\":null,\"defaultHost\":null,\"creationDate\":null}},\"_relationships\":{\"collections\":[]},\"creationDate\":\"2016-07-08T14:17:29+02:00\",\"_links\":{\"self\":{\"href\":\"/api/products/product\"},\"images\":{\"href\":\"/api/products/product/images\"}},\"_localized\":{},\"price\":1,\"weight\":\"1\",\"stock\":\"1\"}" \
  http://admin:password@localhost:8080/api/products/product > /dev/null
  
ip=$(ifconfig | grep -Eo 'inet (addr:)?([0-9]*\.){3}[0-9]*' | grep -Eo '([0-9]*\.){3}[0-9]*' | grep -v '127.0.0.1')

echo "Server started"

echo "Home: http://$ip:8080"
echo "Admin: http://$ip:8080/admin/ (Username: admin, Password: password)"

fg %2