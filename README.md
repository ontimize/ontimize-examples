
# Ontimize Boot

- Enter the parent directory and run an install:

		mvn install

## Start the database

 Enter the `projectwiki-model` folder and execute the command

		mvn exec:java -Prun_database

## Start the server:
 - Go to the `projectwiki-boot` folder and run the command

		mvn spring-boot:run

Use the following URL to access the [https://localhost:33333/](https://localhost:33333/) application

## Start the client alone

 - Go to the `projectwiki-frontend/src/main/ngx` folder, if you have node and npm installed on your system run the following commands:

		npm install
		npm start (local development)

or

		npm run production (production)


# ADDITIONAL INFORMATION

  - Start S3 server:
    docker compose up

  - Stop S3 server:

		docker-compose down
		docker volume prune
