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

console.log(' ---------------------------------------');
console.log('|           COMENZANDO PRUEBA           |');
console.log(' ---------------------------------------');

apiBenchmark.measure(
  services,
  routes,
  { debug: true, runMode: 'sequence', minSamples: 20 },
  function (err, results) {
    console.log(' ---------------------------------------');
    console.log('|           PRUEBA FINALIZADA           |');
    console.log(' ---------------------------------------');

    // se guarda el json con resultados
    fs.writeFile('/app/output/results.json', JSON.stringify(results), (err) => {
      if (err) throw err;
      console.log('File successfully written to disk');
    });

    // se guarda el reporte html con resultados
    apiBenchmark.getHtml(results, function (error, html) {
      fs.writeFile('/app/output/report.html', html, (err) => {
        if (err) throw err;
      });
    });
  }
);
