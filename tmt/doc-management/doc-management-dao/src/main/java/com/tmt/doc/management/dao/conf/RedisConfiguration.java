package com.tmt.doc.management.dao.conf;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.StringUtils;

import com.tmt.doc.management.dao.beans.DocumentRedisBean;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
@ConfigurationProperties("jedis")
public class RedisConfiguration {

	@Value("${jedis.host}")
	private String host;

	@Value("${jedis.port}")
	private String port;

	@Value("${jedis.password}")
	private String password;

	@Value("${jedis.pool.max-total}")
	private int poolMax;

	@Value("${jedis.pool.max-idle}")
	private int poolMaxIdle;

	@Value("${jedis.pool.min-idle}")
	private int poolMinIdle;

	@Bean
	public JedisClientConfiguration getJedisClientConfiguration() {
		JedisClientConfiguration.JedisPoolingClientConfigurationBuilder JedisPoolingClientConfigurationBuilder = (JedisClientConfiguration.JedisPoolingClientConfigurationBuilder) JedisClientConfiguration
				.builder();
		GenericObjectPoolConfig GenericObjectPoolConfig = new GenericObjectPoolConfig();
		GenericObjectPoolConfig.setMaxTotal(poolMax);
		GenericObjectPoolConfig.setMaxIdle(poolMaxIdle);
		GenericObjectPoolConfig.setMinIdle(poolMinIdle);
		return JedisPoolingClientConfigurationBuilder.poolConfig(GenericObjectPoolConfig).build();
	}

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		// Pool details
		GenericObjectPoolConfig jdsPool = new JedisPoolConfig();
		jdsPool.setMaxTotal(poolMax);
		jdsPool.setMaxIdle(poolMaxIdle);
		jdsPool.setMinIdle(poolMinIdle);

		// client configuration
		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
		redisStandaloneConfiguration.setHostName(host);
		if (!StringUtils.isEmpty(password)) {
			redisStandaloneConfiguration.setPassword(RedisPassword.of(password));
		}
		return new JedisConnectionFactory(redisStandaloneConfiguration, getJedisClientConfiguration());
	}

	@Bean
	public RedisTemplate redisTemplate() {
		System.out.println("********************  Redis Template invoked*******************" + poolMinIdle);
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		redisTemplate.setKeySerializer(new StringRedisSerializer());
//   	 redisTemplate.setKeySerializer(new StringRedisSerializer());
//   	 redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
//        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
//        redisTemplate.setHashValueSerializer(new StringRedisSerializer()));
		return redisTemplate;
	}


	@Bean
	@Qualifier("listOperations")
	public ListOperations<String, DocumentRedisBean> listOperations(RedisTemplate<String, DocumentRedisBean> redisTemplate) {
		return redisTemplate.opsForList();
	}

	@Bean
	@Qualifier("setOperations")
	public SetOperations<String, DocumentRedisBean> SetOperations(RedisTemplate<String, DocumentRedisBean> redisTemplate) {
		return redisTemplate.opsForSet();
	}
	
    @Bean
    public HashOperations<String, Integer, DocumentRedisBean> hashOps(RedisTemplate<String, Object>  redisTemplate) {
        return redisTemplate.opsForHash();
    }
    

}
