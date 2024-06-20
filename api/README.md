# API do Sistema Meu Aluguel

Este projeto é uma API Spring Boot para o gerenciamento de contratos de locação de imóveis. Ele inclui autenticação baseada em JWT para proteger as rotas e oferece funcionalidades para cadastrar usuários, propriedades, e gerar contratos para serem assinados.

## Funcionalidades

- **Gerenciamento de Usuários**: Cadastro de novos usuários, definição de inquilinos (renters) e proprietários.
- **Gerenciamento de Propriedades**: Cadastro e atualização de propriedades.
- **Geração de Contratos**: Geração de contratos de locação em PDF.
- **Renovação de Contratos**: Rotina para renovação de contratos de locação.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- JPA (Java Persistence API)
- PostegreSQL
- Maven

## Pré-requisitos

- JDK 11 ou superior
- Maven 3.6.3 ou superior

## Instalação

1. Clone o repositório:

    ```bash
    git clone https://github.com/seu-usuario/gerenciamento-contratos-locacao.git
    cd gerenciamento-contratos-locacao
    ```

2. Compile o projeto usando Maven:

    ```bash
    mvn clean install
    ```

3. Execute a aplicação:

    ```bash
    mvn spring-boot:run
    ```

A aplicação estará disponível em `http://localhost:8080`.

## Funcionalidades Futuras

- **Autenticação JWT**: Proteger as rotas da API, permitindo apenas o acesso autenticado.
- **Notificações por Email**: Enviar notificações por email para locadores e locatários sobre vencimentos de contratos e outras atualizações importantes.
- **Histórico de Contratos**: Manter um histórico de contratos anteriores para referência futura.
- **Relatórios**: Gerar relatórios sobre contratos ativos, contratos próximos do vencimento e outros dados relevantes.
- **Controle de Pagamentos**: Implementar um sistema de controle de pagamentos de aluguel, incluindo registro de pagamentos realizados e pendentes.
- **Integração com Serviços de Assinatura Digital**: Permitir a assinatura digital de contratos diretamente através da API.
- **Gerenciamento de Usuários Avançado**: Implementar funcionalidades avançadas de gerenciamento de usuários, incluindo permissões e papéis personalizados.
