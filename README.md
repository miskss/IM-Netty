# IM-Netty
使用Netty开发的基于控制台的IM系统，主要为前段时间对netty学习的一个汇总项目。

## Netty + redis

## 通信协议 

 ``` 
 魔数 (4 字节) + 协议的版本号（1字节） + 指令 （2字节）+数据的长度（4 字节） + 数据载体（n 字节）
 数据为json格式 ，协议的版本 暂时固定为 1
 +------------+---------+------------+--------------+----------------+
 | 0xCAFE1234 | 1 byte  |  2 bytes   |    4 bytes   |   1....n bytes |
 +------------+---------+------------+--------------+----------------+

```
[TransferProtocol.java](src/main/java/com/example/imnetty/protocol/TransferProtocol.java)



