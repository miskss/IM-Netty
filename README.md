# IM-Netty
使用Netty开发的基于控制台的IM系统，主要为前段时间对netty学习的一个汇总项目。

## Netty + redis

## 通信协议 

 ``` 
 魔数 (4 字节) + 协议的版本号(1字节) + 指令 (2字节)+数据的长度(4 字节) + 数据载体(n 字节)
 数据为json格式 ，协议的版本 暂时固定为 1
 +------------+---------+------------+--------------+----------------+
 | 0xCAFE1234 | 1 byte  |  2 bytes   |    4 bytes   |   1....n bytes |
 +------------+---------+------------+--------------+----------------+
 
```
[TransferProtocol.java](src/main/java/com/example/imnetty/protocol/TransferProtocol.java)



## 主要的实现的功能

1. 注册(已完成)
2. 登录(已完成)
3. 权限验证(已完成)
4. 搜索IM用户(已完成)
5. 添加IM用户(已完成)
6. 创建聊天群组(已完成)
7. 拉IM用户进群组(待完成)
8. 退群(待完成)
9. 单聊(已完成)
10. 群聊(已完成)
11. 申请入群(待完成)
12. 检索群(已完成)
