package com.tmt.doc.management.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Repository;

import com.tmt.doc.management.dao.beans.DocumentRedisBean;

@Repository
public class RedisRepository implements IRedisRepository {

	public static final String REDIS_LIST_KEY = "DocumentList";
	public static final String REDIS_SET_KEY = "DocumentSET";
	public static final String REDIS_HASH_KEY = "DocumentHash";

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Autowired
	@Qualifier("listOperations")
	private ListOperations<String, DocumentRedisBean> ListOps;

	@Autowired
	@Qualifier("setOperations")
	private SetOperations<String, DocumentRedisBean> setOps;

	@Autowired
	HashOperations<String, Integer, DocumentRedisBean> hashOps;

	@Override
	public void setDocumentAsString(String idKey, String document) {
		redisTemplate.opsForValue().set(idKey, document);
		redisTemplate.expire(idKey, 10, TimeUnit.SECONDS);

	}

	@Override
	public String getDocumentAsString(String idKey) {
		return (String) redisTemplate.opsForValue().get(idKey);
	}

	////********** List *************
	@Override
	public void addToDocumentsList(DocumentRedisBean DocumentRedisBean) {
		ListOps.leftPush(REDIS_LIST_KEY, DocumentRedisBean);
	}

	@Override
	public List<DocumentRedisBean> getDocumentsListMembers() {
		return ListOps.range(REDIS_LIST_KEY, 0, -1);
	}

	@Override
	public Long getDocumentsListCount() {
		return ListOps.size(REDIS_LIST_KEY);
	}

	// ********** Set *************

	@Override
	public void addToDocumentsSet(DocumentRedisBean... Documents) {
		setOps.add(REDIS_SET_KEY, Documents);

	}

	@Override
	public Set<DocumentRedisBean> getDocumentsSetMembers() {
		return setOps.members(REDIS_SET_KEY);
	}

	@Override
	public boolean isSetMember(DocumentRedisBean DocumentRedisBean) {
		return setOps.isMember(REDIS_SET_KEY, DocumentRedisBean);
	}

	// ********** Hash *************

	@Override
	public void saveHash(DocumentRedisBean DocumentRedisBean) {
		hashOps.put(REDIS_HASH_KEY, DocumentRedisBean.getId(), DocumentRedisBean);

	}

	@Override
	public void updateHash(DocumentRedisBean DocumentRedisBean) {
		hashOps.put(REDIS_HASH_KEY, DocumentRedisBean.getId(), DocumentRedisBean);
	}

	@Override
	public Map<Integer, DocumentRedisBean> findAllHash() {
		return hashOps.entries(REDIS_HASH_KEY);
	}

	@Override
	public DocumentRedisBean findInHash(int id) {
		return hashOps.get(REDIS_HASH_KEY, id);
	}

	@Override
	public void deleteHash(int id) {
		hashOps.delete(REDIS_HASH_KEY, id);
	}

}
