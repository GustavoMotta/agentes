# Projeto Agentes
O projeto consiste em uma aplicação front-end que possibilita a realização de um upload de um arquivo .xml e uma back-end que recebe o arquivo, converte e apresenta o código dos agentes.

Para que seja possível executar a aplicação, é necessários ter as seguintes ferramentas instaladas na máquina:
- Angular Cli v14.2.5
- NodeJS v14+ (com npm)
- Maven v3+
- JDK v17
- Docker (Opcional)

---

## Utilizando a aplicação: 
Executar os comandos abaixo (Back-end):
1. Abrir o terminal na raiz do projeto
2. Acessar pasta agentes-api. Comando: `cd agentes-api`
3. Compilar aplicação. Comando: `mvn clean install -DskipTests=true`
4. Executar o jar gerado. Comando: `java -jar target/agentes-api-1.0.0-SNAPSHOT.jar`

Nesse momento, a aplicação está sendo executada, para conferir basta acessar o Swagger pelo endereço `http://localhost:8080/agentes/swagger-ui.html`

Executar os comandos abaixo (Back-end):
1. Abrir o terminal na raiz do projeto
2. Acessar pasta agentes-api. Comando: `cd agentes-app`
3. Compilar aplicação. Comando: `npm install`
4. Executar a aplicação. Comando: `npm start`

Nesse momento, a aplicação está sendo executada, para conferir basta acessar o endereço `http://localhost:4200/`

---

## Utilizando a aplicação (via Docker): 
Executar os comandos abaixo (Back-end):
1. Abrir o terminal na raiz do projeto
2. Acessar pasta agentes-api. Comando: `cd agentes-api`
3. Conceder permissão de execução pro script run-docker.sh. Comando: `sudo chmod +x run-docker.sh`
4. Executar o script run-docker.sh. Comando: `./run-docker.sh`


Nesse momento, a aplicação está sendo executada, para conferir basta acessar o Swagger pelo endereço `http://localhost:8080/agentes/swagger-ui.html`

Executar os comandos abaixo (Back-end):
1. Abrir o terminal na raiz do projeto
2. Acessar pasta agentes-api. Comando: `cd agentes-app`
3. Conceder permissão de execução pro script run-docker.sh. Comando: `sudo chmod +x run-docker.sh`
4. Executar o script run-docker.sh. Comando: `./run-docker.sh`

Nesse momento, a aplicação está sendo executada, para conferir basta acessar o endereço `http://localhost:4200/`

---

## Requisitos
O projeto foi criado com a intenção de atender os requisitos abaixo:

```
Desafio

	Criar um sistema Web composto de um Front-end SPA (Single Page Application) Angular e um Back-end Java Spring Boot para envio de arquivos XML e posterior processamento deles.

Requisitos
    • Criar uma interface Web para upload de um ou mais arquivos com extensão .xml.
    • Para o desenvolvimento da interface, deve ser utilizado o tema Indigo do Angular Material.
    • Durante o envio do(s) arquivo(s) mostrar um loader para informar ao usuário que estão sendo processados, e ao final esse loader deve desaparecer (utilizar componentes do Angular Material).
    • Os arquivos contêm uma lista de agentes com código e data em formato ISO, e uma lista com quatro regiões (SE, S, NE, N) com sete valores numéricos de geração, compra e preço médio.
    • Todos os arquivos seguem o mesmo formato, como nos exemplos em anexo:
        ◦ exemplo_01.xml
        ◦ exemplo_02.xml
        ◦ exemplo_03.xml
    • Não é necessário validar os dados dos arquivos, considere que eles estarão sempre corretos e no formato especificado acima.
    • Os arquivos devem ser lidos e enviados um a um, sequencialmente.
    • Os arquivos podem conter quantidades grandes de dados, por exemplo, 1.000 agentes (agentes/agente[0..999])
    • Os dados de preço médio (/agentes/agente[]/submercado[]/precoMedio) são confidenciais, portanto devem ser removidos ou substituídos por valores em branco antes de serem enviados.
    • Ao receber cada arquivo, o back-end deve apenas imprimir na saída padrão (System.out) os códigos de agentes (/agentes/agente[]/codigo) recebidos.
		
Instruções
    1. Criar o sistema utilizando as seguintes tecnologias base:
    • Front-end:
        ◦ Angular 12+
        ◦ Angular Material 12+
        ◦ Typescript 4+
        ◦ RxJS 6+
        ◦ NodeJS 14+

    • Back-end:
        ◦ Spring Boot 2
        ◦ Maven 3

    2. Disponibilizá-lo em um repositório Git público (exemplo: GitHub, Bitbucket).
	
	

```