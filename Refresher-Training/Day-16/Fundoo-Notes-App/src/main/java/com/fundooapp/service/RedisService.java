package com.fundooapp.service;

import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RedisService {

	private final StringRedisTemplate redisTemplate;

	public void save(String key, String value) {

		redisTemplate.opsForValue().set(key, value);
	}

	public void saveWithExpiration(String key, String value, long expiration) {

		redisTemplate.opsForValue().set(key, value, expiration, TimeUnit.MILLISECONDS);
	}

	public String get(String key) {

		return redisTemplate.opsForValue().get(key);
	}

	public void delete(String key) {

		redisTemplate.delete(key);
	}
}