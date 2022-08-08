# Prova de Suficiencia Programacao Web II

<h2>Instruções para rodar a aplicação</h2>
<ul>
  <li>Java 17</>
  <li>Caminho do banco de dados: jdbc:mysql://localhost:3306/furb-prova (é necessário criar a base antes com o nome furb-prova)</li>
  <li>Usuário e senha alterar no application.properties conforme o seu local</li>
  <li>OAuth:</li>
  <li>Usuario: admin</li>
  <li>Senha: admin</li>
</ul>

<h2>Para o token utilizar o seguinte cURL:</h2>
<ul>
  <li>curl --request POST \
  --url http://localhost:8080/oauth/token \
  --header 'Authorization: Basic YWRtaW46YWRtaW4=' \
  --header 'Content-Type: multipart/form-data' \
  --cookie JSESSIONID=2160FE4256773620A484D4EC7B178FD0 \
  --form grant_type=password \
  --form username=admin \
  --form password=admin</>
</ul>

<h2>Para o Swagger acessar a seguinte URL:</h2>
<ul>
  <li>localhost:8080/swagger-ui/index.html/</>
</ul>


<h2>Tecnologias usadas</h2>
<ul>
  <li>Java (17)</li>
  <li>Maven</li>
  <li>Spring</li>
  <li>Hibernate</li>
  <li>ModelMapper</li>
  <li>MySQL</li>
  <li>Swagger</li>
  <li>OAuth</li>
</ul>

