
此程序为分销系统的小插件
目前可以为会员级分润进行可视化解析
解析步骤:
访问http://localhost:8080/,编辑完成后保存，
将分销系统的会员级分润清空 delete from dis_profit_param where identity_type ='0'
将level-info系统中的dis_profit_param 数据不带id导入到分销系统，在页面即可看到相关配置信息