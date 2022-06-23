const fs = require('fs');
const apiBenchmark = require('api-benchmark');

const services = {
  elastic: 'http://localhost:8080/api/elastic/products/search/',
  postgres: 'http://localhost:8080/api/postgres/products/search/',
};

const routes = { milk: 'milk', carton: 'carton' };

apiBenchmark.compare(services, routes, function (err, results) {
  fs.writeFile('/app/output/results.json', JSON.stringify(results), (err) => {
    if (err) throw err;
    console.log('File successfully written to disk');
  });
});
