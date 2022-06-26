const fs = require('fs');

const { results: words } = JSON.parse(fs.readFileSync('./input/words.json'));

const tinyOcurrencesWords = words.filter((w) => w.ndoc <= 10).map((w) => w.word);

const smallOcurrencesWords = words.filter((w) => w.ndoc > 10 && w.ndoc <= 2500).map((w) => w.word);

const mediumOcurrencesWords = words
  .filter((w) => w.ndoc > 2500 && w.ndoc <= 5000)
  .map((w) => w.word);

const largeOcurrencesWords = words
  .filter((w) => w.ndoc > 5000 && w.ndoc <= 8000)
  .map((w) => w.word);

const bigOcurrencesWords = words.filter((w) => w.ndoc > 8000).map((w) => w.word);

const calculateMean = (dataset, words) => {
  let totalMean = 0;
  let totalResults = 0;

  words.forEach((word) => {
    totalMean = totalMean + (dataset[word] && dataset[word].stats ? dataset[word].stats.mean : 0);
    totalResults = totalResults + 1;
  });
  return totalMean / totalResults;
};

const handleServer = (data, server) => {
  console.log(`---------------------------------------------------------`);

  console.log(`Tiempo de respuesta promedio para ${server}:`);

  console.log(
    `Palabras con muy poca frecuencia ${calculateMean(data[server], tinyOcurrencesWords)}:`
  );
  console.log(`Palabras con poca frecuencia ${calculateMean(data[server], smallOcurrencesWords)}:`);
  console.log(
    `Palabras con frecuencia medianta ${calculateMean(data[server], mediumOcurrencesWords)}:`
  );
  console.log(`Palabras con frecuencia alta ${calculateMean(data[server], largeOcurrencesWords)}:`);
  console.log(
    `Palabras con frecuencia muy alta ${calculateMean(data[server], bigOcurrencesWords)}:`
  );
};

const run = () => {
  const results = JSON.parse(fs.readFileSync('./output/results.json'));
  handleServer(results, 'elastic');
  handleServer(results, 'postgres');
};

run();
