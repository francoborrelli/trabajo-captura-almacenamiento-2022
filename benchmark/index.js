const fs = require('fs');
const apiBenchmark = require('api-benchmark');

const services = {
  elastic: 'http://api:8080/api/elastic/products/search/',
  postgres: 'http://api:8080/api/postgres/products/search/',
};

const rawdata = fs.readFileSync('./input/words.json');

const { results: words } = JSON.parse(rawdata);

const routes = words.slice(0, 50).reduce((prev, curr) => {
  prev[curr.word] = curr.word;
  return prev;
}, {});

apiBenchmark.compare(
  services,
  routes,
  { debug: true, runMode: 'sequence', minSamples: 20 },
  function (err, results) {
    console.log(results);
    fs.writeFile('/app/output/results.json', JSON.stringify(results), (err) => {
      if (err) throw err;
      console.log('File successfully written to disk');
    });
  }
);
