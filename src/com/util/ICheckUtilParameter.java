package com.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sun.xml.internal.ws.util.StringUtils;

public interface ICheckUtilParameter {
	/**
	 * @Desc   : ��֤�Ƿ�������   ������
	 * @author : SOHU-����
	 * @date   : 2016��11��21�� ����5:59:16
	 * @Version: V1.0
	 * @param value
	 * @return boolean
	 */
	public default boolean isNumber(String value){
		if(value==null){
			return false;
		}
		
		Boolean strResult = value.matches("[0-9]+.*[0-9]*");
		return strResult;
	}
	

	
	/**
	 * @Desc   : �жϽ���Ƿ�С��1��    tur:С��    false����С��
	 * @author : SOHU-����
	 * @date   : 2016��11��21�� ����6:32:49
	 * @Version: V1.0
	 * @param value
	 * @return boolean
	 */
	public default boolean isLess0dot01(String value){
		if(!isNumber(value)){
			return true;
		}
		int amount = new BigDecimal(value).multiply(new BigDecimal(100)).intValue();
		if (amount <= 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * @Desc   : �жϽ���Ƿ�С��1��    tur:С��    false����С��
	 * @author : SOHU-����
	 * @date   : 2016��11��21�� ����6:32:49
	 * @Version: V1.0
	 * @param value
	 * @return boolean
	 */
	public default boolean isLess0dot01(BigDecimal value){
		if(value == null){
			return true;
		}
		int amount = value.multiply(new BigDecimal(100)).intValue();
		if (amount <= 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * @Desc   : �ж��ַ����ĳ����Ƿ����length�ĳ���      ����������
	 * @author : SOHU-����
	 * @date   : 2016��11��21�� ����10:08:48
	 * @Version: V1.0
	 * @param
	 * @param length
	 * @return boolean
	 */
	public default boolean isGreaterLength(String value,int length){
		if(value==null){
			return false;
		}
		if(value.length()>length){
			return true;
		}
		return false;
	}
	
	/**
	 * @Desc   : �ж��Ƿ�Ϊ��
	 * @author : SOHU-����
	 * @date   : 2016��11��22�� ����2:43:17
	 * @Version: V1.0
	 * @param
	 * @return boolean
	 */
	public default boolean isNotNull(String value){
		return !isNull(value);
	}
	
	/**
	 * 
	 * @Desc     �ж��Ƿ�Ϊ�գ�����null��""\" "��<P>
	 * @author   honghuiwang
	 * @date     2016��11��21�� ����1:31:03
	 * @Version  V1.0
	 * @param
	 * @return   boolean
	 */
	public default boolean isNull(String value){
		if(value==null){
			return false;
		}
		if(value.trim().equals("")){
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * @Desc     �ж϶����Ƿ�Ϊ��<P>
	 * @author   honghuiwang
	 * @date     2016��11��21�� ����1:31:03
	 * @Version  V1.0
	 * @param
	 * @return   boolean
	 */
	public default boolean isNull(Object obj){
		if(obj==null){
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @Desc     �ж϶����Ƿ�Ϊ��<P>
	 * @author   honghuiwang
	 * @date     2016��11��21�� ����1:31:03
	 * @Version  V1.0
	 * @param
	 * @return   boolean
	 */
	public default boolean isNull(Integer obj){
		if(obj==null){
			return true;
		}
		if(obj==0){
			return true;
		}
		return false;
	}
	/**
	 * 
	 * @Desc     �ж϶����Ƿ�Ϊ��<P>
	 * @author   honghuiwang
	 * @date     2016��11��21�� ����1:31:03
	 * @Version  V1.0
	 * @param
	 * @return   boolean
	 */
	public default boolean isNull(Long obj){
		if(obj==null){
			return true;
		}
		if(obj==0){
			return true;
		}
		return false;
	}
	/**
	 * 
	 * @Desc     �ж϶����Ƿ�Ϊ��<P>
	 * @author   honghuiwang
	 * @date     2016��11��21�� ����1:31:03
	 * @Version  V1.0
	 * @param
	 * @return   boolean
	 */
	@SuppressWarnings("rawtypes")
	public default boolean isNull(List obj){
		if(obj==null){
			return true;
		}
		return obj.isEmpty();
	}
	
	/**
	 * 
	 * @Desc     �ж϶����Ƿ�Ϊ��<P>
	 * @author   honghuiwang
	 * @date     2016��11��21�� ����1:31:03
	 * @Version  V1.0
	 * @param
	 * @return   boolean
	 */
	@SuppressWarnings("rawtypes")
	public default boolean isNull(Set obj){
		if(obj==null){
			return true;
		}
		return obj.isEmpty();
	}
	
	/**
	 * 
	 * @Desc     �ж�Map�Ƿ�Ϊ��<P>
	 * @author   honghuiwang
	 * @date     2016��11��21�� ����1:31:03
	 * @Version  V1.0
	 * @param
	 * @return   boolean
	 */
	public default boolean isNull(Map obj){
		if(obj==null){
			return true;
		}
		return obj.isEmpty();
	}
	
	/**
	 * @Desc   : ��֤IP�ĸ�ʽ
	 * @author : SOHU-����
	 * @date   : 2016��11��21�� ����5:42:58
	 * @Version: V1.0
	 * @param ip
	 * @return boolean
	 */
	public default boolean isIP(String ip){
		return true;
		/*if(StringUtils.isBlank(ip)){
			return false;
		}
		String ipv4 = "(?<=(\\b|\\D))(((\\d{1,2})|(1\\d{2})|(2[0-4]\\d)|(25[0-5]))\\.){3}((\\d{1,2})|(1\\d{2})|(2[0-4]\\d)|(25[0-5]))(?=(\\b|\\D))";
		String ipv6 = "^\\s*((([0-9A-Fa-f]{1,4}:){7}(([0-9A-Fa-f]{1,4})|:))|(([0-9A-Fa-f]{1,4}:){6}(:|((25[0-5]|2[0-4]\\d|[01]?\\d{1,2})(\\.(25[0-5]|2[0-4]\\d|[01]?\\d{1,2})){3})|(:[0-9A-Fa-f]{1,4})))|(([0-9A-Fa-f]{1,4}:){5}((:((25[0-5]|2[0-4]\\d|[01]?\\d{1,2})(\\.(25[0-5]|2[0-4]\\d|[01]?\\d{1,2})){3})?)|((:[0-9A-Fa-f]{1,4}){1,2})))|(([0-9A-Fa-f]{1,4}:){4}(:[0-9A-Fa-f]{1,4}){0,1}((:((25[0-5]|2[0-4]\\d|[01]?\\d{1,2})(\\.(25[0-5]|2[0-4]\\d|[01]?\\d{1,2})){3})?)|((:[0-9A-Fa-f]{1,4}){1,2})))|(([0-9A-Fa-f]{1,4}:){3}(:[0-9A-Fa-f]{1,4}){0,2}((:((25[0-5]|2[0-4]\\d|[01]?\\d{1,2})(\\.(25[0-5]|2[0-4]\\d|[01]?\\d{1,2})){3})?)|((:[0-9A-Fa-f]{1,4}){1,2})))|(([0-9A-Fa-f]{1,4}:){2}(:[0-9A-Fa-f]{1,4}){0,3}((:((25[0-5]|2[0-4]\\d|[01]?\\d{1,2})(\\.(25[0-5]|2[0-4]\\d|[01]?\\d{1,2})){3})?)|((:[0-9A-Fa-f]{1,4}){1,2})))|(([0-9A-Fa-f]{1,4}:)(:[0-9A-Fa-f]{1,4}){0,4}((:((25[0-5]|2[0-4]\\d|[01]?\\d{1,2})(\\.(25[0-5]|2[0-4]\\d|[01]?\\d{1,2})){3})?)|((:[0-9A-Fa-f]{1,4}){1,2})))|(:(:[0-9A-Fa-f]{1,4}){0,5}((:((25[0-5]|2[0-4]\\d|[01]?\\d{1,2})(\\.(25[0-5]|2[0-4]\\d|[01]?\\d{1,2})){3})?)|((:[0-9A-Fa-f]{1,4}){1,2})))|(((25[0-5]|2[0-4]\\d|[01]?\\d{1,2})(\\.(25[0-5]|2[0-4]\\d|[01]?\\d{1,2})){3})))(%.+)?\\s*$";
		Pattern p4 = Pattern.compile(ipv4);
	    Matcher m4 = p4.matcher(ip);
		if(m4.matches()){
			return true;
		}
		Pattern p6 = Pattern.compile(ipv6);
	    Matcher m6 = p6.matcher(ip);
		if(m6.matches()){
			return true;
		}
		return false;*/
	}
	
	
}
