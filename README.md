# scaffolding-project

# 项目脚手架

## 设计模式 实例
1、策略模式、模板模式
2、责任链，状态模式

# 技术转变
单体项目多数据源 -> 微服务（用户服务，内部服务，销售服务）

## 项目内容
### 快销网
- 1、订单管理 策略+模板 策略分类，模板组装订单信息
- 2、拜访管理 状态+模板 到点打卡，离店打卡，组装打卡信息；拜访报表，责任链模式，processor上下级处理，不同的人看到不同数据
- 3、冰柜 新冰柜，老冰柜；投放，迁移
- 4、售后 订单售后，冰柜售后，异常处理
- 5、商品详情 模板 生成不同的详情，活动商品详情，秒杀订单详情
- 6、mine 策略，不同的角色不同的数据取出展示
- 7、tools tree 工具树
- 8、ResponseResult 统一返回
- 9、闪屏广告 可配置形式，市面上有的将闪屏分为上下两个图片 与前端配置，版本号控制是否更新
- 10、调查问卷，可配置形式，Json存储用户答案
- 11、项目功能包合理放置
- 12、协议功能，预生成模板，填写，暂存功能
- 13、流程审批 责任链模式，包含上下级信息数据

# erp 
## 供应链
- 1、采供销
  - erp 采供：采购 供应商 
  - 快销网：销售 S2B2C 模式；终端，消费者
