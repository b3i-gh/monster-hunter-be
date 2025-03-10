# MONSTER-HUNTER: backend application


## Description
This project is a simple spring backend application that allows users to keep track of their monster energy drink cans collection.
The backend is connected to a PostgreSQL database and exposes a set of REST APIs to interact with the data, from a frontend app or a mobile app.

## Usage
 - run `docker-compose up` to run the docker container with the database
 - run the backend app with `spring-boot:run`
 - connect through the mobile app or via postman to interact with the APIs

## Available APIs
 - GET /api/v1/cans : returns the list of all cans
 - POST /api/v1/cans : insert a new can into the collection 
 - GET /api/v1/cans/{id} : retrieve a can and its details by id
 - PUT /api/v1/cans/{id} : update a can's details
 - DELETE /api/v1/cans/{id} : delete a can from the collection

### Versions
 - 1.0.0 : initial version
    - implemented basic CRUD APIs to manage directly the collection

### Future implementations:
 - image upload from the mobile app
 - barcode recognition (possibly a front-end feature)
 - mobile synchronization with the backend for offline usage