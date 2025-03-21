<h1 align="center" style="font-weight: bold;">Stocks Finance 💻</h1>

<p align="center">
 <a href="#tech">Tecnologias</a> • 
 <a href="#started">Iniciar</a> • 
 <a href="#routes">API Endpoints</a> •
 <a href="#contribute">Contribuições</a>
</p>

<p align="center">
    <b>Stocks Finance é uma API que auxilia na análise e escolha de ativos do mercado de ações Brasileiro.</b>
</p>

<h2 id="technologies">💻 Tecnologias</h2>

- Java
- Spring Boot
- MongoDB

<h2 id="started">🚀 Iniciar</h2>

<h3>Pré-requisitos</h3>

- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [MongoDB](https://www.mongodb.com/try/download/community)

<h3>Clonar</h3>

```bash
git clone https://github.com/Eduardo-Port/Stocks-Finance.git
```

<h3>Executar</h3>

1 - Entrar na pasta do projeto.

```bash
cd Stocks-Finance
```

2 - Instalar todas as dependências do projeto e iniciar a aplicação Spring Boot. 
```bash
mvnw spring-boot:run
```

<h2 id="routes">📍 API Endpoints</h2>
​
| rota               | descrição                                     
|----------------------|-----------------------------------------------------
| <kbd>GET /api/stocks</kbd>     | retorna todas as ações registradas [detalhes da resposta](#get-all-detail)
| <kbd>GET /api/stocks/?title={title}</kbd>     | retorna as informações de uma ação específica [detalhes da resposta](#get-one-detail)
| <kbd>POST /api/stocks</kbd>     | authenticate user into the api see [detalhes da resposta](#post-detail)
| <kbd>PUT /api/stocks</kbd>     | authenticate user into the api see [detalhes da resposta](#post-detail)

<h3 id="get-all-detail">GET /api/stocks</h3>

**RESPONSE**
```json
{
	"_embedded": {
		"stockList": [
			{
				"title": "PETR3",
				"price": 28.5,
				"profit": 4.6,
				"pricePerPatrimonialValue": 0.9,
				"patrimonialValue": 0.9,
				"dividendYield": 10.93,
				"dividendYieldLast5Years": 8.5,
				"_links": {
					"self": {
						"href": "http://localhost:8080/api/stocks/?title=PETR3"
					}
				}
			},
			{
				"title": "PETR4",
				"price": 28.5,
				"profit": 4.6,
				"pricePerPatrimonialValue": 0.9,
				"patrimonialValue": 0.9,
				"dividendYield": 10.93,
				"dividendYieldLast5Years": 8.5,
				"_links": {
					"self": {
						"href": "http://localhost:8080/api/stocks/?title=PETR4"
					}
				}
			},
			{
				"title": "PETR11",
				"price": 28.5,
				"profit": 4.6,
				"pricePerPatrimonialValue": 0.9,
				"patrimonialValue": 0.9,
				"dividendYield": 10.93,
				"dividendYieldLast5Years": 8.5,
				"_links": {
					"self": {
						"href": "http://localhost:8080/api/stocks/?title=PETR11"
					}
				}
			}
		]
	},
	"_links": {
		"self": {
			"href": "http://localhost:8080/api/stocks?page=0&size=9"
		}
	},
	"page": {
		"size": 9,
		"totalElements": 3,
		"totalPages": 1,
		"number": 0
	}
}
```

<h3 id="get-one-detail">GET /api/stocks/?title={title}</h3>

**RESPONSE**
```json
{
	"title": "PETR11",
	"price": 28.5,
	"profit": 4.6,
	"pricePerPatrimonialValue": 0.9,
	"patrimonialValue": 0.9,
	"dividendYield": 10.93,
	"dividendYieldLast5Years": 8.5,
	"_links": {
		"Stock list": {
			"href": "http://localhost:8080/api/stocks?page=0"
		}
	}
}
```

<h3 id="post-detail">POST /api/stocks</h3>

**REQUEST**
```json
{
	"title": "PETR11",
	"price": 28.50,
	"profit": 4.60,
	"pricePerPatrimonialValue": 0.90,
	"patrimonialValue": 31.53,
	"dividendYield": 10.93,
	"dividendYieldLast5Years": 8.50
}
```

**RESPONSE**
```json
{
	"title": "PETR11",
	"price": 28.5,
	"profit": 4.6,
	"pricePerPatrimonialValue": 0.9,
	"patrimonialValue": 0.9,
	"dividendYield": 10.93,
	"dividendYieldLast5Years": 8.5,
	"_links": {
		"self": {
			"href": "http://localhost:8080/api/stocks/?title=PETR11"
		}
	}
}
```

<h3 id="put-detail">PUT /api/stocks</h3>

**REQUEST**
```json
{
	"title": "PETR11",
	"price": 17.23,
	"profit": 23.12,
	"pricePerPatrimonialValue": 1.4,
	"patrimonialValue": 1223.32,
	"dividendYield": 7.4,
	"dividendYieldLast5Years": 10.6
}
```

**RESPONSE**
```json
{
	"title": "PETR11",
	"price": 17.23,
	"profit": 23.12,
	"pricePerPatrimonialValue": 1.4,
	"patrimonialValue": 1223.32,
	"dividendYield": 7.4,
	"dividendYieldLast5Years": 10.6,
	"_links": {
		"self": {
			"href": "http://localhost:8080/api/stocks/?title=BBAS3"
		}
	}
}
```

<h2 id="contribute">📫 Contribuições</h2>

1. `git clone https://github.com/Eduardo-Port/Stocks-Finance.git`
2. `git checkout -b feature/NAME`
3. Siga patterns de commits
4. Abra um Pull Request explicando os problemas resolvidos ou a atualização realizada, se existir, adicione prints das mudanças visuais e espere pelo review!

<h3>Documentações que podem te ajudar</h3>

[📝 How to create a Pull Request](https://www.atlassian.com/br/git/tutorials/making-a-pull-request)

[💾 Commit pattern](https://gist.github.com/joshbuchea/6f47e86d2510bce28f8e7f42ae84c716)
