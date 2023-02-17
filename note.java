

ORDER


*Producer 

-sendMessage(event) - add msg(paylod) and topic 
--public void sendMessage(OrderEvent event){
        Message<OrderEvent> message = MessageBuilder
                .withPayload(event)        // inject msg
                .setHeader(KafkaHeaders.TOPIC, topic.name())  
                .build();                                     
        kafkaTemplate.send(message);                         


*Controller 

-placeOrder(@Reqbody order)
--set message & status in orderEvent  
--set order in OrderEvent

--orderProducer.sendMessage(orderEvent) 


STOCK & EMAIL 

*OrderConsumer 

-add @KafkaListener(topic, groupId) 
-consume(event) 

*application.properties 

- set group-id for email, stock respectively 
- different ports, 8081, 8082 for each 
- use same localhost:9092 




