package com.stylefeng.guns.modular.dist.service.impl;

import com.stylefeng.guns.common.annotion.AmoutLock;
import com.stylefeng.guns.modular.dist.amountTemplate.AmountTemplateFactoryContext;
import com.stylefeng.guns.modular.dist.service.IAmountMangeService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @ClassName AmountMangeServiceImpl
 * @autor huangpu
 * @DATE 2019/9/26
 * 账户统一管理
 * 账户类型: 比如用户开通的 分润账户 升级账户 等
 * 总账户: 各账户类型的可用金额+冻结金额
 * 总冻结金额:各分类账户的冻结金额的总和
 * 此处对金额进行总体的控制，分别为增加金额 冻结金额 减少金额  返还金额
 * 增加金额  对分类账户的金额增加 ，增加总金额和分类账户的总金额
 * 冻结金额  对分类账户的金额冻结，减少总可用金额和分类账户可用金额
 * 减少金额  对分类账户的金额减少，减去总冻结金额 总金额 分类账户总金额 分类账户冻结金额
 * 返回金额  返回冻结金额到可用金额上  减去总冻结金额  分类账户金额 增加总可用金额 分类账户可用金额
 *
 * 调用通过模板方法进行调用，即统一根据AccountType账户类型进行统一的账户的调配
 * AmoutLock 对金额进行加锁，由于金额属于敏感信息，此处设置了加锁的功能
 * 具体加锁方法执行为com.stylefeng.guns.core.aop.AmountLockAop，
 * 加锁原理:
 *  zookeeper加锁，锁的形式为分布式锁
 *  通过在类路径下的zookeeper.properties文件设置了开关，关的情况下是不加锁的，这里只讨论开的情况下
 *  首先在 配置文件zookeeper.properties文件中设置zk的相关地址
 *  系统在加载的时候会运行一个CuratorFramework并且启动
 *  在相关spring组件中增加@AmoutLock注解
 *  进入方法请前会根据配置情况判断是否进入加锁流程，进入的话 会通过 curator的InterProcessMutex类
 *  创建一个/amount{userId}的账户，这样能够保证多个用户进入此方法
 *  通过lock.acquire()在zk下创建/amount{userId} 下创建临时有序节点
 *  执行账户操作
 *  通过lock.release()是否节点，如果有下一个最小的节点，则通过watch机制通知下一个节点进入方法
 *  优点:
 *   1.对账户可以实现分布式的锁定，有利于分布式应用的部署
 *   2.通过对每一个账户的监控保证了程序的健壮性
 *
 *   缺点
 *   1. 由于需要访问zk进行加锁，由于网络原因等，会导致程序运行变慢
 *   2.增加了程序的复杂性
 *
 *   其他方案:
 *   数据库方案:行级锁
 *   乐观锁:版本控制
 *   公平锁:
 *   java中的锁对同一个商品用锁是可以的，但是如果对所有的账户采用锁会导致所有的账户都会等待，会降低程序的可用性，因此，此处不予实现
 *
 *
 **/

@Service
public class AmountMangeServiceImpl implements IAmountMangeService {


    @Override
    @AmoutLock
    public void addMoney(String userId, BigDecimal amount, String sourceName, String type, String accountType) {
        AmountTemplateFactoryContext context = new AmountTemplateFactoryContext(accountType);
        context.amountTemplate.addMoney(userId,amount,sourceName, type);
    }

    @Override
    @AmoutLock
    public void frozenAmount(String userId, BigDecimal amount,String accountType) {
        AmountTemplateFactoryContext context = new AmountTemplateFactoryContext(accountType);
        context.amountTemplate.frozenAmount(userId,amount);
    }

    @Override
    @AmoutLock
    public void reduceMoney(String userId, BigDecimal amount, String accountType) {
        AmountTemplateFactoryContext context = new AmountTemplateFactoryContext(accountType);
        context.amountTemplate.reduceMoney(userId,amount);
    }

    @Override
    @AmoutLock
    public void returnMoney(String userId, BigDecimal amount, String accountType) {
        AmountTemplateFactoryContext context = new AmountTemplateFactoryContext(accountType);
        context.amountTemplate.returnMoney(userId,amount);
    }
}

    
    