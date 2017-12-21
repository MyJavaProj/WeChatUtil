# WeChatUtil
企业微信 企业应用 给客户端发【文本消息】方法封装

# 用到的包
    <dependency>
			<groupId>com.alibaba</groupId>
			<artifactId>fastjson</artifactId>
			<version>1.2.15</version>
		</dependency>
		<dependency>
			<groupId>org.apache.httpcomponents</groupId>
			<artifactId>httpclient</artifactId>
			<version>4.3.1</version>
		</dependency>
    
# 使用方式：
		MessageEntity entity = new MessageEntity();
		entity.setToparty("@all");
		entity.setTotag("@all");
		entity.setTouser("YiJuanKongXiao");
		entity.setAgentid(1000002);
		entity.setSafe("0");
		entity.setMsgtype("text");
		entity.setContent("姓名：***\\n" + "性别：男\\n" + "年龄：18\\n" + "简介：		个人简介");
		String token = WeChatUtil.getCompanyAccess_Token("corpID", "corpSecret");//token有时效限制
		WeChatUtil.sendMsg(entity, token);
	
