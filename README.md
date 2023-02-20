# springboot_kafka

通过 docker-compose 部署kafka  
进入项目目录后输入  

```
docker-compose up -d
```

PS: 如果出现too manay request尝试登录docker排除问题  

 
常用命令  
  
```
docker exec -it springboot_kafka_kafka_1 /bin/bash
```

```
cd /opt/kafka/bin
```
  
#查看kafka版本  
```
kafka-broker-api-versions.sh --bootstrap-server localhost:9092 --version
```
  
#创建topic 1副本 3分区  
```
kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 3 --topic test
```
  
#拓展topic分区到4分区
```
kafka-topics.sh --bootstrap-server localhost:9092 --alter --topic test --partitions 4
```
  
#删除指定topic  
```
kafka-topics.sh --bootstrap-server localhost:9092 --delete --topic test
```
  
#查询所有topic  
```
kafka-topics.sh --list --bootstrap-server localhost:9092
```
  
#查询所有topic的详情  
```
kafka-topics.sh --bootstrap-server localhost:9092 --describe
```
  
#查询指定topic的详情   
```
kafka-topics.sh --bootstrap-server localhost:9092 --topic topic名称 --describe
```
  
#查询消费者列表  
```
kafka-consumer-groups.sh --bootstrap-server localhost:9092 --list
```
  
#查询指定服务组的消费详情  
```
kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group my-group
```
  
#生产者发送消息  
```
kafka-console-producer.sh --broker-list localhost:9092 --topic test
```
  
#消费者消费消息  
```
kafka-verifiable-consumer.sh --broker-list localhost:9092 --topic test --group-id testGroup
```



