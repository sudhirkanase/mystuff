package com.tmt.doc.management.services.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.tmt.doc.management.dao.beans.DocumentRedisBean;

public interface IRedisService {
	// String
	void setDcoumentAsString(String idKey, String document);

	String getDocumentrAsString(String key);

	// list
	void addToDocumentsList(DocumentRedisBean doc);

	List<DocumentRedisBean> getDocumentsListMembers();

	Long getDocumentsListCount();

	// Set
	void addToDocumentsSet(DocumentRedisBean... documents);

	Set<DocumentRedisBean> getDocumentsSetMembers();

	boolean isSetMember(DocumentRedisBean doc);

	// Hash
	void savePHash(DocumentRedisBean doc);

	void updatePHash(DocumentRedisBean doc);

	Map<Integer, DocumentRedisBean> findAllPHash();

	DocumentRedisBean findPInHash(int id);

	void deletePhash(int id);

}
