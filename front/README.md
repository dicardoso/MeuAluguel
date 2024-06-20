# Frontend do Sistema Meu Aluguel

Este projeto é o frontend do Sistema de Gerenciamento de Contratos de Locação, uma aplicação web que permite aos usuários administrar contratos de locação de imóveis. Ele se comunica com a API desenvolvida em Spring Boot para fornecer uma interface amigável e eficiente para os locadores e locatários.

## Funcionalidades

- **Cadastro de Usuários**: Permite que novos usuários se registrem e sejam definidos como locatários.
- **Cadastro de Propriedades**: Facilita a adição de novas propriedades ao sistema.
- **Geração de Contratos**: Interface para criar novos contratos de locação, com pré-visualização e edição. 
- **Renovação de Contratos**: Opção para renovar contratos existentes.
- **Autenticação de Usuários**: Login e controle de acesso baseado em tokens JWT. 
- **Dashboard**: Visão geral dos contratos, propriedades e usuários.
- **Notificações**: Alertas e notificações para eventos importantes, como vencimento de contratos.

## Tecnologias Utilizadas

- **Vue.js**: Framework JavaScript progressivo para construir interfaces de usuário.
- **Nuxt.js**: Framework para Vue.js com suporte para renderização no lado do servidor (SSR).
- **Pinia**: Gerenciamento de estado para aplicações Vue.js.
- **Vuetify**: Biblioteca de componentes UI para Vue.js.

## Estrutura do Projeto

```plaintext
front/
│
├── .nuxt/                  # Diretório gerado automaticamente pelo Nuxt.js
├── components/             # Componentes Vue reutilizáveis
├── node_modules/           # Dependências do projeto
├── pages/                  # Páginas individuais da aplicação
├── plugins/                # Plugins Vue
├── public/                 # Arquivos estáticos públicos
├── server/                 # Código do lado do servidor (Nuxt.js)
├── .eslintrc.cjs           # Configuração do ESLint
├── .gitignore              # Arquivos e diretórios ignorados pelo Git
├── .prettierrc             # Configuração do Prettier
├── nuxt.config.ts          # Configuração do Nuxt.js
├── package.json            # Dependências do projeto e scripts
├── tsconfig.json           # Configuração do TypeScript
├── yarn.lock               # Arquivo de bloqueio do Yarn
└── README.md               # Documentação do projeto
```

## Instalação e configuração

1. Compile o projeto usando Maven:

    ```bash
    yarn install
    ```
2. Configure as variáveis de ambiente no arquivo .env.
2. Execute a aplicação:

    ```bash
    yarn dev
    ```

A aplicação estará disponível em `http://localhost:3000`.