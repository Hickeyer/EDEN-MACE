## 分销管理系统（EDEN-MACE）

### 前言

  随着微信等社交工具的出现，很多软件出现了通过人脉赚钱的方式，每个人通过各种方式将数据传递给另外的人，通过这种分裂式的发展，使得产品能够得到有效的推广，并且可以进行有效的精准推广，于是市场上产生了很多的微信三级分销等软件，也有很多成功的产品，比如拼多多等，根据我个人了解 很多初创企业 都使用这种模式，在产品刚刚上线的时候就使用这种模式，为企业赚得了第一桶金。

   但是我们用第三方软件，有很多问题，比如  很多东西都不能够定制化，很多业务不够满足自己产品的需求，于是只能"凑合着用",有些公司会定制开发，产生了很大的开发成本和时间，在任何一个产品上线的时候，时间就是产品的生命线，尤其是遇到不熟悉这些业务的开发的时候 ，可能需求和产品会产生误差，会导致产品拖延很长时间。

   我通过对分销系统多年的研究发现，分销的分润和等级的计算完全在后台进行配置化管理，将抽象的分销系统具体化，前端可以单独开发，开发成本和时间完全可以进行控制，于是就开发这样的一套系统。

### 视频介绍
https://pan.baidu.com/s/1MmKzOW69q8EE72ULOr2BXg

###  我们的价值

> 对于程序员 ，可以学到技术和业务逻辑紧密结合，用业务作为跳板去学习技术

> 对于企业，可以实现企业的推广，快速将人脉变现

### 产品亮点

1、权限和分销完全分离，符合开发的 低耦合的需求。

2、产品完全可配置化，仅需要少量改动

3、采用微服务思想，和原业务低耦合 ，不需要的时候可以随时下线。

4、可视化图形化界面统计。

5、完善化的账务体系，可追溯每一笔分润的来源。

### 适用企业

1、已有项目，需要增加分销功能。

2、项目需要暂时使用分销功能。

3、对接多个系统，需要对多个账户进行控制的系统

### 场景案例

  1. 电商商品需要增加购买商品分佣功能
  2. 广告网站需要增加邀请奖励功能
  3. 金融机构需要增加推广奖励 的功能 


### 目标

企业级软件，为企业低成本、高效率、快速的盈利。

### 开源地址

https://gitee.com/codingdb/distribution_management

### 技术特色

  1、引用guns 权限管理系统

  2、采用spring boot 简化了配置、并且将开发环境的配置和生产环境配置分离开。

  3、jwt 安全验证。

  4、将权限数据库和业务数据库进行分离

  5、采用quartz进行任务调度，直接修改数据库即可

  6、采用枚举类和数据字典配合的方式进行数据维护，不必要的地方直接调用枚举类，减少数据库的调用。

  7、策略模式和简单工厂模式实现佣金的扩展，可以很容易的扩展分销系统。

  8、 采用swagger方式对外开放接口,并且使用restful风格。

  9、采用阿里云编码规约。

  10、分销商自动分配权限。

  11、自动权限配置功能。

###  代码展示

枚举类实现自动计算分润

 ```java
ZERO_STATUS("0","按照百分比计算") {
        @Override
        public BigDecimal calResult(BigDecimal amount, BigDecimal arg) {
            return amount.multiply(arg);
        }
    }
 ```

策略模式实现分佣账户的扩展

```java
 public AmountFactoryContext(String type) {
        switch (type){
            case "0":
                amountService = new TradeAmountServiceImpl();
                break;
            case  "1":
                amountService = new LevelAmountServiceImpl();
                break;
            default:
                break;
        }
    }
```



###  特别鸣谢

咕泡学院青山老师

### 项目总览
项目使用场景图示

 ![输入图片说明](https://gitee.com/uploads/images/2018/0609/190905_38816529_1497609.png "分销场景.png")

分销功能架构图

![输入图片说明](https://images.gitee.com/uploads/images/2018/0828/101219_4d445e9d_1497609.jpeg "代理分销.jpg")

分销内部设计图
![输入图片说明](https://gitee.com/uploads/images/2018/0510/085941_47511fa1_1497609.png "未命名文件.png")

### 项目说明

distribution_management  用来运行分销管理系统

plug用来调试接口，调试完成后，可以直接使用

### 安装方法

下载此项目后，generator.ExecuSql 修改数据库和密码，可以自动导入sql。

运行/distribution_management 目录下的项目,访问http://localhost/。

账号 ： admin /111111

​          dist/123

### 项目特色

####  经典分销模式
如下图中的分销模式，就可以很好的与本系统对接
![输入图片说明](https://gitee.com/uploads/images/2018/0503/203047_afd028a5_1497609.png "未命名文件.png")

#### 强大的账户体系
![输入图片说明](https://gitee.com/uploads/images/2018/0530/161429_4728a749_1497609.png "账户系统 (1).png")

#### 系统可拔插

​      系统以微服务的形式运行，即独立于其他的软件，提供接口进行交互，不会对其他的系统产生新的冗余数据。

​      假设**李老板** 前期需要推广自己的软件，自己的软件又没有设计这个功能，加功能又需要很多钱，这个时候，使用这个软件就可以减少资金的投入（写很少的代码就可以实现自己的需求）。

  系统稳定了，**李老板** 不需要这个分销软件了， 那么可以直接将原来的几行代码关了，或者在自己的系统中增加开关，直接就可以关掉。并且不影响原来的系统的运行。

####  分销配置化

  假设**李老板**  原来只设置一级又分润，后面需要给二级或者三级分润，这个时候只需要在后台进行配置就可以。**李老板** 如果设置原来的配置每笔交易按照百分比收取，后来改为每笔交易按照固定金额收取，就可以直接在后台进行配置。
如下图中的分润配置，可以根据各种情况进行配置分润。
![输入图片说明](https://gitee.com/uploads/images/2018/0616/205340_a24ef103_1497609.jpeg "分润详情.jpg")

#### 会员关系可视化

  会员的发展理论上可以无限制的发展下去，并且可以通过树状图表现出来。

#### 分销关系权限化

每个分销商只能看到自己名下的会员。并且可以看到自己的交易明细，这个就减少原有的系统的开发。

#### 积分控制可视化


![输入图片说明](https://images.gitee.com/uploads/images/2018/0723/003756_50bc8665_1497609.jpeg "积分模块.jpg")

### 平台简介
对接参考，用来对系统进行对接，并且已经写好了的模拟接口，可以模仿使用
![输入图片说明](https://gitee.com/uploads/images/2018/0531/232723_3195cc5d_1497609.jpeg "1.jpg")

会员信息对会员账号和会员资金进行管理
![输入图片说明](https://gitee.com/uploads/images/2018/0531/232930_a2b39ed8_1497609.jpeg "2.jpg")
![输入图片说明](https://gitee.com/uploads/images/2018/0531/233008_65b79616_1497609.jpeg "3.jpg")
![输入图片说明](https://gitee.com/uploads/images/2018/0531/233016_a1f5825b_1497609.jpeg "4.jpg")

分销配置用来配置分润等信息
![输入图片说明](https://gitee.com/uploads/images/2018/0531/233057_0ec35361_1497609.jpeg "5.jpg")
![输入图片说明](https://gitee.com/uploads/images/2018/0531/233120_47801737_1497609.jpeg "6.jpg")
![输入图片说明](https://gitee.com/uploads/images/2018/0531/233110_36d91f83_1497609.jpeg "7.jpg")

交易中心 集中对收入和支出进行管理
![输入图片说明](https://gitee.com/uploads/images/2018/0531/233149_4a1d658e_1497609.jpeg "8.jpg")
![输入图片说明](https://gitee.com/uploads/images/2018/0531/233201_d8fb5542_1497609.jpeg "9.jpg")
统计中心 对数据进行统计
交易动态，可以查看最新的交易成功的动态
![输入图片说明](https://gitee.com/uploads/images/2018/0609/143627_87c48977_1497609.jpeg "111.jpg")
账户收益统计图
![输入图片说明](https://gitee.com/uploads/images/2018/0610/120127_3fc5142b_1497609.jpeg "111.jpg")

### 利用docker 本地部署
inside docker folder, start docker by
```
  $ ./start.sh
```
Then dump the data
inside docker folder, access mysql container by
```
  $ docker exec -it distribution-mysql bash -l 
  $ mysql -uroot -p
  $ source /docker-entrypoint-initdb.d/distribution.sql;
  $ source /docker-entrypoint-initdb.d/authority.sql;
```
注意： 这里mysql 的port 是 6603， 需要在application-dev.yml 中替换成相应的port.
