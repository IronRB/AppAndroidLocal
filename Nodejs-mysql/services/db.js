const mysql = require('mysql');
const config = require('../config/config');

async function query(sql,params) {
  console.log(config.db)
  const connection = await mysql.createConnection(config.db);
  connection.connect(function(err) {
    if (err) throw err;
      console.log("Connected!");
    connection.query(sql, params, function (err, result) {
      if (err) throw err;
      connection.end();
    });
  });
  console.log({messageQuery: new Date().toDateString()});
  return;
}

module.exports = {
  query
}