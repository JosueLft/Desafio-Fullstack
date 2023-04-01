# Desafio Full-Stack

## Entidades bases

### Empresa
- CNPJ
- Nome Fantasia
- CEP

### Fornecedor
- CNPJ ou CPF
- Nome
- E-mail
- CEP

## Tecnologias utilizadas
- Java Spring
- Angular
- PostgreSQL

## Instruções de instalação e uso
- Clonar o repositório

##### Front-End
- Rodar o comando `npm install` para instalar as dependências do back-end
- Rodar o comando `npm run dev` para iniciar o servidor do back-end
- Entrar na pasta `frontend` e rodar o comando `npm install` para instalar as dependências do front-end
- Rodar o comando `npm start` para iniciar o servidor do front-end
- Acessar a aplicação em `http://localhost:4200/` no navegador.

##### Back-End
- Baixar e configurar banco de dados postgresql.
- Crie uma base de dados com o nome que preferir.
- Criar arquivo `application.properties` com as informações do ambiente e configurações de conexão com o banco.

- `application.properties`
> `spring.profiles.active=dev`<br>
> `spring.jpa.open-in-view=true`<br>

- `application-dev.properties`
> `spring.datasource.url=jdbc:postgresql://localhost:5432/{DATABASE-NAME}`<br>
> `spring.datasource.username={USER-NAME}`<br>
> `spring.datasource.password={PASSWORD-DATABASE}`<br>
> 
> `spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true`<br>
> `spring.jpa.hibernate.ddl-auto=update`<br>
> `spring.jpa.show-sql=true`<br>
> `spring.jpa.properties.hibernate.format_sql=true`<br>

## Autores
Este projeto foi desenvolvido por [Nome do desenvolvedor].