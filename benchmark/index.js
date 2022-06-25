const fs = require('fs');
const apiBenchmark = require('api-benchmark');

const services = {
  elastic: 'http://api:8080/api/elastic/products/search/',
  postgres: 'http://api:8080/api/postgres/products/search/',
};

const benchmarkOptions = {
  debug: true, // (Boolean, default false): Displays some info on the console.

  runMode: 'sequence', // (String, default 'sequence'): Can be 'sequence' (each request is made after receiving the previous response) or 'parallel' (all requests are made in parallel).

  minSamples: 20, // (Number, default 20): The minimum sample size required to perform statistical analysis.
};

const showMessage = (message) => {
  console.log(' ---------------------------------------');
  console.log(`|           ${message.toUpperCase()}           |`);
  console.log(' ---------------------------------------');
};

const getRoutes = () => {
  const rawdata = fs.readFileSync('./input/words.json');
  const { results: words } = JSON.parse(rawdata);
  return words.reduce((prev, curr) => {
    prev[curr.word] = curr.word;
    return prev;
  }, {});
};

const saveFile = (filename, content) => {
  fs.writeFileSync(filename, content, (err) => {
    if (err) throw err;
  });
};

const saveJSONResult = (results) => {
  saveFile('/app/output/results.json', JSON.stringify(results));
};

const saveDetailsHTMLResult = (results) => {
  Object.keys(results).forEach((server) => {
    Object.keys(results[server]).forEach((route) => {
      if (results[server][route].response) {
        results[server][route].response.body = null;
      }
    });
  });
  apiBenchmark.getHtml(results, function (error, html) {
    saveFile('/app/output/report.html', html);
  });
};

const getGeneralStats = (results) => {
  // calcula el promedio de tiempo de respuesta para todos los resultados del arreglo
  const calculateAvg = (data) =>
    data.filter((s) => s.stats && s.stats.mean).reduce((prev, curr) => prev + curr.stats.mean, 0) /
    data.filter((s) => s.stats && s.stats.mean).length;

  // se queda con aquellos resultados donde resultó la respuesta más rápida.
  const calculateWinnings = (data) => data.filter((r) => r.isFastest);

  // calcula el promedio de tiempo de respuesta para todos los resultados del arreglo
  const calculateStats = (results) => {
    return [calculateAvg(results), calculateWinnings(results)];
  };

  const [avgElasticTime, elasticWinnings] = calculateStats(Object.values(results.elastic));
  const [avgPostgresTime, postgrestWinnings] = calculateStats(Object.values(results.postgres));

  showMessage('Resultado general');
  console.log(`------------------------------------------------------------------`);

  console.log(`Resultados Elasticsearch:`);
  console.log(`Fue más rápido en: ${elasticWinnings.length} términos.`);
  console.log(`Tuvo un tiempo promedio de respuesta de : ${avgElasticTime} seg.`);

  console.log(`------------------------------------------------------------------`);

  console.log(`Resultados Postgres:`);
  console.log(`Fue más rápido en: ${postgrestWinnings.length} términos.`);
  console.log(`Tuvo un tiempo promedio de respuesta de : ${avgPostgresTime} seg.`);

  console.log(`------------------------------------------------------------------`);
};

const runBenchmark = () => {
  showMessage('Comenzando prueba');
  const routes = getRoutes();
  apiBenchmark.measure(services, routes, benchmarkOptions, function (err, results) {
    saveJSONResult(results);
    saveDetailsHTMLResult(results);
    getGeneralStats(results);
    showMessage('Prueba finalizada');
  });
};

runBenchmark();
