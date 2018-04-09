- /{name}-{profiles}.yml
- /{label}/{name}-{profiles}.yml

---
- name:服务名
- profiles:环境
- label:分支


basedir: ?

自动刷新路径:curl -v -X POST "http://localhost:8082/application/refresh"

集成webhook实现自动更新：https://natapp.cn
