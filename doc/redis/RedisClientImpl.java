package com.netease.ad.b.nex.redis.impl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.netease.ad.b.nex.redis.RedisException;
import com.netease.ad.b.nex.redis.RedisClient;
import com.netease.ad.b.nex.util.JsonHelper;

import reactor.util.Assert;

/**
 * @author bjhexin3 2016年9月29日
 * @version 1.0
 *
 */
public class RedisClientImpl implements RedisClient {

	private final Logger logger = LoggerFactory.getLogger(RedisClientImpl.class);

	private RedisTemplate<String, Object> redisTemplate;

	public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.netease.ad.b.nex.redis.StringRedisClient#set(java.lang.String,
	 * java.lang.Object)
	 */
	@Override
	public void set(final String key, final Object value) {
		Assert.notNull(key, "key must not be null");
		Assert.notNull(value, "value must not be null");
		redisTemplate.execute(new RedisCallback<Boolean>() {

			@Override
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				String valueStr = null;
				if (value instanceof String) {
					valueStr = value.toString();
				} else {
					try {
						valueStr = JsonHelper.toJson(value);
					} catch (JsonProcessingException e) {
						logger.error("{}转为JSON时出错", value);
						throw new RedisException("转为JSON时出错");
					}
				}
				connection.set(key.getBytes(), valueStr.getBytes());
				return true;
			}
		});

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.netease.ad.b.nex.redis.StringRedisClient#get(java.lang.String,
	 * java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> T get(final String key, Class<T> clazz) {
		Assert.notNull(key, "key must not be null");
		Assert.notNull(clazz, "clazz must not be null");
		String valueStr = redisTemplate.execute(new RedisCallback<String>() {

			@Override
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				byte[] bs = connection.get(key.getBytes());
				return new String(bs);
			}
		});
		if (clazz.equals(String.class)) {
			return (T) valueStr;
		}
		try {
			return JsonHelper.toObject(valueStr, clazz);
		} catch (IOException e) {
			logger.error("json转对象时出错:{}", valueStr);
			throw new RedisException("JSON转对象时出错");
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.netease.ad.b.nex.redis.StringRedisClient#hset(java.lang.String,
	 * java.lang.String, java.lang.Object)
	 */
	@Override
	public void hSet(final String key, final String field, final Object value) {
		Assert.notNull(key, "key must not be null");
		Assert.notNull(field, "field must not be null");
		Assert.notNull(value, "value must not be null");
		redisTemplate.execute(new RedisCallback<Boolean>() {

			@Override
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				String valueStr = null;
				if (value instanceof String) {
					valueStr = value.toString();
				} else {
					try {
						valueStr = JsonHelper.toJson(value);
					} catch (JsonProcessingException e) {
						logger.error("json转对象时出错:{}", valueStr);
						throw new RedisException("JSON转对象时出错");
					}
				}
				connection.hSet(key.getBytes(), field.getBytes(), valueStr.getBytes());
				return true;
			}
		});
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.netease.ad.b.nex.redis.StringRedisClient#hget(java.lang.String,
	 * java.lang.String, java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> T hGet(final String key, final String field, final Class<T> clazz) {
		Assert.notNull(key, "key must not be null");
		Assert.notNull(clazz, "clazz must not be null");
		String valueStr = redisTemplate.execute(new RedisCallback<String>() {

			@Override
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				byte[] bs = connection.hGet(key.getBytes(), field.getBytes());
				return new String(bs);
			}
		});
		if (clazz.equals(String.class)) {
			return (T) valueStr;
		}
		try {
			return JsonHelper.toObject(valueStr, clazz);
		} catch (IOException e) {
			logger.error("json转对象时出错:{}", valueStr);
			throw new RedisException("JSON转对象时出错");
		}
	}

}
