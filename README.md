# Backend dev technical test
Show similar products to the one they are currently seeing. To do this we agreed with our front-end applications to create a new REST API operation that will provide them the product detail of the similar products for a given one. 

You have to start the mocks and other needed infrastructure with the following command.
```
docker-compose up -d simulado influxdb grafana
```
Check that mocks are working with a sample request to [http://localhost:3001/product/1/similarids](http://localhost:3001/product/1/similarids).

The app invocation [http://localhost:5000/product/1/similar](http://localhost:5000/product/1/similar).

Swagger info [http://localhost:5000/swagger-ui/index.html](http://localhost:5000/swagger-ui/index.html)

