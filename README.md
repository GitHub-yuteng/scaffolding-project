# scaffolding-project

# 项目脚手架

## 设计模式 实例
1、策略模式、模板模式
2、责任链，状态模式

# 技术转变
单体项目多数据源 -> 微服务（用户服务，内部服务，销售服务）

## 项目内容
### 快销网
- 1、订单管理 策略+模板 策略分类，模板组装订单信息（缺少购买时候快照）
- 2、拜访管理 状态+模板 到点打卡，离店打卡，组装打卡信息；
- 3、拜访报表 责任链模式，processor上下级处理，不同的人看到不同数据
- 4、冰柜 新冰柜，老冰柜；终端投放，迁移；拜访冰柜
- 5、售后 订单售后，冰柜售后，异常处理
- 6、商品详情 模板 生成不同的详情，活动商品详情，秒杀订单详情
- 7、mine 策略，不同的角色不同的数据取出展示
- 8、tools tree 工具树 （Redis 缓存当前角色-用户工具）
- 9、ResponseResult 统一返回
- 10、闪屏广告 可配置形式，市面上有的将闪屏分为上下两个图片 与前端配置，版本号控制是否更新
- 11、调查问卷 可配置形式，Json存储用户答案
- 12、项目功能包合理放置
- 13、协议功能 预生成模板，填写，暂存功能
- 14、流程审批 责任链模式，包含上下级信息数据
- 15、营销系统 秒杀订单，满减赠，活动
- 16、日常活动
- 17、多线程处理（ordercell查看）报表，多数据分组分批插入，不同服务开启线程调用
- 18、Redis 缓存 缓存工具，用户信息

### PC 数字化营销平台
- 1、订单管理 策略；品牌商/经销商 查看订单
- 2、发货 表设计发货商品信息为Json方便扩展
- 3、问卷调查 健康打卡报表
- 4、商品库上架下架

# erp 
## 供应链
- 1、采供销
  - erp 采供：采购 供应商 
  - 快销网：销售 S2B2C 模式；终端，消费者
    - 本地店铺，终端直营店，招商店铺，消费者商城
