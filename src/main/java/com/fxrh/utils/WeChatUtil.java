package com.fxrh.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fxrh.utils.HttpClientUtil;
/**
 * 微信发送文本消息
 * 包引用
 * <dependency>
			<groupId>com.alibaba</groupId>
			<artifactId>fastjson</artifactId>
			<version>1.2.15</version>
		</dependency>
		<dependency>
			<groupId>org.apache.httpcomponents</groupId>
			<artifactId>httpclient</artifactId>
			<version>4.3.1</version>
		</dependency>
 * @author qianjianlei
 *
 */
public class WeChatUtil {
	static Logger logger = Logger.getLogger(WeChatUtil.class);
	
	public static void main(String[] args) throws Exception {
		String corpID = "ww1c87b1fac5427685";
		String corpSecret = "K4k38q-5NqLCvSNaxDjtR2U78_4Cj9xwV9Xv9rUPViU";
		
		String token = getCompanyAccess_Token(corpID , corpSecret);
		logger.debug("new access_token: " + token);
		
		
		MessageEntity entity = new MessageEntity();
		entity.setToparty("@all");
		entity.setTotag("@all");
		entity.setTouser("YiJuanKongXiao");
		entity.setAgentid(1000002);
		entity.setSafe("0");
		entity.setMsgtype("text");
		entity.setContent("姓名：***\\n" + "性别：男\\n" + "年龄：18\\n"
				+ "简介：		爱神的箭卡山莨菪碱阿拉山口几点开始京东方哈回复登记卡水电费卡萨返回空说打发生的卡号房价快萨芬哈克水电费哈市开发哈是会计领导发话撒娇开发撒的开发挥洒看对方哈萨克东方航空就撒风好大发觉是的放假卡萨丁荒废集卡萨丁回复撒娇看到1回复绝杀的减肥哈萨克绝代风华数据库东方航空就撒倒海翻江卡萨丁话费卡爱神的箭卡山莨菪碱阿拉山口几点开始京东方哈回复登记卡水电费卡萨返回空说打发生的卡号房价快萨芬哈克水电费哈市开发哈是会计领导发话撒娇开发撒的开发挥洒看对方哈萨克东方航空就撒风好大发觉是的放假卡萨丁荒废集卡萨丁回复撒娇看到2回复绝杀的减肥哈萨克绝代风华数据库东方航空就撒倒海翻江卡萨丁话费卡爱神的箭卡山莨菪碱阿拉山口几点开始京东方哈回复登记卡水电费卡萨返回空说打发生的卡号房价快萨芬哈克水电费哈市开发哈是会计领导发话撒娇开发撒的开发挥洒看对方哈萨克东方航空就撒风好大发觉是的放假卡萨丁荒废集卡萨丁回复撒娇看到3回复绝杀的减肥哈萨克绝代风华数据库东方航空就撒倒海翻江卡萨丁话费卡爱神的箭卡山莨菪碱阿拉山口几点开始京东方哈回复登记卡水电费卡萨返回空说打发生的卡号房价快萨芬哈克水电费哈市开发哈是会计领导发话撒娇开发撒的开发挥洒看对方哈萨克东方航空就撒风好大发觉是的放假卡萨丁荒废集卡萨丁回复撒娇看到4回复绝杀的减肥哈萨克绝代风华数据库东方航空就撒倒海翻江卡萨丁话费卡爱神的箭卡山莨菪碱阿拉山口几点开始京东方哈回复登记卡水电费卡萨返回空说打发生的卡号房价快萨芬哈克水电费哈市开发哈是会计领导发话撒娇开发撒的开发挥洒看对方哈萨克东方航空就撒风好大发觉是的放假卡萨丁荒废集卡萨丁回复撒娇看到5回复绝杀的减肥哈萨克绝代风华数据库东方航空就撒倒海翻江卡萨丁话费卡爱神的箭卡山莨菪碱阿拉山口几点开始京东方哈回复登记卡水电费卡萨返回空说打发生的卡号房价快萨芬哈克水电费哈市开发哈是会计领导发话撒娇开发撒的开发挥洒看对方哈萨克东方航空就撒风好大发觉是的放假卡萨丁荒废集卡萨丁回复撒娇看到6回复绝杀的");
		String access_token = token;
		
		sendMsg(entity, access_token );
	}

	/**
	 * 发送文本消息接口
	 * @param entity			文本消息内容
	 * @param access_token	企业微信调用接口凭证
	 */
	public static void sendMsg(MessageEntity entity, String access_token ) {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("toparty", entity.getToparty());
			map.put("totag", entity.getTotag());
			map.put("touser", entity.getTouser());
			map.put("agentid", entity.getAgentid());
			map.put("safe", entity.getSafe());

			map.put("msgtype", entity.getMsgtype());
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("content", entity.getContent());
			map.put("text", map2);

			String params = JSON.toJSONString(map, true);
			String url = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=" + access_token;
			String rtn = HttpClientUtil.postJson(url, params, "");
			logger.debug("send message ::::::::::::::::::: " + rtn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取企业微信调用接口凭证接口
	 * @param corpID			企业微信的CorpID，在企业微信控制台-我的企业-企业信息 查询
	 * @param corpSecret		企业应用secret，在企业微信控制台-企业应用-自建应用 查询
	 * @return
	 * @throws Exception
	 */
	public static String getCompanyAccess_Token(String corpID, String corpSecret) throws Exception {
		String token = "";
		String url = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=" + corpID + "&corpsecret=" + corpSecret;
		String rtnString = HttpClientUtil.get(url);

		if (!rtnString.isEmpty()) {
			Map<String, Object> map = JSONObject.parseObject(rtnString);
			String errcode = map.get("errcode").toString();
			String errmsg = map.get("errmsg").toString();

			token = map.get("access_token").toString();
			String ex = map.get("expires_in").toString();

			logger.debug(
					String.format("get access_token::::::::::::::::::%s , expires : %s,errcode ：%s , errmsg : %s", token, ex, errcode, errmsg));
		}
		return token;
	}
}
