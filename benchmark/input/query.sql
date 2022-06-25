-- Query utilizada para la obtención de los terminos a utilizar como input en las pruebas del benchmark


-- terminos con muchas ocurrencias unicas producto
SELECT *                                       
FROM ts_stat($$SELECT tsvector_search FROM products$$) 
ORDER  BY ndoc DESC
LIMIT 200;

-- terminos cercanos a la mediana de la ocurrencia media producto - no se analizara, ya que coincide con los valores mas bajos (1 ocurrencia en todos los terminos)
-- SELECT *                                       
-- FROM ts_stat($$SELECT tsvector_search FROM products$$) 
-- ORDER  BY ndoc DESC 
-- LIMIT  1000
-- OFFSET((SELECT COUNT(*) FROM ts_stat($$SELECT tsvector_search FROM products$$)) / 2 - 50);

-- terminos cercanos a la ocurrencia mediana, pero descartando el grupo de valores de ocurrencia 1
SELECT *                                       
FROM ts_stat($$SELECT tsvector_search FROM products$$) 
WHERE ndoc > 1
ORDER  BY ndoc DESC 
LIMIT  200
OFFSET((SELECT COUNT(*) FROM ts_stat($$SELECT tsvector_search FROM products$$) WHERE ndoc > 1) / 2 - 50);

-- la moda tampoco vale la pena, ya que coincide con la ocurrencia mas baja (1)
-- SELECT ndoc, COUNT(*) count                                 
-- FROM ts_stat($$SELECT tsvector_search FROM products$$) 
-- GROUP BY ndoc
-- ORDER BY COUNT(*) DESC
-- LIMIT 1;

SELECT *                                       
FROM ts_stat($$SELECT tsvector_search FROM products$$) 
WHERE ndoc > 1
ORDER  BY ndoc DESC 
LIMIT  200
OFFSET((SELECT COUNT(*) FROM ts_stat($$SELECT tsvector_search FROM products$$) WHERE ndoc > 1) / 2 - 50);

-- terminos cercanos a la ocurrencia promedio (aprox 6.48)
SELECT word, ndoc                                   
FROM ts_stat($$SELECT tsvector_search FROM products$$)
GROUP BY word, ndoc
HAVING ndoc BETWEEN 6 AND 7
ORDER BY random()
LIMIT 200;

-- terminos con ocurrencias mas bajas
SELECT *                                       
FROM ts_stat($$SELECT tsvector_search FROM products$$) 
ORDER  BY ndoc ASC
LIMIT  200;