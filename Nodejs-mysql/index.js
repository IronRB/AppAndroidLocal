const express = require('express');
const server = express();
const config = require('./config/config');
const port = config.port;
const namesRouter = require('./routes/names')
const cors = require("cors");

server.use(cors());

server.use(express.json());
server.use(express.urlencoded({ extended: true }));

server.get('/', (req, res) => {
  res.json({'message': 'Connect successfully'});
})

server.use('/posts', namesRouter);

server.listen(port, () => {
  console.log(`Server listening at http://localhost:${port}`)
});