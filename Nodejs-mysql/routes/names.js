const express = require('express');
const router = express.Router();
const names = require('../services/names')

router.post('/', async function(req, res, next) {
    try {
      console.log(req.body)
      res.json(await names.create(req.body));
    } catch (err) {
      console.error(`Error while creating name`, err.message);
      next(err);
    }
  });
  
  module.exports = router;