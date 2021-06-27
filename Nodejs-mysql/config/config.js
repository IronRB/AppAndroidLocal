const env = process.env;

const config = {
  db: { 
    host: env.DB_HOST || 'localhost',
    user: env.DB_USER || 'root',
    password: env.DB_PASSWORD || '123456',
    database: env.DB_NAME || 'mydb',
  },
  port: env.PORT || 3000,
};

module.exports = config;