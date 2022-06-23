var apiBenchmark = require('api-benchmark');

var services = {
  elastic: 'http://localhost:8080/api/elastic/products/search/',
  postgres: 'http://localhost:8080/api/postgres/products/search/',
};

var routes = { milk: 'milk', carton: 'carton' };

apiBenchmark.compare(services, routes, function (err, results) {
  console.log(results.elastic.milk.stats);
  // displays some stats, including the winner!
});
