# 🎮 Game API

API simples em **Java + Play Framework** para gerenciar jogos.

🔗 Repositório: [https://github.com/Diemesonst/UploadApi](https://github.com/Diemesonst/UploadApi)

---

## 🚀 Como rodar
```bash
git clone https://github.com/Diemesonst/UploadApi.git
cd UploadApi
sbt run
🌐 Endpoints
➕ Criar jogo

POST /games
Body:

{
  "name": "The Legend of Zelda",
  "genre": "Aventura",
  "year": 1986
}

📋 Listar jogos

GET /games

🔎 Buscar jogo por ID

GET /games/:id

🗄️ Banco de Dados

H2 em memória

Console: http://localhost:9000/@db

👨‍💻 Feito por Diemesonst


---

👉 Quer que eu já gere esse `README.md` como **arquivo pronto** pra você só colocar dentro do repo
