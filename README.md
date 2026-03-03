# 🎵 Aura Music

## Metodologia: Abordagem Baseada em Projeto
Este projeto foi concebido como um desafio prático, com o objetivo de projetar, desenvolver e colocar em produção uma aplicação web funcional. A abordagem prioriza a resolução de um problema de domínio real, explorando tecnologias tanto no lado do cliente (frontend) quanto no lado do servidor (backend), além de aplicar boas práticas de engenharia de software e infraestrutura.

## Domínio do Problema
O sistema é uma plataforma web de streaming projetada para amantes de música. O objetivo principal é permitir que usuários descubram, ouçam e organizem suas faixas favoritas de maneira intuitiva, com uma experiência fluida de reprodução de áudio.

## Arquitetura e Padrões
O projeto adota uma arquitetura **Monolítica** modular no backend. Essa escolha simplifica o fluxo de CI/CD inicial e a infraestrutura, mas o código será estruturado de forma coesa (separado por domínios) para facilitar uma futura migração para **Microserviços**. 
Utilizaremos o padrão arquitetural **MVC** (Model-View-Controller) no design da API e aplicaremos Padrões de Projeto como **Repository** (para abstração de acesso a dados) e **Singleton** (no gerenciamento de injeção de dependências).

## Tecnologias e Justificativas
* **Frontend:** React | Next.js | Typescript | Tailwind CSS. 
  * *Justificativa:* Permite a criação de Single Page Applications (SPAs). Isso é vital para um player de música, garantindo que o usuário navegue pelo sistema sem que o áudio seja interrompido por recarregamentos de página.
* **Backend:** Java (Spring Boot). 
  * *Justificativa:* Framework robusto e padronizado para a criação de APIs REST, com excelente suporte integrado para segurança corporativa (Spring Security) e persistência de dados.
* **Banco de Dados:** PostgreSQL. 
  * *Justificativa:* Banco de dados relacional poderoso, ideal para garantir a consistência das transações de histórico de reprodução e para modelar relacionamentos complexos entre Usuários, Músicas e Playlists.
* **Repositório e DevOps:** GitLab. 
  * *Justificativa:* Oferece um ambiente centralizado para o código-fonte (Git) e possui ferramentas nativas poderosas para a construção de esteiras automatizadas de CI/CD.
* **Qualidade e Testes:** JUnit (Java) e Jest (React). 
  * *Justificativa:* Ferramentas consolidadas na indústria para suportar a prática de TDD com execução rápida e feedbacks precisos.
* **Observabilidade:** Spring Boot Actuator. 
  * *Justificativa:* Facilita a exposição de métricas de saúde (health checks) e telemetria da aplicação, essenciais para o monitoramento em ambiente de produção online.

## Engenharia e Produção (Deploy e CI/CD)
O repositório está configurado com um pipeline de Integração e Entrega Contínuas (CI/CD). A cada novo *push* na branch principal, o pipeline executa automaticamente os testes unitários. Se aprovados, ocorre o processo de *build* e o deploy é realizado automaticamente em um provedor de nuvem, deixando o sistema em ambiente de produção online de forma ágil e segura.

## Atribuições e Responsabilidades
- Protótipo e Front-end: [Lucas Moraes](https://github.com/hub-Moraes).
- Banco de Dados e Back-end: [Vitor Keller](https://github.com/vitorkeller).
