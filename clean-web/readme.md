
# Api rest

* Swagger
````
    http://localhost:8080/swagger-ui/index.html#
    
````

* User
````
    http://localhost:8080/api/venturarh/user
````
````
    Get Index
    
    http://localhost:8080/api/venturarh/user/{cpf}
````
````
    Post
    Create
    
    http://localhost:8080/api/venturarh/user/create
````
````
    Post
    Create Curriculum
    
    http://localhost:8080/api/venturarh/user/create/curriculum
````
````
    Put
    Edicao
    
    http://localhost:8080/api/venturarh/user/edit{cpf}
````

* Customer
````
    http://localhost:8080/api/venturarh/customer
````
````
    Get Index
    
    http://localhost:8080/api/venturarh/customer/{uid}
````
````
    Get
    listAllJobOpportunity
    
    http://localhost:8080/api/venturarh/customer/{cpf}/job-opportunity
````
````
    Post
    Create 
    
    http://localhost:8080/api/venturarh/customer/create
````
````
    Put
    Edicao
    
    http://localhost:8080/api/venturarh/customer/edit{cpf}
````

* Company
````
    http://localhost:8080/api/venturarh/company
````
````
    Get Index
    
    http://localhost:8080/api/venturarh/company/{cnpj}
````
````
    Post
    Create
    
    http://localhost:8080/api/venturarh/company/create{who}
````
````
    Put
    Edicao
    
    http://localhost:8080/api/venturarh/company/edit{cnpj}/{who}
````
* Admin
````
    http://localhost:8080/api/venturarh/admin
````
````
    Get Index
    
    http://localhost:8080/api/venturarh/admin/{cpf}
````
````
    Post 
    Create
    
    http://localhost:8080/api/venturarh/admin/create/{who}
````
* JobOpportunity
````
    http://localhost:8080/api/venturarh/job-opportunity
````
````
    Get Index
    
    http://localhost:8080/api/venturarh/job-opportunity
````
````
    Post 
    Create
    
    http://localhost:8080/api/venturarh/job-opportunity/create/{who}
````
````
    Get 
    
    http://localhost:8080/api/venturarh/job-opportunity/customer-opportunity/{id}
````
````
    Put 
    Edição
    
    http://localhost:8080/api/venturarh/job-opportunity/{id}
````
````
    Delete
    Delete
    
    http://localhost:8080/api/venturarh/job-opportunity/{id}
````
* answer-opportunity
````
    http://localhost:8080///venturarh/answer-opportunity/
````
````
    Post Create
    
    http://localhost:8080/api/venturarh/answer-opportunity/create/{uid}
````
* criterion
````
    http://localhost:8080/api/venturarh/criterion
````
````
    Post Create
    
    http://localhost:8080/api/venturarh/criterion/details/{id}
````