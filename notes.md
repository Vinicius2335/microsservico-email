# RabbitMQ
<br>
1- Criar uma nova instancia no site -> CloudAMQP

2- Adicionar a Dependencia -> Spring AMQP 

````properties
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-amqp</artifactId>
</dependency>
````
3- Configurar nas propriedades a conexão da instancia criada no site com o nosso serviço 

4- Criar uma classe de configuração, para criar a fila e colocar depois configurações de converção
<strong style="color:yellow">RabbitMQConfig</strong>

5- Criar o nosso consumer, classe que ficará escutando nossa fila <strong style="color:yellow">EmailConsumer</strong>

6- Em <strong style="color:yellow">RabbitMQConfig</strong>, criar um novo bean para converter a mensagem

OBS: requisição atraves do endpoint = sincrono, atraves do RabbitMQ = assincrono