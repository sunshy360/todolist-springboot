## todo-api 需求

实现todo-api.yml文件中所定义的api（文件符合swagger规范），以支持对于todo item的增删改查工作。 可以将 .yml 文件在 http://editor.swagger.io 打开，查看具体需求。

## 使用技术

使用spring boot来搭建rest api，数据库选用mysql

## 使用方法
`.gradlew bootRun`

查询Todoitems

`curl localhost:8080/todoitems`

增加Todoitem

`curl -X POST "http://localhost:8080/todoitems" -H "accept: application/json" -H "Content-Type: application/json" -d "{ \"itemName\": \"learn spring boot\"}"`

修改Todoitem

`curl -X PUT "http://localhost:8080/todoitems/1" -H "accept: application/json" -H "Content-Type: application/json" -d "{ \"itemName\": \"learn spring boot\",\"done\":true}"`

删除Todoitem

`curl -X DELETE http://localhost:8080/todoitems/1`
