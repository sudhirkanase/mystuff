package com.tmt.doc.management.services.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmt.doc.management.dao.beans.DocumentRedisBean;
import com.tmt.doc.management.dao.redis.IRedisRepository;

@Service
public class RedisService implements IRedisService {

	@Autowired
	IRedisRepository repository;

	@Override
	public void setDcoumentAsString(String idKey, String document) {
		repository.setDocumentAsString(idKey, document);

	}

	@Override
	public String getDocumentrAsString(String key) {
		return repository.getDocumentAsString(key);
	}

	// List
	@Override
	public void addToDocumentsList(DocumentRedisBean doc) {
		repository.addToDocumentsList(doc);

	}

	@Override
	public List<DocumentRedisBean> getDocumentsListMembers() {
		return repository.getDocumentsListMembers();
	}

	@Override
	public Long getDocumentsListCount() {
		return repository.getDocumentsListCount();
	}

	@Override
	public void addToDocumentsSet(DocumentRedisBean... Documents) {
		repository.addToDocumentsSet(Documents);

	}

	@Override
	public Set<DocumentRedisBean> getDocumentsSetMembers() {
		return repository.getDocumentsSetMembers();
	}

	@Override
	public boolean isSetMember(DocumentRedisBean DocumentRedisBean) {
		return repository.isSetMember(DocumentRedisBean);
	}

	// Hash

	@Override
	public void savePHash(DocumentRedisBean DocumentRedisBean) {
		repository.saveHash(DocumentRedisBean);

	}

	@Override
	public void updatePHash(DocumentRedisBean DocumentRedisBean) {
		repository.updateHash(DocumentRedisBean);

	}

	@Override
	public Map<Integer, DocumentRedisBean> findAllPHash() {
		return repository.findAllHash();
	}

	@Override
	public DocumentRedisBean findPInHash(int id) {
		return repository.findInHash(id);
	}

	@Override
	public void deletePhash(int id) {
		repository.deleteHash(id);

	}

}
