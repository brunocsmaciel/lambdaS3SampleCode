﻿# Lambda AWS - Sample Code interação com bucket
Esse projeto tem como objetivo criar um arquivo .txt com base no texto de entrada e gravar o arquivo em um bucket s3 utilizando java puro, isto é, sem frameworks (quarkus, spring).

# Tecnologias utilizadas
- Java 11
- Maven
- AWS SDK S3

## Passo a passo

Com uma conta AWS, criar uma função lambda


- Criar uma função lambda no console da aws. Obs: A role precisa dar permissões de acesso ao bucket
![Criar função](./src/main/resources/images/lambda-bucket.png)
 

- Para gerar o jar da aplicação, vá até a pasta raiz e dê o comando 'mvn clean package'. O jar é gerado dentro da pasta target
![](./src/main/resources/images/jar.png)


 - Fazer o upload do jar 
![Upload Jar](./src/main/resources/images/zip%20ou%20jar.png)
![Upload Jar2](./src/main/resources/images/fazer%20upload.png)


- Clicar na aba teste para executar o teste
![Iniciando teste](./src/main/resources/images/iniciando%20teste.png)
![Modelo teste](./src/main/resources/images/modelo%20teste.png)


- Os logs do envio irão aparecer na tela
![Logs de envio](./src/main/resources/images/logs-envio.png)


 - Inspecionando o bucket e o arquivo, podemos verificar o conteúdo
![Inspecionando o bucket](./src/main/resources/images/objeto-bucket.png)
![Inspecionando o arquivo](./src/main/resources/images/arquivo-bucket.png)
