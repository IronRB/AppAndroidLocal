const db = require('./db');

async function create(person){
    await db.query(
      `INSERT INTO persons 
      (name) 
      VALUES 
      (?)`, 
      [
        person.name
      ]
    );

    let name = 'Name created successfully';
  
    return {name};
  }
  
  module.exports = {
    create
  }