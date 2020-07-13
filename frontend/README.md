List of commandes to run before using the generated Angular: 
>npm install (for all the normally needed node_modules)
>
>npm install bootstrap font-awesome --save
>
>npm install primeng --save
>
>npm install primeicons --save
>
>npm install @angular/animations --save

You can run the angular project using:
>ng serve -o --port 4201

If you are using our generated back-end make sure to change the
port in the CorsConfig Class in the back-end to the port you
are using here.

Optional: If you open the project in WebStorm , right click on
the app folder and click on "Reformat Code".

## Pour se connecter utiliser l'un de ces utilisateurs:
* Admin
    {
        "authorityVo": {
            "authority": "Admin"
        },
        "code": "admin1",
        "email": "admin@gmail.com",
        "enabled": "true",
        "firstName": "adminFirst",
        "lastName": "adminLast"
    }   

    Mot de passe admin est **admin** : coller **$2a$10$54McHJIlxPGxOR.UYEW7iekDb/0eW0xrcK6oLhn8.Lo0mElkwf8hi** dans le champs password de la bd
* Validator
    {
        "authorityVo": {
            "authority": "Validator"
        },
        "code": "validator1",
        "email": "validator@gmail.com",
        "enabled": "true",
        "firstName": "validatorFirst",
        "lastName": "validatorLast"
    }
    Mot de passe Validator est **validator**: coller **$2a$10$zVjSow8Ypikn5V5yG4YWtOwUMlBvYU3JbS.pa8fYL5ezFhBHawhFe** dans le champs password de la bd
* Delivery
    {
        "authorityVo": {
            "authority": "Delivery"
        },
        "code": "delivery1",
        "email": "delivery@gmail.com",
        "enabled": "true",
        "firstName": "deliveryFirst",
        "lastName": "deliveryLast"
    }
    Mot de passe de Delivery est **delivery** : coller **$2a$10$O9fj1nblleh9yyotW.J68eJOmqPJMA0jZJuW9J3VefpPygPkrJFd.** dans le champs password de la bd
